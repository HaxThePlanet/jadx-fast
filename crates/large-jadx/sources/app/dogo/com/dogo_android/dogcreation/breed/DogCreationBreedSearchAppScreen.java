package app.dogo.com.dogo_android.dogcreation.j;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogCreationBreedSearchAppScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchAppScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "initialFilterValue", "", "(Ljava/lang/String;)V", "getInitialFilterValue", "()Ljava/lang/String;", "createFragment", "Landroidx/fragment/app/DialogFragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class DogCreationBreedSearchAppScreen extends e {

    public static final Parcelable.Creator<k> CREATOR = new k$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String initialFilterValue;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<k> {
        public final k a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new DogCreationBreedSearchAppScreen(parcel.readString());
        }

        public final k[] b(int i) {
            return new k[i];
        }
    }
    public k(String str) {
        n.f(str, "initialFilterValue");
        super();
        this.initialFilterValue = str;
    }

    @Override // app.dogo.com.dogo_android.util.e
    /* renamed from: a, reason: from kotlin metadata */
    protected d createFragment() {
        final app.dogo.com.dogo_android.dogcreation.j.l dogCreationBreedSearchDialog = new DogCreationBreedSearchDialog();
        dogCreationBreedSearchDialog.setStyle(0, 2131951968);
        return dogCreationBreedSearchDialog;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final String b() {
        return this.initialFilterValue;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return S.onboardingGenerateProgram.withoutParameters();
    }

    public /* synthetic */ k(String str, int i, g gVar) {
        String str2;
        str2 = i & 1 != 0 ? "" : str2;
        this(str2);
    }


    public k() {
        final String str = null;
        this(str, 1, str);
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.initialFilterValue);
    }
}
