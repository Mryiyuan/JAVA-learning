import java.util.Stack;

public class SingleLinkedList{
    public static void main(String args[]){
        SingleLinkedListDemo s = new SingleLinkedListDemo();
        HeroNode node1 = new HeroNode(1,"刘备");
        HeroNode node2 = new HeroNode(2,"关羽");
        HeroNode node3 = new HeroNode(3,"张飞");
        s.addHeroNode(node1);
        s.addHeroNode(node2);
        s.addHeroNode(node3);
        //s.showLinkedList(s.getHead());

       // s.updateSingleLinkedList(new HeroNode(2,"guanyu"));
        //s.showLinkedList(s.getHead());

        //s.deleteLinkedlist(2);
        s.insertSingleLinkedList((new HeroNode(4,"111")));
        s.showLinkedList(s.getHead());
//        System.out.println(s.traverse(s.getHead()));
//        s.daoshuKthnode(s.getHead(),1);
//        s.daoshuKthnode(s.getHead(),2);
//        s.daoshuKthnode(s.getHead(),3);
//        s.daoshuKthnode(s.getHead(),4);
        //s.listReverse(s.getHead());
        //s.showLinkedList(s.getHead());
        s.ListReverseByStack(s.getHead());
        SingleLinkedListDemo s1 = new SingleLinkedListDemo();
        HeroNode node15 = new HeroNode(15,"1556");
        HeroNode node23 = new HeroNode(23,"154");
        HeroNode node35 = new HeroNode(35,"987");
        s1.addHeroNode(node15);
        s1.addHeroNode(node23);
        s1.addHeroNode(node35);
        s1.showLinkedList(s1.getHead());
        //合并
        System.out.println("--------------------------------------------------------------------------");



        s.mergeList(s.getHead(),s1.getHead());
    }
}

class SingleLinkedListDemo{
    private  HeroNode head = new HeroNode(0, "");//head node
    //the head node is helped look for
    //so we shold have a method to get head node
    public HeroNode getHead(){
        return head;
    }
    public void addHeroNode(HeroNode heronode) {
        //cus headnode is stable, we need a temp node to traverse
        HeroNode temp = head;
        // we should add the element to the tail of list, so we need find the tail of the list
        while (true){
            if (temp.next == null){
                break;
        }
        temp = temp.next;
        }
        temp.next = heronode;
    }

    //show the list
    public void showLinkedList(HeroNode head){
        if (head.next == null){
            System.out.println("list is null");
            return;
        }
        //cus headnode is stable, we need a temp node to traverse
        HeroNode temp = head.next;
        while(true){
            if (temp == null) {
                break;
            }System.out.println(temp);
            temp = temp.next;

        }
    }
    //change the list node data
    //temp.id= heronode.id temp.name= heronode.name
    public void updateSingleLinkedList(HeroNode heronode){
        //temp是现有node, heronode是新node
        if (head.next == null){
            System.out.println("list is empty");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        //if found the node
        while(true){

            if(temp.id == heronode.id) {
                flag = true;
                break;
            }
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }


        if (flag){
            temp.name = heronode.name;
        }else{
            System.out.println("not found the data that the id is " + heronode.id );
        }
    }

    public void insertSingleLinkedList(HeroNode heronode){

        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if (temp.next == null){
                flag = true;
                break;
            }else if(temp.next.id > heronode.id){
                flag = true;
                break;
            } else if (temp.next.id == heronode.id) {
                break;
            }
            temp = temp.next;
        }
        if(flag){
            heronode.next = temp.next;
            temp.next = heronode;
        }else{
            System.out.println("repeat");
        }
    }
    public void deleteLinkedlist(int id) {

        HeroNode temp = head;
        boolean flag = false;
        // found the dai shangchu node de prev node;
        while(true){
            //yijing bianli dao zuihou xuyao tui chu xun huan
            if(temp.next == null){
                break;
            }
            if(temp.next.id == id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next =  temp.next.next;
        }else{
            System.out.println("not found the id is " + id);
        }
    }
    public  int traverse(HeroNode heronode){
        HeroNode temp = head;
        //boolean flag = false;
        int count = 0;
        while(true){
            if(temp.next == null){
                break;
            }else{
                count++;
                temp=temp.next;
            }
        }
        //System.out.println(count);
        return count;
    }
    public void daoshuKthnode(HeroNode heroNode, int n){
        HeroNode temp = head;
        int length = traverse((getHead()));

            if(temp.next == null){
                System.out.println("ooooooo") ;
            }else if(n > length || n <= 0){
                System.out.println("1111111");
            }else{
                for(int j = 1; j < length - n + 1; j++){
                    temp = temp.next;
                }
            }
            temp = temp.next;
        System.out.println(temp);
    }
    public  void listReverse(HeroNode heronode){
        //列表反转：新建一个头节点 然后指针改变
        HeroNode temp = head;//原有指针
        HeroNode reseverHead = new HeroNode(0,"");
        HeroNode next = null;
        if(head.next==null||head.next.next==null){
            return;
        }
        while(temp.next!=null){
            next = temp.next.next;
            temp.next.next=reseverHead.next;
            reseverHead.next = temp.next;
            temp.next = next;
        }
        head.next = reseverHead.next;

    }
    public void ListReverseByStack(HeroNode head){
        if(head.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode temp = head.next;
        while (temp != null){
            stack.push(temp);
            temp=temp.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }
    //两个链表合并
    public void mergeList(HeroNode head1, HeroNode head2){
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;

        //新头节点
        HeroNode head3 = new HeroNode(0,"");
        HeroNode temp3 = head3;

        while (temp1 != null || temp2 != null){
            if(temp1 != null && temp2 == null){
                temp3.next = temp1;
                temp1  = temp1.next;
            } else if (temp1 == null && temp2 != null) {
                temp3.next = temp2;
                temp2 = temp2.next;
            } else {
                if(temp1.id < temp2.id){
                    temp3.next = temp1;
                    temp1 = temp1.next;
                }else{
                    temp3.next = temp2;
                    temp2 = temp2.next;
                }
            }
            temp3 = temp3.next;
        }
        SingleLinkedListDemo s = new SingleLinkedListDemo();
        s.showLinkedList(head3);
    }
    public void reOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(head.next == null){
                flag = true;
                break;
            } else if (temp.next.id > heroNode.id) {
                flag= true;
                break;
            }else if(temp.next.id == heroNode.id){
                break;
            }
            temp = temp.next;
        }
        if(flag){
            heroNode.next = temp.next;
            temp.next = heroNode;
        }else{
            System.out.println("id is repeated");
        }
    }
}

class HeroNode{
    public int id;
    public  String name;
    public HeroNode next;//point the next node

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}