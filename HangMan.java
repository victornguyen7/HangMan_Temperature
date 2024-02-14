package HangMan_Temperature;


import java.util.Scanner;

public class HangMan {
	
	private char[] setUp;
	private String secretWord;
	
	public HangMan(String sw) {
		secretWord = sw;
		setUp = new char[secretWord.length()];
		secretWord = secretWord.toLowerCase();
	}
	
	public String getSecretWord() {
		return secretWord;
	}//get the secret word
	
	public void setSecretWord(String newSecretWord) {
		secretWord = newSecretWord;
	}//set the secret word
	
	public boolean space() {
		for ( int i = 0; i < secretWord.length(); i++) {
			if(secretWord.charAt(i) == ' ') {
				return false;
			}
		}
		return true;
		
	}//check if the word has space or not
	
	public int spaceCount() {
		int space = 0;
		if(!space()) {
			for(int i = 0; i < secretWord.length(); i++) {
				if (secretWord.charAt(i) == ' ') {
					space++;
				}
			}
		}
		return space;
	}//count the number of space in the secret word
	
	public void setUp() {
		for(int i = 0; i < secretWord.length(); i++) {
			setUp[i] = '_';
		}
	}//set up the word
	
	public void setUpWithSpace() {
		if(!space()) {
			for(int i = 0; i < secretWord.length(); i++) {
				if(secretWord.charAt(i) != ' ') {
					setUp[i] = '_';
					}	
				else if (secretWord.charAt(i) == ' ') {
					setUp[i] = ' ';
				}
			}
		}
	}//set up the word that has spaces
	
	public void check() {
		int wrong = 6;
		
		while(wrong > 0) {
			System.out.println("The word is: " + String.valueOf(setUp));
			System.out.println("Enter your guess: ");
			Scanner input = new Scanner(System.in);
			char guess = input.next().charAt(0);
			
			boolean check = false;
			
			if(secretWord.indexOf(guess) >= 0) {
				System.out.println("Correct");
			}
			else {
				System.out.println("Incorrect");
			}
			
			for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    setUp[i] = guess;
                    check = true;
                }
            }
			
			if(!check) {
				wrong--;
			}
			
			System.out.println(wrong + " guesses left.");
			
			if(String.valueOf(setUp).equals(secretWord)) {
				System.out.println("You win.");
				break;
			}
		}
        if (wrong == 0) {
            System.out.println("Game over. You lose.");
        }
	}//check if the input letter is in the secret word or not
	
	public void startGame() {
		System.out.println("Welcome to the hangman game.");
		System.out.println("You have to guess this secret word.");
		System.out.println("This secret word has totally " + (secretWord.length() - spaceCount()) + " letters.");
		if(space()) {
			setUp();
		}
		else {
			setUpWithSpace();
		}
		check();
		System.out.println("The word is: " + secretWord);
	}//print out the game
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HangMan game = new HangMan("Victor Hien");
		
		game.startGame();
	}
}