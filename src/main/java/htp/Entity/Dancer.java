package htp.Entity;

public class Dancer {

    private int totalSteps;
    private int position;

    public Dancer() {
        this.position = 0;
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    // OK движение вперед/назад
    public void move(int aSteps, int aSize) {
        int temp = position;
        // вперед
        if (isEvenNumber(aSteps)) {
            position = position + aSteps;
            if (canMove(position, aSteps, aSize)) {
                totalSteps = totalSteps + aSteps;
            } else {
                totalSteps = totalSteps + temp;
            }
        }
        // назад
        if (!isEvenNumber(aSteps)) {
            position = position - aSteps;
            if (canMove(position, aSteps, aSize)) {
                totalSteps = totalSteps + aSteps;
            } else {
                totalSteps = totalSteps + temp;
            }
        }
    }

    // OK проверка на четное/нечетное число
    private boolean isEvenNumber(int x) {
        return x % 2 == 0;
    }

    // OK проверка возможности двигаться
    public boolean canMove(int aPosition, int aSteps, int aSize) {
        if (aPosition<0) return false;
        if (aPosition>aSize-1) return false;
        if (aSteps==0) return false;
        return true;
    }
}
