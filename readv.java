import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.Socket;
import java.nio.ByteBuffer;

class IoVec {
    ByteBuffer buffer;

    public IoVec(ByteBuffer buffer) {
        this.buffer = buffer;
    }
}

public class readv {
    public static void main(String args[]){
        try{
            try {
                // Create a new socket and connect it to the peer
                int sockfd = Socket.createSocket();
                InetAddress addr = InetAddress.getByName("www.example.com");
                int port = 80;
                SocketAddress peerAddr = new InetSocketAddress(addr, port);
                int ret = Socket.connect(sockfd, peerAddr);
                if (ret == 0) {
                    // Allocate two buffers to hold the data read from the socket
                    ByteBuffer buffer1 = ByteBuffer.allocate(10);
                    ByteBuffer buffer2 = ByteBuffer.allocate(10);
                    IoVec[] iovecs = { new IoVec(buffer1), new IoVec(buffer2) };
    
                    // Read data from the socket into the buffers
                    ret = Socket.readv(sockfd, iovecs, 0);
                    if (ret > 0) {
                        // The data has been read successfully
                        System.out.println("Data read: " + ret + " bytes");
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
