package com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes;

import com.mp4parser.streaming.WriteOnlyBox;
import f.b.a.d;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: VTTCueBox.java */
/* loaded from: classes2.dex */
public class VTTCueBox extends WriteOnlyBox {

    CueIDBox cueIDBox;
    CuePayloadBox cuePayloadBox;
    CueSettingsBox cueSettingsBox;
    CueSourceIDBox cueSourceIDBox;
    CueTimeBox cueTimeBox;
    public VTTCueBox() {
        super("vtcc");
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        g.g(allocate, getSize());
        allocate.put(d.e(getType()));
        writableByteChannel.write((ByteBuffer)allocate.rewind());
        if (this.cueSourceIDBox != null) {
            this.cueSourceIDBox.getBox(writableByteChannel);
        }
        if (this.cueIDBox != null) {
            this.cueIDBox.getBox(writableByteChannel);
        }
        if (this.cueTimeBox != null) {
            this.cueTimeBox.getBox(writableByteChannel);
        }
        if (this.cueSettingsBox != null) {
            this.cueSettingsBox.getBox(writableByteChannel);
        }
        if (this.cuePayloadBox != null) {
            this.cuePayloadBox.getBox(writableByteChannel);
        }
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public CueIDBox getCueIDBox() {
        return this.cueIDBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public CuePayloadBox getCuePayloadBox() {
        return this.cuePayloadBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public CueSettingsBox getCueSettingsBox() {
        return this.cueSettingsBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public CueSourceIDBox getCueSourceIDBox() {
        return this.cueSourceIDBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public CueTimeBox getCueTimeBox() {
        return this.cueTimeBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public long getSize() {
        int i = 0;
        long size;
        long size2;
        long size3;
        i = 0;
        if (this.cueSourceIDBox != null) {
            size = this.cueSourceIDBox.getSize();
        } else {
        }
        if (this.cueIDBox != null) {
            size2 = this.cueIDBox.getSize();
        } else {
        }
        if (this.cueTimeBox != null) {
            size3 = this.cueTimeBox.getSize();
        } else {
        }
        if (this.cueSettingsBox != null) {
            long size5 = this.cueSettingsBox.getSize();
        } else {
        }
        if (this.cuePayloadBox != null) {
            long size4 = this.cuePayloadBox.getSize();
        }
        return (size + 8L) + size2 + size3 + i + i;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCueIDBox(CueIDBox cueIDBox) {
        this.cueIDBox = cueIDBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCuePayloadBox(CuePayloadBox cuePayloadBox) {
        this.cuePayloadBox = cuePayloadBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCueSettingsBox(CueSettingsBox set) {
        this.cueSettingsBox = set;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCueSourceIDBox(CueSourceIDBox cueSourceIDBox) {
        this.cueSourceIDBox = cueSourceIDBox;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setCueTimeBox(CueTimeBox cueTimeBox) {
        this.cueTimeBox = cueTimeBox;
    }
}
