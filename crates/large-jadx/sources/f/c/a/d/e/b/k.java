package f.c.a.d.e.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.q0;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class k implements Parcelable.Creator<f.c.a.d.e.b.j> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int i3;
        int i5;
        int i2;
        int i4;
        final int i6 = SafeParcelReader.w(parcel);
        i = 0;
        i3 = 0;
        while (parcel.dataPosition() < i6) {
            i5 = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i5);
            if (i2 != 1) {
            } else {
            }
            i = SafeParcelReader.r(parcel, i5);
            if (i2 != 2) {
            } else {
            }
            i3 = SafeParcelReader.d(parcel, i5, q0.CREATOR);
            SafeParcelReader.v(parcel, i5);
        }
        SafeParcelReader.j(parcel, i6);
        j obj7 = new j(i, i3);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new j[i];
    }
}
