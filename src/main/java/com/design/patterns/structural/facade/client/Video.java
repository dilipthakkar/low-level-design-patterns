package com.design.patterns.structural.facade.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents video media file.
 */
@AllArgsConstructor
@Getter
public class Video {

    // We are only using MP4 video files, so we don't need to specify the video type.
    private String content;
    
}
