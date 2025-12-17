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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0008\u0010\u0010\u001a\u00020\u0011H\u0014J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\nHÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/subscription/contactus/UnlockHelplineScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "fragmentReturnTag", "(Ljava/lang/String;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "component1", "component2", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UnlockHelplineScreen extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen> CREATOR;
    private final String fragmentReturnTag;
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            UnlockHelplineScreen unlockHelplineScreen = new UnlockHelplineScreen(parcel.readString(), parcel.readString());
            return unlockHelplineScreen;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen[] newArray(int i) {
            return new UnlockHelplineScreen[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        UnlockHelplineScreen.Creator creator = new UnlockHelplineScreen.Creator();
        UnlockHelplineScreen.CREATOR = creator;
    }

    public UnlockHelplineScreen(String string, String string2) {
        n.f(string, "source");
        n.f(string2, "fragmentReturnTag");
        super();
        this.source = string;
        this.fragmentReturnTag = string2;
    }

    public static app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen copy$default(app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen unlockHelplineScreen, String string2, String string3, int i4, Object object5) {
        String obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = unlockHelplineScreen.source;
        }
        if (i4 &= 2 != 0) {
            obj2 = unlockHelplineScreen.getFragmentReturnTag();
        }
        return unlockHelplineScreen.copy(obj1, obj2);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String component1() {
        return this.source;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String component2() {
        return getFragmentReturnTag();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.subscription.contactus.UnlockHelplineScreen copy(String string, String string2) {
        n.f(string, "source");
        n.f(string2, "fragmentReturnTag");
        UnlockHelplineScreen unlockHelplineScreen = new UnlockHelplineScreen(string, string2);
        return unlockHelplineScreen;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        UnlockHelplineFragment unlockHelplineFragment = new UnlockHelplineFragment();
        return unlockHelplineFragment;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.x0.c(u.a(r2Var, this.source));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof UnlockHelplineScreen) {
            return i2;
        }
        if (!n.b(this.source, object.source)) {
            return i2;
        }
        if (!n.b(getFragmentReturnTag(), (UnlockHelplineScreen)object.getFragmentReturnTag())) {
            return i2;
        }
        return i;
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

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        return i2 += i4;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UnlockHelplineScreen(source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", fragmentReturnTag=");
        stringBuilder.append(getFragmentReturnTag());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.source);
        parcel.writeString(this.fragmentReturnTag);
    }
}
