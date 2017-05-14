import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

	static public void lotto() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Wprowadz 6 losowych liczb z zakresu:");
		Integer[] tab = new Integer[6];
		Integer temp = 0;
		for (int i = 0; i < 6; i++) {
			if (scan.hasNextInt()) {
				temp = scan.nextInt();

				if ((temp < 1) || (temp > 49) ) {
					System.out.println("Wprowadziles liczbe poza zakresem <1-48> kończę działanie programu.");
					return;
				}else if ((Arrays.asList(tab).contains(temp)))
				{
					System.out.println("Wprowadziłes dwukrotnie tą samą liczbę. Konńcze działanie programu.");
				}
				
				else {
					tab[i] = temp;
				}
			} else {
				System.out.println("Wprowadzono zle dane.");
				return;
			}

		}
		Arrays.sort(tab);
		System.out.println("Twoje liczby:");
		System.out.println(Arrays.toString(tab));

		Integer[] arr = new Integer[49];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		Collections.shuffle(Arrays.asList(arr));

		ArrayList<Integer> lottoResults = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			lottoResults.add(arr[i]);
		}
		Collections.sort(lottoResults);
		System.out.println("Wyniki lotto:");
		System.out.println(lottoResults.toString());

		ArrayList<Integer> luckyNumber = new ArrayList<>();

		int iterator = 0;
		for (int i = 0; i < 6; i++) {
			if (lottoResults.contains(tab[i])) {
				luckyNumber.add(tab[i]);
				iterator++;
			}
		}

		if (iterator >= 3) {
			System.out.println("trafiles " + iterator + " liczb ");
			System.out.println("Twoje szczesliwe liczby to: " + luckyNumber.toString());
		}

	}

	public static void main(String[] args) {

		lotto();

	}

}
