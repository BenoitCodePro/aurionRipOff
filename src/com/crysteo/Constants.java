package com.crysteo;

/**
 * Created by plesur on 10/18/15.
 * Contains all the strings for the errors/help command.
 * Also contains methods to display those messages (not necessary, but it makes the code more readable)
 * This class is static.
 */
public class Constants {

    private static final String AURIONRIPOFF_INTRO = "Welcome to Aurion Rip-Off !\n" +
            "Please use on of the following command (type help command for more information).\n" +
            "You can exit this program with the EOF char (^D).\n\n";
    private static final String WRONG_COMMAND_USAGE = "Wrong usage of the command. Please see the help function.\n";
    private static final String HELP_MAIN = "The different commands that exist are:\n" +
            "help - display this help\n" +
            "add ELEMENT\n" +
            "serialize FILEPATH\n" +
            "deserialize FILEPATH\n" +
            "display\n" +
            "\tTo learn more about a command simply type \"help name_of_the_command\".\n";
    private static final String HELP_ADD = "The add command allows you to add a teacher/student/class by typing \"add student\" for example.\n" +
            "Here are the parameters necessary to add each of those elements:\n" +
            "Student:\n\tfirst name ; surname ; promotion (just a number)\n" +
            "Teacher:\n\tfirst name ; surname ; office room (full name)\n" +
            "Class:\n\t TO BE DEFINED\n";
    private static final String HELP_SERIALIZE = "The command serialize allows you to serialize all the students/teachers/classes you created.\n" +
            "The first (and only) argument is the path of the file you want to save the objects to.\n" +
            "Example:\n\tserialize /home/user/aurionRipOffObjects.ser\n";
    private static int lineCount = 0;

    private Constants() {
    }

    public static void wrong_command_usage() {
        System.out.print(WRONG_COMMAND_USAGE);
    }

    public static void help_main() {
        System.out.print(HELP_MAIN);
    }

    public static void help_add() {
        System.out.print(HELP_ADD);
    }

    public static void help_serialize() {
        System.out.print(HELP_SERIALIZE);
    }

    public static void present_software() {
        System.out.print((AURIONRIPOFF_INTRO));
    }

    public static void new_line() {
        System.out.print(++lineCount + "> ");
    }
}
