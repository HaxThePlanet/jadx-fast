package app.dogo.com.dogo_android.y.r;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0017\u001a\u00020\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0008\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/firstexamunlocked/FirstExamUnlockedScreen;", "Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "fragmentReturnTag", "", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Ljava/lang/String;)V", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getFragmentReturnTag", "()Ljava/lang/String;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "getTrickItem", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends g {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.r.d> CREATOR;
    private final TrickItem v;
    private final ProgramSaveInfo w;
    private final DogProfile x;
    private final String y;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.r.d> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.r.d a(Parcel parcel) {
            n.f(parcel, "parcel");
            d dVar = new d((TrickItem)TrickItem.CREATOR.createFromParcel(parcel), (ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), (DogProfile)DogProfile.CREATOR.createFromParcel(parcel), parcel.readString());
            return dVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.r.d[] b(int i) {
            return new d[i];
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
        d.a aVar = new d.a();
        d.CREATOR = aVar;
    }

    public d(TrickItem trickItem, ProgramSaveInfo programSaveInfo2, DogProfile dogProfile3, String string4) {
        n.f(trickItem, "trickItem");
        n.f(programSaveInfo2, "programSaveInfo");
        n.f(dogProfile3, "dogProfile");
        n.f(string4, "fragmentReturnTag");
        super(string4);
        this.v = trickItem;
        this.w = programSaveInfo2;
        this.x = dogProfile3;
        this.y = string4;
    }

    @Override // app.dogo.com.dogo_android.util.g
    protected Fragment createFragment() {
        c cVar = new c();
        return cVar;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public i3 createTrackingParameters() {
        return j3.o0.f();
    }

    @Override // app.dogo.com.dogo_android.util.g
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final DogProfile e() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final ProgramSaveInfo f() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final TrickItem g() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public String getFragmentReturnTag() {
        return this.y;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public Integer getStatusBarColor() {
        return 2131100352;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.v.writeToParcel(parcel, i2);
        this.w.writeToParcel(parcel, i2);
        this.x.writeToParcel(parcel, i2);
        parcel.writeString(this.y);
    }
}
