package com.bumptech.glide.load.m;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {

    private final b.b<Data> a;

    public interface b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    public static class a implements o<byte[], ByteBuffer> {
        public n<byte[], ByteBuffer> b(r rVar) {
            return new b(new b.a.a(this));
        }
    }

    private static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        private final byte[] a;
        private final b.b<Data> b;
        c(byte[] bArr, b.b<Data> bVar) {
            super();
            this.a = bArr;
            this.b = bVar;
        }

        public Class<Data> a() {
            return this.b.a();
        }

        public a d() {
            return a.LOCAL;
        }

        public void e(com.bumptech.glide.h hVar, d.a<? super Data> aVar) {
            aVar.f(this.b.b(this.a));
        }

        public void b() {
        }

        public void cancel() {
        }
    }

    public static class d implements o<byte[], InputStream> {
        public n<byte[], InputStream> b(r rVar) {
            return new b(new b.d.a(this));
        }
    }
    public b(b.b<Data> bVar) {
        super();
        this.a = bVar;
    }

    public n.a<Data> c(byte[] bArr, int i, int i2, com.bumptech.glide.load.h hVar) {
        return new n.a(new d(bArr), new b.c(bArr, this.a));
    }

    public boolean d(byte[] bArr) {
        return true;
    }
}
