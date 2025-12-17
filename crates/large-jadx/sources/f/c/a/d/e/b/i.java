package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<f.c.a.d.e.b.h> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i4;
        int i5;
        int i2;
        int i;
        final int i6 = SafeParcelReader.w(parcel);
        i4 = i3;
        while (parcel.dataPosition() < i6) {
            i5 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i5);
            if (i2 != 1) {
            } else {
            }
            i3 = SafeParcelReader.g(parcel, i5);
            if (i2 != 2) {
            } else {
            }
            i4 = SafeParcelReader.e(parcel, i5);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i6);
        h obj7 = new h(i3, i4);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new h[i];
    }
}
