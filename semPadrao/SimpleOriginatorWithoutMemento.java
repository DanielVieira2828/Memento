import java.util.ArrayList;
import java.util.List;

public class SimpleOriginatorWithoutMemento {
    private String state;
    private List<String> savedStates = new ArrayList<>();

    public void setState(String state) {
        this.state = state;
        System.out.println("State set to: " + state);
    }

    public String getState() {
        return state;
    }

    public void saveState() {
        savedStates.add(state);
        System.out.println("State saved: " + state);
    }

    public void restoreState(int index) {
        if (index >= 0 && index < savedStates.size()) {
            state = savedStates.get(index);
            System.out.println("State restored to: " + state);
        } else {
            System.out.println("Invalid state index.");
        }
    }

    public static void main(String[] args) {
        SimpleOriginatorWithoutMemento originator = new SimpleOriginatorWithoutMemento();

        originator.setState("State #1");
        originator.setState("State #2");
        originator.saveState(); // Save State #2

        originator.setState("State #3");
        originator.saveState(); // Save State #3

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.restoreState(0); // Restore State #2
        originator.restoreState(1); // Restore State #3
    }
}