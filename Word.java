public class Word {
private String word;
private Characters[] wordArray;
    
    /**
    * checks to see if user input is a 5 letter word, if it is not, it throws an exception
    * creates a new array of characters if user's guess is a 5 letter word
    * @param word - word 
    */

public Word(String word){
    if(word.length()!=5){ // throw exception if the guess is something other than a 5-letter word.
        throw new IllegalArgumentException("Word should have exactly five letters");
    }
    this.word = word;
    wordArray = new Characters[5];
    for(int i =0; i < 5; i++){ // for each index in the word, establish a new character for each letter and insert into wordArray
        Characters c = new Characters(word.charAt(i));
        wordArray[i] = c;
    }
}

    /**
    * gets word 
    */
    
    public String getWord() {
        return word;
    }

    /**
    * sets word
    * param word - word 
    */
    
    public void setWord(String word) {
        this.word = word;
    }

    /**
    * gets array of characters for given guess 
    */
    
    public Characters[] getWordArray() {
        return wordArray;
    }

    /**
    * sets array of characters for given guess
    * param Characters[] wordArray 
    */
    
    public void setWordArray(Characters[] wordArray) {
        this.wordArray = wordArray;
    }

    /**
    * compares characters in the answer to the characters in the same position in the user's guess
    * @param Word other 
    * 
    */
    
    public void checkPosition(Word other){
    Characters[] word1 = this.getWordArray();
    Characters[] word2 = other.getWordArray();
    for(int i = 0; i < 5; i++){
        if(word1[i].isEqual(word2[i])){
            other.wordArray[i].setType(2); // if the character in the answer matches the position and character of the user's guess, the user's character is assigned type 2
        } else if (this.word.contains(word2[i].getC()+"")) {//String issue possible problem
            other.wordArray[i].setType(1); // if the character in the answer matches a character in the user's guess, but they are in different positions in the array, the user's character is assigned type 1
        }
        else { //  if the character in the answer does not match a character in the user's guess, the character in the user's guess is assigned type 0
            other.wordArray[i].setType(0);
        }
    }
    }

    
    /**
    * compares users guess to answer
    * param Word other 
    */

    public int compareTo(Word other){
    return this.getWord().compareTo(other.getWord());
}
}
