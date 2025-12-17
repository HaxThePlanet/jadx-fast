package f.c.a.d.c;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class p implements Parcelable.Creator<f.c.a.d.c.b> {
    static void a(f.c.a.d.c.b b, Parcel parcel2, int i3) {
        final int i6 = 0;
        b.o(parcel2, 2, b.m2(), i6);
        b.n(parcel2, 3, b.j2(), i3, i6);
        int i5 = 4;
        b.n(parcel2, i5, b.k2(), i3, i6);
        b.l(parcel2, 5, b.l2());
        b.f(parcel2, 6, b.n2(), i6);
        b.b(parcel2, b.a(parcel2));
    }

    @Override // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel) {
        int i;
        int cREATOR;
        int i2;
        int i3;
        int i6;
        int i7;
        int i5;
        int i4;
        final int i8 = SafeParcelReader.w(parcel);
        i4 = i7;
        i5 = cREATOR;
        while (parcel.dataPosition() < i8) {
            i = SafeParcelReader.p(parcel);
            cREATOR = SafeParcelReader.k(i);
            if (cREATOR != 2) {
            } else {
            }
            i3 = SafeParcelReader.e(parcel, i);
            if (cREATOR != 3) {
            } else {
            }
            i6 = i;
            if (cREATOR != 4) {
            } else {
            }
            i7 = i;
            if (cREATOR != 5) {
            } else {
            }
            i5 = SafeParcelReader.s(parcel, i);
            if (cREATOR != 6) {
            } else {
            }
            i4 = SafeParcelReader.b(parcel, i);
            SafeParcelReader.v(parcel, i);
        }
        SafeParcelReader.j(parcel, i8);
        super(i3, i6, i7, i5, obj9, i4);
        return obj12;
    }

    @Override // android.os.Parcelable$Creator
    public final Object[] newArray(int i) {
        return new b[i];
    }
}
