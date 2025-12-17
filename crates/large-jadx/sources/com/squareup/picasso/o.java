package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import l.q;

/* loaded from: classes2.dex */
class o extends com.squareup.picasso.g {

    private static final String[] b;

    static enum a {

        MICRO(3, 96, 96);

        final int androidKind;
        final int height;
        final int width;
    }
    static {
        o.b = /* result */;
    }

    o(Context context) {
        super(context);
    }

    static int k(ContentResolver contentResolver, Uri uri2) {
        boolean obj8;
        final int i = 0;
        int i2 = 0;
        Cursor query = contentResolver.query(uri2, o.b, 0, 0, 0);
        if (query != null) {
            if (!query.moveToFirst()) {
                try {
                    if (query != null) {
                    }
                    query.close();
                    return query.getInt(i);
                    if (query != null) {
                    }
                    query.close();
                    return i;
                    if (obj1 == null) {
                    } else {
                    }
                    obj1.close();
                    throw contentResolver;
                    if (obj1 != null) {
                    }
                    obj1.close();
                    return obj0;
                }
            } else {
            }
        }
    }

    static com.squareup.picasso.o.a l(int i, int i2) {
        int height;
        int obj2;
        com.squareup.picasso.o.a mICRO = o.a.MICRO;
        if (i <= mICRO.width && i2 <= mICRO.height) {
            if (i2 <= mICRO.height) {
                return mICRO;
            }
        }
        com.squareup.picasso.o.a mINI = o.a.MINI;
        if (i <= mINI.width && i2 <= mINI.height) {
            if (i2 <= mINI.height) {
                return mINI;
            }
        }
        return o.a.FULL;
    }

    @Override // com.squareup.picasso.g
    public boolean c(com.squareup.picasso.w w) {
        boolean equals;
        Uri obj3;
        obj3 = w.d;
        if ("content".equals(obj3.getScheme()) && "media".equals(obj3.getAuthority())) {
            obj3 = "media".equals(obj3.getAuthority()) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    @Override // com.squareup.picasso.g
    public com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2) {
        String startsWith;
        int fULL;
        android.graphics.Bitmap thumbnail;
        int androidKind;
        String str;
        int width;
        int height;
        android.graphics.BitmapFactory.Options factory;
        com.squareup.picasso.w wVar;
        int i3;
        int i;
        com.squareup.picasso.o.a aVar;
        long l;
        final Object obj = w;
        final ContentResolver contentResolver = obj2.a.getContentResolver();
        final int i6 = o.k(contentResolver, obj.d);
        startsWith = contentResolver.getType(obj.d);
        i3 = 1;
        if (startsWith != null && startsWith.startsWith("video/")) {
            i = startsWith.startsWith("video/") ? i3 : startsWith;
        } else {
        }
        final int i7 = 0;
        aVar = o.l(obj.h, obj.i);
        if (w.c() && i == 0 && aVar == o.a.FULL) {
            aVar = o.l(obj.h, obj.i);
            if (i == 0) {
                if (aVar == o.a.FULL) {
                    y.a aVar2 = new y.a(i7, q.l(j(w)), t.e.DISK, i6);
                    return aVar2;
                }
            }
            l = ContentUris.parseId(obj.d);
            android.graphics.BitmapFactory.Options factory2 = y.d(w);
            factory2.inJustDecodeBounds = i3;
            i3 = factory2;
            y.a(obj.h, obj.i, aVar.width, aVar.height, factory2, w);
            if (i != 0) {
                androidKind = aVar == o.a.FULL ? 1 : aVar.androidKind;
                thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, l, obj15, androidKind);
            } else {
                thumbnail = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, l, obj15, aVar.androidKind);
            }
            if (thumbnail != null) {
                y.a aVar3 = new y.a(thumbnail, i7, t.e.DISK, i6);
                return aVar3;
            }
        }
        y.a aVar4 = new y.a(i7, q.l(j(w)), t.e.DISK, i6);
        return aVar4;
    }
}
