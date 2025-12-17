package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class o implements Parcelable.Creator<f.c.a.d.c.n> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i4;
        int i;
        int i3;
        int i5;
        int i2;
        final int i6 = SafeParcelReader.w(parcel);
        i = i4;
        while (parcel.dataPosition() < i6) {
            i3 = SafeParcelReader.p(parcel);
            i5 = SafeParcelReader.k(i3);
            if (i5 != 2) {
            } else {
            }
            i4 = SafeParcelReader.r(parcel, i3);
            if (i5 != 3) {
            } else {
            }
            i = SafeParcelReader.l(parcel, i3);
            SafeParcelReader.v(parcel, i3);
        }
        SafeParcelReader.j(parcel, i6);
        n obj7 = new n(i4, i);
        return obj7;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new n[i];
    }
}
