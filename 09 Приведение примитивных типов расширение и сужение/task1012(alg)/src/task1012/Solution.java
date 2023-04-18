package task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
Введи с клавиатуры 10 строчек и посчитай в них количество различных букв без учета регистра. Результат выведи на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Requirements:
1. Программа должна 10 раз считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и количество раз, которое буква встречалась в введенных строках.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        // напишите тут ваш код
        Map<Character, Integer> count = getChar(list);
        for (int i = 0; i < alphabet.size(); i++) {
            if (count.get(alphabet.get(i)) != null) {
                System.out.println(alphabet.get(i) + " " + count.get(alphabet.get(i)));
            } else {
                System.out.println(alphabet.get(i) + " " + 0);
            }
        }
    }

    public static Map<Character, Integer> getChar(ArrayList<String> list) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                for (Character character : list.get(i).toCharArray()) {
                    Integer count = charCount.get(character);
                    int newCount = (count == null ? 1 : count + 1);
                    charCount.put(character, newCount);
                }
            }
        }
        return charCount;
    }
}
