package homework1.obstacle;

import homework1.participant.Participant;

public abstract class Obstacle {
    private final int size;

    public Obstacle(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public abstract void passingObstacle(Participant participants);
}
