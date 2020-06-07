
package dalanehmarg;

import java.util.Scanner;
import java.util.regex.Pattern;
import newGame.NewGame;

public class DalanehMarg {
    public static int NumberOfBullet=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
        System.out.println("Please Enter Width  only digits: ");
        /////////////////////
        //NumberOfBullet=sc.nextInt();
        String width=sc.next();
        if (regexpr(width))
        {
            NewGame newgame=new NewGame(Integer.parseInt(width));
        }
        else
        {}
        
    }
    }

    private static boolean regexpr(String width) {
        boolean matches;
        matches = Pattern.matches("\\d+", width);
        return matches;
    }
    
}
