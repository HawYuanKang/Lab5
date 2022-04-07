

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * An example of client-side application using UDP
 * @author emalianakasmuri
 *
 */

public class UDPClientSideApp {

	public static void main(String[] args) {
		
		System.out.println("\n\tUDPClientSideApp: Demonstration of UDP "
				+ "Client-Side Application.");
		
		
		
		try {
			
			// 1. Define server port number and address
			int portNo = 8083;
			InetAddress ip = InetAddress.getLocalHost();
			
			// 2. Prepare and transform data into bytes
			String text = "Good morning Malaysia Singapore Vietnam.";
			byte buf[] = text.getBytes();

			// 3. Wrap data in datagram packet (constructor no 5)
			DatagramPacket outPacket = 
					new DatagramPacket(buf, buf.length, ip, portNo);
			
			// 4. Create the socket object to transmit the data.
			DatagramSocket datagramSocket = new DatagramSocket();

			// 5. Send datagram packet
			datagramSocket.send(outPacket);
			System.out.println("\n\tSending '" + text + "' (" + text.length() 
				+ ") out on network.");
			
			// 6.New buffer to extract the received data
			byte[] inData = new byte[65535];
			byte[] inData1 = new byte[65535];
			byte[] inData2 = new byte[65535];
			byte[] inData3 = new byte[65535];
			
			// 7. Packet to receive data
			DatagramPacket inPacket = new DatagramPacket(inData, inData.length );
			DatagramPacket inPacket1 = new DatagramPacket(inData1, inData1.length );
			DatagramPacket inPacket2 = new DatagramPacket(inData2, inData2.length );
			DatagramPacket inPacket3 = new DatagramPacket(inData3, inData3.length );
			
			// 8. Receive data
			datagramSocket.receive(inPacket);
			datagramSocket.receive(inPacket1);
			datagramSocket.receive(inPacket2);
			datagramSocket.receive(inPacket3);
			
			// 9. Extract data
			inData = inPacket.getData();
			inData1 = inPacket1.getData();
			inData2 = inPacket2.getData();
			inData3 = inPacket3.getData();
			
			// 10. Further processing
			// Transform data into human readable text
			String length = new String(inData, 0, inPacket.getLength());
			String length1 = new String(inData1, 0, inPacket1.getLength());
			String length2 = new String(inData2, 0, inPacket2.getLength());
			String length3 = new String(inData3, 0, inPacket3.getLength());
			
			// Display the data received from the server
			System.out.println("\tLength from the server is : " + length);
			System.out.println("\tVowel Count from the server is : " + length1);
			System.out.println("\tConsonent Count from the server is : " + length2);
			System.out.println("\tPunctuation Count from the server is : " + length3);
			
			datagramSocket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("\n\tUDPClientSideApp: End of program.");

	}

}
