package hoffmanEncoding;

import java.io.File;

import java.util.HashMap;

import java.util.Set;

import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;

public class Scheme

{

	private Tree tree;

	private String s;

	HashMap<String, String> scheme = new HashMap<String, String>();

	public Scheme(Tree tree)

	{

		this.tree = tree;

	}


	public void buildScheme()

	{

		buildScheme(scheme, tree.root, s);

	}

	private void buildScheme(HashMap<String, String> st, TreeNode x,
			String s) {

		if (x.letter == null) {

			buildScheme(st, x.left, s + "0");

			buildScheme(st, x.right, s + "1");

		}

		if (x.letter != null) {

			st.put(x.letter, s);

		}

	}

	public void writeFile() throws IOException {


			File file = new File("C:\\Users\\Allan\\Documents\\huffmanTxt\\mySchemeFinal.txt");


				file.createNewFile();


			FileWriter fw = new FileWriter(file.getAbsoluteFile());

			BufferedWriter bw = new BufferedWriter(fw);

			Set<String> set = scheme.keySet();

			for (String l : set)

			{

				bw.write(l + scheme.get(l).substring(4));
				bw.newLine();

			}
			bw.close();
			System.out.println("done");
		

	}

}
