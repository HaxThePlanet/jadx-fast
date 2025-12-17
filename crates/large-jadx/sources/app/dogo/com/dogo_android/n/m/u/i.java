package app.dogo.com.dogo_android.n.m.u;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.n.m.n;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/PausedTrickDetailsScreen;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsScreen;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "source", "", "pauseTimeSec", "", "(Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;Ljava/lang/String;J)V", "getPauseTimeSec", "()Ljava/lang/Long;", "getSession", "()Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "getSource", "()Ljava/lang/String;", "createFragment", "Landroidx/fragment/app/Fragment;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class i extends app.dogo.com.dogo_android.n.m.u.m {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.n.m.u.i> CREATOR;
    private final n x;
    private final String y;
    private final long z;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.n.m.u.i> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.m.u.i a(Parcel parcel) {
            n.f(parcel, "parcel");
            i iVar = new i((n)parcel.readParcelable(i.class.getClassLoader()), parcel.readString(), parcel.readLong(), obj4);
            return iVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.n.m.u.i[] b(int i) {
            return new i[i];
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
        i.a aVar = new i.a();
        i.CREATOR = aVar;
    }

    public i(n n, String string2, long l3) {
        n.f(n, "session");
        n.f(string2, "source");
        String str3 = "";
        super(n, str3, str3, string2);
        this.x = n;
        this.y = string2;
        this.z = l3;
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    public Long a() {
        return Long.valueOf(this.z);
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    public n b() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    protected Fragment createFragment() {
        l lVar = new l();
        return lVar;
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    public String getSource() {
        return this.y;
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeParcelable(this.x, i2);
        parcel.writeString(this.y);
        parcel.writeLong(this.z);
    }
}
