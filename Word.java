public class Word {
private String word;
private Characters[] wordArray;

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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Characters[] getWordArray() {
        return wordArray;
    }

    public void setWordArray(Characters[] wordArray) {
        this.wordArray = wordArray;
    }

    public void checkPosition(Word other){
    Characters[] word1 = this.getWordArray();
    Characters[] word2 = other.getWordArray();
    for(int i = 0; i < 5; i++){
        if(word1[i].isEqual(word2[i])){
            other.wordArray[i].setType(2);
        } else if (this.word.contains(word2[i].getC()+"")) {//String issue possible problem
            other.wordArray[i].setType(1);
        }
        else {
            other.wordArray[i].setType(0);
        }
    }
    }


    public int compareTo(Word other){
    return this.getWord().compareTo(other.getWord());
}
}
