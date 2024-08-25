import java.util.Arrays;

class ReverseInGroupofK {
    static void reverseinGroup(int[] arr, int k) {
        for(int i=0; i<arr.length;i=i+k) {
            int low = i;
            int high = low + k - 1;
            if(high > arr.length - 1) {
                high = arr.length - 1;
            };
            while(low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};
        reverseinGroup(arr, 3);
    }
}