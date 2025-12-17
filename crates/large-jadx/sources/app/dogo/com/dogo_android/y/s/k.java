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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B9\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007HÆ\u0001J\u0008\u0010\u0017\u001a\u00020\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "lessonId", "", "programId", "fragmentParentReturnTag", "fromProgramOverviewLibrary", "", "fromProgramOverviewOnboarding", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getFromProgramOverviewLibrary", "()Z", "getFromProgramOverviewOnboarding", "getLessonId", "getProgramId", "component1", "component2", "component3", "component4", "component5", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.s.k> CREATOR;
    private final String a;
    private final String b;
    private final String c;
    private final boolean v;
    private final boolean w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.s.k> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.s.k a(Parcel parcel) {
            int i;
            int i2;
            n.f(parcel, "parcel");
            int i3 = 1;
            i2 = parcel.readInt() != 0 ? i3 : i;
            if (parcel.readInt() != 0) {
                i = i3;
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), i2, i);
            return kVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.s.k[] b(int i) {
            return new k[i];
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
        k.a aVar = new k.a();
        k.CREATOR = aVar;
    }

    public k(String string, String string2, String string3, boolean z4, boolean z5) {
        n.f(string3, "fragmentParentReturnTag");
        super();
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.v = z4;
        this.w = z5;
    }

    public k(String string, String string2, String string3, boolean z4, boolean z5, int i6, g g7) {
        int i4;
        int i;
        int i2;
        int i3;
        final int i5 = 0;
        i4 = i6 & 1 != 0 ? i5 : string;
        i = i6 & 2 != 0 ? i5 : string2;
        final int obj9 = 0;
        i2 = i6 & 8 != 0 ? obj9 : z4;
        i3 = i6 & 16 != 0 ? obj9 : z5;
        super(i4, i, string3, i2, i3);
    }

    public static app.dogo.com.dogo_android.y.s.k b(app.dogo.com.dogo_android.y.s.k k, String string2, String string3, String string4, boolean z5, boolean z6, int i7, Object object8) {
        String obj4;
        String obj5;
        String obj6;
        boolean obj7;
        boolean obj8;
        if (i7 & 1 != 0) {
            obj4 = k.a;
        }
        if (i7 & 2 != 0) {
            obj5 = k.b;
        }
        if (i7 & 4 != 0) {
            obj6 = k.getFragmentParentReturnTag();
        }
        if (i7 & 8 != 0) {
            obj7 = k.v;
        }
        if (i7 & 16 != 0) {
            obj8 = k.w;
        }
        return k.a(obj4, obj5, obj6, obj7, obj8);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.y.s.k a(String string, String string2, String string3, boolean z4, boolean z5) {
        n.f(string3, "fragmentParentReturnTag");
        super(string, string2, string3, z4, z5);
        return kVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean c() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        j jVar = new j();
        return jVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        w1 w1Var = new w1();
        return j3.Z.b(w1Var, this.a);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean d() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String e() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof k) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(getFragmentParentReturnTag(), (k)object.getFragmentParentReturnTag())) {
            return i2;
        }
        if (this.v != object.v) {
            return i2;
        }
        if (this.w != object.w) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String f() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        int i3;
        int i;
        boolean z;
        boolean i2;
        String str = this.a;
        if (str == null) {
            i3 = i;
        } else {
            i3 = str.hashCode();
        }
        String str2 = this.b;
        if (str2 == null) {
        } else {
            i = str2.hashCode();
        }
        if (this.v) {
            z = i2;
        }
        boolean z2 = this.w;
        if (z2) {
        } else {
            i2 = z2;
        }
        return i10 += i2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramLessonScreen(lessonId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.b);
        stringBuilder.append(", fragmentParentReturnTag=");
        stringBuilder.append(getFragmentParentReturnTag());
        stringBuilder.append(", fromProgramOverviewLibrary=");
        stringBuilder.append(this.v);
        stringBuilder.append(", fromProgramOverviewOnboarding=");
        stringBuilder.append(this.w);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
    }
}
