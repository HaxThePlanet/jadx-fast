package app.dogo.com.dogo_android.y.s;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.w1;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramLessonScreen.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B9\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007HÆ\u0001J\u0008\u0010\u0017\u001a\u00020\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "lessonId", "", "programId", "fragmentParentReturnTag", "fromProgramOverviewLibrary", "", "fromProgramOverviewOnboarding", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getFromProgramOverviewLibrary", "()Z", "getFromProgramOverviewOnboarding", "getLessonId", "getProgramId", "component1", "component2", "component3", "component4", "component5", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final /* data */ class ProgramLessonScreen extends j {

    public static final Parcelable.Creator<k> CREATOR = new k$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String fragmentParentReturnTag;
    private final String b;
    private final String c;
    private final boolean v;
    private final boolean w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<k> {
        public final k a(Parcel parcel) {
            boolean z2 = false;
            int i;
            n.f(parcel, "parcel");
            i = 1;
            int r7 = parcel.readInt() != 0 ? i : 0;
            if (parcel.readInt() != 0) {
            }
            ProgramLessonScreen programLessonScreen = new ProgramLessonScreen(parcel.readString(), parcel.readString(), parcel.readString(), i, z2);
            return programLessonScreen;
        }

        public final k[] b(int i) {
            return new k[i];
        }
    }
    public /* synthetic */ k(String str, String str2, String str3, boolean z, boolean z2, int i, g gVar) {
        String str4;
        String str22;
        boolean z42;
        boolean z52;
        i = 0;
        int r2 = i & 1 != 0 ? i : str;
        int r3 = i & 2 != 0 ? i : str2;
        final int str23 = 0;
        int r5 = i & 8 != 0 ? str23 : z;
        int r6 = i & 16 != 0 ? str23 : z2;
        this(str4, str22, str3, z42, (i & 16 != 0 ? str23 : z2));
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: c, reason: from kotlin metadata */
    /* operator */ public final boolean component1() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ProgramLessonFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.examList.b(new EP_LessonId(), this.fragmentParentReturnTag);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean d() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String e() {
        return this.fragmentParentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String f() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.c;
    }

    public k(String str, String str2, String str3, boolean z, boolean z2) {
        n.f(str3, "fragmentParentReturnTag");
        super();
        this.fragmentParentReturnTag = str;
        this.b = str2;
        this.c = str3;
        this.v = z;
        this.w = z2;
    }


    public static /* synthetic */ k b(k kVar, String str, String str2, String str3, boolean z, boolean z2, int i, Object object) {
        String str22;
        String object82;
        String str42;
        boolean z52;
        boolean z62;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
            str42 = kVar.getFragmentParentReturnTag();
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
        }
        return kVar.copy(str22, object82, str42, z52, z62);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final k copy(String lessonId, String programId, String fragmentParentReturnTag, boolean fromProgramOverviewLibrary, boolean fromProgramOverviewOnboarding) {
        n.f(fragmentParentReturnTag, "fragmentParentReturnTag");
        ProgramLessonScreen programLessonScreen = new ProgramLessonScreen(lessonId, programId, fragmentParentReturnTag, fromProgramOverviewLibrary, fromProgramOverviewOnboarding);
        return programLessonScreen;
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
        final boolean z8 = false;
        if (!(other instanceof ProgramLessonScreen)) {
            return false;
        }
        if (!n.b(this.fragmentParentReturnTag, other.fragmentParentReturnTag)) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        if (!n.b(getFragmentParentReturnTag(), other.getFragmentParentReturnTag())) {
            return false;
        }
        if (this.v != other.v) {
            return false;
        }
        return this.w != other.w ? z8 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        int i;
        boolean z;
        boolean z2 = true;
        i = 0;
        if (this.fragmentParentReturnTag == null) {
        } else {
            i = this.fragmentParentReturnTag.hashCode();
        }
        if (this.b != null) {
            i = this.b.hashCode();
        }
        if (this.v) {
        }
        if (!(this.w)) {
        }
        return (i * 31) + i * 31 + getFragmentParentReturnTag().hashCode() * 31 + z * 31 + z2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramLessonScreen(lessonId=";
        String str3 = ", programId=";
        String str5 = ", fragmentParentReturnTag=";
        String fragmentParentReturnTag = getFragmentParentReturnTag();
        String str6 = ", fromProgramOverviewLibrary=";
        String str7 = ", fromProgramOverviewOnboarding=";
        str = str2 + this.fragmentParentReturnTag + str3 + this.b + str5 + fragmentParentReturnTag + str6 + this.v + str7 + this.w + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.fragmentParentReturnTag);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
    }
}
