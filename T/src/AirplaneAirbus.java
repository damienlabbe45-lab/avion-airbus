import java.util.Scanner; 
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;

public class AirplaneAirbus {
	
	public static String InputInt(Scanner input) {
		System.out.println("veillez mettre un identifiant:");
		while(!input.hasNextInt()) input.nextLine();
		return input.nextLine();
	}
	
	public static String InputPhase(Scanner input) {
		String typeproduct ="";
		System.out.println("Veillez mettre la phase:");
		while(!Arrays.asList("etude de faisabilite","conception","definition",
				"construction","en service","cloture").contains(typeproduct)) {
			typeproduct =input.nextLine().toLowerCase();
		}
		return typeproduct;
	}
	
	public static String InputProgramm(Scanner input) {
		String programm = "";
		System.out.println("Veillez mettre le proggramme:");
		while(!programm.matches("[A-Z]\\d+[A-Z]?")) {
			programm = input.nextLine();
		}
		return programm;
	}
	
	public static String InputType(Scanner input) {
		System.out.println("veillez mettre le type:");
		return input.nextLine();
	}
	
	public static List<String> Airplane(Scanner input) {
		String[] airplane= {InputInt(input),InputProgramm(input),InputPhase(input),InputType(input)};
		return Arrays.asList(airplane);
	}
	
	public static HashMap<List<String>,List<String[]>> AirplaneCreate(Scanner input){
		HashMap<List<String>,List<String[]>> airplane = new HashMap<>();
		System.out.println("Voulez vous créé un avion?");
		while(input.nextLine().equalsIgnoreCase("oui")) {
			List<String> airplanes = Airplane(input);
			List<String[]> pieces = AirplanePiece.piecesCreate(input);
			airplane.put(airplanes, pieces);
			airplane.replace(airplanes, AirplanePiece.piecesRemove(input,pieces));
			System.out.println("voulez vous oui ou non créé un nouveau avion?");
		}
		return  airplane;
	}
	
	public static void printairplane(List<String> airplanes) {
		System.out.println("[Identifiant,Programme,Phase, Type]");
		System.out.println(Arrays.deepToString(airplanes.toArray()));
	}
	
	//public static void print2(List<String> airplanes) {
	//	System.out.println(Arrays.deepToString(airplanes.toArray()));
	//}
	
	public static void print(HashMap<List<String>,List<String[]>> airplanes, Scanner input) {
		System.out.println("voulez-vous voir toutes les infos des pièces d'avion oui ou  non?");
		boolean isAll = input.nextLine().equalsIgnoreCase("oui");
		airplanes.forEach(( airplane, pieces) -> {
			printairplane(airplane);
			if(isAll)AirplanePiece.printpiece(pieces);
			else AirplanePiece.printname(pieces);
		});
	}
	
	public static void findAirplane(Scanner input,HashMap<List<String>,List<String[]>> airplanes) {
		System.out.println("veillez mettre un mot!");
		String word  = input.nextLine().toLowerCase();
		HashMap<List<String>,List<String[]>> results = new HashMap<>();
		for(List<String> airplane:airplanes.keySet()) {
			if(airplane.get(0).contains(word) || airplane.get(1).contains(word.toUpperCase()) || 
					airplane.get(2).contains(word) || airplane.get(3).contains(word)) {
				results.put(airplane,airplanes.get(airplane));
			}
		}
		if (!results.isEmpty())print(results, input);
		else System.out.println("aucun résultat");
	}
	
	public static void main(String[] args) {
		if( args.length > 0) throw new IllegalArgumentException(" pas d'arguments");
		Scanner input = new Scanner(System.in);
		HashMap<List<String>,List<String[]>> airplanes = AirplaneCreate(input);
		print(airplanes, input);
		findAirplane(input,airplanes);
		input.close();
	}

}
