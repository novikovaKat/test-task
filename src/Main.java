import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "./src/text.txt"; //file with text

        String content = Files.readString(Path.of(filePath));
        System.out.println("Your text: \n" + content);

        String [] words = content.split("[^a-zA-Z]+");

        //map with characters, first index of word with this char, amount such words in the text
        HashMap<Character, Pair> globalMap = new HashMap<>();
        int index = 0;

        for (String word: words) {
            char [] charArray = word.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();

            for (char ch: charArray) {      //filling map with characters and their amount in a word
                if(map.containsKey(ch)){
                    map.replace(ch, map.get(ch) + 1);
                }
                else{
                    map.put(ch, 1);
                }
            }
            for (char ch: charArray) {  //searching for first unique char
                if(map.get(ch) == 1){   
                    if(globalMap.containsKey(ch)){
                        globalMap.get(ch).increaseCount();
                    }
                    else{
                        globalMap.put(ch, new Pair(index, 1));
                        index++;
                    }
                    break;
                }
            }
        }
        int resultIndex = -1;
        Character resultChar = null;
        //searching for first unique char in text of already selected in words
        for (Character key: globalMap.keySet()) { 
            if(globalMap.get(key).getCount() == 1 && (globalMap.get(key).getIndex() < resultIndex || resultIndex == -1)){
                resultChar = key;
                resultIndex = globalMap.get(key).getIndex();
            }
        }
        if (resultChar != null){
            System.out.println("Result: " + resultChar);
        }
        else{
            System.out.println("No unique character");
        }
    }

}