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
import java.io.InputStream;

/* loaded from: classes.dex */
public class c implements d<InputStream> {

    private final Uri a;
    private final com.bumptech.glide.load.data.o.e b;
    private InputStream c;

    static class a implements com.bumptech.glide.load.data.o.d {

        private static final String[] b;
        private final ContentResolver a;
        static {
            c.a.b = /* result */;
        }

        a(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.o.d
        public Cursor a(Uri uri) {
            final String[] strArr2 = new String[1];
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, c.a.b, "kind = 1 AND image_id = ?", strArr2, 0);
        }
    }

    static class b implements com.bumptech.glide.load.data.o.d {

        private static final String[] b;
        private final ContentResolver a;
        static {
            c.b.b = /* result */;
        }

        b(ContentResolver contentResolver) {
            super();
            this.a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.o.d
        public Cursor a(Uri uri) {
            final String[] strArr2 = new String[1];
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, c.b.b, "kind = 1 AND video_id = ?", strArr2, 0);
        }
    }
    c(Uri uri, com.bumptech.glide.load.data.o.e e2) {
        super();
        this.a = uri;
        this.b = e2;
    }

    private static com.bumptech.glide.load.data.o.c c(Context context, Uri uri2, com.bumptech.glide.load.data.o.d d3) {
        e eVar = new e(c.c(context).j().g(), d3, c.c(context).e(), context.getContentResolver());
        c obj3 = new c(uri2, eVar);
        return obj3;
    }

    public static com.bumptech.glide.load.data.o.c f(Context context, Uri uri2) {
        c.a aVar = new c.a(context.getContentResolver());
        return c.c(context, uri2, aVar);
    }

    public static com.bumptech.glide.load.data.o.c g(Context context, Uri uri2) {
        c.b bVar = new c.b(context.getContentResolver());
        return c.c(context, uri2, bVar);
    }

    private InputStream h() {
        Object inputStream;
        int gVar;
        int i;
        Uri uri;
        inputStream = this.b.d(this.a);
        gVar = -1;
        if (inputStream != null) {
            i = this.b.a(this.a);
        } else {
            i = gVar;
        }
        if (i != gVar) {
            gVar = new g(inputStream, i);
            inputStream = gVar;
        }
        return inputStream;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        final InputStream inputStream = this.c;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public a d() {
        return a.LOCAL;
    }

    public void e(h h, d.a<? super InputStream> d$a2) {
        int str2;
        String str;
        InputStream obj3;
        try {
            obj3 = h();
            this.c = obj3;
            a2.f(obj3);
            str2 = 3;
            str = "MediaStoreThumbFetcher";
            str2 = Log.isLoggable(str, str2);
            if (str2 != null) {
            }
            str2 = "Failed to find thumbnail file";
            Log.d(str, str2, h);
            a2.c(h);
        }
    }
}
