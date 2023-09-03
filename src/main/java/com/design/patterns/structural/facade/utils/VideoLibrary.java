package com.design.patterns.structural.facade.utils;

import com.design.patterns.structural.facade.adobe.AdobeAudio;
import com.design.patterns.structural.facade.adobe.AdobeVideo;
import com.design.patterns.structural.facade.adobe.AudioType;
import com.design.patterns.structural.facade.adobe.Convertor;
import com.design.patterns.structural.facade.adobe.VideoType;
import com.design.patterns.structural.facade.client.Audio;
import com.design.patterns.structural.facade.client.Video;

import lombok.AllArgsConstructor;

/**
 * Facade class which provides utility to work with video files, using Adobe library.
 * 
 * This class provides a extra layer on top of the Adobe media library (3rd party).
 */
@AllArgsConstructor
public class VideoLibrary {
    private Video video;

    public Audio convertToAudio(){
        AdobeVideo adobeVideo = new AdobeVideo(VideoType.MP4, video.getContent());
        AdobeAudio adobeAudio = Convertor.convertFromVideoToAudio(adobeVideo, AudioType.MP3);
        return new Audio(adobeAudio.getContent());
    }
}
