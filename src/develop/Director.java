package develop;

import java.util.HashMap;
import java.util.Map;

class Director {
    private Map<String, Paper> projects = new HashMap<>();
    public void addProject(String name, Paper paper){
        projects.put(name, paper);
    }
    public void runProject(String name){
        if(! projects.containsKey(name)) throw new RuntimeException("No Project");
        Paper paper = projects.get(name);
        if(paper instanceof ServerClient){
            ServerClient project = (ServerClient) paper;
            Programmer frontEnd = new FrontEnd();
            Programmer backEnd = new BackEnd();
            project.setFrontendProgrammer(frontEnd);
            project.setBackendProgrammer(backEnd);
            Program client = frontEnd.makeProgram(paper);
            Program server = backEnd.makeProgram(paper);
            deploy(name, client, server);
        }else if(paper instanceof Client){
            Client project = (Client) paper;
            Programmer frontEnd = new FrontEnd();
            project.setProgrammer(frontEnd);
            Program program = frontEnd.makeProgram(paper);
            deploy(name, program);
        }
    }

    private void deploy(String projectName, Program ...programs) {
    }
}
