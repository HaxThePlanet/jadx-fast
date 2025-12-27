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

/* compiled from: DogSelectScreen.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0008\u0010\r\u001a\u00020\u000eH\u0014J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "requestKey", "", "skipWelcomeScreen", "", "source", "(Ljava/lang/String;ZLjava/lang/String;)V", "getRequestKey", "()Ljava/lang/String;", "getSkipWelcomeScreen", "()Z", "getSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class DogSelectScreen extends e {

    public static final Parcelable.Creator<i> CREATOR = new i$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String requestKey;
    /* renamed from: b, reason: from kotlin metadata */
    private final boolean skipWelcomeScreen;
    /* renamed from: c, reason: from kotlin metadata */
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<i> {
        public final i a(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            int r2 = parcel.readInt() != 0 ? 1 : 0;
            DogSelectScreen dogSelectScreen = new DogSelectScreen(parcel.readString(), (parcel.readInt() != 0 ? 1 : 0), parcel.readString());
            return dogSelectScreen;
        }

        public final i[] b(int i) {
            return new i[i];
        }
    }
    public i(String str, boolean z, String str2) {
        n.f(str, "requestKey");
        n.f(str2, "source");
        super();
        this.requestKey = str;
        this.skipWelcomeScreen = z;
        this.source = str2;
    }

    @Override // app.dogo.com.dogo_android.util.e
    /* renamed from: a, reason: from kotlin metadata */
    public final String createFragment() {
        return this.requestKey;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final boolean b() {
        return this.skipWelcomeScreen;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        return new DogSelectDialog();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return S.libraryTrickList.withoutParameters();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final String getSource() {
        return this.source;
    }


    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.requestKey);
        parcel.writeInt(this.skipWelcomeScreen);
        parcel.writeString(this.source);
    }
}
