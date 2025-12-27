package f.c.a.d.c;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class p implements Parcelable.Creator<b> {
    static void a(b bVar, Parcel parcel, int i) {
        final boolean z = false;
        b.o(parcel, 2, bVar.m2(), z);
        b.n(parcel, 3, bVar.j2(), i, z);
        int i5 = 4;
        b.n(parcel, i5, bVar.k2(), i, z);
        b.l(parcel, 5, bVar.l2());
        b.f(parcel, 6, bVar.n2(), z);
        b.b(parcel, b.a(parcel));
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str;
        DataHolder dataHolder;
        ParcelFileDescriptor parcelFileDescriptor;
        int i2;
        int i;
        final int i4 = SafeParcelReader.w(parcel);
        i = 0;
        i2 = 0;
        while (parcel.dataPosition() < i4) {
            i = SafeParcelReader.p(parcel);
            i2 = SafeParcelReader.k(i);
            int i3 = 2;
        }
        SafeParcelReader.j(parcel, i4);
        b parcel2 = new b(str, dataHolder, parcelFileDescriptor, i2, bArr, i);
        return parcel2;
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new b[i];
    }
}
