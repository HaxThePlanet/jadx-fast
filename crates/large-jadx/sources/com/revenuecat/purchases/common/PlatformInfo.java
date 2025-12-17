package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\u0008\u0005\u0010\u0004J&\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00022\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\u0008\u0008\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\n\u0010\u0004J\u0010\u0010\u000c\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0006\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0012\u001a\u0004\u0008\u0014\u0010\u0004¨\u0006\u0017", d2 = {"Lcom/revenuecat/purchases/common/PlatformInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "flavor", "version", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/PlatformInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFlavor", "getVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class PlatformInfo {

    private final String flavor;
    private final String version;
    public PlatformInfo(String string, String string2) {
        n.f(string, "flavor");
        super();
        this.flavor = string;
        this.version = string2;
    }

    public static com.revenuecat.purchases.common.PlatformInfo copy$default(com.revenuecat.purchases.common.PlatformInfo platformInfo, String string2, String string3, int i4, Object object5) {
        String obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = platformInfo.flavor;
        }
        if (i4 &= 2 != 0) {
            obj2 = platformInfo.version;
        }
        return platformInfo.copy(obj1, obj2);
    }

    public final String component1() {
        return this.flavor;
    }

    public final String component2() {
        return this.version;
    }

    public final com.revenuecat.purchases.common.PlatformInfo copy(String string, String string2) {
        n.f(string, "flavor");
        PlatformInfo platformInfo = new PlatformInfo(string, string2);
        return platformInfo;
    }

    public boolean equals(Object object) {
        boolean version;
        String flavor;
        Object obj3;
        if (this != (PlatformInfo)object && object instanceof PlatformInfo && n.b(this.flavor, object.flavor) && n.b(this.version, object.version)) {
            if (object instanceof PlatformInfo) {
                if (n.b(this.flavor, object.flavor)) {
                    if (n.b(this.version, object.version)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public final String getFlavor() {
        return this.flavor;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int i2;
        int i;
        String flavor = this.flavor;
        if (flavor != null) {
            i2 = flavor.hashCode();
        } else {
            i2 = i;
        }
        final String version = this.version;
        if (version != null) {
            i = version.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlatformInfo(flavor=");
        stringBuilder.append(this.flavor);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
