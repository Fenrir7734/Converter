package org.example;


import org.example.controllers.MainController;

public class Main {

    /**
     * This main method should be run. This main method is unfortunately required
     * because class MainController extends Application class and has main method.
     * In this case the LauncherHelper check for the javafx.graphic module to be
     * present as a named module. If that module is not present, the launch is aborted.
     *
     * @link https://stackoverflow.com/questions/52569724/javafx-11-create-a-jar-file-with-gradle/52571719#52571719
     */
    public static void main(String[] args) {
        MainController.main(args);
    }
}
