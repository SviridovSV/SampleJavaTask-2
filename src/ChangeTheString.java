import javafx.util.StringConverter;

import java.util.Random;

/**
 * Created by Family on 11.12.2014.
 */
public class ChangeTheString {



    public static String randomGenerator() { //создаем метод для генерирования строки с произвольными длиной и
                                             //последовательностью символов ASCII

        int str1Length = (int) (Math.random() * 1000); //генерируем произвольную длину строки

        int[] asciiCode = new int[128]; //создаем массив с кодами ASCII (от 0 до 127)
        for (int i = 0; i < 128; i++) {
            asciiCode[i] = i;
        }
        //создаем строку с произвольной длиной
        //использовал для этого StringBuilder, т.к. планирую создавать произвольную последовательность путем
        //добавления нового символа к строке, а String является неизменным объектом
        StringBuilder aChar = new StringBuilder();
        aChar.setLength(str1Length);
        for (int i = 0; i < str1Length; i++) {

            aChar.append(new Character((char) asciiCode[(int) (Math.random() * 127)]));
        }
        String aCharStr=aChar.toString();//приводим к типу String(в необходимости данного действия не уверен,
                                         //но посчитал, что дальше величина строки изменяться не будет, а оперировать
                                         //со стрингом будет проще по ресурсозатратам
        return aCharStr;
    }
    //пишем метод для замены символов в заданной строке
    public static String transformedString(String str){
        if (str==null){  //проверяем, чтобы ссылка на обЪект не была равна null
            return "There is no string";
        }
        //делаем из заданной строки массив из символов, которые ее составляют
        char [] strChar = str.toCharArray ();
        for (int i=0;i<strChar.length;i++){ //путем перебора ищем необходимые символы и производим замены
            switch (strChar[i]){
                case '1':
                    strChar[i]='Q';
                break;
                case 'Q':
                    strChar[i]='1';
                break;
            }

        }
        String transStr = String.copyValueOf(strChar);// собираем обратно строку из массива символов
        return transStr;
    }
    public static void main(String[] args) {
        String s=randomGenerator();
        System.out.println(s);
        System.out.println("New string "+transformedString(s));



    }

}
