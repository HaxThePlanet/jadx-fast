package com.bumptech.glide.load.m;

import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.h;
import com.bumptech.glide.s.d;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class b<Data>  implements com.bumptech.glide.load.m.n<byte[], Data> {

    private final com.bumptech.glide.load.m.b.b<Data> a;

    public interface b {
        public abstract Class<Data> a();

        public abstract Data b(byte[] bArr);
    }

    public static class a implements com.bumptech.glide.load.m.o<byte[], ByteBuffer> {
        public com.bumptech.glide.load.m.n<byte[], ByteBuffer> b(com.bumptech.glide.load.m.r r) {
            b.a.a aVar = new b.a.a(this);
            b obj2 = new b(aVar);
            return obj2;
        }
    }

    private static class c implements d<Data> {

        private final byte[] a;
        private final com.bumptech.glide.load.m.b.b<Data> b;
        c(byte[] bArr, com.bumptech.glide.load.m.b.b<Data> b$b2) {
            super();
            this.a = bArr;
            this.b = b2;
        }

        public Class<Data> a() {
            return this.b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public a d() {
            return a.LOCAL;
        }

        public void e(h h, d.a<? super Data> d$a2) {
            a2.f(this.b.b(this.a));
        }
    }

    public static class d implements com.bumptech.glide.load.m.o<byte[], InputStream> {
        public com.bumptech.glide.load.m.n<byte[], InputStream> b(com.bumptech.glide.load.m.r r) {
            b.d.a aVar = new b.d.a(this);
            b obj2 = new b(aVar);
            return obj2;
        }
    }
    public b(com.bumptech.glide.load.m.b.b<Data> b$b) {
        super();
        this.a = b;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((byte[])object);
    }

    @Override // com.bumptech.glide.load.m.n
    public com.bumptech.glide.load.m.n.a b(Object object, int i2, int i3, h h4) {
        return c((byte[])object, i2, i3, h4);
    }

    public com.bumptech.glide.load.m.n.a<Data> c(byte[] bArr, int i2, int i3, h h4) {
        d obj4 = new d(bArr);
        b.c obj5 = new b.c(bArr, this.a);
        n.a obj3 = new n.a(obj4, obj5);
        return obj3;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(byte[] bArr) {
        return 1;
    }
}
