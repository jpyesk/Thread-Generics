package fop.w11pchat;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static fop.w11pchat.ClientHandler.clientHandlers;
import static fop.w11pchat.ClientHandler.getClientHandlers;


public class ChatClient {
    private Socket socket;
    private BufferedReader buffread;
    private BufferedWriter buffwrite;
    private String username;
    public ChatClient(Socket socket,String username){
        try{
            this.socket = socket;
            this.buffwrite = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.buffread = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        } catch (IOException e){
            closeAll2(socket,buffread,buffwrite);
        }
    }
    public void sendingMessages(){
        try{
            buffwrite.write(username);
            buffwrite.newLine();
            buffwrite.flush();

            Scanner scan = new Scanner(System.in);
            while (socket.isConnected()){
                String message = scan.nextLine();
                if (Objects.equals(message, "LOGOUT")) {
                    System.out.println("You Disconnected By Typing LOGOUT");
                    this.socket.close();
                    break;
                }
                if (Objects.equals(message, "PINGU")){
                    String[] pingufacts = new String[5];
                    pingufacts[0]="There are 18 species of penguin";
                    pingufacts[1]="Smallest penguin is only a foot tall";
                    pingufacts[2]="Penguins originated in Australia";
                    pingufacts[3]="Largest living penguin is emperor penguin";
                    pingufacts[4]="Penguins cannot fly";
                    Random random = new Random();
                    System.out.println(pingufacts[random.ints(0,4).findFirst().getAsInt()]);
                }
                if (Objects.equals(message,"WHOIS")) {
                    for (int i = 0; i < clientHandlers.size(); i++) {
                        System.out.println(clientHandlers.get(i) + " ");
                    }
                }
                buffwrite.write(username +": " + message);
                buffwrite.newLine();
                buffwrite.flush();

            }
        } catch (IOException e){
            closeAll2(socket,buffread,buffwrite);
        }
    }
    public void receiveMessages(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msg;
                while (socket.isConnected()){
                    try{
                        msg = buffread.readLine();
                        System.out.println(msg);
                    } catch(Exception e){
                        closeAll2(socket,buffread,buffwrite);
                    }
                }
            }
        }).start();
    }
    public void closeAll2(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if (socket != null){
                socket.close();
            }
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username for group chat:");
        String username = scan.nextLine();
        Socket socket = new Socket("localhost",3000);
        ChatClient client = new ChatClient(socket,username);
        client.receiveMessages();
        client.sendingMessages();

    }
}
