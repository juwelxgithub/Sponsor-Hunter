package com.seu.sponsor_hunter.service;

import com.seu.sponsor_hunter.model.Influencer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class InfluencerService {
    public void save(Influencer influencer) {
        String line = influencer.getName() + "," + influencer.getFollower() + "," + influencer.getPrice() + "," + influencer.getEmail() + "\n";

        try {
            RandomAccessFile raf = new RandomAccessFile("influencerInfo.txt", "rw");
            raf.seek(raf.length());
            raf.writeBytes(line);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Influencer> list() {
        List<Influencer> influencerList = new ArrayList<>();
        try {
            RandomAccessFile raf = new RandomAccessFile("influencerInfo.txt", "r");
            String line;
            while ((line = raf.readLine()) != null) {
                String[] arr = line.split(",");
                String name = arr[0];
                double follower = Double.parseDouble(arr[1]);
                double price = Double.parseDouble(arr[2]);
                String email = arr[3];

                Influencer influencer = new Influencer(name, follower, price, email);
                influencerList.add(influencer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return influencerList;
    }
}
