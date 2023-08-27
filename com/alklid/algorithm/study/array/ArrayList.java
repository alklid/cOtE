package alklid.algorithm.study.array;

public class ArrayList {
    public static void main(String[] args) {
        alklid.structure.ArrayList arrayList
                = new alklid.structure.ArrayList();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.remove(4);

        System.out.println(arrayList.get(2));
        System.out.println(arrayList.get(4));
        System.out.println(arrayList.get(8)); // 9
        System.out.println(arrayList.get(12)); // Exception
    }
}
