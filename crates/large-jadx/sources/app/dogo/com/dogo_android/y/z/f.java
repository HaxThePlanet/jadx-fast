package app.dogo.com.dogo_android.y.z;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\u000cJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0008HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JQ\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0008\u0010#\u001a\u00020$H\u0014J\u0008\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0018HÖ\u0001J\u0013\u0010(\u001a\u00020\u00082\u0008\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0018HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programId", "", "programColorHex", "programOverview", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "calledFromLibrary", "", "calledFromOnboarding", "fragmentParentReturnTag", "source", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;ZZLjava/lang/String;Ljava/lang/String;)V", "getCalledFromLibrary", "()Z", "getCalledFromOnboarding", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getProgramColorHex", "getProgramId", "getProgramOverview", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.z.f> CREATOR;
    private final String a;
    private final String b;
    private final ProgramOverview c;
    private final boolean v;
    private final boolean w;
    private final String x;
    private final String y;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.z.f> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.z.f a(Parcel parcel) {
            Object fromParcel;
            int i;
            int i2;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                fromParcel = 0;
            } else {
                fromParcel = ProgramOverview.CREATOR.createFromParcel(parcel);
            }
            int i3 = 1;
            i2 = parcel.readInt() != 0 ? i3 : i;
            if (parcel.readInt() != 0) {
                i = i3;
            }
            super(parcel.readString(), parcel.readString(), (ProgramOverview)fromParcel, i2, i, parcel.readString(), parcel.readString());
            return fVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.z.f[] b(int i) {
            return new f[i];
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
        f.a aVar = new f.a();
        f.CREATOR = aVar;
    }

    public f(String string, String string2, ProgramOverview programOverview3, boolean z4, boolean z5, String string6, String string7) {
        n.f(string, "programId");
        n.f(string2, "programColorHex");
        n.f(string6, "fragmentParentReturnTag");
        n.f(string7, "source");
        super();
        this.a = string;
        this.b = string2;
        this.c = programOverview3;
        this.v = z4;
        this.w = z5;
        this.x = string6;
        this.y = string7;
    }

    public f(String string, String string2, ProgramOverview programOverview3, boolean z4, boolean z5, String string6, String string7, int i8, g g9) {
        int i;
        int i2;
        final int i5 = 0;
        i = i8 & 8 != 0 ? i5 : z4;
        i2 = i8 & 16 != 0 ? i5 : z5;
        super(string, string2, programOverview3, i, i2, string6, string7);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean a() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean b() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String c() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        e eVar = new e();
        return eVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.n0.c(u.a(r2Var, this.y));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String d() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramOverview e() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof f) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        if (this.v != object.v) {
            return i2;
        }
        if (this.w != object.w) {
            return i2;
        }
        if (!n.b(getFragmentParentReturnTag(), (f)object.getFragmentParentReturnTag())) {
            return i2;
        }
        if (!n.b(this.y, object.y)) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100375;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        int i;
        boolean z;
        boolean i2;
        ProgramOverview programOverview = this.c;
        if (programOverview == null) {
            i = 0;
        } else {
            i = programOverview.hashCode();
        }
        if (this.v) {
            z = i2;
        }
        boolean z2 = this.w;
        if (z2) {
        } else {
            i2 = z2;
        }
        return i14 += i18;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramOverviewScreen(programId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", programColorHex=");
        stringBuilder.append(this.b);
        stringBuilder.append(", programOverview=");
        stringBuilder.append(this.c);
        stringBuilder.append(", calledFromLibrary=");
        stringBuilder.append(this.v);
        stringBuilder.append(", calledFromOnboarding=");
        stringBuilder.append(this.w);
        stringBuilder.append(", fragmentParentReturnTag=");
        stringBuilder.append(getFragmentParentReturnTag());
        stringBuilder.append(", source=");
        stringBuilder.append(this.y);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        ProgramOverview programOverview = this.c;
        if (programOverview == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            programOverview.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
    }
}
