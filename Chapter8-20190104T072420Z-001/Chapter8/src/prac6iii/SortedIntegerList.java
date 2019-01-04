/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac6iii;

import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author TAR UC
 */
public class SortedIntegerList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        ListInterface<Integer> sortedList = new SortedArrayList<>();
//        
//       
//        
//        for(int i=1; i<=10; i++){
//            sortedList.add(i);
//        }
//        System.out.println("\nadding 10 more items: \n" + sortedList.toString());
//        
//        System.out.println("Search a number >> ");
//        Scanner scan = new Scanner(System.in);
//        
//        int entry = scan.nextInt();
//        int foundPos = sortedList.search(entry);
//        if(foundPos >=0){
//            System.out.println(entry + " is found at index " + foundPos);
//        }
//        else
//            System.out.println(entry + " is not found");
//        for(int i=1; i<=10; i++){
//            sortedList.add(i);
//        }
 
//        sortedList.add(1);
//        sortedList.add(3);
//        sortedList.add(2);
//        System.out.println("\nSorted List: \n" + sortedList.toString());
//        
//        
//        sortedList.remove();
//        System.out.println("\nAfter remove the first: \n" + sortedList.toString());
//        
//        sortedList.remove(sortedList.getSize()-1);
//        System.out.println("\nAfter remove the last: \n" + sortedList.toString());
             
        
        
    	
        int[] numbers = new int[20];
        int size = 0;
        Random randomGenerator = new Random();
        System.out.println("Random numbers:");
        int randomInt =0;
        for (int idx = 0; idx < 10; ++idx){
            randomInt = randomGenerator.nextInt(100);
            System.out.print(randomInt + " ");
            numbers[idx] = randomInt;
            size++;
//          sortedList.add(randomInt);
        }
        System.out.println("\n");
        //bubbleSort(numbers, size);
        //selectionSort(numbers, size);
        //recursiveSelectionSort(numbers, size);
        //insertionSort(numbers, size);
        quickSort(numbers, size);
        System.out.println("\n\nSorted Array:");
        printArray(numbers, size);
   
    }
    
    public static void bubbleSort(int a[], int n){
        boolean sorted = false;
        int count = 0;
        for(int x = 1; x<n && !sorted; x++){
            sorted=true;
            for(int y = 0; y<n-x; y++)
            {
                if(a[y]> a[y+1]){
                    swap(a, y, y+1);
                    sorted=false;
                }
                System.out.print("Step " + (++count) + " >> ");
                printArray(a, n);
            }
        }
    }
    
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
    
    public static void recursiveSelectionSort(int a[], int n)
    {
        recursiveSelectionSort(a, 0, n-1);
    }
    
    public static void recursiveSelectionSort(int a[], int first, int last){
        if(first <= last){
            int pos = getSmallest(a, first,last);
            swap(a, first, pos);
            System.out.print("Step " + (first+1) + " >> ");
            printArray(a, last+1);
            recursiveSelectionSort(a, first+1, last);
        }
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
    
    public static void quickSort(int[]a, int n){

        quickSort(a, 0, n-1);
    }
    public static void quickSort(int[] a, int first, int last){
        if(first<last){
            int pivotIndex = partition(a, first, last);
            quickSort(a, first, pivotIndex-1);
            quickSort(a, pivotIndex+1, last);
        }
            
    }
    
    public static int partition(int[] a, int first, int last){
        //      Step 1 − Choose the highest index value as pivot
//      Step 2 − Take two variables to point left and right of the list excluding pivot
//      Step 3 − left points to the low index
//      Step 4 − right points to the high
//      Step 5 − while value at left is less than pivot move right
//      Step 6 − while value at right is greater than pivot move left
//      Step 7 − if both step 5 and step 6 does not match swap left and right
//      Step 8 − if left ≥ right, the point where they met is new pivot
        int pivot = a[last];
        int leftIndex = first;
        int rightIndex = last-1;
        
        while(true){
            while( a[leftIndex] < pivot){
                leftIndex++;
            }
            //System.out.println("leftIndex: " + leftIndex);
            while(rightIndex >= 0 && a[rightIndex] >= pivot){
                rightIndex--;
  
            }
            //System.out.println("rightIndex: " + rightIndex);
            if(leftIndex > rightIndex){
                System.out.print(" >> ");
                printArray(a, last+1);
         
                break;
            }
            else{
                swap(a, leftIndex, rightIndex);  
            }
            System.out.print(" >> ");
            printArray(a, last+1);
        }
        swap(a, leftIndex, last);
        System.out.print(" >> ");
        printArray(a, last+1);
        return leftIndex;
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
    
    
    public static void swap(int[] a, int first, int second){
        int temp;
        temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
    
    public static void printArray(int[] a, int n){
        
        for(int i=0; i<n; i++)
                System.out.print(a[i] + " ");
        System.out.println("\n");
    }
    
}
