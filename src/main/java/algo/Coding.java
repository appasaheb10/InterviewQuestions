package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KeyValue {

    float time;
    String value;

    public KeyValue(float time, String value) {
        this.time = time;
        this.value = value;
    }
}

public class Coding {
    List<Coding> list = new ArrayList<>();
    //static List<String> times = new ArrayList<>();

    Map<String,List<KeyValue>> map = new HashMap();

    public void put(String key, String value, float time) {

        //String time = LocalTime.now().getHour() + "" + LocalTime.now().getMinute() + "" + LocalTime.now().getSecond();
        //times.add(time);

        if (!map.containsKey(key)) {
            if (map.get(key) == null) {
                map.put(key, new ArrayList<KeyValue>());
            }
            KeyValue keyValue = new KeyValue(time, value);
            map.get(key).add(keyValue);
        }else {
            KeyValue keyValue = new KeyValue(time, value);
            map.get(key).add(keyValue);
        }
    }

    public void get(float time, String key) {
        if(time == 0f) {
            System.out.println(map.get(key).get(map.get(key).size()-1).value);
        }

        int index = -1;
        if(map.get(key) != null) {
            System.out.println(binarySearch(map.get(key), time,0,map.get(key).size()-1)); ;
        }
    }

    public static String binarySearch(List<KeyValue> list, float element, int low, int high) {
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) /2;

            if(list.get(mid).time  == element)
                return list.get(mid).value;
            if(list.get(mid).time < element && list.get(mid+1).time > element)
                return list.get(mid).value;
            else  if(list.get(mid).time < element)
                low = mid + 1;
            else
                high = mid -1;
        }
        return "not found";

    }

    public static void main(String[] args) throws InterruptedException {

        Coding coding = new Coding();


        coding.put("abc", "1", 1);
        coding.put("abc", "2", 1.15f);
        coding.put("abc", "3",2.15f);
        coding.put("abc", "4", 2.25f);
        coding.put("abc", "5", 3f);

        coding.get(1f, "abc");
        coding.get(2f, "abc");
        coding.get(2.15f, "abc");
        coding.get(2.3f, "abc");
        coding.get(0f, "abc");  // 0 means current


    }
}
