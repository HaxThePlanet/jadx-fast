package com.google.android.gms.internal.firebase-auth-api;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class wq implements Iterable<Byte>, Serializable {

    public static final com.google.android.gms.internal.firebase-auth-api.wq a;
    private int zzc = 0;
    static {
        vq vqVar = new vq(e.b);
        wq.a = vqVar;
        int i = lq.a;
    }

    wq() {
        super();
        final int i = 0;
    }

    static int t(int i, int i2, int i3) {
        int i4 = i2 - i;
        if (i7 |= i11 < 0) {
            if (i < 0) {
            } else {
                if (i2 < i) {
                    StringBuilder stringBuilder = new StringBuilder(66);
                    stringBuilder.append("Beginning index larger than ending index: ");
                    stringBuilder.append(i);
                    stringBuilder.append(", ");
                    stringBuilder.append(i2);
                    IndexOutOfBoundsException obj5 = new IndexOutOfBoundsException(stringBuilder.toString());
                    throw obj5;
                }
                StringBuilder stringBuilder2 = new StringBuilder(37);
                stringBuilder2.append("End index: ");
                stringBuilder2.append(i2);
                stringBuilder2.append(" >= ");
                stringBuilder2.append(i3);
                IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException(stringBuilder2.toString());
                throw obj3;
            }
            obj5 = new StringBuilder(32);
            obj5.append("Beginning index: ");
            obj5.append(i);
            obj5.append(" < 0");
            IndexOutOfBoundsException obj4 = new IndexOutOfBoundsException(obj5.toString());
            throw obj4;
        }
        return i4;
    }

    public static com.google.android.gms.internal.firebase-auth-api.wq v(byte[] bArr) {
        return wq.w(bArr, 0, bArr.length);
    }

    public static com.google.android.gms.internal.firebase-auth-api.wq w(byte[] bArr, int i2, int i3) {
        wq.t(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        vq vqVar = new vq(bArr2);
        return vqVar;
    }

    public static com.google.android.gms.internal.firebase-auth-api.wq y(String string) {
        vq vqVar = new vq(string.getBytes(e.a));
        return vqVar;
    }

    static com.google.android.gms.internal.firebase-auth-api.wq z(byte[] bArr) {
        vq vqVar = new vq(bArr);
        return vqVar;
    }

    @Override // java.lang.Iterable
    public final String A(Charset charset) {
        String obj2;
        if (g() == 0) {
            obj2 = "";
        } else {
            obj2 = p(charset);
        }
        return obj2;
    }

    @Override // java.lang.Iterable
    public final byte[] B() {
        int i = g();
        if (i == 0) {
            return e.b;
        }
        final byte[] bArr2 = new byte[i];
        final int i2 = 0;
        h(bArr2, i2, i2, i);
        return bArr2;
    }

    @Override // java.lang.Iterable
    public abstract byte b(int i);

    @Override // java.lang.Iterable
    abstract byte d(int i);

    @Override // java.lang.Iterable
    public abstract boolean equals(Object object);

    @Override // java.lang.Iterable
    public abstract int g();

    @Override // java.lang.Iterable
    protected abstract void h(byte[] bArr, int i2, int i3, int i4);

    @Override // java.lang.Iterable
    public final int hashCode() {
        int zzc;
        int i;
        int i2 = g();
        if (this.zzc == 0 && i(i2, 0, i2) == 0) {
            i2 = g();
            if (i(i2, 0, i2) == 0) {
                zzc = 1;
            }
            this.zzc = zzc;
        }
        return zzc;
    }

    @Override // java.lang.Iterable
    protected abstract int i(int i, int i2, int i3);

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        qq qqVar = new qq(this);
        return qqVar;
    }

    @Override // java.lang.Iterable
    public abstract com.google.android.gms.internal.firebase-auth-api.wq l(int i, int i2);

    @Override // java.lang.Iterable
    public abstract com.google.android.gms.internal.firebase-auth-api.zq m();

    @Override // java.lang.Iterable
    protected abstract String p(Charset charset);

    @Override // java.lang.Iterable
    abstract void q(com.google.android.gms.internal.firebase-auth-api.pq pq);

    @Override // java.lang.Iterable
    public abstract boolean s();

    @Override // java.lang.Iterable
    public final String toString() {
        String concat;
        int str;
        Object[] arr = new Object[3];
        str = 0;
        arr[str] = Integer.toHexString(System.identityHashCode(this));
        arr[1] = Integer.valueOf(g());
        if (g() <= 50) {
            concat = x0.a(this);
        } else {
            concat = String.valueOf(x0.a(l(str, 47))).concat("...");
        }
        arr[2] = concat;
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", arr);
    }

    @Override // java.lang.Iterable
    protected final int u() {
        return this.zzc;
    }
}
