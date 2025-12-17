package app.dogo.com.dogo_android.x.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/metricintroduction/MetricsIntroductionInteractionsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "fragmentParentReturnTag", "", "(Ljava/lang/String;)V", "getFragmentParentReturnTag", "()Ljava/lang/String;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.x.c.h> CREATOR;
    private final String a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.x.c.h> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.x.c.h a(Parcel parcel) {
            n.f(parcel, "parcel");
            h hVar = new h(parcel.readString());
            return hVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.x.c.h[] b(int i) {
            return new h[i];
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
        h.a aVar = new h.a();
        h.CREATOR = aVar;
    }

    public h(String string) {
        n.f(string, "fragmentParentReturnTag");
        super();
        this.a = string;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        g gVar = new g();
        return gVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.Z0.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
    }
}
