package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class AssetDataSource extends com.google.android.exoplayer2.upstream.h {

    private final AssetManager e;
    private Uri f;
    private InputStream g;
    private long h;
    private boolean i;

    public static final class AssetDataSourceException extends com.google.android.exoplayer2.upstream.DataSourceException {
        public AssetDataSourceException(Throwable throwable, int i2) {
            super(throwable, i2);
        }
    }
    public AssetDataSource(Context context) {
        super(0);
        this.e = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public long c(com.google.android.exoplayer2.upstream.n n) {
        String substring;
        int cmp2;
        boolean z;
        boolean startsWith;
        int cmp;
        try {
            Uri uri = n.a;
            this.f = uri;
            substring = uri.getPath();
            g.e(substring);
            final int i3 = 1;
            if ((String)substring.startsWith("/android_asset/")) {
            } else {
            }
            substring = substring.substring(15);
            if (substring.startsWith("/")) {
            }
            substring = substring.substring(i3);
            p(n);
            InputStream open = this.e.open(substring, i3);
            this.g = open;
            if (Long.compare(skip, l4) < 0) {
            } else {
            }
            cmp2 = n.g;
            int i4 = -1;
            if (Long.compare(cmp2, i4) != 0) {
            } else {
            }
            this.h = cmp2;
            long l = (long)available;
            this.h = l;
            if (Long.compare(l, cmp) == 0) {
            }
            this.h = i4;
            this.i = i3;
            q(n);
            return this.h;
            AssetDataSource.AssetDataSourceException obj8 = new AssetDataSource.AssetDataSourceException(0, 2008);
            throw obj8;
            z = n instanceof FileNotFoundException;
            if (z) {
            } else {
            }
            z = true;
            z = true;
            AssetDataSource.AssetDataSourceException assetDataSourceException = new AssetDataSource.AssetDataSourceException(n, z);
            throw assetDataSourceException;
            throw n;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public void close() {
        int i = 0;
        this.f = i;
        final InputStream inputStream2 = this.g;
        if (inputStream2 != null) {
            inputStream2.close();
        }
        this.g = i;
        if (this.i) {
            this.i = false;
            o();
        }
        try {
            AssetDataSource.AssetDataSourceException assetDataSourceException = new AssetDataSource.AssetDataSourceException(th, 2000);
            throw assetDataSourceException;
            this.g = inputStream;
            InputStream inputStream = this.i;
            if (inputStream == null) {
            } else {
            }
            this.i = obj1;
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
        long l;
        int cmp;
        long l2;
        long obj10;
        int obj11;
        if (i3 == 0) {
            return 0;
        }
        l = this.h;
        final int i4 = -1;
        if (Long.compare(l, i) == 0) {
            return i4;
        }
        final int i5 = -1;
        if (Long.compare(l, i5) == 0) {
        } else {
            obj11 = (int)l;
        }
        InputStream inputStream = this.g;
        p0.i(inputStream);
        int obj9 = (InputStream)inputStream.read(bArr, i2, obj11);
        if (obj9 == i4) {
            return i4;
        }
        obj10 = this.h;
        if (Long.compare(obj10, i5) != 0) {
            this.h = obj10 -= cmp;
        }
        n(obj9);
        return obj9;
    }
}
