package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import java.nio.ByteBuffer;

/* compiled from: GroupEntry.java */
/* loaded from: classes2.dex */
public abstract class b {
    public int d() {
        return a().limit();
    }

    public abstract ByteBuffer a();

    public abstract String b();

    public abstract void c(ByteBuffer byteBuffer);
}
