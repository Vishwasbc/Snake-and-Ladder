import java.util.Scanner;
class SnL{
    Scanner s=new Scanner(System.in);
    int[][] play;
    int[] pos;
    int n;
    public final int w=100;
    int cheak=0;
    SnL(int n){
        this.n=n;
        play=new int[2][n];
        pos=new int[n];
        for(int i=0;i<n;i++){
            play[0][i] = i + 1;
            pos[i]=0;
        }
    }
    int rollDice(){
        return ((int) (((Math.random() * 100) % 6) + 1));
    }
    int cheakLaddernSnake(int a,int i){
        switch(a){
            case 5: System.out.println("Player "+i+" is at "+a);
                         System.out.println("Hurray....\nYou Found A Ladder\nYou Climbed Up!!!!!!!");
                        return 14;
            case 19: System.out.println("Player "+i+" is at "+a);
                          System.out.println("Hurray....\nYou Found A Ladder\nYou Climbed Up!!!!!!!");
                          return 36;
            case 24:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Hurray....\nYou Found A Ladder\nYou Climbed Up!!!!!!!");
                          return 42;
            case 62:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Hurray....\nYou Found A Ladder\nYou Climbed Up!!!!!!!");
                          return 72;
            case 75:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Hurray....\nYou Found A Ladder\nYou Climbed Up!!!!!!!");
                          return 91;
            case 84:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Hurray....\nYou Found A Ladder\nYou Climbed Up!!!!!!!");
                          return 95;
            case 25:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Oops!!!!\nYou Found A Snake........\nYou Fell Down");
                          return 7;
            case 37:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Oops!!!!\nYou Found A Snake........\nYou Fell Down");
                           return 17;
            case 44:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Oops!!!!\nYou Found A Snake........\nYou Fell Down");
                           return  32;
            case 68:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Oops!!!!\nYou Found A Snake........\nYou Fell Down");
                           return 9;
            case 74:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Oops!!!!\nYou Found A Snake........\nYou Fell Down");
                           return 52;
            case 94:System.out.println("Player "+i+" is at "+a);
                          System.out.println("Oops!!!!\nYou Found A Snake........\nYou Fell Down");
                           return 16;
            default:return a;
        }
    }
    void snakeNLadder(){
        while(cheak<n){
            for(int i=0;i<n;i++){
                if(play[1][i]==w){
                    System.out.println("To roll the Dice,Press r");
                    char ch=s.next().charAt(0);
                    while(ch!='r') {
                        System.out.println("Please Enter r");
                        ch = s.next().charAt(0);
                    }
                    continue;
                }
                int val=rollDice();
                System.out.println("Player "+play[0][i]+" is at  "+play[1][i]);
                System.out.println("You Got "+val);
                int temp=play[1][i]+val;
                if(temp>w)
                    System.out.println("Player "+play[0][i]+" cannot Move");
                else if(temp==w){
                    System.out.println("Player "+play[0][i]+" has completed the game");
                    play[1][i]=temp;
                    cheak++;
                    posi(play[0][i]);
                }
                else {
                    play[1][i]=cheakLaddernSnake(temp,i+1);
                    System.out.println("Player "+play[0][i]+" is at  "+play[1][i]);
                }
                System.out.println("To roll the Dice,Press r");
                char ch=s.next().charAt(0);
                while(ch!='r'){
                    System.out.println("Please Enter r");
                    ch=s.next().charAt(0);
                }
            }
        }
    }
    int j=0;
    void posi(int i){
        pos[j]=i;
        j++;
    }
}
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Snake and Ladder");
        System.out.println("Enter The No Of Players");
        int n = sc.nextInt();
        SnL s = new SnL(n);
        System.out.println("To roll the Dice,Press r");
        char ch = sc.next().charAt(0);
        while (ch != 'r') {
            System.out.println("Please Enter r");
            ch = sc.next().charAt(0);
        }
        s.snakeNLadder();
        System.out.println("Final Results");
        System.out.println("Position | Player");
        System.out.println("-----------------");
        for (int i = 0; i < n; i++){
            System.out.println("  " + (i + 1) + "   |  " + s.pos[i] + "  ");
            System.out.println("-----------------");
       }
       
    }
}