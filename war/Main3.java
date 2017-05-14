import java.util.Random;
import java.util.Scanner;

public class Main3 {

	public enum userIN {
		wieksza, mniejsza, trafiles
	};

	static void guessNumber() {
		int min = 1;
		int max = 1001;
		int guess;
		int iterator = 0;
		userIN op;
		System.out.println("Pomysl liczbe w zakresie 1-1000, a ja ją zgadne w max 10 probach: ");
		Scanner sc = new Scanner(System.in);

		for (;;) {
			
			//Warunek oszustwa w gdzie. Ilosc prob wieksza niz 10.
			if (iterator >= 10){
				System.out.println("OSZUKUJESZ!! POBITE GARY!!");
				return;
			}
			try {
				guess = ((max - min) / 2) + min;
				System.out.println("Czy ta liczba to: " + guess + " ? ");
				op = userIN.valueOf(sc.next());
				switch (op) {
				case wieksza:
					min = guess;
					iterator++;
					break;
				case mniejsza:
					max = guess;
					iterator++;
					break;
				case trafiles:
					System.out.println("Super. Zgadłem w " + iterator + " probach");
					return;
				default:
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Nie wprowadziles poprawnego napisu");
			}

		}

	}

	public static void main(String[] args) {

		guessNumber();

	}
}