package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class a extends a {

    public static final Parcelable.Creator<a> CREATOR = new i<>();
    public final String a;
    public final byte[] b;
    public final int c;

    public a(String str, byte[] bArr, int i) {
        super();
        this.a = str;
        this.b = bArr;
        this.c = i;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i) {
        final boolean z = false;
        b.o(parcel, 2, this.a, z);
        b.f(parcel, 3, this.b, z);
        b.j(parcel, 4, this.c);
        b.b(parcel, b.a(parcel));
    }
}
