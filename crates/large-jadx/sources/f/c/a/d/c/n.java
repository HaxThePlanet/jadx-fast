package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class n extends a {

    public static final Parcelable.Creator<f.c.a.d.c.n> CREATOR;
    private final int a;
    private final boolean b;
    static {
        o oVar = new o();
        n.CREATOR = oVar;
    }

    public n(int i, boolean z2) {
        super();
        this.a = i;
        this.b = z2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 2, this.a);
        b.c(parcel, 3, this.b);
        b.b(parcel, b.a(parcel));
    }
}
