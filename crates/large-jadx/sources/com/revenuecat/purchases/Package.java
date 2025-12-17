package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.billingclient.api.SkuDetails;
import com.revenuecat.purchases.parceler.SkuDetailsParceler;
import k.a.a.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000c\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0008\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\u0008)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0008HÆ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u000b\u0010\u0004J8\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00022\u0008\u0008\u0002\u0010\r\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008 \u0010!R\u0019\u0010\u000e\u001a\u00020\u00088\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000e\u0010\"\u001a\u0004\u0008#\u0010\nR\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010$\u001a\u0004\u0008%\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000f\u0010&\u001a\u0004\u0008'\u0010\u0004R\u0019\u0010\u000c\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010&\u001a\u0004\u0008(\u0010\u0004¨\u0006+", d2 = {"Lcom/revenuecat/purchases/Package;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/revenuecat/purchases/PackageType;", "component2", "()Lcom/revenuecat/purchases/PackageType;", "Lcom/android/billingclient/api/SkuDetails;", "component3", "()Lcom/android/billingclient/api/SkuDetails;", "component4", "identifier", "packageType", "product", "offering", "copy", "(Ljava/lang/String;Lcom/revenuecat/purchases/PackageType;Lcom/android/billingclient/api/SkuDetails;Ljava/lang/String;)Lcom/revenuecat/purchases/Package;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/android/billingclient/api/SkuDetails;", "getProduct", "Lcom/revenuecat/purchases/PackageType;", "getPackageType", "Ljava/lang/String;", "getOffering", "getIdentifier", "<init>", "(Ljava/lang/String;Lcom/revenuecat/purchases/PackageType;Lcom/android/billingclient/api/SkuDetails;Ljava/lang/String;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class Package implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final String identifier;
    private final String offering;
    private final com.revenuecat.purchases.PackageType packageType;
    private final SkuDetails product;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            n.f(parcel, "in");
            Package obj = new Package(parcel.readString(), (PackageType)Enum.valueOf(PackageType.class, parcel.readString()), (SkuDetails)SkuDetailsParceler.INSTANCE.create(parcel), parcel.readString());
            return obj;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new Package[i];
        }
    }
    static {
        Package.Creator creator = new Package.Creator();
        Package.CREATOR = creator;
    }

    public Package(String string, com.revenuecat.purchases.PackageType packageType2, SkuDetails skuDetails3, String string4) {
        n.f(string, "identifier");
        n.f(packageType2, "packageType");
        n.f(skuDetails3, "product");
        n.f(string4, "offering");
        super();
        this.identifier = string;
        this.packageType = packageType2;
        this.product = skuDetails3;
        this.offering = string4;
    }

    public static com.revenuecat.purchases.Package copy$default(com.revenuecat.purchases.Package package, String string2, com.revenuecat.purchases.PackageType packageType3, SkuDetails skuDetails4, String string5, int i6, Object object7) {
        String obj1;
        com.revenuecat.purchases.PackageType obj2;
        SkuDetails obj3;
        String obj4;
        if (i6 & 1 != 0) {
            obj1 = package.identifier;
        }
        if (i6 & 2 != 0) {
            obj2 = package.packageType;
        }
        if (i6 & 4 != 0) {
            obj3 = package.product;
        }
        if (i6 &= 8 != 0) {
            obj4 = package.offering;
        }
        return package.copy(obj1, obj2, obj3, obj4);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.identifier;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.PackageType component2() {
        return this.packageType;
    }

    @Override // android.os.Parcelable
    public final SkuDetails component3() {
        return this.product;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.offering;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package copy(String string, com.revenuecat.purchases.PackageType packageType2, SkuDetails skuDetails3, String string4) {
        n.f(string, "identifier");
        n.f(packageType2, "packageType");
        n.f(skuDetails3, "product");
        n.f(string4, "offering");
        Package obj = new Package(string, packageType2, skuDetails3, string4);
        return obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        boolean offering;
        Object packageType;
        Object obj3;
        if (this != (Package)object && object instanceof Package && n.b(this.identifier, object.identifier) && n.b(this.packageType, object.packageType) && n.b(this.product, object.product) && n.b(this.offering, object.offering)) {
            if (object instanceof Package) {
                if (n.b(this.identifier, object.identifier)) {
                    if (n.b(this.packageType, object.packageType)) {
                        if (n.b(this.product, object.product)) {
                            if (n.b(this.offering, object.offering)) {
                            }
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public final String getIdentifier() {
        return this.identifier;
    }

    @Override // android.os.Parcelable
    public final String getOffering() {
        return this.offering;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.PackageType getPackageType() {
        return this.packageType;
    }

    @Override // android.os.Parcelable
    public final SkuDetails getProduct() {
        return this.product;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i2;
        int i;
        int i4;
        int i3;
        String identifier = this.identifier;
        i = 0;
        if (identifier != null) {
            i2 = identifier.hashCode();
        } else {
            i2 = i;
        }
        com.revenuecat.purchases.PackageType packageType = this.packageType;
        if (packageType != null) {
            i4 = packageType.hashCode();
        } else {
            i4 = i;
        }
        SkuDetails product = this.product;
        if (product != null) {
            i3 = product.hashCode();
        } else {
            i3 = i;
        }
        String offering = this.offering;
        if (offering != null) {
            i = offering.hashCode();
        }
        return i9 += i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Package(identifier=");
        stringBuilder.append(this.identifier);
        stringBuilder.append(", packageType=");
        stringBuilder.append(this.packageType);
        stringBuilder.append(", product=");
        stringBuilder.append(this.product);
        stringBuilder.append(", offering=");
        stringBuilder.append(this.offering);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "parcel");
        parcel.writeString(this.identifier);
        parcel.writeString(this.packageType.name());
        SkuDetailsParceler.INSTANCE.write(this.product, parcel, i2);
        parcel.writeString(this.offering);
    }
}
