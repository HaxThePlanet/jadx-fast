package com.bumptech.glide.load.m;

import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.h;
import com.bumptech.glide.s.d;
import com.bumptech.glide.t.a;
import java.io.File;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class d implements com.bumptech.glide.load.m.n<File, ByteBuffer> {

    private static final class a implements d<ByteBuffer> {

        private final File a;
        a(File file) {
            super();
            this.a = file;
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
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

        public void e(h h, d.a<? super ByteBuffer> d$a2) {
            int str;
            String str2;
            ByteBuffer obj3;
            try {
                a2.f(a.a(this.a));
                str = 3;
                str2 = "ByteBufferFileLoader";
                str = Log.isLoggable(str2, str);
                if (str != null) {
                }
                str = "Failed to obtain ByteBuffer for file";
                Log.d(str2, str, h);
                a2.c(h);
            }
        }
    }

    public static class b implements com.bumptech.glide.load.m.o<File, ByteBuffer> {
        public com.bumptech.glide.load.m.n<File, ByteBuffer> b(com.bumptech.glide.load.m.r r) {
            d obj1 = new d();
            return obj1;
        }
    }
    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((File)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public com.bumptech.glide.load.m.n.a b(Object object, int i2, int i3, h h4) {
        return c((File)object, i2, i3, h4);
    }

    public com.bumptech.glide.load.m.n.a<ByteBuffer> c(File file, int i2, int i3, h h4) {
        d obj3 = new d(file);
        d.a obj4 = new d.a(file);
        n.a obj2 = new n.a(obj3, obj4);
        return obj2;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(File file) {
        return 1;
    }
}
