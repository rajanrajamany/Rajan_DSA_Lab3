package com.greatlearning.dsa.labsession3.main;

import java.util.Stack;
import com.greatlearning.common.GetInputs;
import com.greatlearning.interfaces.IreadData;

public class BalancingBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IreadData getData = new GetInputs();

		System.out.println("Enter the Brackets :");
		String sInput = getData.readBrackets();

		char cTemp;
		char cLast;
		boolean bBalancedBrackets = true;

		Stack<Character> cStack = new Stack<Character>();
		for (int i = 0; i < sInput.length(); i++) {
			cTemp = sInput.charAt(i);
			if (cTemp == '(' || cTemp == '[' || cTemp == '{') {
				cStack.add(cTemp);
			} else if (cTemp == ')' || cTemp == ']' || cTemp == '}') {
				if (!cStack.isEmpty()) {
					cLast = cStack.peek();
					if ((cLast == '(' && cTemp == ')') || (cLast == '[' && cTemp == ']')
							|| (cLast == '{' && cTemp == '}')) {
						cStack.pop();
					} else {
						bBalancedBrackets = false;
						break;
					}
				} else {
					bBalancedBrackets = false;
					break;
				}
			}
		}
		if (!cStack.isEmpty()) {
			bBalancedBrackets = false;
		}
		if (bBalancedBrackets) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
}
