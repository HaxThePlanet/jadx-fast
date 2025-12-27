package com.bumptech.glide.load.m;

import android.util.Log;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class f<Data> implements n<File, Data> {

    private final f.d<Data> a;

    public interface d<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(File file);
    }

    public static class a<Data> implements o<File, Data> {

        private final f.d<Data> a;
        public a(f.d<Data> dVar) {
            super();
            this.a = dVar;
        }

        public final n<File, Data> b(r rVar) {
            return new f(this.a);
        }
    }

    private static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        private final File a;
        private final f.d<Data> b;
        private Data c;
        c(File file, f.d<Data> dVar) {
            super();
            this.a = file;
            this.b = dVar;
        }

        public Class<Data> a() {
            return this.b.a();
        }

        public void b() {
            if (this.c != null) {
                try {
                    this.b.b(this.c);
                } catch (java.io.IOException unused) {
                    return;
                }
            }
        }

        public a d() {
            return a.LOCAL;
        }

        public void e(com.bumptech.glide.h hVar, d.a<? super Data> aVar) {
            String str2;
            try {
                Object obj = this.b.c(this.a);
                this.c = obj;
                aVar.f(obj);
            } catch (java.io.FileNotFoundException fileNotFound) {
                int str = 3;
                str2 = "FileLoader";
                str = Log.isLoggable(str2, str);
            }
        }

        public void cancel() {
        }
    }

    public static class b extends f.a<android.os.ParcelFileDescriptor> {
        public b() {
            super(new f.b.a());
        }
    }

    public static class e extends f.a<java.io.InputStream> {
        public e() {
            super(new f.e.a());
        }
    }
    public f(f.d<Data> dVar) {
        super();
        this.a = dVar;
    }

    public n.a<Data> c(File file, int i, int i2, com.bumptech.glide.load.h hVar) {
        return new n.a(new d(file), new f.c(file, this.a));
    }

    public boolean d(File file) {
        return true;
    }
}
