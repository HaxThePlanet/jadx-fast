package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class cx extends FilterInputStream {

    private static final int[] AFInAppEventParameterName;
    private static final int[] AFInAppEventType;
    private static final byte[] AFKeystoreWrapper;
    private static final int[] valueOf;
    private static final int[] values;
    private final byte[][] AFLogger$LogLevel;
    private final int[] AFVersionDeclaration;
    private final int AppsFlyer2dXConversionCallback;
    private final byte[] getLevel;
    private final int[] init;
    private final byte[] onAttributionFailureNative;
    private int onDeepLinkingNative = 16;
    private int onInstallConversionDataLoadedNative = Integer.MAX_VALUE;
    private int onInstallConversionFailureNative = 16;
    static {
        cx.AFKeystoreWrapper = da.AFKeystoreWrapper;
        cx.valueOf = da.values;
        cx.values = da.AFInAppEventParameterName;
        cx.AFInAppEventParameterName = da.AFInAppEventType;
        cx.AFInAppEventType = da.valueOf;
    }

    public cx(InputStream inputStream, int i2, byte[] b3Arr3, byte[][] b4Arr4Arr4) {
        super(inputStream);
        this.init = new int[4];
        int obj2 = 16;
        this.getLevel = new byte[obj2];
        this.onAttributionFailureNative = new byte[obj2];
        int i = Integer.MAX_VALUE;
        this.AppsFlyer2dXConversionCallback = i2;
        this.AFVersionDeclaration = da.valueOf(b3Arr3, i2);
        this.AFLogger$LogLevel = cx.AFInAppEventType(b4Arr4Arr4);
    }

    private void AFInAppEventParameterName(byte[] bArr, byte[] b2Arr2) {
        int i2;
        int i11;
        int i9;
        int i;
        int i5;
        int i10;
        int i3;
        int i8;
        int i7;
        int init;
        int i4;
        int[] aFInAppEventParameterName;
        int[] values;
        byte[] bArr2;
        int i6;
        final Object obj = this;
        int[] init2 = obj.init;
        int i14 = 0;
        i9 = 1;
        int i63 = 2;
        final int i67 = 8;
        int i66 = 3;
        int[] aFVersionDeclaration2 = obj.AFVersionDeclaration;
        init2[i14] = i33 ^= i72;
        i11 = 4;
        init2[i9] = i76 ^= i195;
        init2[i63] = i81 ^= i211;
        final int i219 = 13;
        init2[i66] = i69 ^= i5;
        i = i11;
        i2 = i9;
        while (i2 < obj.AppsFlyer2dXConversionCallback) {
            int[] valueOf = cx.valueOf;
            init = obj.init;
            byte[][] aFLogger$LogLevel2 = obj.AFLogger$LogLevel;
            values = cx.values;
            aFInAppEventParameterName = cx.AFInAppEventParameterName;
            int[] aFInAppEventType = cx.AFInAppEventType;
            int[] aFVersionDeclaration3 = obj.AFVersionDeclaration;
            init[i14] = i174 ^= i225;
            init[1] = i52 ^= i100;
            init[i63] = i59 ^= i112;
            init[i66] = i91 ^= i128;
            i2++;
            i += 4;
            i11 = 4;
            i9 = 1;
            i10 = 5;
            i3 = 6;
            i8 = 7;
            i7 = 9;
            i4 = 15;
        }
        int[] aFVersionDeclaration = obj.AFVersionDeclaration;
        int i35 = aFVersionDeclaration[i];
        byte[] aFKeystoreWrapper = cx.AFKeystoreWrapper;
        int[] init3 = obj.init;
        byte[][] aFLogger$LogLevel = obj.AFLogger$LogLevel;
        b2Arr2[i14] = (byte)i134;
        int i135 = 1;
        b2Arr2[i135] = (byte)i182;
        b2Arr2[i63] = (byte)i139;
        b2Arr2[i66] = (byte)i36;
        int i38 = aFVersionDeclaration[i + 1];
        int i184 = 1;
        b2Arr2[4] = (byte)i144;
        b2Arr2[5] = (byte)i148;
        b2Arr2[6] = (byte)i152;
        b2Arr2[7] = (byte)i39;
        int i41 = aFVersionDeclaration[i + 2];
        b2Arr2[i67] = (byte)i158;
        b2Arr2[9] = (byte)i163;
        b2Arr2[10] = (byte)i167;
        b2Arr2[11] = (byte)i42;
        int i12 = aFVersionDeclaration[i += i66];
        b2Arr2[12] = (byte)i17;
        b2Arr2[i219] = (byte)i22;
        b2Arr2[14] = (byte)i26;
        b2Arr2[15] = (byte)i13;
    }

    private static byte[][] AFInAppEventType(byte[][] bArrArr) {
        int i;
        int i2;
        int length;
        byte b;
        byte b2;
        byte[][] bArr = new byte[bArrArr.length];
        final int i3 = 0;
        i = i3;
        for (Object obj3 : bArrArr) {
            bArr[i] = new byte[obj.length];
            i2 = i3;
            while (i2 < obj2.length) {
                bArr[i][obj3[i2]] = (byte)i2;
                i2++;
            }
            bArr[i][obj3[i2]] = (byte)i2;
            i2++;
        }
        return bArr;
    }

    private int valueOf() {
        int onInstallConversionDataLoadedNative;
        int onInstallConversionFailureNative;
        int i2;
        int i3;
        byte[] onAttributionFailureNative;
        byte read;
        int i;
        byte[] getLevel;
        int i4;
        if (this.onInstallConversionDataLoadedNative == Integer.MAX_VALUE) {
            this.onInstallConversionDataLoadedNative = this.in.read();
        }
        i2 = 16;
        if (this.onInstallConversionFailureNative == i2) {
            int onInstallConversionDataLoadedNative2 = this.onInstallConversionDataLoadedNative;
            i = 0;
            this.getLevel[i] = (byte)onInstallConversionDataLoadedNative2;
            String str = "unexpected block size";
            if (onInstallConversionDataLoadedNative2 < 0) {
            } else {
                i3 = 1;
                read = this.in.read(this.getLevel, i3, i3 - 16);
                while (read > 0) {
                    if (i3 += read < i2) {
                    }
                    read = this.in.read(this.getLevel, i3, i3 - 16);
                }
                if (i3 < i2) {
                } else {
                    AFInAppEventParameterName(this.getLevel, this.onAttributionFailureNative);
                    onInstallConversionFailureNative = this.in.read();
                    this.onInstallConversionDataLoadedNative = onInstallConversionFailureNative;
                    this.onInstallConversionFailureNative = i;
                    if (onInstallConversionFailureNative < 0) {
                        i2 -= onInstallConversionFailureNative;
                    }
                    this.onDeepLinkingNative = i2;
                }
                IllegalStateException illegalStateException2 = new IllegalStateException(str);
                throw illegalStateException2;
            }
            IllegalStateException illegalStateException = new IllegalStateException(str);
            throw illegalStateException;
        }
        return this.onDeepLinkingNative;
    }

    @Override // java.io.FilterInputStream
    public final int available() {
        valueOf();
        return onDeepLinkingNative -= onInstallConversionFailureNative;
    }

    @Override // java.io.FilterInputStream
    public final void close() {
        super.close();
    }

    @Override // java.io.FilterInputStream
    public final void mark(int i) {
        return;
        synchronized (this) {
        }
    }

    @Override // java.io.FilterInputStream
    public final boolean markSupported() {
        return 0;
    }

    @Override // java.io.FilterInputStream
    public final int read() {
        valueOf();
        int onInstallConversionFailureNative = this.onInstallConversionFailureNative;
        if (onInstallConversionFailureNative >= this.onDeepLinkingNative) {
            return -1;
        }
        this.onInstallConversionFailureNative = onInstallConversionFailureNative + 1;
        return b &= 255;
    }

    @Override // java.io.FilterInputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream
    public final int read(byte[] bArr, int i2, int i3) {
        int i;
        byte b;
        int i4;
        byte[] onAttributionFailureNative;
        int i5;
        int i6 = i2 + i3;
        i = i2;
        while (i < i6) {
            valueOf();
            int onInstallConversionFailureNative = this.onInstallConversionFailureNative;
            this.onInstallConversionFailureNative = onInstallConversionFailureNative + 1;
            bArr[i] = this.onAttributionFailureNative[onInstallConversionFailureNative];
            i = i4;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream
    public final void reset() {
        return;
        synchronized (this) {
        }
    }

    @Override // java.io.FilterInputStream
    public final long skip(long l) {
        int i;
        int i2;
        int read;
        int i3;
        i = 0;
        while (Long.compare(i, l) < 0) {
            if (read() != -1) {
            }
            i += i2;
        }
        return i;
    }
}
