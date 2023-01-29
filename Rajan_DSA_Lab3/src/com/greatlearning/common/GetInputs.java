package com.greatlearning.common;

import java.util.Scanner;

import com.greatlearning.interfaces.IreadData;

public class GetInputs implements IreadData {
	Scanner sc = new Scanner(System.in);

	public long readLong() {
		long tmpReadValue;
		while (!sc.hasNextLong()) {
			System.out.println("Enter a valid long number!");
			sc.next();
		}
		tmpReadValue = sc.nextLong();
		return tmpReadValue;
	}

	public int readInt() {
		int tmpReadValue;
		while (!sc.hasNextInt()) {
			System.out.println("Enter a valid Integer!");
			sc.next();
		}
		tmpReadValue = sc.nextInt();
		return tmpReadValue;
	}

	public int readPositiveInt() {
		int tmpReadValue = readInt();
		while (tmpReadValue <= 0) {
			System.out.println("Enter a interger value greater than Zero.");
			tmpReadValue = readInt();
		}
		return tmpReadValue;
	}

	@Override
	public String readString() {
		// TODO Auto-generated method stub
		String tmpReadValue;
		while (!sc.hasNext()) {
			System.out.println("Enter a valid String!");
			sc.next();
		}
		tmpReadValue = sc.next();
		return tmpReadValue;

	}

	@Override
	public boolean readBoolean() {
		// TODO Auto-generated method stub
		boolean tmpReadValue;
		while (!sc.hasNextBoolean()) {
			System.out.println("Enter a valid Boolean value!");
			sc.next();
		}
		tmpReadValue = sc.nextBoolean();
		return tmpReadValue;
	}

	@Override
	public float readFloat() {
		// TODO Auto-generated method stub
		float tmpReadValue;
		while (!sc.hasNextFloat()) {
			System.out.println("Enter a valid Float value!");
			sc.next();
		}
		tmpReadValue = sc.nextInt();
		return tmpReadValue;
	}

	@Override
	public char readChar() {
		// TODO Auto-generated method stub
		char tmpReadValue;
		while (!sc.hasNext()) {
			System.out.println("Enter a valid Integer!");
			sc.next();
		}
		tmpReadValue = sc.next().charAt(0);
		return tmpReadValue;
	}

	public String readBrackets() {
		String tmpReadValue = "";
		char tmpChar;
		int iTmp = 0;
		boolean bInValid = true;

		while (bInValid) {
			tmpReadValue = readString();
			for (int i = 0; i < tmpReadValue.length(); i++) {
				tmpChar = tmpReadValue.charAt(i);
				iTmp = i;
				if (!(tmpChar == '{' || tmpChar == '}' || tmpChar == '(' || tmpChar == ')' || tmpChar == '['
						|| tmpChar == ']')) {
					bInValid = true;
					System.out.println("Enter only valid Brackets '{}()[]' ");
					break;
				}
			}
			if (iTmp == tmpReadValue.length() - 1) {
				bInValid = false;
			}
		}
		return tmpReadValue;
	}
}
