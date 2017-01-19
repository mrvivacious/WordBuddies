package wordBuddies_vbhook2;

/**
 * WordBuddies
 * @author vbhook2
 */

public class Main {

    public static void main(String[] args) {
        String[] substrings = new String[args.length];
        int counter = 0;
        boolean multiple = false;
        boolean noBuddy = false;

        //initialization
        for (int i = 0; i < substrings.length; i++) {
            substrings[i] = "none";
        }
        //select initial word
        for (int i = 0; i < args.length; i++) {
            //select word to test for WordBuddies
                for (int j = 0; j < args.length; j++) {
                    if (i != j ) {
                        //substring selection process for initial word
                        for (int k = 0; k < args[i].length() - 1; k++) {
                            //substring selection process for test word
                            for (int l = 0; l < args[j].length() - 1; l++) {
                                if (args[i].substring(k, k + 2).equalsIgnoreCase(args[j].substring(l, l + 2))) {
                                    counter++;
                                    substrings[i] = args[i].substring(k, k + 2);
                                }

                            }

                        }

                    }
                }
            //does one word have multiple buddies?
            if( counter > 1 ) {
                multiple = true;
            }
            //reset counter for next word
            counter = 0;
        }
        //does everyone have a buddy?
        for (int i = 0; i < substrings.length; i++) {
            if(substrings[i].equals("none"))
                noBuddy = true;
        }
        if( multiple || noBuddy)
            System.out.print("Not Buddies");
        else
            for (int i = 0; i < substrings.length; i++) {
                System.out.print(substrings[i] + " ");
            }
    }
}
