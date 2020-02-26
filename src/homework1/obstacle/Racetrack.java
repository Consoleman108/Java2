package homework1.obstacle;

import homework1.participant.Participant;

public class Racetrack extends Obstacle {

   public Racetrack(int length) {
       super(length);
   }

    @Override
    public void passingObstacle(Participant participants) {
        int runLength = participants.run();
        boolean result = (runLength >= getSize());
        boolean onObstacle = participants.isOnObstacle();

        if(onObstacle){
            if(result & (getSize()!= 0)) {
                System.out.println(participants.getType() + " " + participants.getName() + " пробежал ");
            } else {
                System.out.println(participants.getType() + " " + participants.getName() + " не пробежал");
                participants.changeOnObstacle();
            }
        }

        //return result;
    }

}
