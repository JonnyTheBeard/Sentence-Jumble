
/**
 * SentenceJumbler changes the order of the letters in a word, but leaves
 * the first and last characters in place. This is used to show that the
 * human brain only needs the first and last letters for context to read a
 * word.
 *
 * @author Jon Rabideau
 * @version 1.0.0
 */

import java.util.*;

public class SentenceJumbler{
    public String wordJumbler(Random random, String y){
        char a[] = y.toCharArray();

        for(int i = 1; i<a.length - 1; i++){

            int j = random.nextInt(a.length - 2) + 1;

            char temp = a[i]; a[i] = a[j]; a[j] = temp;
        }
        return new String(a);
    }

    public String sentenceJumble(String x){
        String sentence = x;
        String[] words = sentence.split(" ");
        Random r = new Random();

        for(int i = 0; i < words.length; i++){
            words[i] = wordJumbler(r, words[i]);
        }

        sentence = Arrays.toString(words);
        sentence = sentence.substring(1, sentence.length() - 1).replace(",", "");
        System.out.println(sentence);
        return sentence;
    }

    public static void main(String args[]){
        SentenceJumbler test = new SentenceJumbler();
        Scanner scan = new Scanner(System.in);
        String input = "go";
        System.out.println("-------------------------------------------");
        System.out.println("      Welcome to Sentence Jumbler!");
        System.out.println("-------------------------------------------");
        System.out.println("Did you know that the human brain  ");
        System.out.println("can read words as long as the first");
        System.out.println("and last letters are accurate?");
        System.out.println("The rest can be tottally jumbled!");
        System.out.println("Enter a sentence to try for yourself,");
        System.out.println("or enter 'stop' to exit.");
        System.out.println("-------------------------------------------");

        while(!input.equals("stop")){
            input = scan.nextLine();
            if(!input.equals("stop")){
                test.sentenceJumble(input);
            }
        }

        System.out.println("-------------------------------------------");
        System.out.println("Goodbye!");
    }
}
