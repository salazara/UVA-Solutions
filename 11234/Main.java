import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// salazara
// PROBLEM 11234

class Node{
	
	char c;
	Node left = null;
	Node right = null;
	
	Node(char c){
		this.c = c;
	}
	
	Node(char c, Node left, Node right){
		this.c = c;
		this.left = left;
		this.right = right;
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0 ; t < T ; t++){
			
			String s = sc.next();
			
			Deque<Character> st = new ArrayDeque<Character>();
			
			for(char c : s.toCharArray())
				st.push(c);
			
			Node tree = buildTree(st);
			System.out.println(result(tree));
			
		}

	}

	static Node buildTree(Deque<Character> st){
		char c = st.pop();
		
		Node left;
		Node right;
		
		if('A' <= c && c <= 'Z'){
			 left = buildTree(st);
			 right = buildTree(st);
		}
		else
			return new Node(c);
		
		return new Node(c, left, right);
	}
	
	static String result(Node tree){
		
		Deque<Character> vis = new ArrayDeque<Character>();
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(tree);
		
		while(!q.isEmpty()){
			
			Node curr = q.poll();
			vis.push(curr.c);
			
			if(curr.right != null)
				q.add(curr.right);
			
			if(curr.left != null)
				q.add(curr.left);
			
		}
		
		String r = "";
		
		while(!vis.isEmpty())
			r += vis.poll();
		
		return r;
		
	}
	
	
}
