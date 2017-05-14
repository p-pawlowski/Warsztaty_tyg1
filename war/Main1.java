import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main1 {

	static void guessNumber() {
		Random rand = new Random();
		int randNumber = rand.nextInt(100) + 1;
		int userNumber = -1;

		System.out.println("Wylosowałem liczbe w przedziale 1-100. Zgadnij ja: ");
		Scanner sc = new Scanner(System.in);

		while (userNumber != randNumber) {
			while (!sc.hasNextLine()) {
				System.out.println("Wprowadz poprawna liczbe");
				sc.nextLine();
			}try {
				userNumber = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Wprowadz poprawna liczbe");
				sc.nextLine();
				continue;
			}
			if (userNumber < randNumber) {
				System.out.println("Twoja liczba jest za mała. Sprobuj jeszcze raz");
			} else if (userNumber > randNumber) {
				System.out.println("Twoja liczba jest za duza. Sprobuj jeszcze raz");
			}

		}
		System.out.println("Brawo. Wylosowałem liczbe:" + randNumber);
		sc.close();
	}

	public static void main(String[] args) {

		guessNumber();

	}
}
