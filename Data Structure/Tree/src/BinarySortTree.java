public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {8, 3, 6, 4, 7, 1, 10, 14, 13};
        BinarySortTreeDemo bst = new BinarySortTreeDemo();
        for (int i = 0; i < arr.length; i++) {
            bst.add(new Node1(arr[i]));
        }

        bst.removeNode(13);
        bst.infixOrder();

    }
}

class BinarySortTreeDemo {
    private Node1 root;

    //    public BinarySortTreeDemo(Node1 root){
//        this.root=root;
//    }
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("null");
        }

    }

    public void add(Node1 node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }

    }

    public Node1 search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node1 searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public int RemoveMin(Node1 node) {
        Node1 targetNode = node;
        while (targetNode.left != null) {
            targetNode = targetNode.left;
        }
        removeNode(targetNode.value);
        return targetNode.value;

    }

    public void removeNode(int value) {
        if (root == null) {
            return;
        } else {
            Node1 targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            Node1 parent = searchParent(value);
            //target节点左右为空 直接删除
            if (targetNode.left == null && targetNode.right == null) {
               if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                int minvalue = RemoveMin(targetNode.right);
                targetNode.value = minvalue;
            } else {
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;

                        }
                    } else {
                        root = targetNode.left ;
                    }
                } else {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }

                }

            }
        }
    }
}

class Node1 {
    int value;
    Node1 left;
    Node1 right;

    public Node1(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }

    }
    public void add(Node1 node) {
        //需要一个头节点，否则直接返回
        if (node == null) {
            return;
        }
        if (this.value > node.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //find the node we want to del
    public Node1 search(int value) {
        if (this.value == value) {
            return this;
        } else if (this.value > value) {
            //判断当前节点的左子节点是否为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //然后找到删除的父节点
    public Node1 searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        } else {
            if (this.left != null && this.value > value) {
                return this.left.searchParent(value);
            } else if (this.right != null && this.value <= value) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }


}