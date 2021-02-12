import Khalilov.Phone;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try ( Phone phone = new Phone ("127.0.0.1",1502)) {
            System.out.println("Connected to server");
            String request = "Simferopol";
            System.out.println("Request: " + request);
            phone.writeLine(request);
            String response =  phone.ReadLine();

            System.out.println("Responce: " + response);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
