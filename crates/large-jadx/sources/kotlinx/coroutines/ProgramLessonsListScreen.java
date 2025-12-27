package app.dogo.com.dogo_android.y.w;

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

/* compiled from: ProgramLessonsListScreen.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B3\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u0016\u001a\u00020\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0014\u0010\u0008\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000e¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "isNewProgram", "", "programId", "", "calledFromLibrary", "calledFromOnboarding", "fragmentParentReturnTag", "(ZLjava/lang/String;ZZLjava/lang/String;)V", "getCalledFromLibrary", "()Z", "getCalledFromOnboarding", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getProgramId", "component1", "component2", "component3", "component4", "component5", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final /* data */ class ProgramLessonsListScreen extends j {

    public static final Parcelable.Creator<n> CREATOR = new n$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final boolean calledFromLibrary;
    private final String b;
    private final boolean c;
    /* renamed from: v, reason: from kotlin metadata */
    private final boolean isNewProgram;
    /* renamed from: w, reason: from kotlin metadata */
    private final String programId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<n> {
        public final n a(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = 1;
            i = 0;
            int r4 = i;
            int r6 = i;
            int r7 = i;
            ProgramLessonsListScreen programLessonsListScreen = new ProgramLessonsListScreen(i, parcel.readString(), i, i, parcel.readString());
            return programLessonsListScreen;
        }

        public final n[] b(int i) {
            return new n[i];
        }
    }
    public /* synthetic */ n(boolean z, String str, boolean z2, boolean z3, String str2, int i, g gVar) {
        boolean z32;
        boolean z42;
        i = 0;
        int r2 = i & 1 != 0 ? i : z;
        int r4 = i & 4 != 0 ? i : z2;
        int r5 = i & 8 != 0 ? i : z3;
        this(z2, str, z32, (i & 8 != 0 ? i : z3), str2);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: c, reason: from kotlin metadata */
    /* operator */ public final boolean component1() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ProgramLessonsListFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.languageSelect.withoutParameters();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean d() {
        return this.isNewProgram;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String e() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean f() {
        return this.calledFromLibrary;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.programId;
    }

    public n(boolean z, String str, boolean z2, boolean z3, String str2) {
        n.f(str, "programId");
        n.f(str2, "fragmentParentReturnTag");
        super();
        this.calledFromLibrary = z;
        this.b = str;
        this.c = z2;
        this.isNewProgram = z3;
        this.programId = str2;
    }


    public static /* synthetic */ n b(n nVar, boolean z, String str, boolean z2, boolean z3, String str2, int i, Object object) {
        boolean z22;
        String object82;
        boolean z42;
        boolean z52;
        String str62;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        if (i & 16 != 0) {
            str62 = nVar.getFragmentParentReturnTag();
        }
        return nVar.copy(z22, object82, z42, z52, str62);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final n copy(boolean isNewProgram, String programId, boolean calledFromLibrary, boolean calledFromOnboarding, String fragmentParentReturnTag) {
        n.f(programId, "programId");
        n.f(fragmentParentReturnTag, "fragmentParentReturnTag");
        ProgramLessonsListScreen programLessonsListScreen = new ProgramLessonsListScreen(isNewProgram, programId, calledFromLibrary, calledFromOnboarding, fragmentParentReturnTag);
        return programLessonsListScreen;
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
        if (!(other instanceof ProgramLessonsListScreen)) {
            return false;
        }
        if (this.calledFromLibrary != other.calledFromLibrary) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        if (this.c != other.c) {
            return false;
        }
        if (this.isNewProgram != other.isNewProgram) {
            return false;
        }
        return !n.b(getFragmentParentReturnTag(), other.getFragmentParentReturnTag()) ? z5 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean calledFromLibrary2;
        boolean isNewProgram2 = true;
        boolean z;
        int i = 1;
        if (this.calledFromLibrary) {
        }
        if (this.c) {
        }
        if (!(this.isNewProgram)) {
        }
        return (calledFromLibrary2 * 31) + this.b.hashCode() * 31 + z * 31 + isNewProgram2 * 31 + getFragmentParentReturnTag().hashCode();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramLessonsListScreen(isNewProgram=";
        String str3 = ", programId=";
        String str5 = ", calledFromLibrary=";
        String str6 = ", calledFromOnboarding=";
        String str7 = ", fragmentParentReturnTag=";
        String fragmentParentReturnTag = getFragmentParentReturnTag();
        str = str2 + this.calledFromLibrary + str3 + this.b + str5 + this.c + str6 + this.isNewProgram + str7 + fragmentParentReturnTag + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.calledFromLibrary);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.isNewProgram);
        parcel.writeString(this.programId);
    }
}
