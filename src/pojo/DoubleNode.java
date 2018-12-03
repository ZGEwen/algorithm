package pojo;

/**
 * @Classname DoubleNode
 * @Created by zgw
 * @Date 2018-12-03 12:54
 * @Description TODO
 */
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }
}
