package developgenericocp;

import java.util.HashMap;
import java.util.Map;

class Director {
    private Map<String, Paper> projects = new HashMap<>();
    public void addProject(String name, Paper paper){
        projects.put(name, paper);
    }
//    public void runProject(String name){
//        if(! projects.containsKey(name)) throw new RuntimeException("No Project");
//        Paper paper = projects.get(name);
//        if(paper instanceof ServerClient){
//            ServerClient project = (ServerClient) paper;
//            Programmer frontEnd = new FrontEnd<ServerClient>() {
//                @Override
//                void setData(ServerClient paper) {
//                    language = paper.frontendLanguage;
//                }
//            };
//            Programmer backEnd = new BackEnd<ServerClient>(){
//                @Override
//                void setData(ServerClient paper) {
//                    language = paper.backendLanguage;
//                    server = paper.server;
//                }
//            };
//            project.setFrontendProgrammer(frontEnd);
//            project.setBackendProgrammer(backEnd);
//            deploy(name, frontEnd.getProgram(paper), backEnd.getProgram(paper));
//
//        } else if(paper instanceof Client){
//            Client project = (Client) paper;
//            Programmer frontEnd = new FrontEnd<Client>() {
//                @Override
//                void setData(Client paper) {
//                    language = paper.language;
//                    library = paper.library;
//                }
//            };
//            project.setProgrammer(frontEnd);
//            deploy(name, frontEnd.getProgram(paper));
//        }
//    }
    public void runProject(String name){
        if(! projects.containsKey(name)) throw new RuntimeException("No Project");
        Paper paper = projects.get(name);
        deploy(name, paper.run());
    }
    private void deploy(String projectName, Program...programs) {
    }
}
