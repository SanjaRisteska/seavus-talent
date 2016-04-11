import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class WordCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName=args[0];
		
		
		HashMap<String,Integer> words=new HashMap<String,Integer>();
		File f=new File(fileName);
		try{
			FileReader file = new FileReader(f);
            BufferedReader buff = new BufferedReader(file);
            
            boolean eof = false;
            while (!eof) {
            	String line = buff.readLine();
                if (line == null) {
                    eof = true;

                } else {
                    String[] lineWords=line.split(" ");
                    for(int i=0;i<lineWords.length;i++){
                    	String currentWord=lineWords[i].toLowerCase();
                    	if(words.containsKey(currentWord)){
                    		int newValue=words.get(currentWord)+1;
                    		words.replace(currentWord,newValue);
                    	}
                    	else{
                    		words.put(currentWord, 1);
                    	}
                    }
                }
            }
            
            buff.close();
		} catch(IOException ex){
			System.out.println("Error — " + ex.toString());
		}
		
		
		
		
		for(String key : words.keySet()){
			System.out.println(key+" - "+words.get(key));
		}
		
		 
		

	}

}
