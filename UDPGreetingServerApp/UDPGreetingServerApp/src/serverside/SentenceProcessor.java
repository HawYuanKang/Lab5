package serverside;

public class SentenceProcessor {
	
	private int size = 65535;
	
	private String sentence;
	
	
	public SentenceProcessor(byte[] byteData) {
		
		this.sentence = new String(byteData);
	}
	
	public String getSentence() {
		
		return sentence;
	}
	
	/**
	 * This method convert value into an array of byte
	 * @param length
	 * @return
	 */
	public byte[] convertToByteArray(int value) {
		
		byte[] outData = new byte[size];
		
		String stringValue = Integer.valueOf(value).toString();
		
        outData = stringValue.getBytes();
        
        return outData;
	}
	
	public int CountVowel() {
		
		//default vowel count value
		int vCount=0;
		
		//change all character to lower case
		sentence=sentence.toLowerCase();
		
		for(int i = 0; i < sentence.length(); i++) {    
            //Checks whether a character is a vowel    
            if(sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e' || sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u') {    
                //Increments the vowel counter    
                vCount++;    
            }    
		}
        
        return vCount;
	}
	
	public int CountConsonent() {
		
		//default vowel count value
		int cCount=0;
		
		//change all character to lower case
		sentence=sentence.toLowerCase();
		
		for(int i = 0; i < sentence.length(); i++) {    
              
            if(sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e' || sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u') {    
                  
            } 
            else if(sentence.charAt(i) >= 'a' && sentence.charAt(i)<='z') {      
                //Increments the consonant counter    
                cCount++;    
            } 
		}
        
        return cCount;
	}
	
	public int CountPunctuation() {
		
		//default vowel count value
		int pCount=0;
		
		//change all character to lower case
		sentence=sentence.toLowerCase();
		
		for(int i = 0; i < sentence.length(); i++) {    
            
            if(sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e' || sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u') {    
                  
            } 
            else if(sentence.charAt(i) >= 'a' && sentence.charAt(i)<='z') {      
    
            } 
            else if(sentence.charAt(i) == ':' || sentence.charAt(i) == '!' || sentence.charAt(i) == '?' || sentence.charAt(i) == ',' || sentence.charAt(i) == '.') {      
                pCount++;
            } 
		}
        
        return pCount;
	}
	
	/**
	 * This method count the number of characters in a sentence
	 * @return
	 */
	public int countCharacters() {
		
        int index = 0;
        char currentChar = sentence.charAt(index);
        while (currentChar != '\0') {
        	
        	currentChar = sentence.charAt(index++);
        }
        

        return index - 1;
	}
	
	

}
