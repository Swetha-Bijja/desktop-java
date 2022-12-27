import java.io.*;
import java.net.*;
import java.util.*;

public class TcpClient {
    public static void main(String args[]) throws Exception {
        Socket socket = new Socket("localhost", 6666);
        DataInputStream ri = new DataInputStream(socket.getInputStream());
        DataOutputStream wo = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String transfer = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:/Users/Admin/Desktop/java/def.txt"));
            String l = reader.readLine();
            while (l != null) {
                transfer = transfer + l + "\n";
                l = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        wo.writeUTF(transfer);
        socket.close();
        ri.close();
        wo.close();
        sc.close();
    }
}