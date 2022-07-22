package develop;

interface Programmer {
    Program makeProgram(Paper paper);
}

class FrontEnd implements Programmer{
    private Library library ;
    private Language language ;
    @Override
    public Program makeProgram(Paper paper) {
        if(paper instanceof Client){
            Client pb= (Client) paper;
            this.language = pb.language;
            this.library = pb.library;
        }
        return makeFrontEndProgram();
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
        if(paper instanceof ServerClient){
            ServerClient sp = (ServerClient) paper;
            this.language = sp.backendLanguage;
            this.server = sp.server;
        }
        return makeBackEndProgram();
    }
    private Program makeBackEndProgram() {
        return new Program();
    }
}