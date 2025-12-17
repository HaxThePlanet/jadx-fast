package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.parceler.JSONObjectParceler;
import java.util.Objects;
import k.a.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0012\u0008\u0007\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010.\u001a\u00020\u001b\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010$\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010&\u001a\u00020\u001b\u0012\u0008\u0010>\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u00107\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0008\u0010\"\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0010(\u001a\u0004\u0018\u00010\u001b\u0012\u0008\u0010*\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010,\u001a\u00020\u0011\u0012\u0008\u00105\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u00109\u001a\u00020\u0007\u0012\u0006\u0010<\u001a\u00020\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\u0008@\u0010AJ\u001a\u0010\u0005\u001a\u00020\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u0008\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\u0008\n\u0010\tJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u001e\u0010\u001fR\u0019\u0010 \u001a\u00020\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008 \u0010\u001d\u001a\u0004\u0008!\u0010\u001fR\u001b\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010\u001d\u001a\u0004\u0008#\u0010\u001fR\u0019\u0010$\u001a\u00020\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008$\u0010\u001d\u001a\u0004\u0008%\u0010\u001fR\u0019\u0010&\u001a\u00020\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008&\u0010\u001d\u001a\u0004\u0008'\u0010\u001fR\u001b\u0010(\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008(\u0010\u001d\u001a\u0004\u0008)\u0010\u001fR\u001b\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008*\u0010\u001d\u001a\u0004\u0008+\u0010\u001fR\u0019\u0010,\u001a\u00020\u00118\u0006@\u0006¢\u0006\u000c\n\u0004\u0008,\u0010\u0013\u001a\u0004\u0008-\u0010\u0015R\u0019\u0010.\u001a\u00020\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008.\u0010\u001d\u001a\u0004\u0008/\u0010\u001fR\u0019\u00101\u001a\u0002008\u0006@\u0006¢\u0006\u000c\n\u0004\u00081\u00102\u001a\u0004\u00083\u00104R\u001b\u00105\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u00085\u0010\u001d\u001a\u0004\u00086\u0010\u001fR\u0019\u00107\u001a\u00020\u00118\u0006@\u0006¢\u0006\u000c\n\u0004\u00087\u0010\u0013\u001a\u0004\u00088\u0010\u0015R\u0019\u00109\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u00089\u0010:\u001a\u0004\u0008;\u0010\tR\u0019\u0010<\u001a\u00020\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008<\u0010\u001d\u001a\u0004\u0008=\u0010\u001fR\u001b\u0010>\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008>\u0010\u001d\u001a\u0004\u0008?\u0010\u001f¨\u0006B", d2 = {"Lcom/revenuecat/purchases/models/ProductDetails;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "priceAmountMicros", "J", "getPriceAmountMicros", "()J", "Lorg/json/JSONObject;", "originalJson", "Lorg/json/JSONObject;", "getOriginalJson", "()Lorg/json/JSONObject;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "subscriptionPeriod", "getSubscriptionPeriod", "price", "getPrice", "priceCurrencyCode", "getPriceCurrencyCode", "freeTrialPeriod", "getFreeTrialPeriod", "introductoryPrice", "getIntroductoryPrice", "introductoryPriceAmountMicros", "getIntroductoryPriceAmountMicros", "sku", "getSku", "Lcom/revenuecat/purchases/ProductType;", "type", "Lcom/revenuecat/purchases/ProductType;", "getType", "()Lcom/revenuecat/purchases/ProductType;", "introductoryPricePeriod", "getIntroductoryPricePeriod", "originalPriceAmountMicros", "getOriginalPriceAmountMicros", "introductoryPriceCycles", "I", "getIntroductoryPriceCycles", "iconUrl", "getIconUrl", "originalPrice", "getOriginalPrice", "<init>", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class ProductDetails implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final String description;
    private final String freeTrialPeriod;
    private final String iconUrl;
    private final String introductoryPrice;
    private final long introductoryPriceAmountMicros;
    private final int introductoryPriceCycles;
    private final String introductoryPricePeriod;
    private final JSONObject originalJson;
    private final String originalPrice;
    private final long originalPriceAmountMicros;
    private final String price;
    private final long priceAmountMicros;
    private final String priceCurrencyCode;
    private final String sku;
    private final String subscriptionPeriod;
    private final String title;
    private final ProductType type;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            Object obj = parcel;
            n.f(obj, "in");
            super(parcel.readString(), (ProductType)Enum.valueOf(ProductType.class, parcel.readString()), parcel.readString(), parcel.readLong(), obj7, parcel.readString(), parcel.readString(), parcel.readLong(), obj11, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), obj18, parcel.readString(), parcel.readInt(), parcel.readString(), (JSONObject)JSONObjectParceler.INSTANCE.create(obj));
            return productDetails;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new ProductDetails[i];
        }
    }
    static {
        ProductDetails.Creator creator = new ProductDetails.Creator();
        ProductDetails.CREATOR = creator;
    }

    public ProductDetails(String string, ProductType productType2, String string3, long l4, String string5, String string6, long l7, String string8, String string9, String string10, String string11, String string12, long l13, String string14, int i15, String string16, JSONObject jSONObject17) {
        final Object obj = this;
        final Object obj2 = string6;
        final Object obj3 = string10;
        final Object obj4 = string11;
        final Object obj5 = obj29;
        final Object obj6 = obj30;
        n.f(string, "sku");
        n.f(productType2, "type");
        n.f(string3, "price");
        n.f(obj2, "priceCurrencyCode");
        n.f(obj3, "title");
        n.f(obj4, "description");
        n.f(obj5, "iconUrl");
        n.f(obj6, "originalJson");
        super();
        obj.sku = string;
        obj.type = productType2;
        obj.price = string3;
        obj.priceAmountMicros = l4;
        obj.priceCurrencyCode = obj2;
        obj.originalPrice = l7;
        obj.originalPriceAmountMicros = string8;
        obj.title = obj3;
        obj.description = obj4;
        obj.subscriptionPeriod = string12;
        obj.freeTrialPeriod = l13;
        obj.introductoryPrice = string14;
        obj.introductoryPriceAmountMicros = i15;
        obj.introductoryPricePeriod = jSONObject17;
        obj.introductoryPriceCycles = obj28;
        obj.iconUrl = obj5;
        obj.originalJson = obj6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
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
        int i13 = 0;
        if (z ^= i != 0) {
            return i13;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type com.revenuecat.purchases.models.ProductDetails");
        if (z2 ^= i != 0) {
            return i13;
        }
        if (this.type != object.type) {
            return i13;
        }
        if (z3 ^= i != 0) {
            return i13;
        }
        if (Long.compare(priceAmountMicros, priceAmountMicros2) != 0) {
            return i13;
        }
        if (z4 ^= i != 0) {
            return i13;
        }
        if (z5 ^= i != 0) {
            return i13;
        }
        if (Long.compare(originalPriceAmountMicros, originalPriceAmountMicros2) != 0) {
            return i13;
        }
        if (z6 ^= i != 0) {
            return i13;
        }
        if (z7 ^= i != 0) {
            return i13;
        }
        if (z8 ^= i != 0) {
            return i13;
        }
        if (z9 ^= i != 0) {
            return i13;
        }
        if (z10 ^= i != 0) {
            return i13;
        }
        if (Long.compare(introductoryPriceAmountMicros, introductoryPriceAmountMicros2) != 0) {
            return i13;
        }
        if (z11 ^= i != 0) {
            return i13;
        }
        if (this.introductoryPriceCycles != object.introductoryPriceCycles) {
            return i13;
        }
        if (obj8 ^= i != 0) {
            return i13;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDescription() {
        return this.description;
    }

    @Override // android.os.Parcelable
    public final String getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    @Override // android.os.Parcelable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Override // android.os.Parcelable
    public final String getIntroductoryPrice() {
        return this.introductoryPrice;
    }

    @Override // android.os.Parcelable
    public final long getIntroductoryPriceAmountMicros() {
        return this.introductoryPriceAmountMicros;
    }

    @Override // android.os.Parcelable
    public final int getIntroductoryPriceCycles() {
        return this.introductoryPriceCycles;
    }

    @Override // android.os.Parcelable
    public final String getIntroductoryPricePeriod() {
        return this.introductoryPricePeriod;
    }

    @Override // android.os.Parcelable
    public final JSONObject getOriginalJson() {
        return this.originalJson;
    }

    @Override // android.os.Parcelable
    public final String getOriginalPrice() {
        return this.originalPrice;
    }

    @Override // android.os.Parcelable
    public final long getOriginalPriceAmountMicros() {
        return this.originalPriceAmountMicros;
    }

    @Override // android.os.Parcelable
    public final String getPrice() {
        return this.price;
    }

    @Override // android.os.Parcelable
    public final long getPriceAmountMicros() {
        return this.priceAmountMicros;
    }

    @Override // android.os.Parcelable
    public final String getPriceCurrencyCode() {
        return this.priceCurrencyCode;
    }

    @Override // android.os.Parcelable
    public final String getSku() {
        return this.sku;
    }

    @Override // android.os.Parcelable
    public final String getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    @Override // android.os.Parcelable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public final ProductType getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i4;
        int i5;
        int i;
        int i3;
        int i2;
        String originalPrice = this.originalPrice;
        i2 = 0;
        if (originalPrice != null) {
            i4 = originalPrice.hashCode();
        } else {
            i4 = i2;
        }
        String subscriptionPeriod = this.subscriptionPeriod;
        if (subscriptionPeriod != null) {
            i5 = subscriptionPeriod.hashCode();
        } else {
            i5 = i2;
        }
        String freeTrialPeriod = this.freeTrialPeriod;
        if (freeTrialPeriod != null) {
            i = freeTrialPeriod.hashCode();
        } else {
            i = i2;
        }
        String introductoryPrice = this.introductoryPrice;
        if (introductoryPrice != null) {
            i3 = introductoryPrice.hashCode();
        } else {
            i3 = i2;
        }
        String introductoryPricePeriod = this.introductoryPricePeriod;
        if (introductoryPricePeriod != null) {
            i2 = introductoryPricePeriod.hashCode();
        }
        return i37 += i48;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "parcel");
        parcel.writeString(this.sku);
        parcel.writeString(this.type.name());
        parcel.writeString(this.price);
        parcel.writeLong(this.priceAmountMicros);
        parcel.writeString(this.priceCurrencyCode);
        parcel.writeString(this.originalPrice);
        parcel.writeLong(this.originalPriceAmountMicros);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.subscriptionPeriod);
        parcel.writeString(this.freeTrialPeriod);
        parcel.writeString(this.introductoryPrice);
        parcel.writeLong(this.introductoryPriceAmountMicros);
        parcel.writeString(this.introductoryPricePeriod);
        parcel.writeInt(this.introductoryPriceCycles);
        parcel.writeString(this.iconUrl);
        JSONObjectParceler.INSTANCE.write(this.originalJson, parcel, i2);
    }
}
