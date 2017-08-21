import java.io.*;
import java.util.*;

/**
 program to find word ladder with shortest path (i.e. minimum number edges
 */
public class Main {

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();

		String inputFileName = args[0]; // dictionary
		String word1 = args[1]; // first word
		String word2 = args[2]; // second word
  		
		FileReader reader = new FileReader(inputFileName);
		Scanner in = new Scanner(reader);
		String content=new String();
		List<String> ladder=new ArrayList<String>();
		
		while(in.hasNextLine()){ //read words from file into a array list
			content=in.nextLine();
			ladder.add(content);}

		int numWords=ladder.size();
		reader.close();
		
		Graph G=new Graph(numWords);
		int xi=0;
		int yi=0;
		for(int i =0; i<numWords;i++){
			String w1=ladder.get(i);
			G.getVertex(i).setName(w1);
			if(w1.equals(word1)){ //find indexes of word provided by command line arguments
					xi=i;
					}
			for(int j=0; j<numWords;j++){
				String w2=ladder.get(j);
				if(w2.equals(word2)){
					yi=j;
						}
				if(partofladder(w1,w2)==true){ // if words are part of a word ladder
					G.getVertex(i).addToAdjList(j); // make j adjacent to i
						}
					}
				}

	G.dijkstra(xi,yi);
        
		
		// end timer and print total time
		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time: " + (end - start) + " milliseconds");
	}

	       public static boolean partofladder(String word1, String word2){ //true if word are part of a word ladder, false if not
	        	int counter=0;
	        	for(int a=0; a<=4;a++){
	        		char x=word1.charAt(a); // index for position a in start word
				char y=word2.charAt(a); // index for position a in next word
				if(x!=y){
					counter++;}}
				//System.out.println(counter);
	        	if(counter==1){
	        		return true;}
			else{
				return false;}}

}
