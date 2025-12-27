package app.dogo.com.dogo_android.repository.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SpecialOfferRemoteConfig.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferRemoteConfig;", "", "offers", "", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "(Ljava/util/List;)V", "getOffers", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SpecialOfferRemoteConfig {

    private final List<SpecialOfferCoupon> offers;
    public SpecialOfferRemoteConfig(List<SpecialOfferCoupon> list) {
        super();
        this.offers = list;
    }

    public final List<SpecialOfferCoupon> getOffers() {
        return this.offers;
    }

    public static /* synthetic */ SpecialOfferRemoteConfig copy$default(SpecialOfferRemoteConfig specialOfferRemoteConfig, List list, int i, Object object) {
        List offers2;
        if (i & 1 != 0) {
        }
        return specialOfferRemoteConfig.copy(offers2);
    }

    /* operator */ public final List<SpecialOfferCoupon> component1() {
        return this.offers;
    }

    public final SpecialOfferRemoteConfig copy(List<SpecialOfferCoupon> offers) {
        return new SpecialOfferRemoteConfig(offers);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof SpecialOfferRemoteConfig)) {
            return false;
        }
        return !n.b(this.offers, other.offers) ? z3 : z;
    }

    public int hashCode() {
        int i = 0;
        if (this.offers == null) {
            i = 0;
        } else {
            i = this.offers.hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SpecialOfferRemoteConfig(offers=";
        str = str2 + this.offers + 41;
        return str;
    }
}
