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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0008HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0008HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/temp/UserCacheBundleItem;", "Landroid/os/Parcelable;", "user", "Lapp/dogo/com/dogo_android/temp/User;", "dogs", "", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "currentDogId", "", "(Lapp/dogo/com/dogo_android/temp/User;Ljava/util/List;Ljava/lang/String;)V", "getCurrentDogId", "()Ljava/lang/String;", "getDogs", "()Ljava/util/List;", "getUser", "()Lapp/dogo/com/dogo_android/temp/User;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.v.d> CREATOR;
    private final app.dogo.com.dogo_android.v.b a;
    private final List<DogProfile> b;
    private final String c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.v.d> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.v.d a(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(DogProfile.CREATOR.createFromParcel(parcel));
                i++;
            }
            d dVar = new d((b)b.CREATOR.createFromParcel(parcel), arrayList, parcel.readString());
            return dVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.v.d[] b(int i) {
            return new d[i];
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
    static {
        d.a aVar = new d.a();
        d.CREATOR = aVar;
    }

    public d(app.dogo.com.dogo_android.v.b b, List<DogProfile> list2, String string3) {
        n.f(b, "user");
        n.f(list2, "dogs");
        n.f(string3, "currentDogId");
        super();
        this.a = b;
        this.b = list2;
        this.c = string3;
    }

    @Override // android.os.Parcelable
    public final String a() {
        return this.c;
    }

    public final List<DogProfile> b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.v.b c() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof d) {
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
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserCacheBundleItem(user=");
        stringBuilder.append(this.a);
        stringBuilder.append(", dogs=");
        stringBuilder.append(this.b);
        stringBuilder.append(", currentDogId=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        List list = this.b;
        parcel.writeInt(list.size());
        Iterator iterator = list.iterator();
        for (DogProfile size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.c);
    }
}
