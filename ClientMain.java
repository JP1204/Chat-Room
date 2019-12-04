import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) {
        try{
            // first client
            System.out.println("In client 1");
            Socket s = new Socket("localhost",6666);

            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());

            System.out.println(din.readUTF());

            dout.writeUTF("Hello Server");
            dout.flush();

            dout.writeUTF("This is the second message");
            dout.writeUTF("Does this continue?");

            // second client
            System.out.println("In client 2");
            Socket s2 = new Socket("localhost",6666);

            DataOutputStream dout2=new DataOutputStream(s.getOutputStream());
            DataInputStream din2 = new DataInputStream(s.getInputStream());


            dout2.writeUTF("Hello Server");
            dout2.flush();

            dout2.writeUTF("This is the second message");
            dout2.writeUTF("Does this continue?");

            // third client
            System.out.println("In client 3");
            Socket s3 = new Socket("localhost",6666);

            DataOutputStream dout3=new DataOutputStream(s.getOutputStream());
            DataInputStream din3 = new DataInputStream(s.getInputStream());

            dout3.writeUTF("Hello Server");
            dout3.flush();

            dout3.writeUTF("This is the second message");
            dout3.writeUTF("Does this continue?");

            dout.close();
            dout2.close();
            dout3.close();
            s.close();
            s2.close();
            s3.close();

        }catch(Exception e){System.out.println(e);}
    }
}
