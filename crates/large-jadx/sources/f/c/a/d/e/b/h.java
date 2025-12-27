package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class h extends a implements i {

    public static final Parcelable.Creator<h> CREATOR = new i<>();
    private final List<String> a;
    private final String b;
    public h(List<String> list, String str) {
        super();
        this.a = list;
        this.b = str;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Status m() {
        if (this.b != null) {
            return Status.x;
        }
        return Status.B;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i) {
        final boolean z = false;
        b.q(parcel, 1, this.a, z);
        b.o(parcel, 2, this.b, z);
        b.b(parcel, b.a(parcel));
    }

}
