import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args){
        int port = 6666;
        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                System.out.println("About to accept client connection...");
                Socket clientSocket = serverSocket.accept();
                // System.out.println("Accepted connection from " + clientSocket);

                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

                Thread t = new Thread(){
                    @Override
                    public void run() {
                        try {
                            System.out.println("in thread");
                            connectClient(clientSocket);
                        } catch (IOException e) {
                            System.out.println("IO exception");
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            System.out.println("IE exception");
                            e.printStackTrace();
                        }
                    }
                };
                t.start();

                Thread t2 = new Thread(){
                    @Override
                    public void run() {
                        try {


                        } catch(Exception e){
                            System.out.println(e);
                        }
                    }
                };

            }
        } catch(IOException e) {
                System.out.println("stuck here");
                e.printStackTrace();
        }
    }

    private static void connectClient(Socket clientSocket) throws IOException, InterruptedException {
        // System.out.println("connecting client");
        DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
        os.writeUTF("Connected new device");
        Thread.sleep(1000);

        // starts listening to clients
        boolean chat = true;
        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

        while(chat){
            try {
                System.out.println(dis.readUTF() + " " + dis.readUTF());
            } catch (EOFException e){
                Thread.sleep(2000);
            }
        }

        clientSocket.close();
        os.close();
    }
}
