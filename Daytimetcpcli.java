package ti;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Daytimetcpcli {
	public static void main(String[] args) throws IOException {
		try(Socket s = new Socket("127.0.0.1",13)){
			Scanner in = new Scanner(s.getInputStream(),"UTF-8");
			while(in.hasNextLine()) {
				String line = in.nextLine();
				System.out.println(line);
			}
			in.close();
		}
	}
}
