package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import l.q;

/* compiled from: MediaStoreRequestHandler.java */
/* loaded from: classes2.dex */
class o extends g {

    private static final String[] b;

    enum a {

        MICRO(3, 96, 96);

        final int androidKind;
        final int height;
        final int width;
    }
    static {
        o.b = new String[] { "orientation" };
    }

    o(Context context) {
        super(context);
    }

    static int k(ContentResolver contentResolver, Uri uri) {
        final int i2 = 0;
        try {
            Cursor query = contentResolver.query(uri, o.b, null, null, null);
        } catch (Throwable th) {
        } catch (RuntimeException unused) {
        }
        if (query != null) {
            query.close();
        }
        return i2;
    }

    static o.a l(int i, int i2) {
        com.squareup.picasso.o.a mICRO2 = o.a.MICRO;
        if (i <= mICRO2.width && i2 <= o.a.MICRO.height) {
            return o.a.MICRO;
        }
        com.squareup.picasso.o.a mINI2 = o.a.MINI;
        if (o.a.MINI.height <= mINI2.width && i2 <= o.a.MINI.height) {
            return o.a.MINI;
        }
        return o.a.FULL;
    }

    @Override // com.squareup.picasso.g
    public boolean c(w wVar) {
        boolean equals;
        boolean z = false;
        if ("content".equals(wVar.d.getScheme())) {
            wVar = "media".equals(wVar.d.getAuthority()) ? 1 : 0;
        }
        return ("media".equals(wVar.d.getAuthority()) ? 1 : 0);
    }

    @Override // com.squareup.picasso.g
    public y.a f(w wVar, int i) {
        android.graphics.Bitmap thumbnail;
        int androidKind2 = 1;
        String str;
        final com.squareup.picasso.w wVar2 = wVar;
        final ContentResolver contentResolver = this.a.getContentResolver();
        final int i7 = o.k(contentResolver, wVar2.d);
        String type = contentResolver.getType(wVar2.d);
        boolean z2 = true;
        if (type != null) {
            str = "video/";
            i = type.startsWith(str) ? z2 : i;
        }
        final android.graphics.Bitmap bitmap = null;
        if (wVar.c()) {
            com.squareup.picasso.o.a aVar = o.l(wVar2.h, wVar2.i);
            if (i == 0 && aVar == o.a.FULL) {
                return new y.a(bitmap, q.l(j(wVar)), t.e.DISK, i7);
            }
            long l = ContentUris.parseId(wVar2.d);
            BitmapFactory.Options options = y.d(wVar);
            options.inJustDecodeBounds = z2;
            y.a(wVar2.h, wVar2.i, aVar.width, aVar.height, options, wVar);
            if (i != 0) {
                int r0 = aVar == o.a.FULL ? 1 : aVar.androidKind;
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, l, (aVar == o.a.FULL ? 1 : aVar.androidKind), options);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, l, aVar.androidKind, options);
            }
            if (wVar2.d != null) {
                return new y.a(thumbnail, bitmap, t.e.DISK, i7);
            }
        }
        return new y.a(bitmap, q.l(j(wVar)), t.e.DISK, i7);
    }
}
