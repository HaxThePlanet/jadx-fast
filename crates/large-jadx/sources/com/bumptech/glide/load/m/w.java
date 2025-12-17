package com.bumptech.glide.load.m;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.i;
import com.bumptech.glide.load.data.n;
import com.bumptech.glide.load.h;
import com.bumptech.glide.s.d;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class w<Data>  implements com.bumptech.glide.load.m.n<Uri, Data> {

    private static final Set<String> b;
    private final com.bumptech.glide.load.m.w.c<Data> a;

    public interface c {
        public abstract d<Data> a(Uri uri);
    }

    public static final class a implements com.bumptech.glide.load.m.o<Uri, AssetFileDescriptor>, com.bumptech.glide.load.m.w.c<AssetFileDescriptor> {

        private final ContentResolver a;
        public a(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        public d<AssetFileDescriptor> a(Uri uri) {
            a aVar = new a(this.a, uri);
            return aVar;
        }

        public com.bumptech.glide.load.m.n<Uri, AssetFileDescriptor> b(com.bumptech.glide.load.m.r r) {
            w obj1 = new w(this);
            return obj1;
        }
    }

    public static class b implements com.bumptech.glide.load.m.o<Uri, ParcelFileDescriptor>, com.bumptech.glide.load.m.w.c<ParcelFileDescriptor> {

        private final ContentResolver a;
        public b(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        public d<ParcelFileDescriptor> a(Uri uri) {
            i iVar = new i(this.a, uri);
            return iVar;
        }

        public com.bumptech.glide.load.m.n<Uri, ParcelFileDescriptor> b(com.bumptech.glide.load.m.r r) {
            w obj1 = new w(this);
            return obj1;
        }
    }

    public static class d implements com.bumptech.glide.load.m.o<Uri, InputStream>, com.bumptech.glide.load.m.w.c<InputStream> {

        private final ContentResolver a;
        public d(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        public d<InputStream> a(Uri uri) {
            n nVar = new n(this.a, uri);
            return nVar;
        }

        public com.bumptech.glide.load.m.n<Uri, InputStream> b(com.bumptech.glide.load.m.r r) {
            w obj1 = new w(this);
            return obj1;
        }
    }
    static {
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        w.b = Collections.unmodifiableSet(hashSet);
    }

    public w(com.bumptech.glide.load.m.w.c<Data> w$c) {
        super();
        this.a = c;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((Uri)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public com.bumptech.glide.load.m.n.a b(Object object, int i2, int i3, h h4) {
        return c((Uri)object, i2, i3, h4);
    }

    public com.bumptech.glide.load.m.n.a<Data> c(Uri uri, int i2, int i3, h h4) {
        d obj3 = new d(uri);
        n.a obj2 = new n.a(obj3, this.a.a(uri));
        return obj2;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(Uri uri) {
        return w.b.contains(uri.getScheme());
    }
}
