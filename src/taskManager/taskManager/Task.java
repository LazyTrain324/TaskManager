package taskManager;

public class Task {
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeated;

    Task(String title, int time){
        this.title = title;
        this.time = time;
    }
    Task(String title, int start, int end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    String getTitle(){
        return title;
    }

    void setTitle(String title){
        this.title = title;
    }

    boolean isActive(){
        return active;
    }

    void setActive(boolean active){
        this.active = active;
    }

    int getTime(){
        return isRepeated()?time:start;
    }

    void setTime(int time){
        this.time = time;
        repeated = false;

    }

    int getStartTime(){
        return isRepeated()?start:time;
    }

    int getEndTime(){
        return isRepeated()?end:time;
    }

    int getRepeatInterval(){
        return isRepeated()?interval:0;
    }

    void setTime(int start, int end, int interval){
        this.start = start;
        this.end = end;
        this.interval = interval;
        repeated = true;
    }

    boolean isRepeated(){
        return repeated;
    }

    int nextTimeAfter(int current){
        if(isRepeated()){
            for(int i = getStartTime(); i < getEndTime(); i += getRepeatInterval()){
                if (current<i){
                    return i;
                }
            }
            return -1;
        }else{
            return time>current?time:-1;
        }
    }
}
