public class Characters {
    private char c;
    private int type;
    public Characters(char c){
        this.type = -1;
        String s = "" + c;
        s = s.toLowerCase();
        this.c = s.charAt(0);
    }

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
}
