package hashtable.common_interview_question;

import java.util.HashMap;

// Find the common between 2 arrays if they have in common return true, else returns false
public class Solution {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 3};

        System.out.println(valueInCommon(arr1, arr2));
    }

    public static boolean valueInCommon(int[] arr1, int[] arr2){
        HashMap<Integer, Boolean> checker = new HashMap<>();

        for(int i : arr1){
            if(!checker.containsKey(i)){
                checker.put(i, true);
            }
        }

        for(int i : arr2){
            if(checker.get(i) != null) return true;
        }
        return false;
    }
}



