import java.util.*;

class Solution {
    public static boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        int negative = 0;
        int zero = 0;
        int positive = 0;
        Map<Integer,Integer> map1 = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        Map<Integer,Integer> map2 = new TreeMap<Integer, Integer>();
        Map<Integer,Integer> map3 = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                negative++;
                map1.put(A[i],map1.getOrDefault(A[i],0)+1);
            } else if (A[i] == 0) {
                map2.put(A[i],map2.getOrDefault(A[i],0)+1);
                zero++;
            } else if (A[i] > 0) {
                map3.put(A[i],map3.getOrDefault(A[i],0)+1);
                positive++;
            }
        }
        if (negative % 2 == 1 || positive % 2 == 1 || zero % 2 == 1)
            return false;
        else {
            return (remove(map1)&&remove(map3));
        }
    }
    private static boolean remove(Map<Integer,Integer> map){
        if(map.size()==0)
            return true;
        Iterator<Integer> iterator=map.keySet().iterator();
        int key=iterator.next();
        if(map.containsKey(key*2)){
            if(map.get(key)==1)
                map.remove(key);
            else{
                map.put(key,map.get(key)-1);
            }
            if(map.get(key*2)==1)
                map.remove(key*2);
            else{
                map.put(key*2,map.get(key*2)-1);
            }
            return remove(map);
        }else return false;
    }
    public static void main(String args[]){
        int a[]={-10,-20,-40,-80};
        System.out.println(canReorderDoubled(a));
    }
}