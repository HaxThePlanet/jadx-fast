package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<f.c.a.d.c.a> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i2;
        int i5;
        int i3;
        int i;
        int i6;
        final int i7 = SafeParcelReader.w(parcel);
        i5 = i8;
        i2 = i4;
        while (parcel.dataPosition() < i7) {
            i3 = SafeParcelReader.p(parcel);
            i = SafeParcelReader.k(i3);
            if (i != 2) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i3);
            if (i != 3) {
            } else {
            }
            i2 = SafeParcelReader.b(parcel, i3);
            if (i != 4) {
            } else {
            }
            i5 = SafeParcelReader.r(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i7);
        a obj8 = new a(i4, i2, i5);
        return obj8;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new a[i];
    }
}
