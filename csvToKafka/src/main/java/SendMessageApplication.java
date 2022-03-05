import java.util.stream.Stream;

public class SendMessageApplication {

    public static void main(String[] args) throws Exception {
        // 文件地址
        String filePath = "/Users/zhouyifan/Documents/cuhk/research/writetocsv/vertex.csv";
        // kafka topic
        String topic = "test";
        // kafka borker地址
//        String broker = "192.168.50.43:9092";
        String broker = "localhost:9092";
        Stream.generate(new UserBehaviorCsvFileReader(filePath))
                .sequential()
                .forEachOrdered(new KafkaProducer(topic, broker));
    }
}