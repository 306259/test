package warmup;

public class Tree {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
	
	}
	
	public static int countNodes(TreeNode root)
	{
		if(root == null)
			return 0;
		
		return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
	}
	
	public static int countLeaves(TreeNode root)
	{
		if(root == null)
			return 0;
		
		if(root.getLeft() != null && root.getRight() != null)
			return countLeaves(root.getLeft()) + countLeaves(root.getRight());
		
		else
			return 1;
			
	}

}
