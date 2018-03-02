import java.util.LinkedList;
import java.util.Queue;

public class QueryIndex {

    private static Queue<Integer> indexes = new LinkedList<>();

    public synchronized static Queue<Integer> getIndexes() {
        return indexes;
    }

    public synchronized static void setIndexes(Queue<Integer> indexes) {
        QueryIndex.indexes = indexes;
    }

}
