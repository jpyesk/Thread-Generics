package IndexedTrees;

public class Main {
    public static void main(String[] args) {
//        IndexedTree t = new IndexedTree<String>();
        Node<String> t = new Inner<String>(new Inner<>("2"),new Node<String>("4"));
//        for (String s: args) t.insert(0,s);
//        var n = t.size();
//        System.out.println(n);
//        for(Object s: t) System.out.println(s);
//        for (int i = n-1; i >=0 ;i--){
//            System.out.println(t.get(i));
//            t.remove(i);
//        }
//        System.out.println(t.size());
    }
}
