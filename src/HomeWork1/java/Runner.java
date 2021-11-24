package HomeWork1.java;

public class Runner {
    private String runnerName;
    private int time = 0;

    public Runner(String runnerName){
        this.runnerName = runnerName;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}