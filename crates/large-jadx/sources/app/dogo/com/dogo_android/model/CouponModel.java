package app.dogo.com.dogo_android.model;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: CouponModel.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B5\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0008J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\n¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/model/CouponModel;", "", "discount", "", "offerDurationMs", "offeringId", "", "couponId", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getCouponId", "()Ljava/lang/String;", "setCouponId", "(Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOfferDurationMs", "getOfferingId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lapp/dogo/com/dogo_android/model/CouponModel;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CouponModel {

    private String couponId;
    private final Long discount;
    private final Long offerDurationMs;
    private final String offeringId;
    public CouponModel(Long long, Long long2, String str, String str2) {
        super();
        this.discount = long;
        this.offerDurationMs = long2;
        this.offeringId = str;
        this.couponId = str2;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final Long getDiscount() {
        return this.discount;
    }

    public final Long getOfferDurationMs() {
        return this.offerDurationMs;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final void setCouponId(String str) {
        this.couponId = str;
    }

    public /* synthetic */ CouponModel(Long long, Long long2, String str, String str2, int i, g gVar) {
        Long l;
        Long l2;
        i = 0;
        i = i & 1 != 0 ? i : i;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        i = i & 8 != 0 ? i : i;
        this(l, l2, str, str2);
    }

    public CouponModel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CouponModel copy$default(CouponModel couponModel, Long long, Long long2, String str, String str2, int i, Object object) {
        Long discount2;
        Long offerDurationMs2;
        String offeringId2;
        String couponId2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return couponModel.copy(discount2, offerDurationMs2, offeringId2, couponId2);
    }

    /* operator */ public final Long component1() {
        return this.discount;
    }

    /* operator */ public final Long component2() {
        return this.offerDurationMs;
    }

    /* operator */ public final String component3() {
        return this.offeringId;
    }

    /* operator */ public final String component4() {
        return this.couponId;
    }

    public final CouponModel copy(Long discount, Long offerDurationMs, String offeringId, String couponId) {
        return new CouponModel(discount, offerDurationMs, offeringId, couponId);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z6 = false;
        if (!(other instanceof CouponModel)) {
            return false;
        }
        if (!n.b(this.discount, other.discount)) {
            return false;
        }
        if (!n.b(this.offerDurationMs, other.offerDurationMs)) {
            return false;
        }
        if (!n.b(this.offeringId, other.offeringId)) {
            return false;
        }
        return !n.b(this.couponId, other.couponId) ? z6 : z;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.discount == null) {
        } else {
            i = this.discount.hashCode();
        }
        if (this.offerDurationMs == null) {
        } else {
            i = this.offerDurationMs.hashCode();
        }
        if (this.offeringId == null) {
        } else {
            i = this.offeringId.hashCode();
        }
        if (this.couponId != null) {
            i = this.couponId.hashCode();
        }
        return (i * 31) + i * 31 + i * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CouponModel(discount=";
        String str3 = ", offerDurationMs=";
        String str4 = ", offeringId=";
        String str5 = ", couponId=";
        str = str2 + this.discount + str3 + this.offerDurationMs + str4 + this.offeringId + str5 + this.couponId + 41;
        return str;
    }
}
