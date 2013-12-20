package hoffmanEncoding;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Tree {

	public TreeNode root;
	private PriorityQueue<TreeNode> frequency;
	
	public Tree(HashMap<String, Integer> map)
	{
		makeQueue(map);
		makeTree();
	}

	//pass in the map from the FrequencyTable class
	private void makeQueue(HashMap<String, Integer> map) {

		frequency = new PriorityQueue<TreeNode>(map.size());

		for (Entry<String, Integer> entry : map.entrySet()) {
			frequency.add(new TreeNode(entry.getKey(), entry
					.getValue()));
		}

	}

	private void makeTree() {

		while (frequency.size() >= 2) {

			TreeNode left = frequency.poll();
			TreeNode right = frequency.poll();
			TreeNode newNode = new TreeNode(null,
					left.frequency + right.frequency);

			newNode.left = left;
			newNode.right = right;
			frequency.offer(newNode);
		}

		root = frequency.poll();
	}

}
