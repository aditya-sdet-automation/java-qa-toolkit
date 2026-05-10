package AuthenticationValidator;

import java.util.*;
public class AuthValidator
{
    static final String[][] database = {{"awesker","Ouroboros!","Admin"},{"lkennedy","Rpd_098","Agent"},{"cRedfield","BoulderPunch","Agent"}};
    static final int count = database[0].length;

    static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        checkAdmin(sc);
    }

    static int verifyCredentials(Scanner sc) {
        int i = 0;
        int attempts = 1;
        while (attempts<=3) {
                System.out.println("Enter username");
                String name = sc.nextLine().trim();
                System.out.println("Enter password");
                String password = sc.nextLine();
                for(i=0;i<count;i++) {
                    if (name.equals(database[i][0]) && password.equals(database[i][1])) {
                        System.out.println("Credentials are valid");
                        return i;
                    }
                }
            System.out.println("Either username or password is incorrect \n Try again \n");
            attempts++;
            }
        System.out.println("Multiple wrong attempts \n LOCKING OUT");
        return -1;
        }

    static boolean checkAdmin(Scanner sc)
    {
        int i = verifyCredentials(sc);
        if (i==-1) {
            return false;
        }
        if("Admin".equals(database[i][2]))
        {
            System.out.println("Welcome Admin");
            return true;
        }
        else System.out.println("Welcome Agent");
        return true;
    }
}

