package c.a.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ICustomTabsCallback.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    public static abstract class a extends Binder implements a {
        public a() {
            super();
            attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws android.os.RemoteException {
            boolean z = false;
            Bundle bundle = null;
            Bundle bundle2 = null;
            Bundle bundle3 = null;
            Bundle bundle4 = null;
            Bundle bundle5 = null;
            Uri uri;
            String str = "android.support.customtabs.ICustomTabsCallback";
            i2 = 1;
            if (i != 2 && i != 3 && i != 4 && i != 5 && i != 6) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("android.support.customtabs.ICustomTabsCallback");
                return true;
            }
            parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            if (parcel.readInt() != 0) {
            }
            z1(parcel.readInt(), bundle5);
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }
    }
    void T1(String str, Bundle bundle);

    void Z1(Bundle bundle);

    void c2(int i, Uri uri, boolean z, Bundle bundle);

    void p1(String str, Bundle bundle);

    void z1(int i, Bundle bundle);
}
