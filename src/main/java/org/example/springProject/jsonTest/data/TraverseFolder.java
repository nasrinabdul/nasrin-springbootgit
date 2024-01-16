package org.example.springProject.jsonTest.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TraverseFolder {
    public static void main(String args[]) {
        TraverseFolder tf = new TraverseFolder();
        tf.traverse("C:\\Users\\nasri\\projectfiles\\springProject\\springProject");
    }

    public void traverse(String folderName) {
        Path folderPath = Path.of(folderName).toAbsolutePath();
        if(!Files.exists(folderPath)) {
            System.out.println("Give File path does not exist : " + folderName);
            return;
        }

        if(Files.isDirectory(folderPath)) {
            recursiveTraverse(folderPath);
            System.out.println("Traversing completed");
        } else {
            System.out.println("Given path is a file. " + folderName);
            return;
        }

    }

    public void recursiveTraverse(Path folderPath) {
        try(Stream<Path> paths = Files.list(folderPath);) {

            System.out.println("-> " + folderPath.toString() + " : ");
            paths.forEach(file -> {

                if (!Files.isDirectory(file)) {
                    System.out.println(file.getFileName().toString());
                } else {
                    recursiveTraverse(file);
                    System.out.println("Contents of " + file.toString() + " completed ");
                }
            });
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
