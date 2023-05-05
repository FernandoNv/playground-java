package exercicios.codingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Question5 {

    private class GoodVsEvil {
        private static Map<Integer, Integer> goodMap = new HashMap<>();
        private static Map<Integer, Integer> evilMap = new HashMap<>();
        private static void initMapValues(){
            init(goodMap, evilMap);
        }

        public static String battle(String goodAmounts, String evilAmounts) {
            init(goodMap, evilMap);

            var valuesGood = Arrays.stream(goodAmounts.split(" ")).mapToInt(num -> Integer.valueOf(num)).toArray();
            var valuesEvil = Arrays.stream(evilAmounts.split(" ")).mapToInt(num -> Integer.valueOf(num)).toArray();

            int sumGood = 0, sumEvil = 0;

            for(int i = 0; i < valuesGood.length; i++){
                sumGood += valuesGood[i] * goodMap.get(i);
            }
            for(int i = 0; i < evilMap.size(); i++){
                sumEvil += valuesEvil[i] * evilMap.get(i);
            }

            if(sumGood >  sumEvil){
                return "Battle Result: Good triumphs over Evil";
            }

            if(sumGood < sumEvil){
                return "Battle Result: Evil eradicates all trace of Good";
            }

            return "Battle Result: No victor on this battle field";
        }

        private static void init(Map<Integer, Integer> goodMap, Map<Integer, Integer> evilMap) {
            goodMap.clear();
            evilMap.clear();

            goodMap.put(0, 1);
            goodMap.put(1, 2);
            goodMap.put(2, 3);
            goodMap.put(3, 3);
            goodMap.put(4, 4);
            goodMap.put(5, 10);

            evilMap.put(0, 1);
            evilMap.put(1, 2);
            evilMap.put(2, 2);
            evilMap.put(3, 2);
            evilMap.put(4, 3);
            evilMap.put(5, 5);
            evilMap.put(6, 10);
        }
    }

    public static void main(String[] args) {
        System.out.println(GoodVsEvil.battle("1 0 0 0 0 0", "1 0 0 0 0 0 0"));
    }
}
