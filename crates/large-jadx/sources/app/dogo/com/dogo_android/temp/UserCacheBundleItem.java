package app.dogo.com.dogo_android.v;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: UserCacheBundleItem.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0008HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0008HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/temp/UserCacheBundleItem;", "Landroid/os/Parcelable;", "user", "Lapp/dogo/com/dogo_android/temp/User;", "dogs", "", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "currentDogId", "", "(Lapp/dogo/com/dogo_android/temp/User;Ljava/util/List;Ljava/lang/String;)V", "getCurrentDogId", "()Ljava/lang/String;", "getDogs", "()Ljava/util/List;", "getUser", "()Lapp/dogo/com/dogo_android/temp/User;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final /* data */ class UserCacheBundleItem implements Parcelable {

    public static final Parcelable.Creator<d> CREATOR = new d$a<>();
    private final b a;
    /* renamed from: b, reason: from kotlin metadata */
    private final List<DogProfile> dogs;
    private final String c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<d> {
        public final d a(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(DogProfile.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new UserCacheBundleItem((User)User.CREATOR.createFromParcel(parcel), arrayList, parcel.readString());
        }

        public final d[] b(int i) {
            return new d[i];
        }
    }
    public d(b bVar, List<DogProfile> list, String str) {
        n.f(bVar, "user");
        n.f(list, "dogs");
        n.f(str, "currentDogId");
        super();
        this.a = bVar;
        this.dogs = list;
        this.c = str;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final String component1() {
        return this.c;
    }

    public final List<DogProfile> b() {
        return this.dogs;
    }

    public final b c() {
        return this.a;
    }


    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof UserCacheBundleItem)) {
            return false;
        }
        if (!n.b(this.a, other.a)) {
            return false;
        }
        if (!n.b(this.dogs, other.dogs)) {
            return false;
        }
        return !n.b(this.c, other.c) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a.hashCode() * 31) + this.dogs.hashCode() * 31 + this.c.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserCacheBundleItem(user=";
        String str3 = ", dogs=";
        String str4 = ", currentDogId=";
        str = str2 + this.a + str3 + this.dogs + str4 + this.c + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, flags);
        parcel.writeInt(this.dogs.size());
        Iterator it = this.dogs.iterator();
        while (it.hasNext()) {
            (DogProfile)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.c);
    }
}
