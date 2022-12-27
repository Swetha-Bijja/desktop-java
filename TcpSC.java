import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class TcpSC {
    public static void main(String args[]) throws IOException {
        Socket s = new Socket("localhost", 6666);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        dos.writeUTF("hello");
        dos.flush();

        DataInputStream din = new DataInputStream(s.getInputStream());
        String str = din.readUTF();
        System.out.println(str);
        System.out.println("done!");
        s.close();
    }
}