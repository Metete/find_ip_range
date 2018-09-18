import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		String ipCidr = "5.7.3.0/24";

		String[] split = ipCidr.split("/");
		// Split after slash and before slash
		int afterSlash = Integer.parseInt(split[1]);
		int remainingNumOfClientBits = 32 - afterSlash;
		String beforeSlash = split[0];

		// Split the string before slash according to "." and append each splited number
		// to the arraylist as a seperate element.
		String[] bytesSplitedArr = beforeSlash.split("\\.");

		// Convert the input Ip address to binary and concatenate each converted binary
		// conversion.
		String concatenatedBinary = "";
		for (int i = 0; i < 4; i++) {
			int splitedInt = Integer.parseInt((String) bytesSplitedArr[i]);
			String myString = String.format("%8s", Integer.toBinaryString(splitedInt)).replace(' ', '0');
			concatenatedBinary = concatenatedBinary.concat(myString);
		}

		// Get the first k bits which is specified by afterSlash var.
		String networkBits = concatenatedBinary.substring(0, afterSlash);

		// Concatenate network bits and first client bits( k number 0s)
		String concatenatedFirstBits = networkBits;
		for (int i = 0; i < remainingNumOfClientBits; i++) {
			concatenatedFirstBits = concatenatedFirstBits.concat("0");
		}

		// Concatenate network bits and last client bits( k number 1s)
		String concatenatedLastBits = networkBits;
		for (int i = 0; i < remainingNumOfClientBits; i++) {
			concatenatedLastBits = concatenatedLastBits.concat("1");
		}

		// Convert first and last binaries to decimal
		int firstDecimal = Integer.parseInt(concatenatedFirstBits, 2);
		int lastDecimal = Integer.parseInt(concatenatedLastBits, 2);
		System.out.println(firstDecimal);
		System.out.println(lastDecimal);
		System.out.println(lastDecimal - firstDecimal);
	}

	/**
	 * Old version of converting Cidr version to binary.
	 * 
	 * @param ipCidr
	 * @return
	 */
	private static String convertToBinaryUsingTurnedOnBits(String ipCidr) {
		String afterSlash = ipCidr.split("/")[1];
		int numberOfTurnedOnBits = Integer.parseInt(afterSlash);

		StringBuilder binaryConvertedOctetsBuilder = new StringBuilder();

		for (int i = 1; i <= 32; i++) {

			if (i <= numberOfTurnedOnBits) {
				binaryConvertedOctetsBuilder.append("1");
				if (i == 8 || i == 16 || i == 24) {
					binaryConvertedOctetsBuilder.append(".");
				}
			} else {
				binaryConvertedOctetsBuilder.append("0");
				if (i == 8 || i == 16 || i == 24) {
					binaryConvertedOctetsBuilder.append(".");
				}
			}
		}
		String binaryConvertedOctets = binaryConvertedOctetsBuilder.toString();
		return binaryConvertedOctets;
	}

	/**
	 * private static String createSubnetMask(String binaryConvertedOctets) {
	 * 
	 * StringBuilder octetBuilder = new StringBuilder(binaryConvertedOctets);
	 * 
	 * for (int i = 1; i <= binaryConvertedOctets.length(); i++){
	 * 
	 * 
	 * if(i == 8) { octetBuilder octetBuilder.delete(0, 10);
	 * 
	 * } } return binaryConvertedOctets; }
	 * 
	 * private static int sumEachOctet()
	 */
}
