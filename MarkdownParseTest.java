import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testLinks() {
        try {
            Path fileName = Path.of("test-file.md");
            String content = Files.readString(fileName);
            List<String> links = MarkdownParse.getLinks(content);
            List<String> expected = List.of("https://something.com", "some-thing.html");
            assertEquals(expected, links);

        }
        catch(IOException e)  {
            
        }
    }
}


