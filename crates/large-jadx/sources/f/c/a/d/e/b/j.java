package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.q0;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class j extends a {

    public static final Parcelable.Creator<j> CREATOR = new k<>();
    final int a;
    final q0 b;
    j(int i, q0 q0Var) {
        super();
        this.a = i;
        this.b = q0Var;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i) {
        b.j(parcel, 1, this.a);
        b.n(parcel, 2, this.b, i, false);
        b.b(parcel, b.a(parcel));
    }

}
