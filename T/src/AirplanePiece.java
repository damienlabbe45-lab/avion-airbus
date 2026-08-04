import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AirplanePiece {
	
	public static void printpiece(List<String[]> pieces) {
		System.out.println("[nom,Catégorie,prix]");
		System.out.println(Arrays.deepToString(pieces.toArray()));
	}
	
	public static String InputDouble(Scanner input) {
		System.out.println("veillez mettre un prix");
		while(!input.hasNextDouble()) input.next();
		return input.next();
	}
	
	public static void main(String[] args) {
		if( args.length > 0) throw new IllegalArgumentException(" pas d'arguments");
	}

}
