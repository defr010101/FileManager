import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileManager fileManager = new FileManager("D:\\JavaProjects\\FileManager\\root");

        String input = reader.readLine();

        while (!input.equals(Commands.EXIT)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            if (tokens.length == 2) {
                if (tokens[1].contains("/")) {
                    tokens[1] = tokens[1].replace("/", "\\");
                }
            } else if (tokens.length == 3) {
                if (tokens[1].contains("/")) {
                    tokens[1] = tokens[1].replace("/", "\\");
                }

                if (tokens[2].contains("/")) {
                    tokens[2] = tokens[2].replace("/", "\\");
                }
            }

            switch (command) {
                case Commands.LIST_OF_FILES -> fileManager.listOfFiles();
                case Commands.COPY_FILE -> {
                    String sourceFileName = tokens[1];
                    String destFileName = tokens[2];

                    fileManager.copyFile(sourceFileName, destFileName);
                }
                case Commands.CREATE_FILE -> {
                    String fileName = tokens[1];
                    fileManager.createFile(fileName);
                }
                case Commands.FILE_CONTENT -> {
                    String fileName = tokens[1];
                    fileManager.fileContent(fileName);
                }
                case Commands.CHANGE_DIRECTORY -> {
                    String folderName = tokens[1];
                    fileManager.changeDirectory(folderName);
                }
                case Commands.DELETE_FILE -> {
                    String fileName = tokens[1];
                    fileManager.deleteFile(fileName);
                }
                case Commands.DELETE_DIRECTORY -> {
                    String dirName = tokens[1];
                    fileManager.deleteDirectory(dirName);
                }
            }

            input = reader.readLine();
        }

        reader.close();
    }
}
