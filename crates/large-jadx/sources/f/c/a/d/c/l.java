package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class l extends a {

    public static final Parcelable.Creator<f.c.a.d.c.l> CREATOR;
    private final String a;
    static {
        m mVar = new m();
        l.CREATOR = mVar;
    }

    public l(String string) {
        super();
        this.a = string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.o(parcel, 2, this.a, false);
        b.b(parcel, b.a(parcel));
    }
}
