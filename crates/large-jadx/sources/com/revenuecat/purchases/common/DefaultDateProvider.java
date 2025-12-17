package com.revenuecat.purchases.common;

import java.util.Date;
import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0008", d2 = {"Lcom/revenuecat/purchases/common/DefaultDateProvider;", "Lcom/revenuecat/purchases/common/DateProvider;", "Ljava/util/Date;", "getNow", "()Ljava/util/Date;", "now", "<init>", "()V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class DefaultDateProvider implements com.revenuecat.purchases.common.DateProvider {
    @Override // com.revenuecat.purchases.common.DateProvider
    public Date getNow() {
        Date date = new Date();
        return date;
    }
}
