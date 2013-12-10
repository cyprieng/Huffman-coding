import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

import fr.utt.huffman.HuffmanCalc;
import fr.utt.huffman.HuffmanTree;
import fr.utt.huffman.coding.CharCoding;
import fr.utt.huffman.file.FileParser;
import fr.utt.huffman.file.FileWriter;

public class Main {
	public static void main(String[] args) {
		// Ask for file path
		Scanner sc = new Scanner(System.in);
		System.out.print("Path to the file: ");
		String path = sc.nextLine();
		sc.close();

		// Calc and show Huffman Tree
		FileParser fp = new FileParser(path);
		HuffmanCalc hc = new HuffmanCalc(fp.getAscii());
		HuffmanTree ht = hc.calcTree();
		System.out.println(ht);

		// Write file
		BitSet ascii[] = new BitSet[128];
		CharCoding.getBinaryCharCode(ht, 0, new BitSet(), ascii);
		FileWriter.writeFile("test.txt", ascii);
	}
}
