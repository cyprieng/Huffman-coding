package test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.utt.huffman.file.FileParser;

public class TestFileParser {

	@Test
	public void testFileParser() {
		{// Test an example file
			int expected[] = new int[128];
			expected[97] = 1;
			expected[98] = 1;
			expected[100] = 7;
			expected[108] = 1;
			expected[102] = 9;
			expected[106] = 1;
			expected[34] = 1;
			expected[39] = 1;
			expected[33] = 1;
			expected[109] = 1;
			expected[110] = 1;
			expected[111] = 1;
			expected[112] = 1;
			expected[55] = 1;
			expected[56] = 1;
			expected[53] = 1;
			expected[50] = 1;
			expected[51] = 1;
			expected[10] = 2;
			expected[32] = 5;

			FileParser fp = new FileParser("src/test/test.txt");
			int practical[] = fp.getAscii();

			for (int i = 0; i < practical.length; i++) {
				assertTrue("Error with " + i + " char",
						practical[i] == expected[i]);
			}
		}

		{// Test null file
			FileParser fp = new FileParser(null);
			int practical[] = fp.getAscii();
			for (int i = 0; i < practical.length; i++) {
				assertTrue("Error with null file", practical[i] == 0);
			}
		}

		{// Test non existing file
			FileParser fp = new FileParser("unknow file");
			int practical[] = fp.getAscii();
			for (int i = 0; i < practical.length; i++) {
				assertTrue("Error with non existing file", practical[i] == 0);
			}
		}
	}

}
