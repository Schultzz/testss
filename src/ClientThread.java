//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.Date;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *
// * @author MS
// */
//public class ClientThread implements Runnable{
//
//    //Information om socket.
//    Socket socket;
//    //in-out stream
//    ObjectInputStream ois;
//    ObjectOutputStream oos;
//    String username;
//    int id;
//    ChatMessage cm;
//
//    ClientThread(Socket socket, int uniqueId) {
//        // a unique id
//        id = ++uniqueId;
//        this.socket = socket;
//        /* Creating both Data Stream */
//        System.out.println("Thread trying to create Object Input/Output Streams");
//        try {
//            // create output first
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            ois = new ObjectInputStream(socket.getInputStream());
//            // read the username
//            username = (String) ois.readObject();
////            display(username + " just connected.");
//        } catch (IOException e) {
////            display("Exception creating new Input/output Streams: " + e);
//            return;
//        } // have to catch ClassNotFoundException
//        // but I read a String, I am sure it will work
//        catch (ClassNotFoundException e) {
//        }
////        date = new Date().toString() + "\n";
//    }
//
//    @Override
//    public void run() {
//        
//        // to loop until LOGOUT
//			boolean keepGoing = true;
//			while(keepGoing) {
//				// read a String (which is an object)
//				try {
//				                                System.out.println("11111111111111111111111");	
//                                    cm = (ChatMessage) ois.readObject();
//                                        System.out.println("22222222222222222222222222222");
//				}
//				catch (IOException e) {
//					display(username + " Exception reading Streams: " + e);
//					break;				
//				}
//				catch(ClassNotFoundException e2) {
//					break;
//				}
//				// the messaage part of the ChatMessage
//				String message = cm.getMessage();
//
//				// Switch on the type of message receive
//				switch(cm.getType()) {
//
//				case ChatMessage.MESSAGE:
//					broadcast(username + ": " + message);
//					break;
//				case ChatMessage.LOGOUT:
//					display(username + " disconnected with a LOGOUT message.");
//					keepGoing = false;
//					break;
//				case ChatMessage.WHOISIN:
//					writeMsg("List of the users connected at " + sdf.format(new Date()) + "\n");
//					// scan al the users connected
//					for(int i = 0; i < al.size(); ++i) {
//						ClientThread ct = al.get(i);
//						writeMsg((i+1) + ") " + ct.username + " since " + ct.date);
//					}
//					break;
//				}
//			}
//			// remove myself from the arrayList containing the list of the
//			// connected Clients
//			remove(id);
//			close();
//        
//    }
//
//}
