package hoffmanEncoding;

public class TreeNode implements Comparable<TreeNode>
{
	public final String letter;
	public final int frequency;
	
	public TreeNode left, right;
	
	public TreeNode(String letter, int frequency)
	{
		this.letter = letter;
		this.frequency = frequency;
	}
	

	public int compareTo(TreeNode other) {
		// TODO Auto-generated method stub
		return frequency - other.frequency;
	}
	
	
}
