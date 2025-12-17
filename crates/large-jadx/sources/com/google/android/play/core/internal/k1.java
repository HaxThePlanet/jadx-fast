package com.google.android.play.core.internal;

import android.accounts.Account;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class k1 {
    public static long a(com.google.android.play.core.internal.l1 l1, InputStream inputStream2, OutputStream outputStream3, long l4) {
        String string;
        int i4;
        byte[] bArr;
        int i2;
        Object inputStream;
        long long;
        long l2;
        long l;
        int i;
        int i3;
        int unsignedShort;
        byte[] bArr2 = new byte[16384];
        inputStream = inputStream2;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream2, 4096);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
        int int = dataInputStream.readInt();
        if (int != -771763713) {
            Object[] arr = new Object[1];
            String valueOf2 = String.valueOf(String.format("%x", Integer.valueOf(int)));
            String str3 = "Unexpected magic=";
            if (valueOf2.length() != 0) {
                string = str3.concat(valueOf2);
            } else {
                string = new String(str3);
            }
            zzck zzck = new zzck(string);
            throw zzck;
        }
        int read = dataInputStream.read();
        if (read != 4) {
        } else {
            i3 = i4;
            i = l4 - i3;
            unsignedShort = dataInputStream.read();
            int i6 = -1;
            while (unsignedShort != i6) {
                String str4 = "Unexpected end of patch";
                k1.c(bArr2, dataInputStream, outputStream3, unsignedShort, i);
                i3 += i4;
                i = l4 - i3;
                unsignedShort = dataInputStream.read();
                i6 = -1;
                k1.b(bArr2, l1, outputStream3, dataInputStream.readLong(), l2, dataInputStream.readInt());
                k1.b(bArr2, l1, outputStream3, (long)int2, l2, dataInputStream.readInt());
                k1.b(bArr2, l1, outputStream3, (long)int3, l2, dataInputStream.readUnsignedShort());
                unsignedShort = dataInputStream.read();
                k1.b(bArr2, l1, outputStream3, (long)int4, l2, unsignedShort);
                k1.b(bArr2, l1, outputStream3, (long)unsignedShort2, l2, dataInputStream.readInt());
                k1.b(bArr2, l1, outputStream3, (long)unsignedShort3, l2, dataInputStream.readUnsignedShort());
                unsignedShort = dataInputStream.read();
                k1.b(bArr2, l1, outputStream3, (long)unsignedShort4, l2, unsignedShort);
                k1.c(bArr2, dataInputStream, outputStream3, dataInputStream.readInt(), i);
                k1.c(bArr2, dataInputStream, outputStream3, dataInputStream.readUnsignedShort(), i);
            }
            IOException iOException = new IOException("Patch file overrun");
            throw iOException;
        }
        StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder.append("Unexpected version=");
        stringBuilder.append(read);
        zzck zzck2 = new zzck(stringBuilder.toString());
        throw zzck2;
    }

    private static void b(byte[] bArr, com.google.android.play.core.internal.l1 l12, OutputStream outputStream3, long l4, int i5, long l6) {
        int cmp;
        int obj10;
        int obj11;
        int obj12;
        com.google.android.play.core.internal.m1 obj13;
        int obj14;
        if (l6 < 0) {
        } else {
            if (Long.compare(l4, i) < 0) {
            } else {
                final long l = (long)l6;
                if (Long.compare(l, obj13) > 0) {
                } else {
                    super(l12, l4, obj4, l, obj6);
                    InputStream obj8 = obj13.e();
                    while (obj12 > 0) {
                        obj10 = Math.min(obj12, 16384);
                        obj11 = 0;
                        obj13 = obj11;
                        while (obj13 < obj10) {
                            obj14 = obj8.read(bArr, obj13, obj10 - obj13);
                            obj13 += obj14;
                        }
                        outputStream3.write(bArr, obj11, obj10);
                        obj12 -= obj10;
                        obj14 = obj8.read(bArr, obj13, obj10 - obj13);
                        obj13 += obj14;
                    }
                    obj8.close();
                }
                IOException obj7 = new IOException("Output length overrun");
                throw obj7;
            }
            obj7 = new IOException("inputOffset negative");
            throw obj7;
        }
        obj7 = new IOException("copyLength negative");
        throw obj7;
    }

    private static void c(byte[] bArr, DataInputStream dataInputStream2, OutputStream outputStream3, int i4, long l5) {
        int obj5;
        int obj6;
        int obj7;
        if (i4 < 0) {
        } else {
            if (Long.compare(l, l5) > 0) {
            }
            IOException obj2 = new IOException("Output length overrun");
            throw obj2;
        }
        obj2 = new IOException("copyLength negative");
        throw obj2;
    }
}
