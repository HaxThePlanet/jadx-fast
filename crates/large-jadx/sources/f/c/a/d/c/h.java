package f.c.a.d.c;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<g> {
    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        final int i4 = SafeParcelReader.w(parcel);
        int i5 = 0;
        while (parcel.dataPosition() < i4) {
            int i = SafeParcelReader.p(parcel);
            int i3 = 2;
        }
        SafeParcelReader.j(parcel, i4);
        return new g(str);
    }

    @Override // android.os.Parcelable$Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new g[i];
    }
}
