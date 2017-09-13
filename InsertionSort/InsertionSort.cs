using System;
using System.Collections.Generic;
using System.IO;
class Solution {
    
static void printArray(int[] ar) {
    for (int i = 0; i < ar.Length; i++) {
        Console.Write(ar[i] + " ");
    }
    Console.WriteLine();
}
static void insertionSort(int[] ar) {
    for (int i = 1; i < ar.Length; i++) {
        if (ar[i] < ar[i-1]) {
            int j = i;
            while(j > 0 && ar[j] < ar[j-1]) {
                int temp = ar[j];
                ar[j] = ar[j-1];
                ar[j-1] = temp;
                j--;
            }
        }
        printArray(ar);
    }
}
    
static void Main(String[] args) {
           
           int _ar_size;
           _ar_size = Convert.ToInt32(Console.ReadLine());
           int [] _ar =new int [_ar_size];
           String elements = Console.ReadLine();
           String[] split_elements = elements.Split(' ');
           for(int _ar_i=0; _ar_i < _ar_size; _ar_i++) {
                  _ar[_ar_i] = Convert.ToInt32(split_elements[_ar_i]); 
           }

           insertionSort(_ar);
    }
}
