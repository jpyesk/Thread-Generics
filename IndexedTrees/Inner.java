package IndexedTrees;

public class Inner<T> implements Node<T> {
    int rsize;
    int lsize;
    public Node<T> left;
    public Node<T> right;
    public Inner(Node<T> left,Node<T> right){
        this.left = left;
        this.right = right;
        this.rsize = right.size();
        this.lsize = left.size();

    }
    @Override
    public int size() {
        return this.rsize + this.lsize;
    }

    @Override
    public T get(int i) {
        return Iterate(this,i, this.size());

    }
    private T Iterate(Inner<T> node, int index, int count){
        count = node.size();
        if (index == count) return this.left.get(0);
        if (index < count) return Iterate((Inner<T>) node.right,index, count - node.lsize);
        else return Iterate((Inner<T>) node.left,index,count - node.lsize);

    }

    @Override
    public void update(int i, T x) {

    }

    @Override
    public Node<T> insert(int i, T x) {
        return null;
    }

    @Override
    public Node<T> remove(int i) {
        return null;
    }
}
