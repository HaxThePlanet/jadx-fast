package com.bumptech.glide.load.n.d;

import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.e.a;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    private final ByteBuffer a;

    public static class a implements e.a<ByteBuffer> {
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public e<ByteBuffer> c(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }
    public a(ByteBuffer byteBuffer) {
        super();
        this.a = byteBuffer;
    }

    public ByteBuffer c() {
        this.a.position(0);
        return this.a;
    }

    public void b() {
    }
}
