package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0008\u001a\u00020\u0002\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00022\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\u0008\n\u0010\u000bJ\u0010\u0010\u000c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\u0008\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0011\u0010\u0012R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0007R\u0019\u0010\u0008\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0004¨\u0006\u0019", d2 = {"Lcom/revenuecat/purchases/UpgradeInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "oldSku", "prorationMode", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/revenuecat/purchases/UpgradeInfo;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getProrationMode", "Ljava/lang/String;", "getOldSku", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
public final class UpgradeInfo {

    private final String oldSku;
    private final Integer prorationMode;
    public UpgradeInfo(String string, Integer integer2) {
        n.f(string, "oldSku");
        super();
        this.oldSku = string;
        this.prorationMode = integer2;
    }

    public UpgradeInfo(String string, Integer integer2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(string, obj2);
    }

    public static com.revenuecat.purchases.UpgradeInfo copy$default(com.revenuecat.purchases.UpgradeInfo upgradeInfo, String string2, Integer integer3, int i4, Object object5) {
        String obj1;
        Integer obj2;
        if (i4 & 1 != 0) {
            obj1 = upgradeInfo.oldSku;
        }
        if (i4 &= 2 != 0) {
            obj2 = upgradeInfo.prorationMode;
        }
        return upgradeInfo.copy(obj1, obj2);
    }

    public final String component1() {
        return this.oldSku;
    }

    public final Integer component2() {
        return this.prorationMode;
    }

    public final com.revenuecat.purchases.UpgradeInfo copy(String string, Integer integer2) {
        n.f(string, "oldSku");
        UpgradeInfo upgradeInfo = new UpgradeInfo(string, integer2);
        return upgradeInfo;
    }

    public boolean equals(Object object) {
        boolean prorationMode;
        String oldSku;
        Object obj3;
        if (this != (UpgradeInfo)object && object instanceof UpgradeInfo && n.b(this.oldSku, object.oldSku) && n.b(this.prorationMode, object.prorationMode)) {
            if (object instanceof UpgradeInfo) {
                if (n.b(this.oldSku, object.oldSku)) {
                    if (n.b(this.prorationMode, object.prorationMode)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final String getOldSku() {
        return this.oldSku;
    }

    public final Integer getProrationMode() {
        return this.prorationMode;
    }

    public int hashCode() {
        int i2;
        int i;
        String oldSku = this.oldSku;
        if (oldSku != null) {
            i2 = oldSku.hashCode();
        } else {
            i2 = i;
        }
        final Integer prorationMode = this.prorationMode;
        if (prorationMode != null) {
            i = prorationMode.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UpgradeInfo(oldSku=");
        stringBuilder.append(this.oldSku);
        stringBuilder.append(", prorationMode=");
        stringBuilder.append(this.prorationMode);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
