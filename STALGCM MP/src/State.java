public class State {
    private String name = "Q";

    //for initial state and final state
    private boolean isFinal = false;
    private boolean isInitial = false;

    public State (String name) {
        this.name = name;
    }

    public State (String name, boolean isFinal, boolean isInitial) {
        this.name = name;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
    }

    public String getName() {
        return name;
    }

    public boolean isFinal() {
        return isFinal;
    }
    
    public boolean isInitial() {
        return isInitial;
    }

}
