package homework1.participant;

public class Robot implements Participant {

    private static final String TYPE = "Робот";
    private final String name;
    public final int runLength;
    public final int jumpHeight;
    private boolean onObstacle = true;

    public Robot(String name, int runLength, int jumpHeight ) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isOnObstacle() {
        return onObstacle;
    }

    @Override
    public void changeOnObstacle() {
        onObstacle = !onObstacle;
    }

    @Override
    public int run() {
        if(onObstacle) {
            System.out.println("Робот бежит");
        } else
        {
            System.out.print(getType() + " " + getName() + " сошел с дистанции");
        }
        return runLength;
    }

    @Override
    public int jump() {
        if(onObstacle) {
            System.out.println("Ротоб не может прыгать");
            changeOnObstacle();
        } else
        {
            System.out.print(getType() + " " + getName() + " сошел с дистанции");
            System.out.println();
        }
        return 0;
    }
}
