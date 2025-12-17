package com.revenuecat.purchases.common.attribution;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0008\n\u0002\u0008\r\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000e¨\u0006\u000f", d2 = {"Lcom/revenuecat/purchases/common/attribution/AttributionNetwork;", "", "", "serverValue", "I", "getServerValue", "()I", "<init>", "(Ljava/lang/String;II)V", "ADJUST", "APPSFLYER", "BRANCH", "TENJIN", "FACEBOOK", "MPARTICLE", "common_release"}, k = 1, mv = {1, 4, 0})
public enum AttributionNetwork {

    ADJUST(true),
    APPSFLYER(false),
    BRANCH(true),
    TENJIN(false),
    FACEBOOK(true),
    MPARTICLE(6);

    private final int serverValue;
    @Override // java.lang.Enum
    public final int getServerValue() {
        return this.serverValue;
    }
}
