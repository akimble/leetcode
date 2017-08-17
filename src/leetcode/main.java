package leetcode;

import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) {
//		String moves = "LDRRLRUULR";
//		boolean answer = judgeCircle(moves);
//		System.out.println(answer);
		
//		int x = 1;
//		int y = 4;
//		int answer = hammingDistance(x, y);
//		System.out.println(answer);
		
//		TreeNode t1 = new TreeNode(1);
//		TreeNode t1Left = new TreeNode(3);
//		t1.left = t1Left;
//		t1.right = new TreeNode(2);
//		t1Left.left = new TreeNode(5);
//		TreeNode t2 = new TreeNode(2);
//		TreeNode t2Left = new TreeNode(1);
//		TreeNode t2Right = new TreeNode(3);
//		t2Left.right = new TreeNode(4);
//		t2Right.right = new TreeNode(7);
//		TreeNode answer = mergeTrees(t1, t2);
//		System.out.println(answer.val+", "+answer.left.val+", "+answer.right.val);
		
//		String s = "hello";
//		String answer = reverseString(s);
//		System.out.println(answer);
		
//		List<String> answer = fizzBuzz(15);
//		System.out.println(answer);
		
//		int[] nums = new int[] {1,2,2,4,1,4,5};
//		int answer = singleNumber(nums);
//		System.out.println(answer);
		
//		int answer = maxDepth(t1);
//		System.out.println(answer);
		
		int[] nums = new int[] {0, 1, 0, 3, 12};
		moveZeroes(nums);
		for (int i=0;i<nums.length;++i) {
			System.out.println(nums[i]);
		}
	}
	
	// Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
	// The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
	// The output should be true or false representing whether the robot makes a circle. 
	public static boolean judgeCircle(String moves) {
	  char[] charArray = moves.toCharArray();
	  int up = 0;
	  int left = 0;
	  
	  for (int i=0;i<moves.length();++i) {
		  switch(charArray[i]) {
		  	case 'U' :
	    		++up;
	    		break;
	    	case 'D' :
	    		--up;
	    		break;
	    	case 'L' :
	    		++left;
	    		break;
	    	case 'R' :
	    		--left;
	    		break;
	    }
	  }
	  
	  if (up == 0 && left == 0)
		  return true;
	  else
		  return false;
	}
	
	// The Hamming distance between two integers is the number of positions
	// at which the corresponding bits are different.Given two integers x and y, 
	// calculate the Hamming distance. Note:0 ≤ x, y < 231. 
	public static int hammingDistance(int x, int y) {
		int diff = 0;
		final String zero = "0";
		String binX = Integer.toBinaryString(x);
		String binY = Integer.toBinaryString(y);
		
		if (binX.length() < binY.length()) {
			for (int i=binX.length();i<binY.length();++i) {
				binX = zero + binX;
			}
			diff = findDiff(binX, binY);
		}
		else {
			for (int i=binY.length();i<binX.length();++i) {
				binY += "0";
			}
			diff = findDiff(binX, binY);
		}
		
		return diff;
	}
	public static int findDiff(String binX, String binY) {
		char[] binXArray = binX.toCharArray();
		char[] binYArray = binY.toCharArray();
		int diff = 0;
		
		for (int i=0;i<binXArray.length;++i) {
			if (binXArray[i] != binYArray[i])
				++diff;
		}
		
		return diff;
	}
	
	// Looked at one of the answers bc I didn't fully understand the class structure. This
	// is pretty much word-for-word so I don't know if this question counts for me but I
	// did learn how to do it so I don't know.
	// Given two binary trees and imagine that when you put one of them to cover the
	// other, some nodes of the two trees are overlapped while the others are not.You need
	// to merge them into a new binary tree. The merge rule is that if two nodes overlap,
	// then sum node values up as the new value of the merged node. Otherwise, the 
	// NOT null node will be used as the node of new tree. 
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		int t1Andt2Sum = 0;
		
		if (t1 == null && t2 == null)
			return null;
		
		t1Andt2Sum = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
		TreeNode newNode = new TreeNode(t1Andt2Sum);
		
		newNode.left = mergeTrees((t1 == null ? null : t1.left), (t2 == null ? null : t2.left));
		newNode.right = mergeTrees((t1 == null ? null : t1.right), (t2 == null ? null : t2.right));
		
		return newNode;
	}
	
	// Write a function that takes a string as input and returns the string reversed.
	// Was too slow on last case so I commented out and used StringBuilder(duh).
	public static String reverseString(String s) {
//		String reversedS = "";
//		char[] sArray = s.toCharArray();
//		
//		for (int i=0;i<sArray.length;++i) {
//			reversedS += sArray[(sArray.length-1)-i];
//		}
//		
//		return reversedS;
		return new StringBuilder(s).reverse().toString();
	}
	
	// Write a program that outputs the string representation of numbers from 1 to n.
	// But for multiples of three it should output “Fizz” instead of the number and for
	// the multiples of five output “Buzz”. For numbers which are multiples of both three
	// and five output “FizzBuzz”.
	public static List<String> fizzBuzz(int n) {
		List<String> answer = new ArrayList<String>(n);
		
		for (int i=1;i<n+1;++i) {
			if (i%3 == 0 && i%5 == 0) {
				answer.add("FizzBuzz");
			}
			else if (i%3 == 0) {
				answer.add("Fizz");
			}
			else if (i%5 == 0) {
				answer.add("Buzz");
			}
			else {
				answer.add(String.valueOf(i));
			}
		}
		
		return answer;
	}
	
	// Given an array of integers, every element appears twice except for one. 
	// Find that single one. Note:Your algorithm should have a linear runtime complexity.
	// Could you implement it without using extra memory?
	// TOO LONG. Commented out in exchange for bitwise XOR answer I found (ughhh).
	public static int singleNumber(int[] nums) {
//		List<Integer> answer = new ArrayList<Integer>(0);
//		
//		for (int i=0;i<nums.length;++i) {
//			if (answer.contains(nums[i]))
//				answer.remove(new Integer(nums[i]));
//			else
//				answer.add(nums[i]);
//		}
//		
//		return answer.get(0);
		int ans = 0;
		
		for (int i=0;i<nums.length;++i) {
			// 0 = FALSE, N = a number, and XOR is commutative so XOR: 0 ^ N = N, N ^ N = 0
			// Array: {2,1,4,5,2,4,1}, XOR: ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5
			// Commutative means it doesn't matter where the numbers in the array are
			ans = ans ^ nums[i];
		}
		
		return ans;
	}
	
	// Given a binary tree, find its maximum depth.
	// Could of been easier by returning 0 if root==null and if not then return 1+Math.max(left,right)
	public static int maxDepth(TreeNode root) {
		int depth = 0;
		
		if (root != null) {
			int leftNode = maxDepth(root.left);
			int rightNode = maxDepth(root.right);
			
			depth = 1 + (leftNode >= rightNode ? leftNode : rightNode);
		}
		
		return depth;
	}
	
	// Given an array nums, write a function to move all 0's to the end of it while maintaining the
	// relative order of the non-zero elements.For example, given nums = [0, 1, 0, 3, 12], after 
	// calling your function, nums should be [1, 3, 12, 0, 0]. Note:You must do this in-place without
	// making a copy of the array and minimize the total number of operations.
	// I suck. Here's a solution that isn't the garbage I just wrote.
	public static void moveZeroes(int[] nums) {
//		int counter = 0;
//		
//		for (int i=0;i<nums.length-counter;++i) {
//			if (nums[i] == 0) {
//				for (int j=i;j<nums.length-1-counter;++j) {
//					nums[j] = nums[j+1];
//				}
//				nums[nums.length-1-counter] = 0;
//				++counter;
//			}
//			if (nums[i] == 0 && i == nums.length-1) {
//				for (int k=0;k<nums.length-1;++k) {
//					if (nums[k] != 0) OK OK THIS IS AWFUL. LOOKING AT SOLUTION BECAUSE WOW THIS IS BAD
//				}
//			}
//		}
		int current = 0;

		for (int i = 0; i < nums.length; ++i)
			if (nums[i] != 0)
				nums[current++] = nums[i]; // Remember it does the operation first, THEN increments.

		for (int i = current; i < nums.length; ++i)
			nums[i] = 0;
	}
}
