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

/* compiled from: ProgramOverviewScreen.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\u000cJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0008HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JQ\u0010\"\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0008\u0010#\u001a\u00020$H\u0014J\u0008\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0018HÖ\u0001J\u0013\u0010(\u001a\u00020\u00082\u0008\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0018HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0014\u0010\n\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001a¨\u00062", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programId", "", "programColorHex", "programOverview", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "calledFromLibrary", "", "calledFromOnboarding", "fragmentParentReturnTag", "source", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;ZZLjava/lang/String;Ljava/lang/String;)V", "getCalledFromLibrary", "()Z", "getCalledFromOnboarding", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getProgramColorHex", "getProgramId", "getProgramOverview", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final /* data */ class ProgramOverviewScreen extends j {

    public static final Parcelable.Creator<f> CREATOR = new f$a<>();
    private final String a;
    private final String b;
    private final ProgramOverview c;
    private final boolean v;
    private final boolean w;
    private final String x;
    /* renamed from: y, reason: from kotlin metadata */
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<f> {
        public final f a(Parcel parcel) {
            Object fromParcel = null;
            boolean z2 = false;
            int i;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i2 = 0;
            } else {
                fromParcel = ProgramOverview.CREATOR.createFromParcel(parcel);
            }
            i = 1;
            int r7 = parcel.readInt() != 0 ? i : 0;
            if (parcel.readInt() != 0) {
            }
            ProgramOverviewScreen programOverviewScreen = new ProgramOverviewScreen(parcel.readString(), parcel.readString(), (ProgramOverview)fromParcel, i, z2, string, parcel2);
            return programOverviewScreen;
        }

        public final f[] b(int i) {
            return new f[i];
        }
    }
    public /* synthetic */ f(String str, String str2, ProgramOverview programOverview, boolean z, boolean z2, String str3, String str4, int i, g gVar) {
        boolean z42;
        boolean z52;
        i = 0;
        int r6 = i & 8 != 0 ? i : z;
        int r7 = i & 16 != 0 ? i : z2;
        this(str, str2, programOverview, z42, (i & 16 != 0 ? i : z2), str3, str4);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final boolean component1() {
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
        return new ProgramOverviewFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.programLessonExamUnlockedScreen.withParameters(u.a(new EP_ViewSource(), this.source));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String d() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramOverview e() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100375;
    }

    public f(String str, String str2, ProgramOverview programOverview, boolean z, boolean z2, String str3, String str4) {
        n.f(str, "programId");
        n.f(str2, "programColorHex");
        n.f(str3, "fragmentParentReturnTag");
        n.f(str4, "source");
        super();
        this.a = str;
        this.b = str2;
        this.c = programOverview;
        this.v = z;
        this.w = z2;
        this.x = str3;
        this.source = str4;
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
        final boolean z9 = false;
        if (!(other instanceof ProgramOverviewScreen)) {
            return false;
        }
        if (!n.b(this.a, other.a)) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        if (!n.b(this.c, other.c)) {
            return false;
        }
        if (this.v != other.v) {
            return false;
        }
        if (this.w != other.w) {
            return false;
        }
        if (!n.b(getFragmentParentReturnTag(), other.getFragmentParentReturnTag())) {
            return false;
        }
        return !n.b(this.source, other.source) ? z9 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        int i = 0;
        boolean z;
        boolean z2 = true;
        if (this.c == null) {
            i = 0;
        } else {
            i = this.c.hashCode();
        }
        if (this.v) {
        }
        if (!(this.w)) {
        }
        return (this.a.hashCode() * 31) + this.b.hashCode() * 31 + i * 31 + z * 31 + z2 * 31 + getFragmentParentReturnTag().hashCode() * 31 + this.source.hashCode();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramOverviewScreen(programId=";
        String str4 = ", programColorHex=";
        String str6 = ", programOverview=";
        String str7 = ", calledFromLibrary=";
        String str8 = ", calledFromOnboarding=";
        String str9 = ", fragmentParentReturnTag=";
        String fragmentParentReturnTag = getFragmentParentReturnTag();
        String str10 = ", source=";
        str = str2 + this.a + str4 + this.b + str6 + this.c + str7 + this.v + str8 + this.w + str9 + fragmentParentReturnTag + str10 + this.source + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        if (this.c == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.c.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.source);
    }
}
