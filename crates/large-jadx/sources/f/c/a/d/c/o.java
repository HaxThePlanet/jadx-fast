package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class o implements Parcelable.Creator<n> {
    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        boolean z;
        final int i5 = SafeParcelReader.w(parcel);
        i = 0;
        while (parcel.dataPosition() < i5) {
            int i2 = SafeParcelReader.p(parcel);
            int i3 = SafeParcelReader.k(i2);
            int i4 = 2;
        }
        SafeParcelReader.j(parcel, i5);
        return new n(i, z);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new n[i];
    }
}
