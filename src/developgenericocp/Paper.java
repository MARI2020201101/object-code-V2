package developgenericocp;

interface Paper {
    Program[] run();
}

abstract class Client implements Paper{
    Library library = new Library("vueJS");
    Language language = new Language("kotilnJS");
    Programmer programmer;
}

abstract class ServerClient implements Paper{
    Server server = new Server("test");
    Language backendLanguage = new Language("java");
    Language frontendLanguage = new Language("javascript");
    Programmer backendProgrammer;
    Programmer frontendProgrammer;

}