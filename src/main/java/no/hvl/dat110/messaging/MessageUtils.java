package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = null;
		byte[] data;
		
		// TODO - START
		if(message != null) {
			data = message.getData();
			int datalength = data.length;
			segment = new byte[128];
			segment[0] = (byte) datalength;
			for(int i = 0; i < datalength; i++) {
				segment[i+1] = data[i];
			}
			
		}
		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// TODO - START
		// decapsulate segment and put received payload data into a message
	       
			int messagelength = segment[0];
			byte[] nyByte = new byte[messagelength]; 
			for(int i = 0; i < messagelength; i++) {
				nyByte[i] = segment[i+1];
			}
			message = new Message(nyByte);
	 
		// TODO - END
		
		return message;
		
	}
	
}
