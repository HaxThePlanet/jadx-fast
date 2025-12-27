package com.bumptech.glide.load.data.o;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.z.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
class e {

    private static final a f = new a();
    private final a a;
    private final d b;
    private final b c;
    private final ContentResolver d;
    private final List<ImageHeaderParser> e;

    e(List<ImageHeaderParser> list, d dVar, b bVar, ContentResolver contentResolver) {
        this(list, e.f, dVar, bVar, contentResolver);
    }

    private String b(Uri uri) {
        Object obj;
        Object obj2;
        Throwable th;
        int stringBuilder;
        String str3;
        try {
            Cursor cursor = this.b.a(uri);
        } catch (java.lang.SecurityException se) {
        } catch (Throwable th1) {
            obj = obj2;
        }
        if (this.b != null && this.b.moveToFirst()) {
            if (this.b != null) {
                cursor.close();
            }
            return cursor.getString(0);
        }
        if (this.b != null) {
            cursor.close();
        }
        return null;
    }

    private boolean c(File file) {
        boolean z = false;
        long l;
        boolean z2 = false;
        if (this.a.a(file) != null) {
            long l2 = 0L;
            l = this.a.c(file);
            file = l2 < l ? 1 : 0;
        }
        return (l2 < l ? 1 : 0);
    }

    int a(Uri uri) {
        Throwable th;
        int stringBuilder;
        String str3;
        try {
            InputStream inputStream = this.d.openInputStream(uri);
        } catch (java.io.IOException unused) {
            return e.b(this.e, inputStream, this.c);
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused) {
                return i2;
            }
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String str2 = b(uri);
        final int i = 0;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = this.a.b(str2);
        if (c(file) == null) {
            return i;
        }
        try {
        } catch (java.lang.NullPointerException npe) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "NPE opening uri: ";
            uri = " -> ";
            uri = str3 + uri + uri + str;
            uri = new FileNotFoundException(uri).initCause(npe);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) uri;
        }
        return this.d.openInputStream(Uri.fromFile(file));
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, b bVar, ContentResolver contentResolver) {
        super();
        this.a = aVar;
        this.b = dVar;
        this.c = bVar;
        this.d = contentResolver;
        this.e = list;
    }
}
