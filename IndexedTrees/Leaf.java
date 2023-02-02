package IndexedTrees;


public class Leaf<T> implements Node<T> {
    T value;
    public Leaf(T value){
        this.value = value;
    }
    @Override
    public int size() {
        return 1;
    }

    @Override
    public T get(int i) {
        if (i == 0) return this.value;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void update(int i, T x) {
        if (i == 0) {
            this.value = x;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Node<T> insert(int i, T x)
    {
        if (i <= 0) {
            return new Inner<T>(new Leaf<T>(x),new Leaf<T>(this.value));
        } else {
            return new Inner<T>(new Leaf<T>(this.value),new Leaf<T>(x));
        }
    }


    @Override
    public Node<T> remove(int i) {
        if (i == 0) {
            return null;
        }
        throw new IndexOutOfBoundsException();
    }
}

