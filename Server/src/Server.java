import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.net.ServerSocket;
import Khalilov.Phone ;

public class Server {
    public static void main(String[] args) throws IOException {

            try (ServerSocket server = new ServerSocket(1502)) {
                System.out.println("servak pashet");

                while (true)
                     try (Phone phone= new Phone(server)) {
                         new Thread (() -> {
                             String request = phone.ReadLine();
                             String response = (int) (Math.random() * 30 - 10) + " ";
                             System.out.println("Request" + request);
                             try {Thread.sleep(4000);} catch (InterruptedException e) { }
                             phone.writeLine(response);
                             System.out.println("Rasponce " + response);
                         }).start();
                } catch (NullPointerException e){
                    e.printStackTrace();
                }

                } catch (IOException e ){
                    throw new RuntimeException(e) ;
                }

            }

    }

