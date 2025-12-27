package net.time4j.h1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;

/* compiled from: UTF8ResourceReader.java */
/* loaded from: classes3.dex */
class g extends Reader {

    private final PushbackInputStream a = new PushbackInputStream();
    private BufferedReader b = null;
    g(InputStream inputStream) {
        super();
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 3);
    }

    private void a() throws java.io.UnsupportedEncodingException, java.io.IOException {
        int i = 3;
        int i2 = 1;
        byte b = -17;
        if (this.b != null) {
            return;
        }
        i = 3;
        byte[] bArr = new byte[i];
        i2 = 0;
        int read = this.a.read(bArr, i2, i);
        i2 = 1;
        if (read == i) {
            b = (byte) -17;
            if (bArr[i2] == (byte) -17) {
                b = (byte) -69;
                if (bArr[1] == (byte) -69) {
                    b = (byte) -65;
                    if (bArr[2] != (byte) -65) {
                    }
                }
            }
        }
        if (i2 == 0 && read > 0) {
            this.a.unread(bArr, i2, read);
        }
        this.b = new BufferedReader(new InputStreamReader(this.a, "UTF-8"));
    }

    @Override // java.io.Reader
    public String c() throws java.io.IOException {
        a();
        return this.b.readLine();
    }

    @Override // java.io.Reader
    public void close() throws java.io.IOException {
        if (this.b == null) {
            this.a.close();
        } else {
            this.b.close();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws java.io.IOException {
        a();
        return this.b.read(cArr, i, i2);
    }

    @Override // java.io.Reader
    public boolean ready() throws java.io.IOException {
        a();
        return this.b.ready();
    }
}
