package c.a.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public interface a extends IInterface {

    public static abstract class a extends Binder implements c.a.a.a {
        public a() {
            super();
            attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
            int i2;
            int i3;
            int obj5;
            Object obj6;
            int obj8;
            String str = "android.support.customtabs.ICustomTabsCallback";
            final int i11 = 1;
            if (i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 1598968902) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 6) {
                                if (i != 1598968902) {
                                    return super.onTransact(i, parcel2, parcel3, i4);
                                }
                                parcel3.writeString(str);
                                return i11;
                            }
                            parcel2.enforceInterface(str);
                            if (parcel2.readInt() != 0) {
                                obj8 = Uri.CREATOR.createFromParcel(parcel2);
                            } else {
                                obj8 = i3;
                            }
                            i2 = parcel2.readInt() != 0 ? i11 : 0;
                            if (parcel2.readInt() != 0) {
                                i3 = obj6;
                            }
                            c2(parcel2.readInt(), obj8, i2, i3);
                            parcel3.writeNoException();
                            return i11;
                        }
                        parcel2.enforceInterface(str);
                        if (parcel2.readInt() != 0) {
                            i3 = obj6;
                        }
                        T1(parcel2.readString(), i3);
                        parcel3.writeNoException();
                        return i11;
                    }
                    parcel2.enforceInterface(str);
                    if (parcel2.readInt() != 0) {
                        i3 = obj5;
                    }
                    Z1(i3);
                    parcel3.writeNoException();
                    return i11;
                }
                parcel2.enforceInterface(str);
                if (parcel2.readInt() != 0) {
                    i3 = obj6;
                }
                p1(parcel2.readString(), i3);
                parcel3.writeNoException();
                return i11;
            }
            parcel2.enforceInterface(str);
            if (parcel2.readInt() != 0) {
                i3 = obj6;
            }
            z1(parcel2.readInt(), i3);
            parcel3.writeNoException();
            return i11;
        }
    }
    @Override // android.os.IInterface
    public abstract void T1(String string, Bundle bundle2);

    @Override // android.os.IInterface
    public abstract void Z1(Bundle bundle);

    @Override // android.os.IInterface
    public abstract void c2(int i, Uri uri2, boolean z3, Bundle bundle4);

    @Override // android.os.IInterface
    public abstract void p1(String string, Bundle bundle2);

    @Override // android.os.IInterface
    public abstract void z1(int i, Bundle bundle2);
}
