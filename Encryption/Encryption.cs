using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
class Solution {
    /* An English text needs to be encrypted using the following encryption     
    *scheme. First, the spaces are removed from the text. Let L be the length  
    *of this text. 
    *Then, characters are written into a grid, whose rows and columns have          
    *the following constraints: sqrt(L) <= row <= column < sqrt(L)
    *For example, the sentence ’if man was meant to stay on the ground god   
    *would have given us roots’ after removing spaces is  characters long, so   
    *it is written in the form of a grid with 7 rows and 8 columns.
    *The encoded message is obtained by displaying the characters in a 
    *column, inserting a space, and then displaying the next column and   
    *inserting a space, and so on. For example, the encoded message for the 
    *above sentence is: imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes           
    *aohghn sseoau */

    static void Main(String[] args) {
        string str = Console.ReadLine();
        double n = Math.Sqrt(str.Length);
        int rows, columns;
        if(n % 1 == 0) {
            rows = (int) n;
            columns = (int) n;
        }
        else {
            rows = (int) n;
            columns = (int) n+1;
        }
        if (rows*columns < str.Length) rows += 1;
        int spaces = (rows*columns) - str.Length;
        for(int i = 0; i < spaces; i++) {
            str += " ";
        }
        /* just print straight from the string */
        for(int i = 0; i < columns; i++) {
            for(int j = 0; j < rows; j++) {
                if ((str[columns*j + i]) != ' ') Console.Write(str[(columns*j) + i]);
            }
            Console.Write(" ");
        }
    }
}
