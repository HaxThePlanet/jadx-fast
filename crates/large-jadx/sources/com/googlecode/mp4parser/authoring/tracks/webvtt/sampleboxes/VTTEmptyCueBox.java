package com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes;

import com.mp4parser.streaming.WriteOnlyBox;
import f.b.a.d;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes2.dex */
public class VTTEmptyCueBox extends WriteOnlyBox {
    public VTTEmptyCueBox() {
        super("vtte");
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void getBox(WritableByteChannel writableByteChannel) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        g.g(allocate, getSize());
        allocate.put(d.e(getType()));
        writableByteChannel.write((ByteBuffer)allocate.rewind());
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public long getSize() {
        return 8;
    }
}
