package alklid.algorithm.study.linkedlist;

public class LinkedListHashTable {
    public static void main(String[] args) {
        alklid.structure.LinkedListHashTable hashTable
                = new alklid.structure.LinkedListHashTable(3);
        hashTable.put("sung", "sung");
        hashTable.put("jin", "jin");
        hashTable.put("hee", "hee");
        hashTable.put("min", "min");
        hashTable.put("jin", "jinjin");

        System.out.println(hashTable.get("sung"));
        System.out.println(hashTable.get("jin"));
        System.out.println(hashTable.get("hee"));
        System.out.println(hashTable.get("min"));
        System.out.println(hashTable.get("choi"));
    }
}
