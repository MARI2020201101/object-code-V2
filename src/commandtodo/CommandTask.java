package commandtodo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class CommandTask {
    private final CompositeTask task;
    private List<Command> commands = new ArrayList<>();
    private int cursor = 0;
    private final Map<String, String> saved = new HashMap<>();

    public void save(String key){
        JsonVisitor jsonVisitor = new JsonVisitor();
        Renderer renderer = new Renderer(()->jsonVisitor);
        renderer.render(task.getReport(CompositeSortType.TITLE_ASC));
        saved.put(key, jsonVisitor.getResult());
    }
    public void load(String key){
        String savedJson = saved.get(key);
        System.out.println(savedJson);
    }
    public void undo(){
        if(cursor < 0) return;
        commands.get(cursor--).undo(task);
    }
    public void redo(){
        if(cursor == commands.size()-1) return;
        commands.get(++cursor).execute(task);
    }
    public CommandTask(String title, LocalDateTime date) {
        task = new CompositeTask(title, date);
    }
    private void addCommand(Command cmd){
        for(int i = commands.size()-1; i > cursor ; i--){
            commands.remove(i);
        }
        cmd.execute(task);
        commands.add(cmd);
        cursor = commands.size() - 1;
    }
    public void toggle(){
        addCommand(new Toggle());//Toggle 이라는 명령을 객체로 만들었음.
    }
    public String getTitle() {
        return task.getTitle();// 상속쓰지 않고 위임을 통해 get 계열 메서드는 넘겼음.
    }
    public void setTitle(String title) {
        addCommand(new Title(title));
    }
    public LocalDateTime getDate() {
        return task.getDate();
    }
    public void setDate(LocalDateTime date) {
        addCommand(new Date(date));
    }
    public Boolean getComplete() {
        return task.getComplete();
    }
    public void removeTask(CompositeTask task){
        addCommand(new Remove(task));
    }
    public void addTask(String title, LocalDateTime date){
        addCommand(new Add(title, date));
    }

    public TaskReport getReport(CompositeSortType type){
        return task.getReport(type);
    }
}
