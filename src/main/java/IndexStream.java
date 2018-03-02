import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class IndexStream {

    public void readIndex() {
        try {
            List<String> list = Files.readAllLines(Paths.get("." + File.separator + "index.txt"));
            final Queue<Integer> queue = list.stream().map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));

            QueryIndex.setIndexes(queue);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void writeIndex() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("." + File.separator + "index.txt"));
            Queue<Integer> indexes = QueryIndex.getIndexes();
            int size = indexes.size();
            for (int i = 0; i < size; i++) {
                writer.write(QueryIndex.getIndexes().poll() + System.lineSeparator());
            }
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
