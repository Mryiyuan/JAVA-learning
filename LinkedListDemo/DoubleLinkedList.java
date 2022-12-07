import java.util.Stack;

public class DoubleLinkedList {
    public static void main(String args[]){
        DoubleLinkedListDemo d  = new DoubleLinkedListDemo();
        HeroNode2 node1 = new HeroNode2(1,"刘备");
        HeroNode2 node2 = new HeroNode2(2,"关羽");
        HeroNode2 node3 = new HeroNode2(3,"张飞");
        HeroNode2 node4 = new HeroNode2(4,"夏侯惇");

        d.addHeroNode(node1);
        d.addHeroNode(node2);
        d.addHeroNode(node3);
        d.addHeroNode(node4);
        d.showLinkedList(d.getHead());
        System.out.println("-------------update2nd-----------------------------------------");
        d.updateSingleLinkedList(new HeroNode2(2,"guanyu"));
        d.showLinkedList(d.getHead());
        System.out.println("-----------delete4th-------------------------------------------");
        d.deleteLinkedlist(4);
        d.showLinkedList(d.getHead());
        System.out.println("-----------insert4th-------------------------------------------");
        d.insertDoubleLinkedList(new HeroNode2(4,"刘备"));
        d.showLinkedList(d.getHead());
        System.out.println("-----------reorder-------------------------------------------");
        DoubleLinkedListDemo d1  = new DoubleLinkedListDemo();
        HeroNode2 node11 = new HeroNode2(1,"刘备");
        HeroNode2 node22 = new HeroNode2(2,"关羽");
        HeroNode2 node33 = new HeroNode2(3,"张飞");
        HeroNode2 node44 = new HeroNode2(4,"夏侯惇");
        d1.reOrder(node22);
        d1.reOrder(node11);
        d1.reOrder(node44);
        d1.reOrder(node33);
        d1.showLinkedList(d1.getHead());


    }
}

class DoubleLinkedListDemo{
    private  HeroNode2 head = new HeroNode2(0, "");//head node
    //the head node is helped look for
    //so we shold have a method to get head node
    public HeroNode2 getHead(){
        return head;
    }
    public void addHeroNode(HeroNode2 heroNode2) {
        //cus headnode is stable, we need a temp node to traverse
        HeroNode2 temp = head;
        // we should add the element to the tail of list, so we need find the tail of the list
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.prev = temp;//加入的node的next-->后,prev-->前
    }

    //show the list
    public void showLinkedList(HeroNode2 head){
        if (head.next == null){
            System.out.println("list is null");
            return;
        }
        //cus headnode is stable, we need a temp node to traverse
        HeroNode2 temp = head.next;
        while(true){
            if (temp == null) {
                break;
            }System.out.println(temp);
            temp = temp.next;

        }
    }
    //change the list node data
    //temp.id= heronode.id temp.name= heronode.name
    public void updateSingleLinkedList(HeroNode2 heroNode2){
        //temp是现有node, heronode是新node
        if (head.next == null){
            System.out.println("list is empty");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        //if found the node
        while(true){

            if(temp.id == heroNode2.id) {

                flag = true;
                break;
            }
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }


        if (flag){
            temp.name = heroNode2.name;
        }else{
            System.out.println("not found the data that the id is " + heroNode2.id );
        }
    }

    public void insertDoubleLinkedList(HeroNode2 heroNode2){

        HeroNode2 temp = head;
        boolean flag = false;
        while(true){
            if (temp.next == null){
                flag = true;
                break;
            }else if(temp.next.id > heroNode2.id){
                flag = true;
                break;
            } else if (temp.next.id == heroNode2.id) {
                break;
            }
            temp = temp.next;
        }
        if(flag){
            heroNode2.next = temp.next;
            temp.next = heroNode2;
        }else{
            System.out.println("repeat");
        }
    }
    public void deleteLinkedlist(int id) {

        HeroNode2 temp = head.next;
        boolean flag = false;
        // found the dai shangchu node de prev node;
        while(true){
            //yijing bianli dao zuihou xuyao tui chu xun huan
            if(temp == null){
                break;
            }
            if(temp.id == id){
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if(flag){
            temp.prev.next =  temp.next;
            if(temp.next!=null){
                temp.next.prev = temp.prev;
            }
        }else{
            System.out.println("not found the id is " + id);
        }
    }
    public void reOrder(HeroNode2 heroNode){
        HeroNode2 temp = head;
        boolean flag = false;
        while(true){
            if(temp  .next == null){
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
            if(temp.next!=null){
                heroNode.next = temp.next;
                temp.next = heroNode;
                heroNode.prev = temp;
                heroNode.next.prev = heroNode;
            }else{//第一个数据直接插入
                temp.next = heroNode;
                heroNode.prev = temp;
            }
        }else{
            System.out.println("id is repeated");
        }
    }
    public  int traverse(HeroNode2 heroNode2){
        HeroNode2 temp = head;
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
    public void daoshuKthnode(HeroNode2 heroNode2, int n){
        HeroNode2 temp = head;
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
    public  void listReverse(HeroNode2 heroNode2){
        //列表反转：新建一个头节点 然后指针改变
        HeroNode2 temp = head;//原有指针
        HeroNode2 reseverHead = new HeroNode2(0,"");
        HeroNode2 next = null;
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
    public void ListReverseByStack(HeroNode2 head){
        if(head.next == null){
            return;
        }
        Stack<HeroNode2> stack = new Stack<HeroNode2>();
        HeroNode2 temp = head.next;
        while (temp != null){
            stack.push(temp);
            temp=temp.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }

    }
    //两个链表合并
    public void mergeList(HeroNode2 head1, HeroNode2 head2){
        HeroNode2 temp1 = head1.next;
        HeroNode2 temp2 = head2.next;

        //新头节点
        HeroNode2 head3 = new HeroNode2(0,"");
        HeroNode2 temp3 = head3;

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
       DoubleLinkedListDemo d = new DoubleLinkedListDemo();
        d.showLinkedList(head3);
    }

}

class HeroNode2{
    public int id;
    public  String name;
    public HeroNode2 next;//point the next node
    public HeroNode2 prev;

    public HeroNode2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +

                '}';
    }
}
