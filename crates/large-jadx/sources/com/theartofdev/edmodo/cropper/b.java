package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
final class b extends AsyncTask<Void, Void, com.theartofdev.edmodo.cropper.b.a> {

    private final WeakReference<com.theartofdev.edmodo.cropper.CropImageView> a;
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
        a(Uri uri, Bitmap bitmap2, int i3, int i4) {
            super();
            this.a = uri;
            this.b = bitmap2;
            this.c = i3;
            this.d = i4;
            this.e = 0;
        }

        a(Uri uri, Exception exception2) {
            super();
            this.a = uri;
            this.b = 0;
            int obj1 = 0;
            this.c = obj1;
            this.d = obj1;
            this.e = exception2;
        }
    }
    public b(com.theartofdev.edmodo.cropper.CropImageView cropImageView, Uri uri2) {
        double d;
        super();
        this.b = uri2;
        WeakReference obj6 = new WeakReference(cropImageView);
        this.a = obj6;
        this.c = cropImageView.getContext();
        android.util.DisplayMetrics obj5 = cropImageView.getResources().getDisplayMetrics();
        obj6 = obj5.density;
        int i = 1065353216;
        d = Float.compare(obj6, i) > 0 ? (double)i2 : 4607182418800017408L;
        this.d = (int)i3;
        this.e = (int)obj5;
    }

    @Override // android.os.AsyncTask
    protected com.theartofdev.edmodo.cropper.b.a a(Void... voidArr) {
        boolean aVar;
        int uri;
        int i;
        boolean obj5;
        try {
            obj5 = c.l(this.c, this.b, this.d, this.e);
            if (!isCancelled() && !isCancelled()) {
            }
            obj5 = c.l(this.c, this.b, this.d, this.e);
            if (!isCancelled()) {
            }
            com.theartofdev.edmodo.cropper.c.b bVar = c.A(obj5.a, this.c, this.b);
            b.a aVar2 = new b.a(this.b, bVar.a, obj5.b, bVar.b);
            return aVar2;
            return null;
            aVar = new b.a(this.b, voidArr);
            return aVar;
        }
    }

    @Override // android.os.AsyncTask
    public Uri b() {
        return this.b;
    }

    @Override // android.os.AsyncTask
    protected void c(com.theartofdev.edmodo.cropper.b.a b$a) {
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
                    (CropImageView)(CropImageView)cancelled.n(a);
                }
            }
            obj3 = a.b;
            if (i == 0 && obj3 != null) {
                obj3 = a.b;
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
        c((b.a)object);
    }
}
