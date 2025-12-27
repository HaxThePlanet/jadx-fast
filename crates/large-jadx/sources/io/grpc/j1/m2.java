package io.grpc.j1;

import com.google.common.base.d;
import com.google.common.io.BaseEncoding;
import io.grpc.j0;
import io.grpc.t0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: TransportFrameUtil.java */
/* loaded from: classes3.dex */
public final class m2 {

    private static final Logger a;
    private static final byte[] b;
    static {
        m2.a = Logger.getLogger(m2.class.getName());
        m2.b = "-bin".getBytes(d.a);
    }

    private m2() {
        super();
    }

    private static boolean a(byte[] bArr, byte[] bArr2) {
        int i;
        i = bArr.length - bArr2.length;
        boolean z = false;
        if (bArr.length < 0) {
            return false;
        }
        while (i < bArr.length) {
            if (bArr[i] != bArr2[i - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(byte[] bArr) {
        int i;
        i = 0;
        for (byte b : bArr) {
            byte b2 = (byte) 32;
            b2 = (byte) 126;
        }
        return true;
    }

    private static byte[][] c(byte[][] bArrArr, int i) throws java.io.UnsupportedEncodingException {
        int length;
        Object obj;
        String string;
        java.nio.charset.Charset charset;
        int i3;
        final ArrayList arrayList = new ArrayList(bArrArr.length + 10);
        length = 0;
        while (length < i) {
            arrayList.add(bArrArr[length]);
            length = length + 1;
        }
        while (i3 < bArrArr.length) {
            Object obj2 = bArrArr[i3];
            obj = bArrArr[i3 + 1];
            i3 = i3 + 2;
        }
        return (byte[][])arrayList.toArray(new byte[length]);
    }

    public static byte[][] d(t0 t0Var) throws java.io.UnsupportedEncodingException {
        int i;
        Logger logger;
        int i2;
        String str;
        byte[] bytes;
        String str2;
        boolean z;
        StringBuilder stringBuilder;
        String str3;
        byte[][] arr = j0.d(t0Var);
        i = 0;
        if (arr == null) {
            return new byte[i];
        }
        while (i < arr.length) {
            byte[] bArr = arr[i];
            bytes = arr[i + 1];
            i = i + 2;
        }
        if (i == arr.length) {
            return arr;
        }
        return (byte[][])Arrays.copyOfRange(arr, i, i);
    }

    public static byte[][] e(byte[][] bArrArr) throws java.io.UnsupportedEncodingException {
        int i;
        boolean z;
        byte[] bArr;
        java.nio.charset.Charset charset;
        i = 0;
        while (i < bArrArr.length) {
            i2 = i + 1;
            Object obj2 = bArrArr[i2];
            if (m2.a(bArrArr[i], m2.b)) {
            }
        }
        return bArrArr;
    }
}
