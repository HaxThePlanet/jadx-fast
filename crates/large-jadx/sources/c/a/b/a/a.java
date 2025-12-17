package c.a.b.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public interface a extends IInterface {

    public static abstract class a extends Binder implements c.a.b.a.a {
        public a() {
            super();
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static c.a.b.a.a j(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (localInterface != null && localInterface instanceof a) {
                if (localInterface instanceof a) {
                    return (a)localInterface;
                }
            }
            a.a.a aVar = new a.a.a(iBinder);
            return aVar;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
            int obj5;
            int obj6;
            final int i2 = 1;
            final String str = "android.support.v4.os.IResultReceiver";
            if (i != i2 && i != 1598968902) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel2, parcel3, i4);
                }
                parcel3.writeString(str);
                return i2;
            }
            parcel2.enforceInterface(str);
            if (parcel2.readInt() != 0) {
                obj5 = Bundle.CREATOR.createFromParcel(parcel2);
            } else {
                obj5 = 0;
            }
            l2(parcel2.readInt(), obj5);
            return i2;
        }
    }
    @Override // android.os.IInterface
    public abstract void l2(int i, Bundle bundle2);
}
