package io.grpc.j1;

import com.google.common.base.d;
import com.google.common.io.BaseEncoding;
import io.grpc.j0;
import io.grpc.t0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class m2 {

    private static final Logger a;
    private static final byte[] b;
    static {
        m2.a = Logger.getLogger(m2.class.getName());
        m2.b = "-bin".getBytes(d.a);
    }

    private static boolean a(byte[] bArr, byte[] b2Arr2) {
        int i;
        byte b;
        byte b2;
        length -= length2;
        int i3 = 0;
        if (i2 < 0) {
            return i3;
        }
        i = i2;
        for (byte b : bArr) {
        }
        return 1;
    }

    private static boolean b(byte[] bArr) {
        int i2;
        byte b;
        int i;
        final int i3 = 0;
        i2 = i3;
        while (i2 < bArr.length) {
            b = bArr[i2];
            i2++;
        }
        return 1;
    }

    private static byte[][] c(byte[][] bArrArr, int i2) {
        int i4;
        Object obj;
        int i3;
        int i5;
        int length;
        String string;
        int i;
        java.nio.charset.Charset charset;
        int obj11;
        ArrayList arrayList = new ArrayList(length2 += 10);
        int i7 = 0;
        i4 = i7;
        while (i4 < i2) {
            arrayList.add(bArrArr[i4]);
            i4++;
        }
        while (obj11 < bArrArr.length) {
            i4 = bArrArr[obj11];
            obj = bArrArr[obj11 + 1];
            if (!m2.a(i4, m2.b)) {
            } else {
            }
            i5 = i3;
            while (i3 <= obj.length) {
                if (i3 != obj.length && obj[i3] != 44) {
                } else {
                }
                string = new String(obj, i5, i3 - i5, d.a);
                arrayList.add(i4);
                arrayList.add(BaseEncoding.b().c(string));
                i5 = length;
                i3++;
                if (obj[i3] != 44) {
                } else {
                }
            }
            obj11 += 2;
            if (i3 != obj.length && obj[i3] != 44) {
            } else {
            }
            string = new String(obj, i5, i3 - i5, d.a);
            arrayList.add(i4);
            arrayList.add(BaseEncoding.b().c(string));
            i5 = length;
            i3++;
            if (obj[i3] != 44) {
            } else {
            }
            arrayList.add(i4);
            arrayList.add(obj);
        }
        return (byte[][])arrayList.toArray(new byte[i7]);
    }

    public static byte[][] d(t0 t0) {
        int i;
        int i2;
        Logger logger;
        String string;
        String str;
        StringBuilder stringBuilder;
        String str2;
        byte[][] obj8 = j0.d(t0);
        final int i3 = 0;
        if (obj8 == null) {
            return new byte[i3];
        }
        i2 = i;
        while (i < obj8.length) {
            byte[] bArr = obj8[i];
            string = obj8[i + 1];
            if (m2.a(bArr, m2.b)) {
            } else {
            }
            if (m2.b(string)) {
            } else {
            }
            String string3 = new String(bArr, d.a);
            stringBuilder = new StringBuilder();
            stringBuilder.append("Metadata key=");
            stringBuilder.append(string3);
            stringBuilder.append(", value=");
            stringBuilder.append(Arrays.toString(string));
            stringBuilder.append(" contains invalid ASCII characters");
            m2.a.warning(stringBuilder.toString());
            i += 2;
            obj8[i2] = bArr;
            obj8[i2 + 1] = string;
            i2 += 2;
            obj8[i2] = bArr;
            obj8[i2 + 1] = j0.b.f(string).getBytes(d.a);
        }
        if (i2 == obj8.length) {
            return obj8;
        }
        return (byte[][])Arrays.copyOfRange(obj8, i3, i2);
    }

    public static byte[][] e(byte[][] bArrArr) {
        int i;
        boolean z;
        int i2;
        int i3;
        Object obj;
        byte[] string;
        java.nio.charset.Charset charset;
        final int i4 = 0;
        i = i4;
        while (i < bArrArr.length) {
            i3 = i + 1;
            obj = bArrArr[i3];
            if (m2.a(bArrArr[i], m2.b)) {
            } else {
            }
            i += 2;
            i2 = i4;
            for (byte string : obj4) {
            }
            string = new String(obj, d.a);
            bArrArr[i3] = BaseEncoding.b().c(string);
            i2++;
        }
        return bArrArr;
    }
}
