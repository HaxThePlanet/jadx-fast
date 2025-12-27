package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* compiled from: BitmapCroppingWorkerTask.java */
/* loaded from: classes2.dex */
final class a extends AsyncTask<Void, Void, a.a> {

    private final WeakReference<CropImageView> a;
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
    private final CropImageView.j p;
    private final Uri q;
    private final Bitmap.CompressFormat r;
    private final int s;

    static final class a {

        public final Bitmap a;
        public final Uri b;
        final Exception c;
        final int d;
        a(Bitmap bitmap, int i) {
            super();
            this.a = bitmap;
            final Uri uri = null;
            this.b = uri;
            this.c = uri;
            this.d = i;
        }

        a(Uri uri, int i) {
            super();
            final Bitmap bitmap = null;
            this.a = bitmap;
            this.b = uri;
            this.c = bitmap;
            this.d = i;
        }

        a(Exception exc, boolean z) {
            super();
            final Bitmap bitmap = null;
            this.a = bitmap;
            this.b = bitmap;
            this.c = exc;
            this.d = 1;
        }
    }
    a(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, int i4, int i5, boolean z2, boolean z3, CropImageView.j jVar, Uri uri, Bitmap.CompressFormat compressFormat, int i6) {
        final Object cropImageView2 = this;
        super();
        cropImageView2.a = new WeakReference(cropImageView);
        cropImageView2.d = cropImageView.getContext();
        cropImageView2.b = bitmap;
        cropImageView2.e = fArr;
        cropImageView2.c = null;
        cropImageView2.f = i;
        cropImageView2.i = z;
        cropImageView2.j = i2;
        cropImageView2.k = i3;
        cropImageView2.l = i4;
        cropImageView2.m = i5;
        cropImageView2.n = z2;
        cropImageView2.o = z3;
        cropImageView2.p = jVar;
        cropImageView2.q = uri;
        cropImageView2.r = compressFormat;
        cropImageView2.s = i6;
        i2 = 0;
        cropImageView2.g = i2;
        cropImageView2.h = i2;
    }

    @Override // android.os.AsyncTask
    protected a.a a(Void... voidArr) {
        com.theartofdev.edmodo.cropper.c.a aVar;
        final Object voidArr2 = this;
        try {
            Bitmap bitmap2 = null;
            if (voidArr2.c != null) {
                aVar = c.d(voidArr2.d, voidArr2.c, voidArr2.e, voidArr2.f, voidArr2.g, voidArr2.h, voidArr2.i, voidArr2.j, voidArr2.k, voidArr2.l, voidArr2.m, voidArr2.n, z);
                Bitmap bitmap4 = c.y(aVar.a, voidArr2.l, voidArr2.m, voidArr2.p);
                if (voidArr2.q == null) {
                    return new a.a(bitmap4, aVar.b);
                }
                c.C(voidArr2.d, bitmap4, voidArr2.q, voidArr2.r, voidArr2.s);
                if (bitmap4 != null) {
                    bitmap4.recycle();
                }
                return new a.a(voidArr2.q, aVar.b);
            } else {
                if (voidArr2.b != null) {
                    aVar = c.g(bitmap, voidArr2.e, voidArr2.f, voidArr2.i, voidArr2.j, voidArr2.k, voidArr2.n, voidArr2.o);
                }
            }
        } catch (Exception e) {
        }
        return bitmap2;
    }

    @Override // android.os.AsyncTask
    protected void b(a.a aVar) {
        int i = 0;
        boolean cancelled;
        if (aVar != null) {
            i = 0;
            if (!isCancelled() && obj != null) {
                i = 1;
                obj.m(aVar);
            }
            if (i == 0 && aVar.a != null) {
                aVar.a.recycle();
            }
        }
    }

    a(CropImageView cropImageView, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, CropImageView.j jVar, Uri uri2, Bitmap.CompressFormat compressFormat, int i8) {
        final Object cropImageView2 = this;
        super();
        cropImageView2.a = new WeakReference(cropImageView);
        cropImageView2.d = cropImageView.getContext();
        cropImageView2.c = uri;
        cropImageView2.e = fArr;
        cropImageView2.f = i;
        cropImageView2.i = z;
        cropImageView2.j = i4;
        cropImageView2.k = i5;
        cropImageView2.g = i2;
        cropImageView2.h = i3;
        cropImageView2.l = i6;
        cropImageView2.m = i7;
        cropImageView2.n = z2;
        cropImageView2.o = z3;
        cropImageView2.p = jVar;
        cropImageView2.q = uri2;
        cropImageView2.r = compressFormat;
        cropImageView2.s = i8;
        cropImageView2.b = null;
    }
}
