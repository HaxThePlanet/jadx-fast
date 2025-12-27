package com.bumptech.glide.t;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionPassthroughInputStream.java */
/* loaded from: classes.dex */
public final class d extends InputStream {

    private static final Queue<d> c;
    private InputStream a;
    private IOException b;
    static {
        d.c = l.e(0);
    }

    d() {
        super();
    }

    public static d c(InputStream inputStream) {
        Object poll;
        final Queue queue = d.c;
        synchronized (queue) {
            try {
            } catch (Throwable th) {
            }
        }
        if ((d)queue.poll() == null) {
            com.bumptech.glide.t.d dVar = new d();
        }
        poll.f(th);
        return poll;
    }

    @Override // java.io.InputStream
    public IOException a() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.a.available();
    }

    @Override // java.io.InputStream
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public void e() {
        IOException iOException = null;
        this.b = iOException;
        this.a = iOException;
        Queue queue = d.c;
        synchronized (queue) {
            try {
                queue.offer(this);
                return;
            } catch (Throwable th) {
            }
            throw th;
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
        } catch (java.io.IOException ioException) {
            this.b = ioException;
            throw ioException;
        }
        return this.a.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
        } catch (java.io.IOException ioException) {
            this.b = ioException;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) ioException;
        }
        return this.a.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
        } catch (java.io.IOException ioException) {
            this.b = ioException;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) ioException;
        }
        return this.a.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
        } catch (java.io.IOException ioException) {
            this.b = ioException;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) ioException;
        }
        return this.a.read(bArr, i, i2);
    }
}
