import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UdpSC {
    public static void main(String args[]) throws IOException {
        try {
            DatagramSocket dgs = new DatagramSocket();
            String s = "hello";
            byte b[] = s.getBytes();
            dgs.send(new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 6666));
            dgs.close();
        } catch (Exception e) {
        }
    }
}