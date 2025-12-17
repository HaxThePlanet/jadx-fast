package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

/* loaded from: classes2.dex */
public final class h extends a implements i {

    public static final Parcelable.Creator<f.c.a.d.e.b.h> CREATOR;
    private final List<String> a;
    private final String b;
    static {
        i iVar = new i();
        h.CREATOR = iVar;
    }

    public h(List<String> list, String string2) {
        super();
        this.a = list;
        this.b = string2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Status m() {
        if (this.b != null) {
            return Status.x;
        }
        return Status.B;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i4 = 0;
        b.q(parcel, 1, this.a, i4);
        b.o(parcel, 2, this.b, i4);
        b.b(parcel, b.a(parcel));
    }
}
