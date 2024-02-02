package exercicios.collections.examples;

import exercicios.collections.examples.models.Title;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 25; i++){
            int value = (int) (Math.random() * 100)+1;
            nums.add(value);
        }
        System.out.println(nums);
        Collections.sort(nums);
        System.out.println(nums);

        Title title1 = new Title("Title B");
        Title title2 = new Title("Title A");

        List<Title> titles = new LinkedList<>();
        titles.add(title1);
        titles.add(title2);

        System.out.println(titles);
        Collections.sort(titles);
        System.out.println(titles);
    }
}
