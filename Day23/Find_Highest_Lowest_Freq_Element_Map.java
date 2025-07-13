import java.util.HashMap;
import java.util.Map;

public class Find_Highest_Lowest_Freq_Element_Map {
    public static void main(String[] args) {
        int arr[] = {10, 5, 10, 15, 10, 5};
        int n = arr.length;
        findHighestLowestFrequency(arr, n);
    }

    public static void findHighestLowestFrequency(int arr[], int n) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
            } else {
                frequencyMap.put(arr[i], 1);
            }
        }
        // Find highest and lowest frequency elements
        int highestFreq = 0, lowestFreq = n;
        int highestFreqElement = 0, lowestFreqElement = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > highestFreq) {
                highestFreq = entry.getValue();
                highestFreqElement = entry.getKey();
            }
            if (entry.getValue() < lowestFreq) {
                lowestFreq = entry.getValue();
                lowestFreqElement = entry.getKey();
            }
        }

        System.out.println("Element with highest frequency: " + highestFreqElement + " (" + highestFreq + ")");
        System.out.println("Element with lowest frequency: " + lowestFreqElement + " (" + lowestFreq + ")");
        }
    }

