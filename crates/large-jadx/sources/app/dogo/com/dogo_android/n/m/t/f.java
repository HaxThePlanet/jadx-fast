package app.dogo.com.dogo_android.n.m.t;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.n.m.n;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0017\u001a\u00020\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000b\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickScreen2;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "trainingDurationMs", "", "source", "", "fragmentReturnTag", "fragmentParentReturnTag", "(Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getFragmentReturnTag", "getSession", "()Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "getSource", "getTrainingDurationMs", "()J", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.n.m.t.f> CREATOR;
    private final n a;
    private final DogProfile b;
    private final long c;
    private final String v;
    private final String w;
    private final String x;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.n.m.t.f> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.m.t.f a(Parcel parcel) {
            n.f(parcel, "parcel");
            super((n)parcel.readParcelable(f.class.getClassLoader()), (DogProfile)DogProfile.CREATOR.createFromParcel(parcel), parcel.readLong(), obj5, parcel.readString(), parcel.readString(), parcel.readString());
            return fVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.m.t.f[] b(int i) {
            return new f[i];
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
        f.a aVar = new f.a();
        f.CREATOR = aVar;
    }

    public f(n n, DogProfile dogProfile2, long l3, String string4, String string5, String string6) {
        n.f(n, "session");
        n.f(dogProfile2, "dogProfile");
        n.f(string5, "source");
        n.f(string6, "fragmentReturnTag");
        n.f(obj8, "fragmentParentReturnTag");
        super();
        this.a = n;
        this.b = dogProfile2;
        this.c = l3;
        this.v = string5;
        this.w = string6;
        this.x = obj8;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final DogProfile a() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final n b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final long c() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        e eVar = new e();
        return eVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        int i;
        r2 r2Var = new r2();
        n2 n2Var = new n2();
        TrickItem trickItem = this.a.a();
        if (trickItem == null) {
            i = 0;
        } else {
            i = trickItem.getId();
        }
        return j3.y.b(r2Var, this.v, n2Var, i);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String getSource() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeParcelable(this.a, i2);
        this.b.writeToParcel(parcel, i2);
        parcel.writeLong(this.c);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
    }
}
