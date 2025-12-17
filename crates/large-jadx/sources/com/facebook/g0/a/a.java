package com.facebook.g0.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface a extends IInterface {

    public static abstract class a extends Binder implements com.facebook.g0.a.a {
        public static com.facebook.g0.a.a j(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("com.facebook.ppml.receiver.IReceiverService");
            if (localInterface != null && localInterface instanceof a) {
                if (localInterface instanceof a) {
                    return (a)localInterface;
                }
            }
            a.a.a aVar = new a.a.a(iBinder);
            return aVar;
        }

        public static com.facebook.g0.a.a m() {
            return a.a.a.b;
        }
    }
    @Override // android.os.IInterface
    public abstract int I(Bundle bundle);
}
