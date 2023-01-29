package com.greatlearning.dsa.labsession3.main;

import java.util.ArrayList;
import java.util.List;
import com.greatlearning.common.GetInputs;
import com.greatlearning.interfaces.IreadData;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class SumBinarySearchTree {

	public static Node insertNode(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key)
			root.left = insertNode(root.left, key);
		else if (key > root.key)
			root.right = insertNode(root.right, key);
		return root;
	}

	public static void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}

	public static boolean searchAdditionList(int iSum, Node root, List<Integer> list) {
		if (root == null) {
			return false;
		}

		if (list.contains(iSum - root.key)) {
			System.out.println("Sum = " + iSum);
			System.out.println("Pair is (" + (iSum - root.key) + "," + root.key + ")");
			return true;
		} else {
			list.add(root.key);
		}

		if (iSum - root.key < root.key) {
			if (searchAdditionList(iSum, root.left, list)) {
				return true;
			}
		}
		return searchAdditionList(iSum, root.right, list);
	}

	public static void main(String[] args) {
		Node root = null;
		IreadData getData = new GetInputs();

		System.out.println("Enter the tree Value (to Stop enter -1) :");
		int iTmp;
		do {
			iTmp = getData.readInt();
			if (iTmp == -1) {
				break;
			} else {
				if (iTmp < 0) {
					System.out.println("Enter a valid postive integer value.");
				} else {
					root = insertNode(root, iTmp);
				}
			}
		} while (iTmp != -1);

		System.out.println("Enter the Sum to be chekced :");
		int iSum = getData.readPositiveInt();
		List<Integer> list = new ArrayList<Integer>();

		if (!searchAdditionList(iSum, root, list)) {
			System.out.println("The nodes are not found.");
		}

	}
}
