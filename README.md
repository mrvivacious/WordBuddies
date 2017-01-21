# WordBuddies

Write a class WordBuddies that has a main method that accepts an array of strings as an argument. 
Each string can consist of any number of any type of (non-space) character. 
When invoked on the command lie, your program should accept a space-seperated collection of strings, and they will be parsed into the 
args String array with each String as a different element of the array.

We define a pair of words to be "buddies" if in at least 2 positions (counted from the beginning of the word), both words have the same 
character (independent of case). 
That is the words 'Sneeze' and 'slacker' to be buddies because they have the same character in the 1st and 6th position.

Your main funciton should identify if every input string has exactly one buddy. If so, you should print out, in the position of the string
in the input the set of shared characters tht make the pair of words buddies (see the example below). If not, it should print out 'Not Buddies'.

Examples: 

input: scar feature fee tsarina
output: ar fe fe ar

input: scar feature fee fear
output: Not Buddies

--CS126 spring 2017

Initial commit:
Program works just fine, but only checks for two (instead of at least two) letters which are consecutive (letters just need to have same indeces). 
Whoops.

