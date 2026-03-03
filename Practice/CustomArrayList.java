package Practice;
import java.util.*;
public class CustomArrayList {
    private int[] data;
    private int default_size=10;
    private int size=0;
    public CustomArrayList(){
        this.data=new int[default_size];
    }
    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++]=num;
    }
    private void resize() {
        int[] temp=new int[data.length*2];
        //copy the current items in the new array
        for(int i=0;i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }

    private boolean isFull() {
       return size==data.length;
    }
    private int remove(){
        size=size-1;
        return data[size];
    }
    public int get(int index){
        return data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index,int value){
        data[index]=value;
    }
    public String toString(){
        return Arrays.toString(data);
    }
    public static void main(String[] args) {
        CustomArrayList list=new CustomArrayList();
        list.add(3);
        list.add(33);
        list.add(333);
        list.add(3333);
        list.add(33333);
        System.out.println(list);
        ArrayList l=new ArrayList<>();
        l.add("1");
        l.add(2);
        l.add('c');
        System.out.println(l);
    }
}
