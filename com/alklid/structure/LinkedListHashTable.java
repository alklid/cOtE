package alklid.structure;

import alklid.structure.node.NodeKeyValueType;

import java.util.LinkedList;

public class LinkedListHashTable {

    private LinkedList<NodeKeyValueType>[] data;

    public LinkedListHashTable(int size) {
        this.data = new LinkedList[size];
    }

    // 문자열의 각 문자의 아스키코드를 더해서 해시코드를 생성
    int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    // 배열방 번호 구하기. 배열방 갯수로 나눈 나머지를 배열방의 인덱스로 사용
    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    // key 로 node 검색하는 함수
    NodeKeyValueType searchKey(LinkedList<NodeKeyValueType> list, String key) {
        if (list == null) return null;

        for (NodeKeyValueType node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    // 데이터를 받아서 Node 저장하는 함수
    public void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<NodeKeyValueType> list = data[index];

        if (list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }

        NodeKeyValueType node = searchKey(list, key);
        if (node == null) {
            list.addLast(new NodeKeyValueType(key, value));
        }
        else {
            node.value(value);
        }
    }

    // key 로 value 가져오는 함수
    public String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<NodeKeyValueType> list = data[index];
        NodeKeyValueType node = searchKey(list, key);

        return node == null ? "Not Found" : node.value();
    }
}
