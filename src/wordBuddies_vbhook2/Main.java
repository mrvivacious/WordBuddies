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
        int numberOfBuddies = 0;

        //initialization
        for (int i = 0; i < substrings.length; i++) {
            substrings[i] = "";
        }
        //select initial word
        for (int initialWord = 0; initialWord < args.length; initialWord++) {
            //select word to test for WordBuddies
                for (int testWord = 0; testWord < args.length; testWord++) {
                    if ( initialWord != testWord ) {
                        //iterates initial word
                        for (int k = 0; k < args[ initialWord ].length(); k++) {
                            //iterates test word
                            for (int l = 0; l < args[ testWord ].length(); l++) {
                                if ( args[ initialWord ].substring(k, k + 1).equalsIgnoreCase(args[ testWord ].substring(l, l + 1) ) &&
                                        (k == l) && foundBuddy) {
                                    numberOfBuddies++;
                                    if( numberOfBuddies >= 2 ) {
                                        return "Not Buddies";
                                    }
                                }
                                else if( args[ initialWord ].substring(k, k + 1).equalsIgnoreCase(args[ testWord ].substring(l, l + 1)) &&
                                        (k == l) ) {
                                    substrings[ initialWord ] += args[ initialWord ].substring(k, k + 1).toLowerCase();
                                }
                            } //testWord iteration
                        } //initialWord iteration
                    }
                    //if buddies have been found, ensure no additional words affect the substring array's items
                    if ( !substrings[ initialWord ].equals("") && substrings[ initialWord ].length() >= 2 ) {
                        foundBuddy = true;
                    }
                    else
                        substrings[ initialWord ] = "";
                }
            foundBuddy = false;
            numberOfBuddies = 0;
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