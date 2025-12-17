package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* loaded from: classes2.dex */
final class LengthCountingOutputStream extends OutputStream {

    private long length = 0;
    LengthCountingOutputStream() {
        super();
        final int i = 0;
    }

    @Override // java.io.OutputStream
    long getLength() {
        return this.length;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.length = length += i3;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.length = length += l;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int length;
        int obj3;
        int obj4;
        if (i2 < 0) {
        } else {
            if (i2 > bArr.length) {
            } else {
                if (i3 < 0) {
                } else {
                    i2 += i3;
                    if (obj4 > bArr.length) {
                    } else {
                        if (obj4 < 0) {
                        } else {
                            this.length = obj3 += l;
                        }
                    }
                }
            }
        }
        obj3 = new IndexOutOfBoundsException();
        throw obj3;
    }
}
