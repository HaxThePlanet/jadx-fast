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

/* compiled from: User.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000 /2\u00020\u0001:\u0002/0B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001cHÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/temp/User;", "Landroid/os/Parcelable;", "id", "", "policies", "", "Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "participating", "", "abTestBucket", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Long;)V", "getAbTestBucket", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "()Ljava/lang/String;", "getParticipating", "()Ljava/util/List;", "getPolicies", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/lang/Long;)Lapp/dogo/com/dogo_android/temp/User;", "describeContents", "", "equals", "", "other", "", "hashCode", "isPolicyAccepted", "policyId", "isPolicySeen", "toString", "toUserFullEntity", "Lapp/dogo/android/persistencedb/room/relations/UserFullEntity;", "userId", "currentDogId", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "PolicyStatus", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b, reason: from kotlin metadata */
public final /* data */ class User implements Parcelable {

    public static final Parcelable.Creator<b> CREATOR = new b$b<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final b.a INSTANCE = new b$a(0);
    private final String a;
    private final Map<String, b.c> b;
    private final List<String> c;
    private final Long v;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/temp/User$Companion;", "", "()V", "CHALLENGE_TERMS_POLICY_ID", "", "NEWSLETTER_POLICY_ID", "fromEntity", "Lapp/dogo/com/dogo_android/temp/User;", "userEntity", "Lapp/dogo/android/persistencedb/room/relations/UserFullEntity;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final b fromEntity(h userEntity) {
            n.f(userEntity, "userEntity");
            List list = userEntity.a();
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                arrayList.add(new Pair(item.getId(), User_PolicyStatus.INSTANCE.a(item.getStatus())));
            }
            return new User(userEntity.b().getId(), j0.s(arrayList), p.N0(userEntity.b().getParticipatingInChallenges()), userEntity.b().getAbBucket());
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<b> {
        public final b a(Parcel parcel) {
            int i = 0;
            long l;
            Long num = null;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int);
            i = 0;
            while (i != _int) {
                linkedHashMap.put(parcel.readString(), User_PolicyStatus.valueOf(parcel.readString()));
                i = i + 1;
            }
            if (parcel.readInt() == 0) {
                int i2 = 0;
            } else {
                num = Long.valueOf(parcel.readLong());
            }
            return new User(parcel.readString(), linkedHashMap, parcel.createStringArrayList(), num);
        }

        public final b[] b(int i) {
            return new b[i];
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0008\u0086\u0001\u0018\u0000 \n2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "SEEN", "ACCEPTED", "UNKNOWN", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum c {

        ACCEPTED,
        SEEN,
        UNKNOWN;

        private final String tag;
        @Override // java.lang.Enum
        public final String getTag() {
            return this.tag;
        }

        private static final /* synthetic */ b.c[] $values() {
            app.dogo.com.dogo_android.v.b.c[] arr = new b.c[3];
            return new b.c[] { User_PolicyStatus.SEEN, User_PolicyStatus.ACCEPTED, User_PolicyStatus.UNKNOWN };
        }
    }
    public b(String str, Map<String, ? extends b.c> map, List<String> list, Long long) {
        n.f(str, "id");
        n.f(map, "policies");
        n.f(list, "participating");
        super();
        this.a = str;
        this.b = map;
        this.c = list;
        this.v = long;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final String component1() {
        return this.a;
    }

    public final List<String> b() {
        return this.c;
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* operator */ public final boolean equals(String other) {
        boolean z = true;
        n.f(other, "policyId");
        other = this.b.get(other) == User_PolicyStatus.ACCEPTED ? 1 : 0;
        return (this.b.get(other) == User_PolicyStatus.ACCEPTED ? 1 : 0);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final boolean isPolicyAccepted(String policyId) {
        n.f(policyId, "policyId");
        return this.b.containsKey(policyId);
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final h toUserFullEntity(String userId, String currentDogId) {
        n.f(userId, "userId");
        n.f(currentDogId, "currentDogId");
        ArrayList arrayList = new ArrayList(this.b.size());
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            arrayList.add(new PolicyEntity((String)item.getKey(), (User_PolicyStatus)item.getValue().getTag(), userId));
        }
        return new UserFullEntity(new UserEntity(userId, currentDogId, this.v, this.c), arrayList);
    }

    public /* synthetic */ b(String str, Map map, List list, Long long, int i, g gVar) {
        ArrayList arrayList;
        Long l = null;
        if (i & 2 != 0) {
            map = j0.h();
        }
        if (i & 4 != 0) {
            arrayList = new ArrayList();
        }
        i = i & 8 != 0 ? 0 : i;
        this(str, map, arrayList, l);
    }


    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z6 = false;
        if (!(object instanceof User)) {
            return false;
        }
        if (!n.b(this.a, object.a)) {
            return false;
        }
        if (!n.b(this.b, object.b)) {
            return false;
        }
        if (!n.b(this.c, object.c)) {
            return false;
        }
        return !n.b(this.v, object.v) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.v == null) {
            i = 0;
        } else {
            i = this.v.hashCode();
        }
        return (this.a.hashCode() * 31) + this.b.hashCode() * 31 + this.c.hashCode() * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "User(id=";
        String str4 = ", policies=";
        String str5 = ", participating=";
        String str6 = ", abTestBucket=";
        str = str2 + this.a + str4 + this.b + str5 + this.c + str6 + this.v + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Object key;
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeInt(this.b.size());
        Iterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            parcel.writeString((String)item.getKey());
            parcel.writeString((User_PolicyStatus)item.getValue().name());
        }
        parcel.writeStringList(this.c);
        if (this.v == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(this.v.longValue());
        }
    }
}
