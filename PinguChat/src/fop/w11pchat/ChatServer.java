package fop.w11pchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private ServerSocket serversocket;

    public ChatServer(ServerSocket serversocket) {
        this.serversocket = serversocket;
    }
    public void startingserver(){
        try{
            while (!serversocket.isClosed()){
                Socket sock = serversocket.accept();
                System.out.println("A new Client has connected");
                ClientHandler  clientHandler = new ClientHandler(sock);
                Thread thread1 = new Thread(clientHandler);
                thread1.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        ChatServer chatserv = new ChatServer(serverSocket);
        chatserv.startingserver();
    }
}
    
