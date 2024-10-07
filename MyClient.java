import java.net.*;
import java.io.*;
import java.util.Scanner;

class MyClient{
		//  ==> sendRequest to server<==
	static void sendRequest(DataOutputStream dout , String str){
			try{	
			dout.writeUTF(str);
			
			
			
			}catch(Exception e){ System.out.println(e);}
	}


	// ==> reciveResponce fron server <==
	public static void reciveRequest(DataInputStream dis   ){
			
			try{
	                String str =(String) dis.readUTF();
			System.out.println("message = "+str);

			
			
 			}catch(Exception e ){System.out.println(e);}
	
	}
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		try{
			Socket s = new Socket("localhost", 5505);
			
					//out
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
				//in
			DataInputStream dis = new DataInputStream(s.getInputStream());



			//MainServer.sendRequest(dout , str);
			
			
			 while(true){
			
			String str = in.next();

			MyClient.sendRequest(dout , str );
			
			MyClient.reciveRequest(dis );

			
			
						

			if(str.equals("exit"))
			{
			dout.flush();
			dout.close();
			s.close();
			}
			}



			//dout.flush();
			//dout.close();
			//s.close();

			//ss.close();
		}
catch(Exception e){System.out.println(e);}




}
}