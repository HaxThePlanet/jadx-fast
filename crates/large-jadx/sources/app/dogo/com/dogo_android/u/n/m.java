package app.dogo.com.dogo_android.u.n;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000b\u001a\u00020\u000cH\u0014J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0008HÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.u.n.m> CREATOR;
    private final String a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.u.n.m> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.u.n.m a(Parcel parcel) {
            n.f(parcel, "parcel");
            m mVar = new m(parcel.readString());
            return mVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.u.n.m[] b(int i) {
            return new m[i];
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
        m.a aVar = new m.a();
        m.CREATOR = aVar;
    }

    public m(String string) {
        n.f(string, "source");
        super();
        this.a = string;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        l lVar = new l();
        return lVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.i1.b(r2Var, this.a);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100375;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
    }
}
