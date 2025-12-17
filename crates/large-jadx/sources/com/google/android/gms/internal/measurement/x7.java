package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class x7 implements Iterable<Byte>, Serializable {

    public static final com.google.android.gms.internal.measurement.x7 a;
    private int zzc = 0;
    static {
        w7 w7Var = new w7(d9.b);
        x7.a = w7Var;
        int i = m7.a;
    }

    x7() {
        super();
        final int i = 0;
    }

    static int q(int i, int i2, int i3) {
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

    public static com.google.android.gms.internal.measurement.x7 t(byte[] bArr, int i2, int i3) {
        x7.q(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        w7 w7Var = new w7(bArr2);
        return w7Var;
    }

    public static com.google.android.gms.internal.measurement.x7 u(String string) {
        w7 w7Var = new w7(string.getBytes(d9.a));
        return w7Var;
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
    protected abstract int h(int i, int i2, int i3);

    @Override // java.lang.Iterable
    public final int hashCode() {
        int zzc;
        int i;
        int i2 = g();
        if (this.zzc == 0 && h(i2, 0, i2) == 0) {
            i2 = g();
            if (h(i2, 0, i2) == 0) {
                zzc = 1;
            }
            this.zzc = zzc;
        }
        return zzc;
    }

    @Override // java.lang.Iterable
    public abstract com.google.android.gms.internal.measurement.x7 i(int i, int i2);

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        r7 r7Var = new r7(this);
        return r7Var;
    }

    @Override // java.lang.Iterable
    protected abstract String l(Charset charset);

    @Override // java.lang.Iterable
    abstract void m(com.google.android.gms.internal.measurement.q7 q7);

    @Override // java.lang.Iterable
    public abstract boolean p();

    @Override // java.lang.Iterable
    protected final int s() {
        return this.zzc;
    }

    @Override // java.lang.Iterable
    public final String toString() {
        String concat;
        int str;
        Object[] arr = new Object[3];
        str = 0;
        arr[str] = Integer.toHexString(System.identityHashCode(this));
        arr[1] = Integer.valueOf(g());
        if (g() <= 50) {
            concat = va.a(this);
        } else {
            concat = va.a(i(str, 47)).concat("...");
        }
        arr[2] = concat;
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", arr);
    }

    @Override // java.lang.Iterable
    public final String v(Charset charset) {
        String obj2;
        if (g() == 0) {
            obj2 = "";
        } else {
            obj2 = l(charset);
        }
        return obj2;
    }
}
