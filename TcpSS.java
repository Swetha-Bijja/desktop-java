import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSS {
    public static void main(String args[]) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        String str = din.readUTF();
        System.out.println(str);

        String rev = "";
        for (int i = 0; i < str.length(); i++) {
            rev = str.charAt(i) + rev;
        }
        DataOutputStream dot = new DataOutputStream(s.getOutputStream());
        dot.writeUTF(rev);
        dot.flush();

        ss.close();

    }
}
