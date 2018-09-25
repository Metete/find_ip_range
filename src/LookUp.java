
public class LookUp {

	public static void main(String[] args) {

		String lookUpIP = "1.0.0.1";

		// Split the string before slash according to "." and append each splited number
		// to the arraylist as a seperate element.
		String[] bytesSplitedArr = lookUpIP.split("\\.");

		// Convert the input Ip address to binary and concatenate each converted binary
		// conversion.
		String concatenatedBinary = "";
		for (int i = 0; i < 4; i++) {
			int splitedInt = Integer.parseInt((String) bytesSplitedArr[i]);
			String myString = String.format("%8s", Integer.toBinaryString(splitedInt)).replace(' ', '0');
			concatenatedBinary = concatenatedBinary.concat(myString);
		}
		// Convert first and last binaries to decimal
		long lookUpDecimal = Long.parseLong(concatenatedBinary, 2);
		System.out.println(lookUpDecimal);
	}
}
