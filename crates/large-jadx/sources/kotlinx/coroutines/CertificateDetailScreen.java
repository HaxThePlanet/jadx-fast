package app.dogo.com.dogo_android.y.n;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;

/* compiled from: CertificateDetailScreen.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u0014\u001a\u00020\u0015H\u0014J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programExamInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogName", "", "source", "fragmentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogName", "()Ljava/lang/String;", "getFragmentReturnTag", "getProgramExamInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "getSource", "component1", "component2", "component3", "component4", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final /* data */ class CertificateDetailScreen extends j {

    public static final Parcelable.Creator<i> CREATOR = new i$a<>();
    private final ProgramExamSummary a;
    /* renamed from: b, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    private final String c;
    /* renamed from: v, reason: from kotlin metadata */
    private final String source;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<i> {
        public final i a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new CertificateDetailScreen((ProgramExamSummary)ProgramExamSummary.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final i[] b(int i) {
            return new i[i];
        }
    }
    public i(ProgramExamSummary programExamSummary, String str, String str2, String str3) {
        n.f(programExamSummary, "programExamInfo");
        n.f(str, "dogName");
        n.f(str2, "source");
        n.f(str3, "fragmentReturnTag");
        super();
        this.a = programExamSummary;
        this.fragmentReturnTag = str;
        this.c = str2;
        this.source = str3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: b, reason: from kotlin metadata */
    /* operator */ public final String component1() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramExamSummary c() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new CertificateDetailFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.programDescriptionScreen.c(u.a(new EP_ViewSource(), this.c));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.source;
    }

    public /* synthetic */ i(ProgramExamSummary programExamSummary, String str, String str2, String str3, int i, g gVar) {
        str = i & 8 != 0 ? "" : str;
        this(programExamSummary, str, str2, str);
    }


    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final i copy(ProgramExamSummary programExamInfo, String dogName, String source, String fragmentReturnTag) {
        n.f(programExamInfo, "programExamInfo");
        n.f(dogName, "dogName");
        n.f(source, "source");
        n.f(fragmentReturnTag, "fragmentReturnTag");
        return new CertificateDetailScreen(programExamInfo, dogName, source, fragmentReturnTag);
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
        final boolean z6 = false;
        if (!(other instanceof CertificateDetailScreen)) {
            return false;
        }
        if (!n.b(this.a, other.a)) {
            return false;
        }
        if (!n.b(this.fragmentReturnTag, other.fragmentReturnTag)) {
            return false;
        }
        if (!n.b(this.c, other.c)) {
            return false;
        }
        return !n.b(getFragmentReturnTag(), other.getFragmentReturnTag()) ? z6 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        return (this.a.hashCode() * 31) + this.fragmentReturnTag.hashCode() * 31 + this.c.hashCode() * 31 + getFragmentReturnTag().hashCode();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CertificateDetailScreen(programExamInfo=";
        String str3 = ", dogName=";
        String str4 = ", source=";
        String str6 = ", fragmentReturnTag=";
        String fragmentReturnTag = getFragmentReturnTag();
        str = str2 + this.a + str3 + this.fragmentReturnTag + str4 + this.c + str6 + fragmentReturnTag + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, flags);
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeString(this.c);
        parcel.writeString(this.source);
    }
}
