package homework1.participant;

public interface Participant {
    String getType();
    String getName();
    boolean isOnObstacle();
    void changeOnObstacle();
    int run();
    int jump();
}
