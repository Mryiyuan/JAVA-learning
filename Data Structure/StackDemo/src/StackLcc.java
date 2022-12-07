public class StackLcc {
    public static void main(String[] args){
        StackDemo sd = new StackDemo(5);
        sd.push(5);
        sd.showStack();
        sd.pop();
        sd.showStack();
    }
}
class StackDemo{
    //栈的大小
    private int maxSize;
    //需要一个数组模拟
    private int[] stack;
    //top 指针
    private int top = -1;

    public StackDemo(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];

    }
    //判断是否满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    //判断是否空
    public boolean isEmpty(){
        return top == -1;
    }
    //入栈
    public void push(int value){
        if(isFull()){
            System.out.println("man");
            return;
        }
        top++;
        stack[top]= value;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("empty");

        }
        int value = stack[top];
        top--;
        return value;
    }
    public void showStack(){
        if(isEmpty()){
            System.out.println("empty");
        }
        for(int i =top;i >= 0; i--){
            System.out.println(stack[i]);

        }

        }
    }
