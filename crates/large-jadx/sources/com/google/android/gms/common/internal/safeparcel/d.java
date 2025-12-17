package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.c;

/* loaded from: classes2.dex */
public final class d {
    public static <T extends com.google.android.gms.common.internal.safeparcel.c> T a(byte[] bArr, Parcelable.Creator<T> parcelable$Creator2) {
        r.j(creator2);
        final Parcel obtain = Parcel.obtain();
        final int i = 0;
        obtain.unmarshall(bArr, i, bArr.length);
        obtain.setDataPosition(i);
        obtain.recycle();
        return (c)creator2.createFromParcel(obtain);
    }

    public static <T extends com.google.android.gms.common.internal.safeparcel.c> T b(Intent intent, String string2, Parcelable.Creator<T> parcelable$Creator3) {
        byte[] obj0 = intent.getByteArrayExtra(string2);
        if (obj0 == null) {
            return 0;
        }
        return d.a(obj0, creator3);
    }

    public static <T extends com.google.android.gms.common.internal.safeparcel.c> T c(String string, Parcelable.Creator<T> parcelable$Creator2) {
        return d.a(c.a(string), creator2);
    }

    public static <T extends com.google.android.gms.common.internal.safeparcel.c> byte[] d(T t) {
        final Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        obtain.recycle();
        return obtain.marshall();
    }

    public static <T extends com.google.android.gms.common.internal.safeparcel.c> void e(T t, Intent intent2, String string3) {
        intent2.putExtra(string3, d.d(t));
    }

    public static <T extends com.google.android.gms.common.internal.safeparcel.c> String f(T t) {
        return c.d(d.d(t));
    }
}
