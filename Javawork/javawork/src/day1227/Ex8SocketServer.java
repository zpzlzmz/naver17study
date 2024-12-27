package day1227;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex8SocketServer extends Thread{

	ServerSocket serverSocket;
	
	@Override
	public void run() {
		System.out.println("서버 소켓을 생성해보자");
		try {
			//접속하는 클라이언트를 허용하기 위해서 필요한 서버소켓
			serverSocket=new ServerSocket(6000);
			System.out.println("서버 소켓 생성 성공");
			
			while(true)
			{
				//접속한 클라이언트를 허용하고 소켓을 얻는다
				Socket socket=serverSocket.accept();
				System.out.println("접속한 클라이언트의 IP:"
						+socket.getInetAddress().getHostAddress());
			}
		} catch (IOException e) {
			System.out.println("서버 소켓 생성 실패:"+e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex8SocketServer server=new Ex8SocketServer();
		server.start();//run 메서드 호출
	}

}
