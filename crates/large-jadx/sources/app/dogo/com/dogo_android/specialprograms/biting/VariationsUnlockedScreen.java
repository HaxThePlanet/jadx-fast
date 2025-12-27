package app.dogo.com.dogo_android.u.m;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.r2;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: VariationsUnlockedScreen.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0014J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0008\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationsUnlockedScreen;", "Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "source", "", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "fragmentReturnTag", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "getTrickItem", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w, reason: from kotlin metadata */
public final class VariationsUnlockedScreen extends g {

    public static final Parcelable.Creator<w> CREATOR = new w$a<>();
    /* renamed from: v, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    private final TrickItem w;
    private final ProgramSaveInfo x;
    private final String y;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<w> {
        public final w a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new VariationsUnlockedScreen(parcel.readString(), (TrickItem)TrickItem.CREATOR.createFromParcel(parcel), (ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        public final w[] b(int i) {
            return new w[i];
        }
    }
    public w(String str, TrickItem trickItem, ProgramSaveInfo programSaveInfo, String str2) {
        n.f(str, "source");
        n.f(trickItem, "trickItem");
        n.f(programSaveInfo, "saveInfo");
        n.f(str2, "fragmentReturnTag");
        super(str2);
        this.fragmentReturnTag = str;
        this.w = trickItem;
        this.x = programSaveInfo;
        this.y = str2;
    }

    @Override // app.dogo.com.dogo_android.util.g
    protected Fragment createFragment() {
        return new VariationsUnlockedFragment();
    }

    @Override // app.dogo.com.dogo_android.util.g
    public i3 createTrackingParameters() {
        return S.profilePreview.b(new EP_ViewSource(), this.fragmentReturnTag, new EP_TrickId(), this.w.getId());
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final ProgramSaveInfo e() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final TrickItem f() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public String getFragmentReturnTag() {
        return this.y;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final String getSource() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public Integer getStatusBarColor() {
        return 2131100375;
    }


    @Override // app.dogo.com.dogo_android.util.g
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.fragmentReturnTag);
        this.w.writeToParcel(parcel, flags);
        this.x.writeToParcel(parcel, flags);
        parcel.writeString(this.y);
    }
}
