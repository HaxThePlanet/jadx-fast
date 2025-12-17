package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class j extends a {

    public static final Parcelable.Creator<f.c.a.d.c.j> CREATOR;
    public final long a;
    public final f.c.a.d.c.a[] b;
    public final int c = -1;
    private final boolean v;
    static {
        k kVar = new k();
        j.CREATOR = kVar;
    }

    public j(long l, f.c.a.d.c.a[] a2Arr2, int i3, boolean z4) {
        super();
        this.a = l;
        this.b = i3;
        this.v = obj5;
        if (obj5 != null) {
            this.c = z4;
        }
        final int obj1 = -1;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.l(parcel, 2, this.a);
        b.r(parcel, 3, this.b, i2, false);
        b.j(parcel, 4, this.c);
        b.c(parcel, 5, this.v);
        b.b(parcel, b.a(parcel));
    }
}
