package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.s0;
import com.google.android.gms.common.internal.safeparcel.a;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class l extends a {

    public static final Parcelable.Creator<l> CREATOR = new m<>();
    final int a;
    private final com.google.android.gms.common.b b;
    private final s0 c;
    l(int i, com.google.android.gms.common.b bVar, s0 s0Var) {
        super();
        this.a = i;
        this.b = bVar;
        this.c = s0Var;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i) {
        b.j(parcel, 1, this.a);
        final boolean z = false;
        b.n(parcel, 2, this.b, i, z);
        b.n(parcel, 3, this.c, i, z);
        b.b(parcel, b.a(parcel));
    }


    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.common.b j2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final s0 k2() {
        return this.c;
    }
}
