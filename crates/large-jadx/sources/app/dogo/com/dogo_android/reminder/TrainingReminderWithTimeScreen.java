package app.dogo.com.dogo_android.r;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;

/* compiled from: TrainingReminderWithTimeScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0008\u001a\u00020\tH\u0014J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/reminder/TrainingReminderWithTimeScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "screenSource", "", "fragmentReturnTag", "(Ljava/lang/String;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class TrainingReminderWithTimeScreen extends j {

    public static final Parcelable.Creator<n> CREATOR = new n$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    /* renamed from: b, reason: from kotlin metadata */
    private final String screenSource;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<n> {
        public final n a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new TrainingReminderWithTimeScreen(parcel.readString(), parcel.readString());
        }

        public final n[] b(int i) {
            return new n[i];
        }
    }
    public n(String str, String str2) {
        n.f(str, "screenSource");
        n.f(str2, "fragmentReturnTag");
        super();
        this.fragmentReturnTag = str;
        this.screenSource = str2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new TrainingReminderWithTimeFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.dogOwnerInvitation.withParameters(u.a(new EP_ViewSource(), this.fragmentReturnTag));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.screenSource;
    }

    public /* synthetic */ n(String str, String str2, int i, g gVar) {
        String str3;
        str3 = i & 2 != 0 ? "" : str3;
        this(str, str3);
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeString(this.screenSource);
    }
}
