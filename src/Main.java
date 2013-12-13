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
			// Calc and show Huffman Tree
			FileParser fp = new FileParser(path);
			HuffmanCalc hc = new HuffmanCalc(fp.getAscii());
			HuffmanTree ht = hc.calcTree();
			System.out.println(ht);

			// Write file
			BitSet ascii[] = new BitSet[128];
			CharCoding.getBinaryCharCode(ht, 0, new BitSet(), ascii);
			FileWriter.writeFile(path, ascii);
			FileTreeWriter.writeTree(ht, path + ".tree");
		}
	}
}
