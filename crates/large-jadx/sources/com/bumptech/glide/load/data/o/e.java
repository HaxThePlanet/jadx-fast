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

/* loaded from: classes.dex */
class e {

    private static final com.bumptech.glide.load.data.o.a f;
    private final com.bumptech.glide.load.data.o.a a;
    private final com.bumptech.glide.load.data.o.d b;
    private final b c;
    private final ContentResolver d;
    private final List<ImageHeaderParser> e;
    static {
        a aVar = new a();
        e.f = aVar;
    }

    e(List<ImageHeaderParser> list, com.bumptech.glide.load.data.o.a a2, com.bumptech.glide.load.data.o.d d3, b b4, ContentResolver contentResolver5) {
        super();
        this.a = a2;
        this.b = d3;
        this.c = b4;
        this.d = contentResolver5;
        this.e = list;
    }

    e(List<ImageHeaderParser> list, com.bumptech.glide.load.data.o.d d2, b b3, ContentResolver contentResolver4) {
        super(list, e.f, d2, b3, contentResolver4);
    }

    private String b(Uri uri) {
        Object obj;
        Object obj2;
        Throwable moveToFirst;
        int stringBuilder;
        String str;
        final String str2 = "ThumbStreamOpener";
        Cursor cursor = this.b.a(uri);
        if (cursor != null && cursor.moveToFirst() && cursor != null) {
            if (cursor.moveToFirst()) {
                if (cursor != null) {
                    try {
                        cursor.close();
                        return cursor.getString(0);
                        if (cursor != null) {
                        }
                        cursor.close();
                        return null;
                    } catch (java.lang.SecurityException se) {
                    } catch (Throwable th1) {
                    }
                    try {
                        stringBuilder = 3;
                        stringBuilder = Log.isLoggable(obj0, stringBuilder);
                        if (stringBuilder != null) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to query for thumbnail for Uri: ");
                        stringBuilder.append(uri);
                        uri = stringBuilder.toString();
                        Log.d(obj0, uri, moveToFirst);
                        if (obj2 != null) {
                        }
                        obj2.close();
                        return obj;
                        obj = obj2;
                        if (obj == null) {
                        } else {
                        }
                        obj.close();
                        throw uri;
                    }
                }
            }
        }
    }

    private boolean c(File file) {
        boolean z;
        long l;
        File obj5;
        if (this.a.a(file) != null && Long.compare(z, l) < 0) {
            obj5 = Long.compare(z, l) < 0 ? 1 : 0;
        } else {
        }
        return obj5;
    }

    int a(Uri uri) {
        Throwable th;
        int stringBuilder;
        String str;
        final String str2 = "ThumbStreamOpener";
        int i = 0;
        InputStream inputStream = this.d.openInputStream(uri);
        if (inputStream != null) {
            inputStream.close();
        }
        return e.b(this.e, inputStream, this.c);
    }

    public InputStream d(Uri uri) {
        String str = b(uri);
        final int i = 0;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        File file = this.a.b(str);
        if (c(file) == null) {
            return i;
        }
        return this.d.openInputStream(Uri.fromFile(file));
    }
}
