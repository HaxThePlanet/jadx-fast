package app.dogo.com.dogo_android.n.m;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.w.b1;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0008\u0010\u000e\u001a\u00020\u000fH\u0014J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "category", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "selectedTag", "", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;Ljava/lang/String;)V", "getCategory", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "getSelectedTag", "()Ljava/lang/String;", "component1", "component2", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.n.m.q> CREATOR;
    private final TrickItem.TrickCategory a;
    private final String b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.n.m.q> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.m.q a(Parcel parcel) {
            n.f(parcel, "parcel");
            q qVar = new q((TrickItem.TrickCategory)TrickItem.TrickCategory.CREATOR.createFromParcel(parcel), parcel.readString());
            return qVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.m.q[] b(int i) {
            return new q[i];
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
        q.a aVar = new q.a();
        q.CREATOR = aVar;
    }

    public q(TrickItem.TrickCategory trickItem$TrickCategory, String string2) {
        n.f(trickCategory, "category");
        super();
        this.a = trickCategory;
        this.b = string2;
    }

    public q(TrickItem.TrickCategory trickItem$TrickCategory, String string2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(trickCategory, obj2);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final TrickItem.TrickCategory a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        p pVar = new p();
        return pVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        b1 b1Var = new b1();
        return j3.U0.b(b1Var, this.a.getId());
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof q) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        int i;
        String str = this.b;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return i3 += i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickListScreen(category=");
        stringBuilder.append(this.a);
        stringBuilder.append(", selectedTag=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        parcel.writeString(this.b);
    }
}
