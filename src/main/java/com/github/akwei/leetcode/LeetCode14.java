package com.github.akwei.leetcode;

public class LeetCode14 {

    public static void main(String[] args) {
//        String[] strArr = {"flower", "flow", "flight"};
//        String[] strArr = {"dog", "racecar", "car"};
//        String[] strArr = {"dog", "racdog", "cardog"};
//        String[] strArr = {"flow", "flower", "flowerr"};
//        String[] strArr = {"cir", "car"};
        String[] strArr = {"ab", "a"};
        LeetCode14 obj = new LeetCode14();
        System.out.println(obj.longestCommonPrefix(strArr));
    }

    public String longestCommonPrefix(String[] strArr) {
        return longestCommonPrefix1(strArr);
    }

    public String longestCommonPrefix0(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr.length == 0) {
            return sb.toString();
        }
        int idx = 0;
        while (true) {
            char lastChar = 0;
            for (String str : strArr) {
                if (str.length() == idx) {
                    return sb.toString();
                }
                char c = str.charAt(idx);
                if (lastChar == 0) {
                    lastChar = c;
                    continue;
                }
                if (c == lastChar) {
                    continue;
                }
                lastChar = 0;
                break;
            }
            if (lastChar == 0) {
                return sb.toString();
            }
            sb.append(lastChar);
            idx++;
        }
    }

    public String longestCommonPrefix1(String[] strArr) {
        if (strArr.length == 0) {
            return "";
        }
        String tmp = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            int idx = 0;
            while (true) {
                if (tmp.length() == idx || strArr[i].length() == idx) {
                    break;
                }
                if (tmp.charAt(idx) == strArr[i].charAt(idx)) {
                    idx++;
                } else {
                    break;
                }
            }
            if (idx == 0) {
                return "";
            }
            tmp = tmp.substring(0, idx);
        }
        return tmp;
    }
}
