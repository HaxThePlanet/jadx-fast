package com.bumptech.glide.load.m;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.data.i;
import com.bumptech.glide.load.data.n;
import com.bumptech.glide.load.h;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {

    private static final Set<String> b;
    private final w.c<Data> a;

    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri uri);
    }

    public static final class a implements o<Uri, AssetFileDescriptor>, w.c<AssetFileDescriptor> {

        private final ContentResolver a;
        public a(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri uri) {
            return new a(this.a, uri);
        }

        public n<Uri, AssetFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, w.c<ParcelFileDescriptor> {

        private final ContentResolver a;
        public b(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri uri) {
            return new i(this.a, uri);
        }

        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    public static class d implements o<Uri, InputStream>, w.c<InputStream> {

        private final ContentResolver a;
        public d(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        public com.bumptech.glide.load.data.d<InputStream> a(Uri uri) {
            return new n(this.a, uri);
        }

        public n<Uri, InputStream> b(r rVar) {
            return new w(this);
        }
    }
    static {
        w.b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "file", "android.resource", "content" })));
    }

    public w(w.c<Data> cVar) {
        super();
        this.a = cVar;
    }

    public n.a<Data> c(Uri uri, int i, int i2, h hVar) {
        return new n.a(new d(uri), this.a.a(uri));
    }

    public boolean d(Uri uri) {
        return w.b.contains(uri.getScheme());
    }
}
