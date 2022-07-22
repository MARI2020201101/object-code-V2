package developgeneric;

interface Paper<T extends Programmer> {
    void setData(T programmer);
}

class Client implements Paper<FrontEnd>{
    Library library = new Library("vueJS");
    Language language = new Language("kotilnJS");
    private Programmer programmer;

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }

    @Override
    public void setData(FrontEnd programmer) {
        programmer.setLanguage(language);
        programmer.setLibrary(library);
    }
}

class ServerClient implements Paper{ //Generic 이 두개 이상일 경우의 처리가 불가한 문제
    Server server = new Server("test");
    Language backendLanguage = new Language("java");
    Language frontendLanguage = new Language("javascript");
    private Programmer backendProgrammer;
    private Programmer frontendProgrammer;

    public void setBackendProgrammer(Programmer backendProgrammer) {
        this.backendProgrammer = backendProgrammer;
    }

    public void setFrontendProgrammer(Programmer frontendProgrammer) {
        this.frontendProgrammer = frontendProgrammer;
    }

    @Override
    public void setData(Programmer programmer) {
        if(programmer instanceof BackEnd){
            BackEnd backEnd = (BackEnd) programmer;
            backEnd.setServer(server);
            backEnd.setLanguage(backendLanguage);
        }else if(programmer instanceof FrontEnd){
            FrontEnd frontEnd = (FrontEnd) programmer;
            frontEnd.setLanguage(frontendLanguage);
        }

    }
}