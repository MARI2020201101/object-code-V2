package developgenericocp;

class Main {
    public static void main(String[] args) {
        Director director = new Director();
        String projectName ="정기권 개편";
        String projectName2 ="멤버스 개편";
        director.addProject(
                projectName,
                new Client() {
                    @Override
                    public Program[] run() {
                        FrontEnd frontEnd = new FrontEnd<Client>() {
                            @Override
                            void setData(Client paper) {
                                library = paper.library;
                                language = paper.language;
                            }
                        };
                        programmer = frontEnd;
                        return new Program[]{frontEnd.getProgram(this)};
                    }
                });
        director.addProject(
                projectName2,
                new ServerClient() {
                    @Override
                    public Program[] run() {
                        Programmer backend = new BackEnd<ServerClient>() {
                            @Override
                            void setData(ServerClient paper) {
                                server = paper.server;
                                language = paper.backendLanguage;
                            }
                        };
                        Programmer frontEnd = new FrontEnd<ServerClient>() {
                            @Override
                            void setData(ServerClient paper) {
                                language = paper.frontendLanguage;
                            }
                        };
                        backendProgrammer = backend;
                        frontendProgrammer = frontEnd;
                        return new Program[]{
                                backend.getProgram(this)
                                , frontEnd.getProgram(this)};
                    }
                });
        director.runProject(projectName);
        director.runProject(projectName2);
    }

}
