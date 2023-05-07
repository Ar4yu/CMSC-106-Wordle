public class Characters {
    private char c;
    private int type;
    
    /**
    * This method constructs Characters, it takes in a Char and assigns it a type of -1 as a place holder
    * @param Char that will be a Characters.
    */
    
    public Characters(char c){
        this.type = -1;
        String s = "" + c;
        s = s.toLowerCase();
        this.c = s.charAt(0);
    }
    /**
    *This method returns the char value of a Characters
    *@return
    *
    */
    public char getC() {
        return c;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setC(char c) {
        this.c = c;
    }

    public boolean isEqual(Characters c){
        return this.getC() == c.getC();
    }

    public String toString(){
        return String.valueOf(this.c);
    }
}
