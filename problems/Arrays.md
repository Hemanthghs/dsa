### Union of Two Sorted Arrays

```java
// Brute force
// T.C: O((m+n)log(m+n))
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        
        for(int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.addAll(set);
        
        return result;
    }
}

// Optimal
// T.C: O(m+n)
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while(i < n && j < m) {
            if(arr1[i] <= arr2[j]) {
                if(result.size() == 0 || arr1[i] != result.get(result.size() - 1)) {
                    result.add(arr1[i]);
                }
                i++;
            } else {
                if(result.size() == 0 || arr2[j] != result.get(result.size() - 1)) {
                    result.add(arr2[j]);
                }
                j++;
            }
        }
        
        while(i < n) {
            if(result.size() == 0 || arr1[i] != result.get(result.size() - 1)) {
                result.add(arr1[i]);
            }
            i++;
        }
        
        while(j < m) {
            if(result.size() == 0 || arr2[j] != result.get(result.size() - 1)) {
                result.add(arr2[j]);
            }
            j++;
        }
        
        return result;
    }
}

            
```
