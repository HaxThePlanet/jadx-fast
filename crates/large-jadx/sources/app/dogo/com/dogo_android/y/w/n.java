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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B3\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005HÆ\u0001J\u0008\u0010\u0016\u001a\u00020\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0014\u0010\u0008\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000e¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "isNewProgram", "", "programId", "", "calledFromLibrary", "calledFromOnboarding", "fragmentParentReturnTag", "(ZLjava/lang/String;ZZLjava/lang/String;)V", "getCalledFromLibrary", "()Z", "getCalledFromOnboarding", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getProgramId", "component1", "component2", "component3", "component4", "component5", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.w.n> CREATOR;
    private final boolean a;
    private final String b;
    private final boolean c;
    private final boolean v;
    private final String w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.w.n> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.w.n a(Parcel parcel) {
            int i2;
            int i;
            int i3;
            n.f(parcel, "parcel");
            int i4 = 1;
            int i6 = 0;
            i2 = parcel.readInt() != 0 ? i4 : i6;
            i = parcel.readInt() != 0 ? i4 : i6;
            i3 = parcel.readInt() != 0 ? i4 : i6;
            super(i2, parcel.readString(), i, i3, parcel.readString());
            return nVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.w.n[] b(int i) {
            return new n[i];
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
        n.a aVar = new n.a();
        n.CREATOR = aVar;
    }

    public n(boolean z, String string2, boolean z3, boolean z4, String string5) {
        n.f(string2, "programId");
        n.f(string5, "fragmentParentReturnTag");
        super();
        this.a = z;
        this.b = string2;
        this.c = z3;
        this.v = z4;
        this.w = string5;
    }

    public n(boolean z, String string2, boolean z3, boolean z4, String string5, int i6, g g7) {
        int i3;
        int i;
        int i2;
        final int i4 = 0;
        i3 = i6 & 1 != 0 ? i4 : z;
        i = i6 & 4 != 0 ? i4 : z3;
        i2 = i6 & 8 != 0 ? i4 : z4;
        super(i3, string2, i, i2, string5);
    }

    public static app.dogo.com.dogo_android.y.w.n b(app.dogo.com.dogo_android.y.w.n n, boolean z2, String string3, boolean z4, boolean z5, String string6, int i7, Object object8) {
        boolean obj4;
        String obj5;
        boolean obj6;
        boolean obj7;
        String obj8;
        if (i7 & 1 != 0) {
            obj4 = n.a;
        }
        if (i7 & 2 != 0) {
            obj5 = n.b;
        }
        if (i7 & 4 != 0) {
            obj6 = n.c;
        }
        if (i7 & 8 != 0) {
            obj7 = n.v;
        }
        if (i7 & 16 != 0) {
            obj8 = n.getFragmentParentReturnTag();
        }
        return n.a(obj4, obj5, obj6, obj7, obj8);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.y.w.n a(boolean z, String string2, boolean z3, boolean z4, String string5) {
        n.f(string2, "programId");
        n.f(string5, "fragmentParentReturnTag");
        super(z, string2, z3, z4, string5);
        return nVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean c() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        m mVar = new m();
        return mVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.d0.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean d() {
        return this.v;
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
        if (!object instanceof n) {
            return i2;
        }
        if (this.a != object.a) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (this.c != object.c) {
            return i2;
        }
        if (this.v != object.v) {
            return i2;
        }
        if (!n.b(getFragmentParentReturnTag(), (n)object.getFragmentParentReturnTag())) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean f() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z2;
        boolean i;
        boolean z;
        i = 1;
        if (this.a) {
            z2 = i;
        }
        if (this.c) {
            z = i;
        }
        boolean z3 = this.v;
        if (z3) {
        } else {
            i = z3;
        }
        return i8 += i10;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramLessonsListScreen(isNewProgram=");
        stringBuilder.append(this.a);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.b);
        stringBuilder.append(", calledFromLibrary=");
        stringBuilder.append(this.c);
        stringBuilder.append(", calledFromOnboarding=");
        stringBuilder.append(this.v);
        stringBuilder.append(", fragmentParentReturnTag=");
        stringBuilder.append(getFragmentParentReturnTag());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
        parcel.writeString(this.w);
    }
}
