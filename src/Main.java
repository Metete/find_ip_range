
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String ipCidr = "172.10.85.60/22";
		String ipCidr = "192.168.60.55/20";
		System.out.println(convertToBinary(ipCidr));
	}
	
	private static String convertToBinary(String ipCidr) {
		String afterSlash = ipCidr.split("/")[1];
		int numberOfTurnedOnBits = Integer.parseInt(afterSlash);
		
		StringBuilder binaryConvertedOctetsBuilder = new StringBuilder(); 
		
		for(int i = 1; i <= 32; i++) {

			if(i <= numberOfTurnedOnBits){
				binaryConvertedOctetsBuilder.append("1");
				if(i==8 || i==16 || i==24) {
					binaryConvertedOctetsBuilder.append(".");
				}
			}
			else {
				binaryConvertedOctetsBuilder.append("0");
				if(i==8 || i==16 || i==24) {
					binaryConvertedOctetsBuilder.append(".");
				}
			}
		}
		String binaryConvertedOctets = binaryConvertedOctetsBuilder.toString();
		return binaryConvertedOctets;
	}
	
	/**
	 * private static String createSubnetMask(String binaryConvertedOctets) {
	 
	    StringBuilder octetBuilder = new StringBuilder(binaryConvertedOctets);
	    
		for (int i = 1; i <= binaryConvertedOctets.length(); i++){
      

		    if(i == 8) {
		    	octetBuilder
		    	octetBuilder.delete(0, 10);
		    	
		    }
		}
		return binaryConvertedOctets;
	}
	
	private static int sumEachOctet()
	 */
}
