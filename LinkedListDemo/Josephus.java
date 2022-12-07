//circle list

public class Josephus {
    public static void main(String args[]){
        CircleLinkedList c = new CircleLinkedList();
        c.addPeopleLinkslist(10);
        c.showPeople();

    }
}

class CircleLinkedList{
    //代表一个节点
    private People first = null;

    //to make sure how many people we should have, then create the Circle Linked list
    public void addPeopleLinkslist(int nums){
        if(nums <= 0){
            System.out.println("nums is wrong");
            return;
        }
        //def temp
        People tempPeople = null;
        for (int i = 1; i <= nums; i++){
            People people = new People(i);
            if(i == 1){
                first = people;
                first.setNext(first);
                tempPeople = first;
            }else{
                tempPeople.setNext(people);
                people.setNext(first);
                tempPeople = people;
            }
        }

    }
    //遍历显示列表
    public void showPeople(){
        People tempPeople = first;
        while(true){
            System.out.println(tempPeople.getId());
            //遍历一圈 到起点
            if(tempPeople.getNext() ==  first){
                break;
            }
        tempPeople = tempPeople.getNext();
        }
    }
}
class People{
     private int id;
     private  People next;

    public People(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public People getNext() {
        return next;
    }

    public void setNext(People next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", next=" + next +
                '}';
    }
}