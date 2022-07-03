package HomeWork;

import java.util.Arrays;

public class EvaVeliSolution4 {
	    public static void main(String[] args) {
	        var BStree = new TreeNode(6,new TreeNode(2,new TreeNode(1),new TreeNode(4,new TreeNode(3),
	                    new TreeNode(5))),
	            new TreeNode(8,new TreeNode(7),new TreeNode(9))
	        );

	        System.out.println("Sum of right leaves is : " + sumOfRightLeaves(BStree));
	        refactorBST(BStree);
	        System.out.println("Refactoring BST -> "+ Arrays.toString(Sorted(BStree)));
	        System.out.println("Average depth is : " + averageDepth(BStree));
	    }

	    private static int sumOfRightLeaves(TreeNode root) {
	        if (root == null || root.right == null) //it means that the tree does not excist or there are no right children
	            return 0;
	        else if (root.right.right == null) //if its only one child in the right
	            return root.right.value + sumOfRightLeaves(root.left); //find the sum which is right value + value in the left
	        else
	            return sumOfRightLeaves(root.left) + sumOfRightLeaves(root.right); //sum of all nodes in the right subtree
	        
	    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	    private static int asign(TreeNode node, int[] arr, int curr) {
	        if (node == null)
	            return curr;
	        curr= asign(node.left, arr, curr);
	        node.value = arr[curr++];
	        return asign(node.right, arr, curr);
	    }
	    
	    private static int fill(TreeNode root, int[] arr, int next) {
	        if (root == null)
	            return next;

	        next = fill(root.left, arr, next);
	        arr[next++] = root.value;
	        return fill(root.right, arr, next);
	    }

	    private static int[] Sorted(TreeNode root) {
	        int[] sort = new int[count(root)];
	        fill(root, sort, 0);
	        return sort;
	    }
	    
	    private static int average(int[] arr, int start) {
	        if (start + 1 == arr.length)
	            return 0;

	        int sum = 0;
	        for (int i = start + 1; i < arr.length; ++i)
	            sum += arr[i];
	        return sum / (arr.length - start - 1);
	    }

	    
	    private static void refactorBST(TreeNode root) {
	        int[] arrsort = Sorted(root);
	        int[] refactor = new int[arrsort.length];
	        for (int i = 0; i < arrsort.length; ++i)
	            refactor[i] = arrsort[i] + average(arrsort, i);
	        Arrays.sort(refactor);
	        asign(root, refactor, 0);
	    }

///////////////////////////////////////////////////////////////////////////////////////////////
	    private static float averageDepth(TreeNode root) {
	        return depth(root, 0) * 1.0f / count(root); //findin the avg by dividing the depth with number of nodes
	    }

	    private static int depth(TreeNode node, int level) {
	        if (node == null)
	            return 0;
	        else
	            return level + depth(node.left, level + 1) + depth(node.right, level + 1); //finding the sum of the depths
	    }

	    private static int count(TreeNode root) {
	        if (root == null) //no tree
	            return 0;
	        else
	            return 1 + count(root.left) + count(root.right); //count the number of nodes in the tree
	    }
//////////////////////////////////////////////////////////////////////////////
	    private static class TreeNode {
	        int value;
	        TreeNode left;
	        TreeNode right;
	        public TreeNode(int value) {this.value = value;}
	        public TreeNode(int value, TreeNode left, TreeNode right) {
	            this.value = value;
	            this.left = left;
	            this.right = right;
	        }
	 
	}
}
