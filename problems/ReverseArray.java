import java.util.Arrays;

class ReverseArray {
    static void reverse(int[] arr) {
        int low = 0;
        int high =  arr.length - 1;
        while(low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] arg) {
        int[] arr = {10, 20, 30, 40, 50};
        reverse(arr);
    }
}