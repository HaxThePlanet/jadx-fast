package com.google.firebase.firestore.core;

import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public class TargetIdGenerator {

    private static final int QUERY_CACHE_ID = 0;
    private static final int RESERVED_BITS = 1;
    private static final int SYNC_ENGINE_ID = 1;
    private int generatorId;
    private int nextId;
    TargetIdGenerator(int i, int i2) {
        int i3;
        super();
        int i5 = 0;
        final int i6 = 1;
        i3 = i & 1 == i ? i6 : i5;
        Object[] arr = new Object[2];
        arr[i5] = Integer.valueOf(i);
        arr[i6] = Integer.valueOf(i6);
        Assert.hardAssert(i3, "Generator ID %d contains more than %d reserved bits", arr);
        this.generatorId = i;
        seek(i2);
    }

    public static com.google.firebase.firestore.core.TargetIdGenerator forSyncEngine() {
        final int i = 1;
        TargetIdGenerator targetIdGenerator = new TargetIdGenerator(i, i);
        return targetIdGenerator;
    }

    public static com.google.firebase.firestore.core.TargetIdGenerator forTargetCache(int i) {
        TargetIdGenerator targetIdGenerator = new TargetIdGenerator(0, i);
        targetIdGenerator.nextId();
        return targetIdGenerator;
    }

    private void seek(int i) {
        int i2;
        int i4 = 0;
        i2 = i & 1 == this.generatorId ? 1 : i4;
        Assert.hardAssert(i2, "Cannot supply target ID from different generator ID", new Object[i4]);
        this.nextId = i;
    }

    public int nextId() {
        final int nextId = this.nextId;
        this.nextId = nextId + 2;
        return nextId;
    }
}
