package com.bumptech.glide.load.data.o;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Log;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class c implements d<InputStream> {

    private final Uri a;
    private final e b;
    private InputStream c;

    static class a implements d {

        private static final String[] b;
        private final ContentResolver a;
        static {
            c.a.b = new String[] { "_data" };
        }

        a(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        public Cursor a(Uri uri) {
            final String[] strArr2 = new String[1];
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, c.a.b, "kind = 1 AND image_id = ?", new String[] { uri.getLastPathSegment() }, null);
        }
    }

    static class b implements d {

        private static final String[] b;
        private final ContentResolver a;
        static {
            c.b.b = new String[] { "_data" };
        }

        b(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        public Cursor a(Uri uri) {
            final String[] strArr2 = new String[1];
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, c.b.b, "kind = 1 AND video_id = ?", new String[] { uri.getLastPathSegment() }, null);
        }
    }
    c(Uri uri, e eVar) {
        super();
        this.a = uri;
        this.b = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(c.c(context).j().g(), dVar, c.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c.c(context, uri, new c.a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c.c(context, uri, new c.b(context.getContentResolver()));
    }

    private InputStream h() {
        InputStream inputStream;
        int i;
        inputStream = this.b.d(this.a);
        i = -1;
        if (inputStream != null) {
            i = this.b.a(this.a);
        } else {
        }
        if (this.b != i) {
        }
        return inputStream;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        if (this.c != null) {
            try {
                this.c.close();
            } catch (java.io.IOException unused) {
                return;
            }
        }
    }

    public a d() {
        return a.LOCAL;
    }

    public void e(h hVar, d.a<? super InputStream> aVar) {
        String str2;
        try {
            InputStream inputStream = h();
            this.c = inputStream;
            aVar.f(inputStream);
        } catch (java.io.FileNotFoundException fileNotFound) {
            int str = 3;
            str2 = "MediaStoreThumbFetcher";
            str = Log.isLoggable(str2, str);
        }
    }

    public void cancel() {
    }
}
