package net.time4j.h1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;

/* loaded from: classes3.dex */
class g extends Reader {

    private final PushbackInputStream a;
    private BufferedReader b = null;
    g(InputStream inputStream) {
        super();
        int i = 0;
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 3);
        this.a = pushbackInputStream;
    }

    private void a() {
        int i2;
        int i;
        int i3;
        if (this.b != null) {
        }
        i2 = 3;
        byte[] bArr = new byte[i2];
        int i5 = 0;
        int read = this.a.read(bArr, i5, i2);
        if (read == i2 && bArr[i5] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            if (bArr[i5] == -17) {
                if (bArr[i] == -69) {
                    if (bArr[2] == -65) {
                    } else {
                        i = i5;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i == 0 && read > 0) {
            if (read > 0) {
                this.a.unread(bArr, i5, read);
            }
        }
        InputStreamReader inputStreamReader = new InputStreamReader(this.a, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        this.b = bufferedReader;
    }

    @Override // java.io.Reader
    public String c() {
        a();
        return this.b.readLine();
    }

    @Override // java.io.Reader
    public void close() {
        Object reader;
        reader = this.b;
        if (reader == null) {
            this.a.close();
        } else {
            reader.close();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i2, int i3) {
        a();
        return this.b.read(cArr, i2, i3);
    }

    @Override // java.io.Reader
    public boolean ready() {
        a();
        return this.b.ready();
    }
}
