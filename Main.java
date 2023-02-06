import FileHandler.FileManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager fileManager = new FileManager();
        String inputPath = args[0];
        String outputPath = inputPath;
        int lastIndexOfSlash = outputPath.lastIndexOf('\\');
        if(lastIndexOfSlash != -1)
            outputPath = outputPath.substring(0, lastIndexOfSlash) + "\\output.txt";
        else
            outputPath = "output.txt";
        fileManager.controller(inputPath, outputPath);
    }
}
