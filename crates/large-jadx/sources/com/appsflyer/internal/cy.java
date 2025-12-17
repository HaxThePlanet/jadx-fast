package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class cy extends FilterInputStream {

    private final int AFInAppEventParameterName;
    private long[] AFInAppEventType;
    private short AFKeystoreWrapper;
    private int AFLogger$LogLevel;
    private int AppsFlyer2dXConversionCallback;
    private int init = Integer.MAX_VALUE;
    private byte[] valueOf;
    private long[] values;
    public cy(InputStream inputStream, int i2, int i3, short s4, int i5, int i6) {
        super(inputStream);
        int obj2 = Integer.MAX_VALUE;
        obj2 = 4;
        int obj5 = Math.min(Math.max(s4, obj2), 8);
        this.AFInAppEventParameterName = obj5;
        this.valueOf = new byte[obj5];
        this.AFInAppEventType = new long[obj2];
        this.values = new long[obj2];
        this.AFLogger$LogLevel = obj5;
        this.AppsFlyer2dXConversionCallback = obj5;
        this.AFInAppEventType = cz.valueOf(i2 ^ i6, obj5 ^ i6);
        this.values = cz.valueOf(i3 ^ i6, i5 ^ i6);
    }

    private int AFInAppEventParameterName() {
        int init;
        int aFInAppEventParameterName2;
        int aFInAppEventParameterName;
        byte aFInAppEventParameterName3;
        int aFInAppEventParameterName4;
        int i;
        byte[] valueOf;
        int i2;
        if (this.init == Integer.MAX_VALUE) {
            this.init = this.in.read();
        }
        if (this.AFLogger$LogLevel == this.AFInAppEventParameterName) {
            int init2 = this.init;
            i = 0;
            this.valueOf[i] = (byte)init2;
            String str = "unexpected block size";
            if (init2 < 0) {
            } else {
                aFInAppEventParameterName = 1;
                aFInAppEventParameterName3 = this.in.read(this.valueOf, aFInAppEventParameterName, aFInAppEventParameterName6 -= aFInAppEventParameterName);
                while (aFInAppEventParameterName3 > 0) {
                    if (aFInAppEventParameterName += aFInAppEventParameterName3 < this.AFInAppEventParameterName) {
                    }
                    aFInAppEventParameterName3 = this.in.read(this.valueOf, aFInAppEventParameterName, aFInAppEventParameterName6 -= aFInAppEventParameterName);
                }
                if (aFInAppEventParameterName < this.AFInAppEventParameterName) {
                } else {
                    AFInAppEventType();
                    int read = this.in.read();
                    this.init = read;
                    this.AFLogger$LogLevel = i;
                    if (read < 0) {
                        int aFInAppEventParameterName5 = this.AFInAppEventParameterName;
                        aFInAppEventParameterName5 -= aFInAppEventParameterName;
                    } else {
                        aFInAppEventParameterName2 = this.AFInAppEventParameterName;
                    }
                    this.AppsFlyer2dXConversionCallback = aFInAppEventParameterName2;
                }
                IllegalStateException illegalStateException = new IllegalStateException(str);
                throw illegalStateException;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException(str);
            throw illegalStateException2;
        }
        return this.AppsFlyer2dXConversionCallback;
    }

    private void AFInAppEventType() {
        int i3;
        long[] valueOf;
        int i2;
        int i4;
        long l;
        int i;
        long[] aFInAppEventType = this.AFInAppEventType;
        valueOf = this.values;
        short aFKeystoreWrapper2 = this.AFKeystoreWrapper;
        int i16 = 2147483085;
        i17 %= 4;
        int i19 = Integer.MAX_VALUE;
        i7 %= 4;
        valueOf[i2] = i21 /= i19;
        aFInAppEventType[i2] = i12 %= i19;
        i3 = 0;
        while (i3 < this.AFInAppEventParameterName) {
            valueOf = this.valueOf;
            valueOf[i3] = (byte)i9;
            i3++;
        }
        this.AFKeystoreWrapper = (short)i6;
    }

    @Override // java.io.FilterInputStream
    public final int available() {
        AFInAppEventParameterName();
        return appsFlyer2dXConversionCallback -= aFLogger$LogLevel;
    }

    @Override // java.io.FilterInputStream
    public final boolean markSupported() {
        return 0;
    }

    @Override // java.io.FilterInputStream
    public final int read() {
        AFInAppEventParameterName();
        int aFLogger$LogLevel = this.AFLogger$LogLevel;
        if (aFLogger$LogLevel >= this.AppsFlyer2dXConversionCallback) {
            return -1;
        }
        this.AFLogger$LogLevel = aFLogger$LogLevel + 1;
        return b &= 255;
    }

    @Override // java.io.FilterInputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int i4;
        byte b;
        int i;
        byte[] valueOf;
        int i5;
        int i6 = i2 + i3;
        i4 = i2;
        while (i4 < i6) {
            AFInAppEventParameterName();
            int aFLogger$LogLevel = this.AFLogger$LogLevel;
            this.AFLogger$LogLevel = aFLogger$LogLevel + 1;
            bArr[i4] = this.valueOf[aFLogger$LogLevel];
            i4 = i;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream
    public final long skip(long l) {
        int i3;
        int i2;
        int read;
        int i;
        i3 = 0;
        while (Long.compare(i3, l) < 0) {
            if (read() != -1) {
            }
            i3 += i2;
        }
        return i3;
    }
}
