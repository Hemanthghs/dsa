# Arrays

# Sep 19, 2024

## Union of Two Sorted Arrays

[https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1](https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1)

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

## Missing Number - LC - 268
[https://leetcode.com/problems/missing-number/](https://leetcode.com/problems/missing-number/)

```java

// T.C: O(n)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n) {
            int correctIndex = nums[i];
            if(nums[i] < n && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else { 
                i++;
            }
        }

        for(int j = 0; j < n; j++) {
            if(nums[j] != j) {
                return j;
            }
        }
        return n;
    }
}
```

# Sep 21, 2024

## Maximum consecutive ones
[https://leetcode.com/submissions/detail/1397704535/](https://leetcode.com/submissions/detail/1397704535/)

```java
// T.C: O(N)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
```

```
class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int last = 0;
        for(int i = 0; i < N; i++) {
            sum += A[i];
            if(sum == K) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int rem = sum - K;
            if(sumMap.containsKey(rem)) {
                int len = i - sumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            } 
            if(!sumMap.containsKey(sum)){
                sumMap.put(sum, i);
            }
            
        }
        return maxLen;
    }
}


```
