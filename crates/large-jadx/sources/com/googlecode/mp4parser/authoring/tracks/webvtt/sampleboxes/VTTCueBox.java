package com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes;

import com.mp4parser.streaming.WriteOnlyBox;
import f.b.a.d;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class VTTCueBox extends WriteOnlyBox {

    com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueIDBox cueIDBox;
    com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CuePayloadBox cuePayloadBox;
    com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSettingsBox cueSettingsBox;
    com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSourceIDBox cueSourceIDBox;
    com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueTimeBox cueTimeBox;
    public VTTCueBox() {
        super("vtcc");
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void getBox(WritableByteChannel writableByteChannel) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        g.g(allocate, getSize());
        allocate.put(d.e(getType()));
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSourceIDBox cueSourceIDBox = this.cueSourceIDBox;
        if (cueSourceIDBox != null) {
            cueSourceIDBox.getBox(writableByteChannel);
        }
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueIDBox cueIDBox = this.cueIDBox;
        if (cueIDBox != null) {
            cueIDBox.getBox(writableByteChannel);
        }
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueTimeBox cueTimeBox = this.cueTimeBox;
        if (cueTimeBox != null) {
            cueTimeBox.getBox(writableByteChannel);
        }
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSettingsBox cueSettingsBox = this.cueSettingsBox;
        if (cueSettingsBox != null) {
            cueSettingsBox.getBox(writableByteChannel);
        }
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CuePayloadBox cuePayloadBox = this.cuePayloadBox;
        if (cuePayloadBox != null) {
            cuePayloadBox.getBox(writableByteChannel);
        }
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueIDBox getCueIDBox() {
        return this.cueIDBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CuePayloadBox getCuePayloadBox() {
        return this.cuePayloadBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSettingsBox getCueSettingsBox() {
        return this.cueSettingsBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSourceIDBox getCueSourceIDBox() {
        return this.cueSourceIDBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueTimeBox getCueTimeBox() {
        return this.cueTimeBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public long getSize() {
        int size3;
        long size;
        long size2;
        long size4;
        int size5;
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSourceIDBox cueSourceIDBox = this.cueSourceIDBox;
        size3 = 0;
        if (cueSourceIDBox != null) {
            size = cueSourceIDBox.getSize();
        } else {
            size = size3;
        }
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueIDBox cueIDBox = this.cueIDBox;
        if (cueIDBox != null) {
            size2 = cueIDBox.getSize();
        } else {
            size2 = size3;
        }
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueTimeBox cueTimeBox = this.cueTimeBox;
        if (cueTimeBox != null) {
            size4 = cueTimeBox.getSize();
        } else {
            size4 = size3;
        }
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSettingsBox cueSettingsBox = this.cueSettingsBox;
        if (cueSettingsBox != null) {
            size5 = cueSettingsBox.getSize();
        } else {
            size5 = size3;
        }
        com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CuePayloadBox cuePayloadBox = this.cuePayloadBox;
        if (cuePayloadBox != null) {
            size3 = cuePayloadBox.getSize();
        }
        return i4 += size3;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCueIDBox(com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueIDBox cueIDBox) {
        this.cueIDBox = cueIDBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCuePayloadBox(com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CuePayloadBox cuePayloadBox) {
        this.cuePayloadBox = cuePayloadBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCueSettingsBox(com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSettingsBox cueSettingsBox) {
        this.cueSettingsBox = cueSettingsBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCueSourceIDBox(com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueSourceIDBox cueSourceIDBox) {
        this.cueSourceIDBox = cueSourceIDBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCueTimeBox(com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes.CueTimeBox cueTimeBox) {
        this.cueTimeBox = cueTimeBox;
    }
}
