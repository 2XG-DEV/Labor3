package classes;

import java.util.Scanner;

public class UI {

    UI(){

    }

    void display(){
        int choice = -1;
        do{
            System.out.println("1. Register To Course");
            System.out.println("2. Show Courses With Free Places");
            System.out.println(("3. Show Students in Course"));
            System.out.println("4. Show Classes");
            System.out.println("5. Exit");
            Scanner myObj = new Scanner(System.in);
            choice = myObj.nextInt();

        }while(choice < 5);
    }
}
