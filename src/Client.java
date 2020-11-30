import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        byte[] sendData = new byte[1024];
        // while (true) {
        boolean error = true;
        while (error) {
            try {
                Socket socket = new Socket("localhost", 8888);
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                sendData = "hello\n\r".getBytes();
                bos.write(sendData);
                bos.flush();

                bos.close();
                socket.close();
                error=false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //  }

    }
}
