package alklid.structure;

import alklid.structure.node.NodeNextLinkType;

import java.util.Stack;

public class LinkedList {
    public NodeNextLinkType header;

    public LinkedList() {
        header = new NodeNextLinkType();
    }

    public void append(int val) {
        NodeNextLinkType node = new NodeNextLinkType(val);
        NodeNextLinkType n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    public void delete(int val) {
        NodeNextLinkType n = header;
        while (n.next != null) {
            if (n.next.val == val) {
                n.next = n.next.next;
            }
            else {
                n = n.next;
            }
        }
    }

    public void removeDuplicate() {
        NodeNextLinkType n = header.next;
        while (n != null && n.next != null) {
            NodeNextLinkType r = n;
            while (r.next != null) {
                if (r.next.val == n.val) {
                    r.next = r.next.next;
                }
                else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    public void retrieve() {
        NodeNextLinkType n = header.next;
        while (n.next != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println(n.val);
    }

    public void retrieve(NodeNextLinkType n) {
        while (n.next != null) {
            System.out.print(n.val + " -> ");
            n = n.next;
        }
        System.out.println(n.val);
    }

    public NodeNextLinkType get(int findIdx) {
        int idx = 1;
        NodeNextLinkType n = header.next;
        while (n.next != null) {
            if (idx == findIdx) {
                return n;
            }
            idx++;
            n = n.next;
        }
        return null;
    }

    public int getListLength(NodeNextLinkType n) {
        int total = 0;
        while (n != null) {
            total++;
            n = n.next;
        }
        return total;
    }

    public NodeNextLinkType LPadList(NodeNextLinkType n, int length) {
        NodeNextLinkType head = n;
        for (int i=0; i<length; i++) {
            head = insertBefore(head, 0);
        }
        header.next = head;
        return head;
    }

    public NodeNextLinkType insertBefore(NodeNextLinkType n, int val) {
        NodeNextLinkType before = new NodeNextLinkType(val);
        if (n != null) {
            before.next = n;
        }
        return before;
    }
    //------ 여기까지 유틸 함수 ------


    /**
     * 마지막에서 k 번째 노드를 구하라.
     * 전체 갯수를 구하고 O(n), 마지막번째 k 위치까지 한번더 조회 O(n)
     */
    public NodeNextLinkType findNodeFromLastSolution1(int i) {
        NodeNextLinkType n = header;

        int totalCount = 0;
        while (n.next != null) {
            totalCount++;
            n = n.next;
        }

        int findIdx = totalCount - i + 1;
        n = header;
        for (int j=0; j<findIdx; j++) {
            n = n.next;
        }

        System.out.println("find node! : " + n.val);
        return n;
    }

    /**
     * 마지막에서 k 번째 노드를 구하라.
     * 재귀호출을 이용해서 마지막에서부터 역으로 순서를 반환
     * 마지막까지는 가야 하니까 O(n)
     */
    public void findNodeFromLastSolution2(NodeNextLinkType n, int k) {
        recursiveFind(n, k);
    }

    private int recursiveFind(NodeNextLinkType n, int k) {
        if (n == null) {
            return 0;
        }

        int count = recursiveFind(n.next, k) + 1;
        if (count == k) {
            System.out.println("find node! : " + n.val);
        }

        return count;
    }

    /**
     * 마지막에서 k 번째 노드를 구하라.
     * 메모라이즈 방식을 적용. k 번째를 담는 레퍼런스 변수를 두고, 재귀함수에서는 Node 를 반환
     */
    class Reference {
        int count;
    }

    public void findNodeFromLastSolution3(NodeNextLinkType n, int k) {
        Reference r = new Reference();
        NodeNextLinkType findNode = recursiveFindNode(n, k, r);
        System.out.println("find node! : " + findNode.val);
    }

    private NodeNextLinkType recursiveFindNode(NodeNextLinkType n, int k, Reference r) {
        if (n == null) {
            return null;
        }

        NodeNextLinkType found = recursiveFindNode(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }

        return found;
    }

    /**
     * 포인터를 k번째 거리만큼 벌려서 같이 출발시키고
     * 먼저 출발된 포인터가 끝까지 가면, 뒤에 따라간 포인터가 원하는 위치,
     * 시간복잡도 O(n), 공간복잡도 O(1)
     */
    public NodeNextLinkType findNodeFromLastSolution4(NodeNextLinkType n, int k) {
        NodeNextLinkType p = n;
        NodeNextLinkType found = n;

        for (int i=0; i<k; i++) {
            if (p == null) return null;
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            found = found.next;
        }

        System.out.println("find node! : " + found.val);

        return found;
    }

    /**
     * 중간에 있는 노드를 삭제, 단 삭제할 노드만 받고 첫번째 노드가 어딨는지 모름
     * 다음 노드의 값과 next 포인트를 삭제할 노드에 덮어씌우면,
     * 현재 노드의 연결고리가 없어져서 삭제와 같음
     */
    public boolean deleteNodeInMidSolution(NodeNextLinkType n) {
        if (n == null || n.next == null) {
            return false;
        }

        n.val = n.next.val;
        n.next = n.next.next;
        return true;
    }

    /**
     * 기준값 왼쪽에는 작은것들, 오른쪽에는 큰것들을 위치하도록 정렬
     */
    public void sortByValueSolution(int limit) {
        NodeNextLinkType n = header.next;
        NodeNextLinkType h = n;
        NodeNextLinkType t = n;
        while (n != null) {
            NodeNextLinkType next = n.next;

            if (n.val < limit) {
                n.next = h;
                h = n;
            }

            if (n.val >= limit) {
                t.next = n;
                t = n;
            }

            n = next;
        }

        t.next = null;
        header.next = h;
    }

    /**
     * 어떤 숫자를 자리수별로 한개씩 LinkedList 에 담았다.
     * 그런데 1의 자리가 헤더에 오도록 거꾸로 담았따.
     * 이런식의 LinkedList 두개를 받아서 합산하고 같은 식으로
     * LinkedList 에 담아서 반환하라.
     *
     * 419 : 9 -> 1 -> 4
     * 346 : 6 -> 4 -> 3
     */
    public void twoSumListHeadSolution(NodeNextLinkType l1, NodeNextLinkType l2) {
        int carry = 0;
        NodeNextLinkType resultNode = recursiveMergeAdd(l1, l2, carry);
        header.next = resultNode;
    }

    private static NodeNextLinkType recursiveMergeAdd(
            NodeNextLinkType l1, NodeNextLinkType l2, int carry) {

        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        if (l1 != null) {
            value += l1.val;
        }

        if (l2 != null) {
            value += l2.val;
        }

        NodeNextLinkType result = new NodeNextLinkType(value % 10);
        if (l1 != null || l2 != null) {
            NodeNextLinkType next = recursiveMergeAdd(
                    l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value / 10);
            result.next = next;
        }
        return result;
    }


    /**
     * 어떤 숫자를 자리수별로 한개씩 LinkedList 에 담았다.
     * LinkedList 두개를 받아서 합산하고 같은 식으로
     * LinkedList 에 담아서 반환하라.
     *
     * 419 : 4 -> 1 -> 9
     * 46 : 4 -> 6
     *
     * 1. 자리수에 맞춰서 0을 헤더에 추가
     * 2. 재귀를 끝까지 가면 끝에서 역으로 결과값을 반환한것으로 carry 와 연결설정
     * 3. 마지막에 carry 만 남아 있을 수 있어 처리
     */
    class twoSumReference {
        int carry;
    }
    public void twoSumListTailSolution(LinkedList l1, LinkedList l2) {
        int n1Count = getListLength(l1.header.next);
        int n2Count = getListLength(l2.header.next);

        if (n1Count < n2Count) {
            l1.LPadList(l1.header.next, n2Count - n1Count);
        }

        if (n2Count < n1Count) {
            l2.LPadList(l2.header.next, n1Count - n2Count);
        }

        twoSumReference r = new twoSumReference();
        NodeNextLinkType sumNode = recursiveTwoSumLT(l1.header.next, l2.header.next, r);
        header.next = sumNode;

        // 마지막 계산 이후에 carry 남아 있으면 추가
        if (r.carry != 0) {
            NodeNextLinkType carryNode = insertBefore(header.next, r.carry);
            header.next = carryNode;
        }
    }

    private NodeNextLinkType recursiveTwoSumLT(NodeNextLinkType n1, NodeNextLinkType n2, twoSumReference r) {
        if (n1 == null && n2 == null && r.carry == 0) {
            return null;
        }

        NodeNextLinkType result = null;
        if (n1 != null || n2 != null) {
            NodeNextLinkType sumNode = recursiveTwoSumLT(
                    n1.next == null ? null : n1.next,
                    n2.next == null ? null : n2.next,
                    r);

            int total = r.carry;
            if (n1 != null) {
                total += n1.val;
            }
            if (n2 != null) {
                total += n2.val;
            }
            r.carry = total / 10;
            result = insertBefore(sumNode, total % 10);
        }
        return result;
    }


    /**
     * 회문 검사 #1
     * LinkedList 를 거꾸로 복사하고, 처음부터 같이 순회하면서 값이 다른지 확인
     * 시간복잡도 : O(n), 공간복잡도 : O(n)
     */
    public boolean palindromeSolution1() {
        LinkedList pd = reverseAndClone(header.next);
        pd.retrieve();

        return isEquals(header.next, pd.header.next);
    }

    private LinkedList reverseAndClone(NodeNextLinkType n) {
        LinkedList pd = new LinkedList();
        while (n != null) {
            NodeNextLinkType before = pd.insertBefore(pd.header.next, n.val);
            pd.header.next = before;
            n = n.next;
        }

        return pd;
    }

    private boolean isEquals(NodeNextLinkType n1, NodeNextLinkType n2) {
        while (n1 != null & n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1 == null && n2 == null;
    }

    /**
     * 회문 검사 #2
     * slow/fast 두배빠른 포인터를 먼저 끝까지 돌리면, 늦는 포인터가 딱 절반까지 와있음
     * 늦는 포인터가 절반까지 오는 동안의 값을 Stack 에 넣어놓고
     * 절반이후부터 계속 진행하면서 Stack 에서 값을 빼면서 값을 비교
     * 시간복잡도 : O(n), 공간복잡도 : O(n)
     */
    public boolean palindromeSolution2() {
        NodeNextLinkType slow = header.next;
        NodeNextLinkType fast = header.next;

        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }


    /**
     * 교차 검사 #1
     * 두개의 LinkedList 가 중간에 교차하는 지점이 있는지 검사
     * 단순 비교, 만약 길이가 다르면 앞에서 잘라서 길이 맞추고 비교
     */
    public boolean intersection(LinkedList ln2) {
        int ln1Length = getListLength(header.next);
        int ln2Length = getListLength(ln2.header.next);

        NodeNextLinkType n1 = header.next;
        NodeNextLinkType n2 = ln2.header.next;
        if (ln1Length > ln2Length) {
            n1 = get(ln1Length - ln2Length + 1);
        }
        else if (ln2Length > ln1Length) {
            n2 = ln2.get(ln2Length - ln1Length + 1);
        }

        while (n1 != null && n2 != null) {
            if (n1.val == n2.val) {
                return true;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        return false;
    }


    /**
     * LinkedList 내에서 Loop 찾기
     * 두칸씩 가는 포인터와 한칸씩 가는 포인터는 진행시켜서 둘이 만나면 루프임.
     * 루프라면 루프가 시작하는 노드를 찾기
     */
    public NodeNextLinkType findLoopSolution(NodeNextLinkType head) {
        NodeNextLinkType fast = head;
        NodeNextLinkType slow = head;

        // 둘이 만날때까지 fast 한칸, slow 두칸씩 이동
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // 만나면 while 종료
            if (fast == slow) {
                break;
            }
        }

        // 만나서 빠져나온게 끝이었거나, while 조건을 만족시키지 못했거나
        // loop 시작점이 없다는 것이니 null 반환
        if (fast == null || fast.next == null) {
            return null;
        }

        // slow 를 제일 처음으로 이동시키고, 만날때까지 한칸씩 이동시킴
        // loop 가 있다는것을 알고 있음, 없었으면 이미 위에서 null 반환시켰음
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
