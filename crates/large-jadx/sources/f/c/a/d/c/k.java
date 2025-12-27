package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class k implements Parcelable.Creator<j> {
    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i2;
        int i4;
        boolean z;
        int i;
        final int i5 = SafeParcelReader.w(parcel);
        i = 0;
        i2 = 0;
        i4 = 0;
        while (parcel.dataPosition() < i5) {
            i = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i);
            int i3 = 2;
        }
        SafeParcelReader.j(parcel, i5);
        j parcel2 = new j(i2, objArr2, i4, z, i);
        return parcel2;
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new j[i];
    }
}
