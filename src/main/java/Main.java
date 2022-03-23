import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        FileManager fileManager = new FileManager("D:\\JavaProjects\\FileManager\\root");

        String input = in.nextLine();

        while (!input.equals(Commands.EXIT)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

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
            }

            input = in.nextLine();
            in.close();
        }
    }
}
