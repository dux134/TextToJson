package com.util;

public class JsonUtil {

	public static boolean isQuestion(String str) {

		return str.matches("Q[0123456789O]*.*");
	}

	public static boolean isOption(String str) {
//		return str.matches("\\A[0-9]+\\)\\s[a-zA-Z0-9\\s]*");
		return str.matches("\\([\\s]*[abcd]+[\\s]*\\)");
	}
}
