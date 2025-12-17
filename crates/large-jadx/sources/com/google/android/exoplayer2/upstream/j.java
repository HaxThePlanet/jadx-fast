package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.common.base.d;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class j extends com.google.android.exoplayer2.upstream.h {

    private com.google.android.exoplayer2.upstream.n e;
    private byte[] f;
    private int g;
    private int h;
    public j() {
        super(0);
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public long c(com.google.android.exoplayer2.upstream.n n) {
        byte[] str;
        int cmp;
        long l;
        String concat;
        String decode;
        int obj8;
        p(n);
        this.e = n;
        Uri uri = n.a;
        String scheme = uri.getScheme();
        String valueOf2 = String.valueOf(scheme);
        String str8 = "Unsupported scheme: ";
        if (valueOf2.length() != 0) {
            concat = str8.concat(valueOf2);
        } else {
            concat = new String(str8);
        }
        g.b("data".equals(scheme), concat);
        String[] strArr = p0.C0(uri.getSchemeSpecificPart(), ",");
        int i8 = 0;
        if (strArr.length != 2) {
        } else {
            str = strArr[1];
            int i6 = 0;
            if (strArr[i6].contains(";base64")) {
                this.f = Base64.decode(str, i6);
            } else {
                this.f = p0.d0(URLDecoder.decode(str, d.a.name()));
            }
            long l2 = n.f;
            byte[] bArr = this.f;
            int cmp2 = Long.compare(l2, l6);
            if (cmp2 > 0) {
            } else {
                int i2 = (int)l2;
                this.g = i2;
                length2 -= i2;
                this.h = i5;
                long l5 = n.g;
                int i9 = -1;
                if (Long.compare(l5, i9) != 0) {
                    this.h = (int)l4;
                }
                q(n);
                if (Long.compare(l, i9) != 0) {
                } else {
                    l = (long)obj8;
                }
                return l;
            }
            this.f = i8;
            obj8 = new DataSourceException(2008);
            throw obj8;
        }
        obj8 = String.valueOf(uri);
        StringBuilder stringBuilder = new StringBuilder(length += 23);
        stringBuilder.append("Unexpected URI format: ");
        stringBuilder.append(obj8);
        throw ParserException.b(stringBuilder.toString(), i8);
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public void close() {
        final int i = 0;
        if (this.f != null) {
            this.f = i;
            o();
        }
        this.e = i;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public Uri l() {
        Uri uri;
        com.google.android.exoplayer2.upstream.n nVar = this.e;
        uri = nVar != null ? nVar.a : 0;
        return uri;
    }

    @Override // com.google.android.exoplayer2.upstream.h
    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        final int obj5 = Math.min(i3, i);
        byte[] bArr2 = this.f;
        p0.i(bArr2);
        System.arraycopy(bArr2, this.g, bArr, i2, obj5);
        this.g = obj3 += obj5;
        this.h = obj3 -= obj5;
        n(obj5);
        return obj5;
    }
}
