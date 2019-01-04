/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac6iii;

import static sorting.BubbleSort.swap;

/**
 *
 * @author Tarc
 */
public class SortArray {
    
    public static void selectionSort(int a[], int n){
        int last = n-1;
        
        int pos = 0;
        
        for(int i=0; i<last; i++)
        {
            pos = getSmallest(a, i, last);
            swap(a, i, pos);
            System.out.print("Step " + (i+1) + " >> ");
            printArray(a, n);
        }
    }
    
    public static void revisedSelectionSort(int a[], int n){
        int last = n-1;
        
        int pos = 0;
        
        for(int i=0; i<last; i++)
        {
            pos = getSmallest(a, i, last);
            swap(a, i, pos);
            System.out.print("Step " + (i+1) + " >> ");
            printArray(a, n);
        }
    }
    
    public static int getSmallest(int a[], int first, int last){
        int smallest = a[first];
        int pos = first;
        for(int i=first; i<=last; i++)
        {
            if(a[i]<smallest){
                smallest = a[i];
                pos = i;
            }
        }
        return pos;
    }
    
    public static void insertionSort(int a[], int n){
        int element = a[0];
        for(int i=1; i<n; i++){
           element = a[i];
           insertInOrder(element, a, i-1, n);
        }
    }
    
    public static void insertInOrder(int element, int[] a, int first, int n){
        int index = first;
        while(index >=0 && element < a[index]){
            a[index+1] = a[index];
            index --;
        }
        a[index+1]=element;
        System.out.print("Step " + (first+1) + " >> ");
        printArray(a, n);
    }
    
    public static void printArray(int[] a, int n){
        
        for(int i=0; i<n; i++)
                System.out.print(a[i] + " ");
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        int[] a = {2, 5, 1, 3, 4};
        System.out.println("Selection Sort : ");
        selectionSort(a, a.length);
        
        int[] b = {2, 5, 1, 3, 4};
        System.out.println("Insertion Sort : ");
        insertionSort(b, b.length);
        
        int[] c = {2, 5, 1, 3, 4};
        System.out.println("Revised Selection Sort : ");
        revisedSelectionSort(c, c.length);
        
    }
    
}
