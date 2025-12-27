package app.dogo.com.dogo_android.y.o;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: LessonExamHistoryScreen.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u0018\u001a\u00020\u0019H\u0014J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00082\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000c¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "trickName", "", "trickId", "isDogPremium", "", "fragmentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "()Z", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrickId", "getTrickName", "component1", "component2", "component3", "component4", "component5", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s, reason: from kotlin metadata */
public final /* data */ class LessonExamHistoryScreen extends j {

    public static final Parcelable.Creator<s> CREATOR = new s$a<>();
    private final ProgramSaveInfo a;
    private final String b;
    private final String c;
    private final boolean v;
    /* renamed from: w, reason: from kotlin metadata */
    private final String trickName;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<s> {
        public final s a(Parcel parcel) {
            int i = 1;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            r1 = new LessonExamHistoryScreen((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0), parcel.readString());
            return lessonExamHistoryScreen;
        }

        public final s[] b(int i) {
            return new s[i];
        }
    }
    public s(ProgramSaveInfo programSaveInfo, String str, String str2, boolean z, String str3) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(str, "trickName");
        n.f(str2, "trickId");
        n.f(str3, "fragmentReturnTag");
        super();
        this.a = programSaveInfo;
        this.b = str;
        this.c = str2;
        this.v = z;
        this.trickName = str3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: c, reason: from kotlin metadata */
    /* operator */ public final ProgramSaveInfo component1() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new LessonExamHistoryFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.onboardingSurvey.b(new EP_TrickId(), this.c);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String d() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String e() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean f() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.trickName;
    }

    public /* synthetic */ s(ProgramSaveInfo programSaveInfo, String str, String str2, boolean z, String str3, int i, g gVar) {
        String str52;
        str52 = i & 16 != 0 ? "" : str52;
        this(programSaveInfo, str, str2, z, str52);
    }


    public static /* synthetic */ s b(s sVar, ProgramSaveInfo programSaveInfo, String str, String str2, boolean z, String str3, int i, Object object) {
        ProgramSaveInfo programSaveInfo22;
        String object82;
        String str42;
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
            str62 = sVar.getFragmentReturnTag();
        }
        return sVar.copy(programSaveInfo22, object82, str42, z52, str62);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final s copy(ProgramSaveInfo programSaveInfo, String trickName, String trickId, boolean isDogPremium, String fragmentReturnTag) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(trickName, "trickName");
        n.f(trickId, "trickId");
        n.f(fragmentReturnTag, "fragmentReturnTag");
        LessonExamHistoryScreen lessonExamHistoryScreen = new LessonExamHistoryScreen(programSaveInfo, trickName, trickId, isDogPremium, fragmentReturnTag);
        return lessonExamHistoryScreen;
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
        final boolean z7 = false;
        if (!(other instanceof LessonExamHistoryScreen)) {
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
        return !n.b(getFragmentReturnTag(), other.getFragmentReturnTag()) ? z7 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z = true;
        if (this.v) {
            int i13 = 1;
        }
        return (this.a.hashCode() * 31) + this.b.hashCode() * 31 + this.c.hashCode() * 31 + z * 31 + getFragmentReturnTag().hashCode();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LessonExamHistoryScreen(programSaveInfo=";
        String str3 = ", trickName=";
        String str5 = ", trickId=";
        String str7 = ", isDogPremium=";
        String str8 = ", fragmentReturnTag=";
        String fragmentReturnTag = getFragmentReturnTag();
        str = str2 + this.a + str3 + this.b + str5 + this.c + str7 + this.v + str8 + fragmentReturnTag + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, flags);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.v);
        parcel.writeString(this.trickName);
    }
}
