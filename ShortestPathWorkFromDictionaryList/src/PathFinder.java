import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathFinder {

	private String[] dictionary;
	private int[] dfsPaths;
	
	public int findShortestPath(String beginWord, String endWord, String[] dictionary) {
		this.dictionary = dictionary;
		// BFS
		//int count = bfsPathSolver(beginWord,endWord);
		
		// DFS
		Stack<String> wordPaths = new Stack<>();
		this.dfsPaths = 
		int count = dfsSolver(new Node(beginWord,1),new Node(endWord,1),new HashSet<String>(),wordPaths);
		while(!wordPaths.isEmpty())
		{
			System.out.print(wordPaths.pop()+"->");
		}
		System.out.println();
		return count; 
	}
	
	private int bfsPathSolver(String beginWord, String endWord)
	{
		Queue<Node> wordQueue = new LinkedList<>();
		HashSet<String> visitedWords = new HashSet<>();
		Stack<String> wordPath = new Stack<>();
		
		Node root = new Node(beginWord,1);
		addNeighbors(root);
		visitedWords.add(beginWord);
		wordQueue.add(root);
		wordPath.add(beginWord); 
		
		while(!wordQueue.isEmpty())
		{
			Node n = wordQueue.poll();
			for (Node k : n.neighbors) 
			{
				if (isSimilar(k.word,endWord))
				{ 
					System.out.println(k.word+" is similar to "+endWord);
					for (int j = 0; j < wordPath.size(); j++)
					{ 
						System.out.print(wordPath.elementAt(j)+"->");
					}
					System.out.print(k.word+"->");
					System.out.println(endWord);
					return k.distance+1;
				}
				else if (!visitedWords.contains(k.word))
				{
		 			System.out.println("Adding "+k.word);
					addNeighbors(k); 
					visitedWords.add(k.word); 
					wordQueue.add(k);
					wordPath.add(k.word); 
				}
				else
				{
					wordPath.pop();
				}
			}
		} 
		
		return 0;
	}
	
	public int dfsSolver(Node beginWord, Node endWord,HashSet<String> visitedWords, Stack<String> wordPaths)
	{
		if (isSimilar(beginWord.word,endWord.word)) 
		{
			System.out.println(beginWord.distance+" "+beginWord.word);
			wordPaths.push(endWord.word);
			return beginWord.distance+1;
		}
		System.out.println(beginWord.word);
		addNeighbors(beginWord);
		visitedWords.add(beginWord.word);
		
		//wordPaths.push(beginWord.word);
		
		int count = this.dictionary.length+1; 
		for (Node n : beginWord.neighbors)
		{
			//int x = dfsSolver(n,endWord,visitedWords,wordPaths);
			//if (count > x) count = x;
		}
		System.out.println(count+" "+beginWord.word);
		return count; 
	}

	private void addNeighbors(Node root) {
		for (int i = 0; i < this.dictionary.length; i++)
		{
			if (isSimilar(root.word,this.dictionary[i])) 
			{
				root.neighbors.add(new Node(this.dictionary[i],root.distance+1)); 
			} 
		}
	}

	private boolean isSimilar(String word, String string) {
		// Assuming words are all same length
		int count = 0;
		//System.out.println("Comparing "+word+" to "+string);
		for (int i = 0; i < word.length(); i++)
		{
			if (word.charAt(i) == string.charAt(i)) count++;
		}

		return count == word.length()-1;
	}
	
}
	