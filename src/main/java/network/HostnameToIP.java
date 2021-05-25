package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        StringBuilder CMDStringBuilder = new StringBuilder();
        StringBuilder FileStringBuilder = new StringBuilder();
        for (String hostname : hostNames) {
            try {
                InetAddress[] inetAddresses = InetAddress.getAllByName(hostname);
                CMDStringBuilder.append("\n\nIP addresses for hostname '" + hostname + "'");
                FileStringBuilder.append(hostname + "\n");
                for (int i = 0; i < inetAddresses.length; i++) {
                    CMDStringBuilder.append("\n" + inetAddresses[i].getHostAddress());
                    FileStringBuilder.append(inetAddresses[i].getHostAddress() + "\n");
                }
                FileStringBuilder.append("#\n");
            } catch (UnknownHostException e) {
                System.err.println("Host '" + hostname + "' is unknown");
            }
        }
        String finalResult = CMDStringBuilder.toString();

        if (consoleOutput) {
            System.out.println(finalResult);
        }

        if (filePaths.size() != 0) {
            for (String filePathString : filePaths) {
                try {
                    Path filePath = Paths.get(filePathString);
                    Files.write(filePath, FileStringBuilder.toString().getBytes());
                    System.out.println("\n\nWrote result to '" + filePathString + "'");
                } catch (IOException e) {
                    System.err.println("File '" + filePathString + "' not found");
                }
            }
        }
    }

}
