package androidx.core.graphics.drawable;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static androidx.core.graphics.drawable.IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = versionedParcel.p(iconCompat.a, 1);
        iconCompat.c = versionedParcel.j(iconCompat.c, 2);
        iconCompat.d = versionedParcel.r(iconCompat.d, 3);
        iconCompat.e = versionedParcel.p(iconCompat.e, 4);
        iconCompat.f = versionedParcel.p(iconCompat.f, 5);
        iconCompat.g = (ColorStateList)versionedParcel.r(iconCompat.g, 6);
        iconCompat.i = versionedParcel.t(iconCompat.i, 7);
        iconCompat.j = versionedParcel.t(iconCompat.j, 8);
        iconCompat.n();
        return iconCompat;
    }

    public static void write(androidx.core.graphics.drawable.IconCompat iconCompat, VersionedParcel versionedParcel2) {
        String str;
        int i;
        int i2 = 1;
        versionedParcel2.x(i2, i2);
        iconCompat.o(versionedParcel2.f());
        i = iconCompat.a;
        if (-1 != i) {
            versionedParcel2.F(i, i2);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            versionedParcel2.B(bArr, 2);
        }
        android.os.Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            versionedParcel2.H(parcelable, 3);
        }
        int i3 = iconCompat.e;
        if (i3 != 0) {
            versionedParcel2.F(i3, 4);
        }
        int i4 = iconCompat.f;
        if (i4 != 0) {
            versionedParcel2.F(i4, 5);
        }
        android.content.res.ColorStateList list = iconCompat.g;
        if (list != null) {
            versionedParcel2.H(list, 6);
        }
        str = iconCompat.i;
        if (str != null) {
            versionedParcel2.J(str, 7);
        }
        final String obj3 = iconCompat.j;
        if (obj3 != null) {
            versionedParcel2.J(obj3, 8);
        }
    }
}
