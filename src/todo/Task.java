package todo;

import java.time.LocalDateTime;

class Task {
    private String title;
    private LocalDateTime date;
    private Boolean isComplete=false;

    public Task(String title, LocalDateTime date) {
        this.title = title;
        this.date = date;
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
}
