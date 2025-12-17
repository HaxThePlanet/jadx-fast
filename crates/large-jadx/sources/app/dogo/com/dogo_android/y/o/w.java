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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0008\u0010\u0018\u001a\u00020\u0019H\u0014J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00082\u0008\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001dHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000b¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "fragmentReturnTag", "", "sourceScreenName", "lastViewedExamHadFeedback", "", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;Z)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getLastViewedExamHadFeedback", "()Z", "setLastViewedExamHadFeedback", "(Z)V", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getSourceScreenName", "component1", "component2", "component3", "component4", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class w extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.o.w> CREATOR;
    private final ProgramSaveInfo a;
    private final String b;
    private final String c;
    private boolean v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.o.w> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.o.w a(Parcel parcel) {
            int obj5;
            n.f(parcel, "parcel");
            obj5 = parcel.readInt() != 0 ? 1 : 0;
            w wVar = new w((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), obj5);
            return wVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.o.w[] b(int i) {
            return new w[i];
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
        w.a aVar = new w.a();
        w.CREATOR = aVar;
    }

    public w(ProgramSaveInfo programSaveInfo, String string2, String string3, boolean z4) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string2, "fragmentReturnTag");
        n.f(string3, "sourceScreenName");
        super();
        this.a = programSaveInfo;
        this.b = string2;
        this.c = string3;
        this.v = z4;
    }

    public w(ProgramSaveInfo programSaveInfo, String string2, String string3, boolean z4, int i5, g g6) {
        int obj4;
        obj4 = i5 &= 8 != 0 ? 0 : obj4;
        super(programSaveInfo, string2, string3, obj4);
    }

    public static app.dogo.com.dogo_android.y.o.w b(app.dogo.com.dogo_android.y.o.w w, ProgramSaveInfo programSaveInfo2, String string3, String string4, boolean z5, int i6, Object object7) {
        ProgramSaveInfo obj1;
        String obj2;
        String obj3;
        boolean obj4;
        if (i6 & 1 != 0) {
            obj1 = w.a;
        }
        if (i6 & 2 != 0) {
            obj2 = w.getFragmentReturnTag();
        }
        if (i6 & 4 != 0) {
            obj3 = w.c;
        }
        if (i6 &= 8 != 0) {
            obj4 = w.v;
        }
        return w.a(obj1, obj2, obj3, obj4);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.y.o.w a(ProgramSaveInfo programSaveInfo, String string2, String string3, boolean z4) {
        n.f(programSaveInfo, "programSaveInfo");
        n.f(string2, "fragmentReturnTag");
        n.f(string3, "sourceScreenName");
        w wVar = new w(programSaveInfo, string2, string3, z4);
        return wVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean c() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        v vVar = new v();
        return vVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.k0.b(r2Var, this.c);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramSaveInfo d() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String e() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof w) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(getFragmentReturnTag(), (w)object.getFragmentReturnTag())) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        if (this.v != object.v) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final void f(boolean z) {
        this.v = z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z;
        if (this.v) {
            z = 1;
        }
        return i6 += z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LessonExamListScreen(programSaveInfo=");
        stringBuilder.append(this.a);
        stringBuilder.append(", fragmentReturnTag=");
        stringBuilder.append(getFragmentReturnTag());
        stringBuilder.append(", sourceScreenName=");
        stringBuilder.append(this.c);
        stringBuilder.append(", lastViewedExamHadFeedback=");
        stringBuilder.append(this.v);
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
    }
}
