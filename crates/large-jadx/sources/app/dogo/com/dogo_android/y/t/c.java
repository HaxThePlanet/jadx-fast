package app.dogo.com.dogo_android.y.t;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0014J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessoncomplete/ProgramLessonCompleteScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "fragmentReturnTag", "", "fromProgramOverviewLibrary", "", "fromProgramOverviewOnboarding", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;Ljava/lang/String;ZZ)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getFromProgramOverviewLibrary", "()Z", "getFromProgramOverviewOnboarding", "getLessonItem", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.t.c> CREATOR;
    private final ProgramLessonItem a;
    private final String b;
    private final boolean c;
    private final boolean v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.t.c> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.t.c a(Parcel parcel) {
            int i;
            int i2;
            n.f(parcel, "parcel");
            final int i3 = 0;
            i = parcel.readInt() != 0 ? i2 : i3;
            if (parcel.readInt() != 0) {
            } else {
                i2 = i3;
            }
            c cVar = new c((ProgramLessonItem)ProgramLessonItem.CREATOR.createFromParcel(parcel), parcel.readString(), i, i2);
            return cVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.t.c[] b(int i) {
            return new c[i];
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
        c.a aVar = new c.a();
        c.CREATOR = aVar;
    }

    public c(ProgramLessonItem programLessonItem, String string2, boolean z3, boolean z4) {
        n.f(programLessonItem, "lessonItem");
        n.f(string2, "fragmentReturnTag");
        super();
        this.a = programLessonItem;
        this.b = string2;
        this.c = z3;
        this.v = z4;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean a() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean b() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramLessonItem c() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        b bVar = new b();
        return bVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.a0.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100352;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
    }
}
