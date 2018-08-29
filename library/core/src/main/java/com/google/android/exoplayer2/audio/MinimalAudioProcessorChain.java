package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;

import java.util.Arrays;

class MinimalAudioProcessorChain implements DefaultAudioSink.AudioProcessorChain {

    private final AudioProcessor[] audioProcessors;

    /**
     * Creates a new default chain of audio processors, with the user-defined {@code
     * audioProcessors} applied before silence skipping and playback parameters.
     */
    public MinimalAudioProcessorChain(AudioProcessor... audioProcessors) {
        this.audioProcessors = Arrays.copyOf(audioProcessors, audioProcessors.length);
    }

    @Override
    public AudioProcessor[] getAudioProcessors() {
        return audioProcessors;
    }

    @Override
    public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
        return new PlaybackParameters(/* speed= */ 1f);
    }

    @Override
    public long getMediaDuration(long playoutDuration) {
        return playoutDuration;
    }

    @Override
    public long getSkippedOutputFrameCount() {
        return 0;
    }
}
