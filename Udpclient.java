import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.FileReader;

public class Udpclient {
    public static void main(String[] args) {
        try {
            byte b[] = new byte[1024];
            FileInputStream fis = new FileInputStream("hello.txt");
            DatagramSocket ds = new DatagramSocket(5000);
            String transfer = "";
            BufferedReader reader = new BufferedReader(new FileReader("hello.txt"));
            String l = reader.readLine();
            while (l != null) {
                transfer = transfer + l + "\n";
                l = reader.readLine();
            }
            System.out.print(transfer);
            reader.close();
            int i = 0;
            while (fis.available() != 0) {
                b[i++] = (byte) fis.read();
            }
            fis.close();
            ds.send(new DatagramPacket(b, i, InetAddress.getLocalHost(), 1000));
            System.out.println("Data sent!!");
            ds.close();
        } catch (Exception e) {
        }
    }
}