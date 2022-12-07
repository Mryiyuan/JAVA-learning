public class Queue {
    public static void main(String[] args){
        QueueDemo Q = new QueueDemo(10);
        Q.addValue(1);
        Q.addValue(2);
        Q.addValue(3);
        Q.addValue(4);
        Q.showQueue();

    }
}
//数组模拟顺序队列
class QueueDemo{
    private int maxSize;//队列最大长度
    private int front;// 头指针
    private int rear;// 尾指针
    private int[] arr;

    public QueueDemo(int maxSize){
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        arr = new int[maxSize];

    }
    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return  front == rear;

    }

    //添加数据
    //从末尾添加
    public void addValue(int value){
        //判断是否满
        if(isFull()){
            System.out.println("full");
        }else{
            arr[rear] = value;
            rear++;
        }

    }
    //取出数据
    //从头取，一个一个取出

    public int extractValue(){
        //判断是否空
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }else{//从头取出
            return arr[front++];
        }
    }
    public void showQueue(){
        //判断是否空
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }else{//从头取出
            for(int i = 0; i < arr.length; i++){
                System.out.printf("arr[%d]=%d\n",i,arr[i]);

            }
        }
    }
    //展示front
    public int showHeadQueue(){
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }else{//从头取出
            return arr[front];

            }
    }
    //展示rear
    public int showRearQueue(){
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }else{//从头取出
            return arr[rear];

        }
    }

}