package com.design.patterns.structural.facade.adobe;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class provides implementation of Adobe audio files.
 */
@AllArgsConstructor
@Getter
public class AdobeAudio {
    private AudioType type;
    private String content;
}
