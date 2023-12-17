package homeworks.hw7.task1to7;

public class Main {
    public static void main(String[] args) {
        Human joe = new Human("Joe", 201, 5);
        Cat kit = new Cat("Kit", 201, 50);
        Robot r2d2 = new Robot("R2D2", 199, 3);

        Wall wall1 = new Wall(5);
        Racetrack racetrack1 = new Racetrack(100);
        Wall wall2 = new Wall(10);
        Racetrack racetrack2 = new Racetrack(200);

        Member[] groupA = new Member[]{joe, kit, r2d2};
        Obstacle[] stageA = new Obstacle[]{wall1, racetrack1, wall2, racetrack2};

        startCompetition(groupA, stageA);

    }

    public static void startCompetition(Member[] group, Obstacle[] stage){
        for (Obstacle obstacle: stage) {
            for (Member member: group) {
                member.overcome(obstacle);
            }
        }

        //пошук переможця, через кількість пройдених перешкод
        Member winner = group[0];
        for (int i = 1; i < group.length; i++) {
            if(group[i-1].getCountOfOvercameObstacles() > group[i].getCountOfOvercameObstacles()){
                winner = group[i-1];
            }
        }

        System.out.printf("\nThe winner is %s\nObstacles overcame: %d\nDistance passed %d m",
                winner.getName(), winner.getCountOfOvercameObstacles(), winner.getRanDistance());
    }
}
