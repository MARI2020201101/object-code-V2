package develop;

interface Paper {
}
class Client implements Paper{
    Library library = new Library("vueJS");
    Language language = new Language("kotilnJS");
    private Programmer programmer;

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }
}
class ServerClient implements Paper{
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
}