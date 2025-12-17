package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.q0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class j extends a {

    public static final Parcelable.Creator<f.c.a.d.e.b.j> CREATOR;
    final int a;
    final q0 b;
    static {
        k kVar = new k();
        j.CREATOR = kVar;
    }

    j(int i, q0 q02) {
        super();
        this.a = i;
        this.b = q02;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.n(parcel, 2, this.b, i2, false);
        b.b(parcel, b.a(parcel));
    }
}
