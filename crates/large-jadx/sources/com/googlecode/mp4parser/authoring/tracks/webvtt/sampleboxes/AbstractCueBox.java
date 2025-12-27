package com.googlecode.mp4parser.authoring.tracks.webvtt.sampleboxes;

import com.googlecode.mp4parser.h.b;
import com.mp4parser.streaming.WriteOnlyBox;
import f.b.a.d;
import f.b.a.g;
import f.b.a.j;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: AbstractCueBox.java */
/* loaded from: classes2.dex */
public abstract class AbstractCueBox extends WriteOnlyBox {

    String content = "";
    public AbstractCueBox(String str) {
        super(str);
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void getBox(WritableByteChannel writableByteChannel) throws java.io.IOException {
        ByteBuffer allocate = ByteBuffer.allocate(b.a(getSize()));
        g.g(allocate, getSize());
        allocate.put(d.e(getType()));
        allocate.put(j.b(this.content));
        writableByteChannel.write((ByteBuffer)allocate.rewind());
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public String getContent() {
        return this.content;
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public long getSize() {
        return (long)(j.c(this.content) + 8);
    }

    @Override // com.mp4parser.streaming.WriteOnlyBox
    public void setContent(String str) {
        this.content = str;
    }
}
