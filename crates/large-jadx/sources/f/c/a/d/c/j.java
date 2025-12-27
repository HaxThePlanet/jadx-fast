package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class j extends a {

    public static final Parcelable.Creator<j> CREATOR = new k<>();
    public final long a;
    public final a[] b;
    public final int c = -1;
    private final boolean v;

    public j(long j, a[] aVarArr, int i, boolean z) {
        super();
        this.a = j;
        this.b = aVarArr;
        this.v = z;
        if (z) {
            this.c = i;
            return;
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i) {
        b.l(parcel, 2, this.a);
        b.r(parcel, 3, this.b, i, false);
        b.j(parcel, 4, this.c);
        b.c(parcel, 5, this.v);
        b.b(parcel, b.a(parcel));
    }
}
