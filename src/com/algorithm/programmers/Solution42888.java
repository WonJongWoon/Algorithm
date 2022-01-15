package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/01/15
// Problem : https://programmers.co.kr/learn/courses/30/lessons/42888

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution42888 {

	private final static String ENTER_MSG = "%s님이 들어왔습니다.";
	private final static String LEAVE_MSG = "%s님이 나갔습니다.";

	private Map<String, String> fetchInfos(String[] records) {
		Map<String, String> result = new HashMap<>();

		for (String record : records) {
			String[] tokens = record.split(" ");
			String command = tokens[0];
			String userId = tokens[1];

			if ("Enter".equals(command) || "Change".equals(command)) {
				String nickname = tokens[2];
				result.put(userId, nickname);
			}
		}

		return result;
	}

	private String enterMessage(String nickname) {
		return String.format(ENTER_MSG, nickname);
	}

	private String leaveMessage(String nickname) {
		return String.format(LEAVE_MSG, nickname);
	}

	public String[] solution(String[] records) {
		Map<String, String> infos = fetchInfos(records);

		List<String> result = new ArrayList<>();
		for (String record : records) {
			String[] tokens = record.split(" ");
			String command = tokens[0];
			String userId = tokens[1];
			String nickname = infos.get(userId);

			if ("Enter".equals(command)) {
				result.add(enterMessage(nickname));
			} else if ("Leave".equals(command)) {
				result.add(leaveMessage(nickname));
			}
		}

		return result.toArray(new String[0]);
	}
}
