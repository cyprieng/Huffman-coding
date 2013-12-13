import java.util.BitSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.utt.huffman.HuffmanCalc;
import fr.utt.huffman.HuffmanTree;
import fr.utt.huffman.coding.CharCoding;
import fr.utt.huffman.file.FileParser;
import fr.utt.huffman.file.FileTreeWriter;
import fr.utt.huffman.file.FileWriter;

public class Main {
	public static void main(String[] args) {
		// Init var
		Scanner sc = new Scanner(System.in);
		int action = -1;

		// Ask for the action
		do {
			System.out.println("What do you want to do: ");
			System.out.println("1) Encrypt");
			System.out.println("2) Decrypt");

			// Check type
			try {
				action = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
			}
		} while (action != 1 && action != 2);

		sc.nextLine(); // Clear scanner buffer

		// Ask for file path
		System.out.print("Path to the file: ");
		String path = sc.nextLine();
		sc.close();

		// Encrypt
		if (action == 1) {
			long start = System.nanoTime();
			
			// Parse file
			FileParser fp = new FileParser(path);
			long parse = System.nanoTime() - start;
			
			//Init HuffmanCalc
			HuffmanCalc hc = new HuffmanCalc(fp.getAscii());
			long sort = System.nanoTime() - start - parse;
			
			//Calc huffman tree
			HuffmanTree ht = hc.calcTree();
			long calc = System.nanoTime() - start - parse - sort;
			
			long total = System.nanoTime() - start;
			
			//Print
			System.out.println("\nTree:");
			System.out.println(ht);
			System.out.println("\nTime to parse: "+ ((double)(parse/100000)) + "ms");
			System.out.println("Time to sort: "+ ((double)(sort/100000)) + "ms");
			System.out.println("Time to calc tree: "+ ((double)(calc/100000)) + "ms");
			System.out.println("---------------------------------------------------");
			System.out.println("Total time: "+ ((double)(total/100000)) + "ms");

			// Write file
			BitSet ascii[] = new BitSet[128];
			CharCoding.getBinaryCharCode(ht, 0, new BitSet(), ascii);
			FileWriter.writeFile(path, ascii);
			FileTreeWriter.writeTree(ht, path + ".tree");
		}
	}
}
