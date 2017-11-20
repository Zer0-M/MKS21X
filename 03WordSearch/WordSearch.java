import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;

public class WordSearch{
  private char[][]data;
  private String soln;
  private Random randgen;
  private int seed;
  private ArrayList<String>wordsToAdd;
  private ArrayList<String>wordsAdded;

    /**Initialize the grid to the size specified

     *fill all of the positions with '_'
     *fill grid with words from filename and random letters
     *@param rows is the starting height of the WordSearch
     *@param cols is the starting width of the WordSearch
     *@param fileName is the name of a file that contains words formatted in the way specified in the instructions
     */
  public WordSearch( int rows, int cols, String fileName){
    data= new char[rows][cols];
    clear();                                       //The data field is populated with '_' using this method
    wordsToAdd=new ArrayList<String>();            //initializes the wordsToAdd ArrayList
    try{
      File f = new File(fileName);                 //can combine
      Scanner in = new Scanner(f);                 //into one line

      while(in.hasNext()){
        String word = in.next();
        word=word.toUpperCase();
        wordsToAdd.add(word);                      //Adds all the words seperated by whitespace from the file to the wordsToAdd ArrayList

      }

    }catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      //e.printStackTrace();
      System.exit(1);
    }
    seed = (int)(Math.random()*Math.pow(10,(int)(Math.random()*10)));
    wordsAdded=new ArrayList<String>();
    randgen=new Random(seed);
    addAllWords();
    soln=toString();                               // The addAllWords method doesn't add the random letters to the grid so the string of the WordSearch object here will be the solutions
    fillGrid();

  }
  /**Initialize the grid to the size specified

   *fill all of the positions with '_'
   *fill grid with words from filename and random letters
   *@param rows is the starting height of the WordSearch
   *@param cols is the starting width of the WordSearch
   *@param fileName is the name of a file that contains words formatted in the way specified in the instructions
   *@param seed is the seed used to generate the sequence of random digits, which are used postion the words in the grid
   */
  public WordSearch( int rows, int cols, String fileName, int seed){
    data= new char[rows][cols];
    clear();
    wordsToAdd=new ArrayList<String>();
    try{
      File f = new File(fileName);                 //can combine
      Scanner in = new Scanner(f);                 //into one line

      while(in.hasNext()){
        String word = in.next();
        wordsToAdd.add(word);

      }

    }catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      //e.printStackTrace();
      System.exit(1);
    }
    this.seed=seed;
    wordsAdded=new ArrayList<String>();
    randgen=new Random(seed);                       // if the Random object is generated using a specefic seed the the sequence of random digits can be replicated and thus we can store the word grid
    addAllWords();
    soln=toString();
    fillGrid();
  }

    /**Set all values in the WordSearch to underscores'_'*/
  public void clear(){
    for(int i=0;i<data.length;i++){                 //loop through each column of each row and set that to a '_'
      for(int col=0;col<data[i].length;col++){
        try{
          data[i][col]='_';
        }catch(ArrayIndexOutOfBoundsException e){}
      }
    }
  }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
  public String toString(){
    String grid="";
    for(int i=0;i<data.length;i++){
      for(int col=0;col<data[i].length;col++){
        try{
          grid+=data[i][col] +" ";                    // lopping through each column of each row in the data field and adds each of these characters to a String
        }catch(ArrayIndexOutOfBoundsException e){}
      }
      grid+="\n";
    }
    for(int i=0;i<wordsAdded.size();i++){             //this part gives the user the words that the users need to look for in the word search
      String word=wordsAdded.get(i);
      if(i%3==0){                                     //the number after the % is the number of words per line
        grid+="\n";
      }
      grid+=word+"  ";
    }
    return grid;
  }

  /**Returns the solution of the word search
   *@return a string formatted like the word search but with only the answers
   *in place of the random letters there are underscores
   */
  public String getSoln(){
    return soln;
  }

  /**Returns the word search puzzle
   *@return a properly formatted string of the word search grid
   */
  public String getPuzzle(){
    return toString();
  }

  /**Returns words added to the word search
   *@return an array of the words added
   */
  public String getWordsAded(){
    return wordsAdded.toString();
  }

  /**Returns the seed used to create the randgen
   *@return an int
   */
  public int getSeed(){
    return seed;
  }

  /**Attempt to add all of the words from the wordsToAdd list to the word search
   *@return true if words are added
   */
  private boolean addAllWords(){
    int len=wordsToAdd.size();
    boolean added=false;                             //indicates whether a certain word has been added to the WordSearch grid
    for(int count=0;count!=len;count++){             // count indicates the number of words that have been added
      for(int x=0;x<1000&&!added;x++){               // x indicates the number of attempts the program has tried to made to add a word to the grid
        String word=wordsToAdd.get(randgen.nextInt(wordsToAdd.size()));         //picking random words makes sure that the words are not added in the same order
        int colInc=0;
        int rowInc=0;
        while(colInc==0&&rowInc==0){                 //both increments cannot be 0 since having both increments being 0 would cause only the first letter to be added to the grid
          colInc=randgen.nextInt(3)-1;
          rowInc=randgen.nextInt(3)-1;
        }
        int row=randgen.nextInt(data[0].length);
        int col=randgen.nextInt(data.length);
        added=addWord(row,col,word,rowInc,colInc);
        if(added){
          wordsAdded.add(word);                       // take the word out from wordsToAdd and place it in wordsAdded
          wordsToAdd.remove(word);
        }
      }
      added=false;                                    //set back to false because the word is changed
    }
    return true;
  }

  /**Fills in the empty spots in the word search using random letters
   *@return returns true if the grid is filled
   */
  private boolean fillGrid(){
    for(int row=0;row<data.length;row++){
      for(int col=0;col<data[row].length;col++){
        if(data[row][col]=='_'){
          data[row][col]=(char) (randgen.nextInt(26)+65);       //generates a random integer and typecasts that to a character and these random characters are added to the remaining empty spaces on the grid
        }
      }
    }
    return true;

  }
  /**Given a word in the form of a string it will add that word to the
   *word search grid starting at the row and col given and the column and
   *row increments specify if its horizontal,vertical or diagnol.
   *@param row is the row at which the word starts
   *@param col is the col at whcih the word starts
   *@param word is the word that is being added to the grid
   *@param rowIncrement is the number added to row for every letter in the word
   *it has to be between -1 and 1 inclusive, if colIncrement is 0 then it can't be 0
   *@param colIncrement is the number added to row for every letter in the word
   *it has to be between -1 and 1 inclusive, if rowIncrement is 0 then it can't be 0
   */
  private boolean addWord( int row, int col, String word, int rowIncrement, int colIncrement){
    try{
      int testRow=row;                                //These variables and the loop below are used to test whether there are any exceptions and  whether the overlapping characters of two words are the same or not
      int testCol=col;
      for(int ind=0;ind<word.length();ind++){
        if(data[testRow][testCol]!='_'&&data[testRow][testCol]!=word.charAt(ind)){
          return false;
        }
        testRow+=rowIncrement;
        testCol+=colIncrement;
      }
    }
    catch(ArrayIndexOutOfBoundsException e){
      return false;
    }
    for(int i=0;i<word.length();i++){
      data[row][col]=word.charAt(i);                    // this part just adds the word to the grid in the specified location
      row+=rowIncrement;
      col+=colIncrement;
    }
    return true;
  }

  public static void main(String[] args){
    String instructions="To create a WordSearch you require a file containing words and the number of row and columns.\nThe file needs to contain one word per line and it needs to be a text file.\nThe number of row and columns need to be integers above 0.\nThe arguments need to as such java WordSearch r c mydatafile.txt.\nThere are two optional arguments: the seed, which causes the word search to be the same if you run the program again, and the answers;if you want the answers you will need to provide a seed and the string key as the 5th argument ";
    try{
      if(args.length<3){
        System.out.println(instructions); // there needs to be at least three arguments
      }
      else if(Integer.parseInt(args[0])<=0||Integer.parseInt(args[1])<=0){
        System.out.println(instructions);// The rows or columns cannot be negative or zero
      }
      else if(args.length==3){
        WordSearch search=new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);//A WordSearch is created with the given arguments and a random seed
        System.out.println(search);
        System.out.println("Seed: "+search.getSeed());//the random seed is printed when no seed is given
      }
      else if(args.length==4){
        WordSearch search=new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));//A WordSearch is created with the given arguments
        System.out.println(search);
      }
      else if(args.length==5){
        WordSearch search=new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
        System.out.println(search);
        if(args[4].equals("key")){
          System.out.println(search.getSoln());//The answer key will be printed if the 5th argument is the string key
        }
      }
      else{
        System.out.println(instructions);
      }
    }catch(NumberFormatException e){//This catch stament makes sure that the arguments are of the correct type
      System.out.println(instructions);
    }
  }
}
