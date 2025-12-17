package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008)\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0004\u0008K\u0010LJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0015\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\u0008\u000c\u0010\nJ\u0010\u0010\r\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\u0008\u000f\u0010\u000eJ\u0016\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0010HÆ\u0003¢\u0006\u0004\u0008\u0011\u0010\u0012J4\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00072\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0010HÆ\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\u0008\u0017\u0010\u000eJ\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\u0008 \u0010\u001aJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\u0008%\u0010&R%\u0010-\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008'\u0010(\u0012\u0004\u0008+\u0010,\u001a\u0004\u0008)\u0010*R%\u00101\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008.\u0010(\u0012\u0004\u00080\u0010,\u001a\u0004\u0008/\u0010*R%\u00105\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u00082\u0010(\u0012\u0004\u00084\u0010,\u001a\u0004\u00083\u0010*R%\u00109\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u00086\u0010(\u0012\u0004\u00088\u0010,\u001a\u0004\u00087\u0010*R\u001f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00108\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0014\u0010:\u001a\u0004\u0008;\u0010\u0012R%\u0010?\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008<\u0010(\u0012\u0004\u0008>\u0010,\u001a\u0004\u0008=\u0010*R%\u0010C\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008@\u0010(\u0012\u0004\u0008B\u0010,\u001a\u0004\u0008A\u0010*R%\u0010G\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008D\u0010(\u0012\u0004\u0008F\u0010,\u001a\u0004\u0008E\u0010*R\u0019\u0010\u000b\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000b\u0010H\u001a\u0004\u0008I\u0010\u000eR\u0019\u0010\u0013\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0013\u0010H\u001a\u0004\u0008J\u0010\u000e¨\u0006M", d2 = {"Lcom/revenuecat/purchases/Offering;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/PackageType;", "packageType", "Lcom/revenuecat/purchases/Package;", "findPackage", "(Lcom/revenuecat/purchases/PackageType;)Lcom/revenuecat/purchases/Package;", "", "s", "get", "(Ljava/lang/String;)Lcom/revenuecat/purchases/Package;", "identifier", "getPackage", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "serverDescription", "availablePackages", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/revenuecat/purchases/Offering;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "weekly$delegate", "Lkotlin/h;", "getWeekly", "()Lcom/revenuecat/purchases/Package;", "getWeekly$annotations", "()V", "weekly", "annual$delegate", "getAnnual", "getAnnual$annotations", "annual", "sixMonth$delegate", "getSixMonth", "getSixMonth$annotations", "sixMonth", "threeMonth$delegate", "getThreeMonth", "getThreeMonth$annotations", "threeMonth", "Ljava/util/List;", "getAvailablePackages", "twoMonth$delegate", "getTwoMonth", "getTwoMonth$annotations", "twoMonth", "monthly$delegate", "getMonthly", "getMonthly$annotations", "monthly", "lifetime$delegate", "getLifetime", "getLifetime$annotations", "lifetime", "Ljava/lang/String;", "getIdentifier", "getServerDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class Offering implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final h annual$delegate;
    private final List<com.revenuecat.purchases.Package> availablePackages;
    private final String identifier;
    private final h lifetime$delegate;
    private final h monthly$delegate;
    private final String serverDescription;
    private final h sixMonth$delegate;
    private final h threeMonth$delegate;
    private final h twoMonth$delegate;
    private final h weekly$delegate;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            int int;
            Object fromParcel;
            n.f(parcel, "in");
            ArrayList arrayList = new ArrayList(parcel.readInt());
            while (int != 0) {
                arrayList.add((Package)Package.CREATOR.createFromParcel(parcel));
                int--;
            }
            Offering offering = new Offering(parcel.readString(), parcel.readString(), arrayList);
            return offering;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new Offering[i];
        }
    }
    static {
        Offering.Creator creator = new Offering.Creator();
        Offering.CREATOR = creator;
    }

    public Offering(String string, String string2, List<com.revenuecat.purchases.Package> list3) {
        n.f(string, "identifier");
        n.f(string2, "serverDescription");
        n.f(list3, "availablePackages");
        super();
        this.identifier = string;
        this.serverDescription = string2;
        this.availablePackages = list3;
        Offering.lifetime.2 obj2 = new Offering.lifetime.2(this);
        this.lifetime$delegate = j.b(obj2);
        obj2 = new Offering.annual.2(this);
        this.annual$delegate = j.b(obj2);
        obj2 = new Offering.sixMonth.2(this);
        this.sixMonth$delegate = j.b(obj2);
        obj2 = new Offering.threeMonth.2(this);
        this.threeMonth$delegate = j.b(obj2);
        obj2 = new Offering.twoMonth.2(this);
        this.twoMonth$delegate = j.b(obj2);
        obj2 = new Offering.monthly.2(this);
        this.monthly$delegate = j.b(obj2);
        obj2 = new Offering.weekly.2(this);
        this.weekly$delegate = j.b(obj2);
    }

    public static final com.revenuecat.purchases.Package access$findPackage(com.revenuecat.purchases.Offering offering, com.revenuecat.purchases.PackageType packageType2) {
        return offering.findPackage(packageType2);
    }

    public static com.revenuecat.purchases.Offering copy$default(com.revenuecat.purchases.Offering offering, String string2, String string3, List list4, int i5, Object object6) {
        String obj1;
        String obj2;
        List obj3;
        if (i5 & 1 != 0) {
            obj1 = offering.identifier;
        }
        if (i5 & 2 != 0) {
            obj2 = offering.serverDescription;
        }
        if (i5 &= 4 != 0) {
            obj3 = offering.availablePackages;
        }
        return offering.copy(obj1, obj2, obj3);
    }

    private final com.revenuecat.purchases.Package findPackage(com.revenuecat.purchases.PackageType packageType) {
        Object next;
        boolean z;
        String identifier;
        Iterator iterator = this.availablePackages.iterator();
        for (Object next : iterator) {
        }
        next = 0;
        return (Package)next;
    }

    public static void getAnnual$annotations() {
    }

    public static void getLifetime$annotations() {
    }

    public static void getMonthly$annotations() {
    }

    public static void getSixMonth$annotations() {
    }

    public static void getThreeMonth$annotations() {
    }

    public static void getTwoMonth$annotations() {
    }

    public static void getWeekly$annotations() {
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.identifier;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.serverDescription;
    }

    public final List<com.revenuecat.purchases.Package> component3() {
        return this.availablePackages;
    }

    public final com.revenuecat.purchases.Offering copy(String string, String string2, List<com.revenuecat.purchases.Package> list3) {
        n.f(string, "identifier");
        n.f(string2, "serverDescription");
        n.f(list3, "availablePackages");
        Offering offering = new Offering(string, string2, list3);
        return offering;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        List availablePackages;
        String serverDescription;
        Object obj3;
        if (this != (Offering)object && object instanceof Offering && n.b(this.identifier, object.identifier) && n.b(this.serverDescription, object.serverDescription) && n.b(this.availablePackages, object.availablePackages)) {
            if (object instanceof Offering) {
                if (n.b(this.identifier, object.identifier)) {
                    if (n.b(this.serverDescription, object.serverDescription)) {
                        if (n.b(this.availablePackages, object.availablePackages)) {
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package get(String string) {
        n.f(string, "s");
        return getPackage(string);
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package getAnnual() {
        return (Package)this.annual$delegate.getValue();
    }

    public final List<com.revenuecat.purchases.Package> getAvailablePackages() {
        return this.availablePackages;
    }

    @Override // android.os.Parcelable
    public final String getIdentifier() {
        return this.identifier;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package getLifetime() {
        return (Package)this.lifetime$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package getMonthly() {
        return (Package)this.monthly$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package getPackage(String string) {
        Object next;
        boolean z;
        n.f(string, "identifier");
        Iterator iterator = this.availablePackages.iterator();
        for (Package next : iterator) {
        }
        NoSuchElementException obj4 = new NoSuchElementException("Collection contains no element matching the predicate.");
        throw obj4;
    }

    @Override // android.os.Parcelable
    public final String getServerDescription() {
        return this.serverDescription;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package getSixMonth() {
        return (Package)this.sixMonth$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package getThreeMonth() {
        return (Package)this.threeMonth$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package getTwoMonth() {
        return (Package)this.twoMonth$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Package getWeekly() {
        return (Package)this.weekly$delegate.getValue();
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i2;
        int i;
        int i3;
        String identifier = this.identifier;
        i = 0;
        if (identifier != null) {
            i2 = identifier.hashCode();
        } else {
            i2 = i;
        }
        String serverDescription = this.serverDescription;
        if (serverDescription != null) {
            i3 = serverDescription.hashCode();
        } else {
            i3 = i;
        }
        List availablePackages = this.availablePackages;
        if (availablePackages != null) {
            i = availablePackages.hashCode();
        }
        return i6 += i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offering(identifier=");
        stringBuilder.append(this.identifier);
        stringBuilder.append(", serverDescription=");
        stringBuilder.append(this.serverDescription);
        stringBuilder.append(", availablePackages=");
        stringBuilder.append(this.availablePackages);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        int i;
        n.f(parcel, "parcel");
        parcel.writeString(this.identifier);
        parcel.writeString(this.serverDescription);
        List obj4 = this.availablePackages;
        parcel.writeInt(obj4.size());
        obj4 = obj4.iterator();
        for (Package size : obj4) {
            size.writeToParcel(parcel, 0);
        }
    }
}
