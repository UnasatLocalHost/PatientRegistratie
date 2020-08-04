package sr.unasat.patient.app;

import sr.unasat.patient.service.Services;

import static sr.unasat.patient.service.Services.Main.convert;

public class Application {
    public static void main(String[] args) {
        Services.Node root  = new Services.Node(1,"Marc Codrington");
        root.left = new Services.Node(2,"Bruce Wayne");
        root.right = new Services.Node(3,"Clark Kent");
        root.left.left = new Services.Node(4,"Jessica Jones");
        root.left.right = new Services.Node(5,"Electra Natchios");
        root.right.left = new Services.Node(6,"Matt Murdock");
        root.right.right = new Services.Node(7,"Wilson Fisk");

        convert(root);


    }
}
