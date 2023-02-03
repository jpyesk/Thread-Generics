package GenericMiniExample;


class Printer<T>{
    public void printArray(T[] array){
        for (T el: array){
            System.out.println(el);
        }
    }
}
 public class Solution {
     public static void main(String[] args) {
         Printer prints = new Printer();
         Integer[] ints = new Integer[]{1, 2, 3};
         String[] strings = new String[]{"Hello", "World"};
         prints.printArray(ints);
         prints.printArray(strings);

     }
 }
