package wordBuddies_vbhook2;

/**
 * WordBuddies
 * @author vbhook2
 */

public class Main {

    public static void main(String[] args) {
            System.out.print(isWordBuddies(args));
    }

    public static String isWordBuddies(String[] args) {
        String[] substrings = new String[args.length];
        String buddies = "";
        boolean foundBuddy = false;
        boolean noBuddy = false;
        int counter = 0;

        //initialization
        for (int i = 0; i < substrings.length; i++) {
            substrings[i] = "";
        }
        //select initial word
        for (int i = 0; i < args.length; i++) {
            //select word to test for WordBuddies
                for (int j = 0; j < args.length; j++) {
                    if ( i != j ) {
                        //change this to iterate every index
                        for (int k = 0; k < args[i].length(); k++) {
                            //change this to iterate every index of test word
                            for (int l = 0; l < args[j].length(); l++) {
                                if ( args[i].substring(k, k + 1).equalsIgnoreCase(args[j].substring(l, l + 1) ) &&
                                        (k == l) && foundBuddy) {
                                    counter++;                            //"buddy" qualifies with x > 2 matches, one matching character
                                    if( counter >= 2 ) {                  //should not be treated as a buddy and therefore not print "Not Buddies"
                                        return "Not Buddies";
                                    }
                                }
                                else if( args[i].substring(k, k + 1).equalsIgnoreCase(args[j].substring(l, l + 1)) &&
                                        (k == l) ) {
                                    substrings[i] += args[i].substring(k, k + 1).toLowerCase();
                                }
                            }
                        }
                    }
                    //if buddies have been found, ensure no additional words affect the substring array's items
                    if ( !substrings[i].equals("") && substrings[i].length() >= 2 ) {
                        foundBuddy = true;
                    }
                    else
                        substrings[i] = "";
                }
            //reset counter for next word
            foundBuddy = false;
            counter = 0;
        }
        //does everyone have a buddy?
        for (int i = 0; i < substrings.length; i++) {
            if( substrings[i].equals("") )
                noBuddy = true;
        }
        if( noBuddy )
            return "Not Buddies";
        else {
            for (int i = 0; i < substrings.length; i++) {
                buddies += substrings[i];
                if( i != substrings.length-1 ) {
                    buddies += " ";
                }
            }
            //If absolutely nothing was passed into the program
            if( buddies.trim().equals("") ) {
                return "Not Buddies";
            }
            else
                return buddies;
        }
    }
}