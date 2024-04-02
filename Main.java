import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();


    }

    public static void menu(){
        String user_input;
        Scanner input = new Scanner(System.in);
        String[] eng = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
                "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
                "-----"};
        while (true) {
            System.out.println();
            System.out.println("Hello, this program allows you to translate text to morse code or translate morse code to text.");
            System.out.println("Please, select one of the below options:");
            System.out.println("***Enter 't' for encoding text");
            System.out.println("***Enter 'm' for decoding morse code");
            System.out.println("*** Enter 'e' to exit program");
            String user_option = input.nextLine();
            if (user_option.equals("t")) {
                System.out.println("Please enter a phrase: ");
                user_input = input.nextLine();
                encoding(eng, morse, user_input);
            } else if (user_option.equals("m")) {
                System.out.println("Please enter a Morse code: ");
                user_input = input.nextLine();
                decoding(eng, morse, user_input);
            } else if (user_option.equals("e")) {
                System.exit(0);
            } else {
                System.out.println("***invalid option");
                System.out.println("Please enter a valid option");
            }
        }
    }

    public static void encoding(String eng[], String morse[], String user_input){
        user_input = user_input.toLowerCase();
        for(int i = 0; i < user_input.length();i++) {
            char current = user_input.charAt(i);
            for (int j = 0; j < eng.length; j++) {
                if (eng[j].charAt(0) == current) {
                    System.out.print(morse[j] + " ");
                }
            }
            if (current == ' ') {
                System.out.print("   ");
            }

        }
    }

    public static void decoding(String eng[],String morse[], String user_input){
        if(user_input.contains(" ")){
            String[] s = user_input.split(" ");
            StringBuilder translate = new StringBuilder();
            for(int i = 0; i < s.length;i++){
                String current = s[i];
                for(int j = 0; j < eng.length; j++){
                    if (morse[j].equals(current)){
                        translate.append(eng[j]);

                    }
                }
            }
            System.out.println(translate.toString().toUpperCase());
        }


    }

}