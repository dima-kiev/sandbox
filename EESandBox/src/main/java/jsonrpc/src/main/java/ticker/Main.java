package ticker;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String FOUND = null;
        CertainRequest req = new CertainRequest(new ClientBuilder("http://127.0.0.1:").buildClient());

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                if (req.setVarAndPerform(sCurrentLine)) {
                    FOUND = sCurrentLine;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(FOUND != null ? FOUND : "not found");

//https://github.com/arteam/simple-json-rpc/tree/master/client

    }

}
