package app.dogo.com.dogo_android.y.y;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u000e\u001a\u00020\u000fH\u0014J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "fragmentParentReturnTag", "", "calledFromLibrary", "", "(Ljava/lang/String;Z)V", "getCalledFromLibrary", "()Z", "getFragmentParentReturnTag", "()Ljava/lang/String;", "component1", "component2", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.y.g> CREATOR;
    private final String a;
    private final boolean b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.y.g> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.y.g a(Parcel parcel) {
            int obj3;
            n.f(parcel, "parcel");
            obj3 = parcel.readInt() != 0 ? 1 : 0;
            g gVar = new g(parcel.readString(), obj3);
            return gVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.y.g[] b(int i) {
            return new g[i];
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
        g.a aVar = new g.a();
        g.CREATOR = aVar;
    }

    public g() {
        final int i = 0;
        super(i, 0, 3, i);
    }

    public g(String string, boolean z2) {
        n.f(string, "fragmentParentReturnTag");
        super();
        this.a = string;
        this.b = z2;
    }

    public g(String string, boolean z2, int i3, g g4) {
        String obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? "" : obj1;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.y.y.g a(String string, boolean z2) {
        n.f(string, "fragmentParentReturnTag");
        g gVar = new g(string, z2);
        return gVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        f fVar = new f();
        return fVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.h0.f();
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
        if (!object instanceof g) {
            return i2;
        }
        if (!n.b(getFragmentParentReturnTag(), (g)object.getFragmentParentReturnTag())) {
            return i2;
        }
        if (this.b != object.b) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z;
        if (this.b) {
            z = 1;
        }
        return i2 += z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramListScreen(fragmentParentReturnTag=");
        stringBuilder.append(getFragmentParentReturnTag());
        stringBuilder.append(", calledFromLibrary=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
    }
}
