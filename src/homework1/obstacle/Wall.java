package homework1.obstacle;

import homework1.participant.Participant;

public class Wall extends Obstacle {

    public Wall(int height) {
        super(height);
    }

    @Override
    public void passingObstacle(Participant participants) {
        int jumpHeight = participants.jump();
        boolean result = (jumpHeight >= getSize());
        boolean onObstacle = participants.isOnObstacle();

        if(onObstacle) {
            if (result & (getSize()!= 0)) {
                System.out.println(participants.getType() + " " + participants.getName() + " прыгнул ");
            } else {
                System.out.println(participants.getType() + " " + participants.getName() + " не прыгнул");
                participants.changeOnObstacle();
            }
        }

        //return result;
    }
}
