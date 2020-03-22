package homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;

    private Socket socket;

    public static void main(String[] args) throws IOException{
        new Client().startClient(SERVER_ADDR, SERVER_PORT);
    }

    public void startClient(String serverAddress, int serverPort) throws IOException {

        try {
            openConnection(serverAddress, serverPort);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            receivingMessagesThread(dataInputStream);
            sendMessageLoop(dataOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void openConnection(String serverAddress, int serverPort) throws IOException {
        socket = new Socket(serverAddress, serverPort);
        System.out.println("Клиент запущен.");
    }

    private void closeConnection() throws IOException {
        socket.close();
    }

    private void receivingMessagesThread(DataInputStream inputData) throws IOException {
        new Thread(() -> {
            while (true) {
                try {

                    String message = inputData.readUTF();
                    System.out.println("Сообщение от сервеа: " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Соединение закрыто");
                    break;
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
