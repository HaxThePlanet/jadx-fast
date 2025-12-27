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

/* compiled from: BitmapLoader.java */
/* loaded from: classes2.dex */
public class a {

    class c implements Callable<Bitmap> {

        final /* synthetic */ ImageView a;
        final /* synthetic */ Uri b;
        c(ImageView imageView, Uri uri) {
            this.a = imageView;
            this.b = uri;
            super();
        }

        public Bitmap a() {
            return a.b(this.a.getContext(), this.b);
        }
    }

    class a implements a.d {

        final /* synthetic */ Uri a;
        a(Uri uri) {
            this.a = uri;
            super();
        }

        public void a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Error while loading image: ";
            String uri2 = this.a.toString();
            str = str2 + uri2;
            j0.d("BitmapLoader", str, th);
        }
    }

    class b implements a.e<Bitmap> {

        final /* synthetic */ ImageView a;
        b(ImageView imageView) {
            this.a = imageView;
            super();
        }

        public void a(Bitmap bitmap) {
            if (u.Q(this.a)) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }
    static boolean a(Uri uri, File file) {
        Throwable uri2;
        try {
            Object instrument = FirebasePerfUrlConnection.instrument(new URL(uri.toString()).openConnection());
        } catch (Throwable th) {
            uri2 = uri;
        }
        try {
            instrument.setConnectTimeout(3000);
            boolean z = true;
            instrument.setUseCaches(z);
            final InputStream inputStream = instrument.getInputStream();
        } catch (Throwable th) {
        }
        try {
        } catch (Throwable th) {
            uri2 = th;
        }
        int i = 200;
        final int i3 = 0;
        if (instrument.getResponseCode() != 200 && inputStream != null) {
            inputStream.close();
            if (instrument != null) {
                instrument.disconnect();
            }
            return false;
        }
        if (inputStream != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(th);
            } catch (Throwable th) {
                uri2 = th;
            }
            try {
                byte[] bArr = new byte[2048];
                int bytesRead = inputStream.read(bArr);
                i = -1;
                fileOutputStream.write(bArr, i3, bytesRead);
            } catch (Throwable th) {
            }
            if (inputStream != null) {
                inputStream.close();
            }
            fileOutputStream.close();
            if (instrument != null) {
                instrument.disconnect();
            }
            return true;
        }
        if (inputStream != null) {
            inputStream.close();
        }
        if (instrument != null) {
            instrument.disconnect();
        }
        return false;
    }

    static Bitmap b(Context context, Uri uri) throws java.io.FileNotFoundException, java.io.IOException {
        File tempFile = File.createTempFile("itbl_", ".temp", context.getCacheDir());
        if (a.a(uri, tempFile) == null) {
            throw new RuntimeException("Failed to download image file");
        } else {
            return BitmapFactory.decodeFile(tempFile.getAbsolutePath());
        }
    }

    public static void c(ImageView imageView, Uri uri) {
        if (uri != null && uri.getPath() != null) {
            a aVar = a.i(new a.c(imageView, uri));
            aVar.h(new a.b(imageView));
            aVar.g(new a.a(uri));
            return;
        }
        j0.a("BitmapLoader", "Empty url for Thumbnail in inbox");
    }
}
