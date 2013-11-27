import fr.utt.huffman.HuffmanCalc;
import fr.utt.huffman.file.FileParser;

public class Main {
	public static void main(String[] args) {
		FileParser fp = new FileParser("test.txt");
		HuffmanCalc hc = new HuffmanCalc(fp.getAscii());
	}
}
