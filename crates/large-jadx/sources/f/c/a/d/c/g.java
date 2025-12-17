package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class g extends a {

    public static final Parcelable.Creator<f.c.a.d.c.g> CREATOR;
    private final String a;
    static {
        h hVar = new h();
        g.CREATOR = hVar;
    }

    public g(String string) {
        super();
        this.a = string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String E1() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.o(parcel, 2, this.a, false);
        b.b(parcel, b.a(parcel));
    }
}
