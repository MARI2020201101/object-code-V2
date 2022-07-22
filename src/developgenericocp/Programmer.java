package developgenericocp;

abstract class Programmer<T extends Paper> {
    abstract Program makeProgram();
    abstract void setData(T paper);
    public Program getProgram(T paper){
        setData(paper);
        return makeProgram();
    }
}

abstract class FrontEnd<T extends Paper> extends Programmer<T>{
    protected Library library;
    protected Language language;

    @Override
    public Program makeProgram() {
        return new Program();
    }
}

abstract class BackEnd<T extends Paper> extends Programmer<T>{
    protected Server server;
    protected Language language ;

   @Override
    public Program makeProgram() {
        return new Program();
    }

}