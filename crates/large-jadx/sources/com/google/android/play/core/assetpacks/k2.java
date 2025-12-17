package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class k2 extends InputStream {

    private final Enumeration<File> a;
    private InputStream b;
    public k2(Enumeration<File> enumeration) {
        super();
        this.a = enumeration;
        a();
    }

    @Override // java.io.InputStream
    final void a() {
        FileInputStream fileInputStream;
        Object nextElement;
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
        }
        if (this.a.hasMoreElements()) {
            fileInputStream = new FileInputStream((File)this.a.nextElement());
        } else {
            fileInputStream = 0;
        }
        this.b = fileInputStream;
    }

    @Override // java.io.InputStream
    public final void close() {
        InputStream inputStream;
        super.close();
        inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
            this.b = 0;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        InputStream inputStream = this.b;
        final int i = -1;
        while (inputStream != null) {
            int read = inputStream.read();
            a();
            inputStream = this.b;
            i = -1;
        }
        return i;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        InputStream inputStream;
        final int i = -1;
        if (this.b == null) {
            return i;
        }
        Objects.requireNonNull(bArr);
        if (i2 < 0) {
        } else {
            if (i3 < 0) {
            } else {
                if (i3 > length -= i2) {
                } else {
                    if (i3 != 0) {
                    }
                    return 0;
                }
            }
        }
        IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException();
        throw obj3;
    }
}
