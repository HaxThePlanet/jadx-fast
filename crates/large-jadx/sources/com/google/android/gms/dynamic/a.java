package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
import f.c.a.d.b.g.b;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    public static abstract class a extends b implements com.google.android.gms.dynamic.a {
        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static com.google.android.gms.dynamic.a m(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (localInterface instanceof a) {
                return (a)localInterface;
            }
            c cVar = new c(iBinder);
            return cVar;
        }
    }
}
