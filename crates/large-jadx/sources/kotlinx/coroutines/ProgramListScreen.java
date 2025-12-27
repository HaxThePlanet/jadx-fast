package app.dogo.com.dogo_android.y.y;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramListScreen.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u000e\u001a\u00020\u000fH\u0014J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programList/ProgramListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "fragmentParentReturnTag", "", "calledFromLibrary", "", "(Ljava/lang/String;Z)V", "getCalledFromLibrary", "()Z", "getFragmentParentReturnTag", "()Ljava/lang/String;", "component1", "component2", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final /* data */ class ProgramListScreen extends j {

    public static final Parcelable.Creator<g> CREATOR = new g$a<>();
    private final String a;
    private final boolean b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<g> {
        public final g a(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            ProgramListScreen programListScreen = new ProgramListScreen(parcel.readString(), (parcel.readInt() != 0 ? 1 : 0));
            return programListScreen;
        }

        public final g[] b(int i) {
            return new g[i];
        }
    }
    public g(String str, boolean z) {
        n.f(str, "fragmentParentReturnTag");
        super();
        this.a = str;
        this.b = z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: b, reason: from kotlin metadata */
    /* operator */ public final boolean component1() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ProgramListFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.onboardingName.withoutParameters();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.a;
    }

    public /* synthetic */ g(String str, boolean z, int i, g gVar) {
        String str2;
        str2 = i & 1 != 0 ? "" : str2;
        i = i & 2 != 0 ? 0 : i;
        this(str2, z);
    }


    public g() {
        final String str = null;
        this(str, false, 3, str);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final g copy(String fragmentParentReturnTag, boolean calledFromLibrary) {
        n.f(fragmentParentReturnTag, "fragmentParentReturnTag");
        return new ProgramListScreen(fragmentParentReturnTag, calledFromLibrary);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof ProgramListScreen)) {
            return false;
        }
        if (!n.b(getFragmentParentReturnTag(), other.getFragmentParentReturnTag())) {
            return false;
        }
        return this.b != other.b ? z5 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z = true;
        if (this.b) {
            int i4 = 1;
        }
        return (getFragmentParentReturnTag().hashCode() * 31) + z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramListScreen(fragmentParentReturnTag=";
        String fragmentParentReturnTag = getFragmentParentReturnTag();
        String str3 = ", calledFromLibrary=";
        str = str2 + fragmentParentReturnTag + str3 + this.b + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
    }
}
