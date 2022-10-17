package Module10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    {
        try
        {
            FileInputStream fis = new FileInputStream("numbers.txt");
            Scanner sc=new Scanner(fis);
            while(sc.hasNextLine())
            {
                numCheck(sc.nextLine());
            }
            sc.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void numCheck(String s){
            if (bracketsCheck(s) || hyphenCheck(s, 3)) System.out.println(s);
    }

    protected boolean bracketsCheck(String number){
        String[] subNumber = number.strip().split(" ");
        if (subNumber.length == 2){
            if (subNumber[0].startsWith("(") && (subNumber[0].endsWith(")"))){
                if (isNumeric(subNumber[0].substring(1,3))){
                    return hyphenCheck(subNumber[1], 2);
                }
            }
        }
        return false;
    }

    protected boolean hyphenCheck(String number, int parts){
        String[] subNumber = number.strip().split("-");
        if (subNumber.length == parts) {
            for (String s: subNumber) {
                if (!isNumeric(s)) return false;
            }
            return true;
        }
        return false;
    }

    protected static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
