package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010$\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0008\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\u0008&\u0010'J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008\u0007\u0010\u0006J\u0012\u0010\u0008\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\u0008\u0008\u0010\tJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ2\u0010\u000f\u001a\u00020\u00002\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\u0014\u0008\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008 \u0010!R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\"\u001a\u0004\u0008#\u0010\tR%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000e\u0010$\u001a\u0004\u0008%\u0010\u000c¨\u0006(", d2 = {"Lcom/revenuecat/purchases/Offerings;", "Landroid/os/Parcelable;", "", "identifier", "Lcom/revenuecat/purchases/Offering;", "getOffering", "(Ljava/lang/String;)Lcom/revenuecat/purchases/Offering;", "get", "component1", "()Lcom/revenuecat/purchases/Offering;", "", "component2", "()Ljava/util/Map;", "current", "all", "copy", "(Lcom/revenuecat/purchases/Offering;Ljava/util/Map;)Lcom/revenuecat/purchases/Offerings;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/revenuecat/purchases/Offering;", "getCurrent", "Ljava/util/Map;", "getAll", "<init>", "(Lcom/revenuecat/purchases/Offering;Ljava/util/Map;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class Offerings implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final Map<String, com.revenuecat.purchases.Offering> all;
    private final com.revenuecat.purchases.Offering current;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            Object fromParcel;
            int int;
            String string;
            Object fromParcel2;
            n.f(parcel, "in");
            if (parcel.readInt() != 0) {
                fromParcel = Offering.CREATOR.createFromParcel(parcel);
            } else {
                fromParcel = 0;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(parcel.readInt());
            while (int != 0) {
                linkedHashMap.put(parcel.readString(), (Offering)Offering.CREATOR.createFromParcel(parcel));
                int--;
            }
            Offerings offerings = new Offerings(fromParcel, linkedHashMap);
            return offerings;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new Offerings[i];
        }
    }
    static {
        Offerings.Creator creator = new Offerings.Creator();
        Offerings.CREATOR = creator;
    }

    public Offerings(com.revenuecat.purchases.Offering offering, Map<String, com.revenuecat.purchases.Offering> map2) {
        n.f(map2, "all");
        super();
        this.current = offering;
        this.all = map2;
    }

    public static com.revenuecat.purchases.Offerings copy$default(com.revenuecat.purchases.Offerings offerings, com.revenuecat.purchases.Offering offering2, Map map3, int i4, Object object5) {
        com.revenuecat.purchases.Offering obj1;
        Map obj2;
        if (i4 & 1 != 0) {
            obj1 = offerings.current;
        }
        if (i4 &= 2 != 0) {
            obj2 = offerings.all;
        }
        return offerings.copy(obj1, obj2);
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Offering component1() {
        return this.current;
    }

    public final Map<String, com.revenuecat.purchases.Offering> component2() {
        return this.all;
    }

    public final com.revenuecat.purchases.Offerings copy(com.revenuecat.purchases.Offering offering, Map<String, com.revenuecat.purchases.Offering> map2) {
        n.f(map2, "all");
        Offerings offerings = new Offerings(offering, map2);
        return offerings;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        boolean all;
        com.revenuecat.purchases.Offering current;
        Object obj3;
        if (this != (Offerings)object && object instanceof Offerings && n.b(this.current, object.current) && n.b(this.all, object.all)) {
            if (object instanceof Offerings) {
                if (n.b(this.current, object.current)) {
                    if (n.b(this.all, object.all)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Offering get(String string) {
        n.f(string, "identifier");
        return getOffering(string);
    }

    public final Map<String, com.revenuecat.purchases.Offering> getAll() {
        return this.all;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Offering getCurrent() {
        return this.current;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.Offering getOffering(String string) {
        n.f(string, "identifier");
        return (Offering)this.all.get(string);
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i2;
        com.revenuecat.purchases.Offering current = this.current;
        if (current != null) {
            i = current.hashCode();
        } else {
            i = i2;
        }
        final Map all = this.all;
        if (all != null) {
            i2 = all.hashCode();
        }
        return i3 += i2;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Offerings(current=");
        stringBuilder.append(this.current);
        stringBuilder.append(", all=");
        stringBuilder.append(this.all);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int value;
        Object key;
        n.f(parcel, "parcel");
        com.revenuecat.purchases.Offering obj5 = this.current;
        final int i3 = 0;
        if (obj5 != null) {
            parcel.writeInt(1);
            obj5.writeToParcel(parcel, i3);
        } else {
            parcel.writeInt(i3);
        }
        obj5 = this.all;
        parcel.writeInt(obj5.size());
        obj5 = obj5.entrySet().iterator();
        for (Object next2 : obj5) {
            parcel.writeString((String)next2.getKey());
            (Offering)next2.getValue().writeToParcel(parcel, i3);
        }
    }
}
