package permutaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Scanner;
/**
 *
 * @author jvillalba
 */
public class Permutaciones {
    
    private List<String> combinaciones = new ArrayList<>();
    private String[] words;

    public Permutaciones() {
    }

    public Permutaciones(String[] words) {
        this.words = words;
    }
    
    public void GenerarPermutaciones(){
        for(int i = 0; i < words.length; i++){
            Getdata(words[i]);
        }
    }
            
    public void EjecutarEjemplo(){
        String ejemplo_01 = "hat";
        Getdata(ejemplo_01);
        String ejemplo_02 = "abc";
        Getdata(ejemplo_02);
        String ejemplo_03 = "Zu6";
        Getdata(ejemplo_03);
    }
    
    public void Getdata(String word){
        System.out.println("Permutaciones para la palabra: " + word);
        String[] elementos = word.split(""); 
        int r = elementos.length; // tamaño de la palabra  
        Perm2(elementos, "", r, r); // Es importante enviar r dos veces por la recursividad n disminuye.
        Collections.sort(combinaciones); // Ordena alfabeticamente la lista de palabras permutadas
        for (String perm : combinaciones) {
            System.out.println(perm);// Imprimimos las permutaciones
        }
    }    
    private void Perm2(String[] elem, String act, int n, int r) {
        if (n == 0) {
            combinaciones.add(act); // Guarda las permutaciones
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i], n - 1, r);
                }
            }
        }
    }        
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            
	    System.out.println("1. Nuevo Arreglo de Palabras");
	    System.out.println("2. Ejemplo Test");

	    int val = sc.nextInt();

	    switch (val) {
		case 1:
                    int n;
                    String[] words; 
                    sc.nextLine(); 
                    System.out.println ("Introduzca la cantidad de palabra ha ingresar: ");
                    n = Integer.parseInt( sc.nextLine());
                    words = new String[n];
                    for(int i = 0; i < n; i++){                 
                        System.out.println("Introduzca una palabra: ");
                        words[i] = sc.nextLine();
                    }
                    Permutaciones ob = new Permutaciones(words);
                    ob.GenerarPermutaciones();
		    break;
		case 2:
                    Permutaciones ob_ = new Permutaciones();
                    ob_.EjecutarEjemplo();
		    break;
		default:
		    //sale
		    return;
	    }
	}
        
        
        
        

    }
       
}
