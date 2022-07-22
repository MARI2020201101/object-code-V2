package developgeneric;

interface Programmer {
    Program makeProgram(Paper paper);
}

class FrontEnd implements Programmer{
    private Library library ;
    private Language language ;
    @Override
    public Program makeProgram(Paper paper) {
        paper.setData(this);
        return makeFrontEndProgram();
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    private Program makeFrontEndProgram() {
        return new Program();
    }
}

class BackEnd implements Programmer{
    private Server server;
    private Language language ;
    @Override
    public Program makeProgram(Paper paper) {
        paper.setData(this);
        return makeBackEndProgram();
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    private Program makeBackEndProgram() {
        return new Program();
    }
}