package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface j0 extends IInterface {

    public static abstract class a extends Binder implements androidx.room.j0 {
        public a() {
            super();
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static androidx.room.j0 j(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (localInterface != null && localInterface instanceof j0) {
                if (localInterface instanceof j0) {
                    return (j0)localInterface;
                }
            }
            j0.a.a aVar = new j0.a.a(iBinder);
            return aVar;
        }

        public static androidx.room.j0 m() {
            return j0.a.a.b;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
            final int i2 = 1;
            final String str = "androidx.room.IMultiInstanceInvalidationService";
            if (i != i2 && i != 2 && i != 3 && i != 1598968902) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 1598968902) {
                            return super.onTransact(i, parcel2, parcel3, i4);
                        }
                        parcel3.writeString(str);
                        return i2;
                    }
                    parcel2.enforceInterface(str);
                    X1(parcel2.readInt(), parcel2.createStringArray());
                    return i2;
                }
                parcel2.enforceInterface(str);
                f2(i0.a.j(parcel2.readStrongBinder()), parcel2.readInt());
                parcel3.writeNoException();
                return i2;
            }
            parcel2.enforceInterface(str);
            parcel3.writeNoException();
            parcel3.writeInt(e0(i0.a.j(parcel2.readStrongBinder()), parcel2.readString()));
            return i2;
        }
    }
    @Override // android.os.IInterface
    public abstract void X1(int i, String[] string2Arr2);

    @Override // android.os.IInterface
    public abstract int e0(androidx.room.i0 i0, String string2);

    @Override // android.os.IInterface
    public abstract void f2(androidx.room.i0 i0, int i2);
}
