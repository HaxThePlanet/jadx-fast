package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class k implements Parcelable.Creator<f.c.a.d.c.j> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int cREATOR;
        int i2;
        int i6;
        int i5;
        int i3;
        int i4;
        final int i7 = SafeParcelReader.w(parcel);
        i4 = i3;
        i6 = cREATOR;
        i5 = i8;
        while (parcel.dataPosition() < i7) {
            i = SafeParcelReader.p(parcel);
            cREATOR = SafeParcelReader.k(i);
            if (cREATOR != 2) {
            } else {
            }
            i6 = SafeParcelReader.s(parcel, i);
            if (cREATOR != 3) {
            } else {
            }
            i5 = i;
            if (cREATOR != 4) {
            } else {
            }
            i3 = SafeParcelReader.r(parcel, i);
            if (cREATOR != 5) {
            } else {
            }
            i4 = SafeParcelReader.l(parcel, i);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i7);
        super(i6, obj7, i5, i3, i4);
        return obj12;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new j[i];
    }
}
