package com.bumptech.glide.t;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes.dex */
public final class d extends InputStream {

    private static final Queue<com.bumptech.glide.t.d> c;
    private InputStream a;
    private IOException b;
    static {
        d.c = l.e(0);
    }

    public static com.bumptech.glide.t.d c(InputStream inputStream) {
        Object dVar;
        final Queue queue = d.c;
        synchronized (queue) {
            queue = d.c;
        }
        dVar = new d();
        dVar.f(inputStream);
        return dVar;
    }

    @Override // java.io.InputStream
    public IOException a() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.a.available();
    }

    @Override // java.io.InputStream
    public void close() {
        this.a.close();
    }

    @Override // java.io.InputStream
    public void e() {
        int i = 0;
        this.b = i;
        this.a = i;
        Queue queue = d.c;
        queue.offer(this);
        return;
        synchronized (queue) {
            i = 0;
            this.b = i;
            this.a = i;
            queue = d.c;
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    void f(InputStream inputStream) {
        this.a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.a.read();
            this.b = th;
            throw th;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.a.read(bArr);
            this.b = bArr;
            throw bArr;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.a.read(bArr, i2, i3);
            this.b = bArr;
            throw bArr;
        }
    }

    @Override // java.io.InputStream
    public void reset() {
        this.a.reset();
        return;
        synchronized (this) {
            this.a.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long l) {
        try {
            return this.a.skip(l);
            this.b = l;
            throw l;
        }
    }
}
