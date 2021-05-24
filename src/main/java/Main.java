import network.HostnameToIP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    private static boolean consoleOutput = true;

    public static void main(String[] args) throws IOException {
        //Title and credits
        System.out.println("\n-- Hostnames to IP --------------");
        System.out.println("-- Made by Thecrafterja ---------");

        if (args.length == 0) {
            System.err.println("Please enter a hostname");
            System.exit(0);
        }

        if (args[0].equals("-help") || args[0].equals("help") || args[0].equals("-h") || args[0].equals("h")) {
            printHelp();
            System.exit(0);
        }

        if ((args.length % 2) != 0) {
            System.out.println("That arguments doesn't make sense!");
            System.exit(0);
        }

        ArrayList<CMDArgument> arguments = new ArrayList<>();
        for (int i = 0; i < args.length; i+=2) {
            arguments.add(new CMDArgument(args[i], args[i+1]));
        }

        boolean hasHostname = false;
        HostnameToIP hNToIP = new HostnameToIP();
        for (CMDArgument argument : arguments) {
            switch (argument.getType()) {
                case "-hn":
                    hNToIP.addHostname(argument.getData());
                    hasHostname = true;
                    break;
                case "-f":
                    Path filePath = Paths.get(argument.getData());
                    hNToIP.addHostnameAsArrayList((ArrayList<String>) Files.readAllLines(filePath));
                    hasHostname = true;
                    break;
                /*case "-cout":
                    consoleOutput = Boolean.parseBoolean(argument.getData());
                    break;*/
                default:
                    if (argument.getType().equals("help") || argument.getType().equals("-help") || argument.getType().equals("h") || argument.getType().equals("-h")) {
                        System.err.println("Use '" + argument.getType() + "' only alone");
                    } else {
                        System.err.println("The argument '" + argument.getType() + "' does not exist");
                    }
                    System.exit(0);
            }
        }

        if (!hasHostname) {
            System.out.println("You didn't insert a hostname or a hostname file.");
            System.exit(0);
        }

        //Running hostname to ip
        hNToIP.output(consoleOutput);

        System.out.println("\n\n-- Finished ---------------------");
    }

    private static void printHelp() {
        System.out.println("TODO: Write help");
    }

}
