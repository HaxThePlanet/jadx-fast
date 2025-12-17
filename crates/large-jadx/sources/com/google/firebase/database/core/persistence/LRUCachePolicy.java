package com.google.firebase.database.core.persistence;

/* loaded from: classes2.dex */
public class LRUCachePolicy implements com.google.firebase.database.core.persistence.CachePolicy {

    private static final long MAX_NUMBER_OF_PRUNABLE_QUERIES_TO_KEEP = 1000L;
    private static final float PERCENT_OF_QUERIES_TO_PRUNE_AT_ONCE = 0.2f;
    private static final long SERVER_UPDATES_BETWEEN_CACHE_SIZE_CHECKS = 1000L;
    public final long maxSizeBytes;
    public LRUCachePolicy(long l) {
        super();
        this.maxSizeBytes = l;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public long getMaxNumberOfQueriesToKeep() {
        return 1000;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public float getPercentOfQueriesToPruneAtOnce() {
        return 1045220557;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public boolean shouldCheckCacheSize(long l) {
        int obj3;
        obj3 = Long.compare(l, i) > 0 ? 1 : 0;
        return obj3;
    }

    @Override // com.google.firebase.database.core.persistence.CachePolicy
    public boolean shouldPrune(long l, long l2) {
        int obj3;
        if (Long.compare(l, maxSizeBytes) <= 0) {
            if (Long.compare(obj5, obj3) > 0) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }
}
