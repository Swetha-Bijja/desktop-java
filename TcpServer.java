import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("Waiting for Client");
        Socket socket = ss.accept();
        DataInputStream ri = new DataInputStream(socket.getInputStream());
        DataOutputStream wo = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String lines = ri.readUTF();
        ;
        FileWriter myWriter = new FileWriter("C:/Users/Admin/Desktop/java/hi.txt");
        myWriter.write(lines);
        myWriter.close();
        ss.close();
        socket.close();
        ri.close();
        wo.close();
        sc.close();
    }
}