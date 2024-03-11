
package mealeymachine;


public class Transition {
    char transitionName;
    int nextState;
    char output;

    public Transition(char transitionName, int nextState, char output) {
        this.transitionName = transitionName;
        this.nextState = nextState;
        this.output = output;
    }

    public char getOutput() {
        return output;
    }

    public void setOutput(char output) {
        this.output = output;
    }
  

    public char getTransitionName() {
        return transitionName;
    }

    public void setTransitionName(char transitionName) {
        this.transitionName = transitionName;
    }

    public int getNextState() {
        return nextState;
    }

    public void setNextState(int nextState) {
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return "Transition{" + "transitionName=" + transitionName + ", nextState=" + nextState + ", output=" + output + '}';
    }

   
    
}
