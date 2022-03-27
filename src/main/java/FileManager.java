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

    private String concatPath(String current, String fileName) {
        return current + "\\" + fileName;
    }

    public void createFile(String fileName) throws IOException {
        String fullPath = concatPath(currentFolder.toString(), fileName);
        Path currentFile = Paths.get(fullPath);
        Files.createFile(currentFile);
    }

    public void copyFile(String source, String destination) throws IOException {
        String fullSourcePath = concatPath(currentFolder.toString(), source);
        String fullDestPath = concatPath(currentFolder.toString(), destination);

        Path sourcePath = Paths.get(fullSourcePath);
        Path destPath = Paths.get(fullDestPath);

        Files.copy(sourcePath, destPath);
    }

    public void fileContent(String fileName) throws IOException {
        String fullPath = concatPath(currentFolder.toString(), fileName);
        Path currentFile = Paths.get(fullPath);

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
            String fullPath = concatPath(currentFolder.toString(), folderName);
            currentFolder = Paths.get(fullPath);
        }
    }

    public void listOfFiles() throws IOException {
        List<Path> result = Files.walk(currentFolder, 1).toList();
        for (Path path : result) {
            if (path == currentFolder) {
                continue;
            }

            if (Files.isDirectory(path)) {
                System.out.println(path.getFileName().toString() + "/");
            } else {
                System.out.println(path.getFileName());
            }
        }
    }

    public void deleteFile(String fileName) throws IOException {
        String filePath = concatPath(currentFolder.toString(), fileName);
        Path path = Paths.get(filePath);
        Files.delete(path);
    }

    public void deleteDirectory(String dirName) throws IOException {
        Path path = Paths.get(dirName);
        Files.delete(path);
    }
}
