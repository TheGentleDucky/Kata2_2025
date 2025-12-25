package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RemoteSkeletonLoader implements SkeletonLoader {

    private final SkeletonParser skeletonParser;
    private final String skeletonUrl;

    public RemoteSkeletonLoader(String skeletonUrl, SkeletonParser skeletonParser) {
        this.skeletonUrl = skeletonUrl;
        this.skeletonParser = skeletonParser;
    }

    @Override
    public List<Skeleton> loadSkeletons() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new URL(skeletonUrl).openStream()))){

            return graveyardShuffle(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<Skeleton> graveyardShuffle(BufferedReader reader) throws IOException {
        List<Skeleton> skeletons = new ArrayList<>();

        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null){
            if (line.isBlank()) {
                continue; 
            }

            skeletons.add(skeletonParser.parse(line));
        }
        return skeletons;
    }
}
