package AuthenticationValidator;

import java.util.*;
/**
 * Validates user credentials against a hardcoded Umbrella Corporation database.
 * Tracks login attempts and assigns Admin or Agent access roles based on credentials.
*/
public class AuthValidator
{
    // 2D Array acting as our mock database[Username, Password, Role]
    static final String[][] database = {{"awesker","Ouroboros!","Admin"},{"lkennedy","Rpd_098","Agent"},{"cRedfield","BoulderPunch","Agent"}};
    // number of columns in our database
    static final int count = database[0].length;

    static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        checkAdmin(sc);
    }

    /**
     * Prompts the user for credentials and checks them against the database.
     * Allows a maximum of 3 attempts before locking the terminal out.
     */

    static int verifyCredentials(Scanner sc) {
        int i = 0;
        int attempts = 1; //counter to track failed logins
        while (attempts<=3) {
                System.out.println("Enter username");
                String name = sc.nextLine().trim();
                System.out.println("Enter password");
                String password = sc.nextLine();

                // Iterate through the database to find a matching username and password pair
                for(i=0;i<count;i++) {
                    if (name.equals(database[i][0]) && password.equals(database[i][1])) {
                        System.out.println("Credentials are valid");
                        return i; // Return the row index of the verified user
                    }
                }
            System.out.println("Either username or password is incorrect \n Try again \n");
            attempts++;
            }
        System.out.println("Multiple wrong attempts \n LOCKING OUT");
        return -1; // return -1 to indicate failure and trigger lockdown
        }

    /**
     *Determines the role of the verified user based on  the database index.
     * */

    static boolean checkAdmin(Scanner sc)
    {
        int i = verifyCredentials(sc); // Fetch the user index from the verification method
        // If verifiedCredentials returned -1, the user is locked out
        if (i==-1) {
            return false;
        }
        // Chec the #rd column (index 2) for the user's role authorization
        if("Admin".equals(database[i][2]))
        {
            System.out.println("Welcome Admin");
            return true;
        }
        else System.out.println("Welcome Agent");
        return true;
    }
}

