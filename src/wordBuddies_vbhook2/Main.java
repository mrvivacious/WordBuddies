package wordBuddies_vbhook2;

/**
 * WordBuddies
 * @author vbhook2
 */

public class Main {

    public static void main(String[] args) {
        System.out.print(isWordBuddies(args));
    }

    /**
     *This class allows us to run our test cases through its return capabilities
     * @param args passed in as String array
     * @return A String array of the buddies, or "Not Buddies" should the args fail
     */
    public static String isWordBuddies(String[] args) {
        String[] substrings = new String[args.length];
        String buddies = "";
        boolean foundBuddy = false;
        int numberOfBuddies = 0;

        //initialization
        initialization(substrings);
        //select initial word
        for (int initialWord = 0; initialWord < args.length; initialWord++) {
            //select word to test for WordBuddies
                for (int testWord = 0; testWord < args.length; testWord++) {
                    if ( initialWord != testWord ) {
                        //iterates initial word
                        for (int k = 0; k < args[ initialWord ].length(); k++) {
                            //iterates test word
                            for (int l = 0; l < args[ testWord ].length(); l++) {
                                String init = args[ initialWord ].substring(k, k+1);
                                String test = args[ testWord ].substring(l, l + 1);
                                if ( init.equalsIgnoreCase( test ) &&
                                        ( k == l ) && foundBuddy ) {
                                    numberOfBuddies++;
                                    if( numberOfBuddies >= 2 ) {
                                        return "Not Buddies";
                                    }
                                }
                                else if( init.equalsIgnoreCase( test ) &&
                                        ( k == l ) ) {
                                    substrings[ initialWord ] += init.toLowerCase();
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
        if( buddyTest( substrings ) )
            return "Not Buddies";
        else {
            for ( int index = 0; index < substrings.length; index++ ) {
                buddies += substrings[ index ];
                if( index != substrings.length-1 ) {
                    buddies += " ";
                }
            }
            //If absolutely nothing was passed into the program
            if( buddies.trim().equals( "" ) ) {
                return "Not Buddies";
            }
            else
                return buddies;
        }
    }

    /**
     * Initialize an array of the size of the args
     * @param substrings
     * @return
     */
    public static String[] initialization(String[] substrings) {
        for (int i = 0; i < substrings.length; i++) {
            substrings[i] = "";
        }
        return substrings;
    }

    /**
     * Checks for any unchanged indexes. This would mean that a part of the arguments has no buddy
     * @param substrings
     * @return true if an argument is missing a buddy, false if every argument has a buddy
     */
    public static boolean buddyTest(String[] substrings) {
        for (int i = 0; i < substrings.length; i++) {
            if( substrings[i].equals( "" ) )
                return true;
        }
        return false;
    }
}