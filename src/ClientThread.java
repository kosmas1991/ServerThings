import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {

    private final Socket socket;

    ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            int readB;
            while ((readB = bis.read()) != -1)
                System.out.printf("%s", (char) readB);
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
