package is2.kata2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/TheGentleDucky/SkeletonMemeDataset/refs/heads/main/Skelet.csv";

        SkeletonParser parser = new CsvSkeletonParser();
        SkeletonLoader loader= new RemoteSkeletonLoader(parser, url);

        List<Skeleton> skeletons = loader.loadSkeletons();
        skeletons.forEach(System.out::println);

    }
}
