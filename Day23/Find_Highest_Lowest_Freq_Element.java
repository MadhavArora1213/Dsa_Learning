public class Find_Highest_Lowest_Freq_Element {
    public static void main(String[] args) {
        int arr[] = {10, 5, 10, 15, 10, 5};
        int n = arr.length;
        findHighestLowestFrequency(arr, n);
    }
    public static void findHighestLowestFrequency(int arr[], int n) {
       boolean visited[] = new boolean[n];
       int highestFreq = 0, lowestFreq = n;
       int highestFreqElement = 0, lowestFreqElement = 0;

       for (int i = 0; i < n; i++) {
           if (visited[i]) continue;

           int count = 1;
           for (int j = i + 1; j < n; j++) {
               if (arr[i] == arr[j]) {
                   visited[j] = true;
                   count++;
               }
           }

           // Update highest frequency
           if (count > highestFreq) {
               highestFreq = count;
               highestFreqElement = arr[i];
           }

           // Update lowest frequency
           if (count < lowestFreq) {
               lowestFreq = count;
               lowestFreqElement = arr[i];
           }
       }
       System.out.println("Element with highest frequency: " + highestFreqElement + " (" + highestFreq + ")");
       System.out.println("Element with lowest frequency: " + lowestFreqElement + " (" + lowestFreq + ")");
    }
}
