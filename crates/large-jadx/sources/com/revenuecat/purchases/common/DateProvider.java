package com.revenuecat.purchases.common;

import java.util.Date;
import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0006", d2 = {"Lcom/revenuecat/purchases/common/DateProvider;", "", "Ljava/util/Date;", "getNow", "()Ljava/util/Date;", "now", "common_release"}, k = 1, mv = {1, 4, 0})
public interface DateProvider {
    public abstract Date getNow();
}
