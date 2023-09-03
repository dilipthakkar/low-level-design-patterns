package com.design.patterns.structural.facade.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents audio media file.
 */
@AllArgsConstructor
@Getter
public class Audio {

    // We are only using MP3 audio files, so we don't need to specify the audio type.
    private String content;
    
}
