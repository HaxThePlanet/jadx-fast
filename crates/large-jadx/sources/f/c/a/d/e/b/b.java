package f.c.a.d.e.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class b extends a implements i {

    public static final Parcelable.Creator<b> CREATOR = new c<>();
    final int a;
    private int b;
    private Intent c;
    public b() {
        this(2, 0, null);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Status m() {
        if (this.b == 0) {
            return Status.x;
        }
        return Status.B;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i) {
        b.j(parcel, 1, this.a);
        b.j(parcel, 2, this.b);
        b.n(parcel, 3, this.c, i, false);
        b.b(parcel, b.a(parcel));
    }

    b(int i, int i2, Intent intent) {
        super();
        this.a = i;
        this.b = i2;
        this.c = intent;
    }

}
