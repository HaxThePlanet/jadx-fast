package com.bumptech.glide.load.m;

import android.util.Log;
import com.bumptech.glide.load.data.d.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader.java */
/* loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {

    private static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        private final File a;
        a(File file) {
            super();
            this.a = file;
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public com.bumptech.glide.load.a d() {
            return a.LOCAL;
        }

        public void e(com.bumptech.glide.h hVar, d.a<? super ByteBuffer> aVar) {
            String str2;
            try {
                aVar.f(a.a(this.a));
            } catch (java.io.IOException ioException) {
                int str = 3;
                str2 = "ByteBufferFileLoader";
                str = Log.isLoggable(str2, str);
            }
        }

        public void b() {
        }

        public void cancel() {
        }
    }

    public static class b implements o<File, ByteBuffer> {
        public n<File, ByteBuffer> b(r rVar) {
            return new d();
        }
    }
    public n.a<ByteBuffer> c(File file, int i, int i2, com.bumptech.glide.load.h hVar) {
        return new n.a(new d(file), new d.a(file));
    }

    public boolean d(File file) {
        return true;
    }
}
