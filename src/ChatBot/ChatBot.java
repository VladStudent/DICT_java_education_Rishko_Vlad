package ChatBot;

import java.util.Scanner;
import java.util.WeakHashMap;

public class ChatBot {
    public static void main(String[] args) {
        String nameBot = "Botik";
        int YearOld = 2025;
        Scanner consol = new Scanner(System.in);


        System.out.println("Hello!, my name is " +nameBot);
        System.out.println("I was created in " + YearOld);
        System.out.println("Please, remind me your name.");

        String  Myname = consol.nextLine();
        System.out.println("What a great name you have " + Myname + "!");

        System.out.println("Let me guess your age. ");

        System.out.println("Enter remainders of dividing your age by 3, 5 and 7. ");


        int  remainder3 = consol.nextInt();
        System.out.println(remainder3);


        int  remainder5 = consol.nextInt();
        System.out.println(remainder3);


        int  remainder7 = consol.nextInt();
        System.out.println(remainder3);

        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105 ;

        System.out.println("Your age is " + age + " that a good time to start programming!" );


       
    }

}