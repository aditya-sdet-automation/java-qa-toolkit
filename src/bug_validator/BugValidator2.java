package bug_validator;

import java.util.*;

/**
 * A command-line utility designed to standardize and validate manual bug reports.
 * It enforces strict formatting rules for titles, required minimum number of reproduction steps, and calculate bug severity based on keyword analysis
 */
public class BugValidator2
{

    // Array of valid Operating Systems required tro be mentioned in the bug title
    static final String[] VALID_OS = {"Android", "iOS", "Linux", "Windows" };
    // Target keyword(currently unused but reserved for future validation features )
    static final String KEYWORD = "checkout";

    static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //Execute the bug validation pipeline sequentially
        String title = getvalidtitle(sc);
        ArrayList<String> step = getvalidstep(sc);
        String severity = severitychecktitle(title,sc);
        //Generate the final formatted report
        result(title, step, severity);
    }

    /**
     * Prompts the use for a bug title and ensure it contains a valid OS.
     * Loops continuously until a valid title is provided
     */
    static String getvalidtitle(Scanner sc)
    {
        while(true)
        {
            System.out.println("Enter Bug Title");
            String usertitle = sc.nextLine().trim();
            //Pass the title to the OS Validation Method
            if (hasOS(usertitle)) {
                System.out.println("Title Validated: OS detected");
                return usertitle;
            }
            System.out.println("Title Invalidated");;
        }
    }

    /**
     * Parses a string to check if it contains any of the predefined valid operating systems
     * uses regex to strip punctuation for a highly accurate matching
     */
    static boolean hasOS(String title)
    {
        //Split the title into an array of individual words based on spaces
        String[] words = title.split("\\s+");
        for (int i = 0; i < words.length; i++)
        {
            //Regex: Strip out any non-alphanumeric characters (e.g. , brackets, commas)
            String cleanword = words[i].replaceAll("[^a-zA-Z0-9]","");
            for (int j = 0; j < VALID_OS.length; j++)
            {
                //check for a match ignoring case sensitivity
                if (cleanword.equalsIgnoreCase(VALID_OS[j]))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Collects reproduction steps  from the tester
     * Enforces a minimum quality standard of at least 3 steps to prevent vague reports.
     */
    static ArrayList<String> getvalidstep(Scanner sc)
    {
        System.out.println("Enter Steps to reproduce Bugs");
        ArrayList<String> steps = new ArrayList<>();
        while (true) {
            System.out.print("\n" + (steps.size() + 1) + " ");
            String step = sc.nextLine().trim();
            // check if the user is finished entering steps
            if (step.equalsIgnoreCase("done")) {
                //Quality gate: rejects reports with fewer than 3 steps
                if (steps.size() < 3) {
                    System.out.println("Steps too vague");
                    continue;
                } else {
                    System.out.println("Steps noted Successfully");
                    break;
                }
            }
            //Add valid, non-empty steps to the ArrayList
            if (!step.isEmpty())
                steps.add(step);
        }
        return steps;
    }

    /**
     * Auto-detects the severity of the bug based on keywords in the title,
     * then asks the user to manually confirm the severity rating
     */
    static String severitychecktitle(String title,Scanner sc)
    {
        String state = "";
        //Auto dcalculating expected severity based on keywords
        if(title.toLowerCase().contains("crash") || title.toLowerCase().contains("fatal") || title.toLowerCase().contains("freeze"))
            state = "Critical";
        else if (title.toLowerCase().contains("slow") || title.toLowerCase().contains("Lag"))
            state = "High";
        else state = "Low";
       while(true) {
           System.out.println("Enter the number corresponding to Severity of bug \n 1.Critical \n 2.High \n 3.Low ");
           //input validation to prevent scanner crashes on noninteger inputs
           if (!sc.hasNextInt()) {
               System.out.println("Invalid Input");
               sc.next();// consume the bad input to prevent an infinite loop
           }
           int severitynumber = sc.nextInt();
           sc.nextLine();// consume the leftover new line characters
           //verify the user's manual input matches the auto calculated state
           if ((severitynumber == 1 && state.equalsIgnoreCase("Critical") || (severitynumber == 2 && state.equalsIgnoreCase("High") || (severitynumber == 3 && state.equalsIgnoreCase("Low"))))) {
               System.out.println("Severity noted Successfully");
               return state;
           }
           System.out.println("Severity Error");
       }
    }
    // outputs the final formatted bug report to the console
    static void result(String title,ArrayList<String> steps,String severity)
    {
        System.out.println("Bug Report Maker \n ****************");
        System.out.println("Title = " + title);
        System.out.println("Severity = " + severity);
        System.out.println("Steps = " + steps);
    }
}
