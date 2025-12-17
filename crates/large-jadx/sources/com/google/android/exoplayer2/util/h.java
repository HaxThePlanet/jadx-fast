package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class h {

    private final File a;
    private final File b;

    private static final class a extends OutputStream {

        private final FileOutputStream a;
        private boolean b = false;
        public a(File file) {
            super();
            int i = 0;
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.a = fileOutputStream;
        }

        @Override // java.io.OutputStream
        public void close() {
            FileDescriptor fileDescriptor;
            String str;
            String str2;
            if (this.b) {
            }
            this.b = true;
            flush();
            this.a.getFD().sync();
            this.a.close();
        }

        @Override // java.io.OutputStream
        public void flush() {
            this.a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.a.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            this.a.write(bArr, i2, i3);
        }
    }
    public h(File file) {
        super();
        this.a = file;
        File file2 = new File(String.valueOf(file.getPath()).concat(".bak"));
        this.b = file2;
    }

    private void e() {
        boolean exists;
        File file;
        if (this.b.exists()) {
            this.a.delete();
            this.b.renameTo(this.a);
        }
    }

    public void a() {
        this.a.delete();
        this.b.delete();
    }

    public void b(OutputStream outputStream) {
        outputStream.close();
        this.b.delete();
    }

    public boolean c() {
        int i;
        boolean exists;
        if (!this.a.exists()) {
            if (this.b.exists()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public InputStream d() {
        e();
        FileInputStream fileInputStream = new FileInputStream(this.a);
        return fileInputStream;
    }

    public OutputStream f() {
        boolean renameTo;
        com.google.android.exoplayer2.util.h.a aVar;
        File iOException;
        File file;
        String string;
        Object stringBuilder;
        if (this.a.exists()) {
            if (!this.b.exists()) {
                if (!this.a.renameTo(this.b)) {
                    String valueOf = String.valueOf(this.a);
                    String valueOf2 = String.valueOf(this.b);
                    stringBuilder = new StringBuilder(i += length2);
                    stringBuilder.append("Couldn't rename file ");
                    stringBuilder.append(valueOf);
                    stringBuilder.append(" to backup file ");
                    stringBuilder.append(valueOf2);
                    v.h("AtomicFile", stringBuilder.toString());
                }
            } else {
                this.a.delete();
            }
        }
        aVar = new h.a(this.a);
        return aVar;
    }
}
