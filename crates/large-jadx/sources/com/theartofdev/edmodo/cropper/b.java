package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* compiled from: BitmapLoadingWorkerTask.java */
/* loaded from: classes2.dex */
final class b extends AsyncTask<Void, Void, b.a> {

    private final WeakReference<CropImageView> a = new WeakReference<>();
    private final Uri b;
    private final Context c;
    private final int d;
    private final int e;

    public static final class a {

        public final Uri a;
        public final Bitmap b;
        public final int c;
        public final int d;
        public final Exception e;
        a(Uri uri, Bitmap bitmap, int i, int i2) {
            super();
            this.a = uri;
            this.b = bitmap;
            this.c = i;
            this.d = i2;
            this.e = null;
        }

        a(Uri uri, Exception exc) {
            super();
            this.a = uri;
            this.b = null;
            int i2 = 0;
            this.c = i2;
            this.d = i2;
            this.e = exc;
        }
    }
    public b(CropImageView cropImageView, Uri uri) {
        double d = 4607182418800017408L;
        super();
        this.b = uri;
        WeakReference weakReference = new WeakReference(cropImageView);
        this.c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        float f = 1f;
        d = displayMetrics.density > f ? (double)f2 : 4607182418800017408L;
        this.d = (int)(double)displayMetrics.widthPixels * d;
        this.e = (int)(double)displayMetrics.heightPixels * d;
    }

    @Override // android.os.AsyncTask
    protected b.a a(Void... voidArr) {
        try {
            com.theartofdev.edmodo.cropper.c.a aVar3 = c.l(this.c, this.b, this.d, this.e);
            com.theartofdev.edmodo.cropper.c.b bVar = c.A(aVar3.a, this.c, this.b);
        } catch (Exception e) {
            return new b.a(this.b, e);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public Uri b() {
        return this.b;
    }

    @Override // android.os.AsyncTask
    protected void c(b.a aVar) {
        int i = 0;
        boolean cancelled;
        if (aVar != null) {
            i = 0;
            if (!isCancelled() && obj != null) {
                i = 1;
                obj.n(aVar);
            }
            if (i == 0 && aVar.b != null) {
                aVar.b.recycle();
            }
        }
    }
}
