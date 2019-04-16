package com.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.entity.Answer;
import com.entity.Question;
import com.util.JsonUtil;

public class TextToJson {
	ArrayList<Question> list = new ArrayList<>();
	ArrayList<Question> qANDa = new ArrayList<>();
	ArrayList<Answer> list1 = new ArrayList<>();
	String[] arr;
	int count = 0;

	private void operation() {

	}

	public void readTextFromFile() throws IOException {
		FileReader text = new FileReader("src/1000 analogy questions.txt");
		BufferedReader br = new BufferedReader(text);
		String st, s = "", previousQue = "";
		while ((st = br.readLine()) != null) {
			if (JsonUtil.isQuestion(st)) {
				if (s != null || !s.equals("")) {
					convertIntoQuestion(s, previousQue);
					s = "";
				}
				previousQue = st;

			} else {
				s += st.trim() + " ";
			}
		}
	}

	public void getAnswersOfQuestion() throws IOException {
		FileReader text = new FileReader("src/answers.txt");
		BufferedReader br = new BufferedReader(text);
		String st;
		while ((st = br.readLine()) != null) {
			if (st.length() > 1) {
				String[] str = st.split(" ");
				Answer answer3 = new Answer();
				answer3.setAnswerN((str[0]));
				answer3.setAns(str[1]);
				list1.add(answer3);
			}
		}
		for (Answer a : list1) {
			int n = Integer.parseInt(a.getAnswerN());
			if (n < 948) {
				Question q = list.get(n - 1);
				q.setAnswer(a.getAns());
				qANDa.add(q);
			}
		}
		Collections.sort(qANDa);
		for (int i = 1; i < 500; i++) {
			if(qANDa.get(i).isNull())
				System.out.println(i);
		}
	}

	private void convertIntoQuestion(String s, String previousQue) {
		if (s.length() <= 0)
			return;
		int queNo = Integer.parseInt(previousQue.substring(1, previousQue.length() - 2));
		Matcher matcher = Pattern.compile("\\([\\s]*[abcd]+[\\s]*\\)").matcher(s);
		int index = 0;
		count = 0;
		arr = new String[6];
		while (matcher.find()) {
			arr[count++] = s.substring(index, matcher.start());
			index = matcher.end();
		}
		arr[count] = s.substring(index, s.length() - 1);
		list.add(new Question(queNo,queNo +". "+ arr[0], arr[1], arr[2], arr[3], arr[4]));
	}

	public void putToJson() throws FileNotFoundException {
		JSONObject jo = new JSONObject();
		PrintWriter pw = new PrintWriter("JSON analogy que.json");
		JSONArray ar = new JSONArray();

		Map m = new LinkedHashMap(5); 
		m.put("1-100","");
		m.put("101-200", "");
		jo.put("solved", m);
		int i;
		for (Question question : list) {
			i = question.getQueNo();
			m = new LinkedHashMap(5); 
	        m.put("question", question.getQues());
	        m.put("a", question.getOptionA());
	        m.put("b", question.getOptionB());
	        m.put("c", question.getOptionC());
	        m.put("d", question.getOptionD());
	        m.put("ans", question.getAnswer());	    
	        m.put("solved", "false");
	        m.put("solution", "");
	        jo.put(i, m);
		}
        pw.write(jo.toString());
		pw.flush();
		pw.close();
	}

}
