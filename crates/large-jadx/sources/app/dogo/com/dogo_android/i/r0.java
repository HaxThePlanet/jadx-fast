package app.dogo.com.dogo_android.i;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000b\u001a\u00020\u000cH\u0014J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "remoteKey", "", "selectionList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getRemoteKey", "()Ljava/lang/String;", "getSelectionList", "()Ljava/util/List;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r0 extends e {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.i.r0> CREATOR;
    private final String a;
    private final List<String> b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.i.r0> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.i.r0 a(Parcel parcel) {
            n.f(parcel, "parcel");
            r0 r0Var = new r0(parcel.readString(), parcel.createStringArrayList());
            return r0Var;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.i.r0[] b(int i) {
            return new r0[i];
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
        r0.a aVar = new r0.a();
        r0.CREATOR = aVar;
    }

    public r0(String string, List<String> list2) {
        n.f(string, "remoteKey");
        n.f(list2, "selectionList");
        super();
        this.a = string;
        this.b = list2;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final String a() {
        return this.a;
    }

    public final List<String> b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        p0 p0Var = new p0();
        return p0Var;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return j3.E0.f();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeStringList(this.b);
    }
}
