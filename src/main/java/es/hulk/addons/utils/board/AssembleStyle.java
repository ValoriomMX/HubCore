package es.hulk.addons.utils.board;

public enum AssembleStyle
{
    KOHI("KOHI", 0, true, 15), 
    VIPER("VIPER", 1, true, -1), 
    MODERN("MODERN", 2, false, 1);
    
    private boolean decending;
    private int startNumber;
    
    private AssembleStyle(final String s, final int n, final boolean decending, final int startNumber) {
        this.decending = decending;
        this.startNumber = startNumber;
    }
    
    public boolean isDecending() {
        return this.decending;
    }
    
    public int getStartNumber() {
        return this.startNumber;
    }
}
