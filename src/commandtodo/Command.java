package commandtodo;

import java.time.LocalDateTime;

interface Command {
    void execute(CompositeTask task);
    void undo(CompositeTask task);
}

class Toggle implements Command{
    @Override
    public void execute(CompositeTask task) {
        task.toggle();
    }
    @Override
    public void undo(CompositeTask task) {
        task.toggle();
    }
}

class Title implements Command{
    private final String title;
    private String oldTitle;
    public Title(String title) {
        this.title =title;
    }
    @Override
    public void execute(CompositeTask task) {
        this.oldTitle = task.getTitle();
        task.setTitle(title);
    }
    @Override
    public void undo(CompositeTask task) {
        task.setTitle(oldTitle);
    }
}
class Date implements Command{
    private final LocalDateTime date;
    private LocalDateTime oldDate;

    public Date(LocalDateTime date) {
        this.date = date;
    }
    @Override
    public void execute(CompositeTask task) {
        this.oldDate = task.getDate();
        task.setDate(date);
    }
    @Override
    public void undo(CompositeTask task) {
        task.setDate(oldDate);
    }
}
class Add implements Command{
    private final String title;
    private final LocalDateTime date;
    private  CompositeTask oldTask;

    public Add(String title, LocalDateTime date) {
        this.title = title;
        this.date = date;
    }

    @Override
    public void execute(CompositeTask task) {
        oldTask = task.addTask(title, date);
    }

    @Override
    public void undo(CompositeTask task) {
        task.removeTask(oldTask);
    }
}
class Remove implements Command{
    private final CompositeTask baseTask;
    private String  oldTitle;
    private LocalDateTime oldDate;

    public Remove(CompositeTask task) {
        this.baseTask = task;
    }

    @Override
    public void execute(CompositeTask task) {
        oldTitle = task.getTitle();
        oldDate = task.getDate();
        task.removeTask(baseTask);
    }

    @Override
    public void undo(CompositeTask task) {
        task.addTask(oldTitle, oldDate);
    }
}