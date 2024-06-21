package org.deliveroo;

public class Main {
    public static void main(String[] args) {
        args = new String[]{"30 2 3 * + /usr/bin/find"};
//        if (args.length != 1) {
//            System.err.println("Usage: java org.deliveroo.CronParser \"<cron string>\"");
//            System.exit(1);
//        }

        String cronString = args[0];
        CronParser parser = new CronParser(cronString);
        System.out.println(parser.parse());
    }
}
