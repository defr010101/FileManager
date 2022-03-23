import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\JavaProjects\\FileManager\\root\\text10.txt");
        System.out.println(path);
    }
}
