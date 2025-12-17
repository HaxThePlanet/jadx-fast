package app.dogo.com.dogo_android.repository.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferRemoteConfig;", "", "offers", "", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "(Ljava/util/List;)V", "getOffers", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SpecialOfferRemoteConfig {

    private final List<app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon> offers;
    public SpecialOfferRemoteConfig(List<app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon> list) {
        super();
        this.offers = list;
    }

    public static app.dogo.com.dogo_android.repository.domain.SpecialOfferRemoteConfig copy$default(app.dogo.com.dogo_android.repository.domain.SpecialOfferRemoteConfig specialOfferRemoteConfig, List list2, int i3, Object object4) {
        List obj1;
        if (i3 &= 1 != 0) {
            obj1 = specialOfferRemoteConfig.offers;
        }
        return specialOfferRemoteConfig.copy(obj1);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon> component1() {
        return this.offers;
    }

    public final app.dogo.com.dogo_android.repository.domain.SpecialOfferRemoteConfig copy(List<app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon> list) {
        SpecialOfferRemoteConfig specialOfferRemoteConfig = new SpecialOfferRemoteConfig(list);
        return specialOfferRemoteConfig;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SpecialOfferRemoteConfig) {
            return i2;
        }
        if (!n.b(this.offers, object.offers)) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon> getOffers() {
        return this.offers;
    }

    public int hashCode() {
        int i;
        List offers = this.offers;
        if (offers == null) {
            i = 0;
        } else {
            i = offers.hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpecialOfferRemoteConfig(offers=");
        stringBuilder.append(this.offers);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
