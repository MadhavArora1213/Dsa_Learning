import speech_recognition as sr
import pyttsx3
import requests
import json
import re
from datetime import datetime
import threading
import time

class NotionVoiceAssistant:
    def __init__(self, notion_token, database_id):
        self.notion_token = notion_token
        self.database_id = database_id
        self.headers = {
            "Authorization": f"Bearer {notion_token}",
            "Content-Type": "application/json",
            "Notion-Version": "2022-06-28"
        }
        
        # Initialize speech components
        self.recognizer = sr.Recognizer()
        self.tts = pyttsx3.init()
        self.microphone = sr.Microphone()
        self.is_running = True
        
        # Configure TTS
        voices = self.tts.getProperty('voices')
        if voices:
            self.tts.setProperty('voice', voices[0].id)
        self.tts.setProperty('rate', 150)
        self.tts.setProperty('volume', 0.8)
        
        # Adjust for ambient noise
        print("🎙️ Calibrating microphone for ambient noise...")
        with self.microphone as source:
            self.recognizer.adjust_for_ambient_noise(source, duration=2)
        print("✅ Microphone calibrated!")
    
    def speak(self, text):
        """Convert text to speech"""
        print(f"🔊 Assistant: {text}")
        self.tts.say(text)
        self.tts.runAndWait()
    
    def listen(self, timeout=10):
        """Listen for voice commands"""
        try:
            with self.microphone as source:
                print("🎤 Listening...")
                audio = self.recognizer.listen(source, timeout=timeout, phrase_time_limit=8)
            
            print("🔄 Processing speech...")
            command = self.recognizer.recognize_google(audio).lower()
            print(f"📝 You said: '{command}'")
            return command
        
        except sr.WaitTimeoutError:
            print("⏰ Listening timeout - no speech detected")
            return None
        except sr.UnknownValueError:
            print("❓ Could not understand audio")
            self.speak("I couldn't understand that. Please try again.")
            return None
        except sr.RequestError as e:
            print(f"❌ Speech recognition error: {e}")
            self.speak("There was an error with speech recognition.")
            return None
    
    def test_connection(self):
        """Test Notion API connection"""
        try:
            response = requests.get(
                f"https://api.notion.com/v1/databases/{self.database_id}",
                headers=self.headers
            )
            
            if response.status_code == 200:
                db_info = response.json()
                db_title = "Tasks Tracker"  # Default name based on your screenshot
                if db_info.get('title') and len(db_info['title']) > 0:
                    db_title = db_info['title'][0]['text']['content']
                print(f"✅ Connected to database: {db_title}")
                self.speak(f"Successfully connected to your {db_title} database!")
                return True
            else:
                print(f"❌ Connection failed: {response.status_code}")
                print(f"Error: {response.text}")
                return False
        except Exception as e:
            print(f"❌ Connection error: {e}")
            return False
    
    def create_page(self, title, content="", priority="Medium", status="Not started"):
        """Create a new page in Notion database"""
        try:
            # Based on your database structure from the screenshot
            data = {
                "parent": {"database_id": self.database_id},
                "properties": {
                    "Name": {
                        "title": [
                            {
                                "text": {
                                    "content": title
                                }
                            }
                        ]
                    },
                    "Status": {
                        "select": {
                            "name": status
                        }
                    },
                    "Priority": {
                        "select": {
                            "name": priority
                        }
                    },
                    "Assignee": {
                        "people": [
                            {
                                "object": "user",
                                "id": "user_id_placeholder"  # This will be auto-filled
                            }
                        ]
                    },
                    "Due": {
                        "date": {
                            "start": datetime.now().strftime("%Y-%m-%d")
                        }
                    }
                }
            }
            
            # Try with full structure first
            response = requests.post(
                "https://api.notion.com/v1/pages",
                headers=self.headers,
                json=data
            )
            
            if response.status_code == 200:
                return response.json()
            else:
                # If complex structure fails, try simple structure
                simple_data = {
                    "parent": {"database_id": self.database_id},
                    "properties": {
                        "Name": {
                            "title": [
                                {
                                    "text": {
                                        "content": title
                                    }
                                }
                            ]
                        }
                    }
                }
                
                response = requests.post(
                    "https://api.notion.com/v1/pages",
                    headers=self.headers,
                    json=simple_data
                )
                return response.json() if response.status_code == 200 else None
                
        except Exception as e:
            print(f"Error creating page: {e}")
            return None
    
    def search_pages(self, query=""):
        """Search for pages in Notion"""
        try:
            data = {
                "filter": {
                    "value": "page",
                    "property": "object"
                }
            }
            
            if query:
                data["query"] = query
            
            response = requests.post(
                "https://api.notion.com/v1/search",
                headers=self.headers,
                json=data
            )
            
            return response.json() if response.status_code == 200 else {"results": []}
        except Exception as e:
            print(f"Error searching pages: {e}")
            return {"results": []}
    
    def update_page(self, page_id, new_title=None, status=None, priority=None):
        """Update a page"""
        try:
            data = {"properties": {}}
            
            if new_title:
                data["properties"]["Name"] = {
                    "title": [
                        {
                            "text": {
                                "content": new_title
                            }
                        }
                    ]
                }
            
            if status:
                data["properties"]["Status"] = {
                    "select": {
                        "name": status
                    }
                }
            
            if priority:
                data["properties"]["Priority"] = {
                    "select": {
                        "name": priority
                    }
                }
            
            response = requests.patch(
                f"https://api.notion.com/v1/pages/{page_id}",
                headers=self.headers,
                json=data
            )
            
            return response.json() if response.status_code == 200 else None
        except Exception as e:
            print(f"Error updating page: {e}")
            return None
    
    def delete_page(self, page_id):
        """Archive/delete a page"""
        try:
            data = {"archived": True}
            
            response = requests.patch(
                f"https://api.notion.com/v1/pages/{page_id}",
                headers=self.headers,
                json=data
            )
            
            return response.json() if response.status_code == 200 else None
        except Exception as e:
            print(f"Error deleting page: {e}")
            return None
    
    def get_page_title(self, page):
        """Extract title from page object"""
        try:
            if page.get('properties', {}).get('Name', {}).get('title'):
                return page['properties']['Name']['title'][0]['text']['content']
            elif page.get('properties', {}).get('Title', {}).get('title'):
                return page['properties']['Title']['title'][0]['text']['content']
            else:
                return "Untitled"
        except:
            return "Untitled"
    
    def process_voice_command(self, command):
        """Process voice commands and execute actions"""
        if not command:
            return True
        
        command = command.strip().lower()
        
        # Exit commands
        if any(word in command for word in ["stop", "quit", "exit", "goodbye", "bye"]):
            self.speak("Thanks for using Notion Voice Assistant. Goodbye!")
            return False
        
        # Help command
        elif "help" in command:
            help_text = """Here are the available commands:
            Create page called [title] - Creates a new page
            Search for [query] - Searches for pages
            List my pages - Shows recent pages  
            Update page [title] to [new title] - Updates page title
            Delete page [title] - Deletes a page
            Mark [title] as done - Marks page as completed
            Set [title] priority to high - Changes priority
            Stop or quit - Exit the assistant"""
            self.speak(help_text)
        
        # Create commands
        elif "create" in command or "add" in command or "new" in command:
            patterns = [
                r'(?:create|add|new)(?:\s+(?:page|task|note))?\s+(?:called|named|titled)?\s*(.+)',
                r'(?:create|add|new)\s+(.+)',
            ]
            
            title = None
            for pattern in patterns:
                match = re.search(pattern, command)
                if match:
                    title = match.group(1).strip()
                    break
            
            if title:
                # Extract priority if mentioned
                priority = "Medium"
                if "high priority" in command or "urgent" in command:
                    priority = "High"
                elif "low priority" in command:
                    priority = "Low"
                
                result = self.create_page(title, priority=priority)
                if result and result.get('id'):
                    self.speak(f"Successfully created page: {title}")
                else:
                    self.speak("Sorry, I couldn't create the page. Please check your connection.")
            else:
                self.speak("What should I name the page?")
                title_command = self.listen(timeout=8)
                if title_command:
                    result = self.create_page(title_command)
                    if result and result.get('id'):
                        self.speak(f"Successfully created page: {title_command}")
                    else:
                        self.speak("Sorry, I couldn't create the page.")
        
        # Search commands
        elif "search" in command or "find" in command:
            patterns = [
                r'(?:search|find)(?:\s+for)?\s+(.+)',
                r'(?:search|find)\s+(.+)'
            ]
            
            query = None
            for pattern in patterns:
                match = re.search(pattern, command)
                if match:
                    query = match.group(1).strip()
                    break
            
            if query:
                results = self.search_pages(query)
                pages = results.get('results', [])
                if pages:
                    page_names = [self.get_page_title(page) for page in pages[:5]]
                    page_names = [name for name in page_names if name != "Untitled"]
                    if page_names:
                        self.speak(f"Found {len(pages)} pages. Here are the top results: {', '.join(page_names[:3])}")
                    else:
                        self.speak("Found some pages but couldn't read their titles.")
                else:
                    self.speak(f"No pages found for '{query}'")
            else:
                self.speak("What would you like to search for?")
        
        # List commands
        elif "list" in command or "show" in command:
            results = self.search_pages("")
            pages = results.get('results', [])[:8]
            if pages:
                page_names = [self.get_page_title(page) for page in pages]
                page_names = [name for name in page_names if name != "Untitled"]
                if page_names:
                    self.speak(f"Here are your recent pages: {', '.join(page_names[:5])}")
                else:
                    self.speak("I found some pages but couldn't read their titles.")
            else:
                self.speak("No pages found in your database.")
        
        # Update commands
        elif "update" in command or "rename" in command:
            match = re.search(r'(?:update|rename)(?:\s+page)?\s+(.+?)\s+to\s+(.+)', command)
            if match:
                old_title = match.group(1).strip()
                new_title = match.group(2).strip()
                
                results = self.search_pages(old_title)
                pages = results.get('results', [])
                
                if pages:
                    page = pages[0]
                    result = self.update_page(page['id'], new_title=new_title)
                    if result:
                        self.speak(f"Updated page from '{old_title}' to '{new_title}'")
                    else:
                        self.speak("Sorry, I couldn't update the page.")
                else:
                    self.speak(f"Couldn't find a page with title '{old_title}'")
            else:
                self.speak("Please say: update page [old name] to [new name]")
        
        # Mark as done commands
        elif "mark" in command and ("done" in command or "complete" in command):
            match = re.search(r'mark\s+(.+?)\s+as\s+(?:done|complete)', command)
            if match:
                title = match.group(1).strip()
                results = self.search_pages(title)
                pages = results.get('results', [])
                
                if pages:
                    page = pages[0]
                    result = self.update_page(page['id'], status="Done")
                    if result:
                        self.speak(f"Marked '{title}' as done")
                    else:
                        self.speak("Sorry, I couldn't update the status.")
                else:
                    self.speak(f"Couldn't find a page with title '{title}'")
        
        # Delete commands  
        elif "delete" in command or "remove" in command:
            match = re.search(r'(?:delete|remove)(?:\s+page)?\s+(.+)', command)
            if match:
                title = match.group(1).strip()
                results = self.search_pages(title)
                pages = results.get('results', [])
                
                if pages:
                    page = pages[0]
                    result = self.delete_page(page['id'])
                    if result:
                        self.speak(f"Deleted page '{title}'")
                    else:
                        self.speak("Sorry, I couldn't delete the page.")
                else:
                    self.speak(f"Couldn't find a page with title '{title}'")
        
        # Priority commands
        elif "priority" in command:
            match = re.search(r'set\s+(.+?)\s+priority\s+to\s+(high|medium|low)', command)
            if match:
                title = match.group(1).strip()
                priority = match.group(2).strip().capitalize()
                
                results = self.search_pages(title)
                pages = results.get('results', [])
                
                if pages:
                    page = pages[0]
                    result = self.update_page(page['id'], priority=priority)
                    if result:
                        self.speak(f"Set '{title}' priority to {priority.lower()}")
                    else:
                        self.speak("Sorry, I couldn't update the priority.")
                else:
                    self.speak(f"Couldn't find a page with title '{title}'")
        
        else:
            suggestions = [
                "Try saying 'create page called Meeting Notes'",
                "Or 'search for project'", 
                "Or 'list my pages'",
                "Say 'help' for all commands"
            ]
            self.speak(f"I didn't understand that command. {suggestions[0]}")
        
        return True
    
    def run(self):
        """Main loop for voice assistant"""
        print("=" * 60)
        print("🎤 NOTION VOICE ASSISTANT FOR MADHAV ARORA")
        print("=" * 60)
        
        # Test connection first
        if not self.test_connection():
            self.speak("Unable to connect to Notion. Please check your credentials.")
            return
        
        self.speak("Hi Madhav! Your Notion Voice Assistant is ready! Say 'help' to hear available commands, or just start giving commands.")
        
        consecutive_errors = 0
        max_errors = 3
        
        while self.is_running:
            try:
                command = self.listen()
                
                if command:
                    consecutive_errors = 0
                    if not self.process_voice_command(command):
                        break
                else:
                    consecutive_errors += 1
                    if consecutive_errors >= max_errors:
                        self.speak("I'm having trouble hearing you. Restarting listening...")
                        consecutive_errors = 0
                        time.sleep(1)
                
                time.sleep(0.5)
                
            except KeyboardInterrupt:
                print("\n👋 Interrupted by user")
                self.speak("Goodbye Madhav!")
                break
            except Exception as e:
                print(f"❌ Unexpected error: {e}")
                consecutive_errors += 1
                if consecutive_errors >= max_errors:
                    self.speak("I'm experiencing technical difficulties. Please restart me.")
                    break

def main():
    print("🚀 Starting Notion Voice Assistant for Madhav Arora...")
    
    # Your actual credentials
    NOTION_TOKEN = "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"
    DATABASE_ID = "218c4d5ac5798044a9c9d1f431b36e7d"
    
    try:
        assistant = NotionVoiceAssistant(NOTION_TOKEN, DATABASE_ID)
        assistant.run()
    except Exception as e:
        print(f"❌ Failed to start assistant: {e}")
        print("\n🔧 Troubleshooting:")
        print("- Check your internet connection")
        print("- Verify your microphone is working")
        print("- Make sure you have the required packages installed")
        input("\nPress Enter to exit...")

if __name__ == "__main__":
    main()