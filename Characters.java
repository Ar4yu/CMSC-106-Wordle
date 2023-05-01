

public class Characters {
    private char c;
    private int type;
    public Characters(char c){
        this.type = -1;
        String s = "" + c;
        s = s.toLowerCase();
        this.c = s.charAt(0);
    }
    
    /**
     * method that returns the given character
     * @return char-type character
     *
     */
    
    public char getC() {
        return c; // returns given character
    }

    /**
     * method that returns the the type of the character, where -1 is a placeholder before testing the character,
     * 0 is not in the word, 1 is in the word but in the wrong slot, and 2 is in the word and in the correct slot.
     * @return integer indicating type
     *
     */
    
    
    public int getType() {
        return type; // return integer type
    }
    
    /**
     * setter method for the type of the character
     * @param integer indicating type
     */

    public void setType(int type) {
        this.type = type; // setting type value
    }
    
    /**
     * setter method for the character c
     * @param char-type character c
     */

    public void setC(char c) {
        this.c = c; // setting value of c
    }
    
    /**
     * method that finds if two characters are equivalent, used for comparing guessed characters to characters
     * inside the word to guess
     * @param character c
     * @return char-type character
     *
     */

    public boolean isEqual(Characters c){
        return this.getC() == c.getC(); // will return true if the characters are equivalent
    }
}
