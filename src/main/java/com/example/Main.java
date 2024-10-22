package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            
            
           
            Socket mySocket = new Socket("localhost", 3000); 
            String stringRead = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream    ());

            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("Inserisci il numero:");

                String outputString = sc.nextLine();

                out.writeBytes(outputString + '\n');

                stringRead = in.readLine();

               

                switch (stringRead) {
                    case ">":
                        System.out.println("numero troppo grande");
                        break;

                    case "<":
                        System.out.println("numero troppo piccolo");
                        break;

                    case "=":
                    stringRead = in.readLine();
                    System.out.println("numero indovinato con " + stringRead + " tentativi");
                        break;
                        
                    default:
                    System.out.println("numero non compreso");
                    break;
                }

                
            
            } while(true);
        } catch (UnknownHostException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}