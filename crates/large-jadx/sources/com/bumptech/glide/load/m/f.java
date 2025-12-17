package com.bumptech.glide.load.m;

import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.h;
import com.bumptech.glide.s.d;
import java.io.File;

/* loaded from: classes.dex */
public class f<Data>  implements com.bumptech.glide.load.m.n<File, Data> {

    private final com.bumptech.glide.load.m.f.d<Data> a;

    public interface d {
        public abstract Class<Data> a();

        public abstract void b(Data data);

        public abstract Data c(File file);
    }

    public static class a implements com.bumptech.glide.load.m.o<File, Data> {

        private final com.bumptech.glide.load.m.f.d<Data> a;
        public a(com.bumptech.glide.load.m.f.d<Data> f$d) {
            super();
            this.a = d;
        }

        public final com.bumptech.glide.load.m.n<File, Data> b(com.bumptech.glide.load.m.r r) {
            f obj2 = new f(this.a);
            return obj2;
        }
    }

    private static final class c implements d<Data> {

        private final File a;
        private final com.bumptech.glide.load.m.f.d<Data> b;
        private Data c;
        c(File file, com.bumptech.glide.load.m.f.d<Data> f$d2) {
            super();
            this.a = file;
            this.b = d2;
        }

        public Class<Data> a() {
            return this.b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.m.f.d dVar;
            final Object obj = this.c;
            if (obj != null) {
                this.b.b(obj);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public a d() {
            return a.LOCAL;
        }

        public void e(h h, d.a<? super Data> d$a2) {
            File file;
            String str2;
            Object obj3;
            try {
                obj3 = this.b.c(this.a);
                this.c = obj3;
                a2.f(obj3);
                int str = 3;
                str2 = "FileLoader";
                str = Log.isLoggable(str2, str);
                if (str != null) {
                }
                str = "Failed to open file";
                Log.d(str2, str, h);
                a2.c(h);
            }
        }
    }

    public static class b extends com.bumptech.glide.load.m.f.a<android.os.ParcelFileDescriptor> {
        public b() {
            f.b.a aVar = new f.b.a();
            super(aVar);
        }
    }

    public static class e extends com.bumptech.glide.load.m.f.a<java.io.InputStream> {
        public e() {
            f.e.a aVar = new f.e.a();
            super(aVar);
        }
    }
    public f(com.bumptech.glide.load.m.f.d<Data> f$d) {
        super();
        this.a = d;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((File)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public com.bumptech.glide.load.m.n.a b(Object object, int i2, int i3, h h4) {
        return c((File)object, i2, i3, h4);
    }

    public com.bumptech.glide.load.m.n.a<Data> c(File file, int i2, int i3, h h4) {
        d obj4 = new d(file);
        f.c obj5 = new f.c(file, this.a);
        n.a obj3 = new n.a(obj4, obj5);
        return obj3;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(File file) {
        return 1;
    }
}
