import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8888);
            Socket socket;

            boolean run = true;
            while (run) {
                System.out.println("waiting for clients...");
                socket = server.accept();
                ClientThread clientThread = new ClientThread(socket);
                System.out.printf("Client %s connected!\n",socket.getInetAddress().getHostName());
                clientThread.start();

            }
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
