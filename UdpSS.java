import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSS {
    public static void main(String args[]) {
        try {
            DatagramSocket dgs = new DatagramSocket(6666);
            byte b[] = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b, b.length);
            System.out.println("hi");

            dgs.receive(dp);
            String s = new String(dp.getData());
            String rev = "";
            for (int i = s.length(); i >= 0; i--) {
                rev += s.charAt(i);
            }
            System.out.println("hi");

            byte a[] = rev.getBytes();
            dgs.send(new DatagramPacket(a, a.length, InetAddress.getLocalHost(), 6666));
            System.out.println("hi");

            dgs.close();
        } catch (Exception e) {
        }

    }
}
