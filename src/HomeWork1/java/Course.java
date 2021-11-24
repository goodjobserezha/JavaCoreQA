package HomeWork1.java;


public class Course {
        private Obstacles[] poolCourse = {new Obstacles("Obstacle1"),
                new Obstacles("Obstacle2"), new Obstacles("Obstacle3")};

        public void doIt(Team team){
            for (Runner courRunner:team.runners){
                int result = 0;
                for (Obstacles courObst:poolCourse){
                    result += courObst.overcome(courRunner.getRunnerName());
                }
                courRunner.setTime(result);
            }
        }
    }

