package com.bumptech.glide.load.m;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.h;
import com.bumptech.glide.load.data.m;
import com.bumptech.glide.load.h;
import com.bumptech.glide.s.d;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public class a<Data>  implements com.bumptech.glide.load.m.n<Uri, Data> {

    private static final int c = 22;
    private final AssetManager a;
    private final com.bumptech.glide.load.m.a.a<Data> b;

    public interface a {
        public abstract d<Data> a(AssetManager assetManager, String string2);
    }

    public static class b implements com.bumptech.glide.load.m.o<Uri, AssetFileDescriptor>, com.bumptech.glide.load.m.a.a<AssetFileDescriptor> {

        private final AssetManager a;
        public b(AssetManager assetManager) {
            super();
            this.a = assetManager;
        }

        public d<AssetFileDescriptor> a(AssetManager assetManager, String string2) {
            h hVar = new h(assetManager, string2);
            return hVar;
        }

        public com.bumptech.glide.load.m.n<Uri, AssetFileDescriptor> b(com.bumptech.glide.load.m.r r) {
            a obj2 = new a(this.a, this);
            return obj2;
        }
    }

    public static class c implements com.bumptech.glide.load.m.o<Uri, InputStream>, com.bumptech.glide.load.m.a.a<InputStream> {

        private final AssetManager a;
        public c(AssetManager assetManager) {
            super();
            this.a = assetManager;
        }

        public d<InputStream> a(AssetManager assetManager, String string2) {
            m mVar = new m(assetManager, string2);
            return mVar;
        }

        public com.bumptech.glide.load.m.n<Uri, InputStream> b(com.bumptech.glide.load.m.r r) {
            a obj2 = new a(this.a, this);
            return obj2;
        }
    }
    static {
    }

    public a(AssetManager assetManager, com.bumptech.glide.load.m.a.a<Data> a$a2) {
        super();
        this.a = assetManager;
        this.b = a2;
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
        d obj5 = new d(uri);
        n.a obj4 = new n.a(obj5, this.b.a(this.a, uri.toString().substring(a.c)));
        return obj4;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(Uri uri) {
        boolean equals;
        int i;
        boolean obj3;
        if ("file".equals(uri.getScheme()) != null && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0))) {
            if (!uri.getPathSegments().isEmpty()) {
                if ("android_asset".equals(uri.getPathSegments().get(i))) {
                    i = 1;
                }
            }
        }
        return i;
    }
}
