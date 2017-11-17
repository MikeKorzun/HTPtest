package htp.Entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DanceHall {

private List<Integer> area = new ArrayList<Integer>();

    public DanceHall() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите последовательность:");
        String line;
        String[] array;
        line = reader.readLine();
        while (area.size()==0) {
            // парсинг строки в массив цифр
            array = (line.replaceAll("\\D+", " ").trim()).split(" ");
            for (String x: array) {
                // проверка принадлежности элемента массива к цифре
                try {
                    area.add(Integer.valueOf(x));
                } catch (NumberFormatException e) {
                    System.out.println("Числовая последовательность имеет неправильный формат, повторите ввод");
                    line = reader.readLine();
                    break;
                }
            }
        }
    }

    public List<Integer> getArea() {
        return area;
    }

    public void setArea(List<Integer> area) {
        this.area = area;
    }

    // проверка на возможность выйти за пределы площадки
    public boolean isAreaInfinite () {
        for (int i=0; i<area.size(); i++) {
            if (area.get(i)%2==0) {
                if (i + (area.get(i))>=area.size()) return false;
            }
            if (area.get(i)%2!=0) {
                if ((i - area.get(i))<0) return false;
            }
        }
        return true;
    }

}
