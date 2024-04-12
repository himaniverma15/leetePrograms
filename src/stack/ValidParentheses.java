package stack;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(])"));
    }

    public static boolean isValid(String s) {

        boolean isValid = false;
        if (s.length() == 1) {
            return false;
        }
        int top = -1;

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            switch (c) {

                case '(': {
                    top += 1;
                    list.add(c);
                }

                break;
                case '[': {
                    top += 1;
                    list.add(c);
                }
                break;
                case '{': {
                    top += 1;
                    list.add(c);
                }
                break;
                case ')': {
                    if (list.size()>0  && list.get(top) == '(') {
                        list.remove(top);
                        top -= 1;
                    } else {
                        list.add(c);
                        top+=1;
                    }
                }

                break;
                case '}': {
                    if (list.size()>0  && list.get(top) == '{' ) {
                        list.remove(top);
                        top -= 1;
                    } else {
                        list.add(c);
                        top+=1;
                    }
                }
                break;
                case ']': {
                    if (list.size()>0 && list.get(top) == '[') {
                        list.remove(top);
                        top -= 1;
                    } else {
                        list.add(c);
                        top+=1;
                    }
                }
                break;
            }

        }

        if (top == -1) {
            isValid = true;
        }

        return isValid;
    }
}
