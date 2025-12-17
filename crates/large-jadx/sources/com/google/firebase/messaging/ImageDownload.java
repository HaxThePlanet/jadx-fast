package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import f.c.a.d.b.h.l;
import f.c.a.d.b.h.m;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class ImageDownload implements Closeable {

    private volatile InputStream connectionInputStream;
    private j<Bitmap> task;
    private final URL url;
    private ImageDownload(URL uRL) {
        super();
        this.url = uRL;
    }

    private byte[] blockingDownloadBytes() {
        boolean loggable;
        Throwable th;
        long str;
        StringBuilder stringBuilder;
        URLConnection connection = this.url.openConnection();
        final int i2 = 1048576;
        if (connection.getContentLength() > i2) {
        } else {
            InputStream inputStream = connection.getInputStream();
            this.connectionInputStream = inputStream;
            byte[] bArr = l.b(l.a(inputStream, 1048577));
            if (inputStream != null) {
                inputStream.close();
            }
            String str4 = "FirebaseMessaging";
            if (Log.isLoggable(str4, 2)) {
                String valueOf = String.valueOf(this.url);
                stringBuilder = new StringBuilder(length2 += 34);
                stringBuilder.append("Downloaded ");
                stringBuilder.append(bArr.length);
                stringBuilder.append(" bytes from ");
                stringBuilder.append(valueOf);
                Log.v(str4, stringBuilder.toString());
            }
            if (bArr.length > i2) {
            } else {
                return bArr;
            }
            IOException iOException2 = new IOException("Image exceeds max size of 1048576");
            throw iOException2;
        }
        IOException iOException = new IOException("Content-Length exceeds max size of 1048576");
        throw iOException;
    }

    public static com.google.firebase.messaging.ImageDownload create(String string) {
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        URL url = new URL(string);
        ImageDownload imageDownload = new ImageDownload(url);
        return imageDownload;
    }

    @Override // java.io.Closeable
    public Bitmap blockingDownload() {
        boolean loggable;
        int str;
        String valueOf = String.valueOf(this.url);
        String.valueOf(valueOf).length();
        String str3 = "FirebaseMessaging";
        Log.i(str3, "Starting download of: ".concat(String.valueOf(valueOf)));
        byte[] blockingDownloadBytes = blockingDownloadBytes();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(blockingDownloadBytes, 0, blockingDownloadBytes.length);
        if (decodeByteArray == null) {
        } else {
            if (Log.isLoggable(str3, 3)) {
                String valueOf6 = String.valueOf(this.url);
                String.valueOf(valueOf6).length();
                Log.d(str3, "Successfully downloaded image: ".concat(String.valueOf(valueOf6)));
            }
            return decodeByteArray;
        }
        String valueOf4 = String.valueOf(this.url);
        String.valueOf(valueOf4).length();
        IOException iOException = new IOException("Failed to decode image: ".concat(String.valueOf(valueOf4)));
        throw iOException;
    }

    @Override // java.io.Closeable
    public void close() {
        try {
            m.a(this.connectionInputStream);
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", th);
        }
    }

    public j<Bitmap> getTask() {
        final j task = this.task;
        r.j(task);
        return (j)task;
    }

    @Override // java.io.Closeable
    public void start(Executor executor) {
        ImageDownload$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ImageDownload$$ExternalSyntheticLambda0(this);
        this.task = m.c(executor, externalSyntheticLambda0);
    }
}
