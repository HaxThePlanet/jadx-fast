package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class a extends a {

    public static final Parcelable.Creator<f.c.a.d.c.a> CREATOR;
    public final String a;
    public final byte[] b;
    public final int c;
    static {
        i iVar = new i();
        a.CREATOR = iVar;
    }

    public a(String string, byte[] b2Arr2, int i3) {
        super();
        this.a = string;
        this.b = b2Arr2;
        this.c = i3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        final int i6 = 0;
        b.o(parcel, 2, this.a, i6);
        b.f(parcel, 3, this.b, i6);
        b.j(parcel, 4, this.c);
        b.b(parcel, b.a(parcel));
    }
}
