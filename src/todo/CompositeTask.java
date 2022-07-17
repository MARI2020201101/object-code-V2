package todo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class CompositeTask {
    // Task, Tasks 무시
    // 얘가 둘다 역할한다. 리프이자 노드역할.

    private String title;
    private LocalDateTime date;
    private Boolean isComplete=false;
    private final Set<CompositeTask> list = new HashSet<>();

    public CompositeTask(String title, LocalDateTime date) {
        setTitle(title);
        setDate(date);
    }
    public void toggle(){
        isComplete = !isComplete;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void removeTask(CompositeTask task){
        list.remove(task);
    }
    public void addTask(String title, LocalDateTime date){
        list.add(new CompositeTask(title,date));
    }
    public TaskReport getReport(CompositeSortType type){
        TaskReport report = new TaskReport(this);
        for(CompositeTask t : list){
            report.add(t.getReport(type));//서브리스트들이 재귀적으로 호출된다.
        }
        return report;
    }
}
