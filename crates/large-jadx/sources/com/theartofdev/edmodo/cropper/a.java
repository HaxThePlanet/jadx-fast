package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class a extends AsyncTask<Void, Void, com.theartofdev.edmodo.cropper.a.a> {

    private final WeakReference<com.theartofdev.edmodo.cropper.CropImageView> a;
    private final Bitmap b;
    private final Uri c;
    private final Context d;
    private final float[] e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final boolean n;
    private final boolean o;
    private final com.theartofdev.edmodo.cropper.CropImageView.j p;
    private final Uri q;
    private final Bitmap.CompressFormat r;
    private final int s;

    static final class a {

        public final Bitmap a;
        public final Uri b;
        final Exception c;
        final int d;
        a(Bitmap bitmap, int i2) {
            super();
            this.a = bitmap;
            final int obj1 = 0;
            this.b = obj1;
            this.c = obj1;
            this.d = i2;
        }

        a(Uri uri, int i2) {
            super();
            final int i = 0;
            this.a = i;
            this.b = uri;
            this.c = i;
            this.d = i2;
        }

        a(Exception exception, boolean z2) {
            super();
            final int obj2 = 0;
            this.a = obj2;
            this.b = obj2;
            this.c = exception;
            this.d = 1;
        }
    }
    a(com.theartofdev.edmodo.cropper.CropImageView cropImageView, Bitmap bitmap2, float[] f3Arr3, int i4, boolean z5, int i6, int i7, int i8, int i9, boolean z10, boolean z11, com.theartofdev.edmodo.cropper.CropImageView.j cropImageView$j12, Uri uri13, Bitmap.CompressFormat bitmap$CompressFormat14, int i15) {
        final Object obj = this;
        super();
        final Object obj2 = cropImageView;
        WeakReference weakReference = new WeakReference(cropImageView);
        obj.a = weakReference;
        obj.d = cropImageView.getContext();
        obj.b = bitmap2;
        obj.e = f3Arr3;
        obj.c = 0;
        obj.f = i4;
        obj.i = z5;
        obj.j = i6;
        obj.k = i7;
        obj.l = i8;
        obj.m = i9;
        obj.n = z10;
        obj.o = z11;
        obj.p = j12;
        obj.q = uri13;
        obj.r = compressFormat14;
        obj.s = i15;
        int i13 = 0;
        obj.g = i13;
        obj.h = i13;
    }

    a(com.theartofdev.edmodo.cropper.CropImageView cropImageView, Uri uri2, float[] f3Arr3, int i4, int i5, int i6, boolean z7, int i8, int i9, int i10, int i11, boolean z12, boolean z13, com.theartofdev.edmodo.cropper.CropImageView.j cropImageView$j14, Uri uri15, Bitmap.CompressFormat bitmap$CompressFormat16, int i17) {
        final Object obj = this;
        super();
        final Object obj2 = cropImageView;
        WeakReference weakReference = new WeakReference(cropImageView);
        obj.a = weakReference;
        obj.d = cropImageView.getContext();
        obj.c = uri2;
        obj.e = f3Arr3;
        obj.f = i4;
        obj.i = z7;
        obj.j = i8;
        obj.k = i9;
        obj.g = i5;
        obj.h = i6;
        obj.l = i10;
        obj.m = i11;
        obj.n = z12;
        obj.o = z13;
        obj.p = j14;
        obj.q = uri15;
        obj.r = compressFormat16;
        obj.s = i17;
        obj.b = 0;
    }

    @Override // android.os.AsyncTask
    protected com.theartofdev.edmodo.cropper.a.a a(Void... voidArr) {
        com.theartofdev.edmodo.cropper.c.a aVar;
        int i;
        Bitmap i4;
        float[] fArr;
        int uri;
        boolean z;
        int i5;
        int i3;
        boolean z4;
        boolean z3;
        int i6;
        int i8;
        int i7;
        int i2;
        boolean z5;
        boolean z2;
        final Object obj = this;
        i4 = 0;
        if (!isCancelled()) {
            uri = obj.c;
            if (uri != null) {
                aVar = c.d(obj.d, uri, obj.e, obj.f, obj.g, obj.h, obj.i, obj.j, obj.k, obj.l, obj.m, obj.n, obj.o);
                Bitmap bitmap3 = c.y(aVar.a, obj.l, obj.m, obj.p);
                Uri uri3 = obj.q;
                if (uri3 == null) {
                    a.a aVar5 = new a.a(bitmap3, aVar.b);
                    return aVar5;
                }
                c.C(obj.d, bitmap3, uri3, obj.r, obj.s);
                if (bitmap3 != null) {
                    bitmap3.recycle();
                }
                a.a aVar4 = new a.a(obj.q, aVar.b);
                return aVar4;
            } else {
                try {
                    Bitmap bitmap = obj.b;
                    if (bitmap != null) {
                    }
                    aVar = c.g(bitmap, obj.e, obj.f, obj.i, obj.j, obj.k, obj.n, obj.o);
                    bitmap3 = c.y(aVar.a, obj.l, obj.m, obj.p);
                    uri3 = obj.q;
                    if (uri3 == null) {
                    }
                    aVar5 = new a.a(bitmap3, aVar.b);
                    return aVar5;
                    c.C(obj.d, bitmap3, uri3, obj.r, obj.s);
                    if (bitmap3 != null) {
                    }
                    bitmap3.recycle();
                    aVar4 = new a.a(obj.q, aVar.b);
                    return aVar4;
                    a.a aVar2 = new a.a(i4, 1);
                    return aVar2;
                    return i4;
                    if (obj1.q != null) {
                    } else {
                    }
                    a.a aVar3 = new a.a(th, 0);
                    return aVar3;
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void b(com.theartofdev.edmodo.cropper.a.a a$a) {
        int i;
        boolean cancelled;
        Object obj3;
        i = 0;
        cancelled = this.a.get();
        if (a != null && !isCancelled() && (CropImageView)cancelled != null) {
            i = 0;
            if (!isCancelled()) {
                cancelled = this.a.get();
                if ((CropImageView)(CropImageView)cancelled != null) {
                    i = 1;
                    (CropImageView)(CropImageView)cancelled.m(a);
                }
            }
            obj3 = a.a;
            if (i == 0 && obj3 != null) {
                obj3 = a.a;
                if (obj3 != null) {
                    obj3.recycle();
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected Object doInBackground(Object[] objectArr) {
        return a((Void[])objectArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(Object object) {
        b((a.a)object);
    }
}
