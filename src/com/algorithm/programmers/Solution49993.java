package com.algorithm.programmers;

// Created by https://github.com/WonJongWoon 2022/02/24
// Problem : https://programmers.co.kr/learn/courses/30/lessons/49993

class Solution49993 {

	private String getLeadingSkillinSkillTree(String leadingSkills, String skillTree) {
		StringBuilder result = new StringBuilder();
		for (char skill : skillTree.toCharArray()) {
			if (leadingSkills.contains(String.valueOf(skill))) {
				result.append(skill);
			}
		}

		return result.toString();
	}

	public int solution(String leadingSkills, String[] skillTrees) {
		int result = 0;
		for (String skillTree : skillTrees) {
			String leadingSkillInSkillTree = getLeadingSkillinSkillTree(leadingSkills, skillTree);

			for (int idx = leadingSkills.length(); idx >= 0; idx--) {
				String partOfLeadingSkills = leadingSkills.substring(0, idx);
				if (partOfLeadingSkills.equals(leadingSkillInSkillTree)) {
					result++;
					break;
				}
			}
		}

		return result;
	}
}
