package com.iterable.iterableapi.j1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.iterable.iterableapi.j0;
import com.iterable.iterableapi.k1.a;
import com.iterable.iterableapi.k1.a.d;
import com.iterable.iterableapi.k1.a.e;
import d.h.l.u;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class a {

    class c implements Callable<Bitmap> {

        final ImageView a;
        final Uri b;
        c(ImageView imageView, Uri uri2) {
            this.a = imageView;
            this.b = uri2;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Bitmap a() {
            return a.b(this.a.getContext(), this.b);
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class a implements a.d {

        final Uri a;
        a(Uri uri) {
            this.a = uri;
            super();
        }

        @Override // com.iterable.iterableapi.k1.a$d
        public void a(Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error while loading image: ");
            stringBuilder.append(this.a.toString());
            j0.d("BitmapLoader", stringBuilder.toString(), throwable);
        }
    }

    class b implements a.e<Bitmap> {

        final ImageView a;
        b(ImageView imageView) {
            this.a = imageView;
            super();
        }

        @Override // com.iterable.iterableapi.k1.a$e
        public void a(Bitmap bitmap) {
            boolean z;
            if (u.Q(this.a)) {
                this.a.setImageBitmap(bitmap);
            }
        }

        @Override // com.iterable.iterableapi.k1.a$e
        public void onSuccess(Object object) {
            a((Bitmap)object);
        }
    }
    static boolean a(Uri uri, File file2) {
        Throwable th3;
        Throwable th2;
        int i;
        File obj7;
        URL url = new URL(uri.toString());
        int obj6 = 0;
        Object instrument = FirebasePerfUrlConnection.instrument(url.openConnection());
        (HttpURLConnection)(URLConnection)instrument.setConnectTimeout(3000);
        int i3 = 1;
        instrument.setUseCaches(i3);
        final InputStream inputStream = instrument.getInputStream();
        final int i4 = 0;
        if (instrument.getResponseCode() != 200 && inputStream != null) {
            if (inputStream != null) {
                inputStream.close();
            }
            if (instrument != null) {
                instrument.disconnect();
            }
            return i4;
        }
        if (inputStream != null) {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            obj6 = new byte[2048];
            obj7 = inputStream.read(obj6);
            while (obj7 != -1) {
                fileOutputStream.write(obj6, i4, obj7);
                obj7 = inputStream.read(obj6);
            }
            try {
                if (inputStream != null) {
                }
                inputStream.close();
                fileOutputStream.close();
                if (instrument != null) {
                }
                instrument.disconnect();
                return i3;
                if (inputStream != null) {
                }
                inputStream.close();
                if (instrument != null) {
                }
                instrument.disconnect();
                return i4;
                th2 = uri;
            } catch (Throwable th) {
            }
            if (th3 != null) {
                th3.close();
            }
            if (th2 != null) {
                th2.close();
            }
            if (th == null) {
            } else {
                th.disconnect();
            }
            throw uri;
        }
    }

    static Bitmap b(Context context, Uri uri2) {
        File obj2 = File.createTempFile("itbl_", ".temp", context.getCacheDir());
        if (!a.a(uri2, obj2)) {
        } else {
            return BitmapFactory.decodeFile(obj2.getAbsolutePath());
        }
        obj2 = new RuntimeException("Failed to download image file");
        throw obj2;
    }

    public static void c(ImageView imageView, Uri uri2) {
        String empty;
        if (uri2 != null && uri2.getPath() != null && uri2.getPath().isEmpty()) {
            if (uri2.getPath() != null) {
                if (uri2.getPath().isEmpty()) {
                }
                a.c cVar = new a.c(imageView, uri2);
                a aVar = a.i(cVar);
                a.b bVar = new a.b(imageView);
                aVar.h(bVar);
                a.a obj2 = new a.a(uri2);
                aVar.g(obj2);
            }
        }
        j0.a("BitmapLoader", "Empty url for Thumbnail in inbox");
    }
}
