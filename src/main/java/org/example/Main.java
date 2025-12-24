package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/TheGentleDucky/SkeletonMemeDataset/refs/heads/main/Skelet.csv";

        SkeletonParser parser = new CsvSkeletonParser();
        SkeletonLoader loader = new RemoteSkeletonLoader(url, parser);

        List<Skeleton> skeletonList = loader.loadSkeletons();
        skeletonList.forEach(System.out::println);

    }
}