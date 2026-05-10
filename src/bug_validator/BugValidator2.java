package bug_validator;

import java.util.*;
public class BugValidator2
{

    static final String[] VALID_OS = {"Android", "iOS", "Linux", "Windows" };
    static final String KEYWORD = "checkout";

    static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String title = getvalidtitle(sc);
        ArrayList<String> step = getvalidstep(sc);
        String severity = severitychecktitle(title,sc);
        result(title, step, severity);
    }
    static String getvalidtitle(Scanner sc)
    {
        while(true)
        {
            System.out.println("Enter Bug Title");
            String usertitle = sc.nextLine().trim();
            if (hasOS(usertitle)) {
                System.out.println("Title Validated: OS detected");
                return usertitle;
            }
            System.out.println("Title Invalidated");;
        }
    }
    static boolean hasOS(String title)
    {
        String[] words = title.split("\\s+");
        for (int i = 0; i < words.length; i++)
        {
            String cleanword = words[i].replaceAll("[^a-zA-Z0-9]","");
            for (int j = 0; j < VALID_OS.length; j++)
            {
                if (cleanword.equalsIgnoreCase(VALID_OS[j]))
                {
                    return true;
                }
            }
        }
        return false;
    }
    static ArrayList<String> getvalidstep(Scanner sc)
    {
        System.out.println("Enter Steps to reproduce Bugs");
        ArrayList<String> steps = new ArrayList<>();
        while (true) {
            System.out.print("\n" + (steps.size() + 1) + " ");
            String step = sc.nextLine().trim();
            if (step.equalsIgnoreCase("done")) {
                if (steps.size() < 3) {
                    System.out.println("Steps too vague");
                    continue;
                } else {
                    System.out.println("Steps noted Successfully");
                    break;
                }
            }
            if (!step.isEmpty())
                steps.add(step);
        }
        return steps;
    }
    static String severitychecktitle(String title,Scanner sc)
    {
        String state = "";
        if(title.toLowerCase().contains("crash") || title.toLowerCase().contains("fatal") || title.toLowerCase().contains("freeze"))
            state = "Critical";
        else if (title.toLowerCase().contains("slow") || title.toLowerCase().contains("Lag"))
            state = "High";
        else state = "Low";
       while(true) {
           System.out.println("Enter the number corresponding to Severity of bug \n 1.Critical \n 2.High \n 3.Low ");
           if (!sc.hasNextInt()) {
               System.out.println("Invalid Input");
               sc.next();
           }
           int severitynumber = sc.nextInt();
           sc.nextLine();
           if ((severitynumber == 1 && state.equalsIgnoreCase("Critical") || (severitynumber == 2 && state.equalsIgnoreCase("High") || (severitynumber == 3 && state.equalsIgnoreCase("Low"))))) {
               System.out.println("Severity noted Successfully");
               return state;
           }
           System.out.println("Severity Error");
       }
    }
    static void result(String title,ArrayList<String> steps,String severity)
    {
        System.out.println("Bug Report Maker \n ****************");
        System.out.println("Title = " + title);
        System.out.println("Severity = " + severity);
        System.out.println("Steps = " + steps);
    }
}
