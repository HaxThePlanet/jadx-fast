package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class m implements Parcelable.Creator<f.c.a.d.c.l> {
    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i3;
        int i2;
        int i4;
        int i;
        final int i5 = SafeParcelReader.w(parcel);
        i3 = 0;
        while (parcel.dataPosition() < i5) {
            i2 = SafeParcelReader.p(parcel);
            if (SafeParcelReader.k(i2) != 2) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i2);
            SafeParcelReader.v(parcel, i2);
        }
        SafeParcelReader.j(parcel, i5);
        l obj6 = new l(i3);
        return obj6;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new l[i];
    }
}
