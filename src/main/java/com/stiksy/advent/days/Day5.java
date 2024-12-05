package com.stiksy.advent.days;

import java.util.ArrayList;
import java.util.List;

public class Day5 {
    public List<int[]> getRules(String inputRules) {
        List<int[]> rulesList = new ArrayList<>();
        String[] rules = inputRules.split("\n");
        for (String ruleString : rules) {
            int[] ruleArray = new int[2];
            String[] rule = ruleString.split("\\|");
            ruleArray[0] = Integer.parseInt(rule[0]);
            ruleArray[1] = Integer.parseInt(rule[1]);
            rulesList.add(ruleArray);
        }
        return rulesList;
    }

    public List<List<Integer>> getPages(String inputPages) {
        List<List<Integer>> pagesList = new ArrayList<>();
        String[] pages = inputPages.split("\n");
        for (String pageString : pages) {
            List<Integer> pageList = new ArrayList<>();
            String[] page = pageString.split(",");
            for (String pageNumber : page) {
                pageList.add(Integer.parseInt(pageNumber));
            }
            pagesList.add(pageList);
        }
        return pagesList;
    }

    public boolean checkPagesOnRules(List<int[]> rules, List<Integer> pages) {
        for (int i = 0; i < pages.size(); i++) {
            for (int j = i + 1; j < pages.size(); j++) {
                boolean isPagePairValid = false;
                int[] pagePair = new int[]{pages.get(i), pages.get(j)};
                for (int[] rule : rules) {
                    if (rule[0] == pagePair[0] && rule[1] == pagePair[1]) {
                        isPagePairValid = true;
                        break;
                    }
                }
                if (!isPagePairValid) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Integer> fixPagesOrder(List<int[]> rules, List<Integer> pages) {
        for (int i = 0; i < pages.size(); i++) {
            for (int j = i + 1; j < pages.size(); j++) {
                boolean isPagePairValid = false;
                int[] pagePair = new int[]{pages.get(i), pages.get(j)};
                for (int[] rule : rules) {
                    if (rule[0] == pagePair[0] && rule[1] == pagePair[1]) {
                        isPagePairValid = true;
                        break;
                    }
                }
                if (!isPagePairValid) {
                    int temp = pages.get(i);
                    pages.set(i, pages.get(j));
                    pages.set(j, temp);
                }
            }
        }
        return pages;
    }

    public int getMiddleNumber(List<Integer> pages) {
        return pages.get(pages.size() / 2);
    }

    public int calculateSumOfPages(String inputPages, String inputRules) {
        List<int[]> rulesList = getRules(inputRules);
        List<List<Integer>> pagesList = getPages(inputPages);
        int sum = 0;
        for (List<Integer> pageList : pagesList) {
            if (checkPagesOnRules(rulesList, pageList)) {
                sum += getMiddleNumber(pageList);
            }
        }
        return sum;
    }

    public int calculateSumOfInvalidPages(String inputPages, String inputRules) {
        List<int[]> rulesList = getRules(inputRules);
        List<List<Integer>> pagesList = getPages(inputPages);
        int sum = 0;
        for (List<Integer> pageList : pagesList) {
            if (!checkPagesOnRules(rulesList, pageList)) {
                List<Integer> fixedPages = fixPagesOrder(rulesList, pageList);
                sum += getMiddleNumber(fixedPages);
            }
        }
        return sum;
    }
}
