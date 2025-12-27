package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<a> {
    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        byte[] bArr;
        int i2;
        final int i6 = SafeParcelReader.w(parcel);
        i2 = 0;
        while (parcel.dataPosition() < i6) {
            int i3 = SafeParcelReader.p(parcel);
            int i4 = SafeParcelReader.k(i3);
            int i5 = 2;
        }
        SafeParcelReader.j(parcel, i6);
        return new a(str, bArr, i2);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new a[i];
    }
}
