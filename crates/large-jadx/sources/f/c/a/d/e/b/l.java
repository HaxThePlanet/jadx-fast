package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.s0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class l extends a {

    public static final Parcelable.Creator<f.c.a.d.e.b.l> CREATOR;
    final int a;
    private final b b;
    private final s0 c;
    static {
        m mVar = new m();
        l.CREATOR = mVar;
    }

    l(int i, b b2, s0 s03) {
        super();
        this.a = i;
        this.b = b2;
        this.c = s03;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final b j2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final s0 k2() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        final int i7 = 0;
        b.n(parcel, 2, this.b, i2, i7);
        b.n(parcel, 3, this.c, i2, i7);
        b.b(parcel, b.a(parcel));
    }
}
