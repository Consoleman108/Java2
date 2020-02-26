package homework1;

import homework1.obstacle.Obstacle;
import homework1.obstacle.Racetrack;
import homework1.obstacle.Wall;
import homework1.participant.Cat;
import homework1.participant.Human;
import homework1.participant.Participant;
import homework1.participant.Robot;

public class Main {
    public static void main(String[] args) {

        Participant[] participants = {
                new Cat("Барсик", 200, 3),
                new Human("Петя", 1000, 2),
                new Robot("R2D2", 100, 0)};

        Obstacle[] obstacles = {
                new Racetrack(10),
                new Wall(0)};

        for (Participant  participant: participants) {
            for (Obstacle obstacle: obstacles) {
                obstacle.passingObstacle(participant);
            }
            System.out.println("-------------------------");
            System.out.println();
        }
    }
}
