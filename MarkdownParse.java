//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // Find the next [, then find the ], then get the first starting
        // character of the link. Proceed to find the last character by finding the new
        // line (if there is no new line that means you are at the end of the file so get
        // the whole length and subtract)
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);

            int beginLink = closeBracket + 2; // Skip to the start of the link

            int newLine = markdown.indexOf("\n", closeBracket); // Find a new line if there is one

            // If there is no newline then just get end of whole file and subtract
            int endLink;
            if (newLine == -1) {
                newLine = markdown.length(); 
                endLink = newLine - 1; // Get index of end of link
            } else {
                endLink = newLine - 1; // Get index of end of link
            }

            String link;
            if (openBracket != -1) {
                link = markdown.substring(beginLink, endLink);
                toReturn.add(link);
                currentIndex = newLine;
            } else {
                break;
            }
            System.out.println(link);
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}