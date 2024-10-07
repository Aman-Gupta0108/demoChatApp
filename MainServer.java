import java.io.*;
import java.net.*;
import java.util.Scanner;
class MainServer{

		//  ==> sendResponce to client <==
			static void sendRequest(DataOutputStream dout ,String str){
			try{	
			dout.writeUTF(str);
			
			
			}catch(Exception e){ System.out.println(e);}
	}

		// ==> reciveRequest from client <==
			public static void reciveRequest(DataInputStream dis){
			try{
	                String str =(String) dis.readUTF();
			System.out.println("message = "+str);
					
				
	
			

 			}catch(Exception e ){System.out.println(e);}
	
	}



	

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		try{
			ServerSocket ss = new ServerSocket(5505);
			Socket s = ss.accept();

				// in
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
				// out
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());			
				
				// main server call
			MainServer.reciveRequest(dis);


                        while(true){
			
			String str = in.next();
			MainServer.sendRequest(dout , str);
			MainServer.reciveRequest(dis);
			if(str.equals("exit"))
			dout.flush();
			dout.close();
			ss.close();

			}
			
			

		}catch(Exception e ){System.out.println(e);}


}}