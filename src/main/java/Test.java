import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get(".\\file1.txt");


        Path normalizeFilePath = Paths.get(filePath.toRealPath().toString());

        System.out.println(normalizeFilePath);

    }
}
