package app.dogo.com.dogo_android.n.m.u;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

/* compiled from: PausedTrickDetailsScreen.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/PausedTrickDetailsScreen;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsScreen;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "source", "", "pauseTimeSec", "", "(Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;Ljava/lang/String;J)V", "getPauseTimeSec", "()Ljava/lang/Long;", "getSession", "()Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan;", "getSource", "()Ljava/lang/String;", "createFragment", "Landroidx/fragment/app/Fragment;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public class PausedTrickDetailsScreen extends m {

    public static final Parcelable.Creator<i> CREATOR = new i$a<>();
    private final app.dogo.com.dogo_android.n.m.n x;
    private final String y;
    private final long z;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<i> {
        public final i a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new PausedTrickDetailsScreen((TrickDetailsPlan)parcel.readParcelable(PausedTrickDetailsScreen.class.getClassLoader()), parcel.readString(), parcel.readLong(), r4);
        }

        public final i[] b(int i) {
            return new i[i];
        }
    }
    public i(app.dogo.com.dogo_android.n.m.n nVar, String str, long j) {
        n.f(nVar, "session");
        n.f(str, "source");
        String str4 = "";
        super(nVar, str4, str4, str);
        this.x = nVar;
        this.y = str;
        this.z = j;
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    /* renamed from: a, reason: from kotlin metadata */
    public Long createFragment() {
        return Long.valueOf(this.z);
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    public app.dogo.com.dogo_android.n.m.n b() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    protected Fragment createFragment() {
        return new TrickDetailsFragment();
    }

    @Override // app.dogo.com.dogo_android.n.m.u.m
    public String getSource() {
        return this.y;
    }


    @Override // app.dogo.com.dogo_android.n.m.u.m
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeParcelable(this.x, flags);
        parcel.writeString(this.y);
        parcel.writeLong(this.z);
    }
}
