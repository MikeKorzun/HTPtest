package htp;

import htp.Entity.DanceHall;
import htp.Entity.Dancer;


import java.io.IOException;


/**
 *
 * Стартовая позиция для танца = первая цифра в последовательности = начало площадки
 * Танец окончен, если вышли за пределы площадки
 * Танец вечный, если мы не можем выйти за пределы площадки
 * Числовая последовательность должна содержать цифры, разделенные пробелом,
 * количество чисел от 1 до 50, все числа <0 будут преобразованы в положительные
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        DanceHall danceHall = new DanceHall();
        Dancer dancer = new Dancer();
        // OK moving
        while (dancer.canMove(
                dancer.getPosition(),
                danceHall.getArea().get(dancer.getPosition()),
                danceHall.getArea().size())
        ) {
            if (!danceHall.isAreaInfinite()) {
                dancer.move(danceHall.getArea().get(dancer.getPosition()), danceHall.getArea().size());
                if (dancer.getPosition()>=danceHall.getArea().size()) break;
                if (dancer.getPosition()<0) break;
            } else {
                dancer.setTotalSteps(-1);
                break;
            }
        }
        System.out.println(dancer.getTotalSteps());
    }
 }
