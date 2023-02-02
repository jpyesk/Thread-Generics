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
    public T get(int i)
    {
        return Iterate(this, i + 1);
    }
    private T Iterate(Node<T> inner1, int index)
    {
        var inner = (Inner<T>)inner1;
//        var count = inner.size();
//        if (index == count) return inner.Right.get(0);
//        if (index < count) return Iterate(inner.Left, index);
//        if (index > count) return Iterate(inner.Right, index - inner.Left.size());

        var count = inner.size();
        if (index == count) return inner.right.get(0);
        if (count == 2)
        {
            if (index == 1) return inner.left.get(0);
            if (index == 2) return inner.right.get(0);
        }
        if (index < count)
        {
            return Iterate(inner.left, index);
        }
        return Iterate(inner.right, index - inner.left.size());
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
