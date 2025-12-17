package app.dogo.com.dogo_android.u.m;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationTipsScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "variation", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "pausedTimeSeconds", "", "source", "", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;JLjava/lang/String;)V", "getPausedTimeSeconds", "()J", "getSource", "()Ljava/lang/String;", "getVariation", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.u.m.s> CREATOR;
    private final TrickItem a;
    private final long b;
    private final String c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.u.m.s> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.u.m.s a(Parcel parcel) {
            n.f(parcel, "parcel");
            s sVar = new s((TrickItem)TrickItem.CREATOR.createFromParcel(parcel), parcel.readLong(), obj3, parcel.readString());
            return sVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.u.m.s[] b(int i) {
            return new s[i];
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
        s.a aVar = new s.a();
        s.CREATOR = aVar;
    }

    public s(TrickItem trickItem, long l2, String string3) {
        n.f(trickItem, "variation");
        n.f(obj5, "source");
        super();
        this.a = trickItem;
        this.b = l2;
        this.c = obj5;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final long a() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final TrickItem b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        r rVar = new r();
        return rVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        n2 n2Var = new n2();
        return j3.d1.b(r2Var, this.c, n2Var, this.a.getId());
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        parcel.writeLong(this.b);
        parcel.writeString(this.c);
    }
}
