package f.c.a.d.e.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<f.c.a.d.e.b.b> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i6;
        int i3;
        int i4;
        int i5;
        int i2;
        final int i7 = SafeParcelReader.w(parcel);
        i3 = i8;
        i6 = i;
        while (parcel.dataPosition() < i7) {
            i4 = SafeParcelReader.p(parcel);
            i5 = SafeParcelReader.k(i4);
            if (i5 != 1) {
            } else {
            }
            i = SafeParcelReader.r(parcel, i4);
            if (i5 != 2) {
            } else {
            }
            i6 = SafeParcelReader.r(parcel, i4);
            if (i5 != 3) {
            } else {
            }
            i3 = SafeParcelReader.d(parcel, i4, Intent.CREATOR);
            SafeParcelReader.v(parcel, i4);
        }
        SafeParcelReader.j(parcel, i7);
        b obj8 = new b(i, i6, i3);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new b[i];
    }
}
