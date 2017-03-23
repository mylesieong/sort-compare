package com.myles.fun;

import org.joda.time.DateTime;

public class App{
    public static void main( String[] args ){
        int size = args.length>0?Integer.parseInt(args[0]):50;
        int[] aa = new int[size];
        for (int i=0; i<size; i++){
            aa[i] = (int)Math.round(Math.random()*1000000);  //random a 6 digit number
        }
        
        /* Quicksort*/
        int[] a1=aa.clone();
        printArray(a1);
        System.out.println("Start quick sort at:" + DateTime.now());
        quick_sort(a1,0,a1.length - 1);
        System.out.println("Finish quick sort at:" + DateTime.now());
        printArray(a1);
        
        /* insertion*/
        int[] a2=aa.clone();
        printArray(a2);
        System.out.println("Start insertion sort at:" + DateTime.now());
        insertion_sort(a2);
        System.out.println("Finish insertion sort at:" + DateTime.now());
        printArray(a2);
        
        /* insertion*/
        int[] a3=aa.clone();
        printArray(a3);
        System.out.println("Start insertion sort at:" + DateTime.now());
        heap(a3);
        System.out.println("Finish insertion sort at:" + DateTime.now());
        printArray(a3);
        
    }
    
    public static void printArray(int[] array) {  
        System.out.print("{");
        //head
        for (int i = 0; i < 3; i++) {  
            System.out.print(array[i]);  
            if (i < array.length - 1) {  
                System.out.print(", ");  
            }  
        }  
        
        //middle
        System.out.print("...(" + array.length + ")...");  
        
        //tail
        for (int i = array.length-3; i < array.length; i++) {  
            System.out.print(array[i]);  
            if (i < array.length - 1) {  
                System.out.print(", ");  
            }  
        }  
        System.out.println("}");  
    }  

    public static void quick_sort(int s[], int l, int r)  
    {  
        if (l < r)  
        {  
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1  
            int i = l, j = r, x = s[l];  
            while (i < j)  
            {  
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数  
                    j--;    
                if(i < j)   
                    s[i++] = s[j];  
                  
                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数  
                    i++;    
                if(i < j)   
                    s[j--] = s[i];  
            }  
            s[i] = x;  
            quick_sort(s, l, i - 1); // 递归调用   
            quick_sort(s, i + 1, r);  
        }  
    } 
    
    public static void insertion_sort(int s[]){
        int temp;
        for (int i = 0; i < s.length; i++){
            for (int j=i; j>0; j--){
                if (s[j]> s[j-1]){
                    temp = s[j];
                    s[j] = s[j-1];
                    s[j-1] = temp;
                }
            }
        }
    }
    
    public static void heapify(int a[], int n, int i) {
		int max, child;
		child = 2 * i + 1;
		max = i;
		if (child < n)
			if (a[child] > a[max])
				max = child;
		if (child + 1 < n)
			if (a[child + 1] > a[max])
				max = child + 1;
		if (max != i) {
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			heapify(a, n, max);
		}
	}

	public static void buildheap(int a[]) {
		for (int i = a.length / 2 - 1; i >= 0; i--)
			heapify(a, a.length, i);
	}

	public static void heap(int a[]) {
		buildheap(a);
		for (int i = a.length - 1; i >= 1; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			heapify(a, i, 0);
		}
	}

}
