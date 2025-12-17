package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.m;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
class d implements l {

    private final l a;
    private final byte[] b;
    private final byte[] c;
    private CipherInputStream d;
    public d(l l, byte[] b2Arr2, byte[] b3Arr3) {
        super();
        this.a = l;
        this.b = b2Arr2;
        this.c = b3Arr3;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final long c(n n) {
        try {
            Cipher cipher = n();
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(this.c);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            m mVar = new m(this.a, n);
            CipherInputStream obj5 = new CipherInputStream(mVar, cipher);
            this.d = obj5;
            mVar.c();
            return -1;
            RuntimeException runtimeException = new RuntimeException(n);
            throw runtimeException;
        } catch (java.security.InvalidKeyException invalidKey) {
        } catch (java.security.InvalidAlgorithmParameterException invalidAlgorithmParameter1) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() {
        Object inputStream;
        if (this.d != null) {
            this.d = 0;
            this.a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final void d(b0 b0) {
        g.e(b0);
        this.a.d(b0);
    }

    public final Map<String, List<String>> h() {
        return this.a.h();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final Uri l() {
        return this.a.l();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    protected Cipher n() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final int read(byte[] bArr, int i2, int i3) {
        int obj2;
        g.e(this.d);
        if (this.d.read(bArr, i2, i3) < 0) {
            obj2 = -1;
        }
        return obj2;
    }
}
