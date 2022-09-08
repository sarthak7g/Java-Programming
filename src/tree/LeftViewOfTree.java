package tree;

import java.util.ArrayList;

public class LeftViewOfTree {
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {

    }


    ArrayList<Integer> leftView(Node head)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Node root = head;
        while(root!=null) {
            ans.add(root.data);

            if(root.left != null){
                root = root.left;
            }else root = root.right;
        }

        return ans;
    }
}
