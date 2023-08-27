package alklid.algorithm.study.linkedlist;

import alklid.structure.LinkedList;
import alklid.structure.node.NodeNextLinkType;

/**
 * 배열(array), 연결리스트(linked list)
 *   - 배열
 *   - 어떤 원소를 바로 찾아갈 수 있다.
 *   - 원소의 검색 장점
 *   - 읽기 : O(1) / 삽입 : O(n) / 삭제 : O(n)
 * - 연결리스트
 *   - 해당 원소까지 처음부터 읽어가야 한다.
 *   - 모든 원소의 값을 한 번에 읽어야 한다면 배열보다는 좋다.
 *   - 원소의 추가 장점
 *   - 읽기 : O(n) / 삽입 : O(1) / 삭제 : O(1)
 * 선택정렬(selected sort) : O(n*n)
 * - 예) 높은 순위정렬
*/
public class LinkedListNode {
    public static void main(String[] args) {
        // 기본 기능
        basicTest();

        // 중복된 노드들을 모두 삭제
        removeDuplicate();

        // 뒤에서 k 번째 위치한 노드
        findNodeFromLast();

        // 중간에 있는 노드를 삭제, 삭제할 노드만 알고 첫번째 노드가 어딨는지 모름.
        deleteNodeInMid();

        // 기준값 왼쪽에는 작은것들, 오른쪽에는 큰것들을 위치하도록 정렬
        sortByValue();

        // 합산 알고리즘 (Header 가 1의 자리)
        twoSumListFromHead();

        // 합산 알고리즘 (Tail 이 1의 자리)
        twoSumListFromTail();

        // 회문 Palindrome : 거꾸로 해도 같은것!
        palindrome();

        // 교차점 찾기
        intersection();

        // 루프 찾기
        loop();
    }


    /**
     * 기본 기능에 대한 테스트
     */
    private static void basicTest() {
        System.out.println(" basicTest ----------------------");
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.retrieve();
        linkedList.delete(3);
        linkedList.retrieve();
        linkedList.delete(1);
        linkedList.retrieve();
    }


    /**
     * 중복된 값을 가진 노드들은 하나만 남겨놓고 제거
     */
    private static void removeDuplicate() {
        System.out.println(" removeDuplicateTest ----------------------");
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(5);
        linkedList.append(5);
        linkedList.append(5);
        linkedList.retrieve();
        linkedList.removeDuplicate();
        linkedList.retrieve();
    }


    /**
     * 뒤에서 k 번째 위치한 노드
     */
    private static void findNodeFromLast() {
        System.out.println(" findNodeFromLastTest ----------------------");
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.retrieve();

        System.out.println("----- findNodeFromLastSolution1 ");
        linkedList.findNodeFromLastSolution1(1);
        linkedList.findNodeFromLastSolution1(2);
        linkedList.findNodeFromLastSolution1(3);
        linkedList.findNodeFromLastSolution1(4);
        linkedList.findNodeFromLastSolution1(5);

        System.out.println("----- findNodeFromLastSolution2 ");
        linkedList.findNodeFromLastSolution2(linkedList.header, 1);
        linkedList.findNodeFromLastSolution2(linkedList.header, 2);
        linkedList.findNodeFromLastSolution2(linkedList.header, 3);
        linkedList.findNodeFromLastSolution2(linkedList.header, 4);
        linkedList.findNodeFromLastSolution2(linkedList.header, 5);

        System.out.println("----- findNodeFromLastSolution3 ");
        linkedList.findNodeFromLastSolution3(linkedList.header, 1);
        linkedList.findNodeFromLastSolution3(linkedList.header, 2);
        linkedList.findNodeFromLastSolution3(linkedList.header, 3);
        linkedList.findNodeFromLastSolution3(linkedList.header, 4);
        linkedList.findNodeFromLastSolution3(linkedList.header, 5);

        System.out.println("----- findNodeFromLastSolution4 ");
        linkedList.findNodeFromLastSolution4(linkedList.header, 1);
        linkedList.findNodeFromLastSolution4(linkedList.header, 2);
        linkedList.findNodeFromLastSolution4(linkedList.header, 3);
        linkedList.findNodeFromLastSolution4(linkedList.header, 4);
        linkedList.findNodeFromLastSolution4(linkedList.header, 5);
    }


    /**
     * 중간에 있는 노드를 삭제해야 하는데 삭제할 노드만 알고 첫번째 노드가 어딨는지 모름.
     */
    private static void deleteNodeInMid() {
        System.out.println(" deleteNodeInMid ----------------------");
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.retrieve();

        NodeNextLinkType deleteNode = linkedList.get(3);
        System.out.println("deleteNode : " + deleteNode.val);
        linkedList.deleteNodeInMidSolution(deleteNode);
        linkedList.retrieve();
    }


    /**
     * 기준값 왼쪽에는 작은것들, 오른쪽에는 큰것들을 위치하도록 정렬
     */
    private static void sortByValue() {
        System.out.println(" sortByValue ----------------------");
        LinkedList linkedList;
        linkedList = new LinkedList();
        linkedList.append(7);
        linkedList.append(2);
        linkedList.append(8);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(1);
        linkedList.append(6);
        linkedList.retrieve();

        linkedList.sortByValueSolution(5);
        linkedList.retrieve();

        linkedList = new LinkedList();
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(2);
        linkedList.append(7);
        linkedList.append(3);
        linkedList.retrieve();

        linkedList.sortByValueSolution(5);
        linkedList.retrieve();

        linkedList = new LinkedList();
        linkedList.append(7);
        linkedList.append(2);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.retrieve();

        linkedList.sortByValueSolution(5);
        linkedList.retrieve();
    }


    /**
     * 합산 알고리즘 (숫자의 1의 자리가 LinkedList Header 부터 시작하는 경우)
     * 예) 1419 : 9 -> 1 -> 4 -> 1
     * 예) 346 : 6 -> 4 -> 3
     */
    private static void twoSumListFromHead() {
        System.out.println(" twoSumListFromHead ----------------------");
        LinkedList ln1 = new LinkedList();
        ln1.append(9);
        ln1.append(1);
        ln1.append(4);
        ln1.append(1);
        ln1.retrieve();

        LinkedList ln2 = new LinkedList();
        ln2.append(6);
        ln2.append(4);
        ln2.append(3);
        ln2.retrieve();

        LinkedList sum = new LinkedList();
        sum.twoSumListHeadSolution(ln1.header.next, ln2.header.next);
        sum.retrieve();
    }

    /**
     * 합산 알고리즘 (숫자의 1의 자리가 LinkedList Tail 부터 시작하는 경우)
     * 예) 914 : 9 -> 1 -> 4
     * 예) 434 : 4 -> 3 -> 4
     */
    private static void twoSumListFromTail() {
        System.out.println(" twoSumListFromTail ----------------------");
        LinkedList ln1 = new LinkedList();
        ln1.append(9);
        ln1.append(1);
        ln1.append(4);
        ln1.retrieve();

        LinkedList ln2 = new LinkedList();
        ln2.append(4);
        ln2.append(3);
        ln2.append(4);
        ln2.retrieve();

        LinkedList sum = new LinkedList();
        sum.twoSumListTailSolution(ln1, ln2);
        sum.retrieve();
    }


    /**
     * 회문 Palindrome : 거꾸로 해도 같은것!
     */
    private static void palindrome() {
        System.out.println(" palindrome ----------------------");
        LinkedList linkedList = new LinkedList();
        linkedList.append('d');
        linkedList.append('a');
        linkedList.append('d');
        linkedList.retrieve();

        boolean isPalindrome1 = linkedList.palindromeSolution1();
        boolean isPalindrome2 = linkedList.palindromeSolution2();
        System.out.println("isPalindrome1  = " + isPalindrome1);
        System.out.println("isPalindrome2  = " + isPalindrome2);

        linkedList = new LinkedList();
        linkedList.append('d');
        linkedList.append('a');
        linkedList.append('d');
        linkedList.append('d');
        linkedList.retrieve();

        isPalindrome1 = linkedList.palindromeSolution1();
        isPalindrome2 = linkedList.palindromeSolution2();
        System.out.println("isPalindrome1  = " + isPalindrome1);
        System.out.println("isPalindrome2  = " + isPalindrome2);

        linkedList = new LinkedList();
        linkedList.append('d');
        linkedList.append('a');
        linkedList.append('d');
        linkedList.append('d');
        linkedList.append('a');
        linkedList.append('d');
        linkedList.retrieve();

        isPalindrome1 = linkedList.palindromeSolution1();
        isPalindrome2 = linkedList.palindromeSolution2();
        System.out.println("isPalindrome1  = " + isPalindrome1);
        System.out.println("isPalindrome2  = " + isPalindrome2);
    }


    /**
     * 두개의 LinkedList 가 중간에 교차하는 지점이 있는지 검사
     */
    private static void intersection() {
        System.out.println(" intersection ----------------------");
        LinkedList ln1 = new LinkedList();
        ln1.append(2);
        ln1.append(3);
        ln1.append(4);
        ln1.append(6);
        ln1.append(9);
        ln1.retrieve();

        LinkedList ln2 = new LinkedList();
        ln2.append(1);
        ln2.append(5);
        ln2.append(7);
        ln2.append(9);
        ln2.retrieve();

        boolean isIntersection = ln1.intersection(ln2);
        System.out.println("isIntersection = " + isIntersection);
    }


    /**
     * LinkedList 내에서 Loop 찾기
     */
    private static void loop() {
        System.out.println(" loop ----------------------");
        LinkedList linkedList = new LinkedList();
        NodeNextLinkType n1 = new NodeNextLinkType(1);
        NodeNextLinkType n2 = n1.addNext(2);
        NodeNextLinkType n3 = n2.addNext(3);
        NodeNextLinkType n4 = n3.addNext(4);
        NodeNextLinkType n5 = n4.addNext(5);
        NodeNextLinkType n6 = n5.addNext(6);
        NodeNextLinkType n7 = n6.addNext(7);
        NodeNextLinkType n8 = n7.addNext(8);
        n8.addNext(n4);
        linkedList.header.next = n1;

        NodeNextLinkType loopStartNode = linkedList.findLoopSolution(n1);

        if (loopStartNode == null) {
            System.out.println("loop not found!");
        }
        else {
            System.out.println("loopStartNode = " + loopStartNode.val);
        }
    }

}
