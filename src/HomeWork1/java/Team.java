package HomeWork1.java;


public class Team {
    private String teamName;

    public Runner[] runners = {new Runner("Runner1"), new Runner("Runner2"),
            new Runner("Runner3"), new Runner("Runner4")};

    public Team(String teamName){
        this.teamName = teamName;

    }

    public void membersName (){
        System.out.println("Команда " + this.teamName + " Члены команды:");
        for (int i = 0; i < runners.length; i++)
            System.out.println(runners[i]);

    }
    public void showResults(){
        for (Runner courRunner:runners){
            System.out.println(courRunner.getRunnerName() + ": " + courRunner.getTime());
        }
    }


}