package com.revenuecat.purchases.common;

import com.revenuecat.purchases.models.ProductDetails;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0010\u0006\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B-\u0012\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000f\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\u0008&\u0010'J\u001a\u0010\u0004\u001a\u00020\u00032\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\n\u0010\u000bR\u001b\u0010\u000c\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u000e\u0010\u000bR\u001f\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\t0\u000f8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u0011\u001a\u0004\u0008\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0014\u0010\r\u001a\u0004\u0008\u0015\u0010\u000bR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001b\u0010\r\u001a\u0004\u0008\u001c\u0010\u000bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001d\u0010\r\u001a\u0004\u0008\u001e\u0010\u000bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001f\u0010\r\u001a\u0004\u0008 \u0010\u000bR\u001b\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010#\u001a\u0004\u0008$\u0010%¨\u0006(", d2 = {"Lcom/revenuecat/purchases/common/ReceiptInfo;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "trialDuration", "Ljava/lang/String;", "getTrialDuration", "", "productIDs", "Ljava/util/List;", "getProductIDs", "()Ljava/util/List;", "offeringIdentifier", "getOfferingIdentifier", "", "price", "Ljava/lang/Double;", "getPrice", "()Ljava/lang/Double;", "duration", "getDuration", "introDuration", "getIntroDuration", "currency", "getCurrency", "Lcom/revenuecat/purchases/models/ProductDetails;", "productDetails", "Lcom/revenuecat/purchases/models/ProductDetails;", "getProductDetails", "()Lcom/revenuecat/purchases/models/ProductDetails;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/revenuecat/purchases/models/ProductDetails;)V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class ReceiptInfo {

    private final String currency;
    private final String duration;
    private final String introDuration;
    private final String offeringIdentifier;
    private final Double price;
    private final ProductDetails productDetails;
    private final List<String> productIDs;
    private final String trialDuration;
    public ReceiptInfo(List<String> list, String string2, ProductDetails productDetails3) {
        String str;
        String introductoryPricePeriod;
        double d;
        int obj5;
        int obj6;
        Object obj7;
        n.f(list, "productIDs");
        super();
        this.productIDs = list;
        this.offeringIdentifier = string2;
        this.productDetails = productDetails3;
        obj5 = 0;
        if (productDetails3 != null) {
            obj6 = Double.valueOf(d2 /= d);
        } else {
            obj6 = obj5;
        }
        this.price = obj6;
        if (productDetails3 != null) {
            obj6 = productDetails3.getPriceCurrencyCode();
        } else {
            obj6 = obj5;
        }
        this.currency = obj6;
        obj6 = 1;
        int i = 0;
        introductoryPricePeriod = productDetails3.getSubscriptionPeriod();
        if (productDetails3 != null && introductoryPricePeriod != null) {
            introductoryPricePeriod = productDetails3.getSubscriptionPeriod();
            if (introductoryPricePeriod != null) {
                d = introductoryPricePeriod.length() == 0 ? obj6 : i;
                if (d == 0) {
                } else {
                    introductoryPricePeriod = obj5;
                }
            } else {
            }
        } else {
        }
        this.duration = introductoryPricePeriod;
        introductoryPricePeriod = productDetails3.getIntroductoryPricePeriod();
        if (productDetails3 != null && introductoryPricePeriod != null) {
            introductoryPricePeriod = productDetails3.getIntroductoryPricePeriod();
            if (introductoryPricePeriod != null) {
                d = introductoryPricePeriod.length() == 0 ? obj6 : i;
                if (d == 0) {
                } else {
                    introductoryPricePeriod = obj5;
                }
            } else {
            }
        } else {
        }
        this.introDuration = introductoryPricePeriod;
        obj7 = productDetails3.getFreeTrialPeriod();
        if (productDetails3 != null && obj7 != null) {
            obj7 = productDetails3.getFreeTrialPeriod();
            if (obj7 != null) {
                if (obj7.length() == 0) {
                } else {
                    obj6 = i;
                }
                obj5 = obj6 == null ? obj7 : obj5;
            }
        }
        this.trialDuration = obj5;
    }

    public ReceiptInfo(List list, String string2, ProductDetails productDetails3, int i4, g g5) {
        int obj3;
        int obj4;
        final int i = 0;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(list, obj3, obj4);
    }

    public boolean equals(Object object) {
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        if (object != null) {
            class = object.getClass();
        } else {
            class = 0;
        }
        int i9 = 0;
        if (z ^= i != 0) {
            return i9;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type com.revenuecat.purchases.common.ReceiptInfo");
        if (z2 ^= i != 0) {
            return i9;
        }
        if (z3 ^= i != 0) {
            return i9;
        }
        if (z4 ^= i != 0) {
            return i9;
        }
        if (z5 ^= i != 0) {
            return i9;
        }
        if (z6 ^= i != 0) {
            return i9;
        }
        if (z7 ^= i != 0) {
            return i9;
        }
        if (obj5 ^= i != 0) {
            return i9;
        }
        return i;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getIntroDuration() {
        return this.introDuration;
    }

    public final String getOfferingIdentifier() {
        return this.offeringIdentifier;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final List<String> getProductIDs() {
        return this.productIDs;
    }

    public final String getTrialDuration() {
        return this.trialDuration;
    }

    public int hashCode() {
        int i;
        int i2;
        String offeringIdentifier = this.offeringIdentifier;
        if (offeringIdentifier != null) {
            i = offeringIdentifier.hashCode();
        } else {
            i = i2;
        }
        ProductDetails productDetails = this.productDetails;
        if (productDetails != null) {
            i2 = productDetails.hashCode();
        }
        return i6 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReceiptInfo(");
        stringBuilder.append("productIDs='");
        stringBuilder.append(p.h0(this.productIDs, 0, 0, 0, 0, 0, 0, 63, 0));
        stringBuilder.append("', ");
        stringBuilder.append("offeringIdentifier=");
        stringBuilder.append(this.offeringIdentifier);
        String str6 = ", ";
        stringBuilder.append(str6);
        stringBuilder.append("price=");
        stringBuilder.append(this.price);
        stringBuilder.append(str6);
        stringBuilder.append("currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append(str6);
        stringBuilder.append("duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(str6);
        stringBuilder.append("introDuration=");
        stringBuilder.append(this.introDuration);
        stringBuilder.append(str6);
        stringBuilder.append("trialDuration=");
        stringBuilder.append(this.trialDuration);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
