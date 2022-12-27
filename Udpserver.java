import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.BufferedReader;

public class Udpserver {
    public static void main(String args[]) {
        try {
            byte b[] = new byte[3072];
            System.out.println("Waiting for client..");
            DatagramSocket dgs = new DatagramSocket(1000);
            FileWriter fw = new FileWriter("hi.txt");
            while (true) {
                DatagramPacket dp = new DatagramPacket(b, b.length);
                dgs.receive(dp);
                fw.write(new String(dp.getData(), 0, dp.getLength()));
                fw.close();
                dgs.close();
                System.out.println("Data written into file!!");
                String transfer = "";
                BufferedReader reader = new BufferedReader(new FileReader("hi.txt"));
                String l = reader.readLine();
                while (l != null) {
                    transfer = transfer + l + "\n";
                    l = reader.readLine();
                }
                System.out.print(transfer);
                reader.close();
            }
        } catch (Exception e) {
        }
    }
}
