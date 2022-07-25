import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Level: Medium
 * refer to: https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/
 *
 * Time complexity: O(m*n)
 * Space complexity: O(n)
 *
 */

public class CommonElementsPresentInAllRowsOfMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(7);

        arr2.add(0);
        arr2.add(0);
        arr2.add(3);
        arr2.add(5);

        arr3.add(1);
        arr3.add(3);
        arr3.add(9);
        arr3.add(8);
        matrix.add(arr1);
        matrix.add(arr2);
        matrix.add(arr3);
        System.out.println(findCommonElements(matrix));
    }

    public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat) {
        Map<Integer, Integer> map = new HashMap();
        int key, val;
        for (int i = 0; i < mat.size(); i++) {
            for (int col = 0; col < mat.get(i).size(); col++) {
                key = mat.get(i).get(col);
                if (i == 0) {
                    map.put(key, 1);
                } else {
                    if (map.containsKey(key)) {
                        val = map.get(key);
                        if (val == i)
                            map.put(key, val + 1);
                    }
                }
            }
        }

//         System.out.println(map);
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == mat.size())
                ans.add(i);
//             System.out.println(i);
        }

        return ans;
    }
}
