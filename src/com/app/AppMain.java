package com.app;

import java.io.IOException;

import com.util.JsonUtil;

public class AppMain {
	public static void main(String[] args) {

//		System.out.println(JsonUtil.isOption("( b )"));
		TextToJson ob = new TextToJson();
		try {
			ob.readTextFromFile();
			ob.getAnswersOfQuestion();
			ob.putToJson();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
