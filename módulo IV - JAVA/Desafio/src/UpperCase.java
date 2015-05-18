import java.util.ArrayList;
import java.util.Scanner;



	public class UpperCase {
		public static void main(String args[]) {

			UpperCase u = new UpperCase();

			u.contaMaiusculas();

		}

		public ArrayList contaMaiusculas() {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Give a string: ");
			String input = keyboard.nextLine();

			ArrayList guardaindices = new ArrayList();
			int tamanhoDaString = input.length();
			int count = 0;

			for (int i = 0; i < tamanhoDaString; i++) {
				if (Character.isUpperCase(input.charAt(i))) {
					guardaindices.add(i);
				}
			}

			System.out.println("Índice das letras maiusculas: " + guardaindices);
			return guardaindices;
		}

	}
	
	