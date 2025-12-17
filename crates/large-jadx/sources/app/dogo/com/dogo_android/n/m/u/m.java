package app.dogo.com.dogo_android.n.m.u;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.n.m.n;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.m;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0014\u001a\u00020\u0015H\u0014J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0008\u0010\u001a\u001a\u00020\u0005H\u0016J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0018\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\n¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "fragmentReturnTag", "", "fragmentParentReturnTag", "source", "(Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getFragmentReturnTag", "pauseTimeSec", "", "getPauseTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSession", "()Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "getSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "getTag", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class m extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.n.m.u.m> CREATOR;
    private final n a;
    private final String b;
    private final String c;
    private final String v;
    private final Long w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.n.m.u.m> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.m.u.m a(Parcel parcel) {
            n.f(parcel, "parcel");
            m mVar = new m((n)parcel.readParcelable(m.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString());
            return mVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.m.u.m[] b(int i) {
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

    public m(n n, String string2, String string3, String string4) {
        n.f(n, "session");
        n.f(string2, "fragmentReturnTag");
        n.f(string3, "fragmentParentReturnTag");
        n.f(string4, "source");
        super();
        this.a = n;
        this.b = string2;
        this.c = string3;
        this.v = string4;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Long a() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public n b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        l lVar = new l();
        return lVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        int i;
        n2 n2Var = new n2();
        TrickItem trickItem = b().a();
        if (trickItem == null) {
            i = 0;
        } else {
            i = trickItem.getId();
        }
        r2 r2Var = new r2();
        return j3.u.c(u.a(n2Var, i), u.a(r2Var, getSource()));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getSource() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getTag() {
        return j3.c.a();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeParcelable(this.a, i2);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.v);
    }
}
