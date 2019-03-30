# Coding-Problems

# Question 1:
Design a micro service that accepts two words(beginWord and endWord), and a dictionary';s word list to find all shortest transformation sequence(s) from beginWord to endWord, such that:
- Only one letter can be changed at a time
- Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

## Example 1:
Input:
beginWord = "hit";,
endWord = "cog";,
wordList = ["hot","dot","dog","lot","log","cog";]
Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]

## Example 2:
Input:
beginWord = "hit";,
endWord = "cog";,
wordList = ["hot","dot","dog","lot","log","cog";]
Output:[]

Explanation: The endWord &quot;cog&quot; is not in wordList, therefore no possible transformation.

----------------------------------------------------------------------------------------------------------------------------------------

# Question 2:
Develop a micro service that take ’n’ points on a 2D plane as input, and finds the maximum number of points that lie on the same straight line.

# Example 1:
Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->;
0  1  2  3 4
