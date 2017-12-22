package ridnaxata.sandbox.sb_015_commandLine;

import java.io.*;

public class CmdLine {


    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("ping.exe -?");

          pr.waitFor();

            int exitcode = pr.exitValue();
            System.out.println(exitcode + " EXIT CODE ");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String s;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

}
