package com.bumptech.glide.load.m;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.o.b;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader.java */
/* loaded from: classes.dex */
public final class k implements n<Uri, File> {

    private final Context a;

    public static final class a implements o<Uri, File> {

        private final Context a;
        public a(Context context) {
            super();
            this.a = context;
        }

        public n<Uri, File> b(r rVar) {
            return new k(this.a);
        }
    }

    private static class b implements com.bumptech.glide.load.data.d<File> {

        private static final String[] c;
        private final Context a;
        private final Uri b;
        static {
            k.b.c = new String[] { "_data" };
        }

        b(Context context, Uri uri) {
            super();
            this.a = context;
            this.b = uri;
        }

        public Class<File> a() {
            return File.class;
        }

        public a d() {
            return a.LOCAL;
        }

        public void e(com.bumptech.glide.h hVar, d.a<? super File> aVar) {
            java.lang.CharSequence charSequence = null;
            int i = 0;
            Uri uri;
            Cursor query = this.a.getContentResolver().query(this.b, k.b.c, null, null, null);
            i = 0;
            if (query != null && query.moveToFirst()) {
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                query.close();
            }
            if (TextUtils.isEmpty(charSequence)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Failed to find file path for: ";
                str = str3 + this.b;
                aVar.c(new FileNotFoundException(str));
            } else {
                aVar.f(new File(charSequence));
            }
        }

        public void b() {
        }

        public void cancel() {
        }
    }
    public k(Context context) {
        super();
        this.a = context;
    }

    public n.a<File> c(Uri uri, int i, int i2, com.bumptech.glide.load.h hVar) {
        return new n.a(new d(uri), new k.b(this.a, uri));
    }

    public boolean d(Uri uri) {
        return b.b(uri);
    }
}
