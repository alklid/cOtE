import java.util.*;

class Solution {
    
    private final static String[][] calcPriorities = new String[][]{
        {"*", "+", "-"},
        {"*", "-", "+"},
        {"+", "*", "-"},
        {"+", "-", "*"},
        {"-", "*", "+"},
        {"-", "+", "*"},
    };
    
    public long solution(String expression) {
        // 연산식 파싱
        StringTokenizer tokenizer = new StringTokenizer(expression, "*+-", true);
        List<String> expList = new LinkedList<>();
        while (tokenizer.hasMoreTokens()) {
            expList.add(tokenizer.nextToken());
        }

        // 연산 우선순위에 따른 계산
        long[] calc = new long[calcPriorities.length];
        for (int i=0; i< calcPriorities.length; i++) {
            calc[i] = calculate(new LinkedList<>(expList), calcPriorities[i]);
        }

        Arrays.sort(calc);
        return calc[calc.length-1];
    }
    
    private long calculate(LinkedList<String> exp, String[] opers) {
        for (String s : opers) {
            exp = calculate(exp, s);
        }

        return Math.abs(Long.parseLong(exp.get(0)));
    }

    private LinkedList<String> calculate(LinkedList<String> exp, String op) {
        LinkedList<String> temp = new LinkedList<>();

        while (!exp.isEmpty()) {
            String item = exp.poll();
            if (item.equals(op)) {
                temp.add(calculate(temp.pollLast(), exp.poll(), item));
            }
            else {
                temp.add(item);
            }
        }

        return temp;
    }

    private String calculate(String a, String b, String op) {
        long result = 0;
        switch(op) {
            case "+":
                result = Long.parseLong(a) + Long.parseLong(b);
                break;
            case "-":
                result = Long.parseLong(a) - Long.parseLong(b);
                break;
            case "*":
                result = Long.parseLong(a) * Long.parseLong(b);
                break;
            default:
                result = 0;
        }
        
        return Long.toString(result);
    }
}