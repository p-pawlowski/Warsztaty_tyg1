
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class Main4 {

	static public boolean rpgDices() {

		// Pobieranie danych od uzytkownika
		String str = inputData();

		// sprawdzenie czy uzytkownik chce zakonczyc zabawe.
		if (str.equals("quit")) {
			System.out.println("Koniec zabawy!");
			return false;
		}

		// sprawdzam czy na poczatku wyrazenia znajduje sie liczba
		// jesli nie dopisuje jedynke z przodu
		// Lapanie wyjatku jesli uzytkownik nic nie wpisal
		try {
			if (!Character.isDigit(str.charAt(0))) {
				str = "1" + str;
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("A może bys tak coś wpisał?\n");
			return true;
		}

		// Ustalenie czy w wyrazeniu znajduje sie + lub -
		int sign = 1;
		if (str.contains("+")) {
			sign = 1;
		} else if (str.contains("-")) {
			sign = -1;
		} else {
			str += "+0"; // dopisuje "+0", zeby byl spelniony wzorzec.
		}

		// Ustalenie czy na poczatku wyrazenia znajduje sie cyfra.
		// Jesli nie dopisuje str "1" z przodu zeby wzorzec byl spelniony

		calculateResult(str, sign);

		return true;

	}

	// Metoda pobierania danych od uzytkownika
	static public String inputData() {
		System.out.println("Wprowadz w formatcie (xDy+z):");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		return str;

	}

	//
	static public void calculateResult(String str, int sign) {

		String regex = "([0-9]+)(D|d)([0-9]+)(\\+|\\-)([0-9]+)";
		Pattern pattern = Pattern.compile(regex);

		// Matcher. Sprawdzenie czy text pasuje do wzorca.

		Matcher matcher = pattern.matcher(str);
		boolean isMatching = matcher.matches();
		if (!isMatching) {
			System.out.println("Tekst nie pasuje do wzorca");
			return;
		}

		//
		Random rand = new Random();
		int result = 0;
		int numberOfRolls = Integer.parseInt(matcher.group(1));
		int numberOfWalls = Integer.parseInt(matcher.group(3));
		int numberToAdd = Integer.parseInt(matcher.group(5));

		// Sprawdzenie czy uzywamy kosci ktora istnieje.
		if (!(numberOfWalls == 4 || numberOfWalls == 6 || numberOfWalls == 8 || numberOfWalls == 10
				|| numberOfWalls == 12 || numberOfWalls == 20 || numberOfWalls == 100)) {
			System.out.println("Wybrana przez ciebie kosc nie jest uzywana w grach RPG");
			return;
		}

		// sumulacje rzutow koscmi
		ArrayList<Integer> singleDiceResults = new ArrayList<>();
		for (int i = 0; i < numberOfRolls; i++) {
			int temp = rand.nextInt(numberOfWalls) + 1;
			result += temp;
			singleDiceResults.add(temp);
		}
		System.out.print("Twoje rzuty koścmi to:  ");
		System.out.println(singleDiceResults.toString());

		// modyfikacja wyniku o dodana/odjeta liczbe
		result += sign * numberToAdd;

		// Wsywietlenie informacji o uzyskanym wyniku:
		String word = " po dodaniu ";
		if (sign < 0) {
			word = " po odjeciu ";
		}
		System.out.print("Uzyskany przez ciebie wynik w " + numberOfRolls + " rzutach " + "koscia D" + numberOfWalls
				+ word + numberToAdd + " to:  --- ");
		System.out.print(result + " ---\n\n");

	}

	public static void main(String[] args) {
		System.out.println("Rozpoczynamy zabawę. Wprowadz \"quit\" jeśli chcesz zakończyć");

		while (rpgDices()) {
		}

	}
}
