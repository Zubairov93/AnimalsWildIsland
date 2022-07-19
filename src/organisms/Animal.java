package organisms;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    private final int id;
    private final double weight;
    private final int maxCountInCell;
    private final int speedMoveToCell;
    private final double foodForSaturation;
    private double currentSaturation;

    private boolean animalIsDead;
    private boolean animalAlreadyMoved;

    public boolean isAnimalAlreadyMoved() {
        return animalAlreadyMoved;
    }
    public void setAnimalAlreadyMoved(boolean animalAlreadyMoved) {
        this.animalAlreadyMoved = animalAlreadyMoved;
    }
    public  boolean isAnimalisDead(){
        return isAnimalisDead();
    }
    public void setAnimalisDead(boolean animalIsDead) {
        this.animalIsDead = animalIsDead;
    }
    public boolean isSaturation() {
        return this.foodForSaturation - this.currentSaturation < 1.0;
    }
    public void  toSaturate(Animal otherAnimal) {
        this.currentSaturation += otherAnimal.getWeight();
        otherAnimal.setAnimalisDead(true);
    }

    public void toSaturate(Plant plant) {
        this.currentSaturation += plant.getWeight();
    }
    public String getSimpleClassName() {
        return  this.getClass().getSimpleName();
    }

    public MoveDirection chooseSideToMove() {
        int direction = ThreadLocalRandom.current().nextInt(1,5);
        MoveDirection directionEnum = null;
        switch (direction) {
            case 1:
                directionEnum = MoveDirection.UP;
                break;
            case 2:
                directionEnum = MoveDirection.DOWN;
                break;
            case 3:
                directionEnum = MoveDirection.LEFT;
                break;
            case 4:
                directionEnum = MoveDirection.RIGHT;
                break;
            case 5:
                directionEnum = MoveDirection.RIGHT;
                break;
        }
        return  directionEnum;
    }




    public Animal(int id, double weight, int maxCountInCell, int speedMoveToCell, double foodForSaturation,double currentSaturation) {
        this.id = id;
        this.weight = weight;
        this.maxCountInCell = maxCountInCell;
        this.speedMoveToCell = speedMoveToCell;
        this.foodForSaturation = foodForSaturation;
        this.currentSaturation = currentSaturation;
    }

    public String getSimpleNameClassName() {
        return this.getClass().getSimpleName();
    }


    public void move() {

    }

    public double getWeight() {
        return weight;
    }
}
