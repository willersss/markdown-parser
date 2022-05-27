import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void testLink1() {
        try {
            Path fileName = Path.of("test-file.md");
            String content = Files.readString(fileName);
            List<String> links = MarkdownParse.getLinks(content);
            List<String> expected = List.of("https://something.com", "some-thing.html");
            assertEquals(expected, links);

        }
        catch(IOException e)  {
            //success
        }
    }
    @Test
    public void testLab1() {
        try {
            Path fileName = Path.of("lab-report-test-1.md");
            String content = Files.readString(fileName);
            List<String> links = MarkdownParse.getLinks(content);
            List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
            assertEquals(expected, links);

        }
        catch(IOException e)  {
            //success
        }
    }
    @Test
    public void testLab2() {
        try {
            Path fileName = Path.of("lab-report-test-2.md");
            String content = Files.readString(fileName);
            List<String> links = MarkdownParse.getLinks(content);
            List<String> expected = List.of("a.com", "a.com(())", "example.com");
            assertEquals(expected, links);

        }
        catch(IOException e)  {
            //success
        }
    }
    @Test
    public void testLab3() {
        try {
            Path fileName = Path.of("lab-report-test-3.md");
            String content = Files.readString(fileName);
            List<String> links = MarkdownParse.getLinks(content);
            List<String> expected = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
            assertEquals(expected, links);

        }
        catch(IOException e)  {
            //success
        }
    }
}


