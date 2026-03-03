package Recursion;

import java.util.ArrayList;

//Lecture-Arrayquestions
public class LinearSearch {
    public static boolean check(int nums[],int target,int i){
        if(i==nums.length) return false;
        return nums[i]==target || check(nums, target, i+1);
    }
    public static int findIndex(int nums[],int target,int i){
        if(i==nums.length) return -1;
        if(nums[i]==target) return i;
        else return findIndex(nums, target, i+1);
    }
    public static int findIndexFromLast(int nums[],int target,int i){
        if(i==-1) return -1;
        if(nums[i]==target) return i;
        else return findIndex(nums, target, i-1);
    }
    public static ArrayList<Integer> findList(int nums[],int target,int index,ArrayList<Integer> list){
        if(index==nums.length){
            return list;
        }
        if(nums[index]==target)list.add(index);
        return findList(nums, target, index+1, list);
    }
    public static ArrayList<Integer> returnList(int nums[],int target,int index){
        ArrayList<Integer> list=new ArrayList<>();
        if(index==nums.length){
            return list;
        }
        if(target==nums[index]){
            list.add(index);
        }
        ArrayList<Integer> l=returnList(nums, target, index+1);
        list.addAll(l);
        return list;
    }
    public static void main(String[] args) {
        int nums[]={1,4,12,3,4};
        System.out.println(check(nums, 127, 0));
        System.out.println(findIndex(nums, 3, 0));
        System.out.println(findIndexFromLast(nums, 3, nums.length-1));
        System.out.println(findList(nums, 4, 0,new ArrayList<Integer>()));
        System.out.println(returnList(nums, 4, 0));
    }
}
