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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u0014\u001a\u00020\u0015H\u0014J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/certificate/CertificateDetailScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programExamInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogName", "", "source", "fragmentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogName", "()Ljava/lang/String;", "getFragmentReturnTag", "getProgramExamInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "getSource", "component1", "component2", "component3", "component4", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.n.i> CREATOR;
    private final ProgramExamSummary a;
    private final String b;
    private final String c;
    private final String v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.n.i> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.n.i a(Parcel parcel) {
            n.f(parcel, "parcel");
            i iVar = new i((ProgramExamSummary)ProgramExamSummary.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
            return iVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.n.i[] b(int i) {
            return new i[i];
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
        i.a aVar = new i.a();
        i.CREATOR = aVar;
    }

    public i(ProgramExamSummary programExamSummary, String string2, String string3, String string4) {
        n.f(programExamSummary, "programExamInfo");
        n.f(string2, "dogName");
        n.f(string3, "source");
        n.f(string4, "fragmentReturnTag");
        super();
        this.a = programExamSummary;
        this.b = string2;
        this.c = string3;
        this.v = string4;
    }

    public i(ProgramExamSummary programExamSummary, String string2, String string3, String string4, int i5, g g6) {
        String obj4;
        obj4 = i5 &= 8 != 0 ? "" : obj4;
        super(programExamSummary, string2, string3, obj4);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.y.n.i a(ProgramExamSummary programExamSummary, String string2, String string3, String string4) {
        n.f(programExamSummary, "programExamInfo");
        n.f(string2, "dogName");
        n.f(string3, "source");
        n.f(string4, "fragmentReturnTag");
        i iVar = new i(programExamSummary, string2, string3, string4);
        return iVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramExamSummary c() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        h hVar = new h();
        return hVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.l0.c(u.a(r2Var, this.c));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof i) {
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
        if (!n.b(getFragmentReturnTag(), (i)object.getFragmentReturnTag())) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        return i6 += i10;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CertificateDetailScreen(programExamInfo=");
        stringBuilder.append(this.a);
        stringBuilder.append(", dogName=");
        stringBuilder.append(this.b);
        stringBuilder.append(", source=");
        stringBuilder.append(this.c);
        stringBuilder.append(", fragmentReturnTag=");
        stringBuilder.append(getFragmentReturnTag());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.v);
    }
}
