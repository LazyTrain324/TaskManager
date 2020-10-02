package taskManager;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskArrayList {
    Task taskArray[];
    int size=0;
    int capacity;
    TaskArrayList(){
        capacity = 10;
        Task taskArray[] = new Task[10];
    }
    TaskArrayList(int arrayCapacity){
        if(arrayCapacity>capacity){
            capacity = arrayCapacity;
        }
        Task taskArray[] = new Task[capacity];
    }
    void add(Task task){
        try {
            taskArray[size]=task;
            size++;
        }catch (ArrayIndexOutOfBoundsException ex){
            capacity = capacity + (capacity >> 1);
            taskArray = Arrays.copyOf(taskArray,capacity);
            taskArray[size]=task;
            size++;
        }
    }
    boolean removeIndexOf(int index){
        if(index<size){
            for(int j=index+1;j<size;j++,index++){
                taskArray[index]=taskArray[j];
            }
            size--;
            return true;
        }else {
            return false;
        }
    }
    boolean remove(Task task){
        for(int i=0; i<size;i++){
            if(task==taskArray[i]){
                return removeIndexOf(i);
            }
        }
        return false;
    }
    int size(){
        return size;
    }
    Task getTask(int index){
        return taskArray[index];
    }
    TaskArrayList incoming(int from, int to){
        TaskArrayList arrayListTemperary = new TaskArrayList();
        for(int i=0; i<size; i++){
            if(taskArray[i].nextTimeAfter(from)<to&&taskArray[i].nextTimeAfter(from)!=-1){
                arrayListTemperary.add(taskArray[i]);
            }
        }
        return arrayListTemperary;
    }

    
}
