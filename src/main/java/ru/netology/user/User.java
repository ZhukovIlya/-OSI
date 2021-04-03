package ru.netology.user;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(outputStream));

            Scanner scanner = new Scanner(System.in);
            String message;
            while (true){
                while (!(message = scanner.nextLine()).isEmpty()){
                    bufferedWriter.write(message);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    while ((message = bufferedReader.readLine()) != null) {
                        System.out.println(message);
                        bufferedWriter.flush();
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
