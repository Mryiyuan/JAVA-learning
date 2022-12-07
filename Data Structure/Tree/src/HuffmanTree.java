import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {7, 5, 2, 4};
        Node root = createHuffmanTree(arr);
        preOrder(root);

    }
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("null tree");
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<Node>();
        for (int weight : arr) {
            nodes.add(new Node(weight));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parentNode = new Node(leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parentNode);

        }

        return nodes.get(0);
    }
}

//collection进行排序
class Node implements Comparable<Node> {
    //node wight
    int weight;

    Node right;
    Node left;

    public Node(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

}