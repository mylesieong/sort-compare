package com.myles.fun;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        System.out.println("Hello World!");
        int[] aa=new int[]{34,23,56,87,654,2,1,46,87,879,3421,45,86,1,1,1,1,1,1};
        printArray(aa);
        quick_sort(aa,0,aa.length - 1);
        printArray(aa);
    }
    
    public static void printArray(int[] array) {  
        System.out.print("{");  
        for (int i = 0; i < array.length; i++) {  
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
}
