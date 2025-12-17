package app.dogo.com.dogo_android.welcome_v2;

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
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0008\u0010\t\u001a\u00020\nH\u0014J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "dogName", "", "dogId", "(Ljava/lang/String;Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getDogName", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class u0 extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.welcome_v2.u0> CREATOR;
    private final String a;
    private final String b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.welcome_v2.u0> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.welcome_v2.u0 a(Parcel parcel) {
            n.f(parcel, "parcel");
            u0 u0Var = new u0(parcel.readString(), parcel.readString());
            return u0Var;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.welcome_v2.u0[] b(int i) {
            return new u0[i];
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
        u0.a aVar = new u0.a();
        u0.CREATOR = aVar;
    }

    public u0(String string, String string2) {
        n.f(string, "dogName");
        n.f(string2, "dogId");
        super();
        this.a = string;
        this.b = string2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String a() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        t0 t0Var = new t0();
        return t0Var;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.J0.b(r2Var, "onboarding");
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }
}
