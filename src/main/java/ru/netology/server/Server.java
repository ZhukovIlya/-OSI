package ru.netology.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

            String message;
            while (true) {
                while ((message = bufferedReader.readLine()) != null) {
                    int vvod = square(message);

                    if (vvod == 0){
                        bufferedWriter.write(message + " не возвести в квадрат, тут работаем только с int(введите число)");
                    } else {
                        bufferedWriter.write("Квадрат числа " + message + " равен " + vvod);
                    }
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int square(String message) {
        try {
            int a = Integer.parseInt(message);
            return a * a;
        } catch (Exception e) {
            return 0;
        }

    }
}
