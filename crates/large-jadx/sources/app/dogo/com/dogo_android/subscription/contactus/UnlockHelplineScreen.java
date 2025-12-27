package app.dogo.com.dogo_android.subscription.contactus;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;

/* compiled from: UnlockHelplineScreen.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0008\u0010\u0010\u001a\u00020\u0011H\u0014J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\nHÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/subscription/contactus/UnlockHelplineScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "fragmentReturnTag", "(Ljava/lang/String;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "component1", "component2", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UnlockHelplineScreen extends j {

    public static final Parcelable.Creator<UnlockHelplineScreen> CREATOR = new UnlockHelplineScreen$Creator<>();
    private final String fragmentReturnTag;
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UnlockHelplineScreen> {
        @Override // android.os.Parcelable$Creator
        public final UnlockHelplineScreen createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new UnlockHelplineScreen(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final UnlockHelplineScreen[] newArray(int i) {
            return new UnlockHelplineScreen[i];
        }
    }
    public UnlockHelplineScreen(String str, String str2) {
        n.f(str, "source");
        n.f(str2, "fragmentReturnTag");
        super();
        this.source = str;
        this.fragmentReturnTag = str2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new UnlockHelplineFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.x0.c(u.a(new EP_ViewSource(), this.source));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String getSource() {
        return this.source;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100375;
    }


    public static /* synthetic */ UnlockHelplineScreen copy$default(UnlockHelplineScreen unlockHelplineScreen, String str, String str2, int i, Object object) {
        String source2;
        String fragmentReturnTag;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
            fragmentReturnTag = unlockHelplineScreen.getFragmentReturnTag();
        }
        return unlockHelplineScreen.copy(source2, fragmentReturnTag);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public final String component1() {
        return this.source;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* operator */ public final String component2() {
        return getFragmentReturnTag();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final UnlockHelplineScreen copy(String source, String fragmentReturnTag) {
        n.f(source, "source");
        n.f(fragmentReturnTag, "fragmentReturnTag");
        return new UnlockHelplineScreen(source, fragmentReturnTag);
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
        final boolean z4 = false;
        if (!(other instanceof UnlockHelplineScreen)) {
            return false;
        }
        if (!n.b(this.source, other.source)) {
            return false;
        }
        return !n.b(getFragmentReturnTag(), other.getFragmentReturnTag()) ? z4 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        return (this.source.hashCode() * 31) + getFragmentReturnTag().hashCode();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UnlockHelplineScreen(source=";
        String str3 = ", fragmentReturnTag=";
        String fragmentReturnTag = getFragmentReturnTag();
        str = str2 + this.source + str3 + fragmentReturnTag + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.source);
        parcel.writeString(this.fragmentReturnTag);
    }
}
