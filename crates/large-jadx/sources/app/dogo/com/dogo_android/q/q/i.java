package app.dogo.com.dogo_android.q.q;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0008\u0010\r\u001a\u00020\u000eH\u0014J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "requestKey", "", "skipWelcomeScreen", "", "source", "(Ljava/lang/String;ZLjava/lang/String;)V", "getRequestKey", "()Ljava/lang/String;", "getSkipWelcomeScreen", "()Z", "getSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends e {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.q.q.i> CREATOR;
    private final String a;
    private final boolean b;
    private final String c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.q.q.i> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.q.i a(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            i iVar = new i(parcel.readString(), i, parcel.readString());
            return iVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.q.i[] b(int i) {
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

    public i(String string, boolean z2, String string3) {
        n.f(string, "requestKey");
        n.f(string3, "source");
        super();
        this.a = string;
        this.b = z2;
        this.c = string3;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final String a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final boolean b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        h hVar = new h();
        return hVar;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return j3.g.f();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final String getSource() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
    }
}
