package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0016¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u000cHÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u000eJ \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000cHÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015R%\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00168\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u001aR%\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00168\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001b\u0010\u0018\u001a\u0004\u0008\u001c\u0010\u001a¨\u0006\u001f", d2 = {"Lcom/revenuecat/purchases/EntitlementInfos;", "Landroid/os/Parcelable;", "", "s", "Lcom/revenuecat/purchases/EntitlementInfo;", "get", "(Ljava/lang/String;)Lcom/revenuecat/purchases/EntitlementInfo;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/w;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "active", "Ljava/util/Map;", "getActive", "()Ljava/util/Map;", "all", "getAll", "<init>", "(Ljava/util/Map;)V", "public_release"}, k = 1, mv = {1, 4, 0})
public final class EntitlementInfos implements Parcelable {

    public static final Parcelable.Creator CREATOR;
    private final Map<String, com.revenuecat.purchases.EntitlementInfo> active;
    private final Map<String, com.revenuecat.purchases.EntitlementInfo> all;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public final Object createFromParcel(Parcel parcel) {
            int int;
            String string;
            Object fromParcel;
            n.f(parcel, "in");
            LinkedHashMap linkedHashMap = new LinkedHashMap(parcel.readInt());
            while (int != 0) {
                linkedHashMap.put(parcel.readString(), (EntitlementInfo)EntitlementInfo.CREATOR.createFromParcel(parcel));
                int--;
            }
            EntitlementInfos entitlementInfos = new EntitlementInfos(linkedHashMap);
            return entitlementInfos;
        }

        @Override // android.os.Parcelable$Creator
        public final Object[] newArray(int i) {
            return new EntitlementInfos[i];
        }
    }
    static {
        EntitlementInfos.Creator creator = new EntitlementInfos.Creator();
        EntitlementInfos.CREATOR = creator;
    }

    public EntitlementInfos(Map<String, com.revenuecat.purchases.EntitlementInfo> map) {
        Object value;
        boolean active;
        n.f(map, "all");
        super();
        this.all = map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator obj4 = map.entrySet().iterator();
        while (obj4.hasNext()) {
            value = obj4.next();
            if ((EntitlementInfo)(Map.Entry)value.getValue().isActive()) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
        }
        this.active = linkedHashMap;
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
        int i4 = 0;
        if (z ^= i != 0) {
            return i4;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type com.revenuecat.purchases.EntitlementInfos");
        if (z2 ^= i != 0) {
            return i4;
        }
        if (obj5 ^= i != 0) {
            return i4;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final com.revenuecat.purchases.EntitlementInfo get(String string) {
        n.f(string, "s");
        return (EntitlementInfo)this.all.get(string);
    }

    public final Map<String, com.revenuecat.purchases.EntitlementInfo> getActive() {
        return this.active;
    }

    public final Map<String, com.revenuecat.purchases.EntitlementInfo> getAll() {
        return this.all;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int value;
        int i;
        n.f(parcel, "parcel");
        Map obj4 = this.all;
        parcel.writeInt(obj4.size());
        obj4 = obj4.entrySet().iterator();
        for (Object next2 : obj4) {
            parcel.writeString((String)next2.getKey());
            (EntitlementInfo)next2.getValue().writeToParcel(parcel, 0);
        }
    }
}
