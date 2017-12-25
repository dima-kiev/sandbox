package ridnaxata.sandbox.sb_015_commandLine;

import java.io.*;

public class CmdLine {

    public static int ATTEMPTS = 10;


    public static void main(String[] args) {

        long millis = System.currentTimeMillis();

        for (int i = 0; i < ATTEMPTS; i++) {

            Runtime rt = Runtime.getRuntime();
            try {
                Process pr = rt.exec("x:\\Program Files\\Bitcoin\\daemon\\bitcoin-cli.exe walletpassphrase qazwsxedcrfv 1");

                pr.waitFor();

                int exitcode = pr.exitValue();
/*
                System.out.println(exitcode + " EXIT CODE ");

                BufferedReader stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()));

                String s;
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }
*/

            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }


        }

        millis = System.currentTimeMillis() - millis;
        System.out.println(millis/ATTEMPTS);
    }

}
