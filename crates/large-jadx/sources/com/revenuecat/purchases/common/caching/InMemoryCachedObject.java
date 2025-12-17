package com.revenuecat.purchases.common.caching;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import java.util.Date;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\u0008\u001b\u0010\u001cJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\u0005J\u0015\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\u0008\u0008\u0010\tJ\u0015\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\u000c\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\r¨\u0006\u001d", d2 = {"Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;", "T", "", "Lkotlin/w;", "clearCacheTimestamp", "()V", "clearCache", "instance", "cacheInstance", "(Ljava/lang/Object;)V", "Ljava/util/Date;", "date", "updateCacheTimestamp", "(Ljava/util/Date;)V", "cachedInstance", "Ljava/lang/Object;", "getCachedInstance", "()Ljava/lang/Object;", "setCachedInstance", "Lcom/revenuecat/purchases/common/DateProvider;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "lastUpdatedAt", "Ljava/util/Date;", "getLastUpdatedAt$common_release", "()Ljava/util/Date;", "setLastUpdatedAt$common_release", "<init>", "(Ljava/util/Date;Lcom/revenuecat/purchases/common/DateProvider;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class InMemoryCachedObject<T>  {

    private T cachedInstance;
    private final DateProvider dateProvider;
    private Date lastUpdatedAt;
    public InMemoryCachedObject() {
        final int i = 0;
        super(i, i, 3, i);
    }

    public InMemoryCachedObject(Date date, DateProvider dateProvider2) {
        n.f(dateProvider2, "dateProvider");
        super();
        this.lastUpdatedAt = date;
        this.dateProvider = dateProvider2;
    }

    public InMemoryCachedObject(Date date, DateProvider dateProvider2, int i3, g g4) {
        int obj1;
        DefaultDateProvider obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        if (i3 &= 2 != 0) {
            obj2 = new DefaultDateProvider();
        }
        super(obj1, obj2);
    }

    public final void cacheInstance(T t) {
        this.cachedInstance = t;
        this.lastUpdatedAt = this.dateProvider.getNow();
    }

    public final void clearCache() {
        clearCacheTimestamp();
        this.cachedInstance = 0;
    }

    public final void clearCacheTimestamp() {
        this.lastUpdatedAt = 0;
    }

    public final T getCachedInstance() {
        return this.cachedInstance;
    }

    public final Date getLastUpdatedAt$common_release() {
        return this.lastUpdatedAt;
    }

    public final void setCachedInstance(T t) {
        this.cachedInstance = t;
    }

    public final void setLastUpdatedAt$common_release(Date date) {
        this.lastUpdatedAt = date;
    }

    public final void updateCacheTimestamp(Date date) {
        n.f(date, "date");
        this.lastUpdatedAt = date;
    }
}
