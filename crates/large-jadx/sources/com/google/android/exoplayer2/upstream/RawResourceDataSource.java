package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/* loaded from: classes2.dex */
public final class RawResourceDataSource extends com.google.android.exoplayer2.upstream.h {

    private final Resources e;
    private final String f;
    private Uri g;
    private AssetFileDescriptor h;
    private InputStream i;
    private long j;
    private boolean k;

    public static class RawResourceDataSourceException extends com.google.android.exoplayer2.upstream.DataSourceException {
        public RawResourceDataSourceException(String string, Throwable throwable2, int i3) {
            super(string, throwable2, i3);
        }
    }
    public RawResourceDataSource(Context context) {
        super(0);
        this.e = context.getResources();
        this.f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        StringBuilder stringBuilder = new StringBuilder(26);
        stringBuilder.append("rawresource:///");
        stringBuilder.append(i);
        return Uri.parse(stringBuilder.toString());
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public long c(com.google.android.exoplayer2.upstream.n n) {
        int channel;
        long l;
        long l2;
        boolean matches;
        String substring;
        String concat2;
        int identifier;
        int cmp2;
        String concat;
        int i;
        int cmp4;
        int cmp;
        int position;
        String str2;
        boolean empty;
        int length;
        String str;
        int cmp3;
        final Object obj2 = this;
        Object obj = n;
        Uri uri = obj.a;
        obj2.g = uri;
        int i10 = 1;
        position = 0;
        if (!TextUtils.equals("rawresource", uri.getScheme())) {
            str2 = "android.resource";
            String lastPathSegment2 = uri.getLastPathSegment();
            g.e(lastPathSegment2);
            if (TextUtils.equals(str2, uri.getScheme()) && uri.getPathSegments().size() == i10 && (String)lastPathSegment2.matches("\\d+")) {
                if (uri.getPathSegments().size() == i10) {
                    lastPathSegment2 = uri.getLastPathSegment();
                    g.e(lastPathSegment2);
                    if ((String)lastPathSegment2.matches("\\d+")) {
                    } else {
                        if (!TextUtils.equals(str2, uri.getScheme())) {
                        } else {
                            substring = uri.getPath();
                            g.e(substring);
                            if ((String)substring.startsWith("/")) {
                                substring = substring.substring(i10);
                            }
                            String host = uri.getHost();
                            if (TextUtils.isEmpty(host)) {
                                concat = "";
                            } else {
                                concat = String.valueOf(host).concat(":");
                            }
                            String valueOf3 = String.valueOf(concat);
                            String valueOf2 = String.valueOf(substring);
                            if (valueOf2.length() != 0) {
                                concat2 = valueOf3.concat(valueOf2);
                            } else {
                                concat2 = new String(valueOf3);
                            }
                            if (obj2.e.getIdentifier(concat2, "raw", obj2.f) == 0) {
                            } else {
                                p(n);
                                AssetFileDescriptor rawResourceFd = obj2.e.openRawResourceFd(identifier);
                                obj2.h = rawResourceFd;
                                if (rawResourceFd == null) {
                                } else {
                                    length = rawResourceFd.getLength();
                                    FileInputStream fileInputStream = new FileInputStream(rawResourceFd.getFileDescriptor());
                                    obj2.i = fileInputStream;
                                    final int i12 = -1;
                                    cmp4 = Long.compare(length, i12);
                                    final int i13 = 2008;
                                    if (cmp4 != 0) {
                                        if (Long.compare(l4, length) > 0) {
                                        } else {
                                        }
                                        RawResourceDataSource.RawResourceDataSourceException rawResourceDataSourceException4 = new RawResourceDataSource.RawResourceDataSourceException(position, position, i13);
                                        throw rawResourceDataSourceException4;
                                    }
                                    long startOffset = rawResourceFd.getStartOffset();
                                    skip -= startOffset;
                                    if (Long.compare(cmp, l5) != 0) {
                                    } else {
                                        int i14 = 0;
                                        if (cmp4 == 0) {
                                            channel = fileInputStream.getChannel();
                                            if (Long.compare(size, i14) == 0) {
                                                obj2.j = i12;
                                                l = obj.g;
                                                if (Long.compare(l, i12) != 0) {
                                                    cmp2 = obj2.j;
                                                    if (Long.compare(cmp2, i12) == 0) {
                                                    } else {
                                                        l = Math.min(cmp2, cmp4);
                                                    }
                                                    obj2.j = l;
                                                }
                                                obj2.k = true;
                                                q(n);
                                                if (Long.compare(l2, i12) != 0) {
                                                } else {
                                                    l2 = obj2.j;
                                                }
                                                return l2;
                                            } else {
                                                size2 -= position;
                                                obj2.j = cmp4;
                                                if (Long.compare(cmp4, i14) < 0) {
                                                } else {
                                                }
                                            }
                                            int i2 = 0;
                                            RawResourceDataSource.RawResourceDataSourceException rawResourceDataSourceException5 = new RawResourceDataSource.RawResourceDataSourceException(i2, i2, i13);
                                            throw rawResourceDataSourceException5;
                                        }
                                        length -= cmp;
                                        obj2.j = length;
                                        if (Long.compare(length, i14) < 0) {
                                        } else {
                                        }
                                        DataSourceException dataSourceException = new DataSourceException(i13);
                                        throw dataSourceException;
                                    }
                                    int i4 = 0;
                                    RawResourceDataSource.RawResourceDataSourceException rawResourceDataSourceException6 = new RawResourceDataSource.RawResourceDataSourceException(i4, i4, i13);
                                    throw rawResourceDataSourceException6;
                                }
                                String valueOf = String.valueOf(uri);
                                StringBuilder stringBuilder = new StringBuilder(length2 += 24);
                                stringBuilder.append("Resource is compressed: ");
                                stringBuilder.append(valueOf);
                                RawResourceDataSource.RawResourceDataSourceException rawResourceDataSourceException7 = new RawResourceDataSource.RawResourceDataSourceException(stringBuilder.toString(), 0, 2000);
                                throw rawResourceDataSourceException7;
                            }
                            RawResourceDataSource.RawResourceDataSourceException rawResourceDataSourceException2 = new RawResourceDataSource.RawResourceDataSourceException("Resource not found.", position, 2005);
                            throw rawResourceDataSourceException2;
                        }
                    }
                } else {
                }
            } else {
            }
            RawResourceDataSource.RawResourceDataSourceException rawResourceDataSourceException3 = new RawResourceDataSource.RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", position, 1004);
            throw rawResourceDataSourceException3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        g.e(lastPathSegment);
        identifier = Integer.parseInt((String)lastPathSegment);
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public void close() {
        com.google.android.exoplayer2.upstream.RawResourceDataSource.RawResourceDataSourceException rawResourceDataSourceException;
        int i = 0;
        this.g = i;
        final int i2 = 2000;
        InputStream inputStream = this.i;
        if (inputStream != null) {
            inputStream.close();
        }
        this.i = i;
        AssetFileDescriptor assetFileDescriptor = this.h;
        if (assetFileDescriptor != null) {
            assetFileDescriptor.close();
        }
        this.h = i;
        if (this.k) {
            this.k = false;
            o();
        }
        try {
            rawResourceDataSourceException = new RawResourceDataSource.RawResourceDataSourceException(str, th2, th);
            throw rawResourceDataSourceException;
            this.h = str;
            String str = this.k;
            if (str == null) {
            } else {
            }
            this.k = obj2;
            o();
            throw th;
        } catch (java.io.IOException ioException) {
        } catch (Throwable th1) {
        }
        this.i = str;
        rawResourceDataSourceException = this.h;
        if (rawResourceDataSourceException != null) {
            try {
                rawResourceDataSourceException.close();
                this.h = str;
                str = this.k;
                if (str == null) {
                } else {
                }
                this.k = obj2;
                o();
                throw th2;
                rawResourceDataSourceException = new RawResourceDataSource.RawResourceDataSourceException(str, th2, th);
                throw rawResourceDataSourceException;
                this.h = str;
                str = this.k;
            }
            this.k = obj2;
            o();
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public Uri l() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public int read(byte[] bArr, int i2, int i3) {
        long l2;
        int cmp;
        long l;
        long obj11;
        int obj12;
        if (i3 == 0) {
            return 0;
        }
        l2 = this.j;
        final int i4 = -1;
        if (Long.compare(l2, i) == 0) {
            return i4;
        }
        final int i5 = -1;
        if (Long.compare(l2, i5) == 0) {
        } else {
            obj12 = (int)l2;
        }
        InputStream inputStream = this.i;
        p0.i(inputStream);
        int obj10 = (InputStream)inputStream.read(bArr, i2, obj12);
        if (obj10 == i4) {
            if (Long.compare(obj10, i5) != 0) {
            } else {
                return i4;
            }
            obj11 = new EOFException();
            obj10 = new RawResourceDataSource.RawResourceDataSourceException("End of stream reached having not read sufficient data.", obj11, 2000);
            throw obj10;
        }
        obj11 = this.j;
        if (Long.compare(obj11, i5) != 0) {
            this.j = obj11 -= cmp;
        }
        n(obj10);
        return obj10;
    }
}
