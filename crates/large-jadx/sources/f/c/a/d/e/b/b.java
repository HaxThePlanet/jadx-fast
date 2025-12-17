package f.c.a.d.e.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class b extends a implements i {

    public static final Parcelable.Creator<f.c.a.d.e.b.b> CREATOR;
    final int a;
    private int b;
    private Intent c;
    static {
        c cVar = new c();
        b.CREATOR = cVar;
    }

    public b() {
        super(2, 0, 0);
    }

    b(int i, int i2, Intent intent3) {
        super();
        this.a = i;
        this.b = i2;
        this.c = intent3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Status m() {
        if (this.b == 0) {
            return Status.x;
        }
        return Status.B;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.j(parcel, 2, this.b);
        b.n(parcel, 3, this.c, i2, false);
        b.b(parcel, b.a(parcel));
    }
}
