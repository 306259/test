package project2_1;

import java.util.Scanner;

public class TreeEvaluator 
{
private TreeNode root;
	
	public TreeEvaluator(String s)
	{
		Scanner parser = new Scanner(s);
		while(parser.hasNext())
		{
			addOne(parser.next());
		}
		parser.close();
	}
	
	public double evaluateTree()
	{
		return evaluateTree(root);
	}
	
	private double evaluateTree(TreeNode node)
	{
		if(node.isNumber())
			return Double.parseDouble(node.getValue());
		
		double operand1 = evaluateTree(node.getLeft());
		double operand2 = evaluateTree(node.getRight());
		
		if(node.getValue().length() > 1)
			throw new IllegalArgumentException("incorrect operator");
		
		switch(node.getValue().charAt(0))
		{
			case '^':
				return Math.pow(operand1, operand2);
			case '*':
				return operand1 * operand2;
			case '/':
				return operand1 / operand2;
			case '-':
				return operand1 - operand2;
			case '+':
				return operand1 + operand2;
			default:
					throw new IllegalArgumentException("Operator not Valid");
		}
		
	}
	
	private void addOne(String s)
	{		
		if(root == null)
		{
			root = new TreeNode(s);
			return;
		}
		
		TreeNode result = add(root, s);
		if(result == null)
			throw new IllegalArgumentException("tree full");
	
		
		root = result;
	
	}
	
	private TreeNode add(TreeNode node, String entry)
	{	
		
		if(node == null)
			return new TreeNode(entry);

		
		if(node.isNumber())
		{ return null; }

		TreeNode left = add(node.getLeft(), entry);
		if(left != null)
		{
			node.setLeft(left);
			return node;
		}

		TreeNode right = add(node.getRight(), entry);
		if(right != null)
		{
			node.setRight(right);
			return node;
		}
		return null;
	}
}
