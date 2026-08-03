import java.util.Arrays;
import java.util.Scanner; 

public class AirplaneAirbus {
	
	public static String InputInt(Scanner input) {
		System.out.println("veillez mettre un identifiant");
		while(!input.hasNextInt()) input.next();
		return input.next();
	}
	
	public static String InputPhase(Scanner input) {
		String typeproduct ="";
		while(!Arrays.asList("etude de faisabilite","conception","definition",
				"construction","en service","cloture").contains(typeproduct)) {
			typeproduct =input.next().toLowerCase();
		}
		return typeproduct;
	}
	
	public static String InputProgramm(Scanner input) {
		String programm = "";
		while(!programm.matches("[A-Z][0-9]+[A-Z]?")) {
			programm = input.next();
		}
		return programm;
	}
	public static List<String[4]> AirplaneCreate(Scanner input){
		List<String[4]> airplane = new ArrayList<>;
		while(!input.next().equalsIgnoreCase("oui")) {
			
			airplane.add(new String(InputInt(input),InputProgramm(input),InputPhase(input),input.next()));
			
		}
		return  airplane;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

	}

}
