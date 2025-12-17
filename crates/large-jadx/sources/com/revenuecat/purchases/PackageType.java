package com.revenuecat.purchases;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\u0008\u0010\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\u0008\u0002\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011¨\u0006\u0012", d2 = {"Lcom/revenuecat/purchases/PackageType;", "", "", "identifier", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "UNKNOWN", "CUSTOM", "LIFETIME", "ANNUAL", "SIX_MONTH", "THREE_MONTH", "TWO_MONTH", "MONTHLY", "WEEKLY", "public_release"}, k = 1, mv = {1, 4, 0})
public enum PackageType {

    UNKNOWN(false),
    CUSTOM(false),
    LIFETIME(false),
    ANNUAL(false),
    SIX_MONTH(false),
    THREE_MONTH(false),
    TWO_MONTH(false),
    MONTHLY(false),
    WEEKLY(false);

    private final String identifier;
    @Override // java.lang.Enum
    public final String getIdentifier() {
        return this.identifier;
    }
}
