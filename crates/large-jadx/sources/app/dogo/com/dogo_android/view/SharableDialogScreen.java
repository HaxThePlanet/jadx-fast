package app.dogo.com.dogo_android.view;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: SharableDialogScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/view/SharableDialogScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "sharableDeeplink", "", "(Ljava/lang/String;)V", "getSharableDeeplink", "()Ljava/lang/String;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class SharableDialogScreen extends j {

    public static final Parcelable.Creator<o> CREATOR = new o$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String sharableDeeplink;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<o> {
        public final o a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new SharableDialogScreen(parcel.readString());
        }

        public final o[] b(int i) {
            return new o[i];
        }
    }
    public o(String str) {
        n.f(str, "sharableDeeplink");
        super();
        this.sharableDeeplink = str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final String createFragment() {
        return this.sharableDeeplink;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        throw new RuntimeException("Do not call this method");
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        throw new RuntimeException("nothing to track");
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.sharableDeeplink);
    }
}
