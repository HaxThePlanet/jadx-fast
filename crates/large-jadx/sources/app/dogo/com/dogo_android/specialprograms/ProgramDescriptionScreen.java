package app.dogo.com.dogo_android.u;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ProgramDescriptionScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000b\u001a\u00020\u000cH\u0014J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/ProgramDescriptionScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "contentText", "", "programId", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContentText", "()Ljava/lang/String;", "getProgramId", "getSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class ProgramDescriptionScreen extends j {

    public static final Parcelable.Creator<g> CREATOR = new g$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String contentText;
    /* renamed from: b, reason: from kotlin metadata */
    private final String programId;
    /* renamed from: c, reason: from kotlin metadata */
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<g> {
        public final g a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ProgramDescriptionScreen(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final g[] b(int i) {
            return new g[i];
        }
    }
    public g(String str, String str2, String str3) {
        n.f(str, "contentText");
        n.f(str2, "programId");
        n.f(str3, "source");
        super();
        this.contentText = str;
        this.programId = str2;
        this.source = str3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final String createFragment() {
        return this.contentText;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ProgramDescriptionFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.e1.b(new EP_ProgramId(), this.programId, new EP_ViewSource(), this.source);
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.contentText);
        parcel.writeString(this.programId);
        parcel.writeString(this.source);
    }
}
