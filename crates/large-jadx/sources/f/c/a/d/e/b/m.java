package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.s0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class m implements Parcelable.Creator<f.c.a.d.e.b.l> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2;
        int i6;
        int i4;
        int i3;
        int i;
        int i5;
        final int i7 = SafeParcelReader.w(parcel);
        i4 = i8;
        i6 = i2;
        while (parcel.dataPosition() < i7) {
            i3 = SafeParcelReader.p(parcel);
            i = SafeParcelReader.k(i3);
            if (i != 1) {
            } else {
            }
            i4 = SafeParcelReader.r(parcel, i3);
            if (i != 2) {
            } else {
            }
            i2 = SafeParcelReader.d(parcel, i3, b.CREATOR);
            if (i != 3) {
            } else {
            }
            i6 = SafeParcelReader.d(parcel, i3, s0.CREATOR);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i7);
        l obj8 = new l(i4, i2, i6);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new l[i];
    }
}
