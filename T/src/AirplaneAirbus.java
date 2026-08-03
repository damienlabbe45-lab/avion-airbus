import java.util.ArrayList;
import java.util.Scanner; 
import java.util.List;
import java.util.Arrays;

public class AirplaneAirbus {
	
	public static String InputInt(Scanner input) {
		System.out.println("veillez mettre un identifiant");
		while(!input.hasNextInt()) input.next();
		return input.next();
	}
	
	public static String InputPhase(Scanner input) {
		String typeproduct ="";
		System.out.println("Veillez mettre la phase");
		while(!Arrays.asList("etude de faisabilite","conception","definition",
				"construction","en service","cloture").contains(typeproduct)) {
			typeproduct =input.next().toLowerCase();
		}
		return typeproduct;
	}
	
	public static String InputProgramm(Scanner input) {
		String programm = "";
		System.out.println("Veillez mettre le proggramme");
		while(!programm.matches("[A-Z][0-9]+[A-Z]?")) {
			programm = input.next();
		}
		return programm;
	}
	public static String InputType(Scanner input) {
		System.out.println("veillez mettre le type");
		return input.next();
	}
	
	public static List<String[]> AirplaneCreate(Scanner input){
		List<String[]> airplane = new ArrayList<>();
		System.out.println("Voulez vous créé un avion?");
		while(input.next().equalsIgnoreCase("oui")) {
			airplane.add( new String[] {InputInt(input),InputProgramm(input),InputPhase(input),InputType(input)});
			System.out.println("voulez vous oui ou non créé un nouveau avion");
		}
		return  airplane;
	}
	
	public static void print(List<String[]> airplanes) {
		System.out.println(airplanes.toString());
	}
	public static void main(String[] args) {
		if( args.length > 0) throw new IllegalArgumentException(" pas d'arguments");
		Scanner input = new Scanner(System.in);
		List<String[]> airplanes = AirplaneCreate(input);
		print(airplanes);
		
		input.close();
	}

}
