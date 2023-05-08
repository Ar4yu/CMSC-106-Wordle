public class Word implements Comparable{
private String word;
private Characters[] wordArray;

/**
* checks to see if user input is a 5 letter word, if it is not, it throws an exception
* creates a new array of characters if user's guess is a 5 letter word
* @param word - word
* @throws illegalArguementExpection if word is not 5 letters long
*/
public Word(String word){
    if(word.length()!=5){
        throw new IllegalArgumentException("Word should have exactly five letters");
    }
    this.word = word;
    wordArray = new Characters[5];
    for(int i =0; i < 5; i++){
        Characters c = new Characters(word.charAt(i));
        wordArray[i] = c;
    }
}
    
    /**
    * This method returns the Word as a String
    * @return the word as a string
    */

    public String getWord() {
        return word;
    }
    
    /**
    * This method updates the word as a new string
    * @param String that the user would like to pass as a new word
    */
    public void setWord(String word) {
        this.word = word;
    }
    
    /**
    *This method returns the Word as a array of Characters
    *@return an array of Characters
    */

    public Characters[] getWordArray() {
        return wordArray;
    }
    /**
    *This method Sets at the characters array as a new Characters Array
    *@param an array of Characters
    */
    public void setWordArray(Characters[] wordArray) {
        this.wordArray = wordArray;
    }
    /**
    * This method goes through the Character Array and compares it to the answer and sets the Type of each Characters in the array
    * if the character in the answer matches the position and character of the user's guess, the user's character is assigned type 2
    * if the character in the answer matches a character in the user's guess, but they are in different positions in the array, the user's character is assigned type 1
    * if the character in the answer does not match a character in the user's guess, the character in the user's guess is assigned type 0
    * @param takes in the users input word
    */
    public void checkPosition(Word other){
    Characters[] word1 = this.getWordArray();
    Characters[] word2 = other.getWordArray();
    for(int i = 0; i < 5; i++){
        if(word1[i].isEqual(word2[i])){
            other.wordArray[i].setType(2);
        } else if (this.word.contains(word2[i].getC()+"")) {
        }
        else {
            other.wordArray[i].setType(0);
        }
    }
    /**
    *This method returns the Word a a string
    *@return a String of the word
    */
    public String toString(){
        return this.word;
    }
    /**
    *This method compares two words
    *@return an int that depecits alphabetical order of the two Words
   
    */

    @Override
    public int compareTo(Object other) {
        return this.getWord().compareTo(other.toString());
    }
}
