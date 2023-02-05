package fop.w11pchat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader buffread;
    private BufferedWriter buffwriter;
    private String username;

    public static ArrayList<ClientHandler> getClientHandlers() {
        return clientHandlers;
    }

    public ClientHandler(Socket socket){
        try{
            this.socket = socket;
            this.buffwriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.buffread = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = buffread.readLine();
            clientHandlers.add(this);
            showMessage("SERVER: "+ username + " has entered the chat!");
        } catch (IOException e){
            closeAll(socket,buffread,buffwriter);
        }
    }
    @Override
    public void run() {
        String clientInput;
        while (socket.isConnected()){
            try{
                clientInput = buffread.readLine();
                showMessage(clientInput);
            }catch (IOException e){
                closeAll(socket,buffread,buffwriter);
                break;
            }
        }
    }
    public void showMessage(String message){
        for (ClientHandler clientHandler: clientHandlers){
            try{
                if (!clientHandler.username.equals(username)){
                    clientHandler.buffwriter.write(message);
                    clientHandler.buffwriter.newLine();
                    clientHandler.buffwriter.flush();
                }
            } catch (Exception e){
                closeAll(socket,buffread,buffwriter);
            }
        }
    }
    public void removeClientHandler(){
        clientHandlers.remove(this);
        showMessage("SERVER: " + username + " has left the chat");
    }

    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
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
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public String getUsername() {
        return username;
    }
}
