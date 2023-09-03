package com.design.patterns.structural.facade.adobe;

/**
 * Provides utility for converting one media file to another media file.
 */
public class Convertor {

    /**
     * Converts given video file to audio file. Extracts audio content from the video file.
     * @param video Adobe video to be converted
     * @param audioType Adobe audio type, to which audio content to be generate
     * @return {@link AdobeAudio}
     */
    public static AdobeAudio convertFromVideoToAudio(AdobeVideo video, AudioType audioType){
        return new AdobeAudio(audioType, video.getContent());
    }
    
}
