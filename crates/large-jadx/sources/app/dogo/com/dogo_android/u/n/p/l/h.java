package app.dogo.com.dogo_android.u.n.p.l;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0008\u0010\u0018\u001a\u00020\u0019H\u0014J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000cR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "", "preselectedTimeMs", "", "preselectedTagType", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "logId", "fragmentReturnTag", "(Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/com/dogo_android/enums/DogLogTypes;Ljava/lang/String;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getLogId", "getPreselectedTagType", "()Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "getPreselectedTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSource", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.u.n.p.l.h> CREATOR;
    private final String a;
    private final Long b;
    private final e c;
    private final String v;
    private final String w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.u.n.p.l.h> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.u.n.p.l.h a(Parcel parcel) {
            int valueOf2;
            e valueOf;
            int i;
            e eVar;
            n.f(parcel, "parcel");
            int i2 = 0;
            if (parcel.readInt() == 0) {
                i = i2;
            } else {
                i = valueOf2;
            }
            if (parcel.readInt() == 0) {
                eVar = i2;
            } else {
                eVar = valueOf;
            }
            super(parcel.readString(), i, eVar, parcel.readString(), parcel.readString());
            return hVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.u.n.p.l.h[] b(int i) {
            return new h[i];
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
        h.a aVar = new h.a();
        h.CREATOR = aVar;
    }

    public h(String string, Long long2, e e3, String string4, String string5) {
        n.f(string, "source");
        n.f(string5, "fragmentReturnTag");
        super();
        this.a = string;
        this.b = long2;
        this.c = e3;
        this.v = string4;
        this.w = string5;
    }

    public h(String string, Long long2, e e3, String string4, String string5, int i6, g g7) {
        int i;
        int i2;
        int i3;
        String obj12;
        final int i4 = 0;
        i = i6 & 2 != 0 ? i4 : long2;
        i2 = i6 & 4 != 0 ? i4 : e3;
        i3 = i6 & 8 != 0 ? i4 : string4;
        obj12 = i6 & 16 != 0 ? "" : obj12;
        super(string, i, i2, i3, obj12);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String a() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final e b() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final Long c() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        g gVar = new g();
        return gVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.f1.b(r2Var, this.a);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100379;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        long longValue;
        Object obj6;
        n.f(parcel, "out");
        parcel.writeString(this.a);
        obj6 = this.b;
        final int i = 0;
        final int i3 = 1;
        if (obj6 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeLong(obj6.longValue());
        }
        obj6 = this.c;
        if (obj6 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeString(obj6.name());
        }
        parcel.writeString(this.v);
        parcel.writeString(this.w);
    }
}
