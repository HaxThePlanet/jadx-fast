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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchAppScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "initialFilterValue", "", "(Ljava/lang/String;)V", "getInitialFilterValue", "()Ljava/lang/String;", "createFragment", "Landroidx/fragment/app/DialogFragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends e {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.dogcreation.j.k> CREATOR;
    private final String a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.dogcreation.j.k> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.dogcreation.j.k a(Parcel parcel) {
            n.f(parcel, "parcel");
            k kVar = new k(parcel.readString());
            return kVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.dogcreation.j.k[] b(int i) {
            return new k[i];
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
        k.a aVar = new k.a();
        k.CREATOR = aVar;
    }

    public k() {
        final int i = 0;
        super(i, 1, i);
    }

    public k(String string) {
        n.f(string, "initialFilterValue");
        super();
        this.a = string;
    }

    public k(String string, int i2, g g3) {
        String obj1;
        obj1 = i2 &= 1 != 0 ? "" : obj1;
        super(obj1);
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected d a() {
        l lVar = new l();
        lVar.setStyle(0, 2131951968);
        return lVar;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final String b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public Fragment createFragment() {
        return a();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return j3.h.f();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
    }
}
