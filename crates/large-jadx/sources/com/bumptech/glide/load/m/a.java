package com.bumptech.glide.load.m;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.data.m;
import java.io.InputStream;
import java.util.List;

/* compiled from: AssetUriLoader.java */
/* loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    private static final int c = 22;
    private final AssetManager a;
    private final a.a<Data> b;

    public interface a<Data> {
        com.bumptech.glide.load.data.d<Data> a(AssetManager assetManager, String str);
    }

    public static class b implements o<Uri, AssetFileDescriptor>, a.a<AssetFileDescriptor> {

        private final AssetManager a;
        public b(AssetManager assetManager) {
            super();
            this.a = assetManager;
        }

        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }

        public n<Uri, AssetFileDescriptor> b(r rVar) {
            return new a(this.a, this);
        }
    }

    public static class c implements o<Uri, InputStream>, a.a<InputStream> {

        private final AssetManager a;
        public c(AssetManager assetManager) {
            super();
            this.a = assetManager;
        }

        public com.bumptech.glide.load.data.d<InputStream> a(AssetManager assetManager, String str) {
            return new m(assetManager, str);
        }

        public n<Uri, InputStream> b(r rVar) {
            return new a(this.a, this);
        }
    }
    public a(AssetManager assetManager, a.a<Data> aVar) {
        super();
        this.a = assetManager;
        this.b = aVar;
    }

    public n.a<Data> c(Uri uri, int i, int i2, com.bumptech.glide.load.h hVar) {
        return new n.a(new d(uri), this.b.a(this.a, uri.toString().substring(a.c)));
    }

    public boolean d(Uri uri) {
        boolean z = false;
        if ("file".equals(uri.getScheme()) != null) {
            if (!uri.getPathSegments().isEmpty()) {
                if ("android_asset".equals(uri.getPathSegments().get(0))) {
                    int i2 = 1;
                }
            }
        }
        return z;
    }

}
