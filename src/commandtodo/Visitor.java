package commandtodo;

interface Visitor {
    void drawTask(CompositeTask task, int depth);
    void end(int depth, boolean isEnd);
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
    public void end(int depth, boolean isEnd) {}
}

class JsonVisitor implements Visitor{
    private String result = "";

    @Override
    public void drawTask(CompositeTask task, int depth) {
        result+="{";
        result+="    title: \"" + task.getTitle() + "\",\n";
        result+="    date: \"" + task.getDate() + "\",\n";
        result+="    isComplete: \"" + task.getComplete() + ",\n";
        result+="    sub: [\n";
    }

    @Override
    public void end(int depth, boolean isEnd) {
        result+="  ]\n";
        result+="}\n";
        if(!isEnd) result+=",";
    }

    public String getResult() {
        return result;
    }
}
