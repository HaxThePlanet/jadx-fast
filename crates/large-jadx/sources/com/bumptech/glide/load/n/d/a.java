package com.bumptech.glide.load.n.d;

import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.e.a;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    private final ByteBuffer a;

    public static class a implements e.a<ByteBuffer> {
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.e$a
        public e b(Object object) {
            return c((ByteBuffer)object);
        }

        public e<ByteBuffer> c(ByteBuffer byteBuffer) {
            a aVar = new a(byteBuffer);
            return aVar;
        }
    }
    public a(ByteBuffer byteBuffer) {
        super();
        this.a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    public Object a() {
        return c();
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.e
    public ByteBuffer c() {
        this.a.position(0);
        return this.a;
    }
}
