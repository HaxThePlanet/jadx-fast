package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Date;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\u0008#\u0010$B\u0019\u0008\u0010\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\u0008#\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\u0008\u0007\u0010\u0008J.\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\t\u001a\u00020\u00022\u0008\u0008\u0002\u0010\n\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\u0008\u000c\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\u0008\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\n\u0010\u001e\u001a\u0004\u0008\u001f\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\u001e\u001a\u0004\u0008 \u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000b\u0010!\u001a\u0004\u0008\"\u0010\u0008¨\u0006(", d2 = {"Lcom/revenuecat/purchases/models/Transaction;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Ljava/util/Date;", "component3", "()Ljava/util/Date;", "revenuecatId", "productId", "purchaseDate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)Lcom/revenuecat/purchases/models/Transaction;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getProductId", "getRevenuecatId", "Ljava/util/Date;", "getPurchaseDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;)V", "Lorg/json/JSONObject;", "jsonObject", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class Transaction implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final String productId;
    private final Date purchaseDate;
    private final String revenuecatId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            n.f(parcel, "in");
            Transaction transaction = new Transaction(parcel.readString(), parcel.readString(), (Date)parcel.readSerializable());
            return transaction;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new Transaction[i];
        }
    }
    static {
        Transaction.Creator creator = new Transaction.Creator();
        Transaction.CREATOR = creator;
    }

    public Transaction(String string, String string2, Date date3) {
        n.f(string, "revenuecatId");
        n.f(string2, "productId");
        n.f(date3, "purchaseDate");
        super();
        this.revenuecatId = string;
        this.productId = string2;
        this.purchaseDate = date3;
    }

    public Transaction(String string, JSONObject jSONObject2) {
        n.f(string, "productId");
        n.f(jSONObject2, "jsonObject");
        String string2 = jSONObject2.getString("id");
        n.e(string2, "jsonObject.getString(\"id\")");
        super(string2, string, JSONObjectExtensionsKt.getDate(jSONObject2, "purchase_date"));
    }

    public static com.revenuecat.purchases.models.Transaction copy$default(com.revenuecat.purchases.models.Transaction transaction, String string2, String string3, Date date4, int i5, Object object6) {
        String obj1;
        String obj2;
        Date obj3;
        if (i5 & 1 != 0) {
            obj1 = transaction.revenuecatId;
        }
        if (i5 & 2 != 0) {
            obj2 = transaction.productId;
        }
        if (i5 &= 4 != 0) {
            obj3 = transaction.purchaseDate;
        }
        return transaction.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.revenuecatId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.productId;
    }

    @Override // android.os.Parcelable
    public final Date component3() {
        return this.purchaseDate;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.models.Transaction copy(String string, String string2, Date date3) {
        n.f(string, "revenuecatId");
        n.f(string2, "productId");
        n.f(date3, "purchaseDate");
        Transaction transaction = new Transaction(string, string2, date3);
        return transaction;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        Date purchaseDate;
        String revenuecatId;
        Object obj3;
        if (this != (Transaction)object && object instanceof Transaction && n.b(this.revenuecatId, object.revenuecatId) && n.b(this.productId, object.productId) && n.b(this.purchaseDate, object.purchaseDate)) {
            if (object instanceof Transaction) {
                if (n.b(this.revenuecatId, object.revenuecatId)) {
                    if (n.b(this.productId, object.productId)) {
                        if (n.b(this.purchaseDate, object.purchaseDate)) {
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public final String getProductId() {
        return this.productId;
    }

    @Override // android.os.Parcelable
    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    @Override // android.os.Parcelable
    public final String getRevenuecatId() {
        return this.revenuecatId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i2;
        int i3;
        String revenuecatId = this.revenuecatId;
        i2 = 0;
        if (revenuecatId != null) {
            i = revenuecatId.hashCode();
        } else {
            i = i2;
        }
        String productId = this.productId;
        if (productId != null) {
            i3 = productId.hashCode();
        } else {
            i3 = i2;
        }
        Date purchaseDate = this.purchaseDate;
        if (purchaseDate != null) {
            i2 = purchaseDate.hashCode();
        }
        return i6 += i2;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transaction(revenuecatId=");
        stringBuilder.append(this.revenuecatId);
        stringBuilder.append(", productId=");
        stringBuilder.append(this.productId);
        stringBuilder.append(", purchaseDate=");
        stringBuilder.append(this.purchaseDate);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "parcel");
        parcel.writeString(this.revenuecatId);
        parcel.writeString(this.productId);
        parcel.writeSerializable(this.purchaseDate);
    }
}
