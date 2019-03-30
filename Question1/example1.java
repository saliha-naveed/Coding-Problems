/*
Input:
beginWord = "hit";,
endWord = "cog";,
wordList = ["hot","dot","dog","lot","log","cog";]
Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 
public class Solution {
 
    class Node {
	 // variale declaration
        String str;
        int level;
        Node parent;
		
     // constructor
        public Node(String str, int level, Node parent) {
            this.str = str;
            this.level = level;
            this.parent = parent;
        }
    }
 
    public List<List<String>> printSolutions(String beginWord, String endWord, List<String> wordList) {
  
     // create list of list 
        List<List<String>> result = new ArrayList<List<String>>();
		
	 // If list is empty  return 
        if (wordList == null || wordList.size() == 0) {
		 System.out.println("Word List is Empty");
         return result;
        }
     // Queue defined
        Queue<Node> queue = new LinkedList<Node>();
	 
	 // Queue add() method
        queue.add(new Node(beginWord, 1, null));
		
        int min = wordList.size() + 1;
		
     //Using Hashtable for storage
        HashSet<String> visited = new HashSet<String>(); 
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(wordList);
 
        int preLevel = 0;
		
     
        while (!queue.isEmpty()) {
            Node node = queue.poll(); //fetching element present at the head of the Queue
 
            if (node.level > min) {
                continue;
            }
 
            if (endWord.equals(node.str)) {
                Node p = node;
                min = p.level;
                LinkedList<String> res = new LinkedList<String>();
                while (p != null) {
                    res.addFirst(p.str);
                    p = p.parent;
                }
                result.add(res);
                continue;
            }
 
            if (preLevel < node.level) {
                preLevel = node.level;
                unvisited.removeAll(visited);
            }
 
            char[] arr = node.str.toCharArray();
            for (int i = 0; i < arr.length; i++) { 
                char c = arr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    arr[i] = j;
                    String newStr = new String(arr);
                    if (!unvisited.contains(newStr)) {
                        continue;
                    }
                    visited.add(newStr);
                    Node newNode = new Node(newStr, node.level + 1, node);
                    queue.offer(newNode);
                }
                arr[i] = c;
            }
        }
        return result;
    }
	
	
	// main function
 
    public static void main(String[] args) {
        Solution sol = new Solution();
		// Input wordlist
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
		//begin and end words
        List<List<String>> result = sol.printSolutions("hit", "cog", wordList);
        for (int i = 0; i < result.size(); i++) {
		//print result
            System.out.println((result.get(i).toString()));
        }
    }
}