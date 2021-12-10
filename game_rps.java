import java.util.Scanner;
public class game_rps  {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /* 
        Realizar un programa que permita controlar el juego de piedra, papel, 
        tijera introduciendo P para piedra, L para papel y T para tijera por 
        cada jugador.El sistema debe indicar qué jugador gana la ronda o si hay 
        empate. Al finalde cada ronda preguntar si desea volver a jugar.
        */

        menu();
    }
    private static void menu() {
        var cantPlayer = 0;
        System.out.println("Enter the number of players");
        cantPlayer = sc.nextInt();
        if (cantPlayer >= 3) {
            many_players(cantPlayer);
        } 
        else if(cantPlayer == 2) {
            two_players(); 
        }else{
            System.out.println("Error: Enter two players minimum");
        }
    }
    private static void two_players() {
        char answerPlayerOne, answerPlayerTwo;
        System.out.println("Player 1");
        System.out.println("Enter P(Paper) or R(Rock) or S(Scissor) uppercase letters: ");
        answerPlayerOne = sc.next().charAt(0);
        System.out.println("Player 2");
        System.out.println("Enter P(Paper) or R(Rock) or S(Scissor) uppercase letters: ");
        answerPlayerTwo = sc.next().charAt(0);
        if (answerPlayerOne == 'P' & answerPlayerTwo == 'R') {
            System.out.println("Win Paper - Player 1");
            repeat_game();
        }
        else if(answerPlayerOne == 'R' & answerPlayerTwo == 'P'){
            System.out.println("Win Paper - Player 2");
            repeat_game();
        }
        else if(answerPlayerOne == 'R' & answerPlayerTwo == 'S'){
            System.out.println("Win Rock - Player 1");
            repeat_game();
        }
        else if(answerPlayerOne == 'S' & answerPlayerTwo == 'R'){
            System.out.println("Win Rock - Player 2");
            repeat_game();
        }
        else if(answerPlayerOne == 'S' & answerPlayerTwo == 'P'){
            System.out.println("Win Scissor - Player 1");
            repeat_game();
        }
        else if(answerPlayerOne == 'P' & answerPlayerTwo == 'S'){
            System.out.println("Win Scissor - Player 2");
            repeat_game();
        }else{
            System.out.println("Error: Enter P(Paper) or R(Rock) or S(Scissor) uppercase letters ");
            two_players();
        }
    }
    public static void many_players(int cantPlayer) {
        char answer;
        int countPaper = 0;
        int countRock = 0;
        int countScissor = 0;
        int countDisPlayer = 0;

        char[] players = new char[cantPlayer];
        for (int i = 0; i < cantPlayer; i++) {
            var position = i+1;
            System.out.println("Player - " + position);
            System.out.println("Enter P(Paper) or R(Rock) or S(Scissor) uppercase letters: ");
            answer = sc.next().charAt(0);
            if (answer != 'P' & answer != 'R' & answer != 'S'){
                System.out.println("Disqualified player!");
                players[i] = 'D';
                continue;
            }
            players[i] = answer;
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i] == 'P') {
                countPaper++;
            } 
            else if (players[i] == 'R') {
                countRock++;   
            }
            else if (players[i] == 'S'){
                countScissor++;
            }else{
                countDisPlayer++;
            }
        }
        // Algorithm to identify the winner 
        if (countPaper != 0 & countRock != 0 & countScissor != 0) {
            System.out.println("Sancocho! (Repeat game)");
            many_players(cantPlayer);
        } 
        else if (countPaper == 0 & countRock == 0 & countScissor == 0) {
            System.out.println("All players have been disqualified!");
        }
        else if (countPaper == countRock & countScissor == 0){
            System.out.println("Tie! (Repeat game)");
            many_players(cantPlayer);
        }
        else if (countPaper == countScissor & countRock == 0){
            System.out.println("Tie! (Repeat game)");
            many_players(cantPlayer);
        }
        else if (countRock == countScissor & countPaper == 0){
            System.out.println("Tie! (Repeat game)");
            many_players(cantPlayer);
        }
        else if (countPaper > countRock & countPaper > countScissor){
            System.out.println("Win paper!");
            System.out.println("Players who won: ");
            for (int i = 0; i < players.length; i++) {
                if (players[i] ==  'P') {
                    System.out.println("Player " + (i+1));
                }
            }
            System.out.println("Disqualified players: " + countDisPlayer);
            repeat_game();
            
        }
        else if (countRock > countPaper & countRock > countScissor){
            System.out.println("Win Rock!");
            System.out.println("Players who won: ");
            for (int i = 0; i < players.length; i++) {
                if (players[i] ==  'R') {
                    System.out.println("Player " + (i+1));
                }
            }
            System.out.println("Disqualified players: " + countDisPlayer);
            repeat_game();
        }
        else if (countScissor > countPaper & countScissor > countRock){
            System.out.println("Win Scissor!");
            System.out.println("Players who won: ");
            for (int i = 0; i < players.length; i++) {
                if (players[i] ==  'S') {
                    System.out.println("Player " + (i+1));
                }
            }
            System.out.println("Disqualified players: " + countDisPlayer);
            repeat_game();
        }
    }
    private static void repeat_game() {
        System.out.println("Do you want to repeat the game? (Y/N) :");
        var answerRepeat = sc.next().charAt(0);
        if (answerRepeat == 'Y') {
            menu();
        }
        
    }
}
