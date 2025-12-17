package com.google.firebase.perf.util;

/* loaded from: classes2.dex */
public enum StorageUnit {

    TERABYTES(1099511627776, true),
    GIGABYTES(1073741824, 2),
    MEGABYTES(1048576, 3),
    KILOBYTES(1024, 4),
    BYTES(true, /* unknown */);

    long numBytes;
    @Override // java.lang.Enum
    public abstract long convert(long l, com.google.firebase.perf.util.StorageUnit storageUnit2);

    @Override // java.lang.Enum
    public long toBytes(long l) {
        return l *= numBytes;
    }

    @Override // java.lang.Enum
    public long toGigabytes(long l) {
        return obj3 /= numBytes2;
    }

    @Override // java.lang.Enum
    public long toKilobytes(long l) {
        return obj3 /= numBytes2;
    }

    @Override // java.lang.Enum
    public long toMegabytes(long l) {
        return obj3 /= numBytes2;
    }

    @Override // java.lang.Enum
    public long toTerabytes(long l) {
        return obj3 /= numBytes2;
    }
}
