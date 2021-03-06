package todo;

import java.util.function.Supplier;

class Renderer {
    private final Supplier<Visitor> factory;

    public Renderer(Supplier<Visitor> factory) {
        this.factory = factory;
    }
    public void render(TaskReport report){
        render(factory.get(),report, 0);
    }
    public void render(Visitor visitor, TaskReport report, int depth){
        visitor.drawTask(report.getTask(), depth);
        for(TaskReport r : report.getList()){
            render(visitor, r, depth+1);
        }
        visitor.end(depth);
    }
}
