package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class DataHolder extends a implements Closeable {

    public static final Parcelable.Creator<com.google.android.gms.common.data.DataHolder> CREATOR;
    private boolean A = true;
    final int a;
    private final String[] b;
    Bundle c;
    private final CursorWindow[] v;
    private final int w;
    private final Bundle x;
    int[] y;
    boolean z = false;

    public static class a {
        a(String[] stringArr, String string2, com.google.android.gms.common.data.a a3) {
            super();
            r.j(stringArr);
            ArrayList obj1 = new ArrayList();
            obj1 = new HashMap();
        }
    }
    static {
        b bVar = new b();
        DataHolder.CREATOR = bVar;
        a aVar = new a(new String[0], 0);
    }

    DataHolder(int i, String[] string2Arr2, CursorWindow[] cursorWindow3Arr3, int i4, Bundle bundle5) {
        super();
        int i2 = 0;
        int i3 = 1;
        this.a = i;
        this.b = string2Arr2;
        this.v = cursorWindow3Arr3;
        this.w = i4;
        this.x = bundle5;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void close() {
        int z;
        CursorWindow cursorWindow;
        int length;
        synchronized (this) {
            try {
                this.z = true;
                z = 0;
                cursorWindow = this.v;
                for (Object cursorWindow : obj1) {
                    cursorWindow.close();
                    cursorWindow = this.v;
                }
                cursorWindow[z].close();
                z++;
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    protected final void finalize() {
        boolean length;
        String string;
        String str;
        StringBuilder stringBuilder;
        try {
            if (this.A && objArr.length > 0 && !isClosed()) {
            }
            if (objArr.length > 0) {
            }
            if (!isClosed()) {
            }
            close();
            String string2 = toString();
            stringBuilder = new StringBuilder(length2 += 178);
            stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
            stringBuilder.append(string2);
            stringBuilder.append(")");
            Log.e("DataBuffer", stringBuilder.toString());
            super.finalize();
            super.finalize();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean isClosed() {
        return this.z;
        synchronized (this) {
            return this.z;
        }
    }

    public Bundle j2() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int k2() {
        return this.w;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void l2() {
        int i2;
        int i3;
        int i;
        String str;
        String[] strArr;
        Bundle bundle;
        int length;
        Bundle bundle2 = new Bundle();
        this.c = bundle2;
        i2 = 0;
        i3 = i2;
        strArr = this.b;
        for (Object str : obj2) {
            this.c.putInt(str, i3);
            strArr = this.b;
        }
        this.y = new int[objArr.length];
        i = i2;
        CursorWindow[] objArr2 = this.v;
        for (Object cursorWindow : obj2) {
            this.y[i2] = i;
            i += length;
            objArr2 = this.v;
        }
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        int i6 = 0;
        b.p(parcel, 1, this.b, i6);
        b.r(parcel, 2, this.v, i2, i6);
        b.j(parcel, 3, k2());
        b.e(parcel, 4, j2(), i6);
        b.j(parcel, 1000, this.a);
        b.b(parcel, b.a(parcel));
        if (i2 & 1 != 0) {
            close();
        }
    }
}
