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
            int beginLink = markdown.indexOf("(", closeBracket); // Skip to the start of the link
            int endLink;
            String link;
            if(beginLink != closeBracket + 1) {
                if(markdown.indexOf("[", closeBracket + 1) == -1) {
                    break;
                }
                else {
                    currentIndex = markdown.indexOf("[", closeBracket + 1);
                }
            }
            else {
                endLink = markdown.indexOf(")", beginLink);
                link = markdown.substring(beginLink + 1, endLink);
                toReturn.add(link);
                currentIndex = markdown.indexOf("[", closeBracket + 1);
                if(currentIndex == -1) {
                    break;
                }
            }
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        System.out.println("new edit woo");
    }

    //new edit new edit
    //ooh edit edit
    //oooh spoooooooky new edit 
    //weghawpeoghapwoeigh ewghpowaeighawopeghiwegoih
}