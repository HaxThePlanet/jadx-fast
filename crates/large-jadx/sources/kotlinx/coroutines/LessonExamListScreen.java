package app.dogo.com.dogo_android.y.o;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: LessonExamListScreen.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0008\u0010\u0018\u001a\u00020\u0019H\u0014J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00082\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000b¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "fragmentReturnTag", "", "sourceScreenName", "lastViewedExamHadFeedback", "", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Z)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getLastViewedExamHadFeedback", "()Z", "setLastViewedExamHadFeedback", "(Z)V", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getSourceScreenName", "component1", "component2", "component3", "component4", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w, reason: from kotlin metadata */
public final /* data */ class LessonExamListScreen extends j {

    public static final Parcelable.Creator<w> CREATOR = new w$a<>();
    private final ProgramSaveInfo a;
    private final String b;
    private final String c;
    private boolean v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<w> {
        public final w a(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            LessonExamListScreen lessonExamListScreen = new LessonExamListScreen((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0));
            return lessonExamListScreen;
        }

        public final w[] b(int i) {
            return new w[i];
        }
    }
    public w(ProgramSaveInfo programSaveInfo, String str, String str2, boolean z) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(str, "fragmentReturnTag");
        n.f(str2, "sourceScreenName");
        super();
        this.a = programSaveInfo;
        this.b = str;
        this.c = str2;
        this.v = z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: c, reason: from kotlin metadata */
    /* operator */ public final boolean component1() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new LessonExamListFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.pottyTrackerOverview.b(new EP_ViewSource(), this.c);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramSaveInfo d() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String e() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final void f(boolean z) {
        this.v = z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.b;
    }

    public /* synthetic */ w(ProgramSaveInfo programSaveInfo, String str, String str2, boolean z, int i, g gVar) {
        i = i & 8 != 0 ? 0 : i;
        this(programSaveInfo, str, str2, z);
    }


    public static /* synthetic */ w b(w wVar, ProgramSaveInfo programSaveInfo, String str, String str2, boolean z, int i, Object object) {
        String fragmentReturnTag;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
            fragmentReturnTag = wVar.getFragmentReturnTag();
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return wVar.copy(programSaveInfo, fragmentReturnTag, str, z);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final w copy(ProgramSaveInfo programSaveInfo, String fragmentReturnTag, String sourceScreenName, boolean lastViewedExamHadFeedback) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(fragmentReturnTag, "fragmentReturnTag");
        n.f(sourceScreenName, "sourceScreenName");
        return new LessonExamListScreen(programSaveInfo, fragmentReturnTag, sourceScreenName, lastViewedExamHadFeedback);
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
        if (!(other instanceof LessonExamListScreen)) {
            return false;
        }
        if (!n.b(this.a, other.a)) {
            return false;
        }
        if (!n.b(getFragmentReturnTag(), other.getFragmentReturnTag())) {
            return false;
        }
        if (!n.b(this.c, other.c)) {
            return false;
        }
        return this.v != other.v ? z7 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z = true;
        if (this.v) {
            int i10 = 1;
        }
        return (this.a.hashCode() * 31) + getFragmentReturnTag().hashCode() * 31 + this.c.hashCode() * 31 + z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LessonExamListScreen(programSaveInfo=";
        String str3 = ", fragmentReturnTag=";
        String fragmentReturnTag = getFragmentReturnTag();
        String str4 = ", sourceScreenName=";
        String str6 = ", lastViewedExamHadFeedback=";
        str = str2 + this.a + str3 + fragmentReturnTag + str4 + this.c + str6 + this.v + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, flags);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.v);
    }
}
