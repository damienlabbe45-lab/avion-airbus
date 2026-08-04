import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AirplanePiece {
	
	public static void printpiece(List<String[]> pieces) {
		System.out.println("[nom,prix en euros,catégorie]");
		System.out.println(Arrays.deepToString(pieces.toArray()));
	}
	
	public static String InputDouble(Scanner input) {
		System.out.println("veillez mettre un prix");
		while(!input.hasNextDouble()) input.nextLine();
		return input.nextLine();
	}
	
	public static String InputName(Scanner input) {
		System.out.println("veillez mettre le nom de la piece");
		return input.nextLine();
	}
	
	public static String InputCat(Scanner input) {
		System.out.println("veillez mettre la categorie");
		return input.nextLine();
	}
	
	public static List<String[]> piecesCreate(Scanner input){
		List<String[]> pieces = new ArrayList<>();
		System.out.println("Voulez vous créé une pièce d'avion?");
		while(input.nextLine().equalsIgnoreCase("oui")) {
			pieces.add( new String[] {InputName(input),InputDouble(input),InputCat(input)});
			System.out.println("voulez vous oui ou non créé une nouvelle pièce d'avion");
		}
		return  pieces;
	}
	
	public static void main(String[] args) {
		if( args.length > 0) throw new IllegalArgumentException(" pas d'arguments");
	}

}
