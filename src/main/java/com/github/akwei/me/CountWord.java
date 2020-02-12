package com.github.akwei.me;

public class CountWord {
    public static void main(String[] args) {
//        String text = "language-specific";
        String text = " Amazon EC2 provides a Query API. These requests are HTTP or HTTPS requests that use the HTTP verbs GET or POST and a Query parameter named Action. For more information about the API actions for Amazon EC2, see Actions in the Amazon EC2 API Reference. language-specific \n"
//                +
//                "\n" +
//                "If you prefer to build applications using language-specific APIs instead of submitting a request over HTTP or HTTPS, AWS provides libraries, sample code, tutorials, and other resources for software developers. These libraries provide basic functions that automate tasks such as cryptographically signing your requests, retrying requests, and handling error responses, making it is easier for you to get started. For more information, see AWS SDKs and Tools"
                ;
        System.out.println(CountWord.count(text));
    }

    public static int count(String text) {
        char[] chars = text.toCharArray();
        int sum = 0;
        boolean beginCount = false;
        char prevCh = ' ';
        for (char ch : chars) {
            if (canCountWord(beginCount, prevCh, ch)) {
                beginCount = true;
            } else {
                if (beginCount) {
                    sum++;
                    beginCount = false;
                }
            }
            prevCh = ch;
        }
        if (beginCount) {
            sum++;
        }
        return sum;
    }

    public static boolean canCountWord(boolean curBeginCount, char prevCh, char ch) {
        if ((ch >= '0' && ch <= '9')
                || (ch >= 'a' && ch <= 'z')
                || (ch >= 'A' && ch <= 'Z')
                || (ch == '\'')) {
            return true;
        }
        if (curBeginCount && ch == '-') {
            return true;
        }
        if (curBeginCount && prevCh == '-') {
            return true;
        }
        return false;
    }
}
