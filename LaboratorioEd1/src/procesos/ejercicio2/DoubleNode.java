package procesos.ejercicio2;

public class DoubleNode {
    private int data;
    private DoubleNode left, right;
    
    public DoubleNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public int getData() {
        return data;
    }
    public DoubleNode getLeft() {
        return left;
    }
    public DoubleNode getRight() {
        return right;
    }
    public void setData(int data) {
        this.data = data;
    }
    public void setLeft(DoubleNode left) {
        this.left = left;
    }
    public void setRight(DoubleNode right) {
        this.right = right;
    }
}
