import java.util.Scanner;
public class LastBiscuit {

    public static final int BARREL_ONE = 6;
    public static final int BARREL_TWO = 8;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int currentPlayer = 1; // We are starting the game with player 1
        int barrelOne = BARREL_ONE; // Barrel 1 starts with 6 biscuits
        int barrelTwo = BARREL_TWO; // Barrel 2 starts with 8 biscuits
        String barrelChoice; // To choose the barrel
        int biscuits = 0; // To choose the barrel
        int playerOneUsedSkip = 0;
        int playerTwoUsedSkip = 0;



        // display of the biscuits in barrel
        System.out.println("Biscuits Left - Barrel 1: " + barrelOne);
        System.out.println("Biscuits Left - Barrel 2: " + barrelTwo);
        System.out.println("Player Turn: " + currentPlayer);

        // The loop will only continue if both the barrels will have more than 0 biscuits
        while (barrelOne > 0 || barrelTwo > 0) {

            //prompt for barrel choice
            System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), "
                    +"or both (both), or skip turn (skip)? ");
            barrelChoice = in.nextLine();

            while (!barrelChoice.equals("one") && !barrelChoice.equals("two")
                    && !barrelChoice.equals("both") && !barrelChoice.equals("skip")) {
                System.out.print("Choose a barrel: barrel1 (one), barrel2 (two), "
                        + "or both (both), or skip turn (skip)? ");
                barrelChoice = in.nextLine();
            }


            boolean validMove = false;
            if (barrelChoice.equals("one")) {
                System.out.print("How many biscuits are you taking? ");

                while (!in.hasNextInt()) {
                    System.out.print("Please input an integer: ");
                    in.nextLine();
                }

                biscuits = in.nextInt();
                in.nextLine();


                if (biscuits <= barrelOne && biscuits > 0) {
                    barrelOne -= biscuits;
                    validMove = true;
                } else {
                    System.out.println("Sorry, that's not a legal number of "
                            + "biscuits for that/those barrel(s)");
                }



            } else if (barrelChoice.equals("two")) {

                System.out.print("How many biscuits are you taking? ");
                while (!in.hasNextInt()) {
                    System.out.print("Please input an integer: ");
                    in.nextLine();
                }
                biscuits = in.nextInt();
                in.nextLine();


                if (biscuits <= barrelTwo && biscuits > 0) {
                    barrelTwo -= biscuits;
                    validMove = true;
                } else {
                    System.out.println("Sorry, that's not a legal number of"
                            +" biscuits for that/those barrel(s)");
                }

            } else if (barrelChoice.equals("both")) {

                System.out.print("How many biscuits are you taking? ");
                while (!in.hasNextInt()) {
                    System.out.print("Please input an integer: ");
                    in.nextLine();
                }
                biscuits = in.nextInt();
                in.nextLine();


                if (biscuits <= barrelTwo && biscuits <= barrelOne && biscuits > 0) {
                    barrelOne -= biscuits;
                    barrelTwo -= biscuits;
                    validMove = true;
                } else {
                    System.out.println("Sorry, that's not a legal number"
                            + " of biscuits for that/those barrel(s)");
                }

            } else if (barrelChoice.equals("skip") && playerOneUsedSkip<1 && playerTwoUsedSkip<1) {
                validMove = true;
            }

            if (currentPlayer == 1 && barrelChoice.equals("skip")){
                playerOneUsedSkip++;
                validMove = true;
            }

            if (currentPlayer == 1 && barrelChoice.equals("skip") && playerOneUsedSkip>1){
                System.out.println("Sorry you've used your skip.");
                validMove = false;
            }

            if (currentPlayer == 2 && barrelChoice.equals("skip")){
                playerTwoUsedSkip++;
                validMove = true;
            }

            if (currentPlayer == 2 && barrelChoice.equals("skip") && playerTwoUsedSkip>1){
                System.out.println("Sorry you've used your skip.");
                validMove = false;
            }


            if (validMove) {
                System.out.println("Biscuits Left - Barrel 1: " + barrelOne);
                System.out.println("Biscuits Left - Barrel 2: " + barrelTwo);



                if (barrelOne <= 0 && barrelTwo <= 0) {
                    System.out.println("Winner is player " + currentPlayer);
                    break;
                }
                if (validMove) {
                    if (currentPlayer == 1) {
                        currentPlayer = 2;
                    } else {
                        currentPlayer = 1;
                    }
                    if (validMove){
                        System.out.println("Player Turn: " + currentPlayer);
                    }

                }
            }
        }
    }
}


