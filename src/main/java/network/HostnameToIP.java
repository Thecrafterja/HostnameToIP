package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class HostnameToIP {

    private ArrayList<String> hostNames = new ArrayList<>();
    private ArrayList<String> filePaths = new ArrayList<>();

    public void addHostname(String hostname) {
        hostNames.add(hostname);
    }

    public void addHostnameAsArrayList(ArrayList<String> hostnameList) {
        for (String actualHostname : hostnameList) {
            addHostname(actualHostname);
        }
    }

    public void addOutputFile(String filePath) {
        filePaths.add(filePath);
    }

    public void output(boolean consoleOutput) {
        StringBuilder finalStringBuilder = new StringBuilder();
        for (String hostname : hostNames) {
            try {
                InetAddress[] inetAddresses = InetAddress.getAllByName(hostname);
                finalStringBuilder.append("\n\nIP addresses for hostname '" + hostname + "'");
                for (int i = 0; i < inetAddresses.length; i++) {
                    finalStringBuilder.append("\n" + inetAddresses[i].getHostAddress());
                }
            } catch (UnknownHostException e) {
                System.err.println("Host '" + hostname + "' is unknown");
            }
        }
        String finalResult = finalStringBuilder.toString();

        if (consoleOutput) {
            System.out.println(finalResult);
        }

        //TODO add file output
    }

}
