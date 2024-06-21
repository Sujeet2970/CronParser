package org.deliveroo;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Error due to the number of args size is not equal to 1");
            System.exit(1);
        }

        String cronString = args[0];
        CronParser parser = new CronParser(cronString);
        System.out.println(parser.parse());
        parser.parseAndGetNthOccurrenceTime(5);
    }
}
