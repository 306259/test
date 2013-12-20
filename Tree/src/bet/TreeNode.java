package bet;

public class TreeNode 
{
		private final String value;
		private TreeNode left;
		private TreeNode right;
		private boolean number;
		
		public TreeNode(String initValue)
		{ 
			if(initValue == null)
				throw new IllegalArgumentException("value is null");
			
			value = initValue;
			left = null;
			right = null;
			try
			{
				Double.parseDouble(value);
				number = true;
			}
			catch(Exception e)
			{
				number = false;
			}
		}		
		
		public String getValue() 
		{ return value; }
		
		public TreeNode getLeft() 
		{ return left; }
		
		public TreeNode getRight() 
		{ return right; }
				
		public void setLeft(TreeNode theNewLeft) 
		{ left = theNewLeft; }
		
		public void setRight(TreeNode theNewRight) 
		{ right = theNewRight; }
		
		public boolean isNumber()
		{ return number; }
	
}