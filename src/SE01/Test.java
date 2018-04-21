package SE01;


import java.lang.*;
import java.util.*;
public class Test {

    public static void main(String[] args) {


        String n = Integer.toString(9085);
        char[] charArray = n.toCharArray();
        List<Integer> cia = new ArrayList<Integer>();
        for (int i = 0;i<charArray.length; i++) {
            int c = Character.getNumericValue(charArray[i]);
            cia.add(c);
        }
        System.out.println(cia+" ");
        cia.sort(Integer::compareTo);
        System.out.println(cia+" ");
    }

    }


