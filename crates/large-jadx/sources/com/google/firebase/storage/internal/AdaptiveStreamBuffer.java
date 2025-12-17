package com.google.firebase.storage.internal;

import android.util.Log;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class AdaptiveStreamBuffer {

    private static final String TAG = "AdaptiveStreamBuffer";
    private static final java.lang.Runtime runtime;
    private boolean adaptiveMode = true;
    private int availableBytes = 0;
    private byte[] buffer;
    private boolean reachedEnd = false;
    private final InputStream source;
    static {
        AdaptiveStreamBuffer.runtime = Runtime.getRuntime();
    }

    public AdaptiveStreamBuffer(InputStream inputStream, int i2) {
        super();
        this.source = inputStream;
        this.buffer = new byte[i2];
        int obj1 = 0;
        final int obj2 = 1;
    }

    private int resize(int i) {
        int adaptiveMode;
        byte[] buffer;
        int availableBytes;
        long l;
        byte[] obj8;
        obj8 = Math.max(length *= 2, i);
        java.lang.Runtime runtime = AdaptiveStreamBuffer.runtime;
        if (this.adaptiveMode && Long.compare(l, availableBytes) < 0) {
            if (Long.compare(l, availableBytes) < 0) {
                adaptiveMode = 0;
                obj8 = new byte[obj8];
                System.arraycopy(this.buffer, adaptiveMode, obj8, adaptiveMode, this.availableBytes);
                this.buffer = obj8;
            } else {
                Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing to conserve memory.");
            }
        } else {
        }
        return obj8.length;
    }

    public int advance(int i) {
        int availableBytes;
        int i2;
        int buffer;
        int obj5;
        availableBytes = this.availableBytes;
        i2 = 0;
        if (i <= availableBytes) {
            availableBytes -= i;
            this.availableBytes = availableBytes;
            buffer = this.buffer;
            System.arraycopy(buffer, i, buffer, i2, availableBytes);
        } else {
            this.availableBytes = i2;
            while (i2 < i) {
                availableBytes = (int)buffer;
                if (availableBytes <= 0) {
                    break;
                } else {
                }
                if (availableBytes == 0) {
                    break;
                } else {
                }
                if (this.source.read() == -1) {
                    break;
                } else {
                }
                i2++;
                i2 += availableBytes;
            }
            obj5 = i2;
        }
        return obj5;
    }

    public int available() {
        return this.availableBytes;
    }

    public void close() {
        this.source.close();
    }

    public int fill(int i) {
        int availableBytes;
        int i2;
        byte[] buffer;
        int i3;
        int obj5;
        if (i > buffer2.length) {
            obj5 = Math.min(i, resize(i));
        }
        availableBytes = this.availableBytes;
        while (availableBytes < obj5) {
            availableBytes = this.source.read(this.buffer, availableBytes, obj5 - availableBytes);
            if (availableBytes == -1) {
                break;
            } else {
            }
            this.availableBytes = availableBytes2 += availableBytes;
            availableBytes = this.availableBytes;
        }
        return this.availableBytes;
    }

    public byte[] get() {
        return this.buffer;
    }

    public boolean isFinished() {
        return this.reachedEnd;
    }
}
