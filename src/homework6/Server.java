package homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) throws IOException {
        new Server().startServer(SERVER_PORT);
    }


    private ServerSocket socket;
    private Socket clientSocket;

    public void startServer(int port) throws IOException {

        try {
            openConnection(port);

            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            receivingMessagesThread(dataInputStream);
            sendMessageLoop(dataOutputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void openConnection(int port) throws IOException {
        socket = new ServerSocket(port);
        System.out.println("Сервер запущен.");
        clientSocket = socket.accept();
        System.out.println("Клиент подключился.");
    }

    private void closeConnection() throws IOException {
        clientSocket.close();
        socket.close();
    }

    private void receivingMessagesThread(DataInputStream inputData) {
        new Thread(() -> {
            while (true) {
                try {
                    String inputMessage = inputData.readUTF();
                    if (inputMessage.equalsIgnoreCase("/end")) {
                        break;
                    }
                    System.out.println("Сообщение от клиента: " + inputMessage);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Соединение закрыто");
                }
            }
        }).start();
    }

    private void sendMessageLoop(DataOutputStream outputData) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.next();
            outputData.writeUTF(message);
            if (message.equals("/end")) {
                break;
            }
        }
    }
}
