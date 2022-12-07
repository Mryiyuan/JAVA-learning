public class BinaryTree {
    public static void main(String[] args){
        BinaryTreeDemo b = new BinaryTreeDemo();
        //root node
        HeroNode root = new HeroNode(1,"刘备");
        b.setRoot(root);

        HeroNode node2 = new HeroNode(2,"张飞");
        HeroNode node3 = new HeroNode(3,"关羽");
        HeroNode node4 = new HeroNode(4,"吕布");
        HeroNode node5 = new HeroNode(5,"貂蝉");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);

        //遍历 前序遍历 12345
        System.out.println("-------------------------------------前序遍历---------------------------------------------");
        b.preOrder();

        //遍历 中序遍历 21435
        System.out.println("-------------------------------------中序遍历---------------------------------------------");
        b.Inorder();

        //遍历 后序遍历 24531
        System.out.println("-------------------------------------后序遍历---------------------------------------------");
        b.Postorder();

        //前序查找
        System.out.println("-------------------------------------前序查找---------------------------------------------");
        System.out.println(b.preOrderSearch(3));

        //中序查找
        System.out.println("-------------------------------------中序查找---------------------------------------------");
        System.out.println(b.inOrderSearch(3));

        //后序查找
        System.out.println("-------------------------------------后序查找---------------------------------------------");
        System.out.println(b.postOrderSearch(3));


    }
}

class BinaryTreeDemo{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }

    //前序
    public void preOrder(){
        if(this.root != null){
            this.root.PreorderTraversal();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序
    public void Inorder(){
        if(this.root != null){
            this.root.InorderTraversal();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序
    public void Postorder(){
        if(this.root != null){
            this.root.PostorderTraversal();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int id){

        if(root != null){
            return root.preOrderSearch(id);
        }else{
            return null;
        }
    }

    //中序查找
    public HeroNode inOrderSearch(int id){
        if(root != null){
            return root.inOrderSearch(id);
        }else{
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int id){
        if(root != null){
            return root.postOrderSearch(id);
        }else{
            return null;
        }
    }
    public void remove(int id){
        if(root != null){
            if(root.getId() == id){
                root =  null;
            }else{
            root.remove(id);}
        }else{
            System.out.println("null");
        }
    }
}
class HeroNode{
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //遍历节点，前序遍历，中序遍历，后序遍历
    //前序遍历DLR D为当前节点，L为左节点， R为右节点
    //用递归

    public void PreorderTraversal (){
        //输出当前节点
        System.out.println(this);
        //前序遍历，左子树
        if(this.left != null){
            this.left.PreorderTraversal ();
        }
        //前序遍历，右子树
        if(this.right != null){
            this.right.PreorderTraversal();
        }
    }

    //中序遍历 LDR
    public void InorderTraversal(){

        //中序遍历，左子树
        if(this.left != null){
            this.left.InorderTraversal();
        }
        //输出当前节点
        System.out.println(this);
        //中序遍历，右子树
        if(this.right != null){
            this.right.InorderTraversal();
        }
    }
    //Postorder Traversal LRD
    public void PostorderTraversal(){

        //后序遍历，左子树
        if(this.left != null){
            this.left.PostorderTraversal();
        }
        //后序遍历，右子树
        if(this.right != null){
            this.right.PostorderTraversal();
        }
        //输出当前节点
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int id){
        System.out.println(this.id);
        //判断当前节点是不是要找的节点
        if(this.id == id){
            return this;
        }
        //如果不等，判断当前节点左节点是否为空，如果不用为空，则递归查找
        HeroNode temp = null;
        if(this.left != null){
            temp = this.left.preOrderSearch(id);
        }
        //找到返回
        //如果没找到，遍历右节点
        if(temp != null){
            return temp;
        }

        //递归右节点
        if(this.right != null){
            temp = this.right.preOrderSearch(id);
        }
        return temp;
    }

    //中序查找
    public HeroNode inOrderSearch(int id){


        //如果不等，判断当前节点左节点是否为空，如果不用为空，则递归查找
        HeroNode temp = null;
        if(this.left != null){
            temp = this.left.inOrderSearch(id);
        }
        //找到返回
        //如果没找到，遍历右节点
        if(temp != null){
            return temp;
        }
        System.out.println(this.id);
        //判断当前节点是不是要找的节点
        if(this.id == id){
            return this;
        }

        //递归右节点
        if(this.right != null){
            temp = this.right.inOrderSearch(id);
        }
        return temp;
    }

    //后续查找
    public HeroNode postOrderSearch(int id){


        //如果不等，判断当前节点左节点是否为空，如果不用为空，则递归查找
        HeroNode temp = null;
        if(this.left != null){
            temp = this.left.postOrderSearch(id);
        }
        //找到返回
        //如果没找到，遍历右节点
        if(temp != null){
            return temp;
        }


        //递归右节点
        if(this.right != null){
            temp = this.right.postOrderSearch(id);
        }

        //判断当前节点是不是要找的节点
        System.out.println(this.id);
        if(this.id == id){
            return this;
        }
        return temp;
    }

    public void remove(int id){

        if(this.left != null && this.left.id == id){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.id == id){
            this.right = null;
            return;
        }
        if(this.left != null){
            this.left.remove(id);
        }
        if(this.right != null){
            this.right.remove(id);
        }
    }
}

