class Solution {
    public int solution(int[] numbers, int k) {
        Node root = new Node(numbers[0]);
        for (int i=1; i<numbers.length; i++) {
            Node node = new Node(numbers[i]);
            Node n = root;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
            
            if (i == numbers.length-1) {
                node.next = root;
            }
        }
        
        Node findNode = root;
        for (int i=0; i<k-1; i++) {
            findNode = findNode.next.next;
        }
        int answer = findNode.val;
        return answer;
    }
    
    static class Node {
        public int val;
        public Node next;
        
        public Node(int val) { this.val = val;}
    }
}