package commandtodo;



import java.time.LocalDateTime;
import java.util.List;

class Main {
    public static void main(String[] args) {
        CommandTask root = new CommandTask("root", LocalDateTime.now());
        root.addTask("sub1", LocalDateTime.now());
        root.addTask("sub2", LocalDateTime.now());

//        Renderer renderer = new Renderer(JsonVisitor::new);
//        renderer.render(root.getReport(CompositeSortType.TITLE_ASC));
//        root.undo();
//        renderer.render(root.getReport(CompositeSortType.TITLE_ASC));
//        root.undo();
//        renderer.render(root.getReport(CompositeSortType.TITLE_ASC));
//        root.redo();
//        renderer.render(root.getReport(CompositeSortType.TITLE_ASC));

        root.save("root");
        System.out.println("----");
        root.load("root");
    }
}
