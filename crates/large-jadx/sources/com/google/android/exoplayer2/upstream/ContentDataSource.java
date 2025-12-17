package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.exoplayer2.util.p0;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes2.dex */
public final class ContentDataSource extends com.google.android.exoplayer2.upstream.h {

    private final ContentResolver e;
    private Uri f;
    private AssetFileDescriptor g;
    private FileInputStream h;
    private long i;
    private boolean j;

    public static class ContentDataSourceException extends com.google.android.exoplayer2.upstream.DataSourceException {
        public ContentDataSourceException(IOException iOException, int i2) {
            super(iOException, i2);
        }
    }
    public ContentDataSource(Context context) {
        super(0);
        this.e = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public long c(com.google.android.exoplayer2.upstream.n n) {
        long l;
        long l2;
        com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException contentDataSourceException;
        int channel;
        boolean z;
        int size;
        int cmp;
        int length;
        int cmp3;
        int cmp2;
        int position;
        Uri uri = n.a;
        this.f = uri;
        p(n);
        AssetFileDescriptor assetFileDescriptor = this.e.openAssetFileDescriptor(uri, "r");
        this.g = assetFileDescriptor;
        if (assetFileDescriptor == null) {
        } else {
            length = assetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
            this.h = fileInputStream;
            int i5 = -1;
            final int cmp4 = Long.compare(length, i5);
            final int i6 = 2008;
            final int i7 = 0;
            if (cmp4 != 0) {
                try {
                    if (Long.compare(l3, length) > 0) {
                    } else {
                    }
                    ContentDataSource.ContentDataSourceException obj15 = new ContentDataSource.ContentDataSourceException(i7, i6);
                    throw obj15;
                    long startOffset = assetFileDescriptor.getStartOffset();
                    skip -= startOffset;
                    if (Long.compare(position, l4) != 0) {
                    } else {
                    }
                    int i8 = 0;
                    if (cmp4 == 0) {
                    }
                    channel = fileInputStream.getChannel();
                    size = channel.size();
                    if (Long.compare(size, i8) == 0) {
                    } else {
                    }
                    this.i = i5;
                    size -= position;
                    this.i = size;
                    if (Long.compare(size, i8) < 0) {
                    } else {
                    }
                    obj15 = new ContentDataSource.ContentDataSourceException(i7, i6);
                    throw obj15;
                    length -= position;
                    this.i = length;
                    if (Long.compare(length, i8) < 0) {
                    } else {
                    }
                    l = n.g;
                    if (Long.compare(l, i5) != 0) {
                    }
                    cmp = this.i;
                    if (Long.compare(cmp, i5) == 0) {
                    } else {
                    }
                    l = Math.min(cmp, length);
                    this.i = l;
                    this.j = true;
                    q(n);
                    if (Long.compare(l2, i5) != 0) {
                    } else {
                    }
                    l2 = this.i;
                    return l2;
                    obj15 = new ContentDataSource.ContentDataSourceException(i7, i6);
                    throw obj15;
                    obj15 = new ContentDataSource.ContentDataSourceException(i7, i6);
                    throw obj15;
                    String valueOf = String.valueOf(uri);
                    StringBuilder stringBuilder = new StringBuilder(length2 += 36);
                    stringBuilder.append("Could not open file descriptor for: ");
                    stringBuilder.append(valueOf);
                    IOException iOException = new IOException(stringBuilder.toString());
                    obj15 = new ContentDataSource.ContentDataSourceException(iOException, 2000);
                    throw obj15;
                    if (n instanceof FileNotFoundException == null) {
                    } else {
                    }
                    contentDataSourceException = new ContentDataSource.ContentDataSourceException(n, 2005);
                    throw contentDataSourceException;
                    throw n;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public void close() {
        com.google.android.exoplayer2.upstream.ContentDataSource.ContentDataSourceException contentDataSourceException;
        int i = 0;
        this.f = i;
        final int i2 = 2000;
        FileInputStream inputStream = this.h;
        if (inputStream != null) {
            inputStream.close();
        }
        this.h = i;
        AssetFileDescriptor assetFileDescriptor2 = this.g;
        if (assetFileDescriptor2 != null) {
            assetFileDescriptor2.close();
        }
        this.g = i;
        if (this.j) {
            this.j = false;
            o();
        }
        try {
            contentDataSourceException = new ContentDataSource.ContentDataSourceException(th2, th);
            throw contentDataSourceException;
            this.g = assetFileDescriptor;
            AssetFileDescriptor assetFileDescriptor = this.j;
            if (assetFileDescriptor == null) {
            } else {
            }
            this.j = obj2;
            o();
            throw th;
        } catch (java.io.IOException ioException) {
        } catch (Throwable th1) {
        }
        this.h = assetFileDescriptor;
        contentDataSourceException = this.g;
        if (contentDataSourceException != null) {
            try {
                contentDataSourceException.close();
                this.g = assetFileDescriptor;
                assetFileDescriptor = this.j;
                if (assetFileDescriptor == null) {
                } else {
                }
                this.j = obj2;
                o();
                throw th2;
                contentDataSourceException = new ContentDataSource.ContentDataSourceException(th2, th);
                throw contentDataSourceException;
                this.g = assetFileDescriptor;
                assetFileDescriptor = this.j;
            }
            this.j = obj2;
            o();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public Uri l() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public int read(byte[] bArr, int i2, int i3) {
        long l2;
        int cmp;
        long l;
        long obj10;
        int obj11;
        if (i3 == 0) {
            return 0;
        }
        l2 = this.i;
        final int i4 = -1;
        if (Long.compare(l2, i) == 0) {
            return i4;
        }
        final int i5 = -1;
        if (Long.compare(l2, i5) == 0) {
        } else {
            obj11 = (int)l2;
        }
        FileInputStream inputStream = this.h;
        p0.i(inputStream);
        int obj9 = (FileInputStream)inputStream.read(bArr, i2, obj11);
        if (obj9 == i4) {
            return i4;
        }
        obj10 = this.i;
        if (Long.compare(obj10, i5) != 0) {
            this.i = obj10 -= cmp;
        }
        n(obj9);
        return obj9;
    }
}
