package todo;

public interface Visitor {
    void drawTask(CompositeTask task, int depth);
    void end(int depth);
}
class ConsoleVisitor implements Visitor{

    @Override
    public void drawTask(CompositeTask task, int depth) {
        String padding = "";
        for(int i = 0; i < depth ; i++){
            padding+= "〓";
        }
        System.out.println(padding+"["+ (task.getComplete() ? "v" : " ") +"] "
        + task.getTitle() + "(" + task.getDate() + ")");
    }

    @Override
    public void end(int depth) {}
}
class JsonVisitor implements Visitor{

    @Override
    public void drawTask(CompositeTask task, int depth) {
        String padding = getPadding(depth);
        System.out.println(padding+"{");
        System.out.println(padding+"    title: \"" + task.getTitle() + "\" ,");
        System.out.println(padding+"    date: \"" + task.getDate() + "\" ,");
        System.out.println(padding+"    isComplete: \"" + task.getComplete() + ",");
        System.out.println(padding+"    sub: [");
    }

    private String getPadding(int depth){
        String padding = "";
        for(int i = 0; i < depth ; i++){
            padding+= "  ";
        }
        return padding;
    }
    @Override
    public void end(int depth) {
        String padding = getPadding(depth);
        System.out.println(padding+"  ]");
        System.out.println(padding+"},");

    }
}
