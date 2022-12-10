Maryfrances Umeora
mumeora (@u.rochester.edu)
HW 01
Lab Times: MW 2:00-3:15
Grader: Linan Li
I did not collaborate with anyone on this assignment


EXPLANATION
We know 'brag' and 'grab' are anagrams. Notice that if the letters are arranged alphabetically, we get abrg for both. Thus, for the anagram checker, I separated the words into arrays of each individual letter, sorted them alphabetically, then checked each element of the arrays to make sure they were all the same. I made sure to convert each letter to lowercase first though because Java puts capital letters before lowercase letters, whether it is alphabetically correct or not.
For the rotation checker, I noticed that if you were given ABCD, then ABCDABCD contains the substring CDAB, which is the rotation of ABCD. Thus, in this program, I concatenated one of the strings with itself then checked to see if the other string was a substring. This also works vice-versa.

COMPILE AND RUN STEPS
Just hit run and follow the printed instructions.