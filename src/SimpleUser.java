
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class implements java socket client
 *
 * @author pankaj
 *
 */
public class SimpleUser {

    static Socket socket = null;

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        String host1 = "localhost";
        int port = 8080;
//        Socket socket = null;
        ObjectOutputStream output = null;
        ObjectInputStream ois = null;
        Scanner scan = new Scanner(System.in);

        

        while (true) {

            socket = new Socket(host1, port);
            
            output = new ObjectOutputStream(socket.getOutputStream());

            System.out.print("> ");

            String msg = scan.nextLine();

            output.writeObject(msg);

            ois = new ObjectInputStream(socket.getInputStream());
           
            String message = (String) ois.readObject();
            System.out.println("Message: " + message);

            ois.close();
            output.close();
        }

//        for(int i=0; i<5;i++){
//            //establish socket connection to server
//            socket = new Socket(host1, port);
//            //write to socket using ObjectOutputStream
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            System.out.println("Sending request to Socket Server");
//            if(i==4)oos.writeObject("exit");
//            else oos.writeObject(""+i);
//            //read the server response message
//            ois = new ObjectInputStream(socket.getInputStream());
//            String message = (String) ois.readObject();
//            System.out.println("Message: " + message);
//            //close resources
//            ois.close();
//            oos.close();
//            Thread.sleep(100);
    }
}
