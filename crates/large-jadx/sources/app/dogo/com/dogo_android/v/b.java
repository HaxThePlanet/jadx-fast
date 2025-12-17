package app.dogo.com.dogo_android.v;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.android.persistencedb.room.entity.PolicyEntity;
import app.dogo.android.persistencedb.room.entity.UserEntity;
import e.a.a.a.b.d.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 /2\u00020\u0001:\u0002/0B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001cHÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/temp/User;", "Landroid/os/Parcelable;", "id", "", "policies", "", "Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "participating", "", "abTestBucket", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Long;)V", "getAbTestBucket", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "()Ljava/lang/String;", "getParticipating", "()Ljava/util/List;", "getPolicies", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Long;)Lapp/dogo/com/dogo_android/temp/User;", "describeContents", "", "equals", "", "other", "", "hashCode", "isPolicyAccepted", "policyId", "isPolicySeen", "toString", "toUserFullEntity", "Lapp/dogo/android/persistencedb/room/relations/UserFullEntity;", "userId", "currentDogId", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "PolicyStatus", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.v.b> CREATOR;
    public static final app.dogo.com.dogo_android.v.b.a Companion;
    private final String a;
    private final Map<String, app.dogo.com.dogo_android.v.b.c> b;
    private final List<String> c;
    private final Long v;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/temp/User$Companion;", "", "()V", "CHALLENGE_TERMS_POLICY_ID", "", "NEWSLETTER_POLICY_ID", "fromEntity", "Lapp/dogo/com/dogo_android/temp/User;", "userEntity", "Lapp/dogo/android/persistencedb/room/relations/UserFullEntity;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.v.b a(h h) {
            int i;
            o oVar;
            String str;
            app.dogo.com.dogo_android.v.b.c.a companion;
            n.f(h, "userEntity");
            List list = h.a();
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            Iterator iterator = list.iterator();
            for (PolicyEntity next2 : iterator) {
                oVar = new o(next2.getId(), b.c.Companion.a(next2.getStatus()));
                arrayList.add(oVar);
            }
            b bVar = new b(h.b().getId(), j0.s(arrayList), p.N0(h.b().getParticipatingInChallenges()), h.b().getAbBucket());
            return bVar;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<app.dogo.com.dogo_android.v.b> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.v.b a(Parcel parcel) {
            int i;
            long long;
            long string;
            app.dogo.com.dogo_android.v.b.c valueOf;
            Long obj7;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int);
            i = 0;
            while (i != int) {
                linkedHashMap.put(parcel.readString(), b.c.valueOf(parcel.readString()));
                i++;
            }
            if (parcel.readInt() == 0) {
                obj7 = 0;
            } else {
                obj7 = Long.valueOf(parcel.readLong());
            }
            b bVar = new b(parcel.readString(), linkedHashMap, parcel.createStringArrayList(), obj7);
            return bVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.v.b[] b(int i) {
            return new b[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u0000 \n2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "SEEN", "ACCEPTED", "UNKNOWN", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum c {

        SEEN("seen"),
        ACCEPTED("seen"),
        UNKNOWN("seen");

        private final String tag;
        private static final app.dogo.com.dogo_android.v.b.c[] $values() {
            app.dogo.com.dogo_android.v.b.c[] arr = new b.c[3];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getTag() {
            return this.tag;
        }
    }
    static {
        b.a aVar = new b.a(0);
        b.Companion = aVar;
        b.b bVar = new b.b();
        b.CREATOR = bVar;
    }

    public b(String string, Map<String, ? extends app.dogo.com.dogo_android.v.b.c> map2, List<String> list3, Long long4) {
        n.f(string, "id");
        n.f(map2, "policies");
        n.f(list3, "participating");
        super();
        this.a = string;
        this.b = map2;
        this.c = list3;
        this.v = long4;
    }

    public b(String string, Map map2, List list3, Long long4, int i5, g g6) {
        Map obj2;
        ArrayList obj3;
        int obj4;
        if (i5 & 2 != 0) {
            obj2 = j0.h();
        }
        if (i5 & 4 != 0) {
            obj3 = new ArrayList();
        }
        obj4 = i5 &= 8 != 0 ? 0 : obj4;
        super(string, obj2, obj3, obj4);
    }

    @Override // android.os.Parcelable
    public final String a() {
        return this.a;
    }

    public final List<String> b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final boolean c(String string) {
        int obj2;
        n.f(string, "policyId");
        obj2 = this.b.get(string) == b.c.ACCEPTED ? 1 : 0;
        return obj2;
    }

    @Override // android.os.Parcelable
    public final boolean d(String string) {
        n.f(string, "policyId");
        return this.b.containsKey(string);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final h e(String string, String string2) {
        int size;
        PolicyEntity policyEntity;
        Object key;
        n.f(string, "userId");
        n.f(string2, "currentDogId");
        UserEntity userEntity = new UserEntity(string, string2, this.v, this.c);
        Map obj7 = this.b;
        ArrayList arrayList = new ArrayList(obj7.size());
        obj7 = obj7.entrySet().iterator();
        for (Map.Entry next2 : obj7) {
            policyEntity = new PolicyEntity((String)next2.getKey(), (b.c)next2.getValue().getTag(), string);
            arrayList.add(policyEntity);
        }
        h obj6 = new h(userEntity, arrayList);
        return obj6;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof b) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        if (!n.b(this.v, object.v)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        Long num = this.v;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        return i7 += i;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User(id=");
        stringBuilder.append(this.a);
        stringBuilder.append(", policies=");
        stringBuilder.append(this.b);
        stringBuilder.append(", participating=");
        stringBuilder.append(this.c);
        stringBuilder.append(", abTestBucket=");
        stringBuilder.append(this.v);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        long longValue;
        Object key;
        Long obj4;
        n.f(parcel, "out");
        parcel.writeString(this.a);
        obj4 = this.b;
        parcel.writeInt(obj4.size());
        obj4 = obj4.entrySet().iterator();
        for (Map.Entry next : obj4) {
            parcel.writeString((String)next.getKey());
            parcel.writeString((b.c)next.getValue().name());
        }
        parcel.writeStringList(this.c);
        obj4 = this.v;
        if (obj4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(obj4.longValue());
        }
    }
}
