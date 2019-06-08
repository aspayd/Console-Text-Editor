package com.adamspayd;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextEditor {

    private String pathName;
    private String fileName;

    private Path path;

    private File textFile;
    private PrintWriter writer;

    public TextEditor(String pathName, String fileName) {
        this.pathName = "./" + pathName;
        this.fileName = fileName + ".txt";

        path = Paths.get(this.pathName, this.fileName);
        File pathFolder = path.getParent().toFile();

        if (!pathFolder.exists()) {
            if(pathFolder.mkdir()) {
                System.out.println("Created directory " + pathFolder.getName());
            } else {
                System.out.println("Failed to create the directory " + pathFolder.getName());
            }
        } else {
            System.out.println("The directory " + pathFolder.getName() + " already exists");
        }

        textFile = path.toFile();
        if(!textFile.exists()) {
            try {
                writer = new PrintWriter(textFile, "UTF-8");
                System.out.println("Created file " + textFile.getName());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The file " + textFile.getName() + " already exists");
        }
    }

    public TextEditor(String fileName) {
        this("", fileName);
    }

    public void write(String text) {
        try {
            if(writer == null) {
                writer = new PrintWriter(path.toFile(), "UTF-8");
            }

            writer.print(text);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public boolean writeln(String text) {
        try {
            if(writer == null) {
                writer = new PrintWriter(path.toFile());
            }

            writer.println(text);
            return true;

        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean save() {
        if(writer == null) {
            System.out.println("Nothing to save");
            return false;
        } else {
            writer.close();
            return true;
        }
    }

    public void readFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile));

            String s;
            while((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getPathName() {
        return pathName;
    }

    public String getFileName() {
        return fileName;
    }
}
