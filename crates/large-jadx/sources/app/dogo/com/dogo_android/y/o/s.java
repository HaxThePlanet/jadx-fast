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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u0018\u001a\u00020\u0019H\u0014J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00082\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000c¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "trickName", "", "trickId", "isDogPremium", "", "fragmentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "()Z", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrickId", "getTrickName", "component1", "component2", "component3", "component4", "component5", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.o.s> CREATOR;
    private final ProgramSaveInfo a;
    private final String b;
    private final String c;
    private final boolean v;
    private final String w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.o.s> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.o.s a(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            super((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), i, parcel.readString());
            return sVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.o.s[] b(int i) {
            return new s[i];
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
        s.a aVar = new s.a();
        s.CREATOR = aVar;
    }

    public s(ProgramSaveInfo programSaveInfo, String string2, String string3, boolean z4, String string5) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string2, "trickName");
        n.f(string3, "trickId");
        n.f(string5, "fragmentReturnTag");
        super();
        this.a = programSaveInfo;
        this.b = string2;
        this.c = string3;
        this.v = z4;
        this.w = string5;
    }

    public s(ProgramSaveInfo programSaveInfo, String string2, String string3, boolean z4, String string5, int i6, g g7) {
        String obj11;
        obj11 = i6 &= 16 != 0 ? "" : obj11;
        super(programSaveInfo, string2, string3, z4, obj11);
    }

    public static app.dogo.com.dogo_android.y.o.s b(app.dogo.com.dogo_android.y.o.s s, ProgramSaveInfo programSaveInfo2, String string3, String string4, boolean z5, String string6, int i7, Object object8) {
        ProgramSaveInfo obj4;
        String obj5;
        String obj6;
        boolean obj7;
        String obj8;
        if (i7 & 1 != 0) {
            obj4 = s.a;
        }
        if (i7 & 2 != 0) {
            obj5 = s.b;
        }
        if (i7 & 4 != 0) {
            obj6 = s.c;
        }
        if (i7 & 8 != 0) {
            obj7 = s.v;
        }
        if (i7 & 16 != 0) {
            obj8 = s.getFragmentReturnTag();
        }
        return s.a(obj4, obj5, obj6, obj7, obj8);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.y.o.s a(ProgramSaveInfo programSaveInfo, String string2, String string3, boolean z4, String string5) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string2, "trickName");
        n.f(string3, "trickId");
        n.f(string5, "fragmentReturnTag");
        super(programSaveInfo, string2, string3, z4, string5);
        return sVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramSaveInfo c() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        r rVar = new r();
        return rVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        n2 n2Var = new n2();
        return j3.j0.b(n2Var, this.c);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String d() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String e() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof s) {
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
        if (!n.b(getFragmentReturnTag(), (s)object.getFragmentReturnTag())) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean f() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z;
        if (this.v) {
            z = 1;
        }
        return i8 += i12;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LessonExamHistoryScreen(programSaveInfo=");
        stringBuilder.append(this.a);
        stringBuilder.append(", trickName=");
        stringBuilder.append(this.b);
        stringBuilder.append(", trickId=");
        stringBuilder.append(this.c);
        stringBuilder.append(", isDogPremium=");
        stringBuilder.append(this.v);
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
        parcel.writeInt(this.v);
        parcel.writeString(this.w);
    }
}
