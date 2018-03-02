import java.util.LinkedList;
import java.util.Queue;

public class Combiner {

    private final static String str = "123456789asdfghjklzxcvbnm";
    private final static String value = "222222222222222222222222222";

    public Queue<Integer> combine() {
        Queue<Integer> indexes = QueryIndex.getIndexes();

        for (int i = value.length() - 1; i >= 0; i--) {
            indexes.add(i);
            rec(i, value, 0, indexes);
            indexes.remove();
        }
        return indexes;
    }

    public void rec(final int i, final String value, int g1, final Queue<Integer> indexes) {
        if (i < value.length() - 1) {
            for (int g = g1; g < str.length(); g++) {
                String s = value.substring(0, i) + str.charAt(g) + value.substring(i + 1);
                indexes.add(g);
                rec(i + 1, s, 1, indexes);
                ((LinkedList)indexes).removeLast();
            }
            return;
        }
        for (int k = 0; k < str.length(); k++) {
            String s = value.substring(0, i) + str.charAt(k) + value.substring(i + 1);
            System.out.println(s);
        }
    }

    public void combineSave(final Queue<Integer> indexes) {
        Integer remove;
        if (indexes.isEmpty()) {
            remove = value.length() - 1;
        } else {
            remove  = indexes.poll();
        }
        for (int i = remove; i >= 0; i--) {
            recSave(i, value, 0, indexes);
        }
    }

    public void recSave(final int i, final String value, int g1, final Queue<Integer> indexes) {
        if (i < value.length() - 1) {
            Integer remove;
            if (indexes.isEmpty()) {
                remove = g1;
            } else {
               remove  = indexes.poll();
            }
            for (int g = remove; g < str.length(); g++) {
                String s = value.substring(0, i) + str.charAt(g) + value.substring(i + 1);
                recSave(i + 1, s, 1, indexes);
            }
            return;
        }
        for (int k = 0; k < str.length(); k++) {
            String s = value.substring(0, i) + str.charAt(k) + value.substring(i + 1);
            System.out.println(s);
        }
    }

}
