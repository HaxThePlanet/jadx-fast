package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Date;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0007\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\"\u001a\u00020\u0018\u0012\u0006\u0010*\u001a\u00020\u0018\u0012\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0007\u0012\u0008\u0010 \u001a\u0004\u0018\u00010\u0018\u0012\u0008\u0010(\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\u00086\u00107J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001a\u0010\u0008\u001a\u00020\u00072\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\nHÖ\u0001¢\u0006\u0004\u0008\r\u0010\u000cJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nHÖ\u0001¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u001f\u0010\u0004R\u001b\u0010 \u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\u000c\n\u0004\u0008 \u0010\u001a\u001a\u0004\u0008!\u0010\u001cR\u0019\u0010\"\u001a\u00020\u00188\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010\u001a\u001a\u0004\u0008#\u0010\u001cR\u0019\u0010$\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008$\u0010\u0015\u001a\u0004\u0008$\u0010\u0017R\u0019\u0010%\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008%\u0010\u001e\u001a\u0004\u0008&\u0010\u0004R\u0019\u0010'\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008'\u0010\u0015\u001a\u0004\u0008'\u0010\u0017R\u001b\u0010(\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\u000c\n\u0004\u0008(\u0010\u001a\u001a\u0004\u0008)\u0010\u001cR\u0019\u0010*\u001a\u00020\u00188\u0006@\u0006¢\u0006\u000c\n\u0004\u0008*\u0010\u001a\u001a\u0004\u0008+\u0010\u001cR\u0019\u0010-\u001a\u00020,8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008-\u0010.\u001a\u0004\u0008/\u00100R\u0019\u00102\u001a\u0002018\u0006@\u0006¢\u0006\u000c\n\u0004\u00082\u00103\u001a\u0004\u00084\u00105¨\u00068", d2 = {"Lcom/revenuecat/purchases/EntitlementInfo;", "Landroid/os/Parcelable;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "willRenew", "Z", "getWillRenew", "()Z", "Ljava/util/Date;", "expirationDate", "Ljava/util/Date;", "getExpirationDate", "()Ljava/util/Date;", "identifier", "Ljava/lang/String;", "getIdentifier", "unsubscribeDetectedAt", "getUnsubscribeDetectedAt", "latestPurchaseDate", "getLatestPurchaseDate", "isActive", "productIdentifier", "getProductIdentifier", "isSandbox", "billingIssueDetectedAt", "getBillingIssueDetectedAt", "originalPurchaseDate", "getOriginalPurchaseDate", "Lcom/revenuecat/purchases/PeriodType;", "periodType", "Lcom/revenuecat/purchases/PeriodType;", "getPeriodType", "()Lcom/revenuecat/purchases/PeriodType;", "Lcom/revenuecat/purchases/Store;", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "<init>", "(Ljava/lang/String;ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class EntitlementInfo implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final Date billingIssueDetectedAt;
    private final Date expirationDate;
    private final String identifier;
    private final boolean isActive;
    private final boolean isSandbox;
    private final Date latestPurchaseDate;
    private final Date originalPurchaseDate;
    private final com.revenuecat.purchases.PeriodType periodType;
    private final String productIdentifier;
    private final com.revenuecat.purchases.Store store;
    private final Date unsubscribeDetectedAt;
    private final boolean willRenew;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            int i2;
            int i;
            int i3;
            n.f(parcel, "in");
            int i4 = 1;
            int i6 = 0;
            i2 = parcel.readInt() != 0 ? i4 : i6;
            i = parcel.readInt() != 0 ? i4 : i6;
            i3 = parcel.readInt() != 0 ? i4 : i6;
            super(parcel.readString(), i2, i, (PeriodType)Enum.valueOf(PeriodType.class, parcel.readString()), (Date)parcel.readSerializable(), (Date)parcel.readSerializable(), (Date)parcel.readSerializable(), (Store)Enum.valueOf(Store.class, parcel.readString()), parcel.readString(), i3, (Date)parcel.readSerializable(), (Date)parcel.readSerializable());
            return entitlementInfo;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new EntitlementInfo[i];
        }
    }
    static {
        EntitlementInfo.Creator creator = new EntitlementInfo.Creator();
        EntitlementInfo.CREATOR = creator;
    }

    public EntitlementInfo(String string, boolean z2, boolean z3, com.revenuecat.purchases.PeriodType periodType4, Date date5, Date date6, Date date7, com.revenuecat.purchases.Store store8, String string9, boolean z10, Date date11, Date date12) {
        n.f(string, "identifier");
        n.f(periodType4, "periodType");
        n.f(date5, "latestPurchaseDate");
        n.f(date6, "originalPurchaseDate");
        n.f(store8, "store");
        n.f(string9, "productIdentifier");
        super();
        this.identifier = string;
        this.isActive = z2;
        this.willRenew = z3;
        this.periodType = periodType4;
        this.latestPurchaseDate = date5;
        this.originalPurchaseDate = date6;
        this.expirationDate = date7;
        this.store = store8;
        this.productIdentifier = string9;
        this.isSandbox = z10;
        this.unsubscribeDetectedAt = date11;
        this.billingIssueDetectedAt = date12;
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
        int i9 = 0;
        if (z ^= i != 0) {
            return i9;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type com.revenuecat.purchases.EntitlementInfo");
        if (z2 ^= i != 0) {
            return i9;
        }
        if (this.isActive != object.isActive) {
            return i9;
        }
        if (this.willRenew != object.willRenew) {
            return i9;
        }
        if (this.periodType != object.periodType) {
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
        if (this.store != object.store) {
            return i9;
        }
        if (z6 ^= i != 0) {
            return i9;
        }
        if (this.isSandbox != object.isSandbox) {
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

    @Override // android.os.Parcelable
    public final Date getBillingIssueDetectedAt() {
        return this.billingIssueDetectedAt;
    }

    @Override // android.os.Parcelable
    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    @Override // android.os.Parcelable
    public final String getIdentifier() {
        return this.identifier;
    }

    @Override // android.os.Parcelable
    public final Date getLatestPurchaseDate() {
        return this.latestPurchaseDate;
    }

    @Override // android.os.Parcelable
    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.PeriodType getPeriodType() {
        return this.periodType;
    }

    @Override // android.os.Parcelable
    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Store getStore() {
        return this.store;
    }

    @Override // android.os.Parcelable
    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    @Override // android.os.Parcelable
    public final boolean getWillRenew() {
        return this.willRenew;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i3;
        int i;
        int i2;
        Date expirationDate = this.expirationDate;
        i2 = 0;
        if (expirationDate != null) {
            i3 = expirationDate.hashCode();
        } else {
            i3 = i2;
        }
        Date unsubscribeDetectedAt = this.unsubscribeDetectedAt;
        if (unsubscribeDetectedAt != null) {
            i = unsubscribeDetectedAt.hashCode();
        } else {
            i = i2;
        }
        Date billingIssueDetectedAt = this.billingIssueDetectedAt;
        if (billingIssueDetectedAt != null) {
            i2 = billingIssueDetectedAt.hashCode();
        }
        return i25 += i2;
    }

    @Override // android.os.Parcelable
    public final boolean isActive() {
        return this.isActive;
    }

    @Override // android.os.Parcelable
    public final boolean isSandbox() {
        return this.isSandbox;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EntitlementInfo(");
        stringBuilder.append("identifier='");
        stringBuilder.append(this.identifier);
        String str3 = "', ";
        stringBuilder.append(str3);
        stringBuilder.append("isActive=");
        stringBuilder.append(this.isActive);
        String str8 = ", ";
        stringBuilder.append(str8);
        stringBuilder.append("willRenew=");
        stringBuilder.append(this.willRenew);
        stringBuilder.append(str8);
        stringBuilder.append("periodType=");
        stringBuilder.append(this.periodType);
        stringBuilder.append(str8);
        stringBuilder.append("latestPurchaseDate=");
        stringBuilder.append(this.latestPurchaseDate);
        stringBuilder.append(str8);
        stringBuilder.append("originalPurchaseDate=");
        stringBuilder.append(this.originalPurchaseDate);
        stringBuilder.append(str8);
        stringBuilder.append("expirationDate=");
        stringBuilder.append(this.expirationDate);
        stringBuilder.append(str8);
        stringBuilder.append("store=");
        stringBuilder.append(this.store);
        stringBuilder.append(str8);
        stringBuilder.append("productIdentifier='");
        stringBuilder.append(this.productIdentifier);
        stringBuilder.append(str3);
        stringBuilder.append("isSandbox=");
        stringBuilder.append(this.isSandbox);
        stringBuilder.append(str8);
        stringBuilder.append("unsubscribeDetectedAt=");
        stringBuilder.append(this.unsubscribeDetectedAt);
        stringBuilder.append(str8);
        stringBuilder.append("billingIssueDetectedAt=");
        stringBuilder.append(this.billingIssueDetectedAt);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "parcel");
        parcel.writeString(this.identifier);
        parcel.writeInt(this.isActive);
        parcel.writeInt(this.willRenew);
        parcel.writeString(this.periodType.name());
        parcel.writeSerializable(this.latestPurchaseDate);
        parcel.writeSerializable(this.originalPurchaseDate);
        parcel.writeSerializable(this.expirationDate);
        parcel.writeString(this.store.name());
        parcel.writeString(this.productIdentifier);
        parcel.writeInt(this.isSandbox);
        parcel.writeSerializable(this.unsubscribeDetectedAt);
        parcel.writeSerializable(this.billingIssueDetectedAt);
    }
}
