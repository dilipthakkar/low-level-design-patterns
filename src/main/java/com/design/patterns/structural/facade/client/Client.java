package com.design.patterns.structural.facade.client;

import com.design.patterns.structural.facade.utils.VideoLibrary;

public class Client {
    public static void main(String[] args) {
        VideoLibrary videoLibrary = new VideoLibrary(new Video("My video content"));
        Audio audio = videoLibrary.convertToAudio();
        System.out.println(audio);
    }
}
