package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class g extends a {

    public static final Parcelable.Creator<g> CREATOR = new h<>();
    private final String a;

    public g(String str) {
        super();
        this.a = str;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String E1() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i) {
        b.o(parcel, 2, this.a, false);
        b.b(parcel, b.a(parcel));
    }
}
