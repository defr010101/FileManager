import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    private Path currentFolder;
    private Path root;

    public FileManager(String currentFolder) {
        this.currentFolder = Paths.get(currentFolder);
        this.root = Paths.get(currentFolder);
    }

    public void createFile(String fileName) throws IOException {
        Path currentFile = Paths.get(currentFolder + fileName);
        Files.createFile(currentFile);
    }

    public void listOfFiles() throws IOException {
        List<String> files = Files.

        for (String file : files) {
            System.out.println(file);
        }
    }

    /*
    Добавить правильную конвертацию:
        cp file1.txt ../file2.txt
    Пока он копирует по относительным путям в рамках одной папки
     */
    public void copyFile(String source, String destination) throws IOException {
        Path sourcePath = Paths.get(currentFolder + source);
        Path destPath = Paths.get(currentFolder + destination);

        Files.copy(sourcePath, destPath);
    }

    public void fileContent(String fileName) throws IOException {
        Path currentFile = Paths.get(currentFolder + fileName);

        List<String> lines = Files.readAllLines(currentFile);
        for (String line: lines) {
            System.out.println(line);
        }
    }

    public void changeDirectory(String folderName) {
        if ("..".equals(folderName)) {
            currentFolder = currentFolder.getParent();
        } else if ("/".equals(folderName)) {
            currentFolder = root;
        } else {
            currentFolder = Paths.get(currentFolder + folderName);
        }
    }
}
