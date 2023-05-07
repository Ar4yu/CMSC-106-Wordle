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
        return c;
    } // returns given character

    /**
     * method that returns the type of the character, where -1 is a placeholder before testing the character,
     * 0 is not in the word, 1 is in the word but in the wrong slot, and 2 is in the word and in the correct slot.
     * @return integer indicating type
     *
     */
    public int getType() {
        return type;
    } // return integer type

    /**
     * setter method for the type of character
     * @param type integer indicating type
     */

    public void setType(int type) {
        this.type = type;
    }

    /**
     * setter method for the character c
     * @param c char-type character
     */
    public void setC(char c) {
        this.c = c;
    }


    /**
     * method that finds if two characters are equivalent, used for
     * comparing guessed characters to characters inside the word to guess
     * @param c character
     * @return boolean result indicating if two characters are equivalent
     */
    public boolean isEqual(Characters c){
        return this.getC() == c.getC();
    }

    /**
     * toString method
     * @return string version of the character
     */

    public String toString(){
        return String.valueOf(this.c);
    }
}
