package com.google.common.io;

import com.google.common.base.n;
import f.c.c.a.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: classes2.dex */
public final class a {

    class a extends OutputStream {
        @Override // java.io.OutputStream
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            n.o(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            n.o(bArr);
        }
    }
    static {
        a.a aVar = new a.a();
    }

    private static byte[] a(Queue<byte[]> queue, int i2) {
        int i4;
        Object remove;
        int i5;
        int i3;
        int i;
        final byte[] bArr = new byte[i2];
        i4 = i2;
        while (i4 > 0) {
            remove = queue.remove();
            i5 = Math.min(i4, remove.length);
            System.arraycopy((byte[])remove, 0, bArr, i2 - i4, i5);
            i4 -= i5;
        }
        return bArr;
    }

    public static long b(InputStream inputStream, OutputStream outputStream2) {
        int i;
        long l;
        int i2;
        n.o(inputStream);
        n.o(outputStream2);
        final byte[] bArr = a.c();
        i = 0;
        int read = inputStream.read(bArr);
        while (read == -1) {
            outputStream2.write(bArr, 0, read);
            i += l;
            read = inputStream.read(bArr);
        }
        return i;
    }

    static byte[] c() {
        return new byte[8192];
    }

    public static byte[] d(InputStream inputStream) {
        n.o(inputStream);
        ArrayDeque arrayDeque = new ArrayDeque(20);
        return a.e(inputStream, arrayDeque, 0);
    }

    private static byte[] e(InputStream inputStream, Queue<byte[]> queue2, int i3) {
        int i4;
        int i2;
        int i;
        byte[] bArr;
        int i5;
        int read;
        int obj8;
        i4 = 8192;
        int i6 = -1;
        int i7 = 2147483639;
        while (obj8 < i7) {
            i = Math.min(i4, i7 -= obj8);
            bArr = new byte[i];
            queue2.add(bArr);
            i5 = 0;
            while (i5 < i) {
                read = inputStream.read(bArr, i5, i - i5);
                i5 += read;
                obj8 += read;
            }
            i4 = a.e(i4, 2);
            i6 = -1;
            i7 = 2147483639;
            read = inputStream.read(bArr, i5, i - i5);
            i5 += read;
            obj8 += read;
        }
        if (inputStream.read() != i6) {
        } else {
            return a.a(queue2, i7);
        }
        OutOfMemoryError obj6 = new OutOfMemoryError("input is too large to fit in a byte array");
        throw obj6;
    }
}
