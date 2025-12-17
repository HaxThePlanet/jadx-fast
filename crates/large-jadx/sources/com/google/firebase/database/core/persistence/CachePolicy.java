package com.google.firebase.database.core.persistence;

/* loaded from: classes2.dex */
public interface CachePolicy {

    public static final com.google.firebase.database.core.persistence.CachePolicy NONE;
    static {
        CachePolicy.1 anon = new CachePolicy.1();
        CachePolicy.NONE = anon;
    }

    public abstract long getMaxNumberOfQueriesToKeep();

    public abstract float getPercentOfQueriesToPruneAtOnce();

    public abstract boolean shouldCheckCacheSize(long l);

    public abstract boolean shouldPrune(long l, long l2);
}
