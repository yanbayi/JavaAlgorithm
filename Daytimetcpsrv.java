package ti;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Daytimetcpsrv {
	public static void main(String[] args) {
		try (ServerSocket s = new ServerSocket(13);){
			System.out.println("listen......");
            while (true) {                                                   
                Socket socket = s.accept();
                Runnable r = new daytime(socket);
                Thread t = new Thread(r);
                t.start();
 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static class daytime implements Runnable{
		private Socket income;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		public daytime(Socket socket) {
			income = socket;
		}
		public void run() {
			try(OutputStream out = income.getOutputStream()){
				PrintWriter outp = new PrintWriter(
						new OutputStreamWriter(out,"UTF-8"),true);
				outp.println(" ±º‰ « : "+df.format(new Date()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}