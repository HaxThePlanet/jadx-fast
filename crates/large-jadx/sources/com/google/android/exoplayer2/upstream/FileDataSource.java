package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.OsConstants;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/* loaded from: classes2.dex */
public final class FileDataSource extends com.google.android.exoplayer2.upstream.h {

    private RandomAccessFile e;
    private Uri f;
    private long g;
    private boolean h;

    private static final class a {
        static boolean a(Throwable throwable) {
            return FileDataSource.a.b(throwable);
        }

        private static boolean b(Throwable throwable) {
            boolean eACCES;
            Object obj1;
            if (throwable instanceof ErrnoException != null && throwable.errno == OsConstants.EACCES) {
                obj1 = throwable.errno == OsConstants.EACCES ? 1 : 0;
            } else {
            }
            return obj1;
        }
    }

    public static class FileDataSourceException extends com.google.android.exoplayer2.upstream.DataSourceException {
        public FileDataSourceException(String string, Throwable throwable2, int i3) {
            super(string, throwable2, i3);
        }

        public FileDataSourceException(Throwable throwable, int i2) {
            super(throwable, i2);
        }
    }
    public FileDataSource() {
        super(0);
    }

    private static RandomAccessFile r(Uri uri) {
        int i;
        String str;
        int i2;
        final int i3 = 2006;
        final String path = uri.getPath();
        g.e(path);
        RandomAccessFile randomAccessFile = new RandomAccessFile((String)path, "r");
        return randomAccessFile;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public long c(com.google.android.exoplayer2.upstream.n n) {
        long l;
        int cmp;
        Uri uri = n.a;
        this.f = uri;
        p(n);
        RandomAccessFile randomAccessFile = FileDataSource.r(uri);
        this.e = randomAccessFile;
        randomAccessFile.seek(n.f);
        if (Long.compare(l, i5) == 0) {
            length -= cmp;
        }
        this.g = l;
        if (Long.compare(l, i6) < 0) {
        } else {
            this.h = true;
            q(n);
            return this.g;
        }
        int i4 = 0;
        FileDataSource.FileDataSourceException obj5 = new FileDataSource.FileDataSourceException(i4, i4, 2008);
        throw obj5;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public void close() {
        int i = 0;
        this.f = i;
        final RandomAccessFile randomAccessFile2 = this.e;
        if (randomAccessFile2 != null) {
            randomAccessFile2.close();
        }
        this.e = i;
        if (this.h) {
            this.h = false;
            o();
        }
        try {
            FileDataSource.FileDataSourceException fileDataSourceException = new FileDataSource.FileDataSourceException(th, 2000);
            throw fileDataSourceException;
            this.e = randomAccessFile;
            RandomAccessFile randomAccessFile = this.h;
            if (randomAccessFile == null) {
            } else {
            }
            this.h = obj1;
            o();
            throw th;
        } catch (Throwable th) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public Uri l() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public int read(byte[] bArr, int i2, int i3) {
        RandomAccessFile randomAccessFile;
        int obj7;
        if (i3 == 0) {
            return 0;
        }
        final int i = 0;
        if (Long.compare(l, i) == 0) {
            return -1;
        }
        randomAccessFile = this.e;
        p0.i(randomAccessFile);
        int obj6 = (RandomAccessFile)randomAccessFile.read(bArr, i2, (int)l3);
        if (obj6 > 0) {
            this.g = obj7 -= randomAccessFile;
            n(obj6);
        }
        return obj6;
    }
}
