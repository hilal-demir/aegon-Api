import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.apache.commons.io.IOUtils;

public class ReadResourceFileDemo
{
    public static void main(String[] args) throws IOException
    {
        String fileName = "Documents/Email/Email/post.txt";
        ClassLoader classLoader = ReadResourceFileDemo.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {

            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
