package homeworks.hw7.task1to7;

public class Member {
    private String name;
    private int runLimit;
    private int jumpLimit;
    private int ranDistance;
    private int countOfOvercameObstacles; //кількість пройдених перешкод
    private boolean isParticipating; //флаг для перевірки на участь в змаганнях

    public Member(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        ranDistance = 0;
        countOfOvercameObstacles = 0;
        isParticipating = true;
    }

    public void run(){
        System.out.println(name + " біжить");
    }
    public  void jump(){
        System.out.println(name+ " стрибає");
    }

    public void overcome(Obstacle obstacle){

        if(!isParticipating) return;

        //перевірка на те, чи зможе учасник пройти перешкоду
        if(obstacle.getLength() > runLimit && obstacle.getClass().getSimpleName().equalsIgnoreCase("Racetrack")){
            System.out.printf("Member %s didn`t overcome obstacle %s at the distance of %d. Total overcame obstacles: %d\n ",
                    name, obstacle.getClass().getSimpleName(), ranDistance, countOfOvercameObstacles);
            isParticipating = false;
            return;
        }
        else if(obstacle.getLength() > jumpLimit && obstacle.getClass().getSimpleName().equalsIgnoreCase("Wall")){
            System.out.printf("Member %s didn`t overcome obstacle %s at the distance of %d m. Total overcame obstacles: %d\n ",
                    name, obstacle.getClass().getSimpleName(), ranDistance, countOfOvercameObstacles);
            isParticipating = false;
            return;
        }

        ranDistance += obstacle.getLength();

        System.out.printf("Member %s overcame obstacle %s at the distance of %d m\n ",
                name, obstacle.getClass().getSimpleName(), ranDistance);

        countOfOvercameObstacles++;
    }

    public String getName() {
        return name;
    }

    public int getCountOfOvercameObstacles() {
        return countOfOvercameObstacles;
    }

    public int getRanDistance() {
        return ranDistance;
    }
}
