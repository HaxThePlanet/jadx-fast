package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface i0 extends IInterface {

    public static abstract class a extends Binder implements androidx.room.i0 {
        public a() {
            super();
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static androidx.room.i0 j(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (localInterface != null && localInterface instanceof i0) {
                if (localInterface instanceof i0) {
                    return (i0)localInterface;
                }
            }
            i0.a.a aVar = new i0.a.a(iBinder);
            return aVar;
        }

        public static androidx.room.i0 m() {
            return i0.a.a.b;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
            final int i2 = 1;
            final String str = "androidx.room.IMultiInstanceInvalidationCallback";
            if (i != i2 && i != 1598968902) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel2, parcel3, i4);
                }
                parcel3.writeString(str);
                return i2;
            }
            parcel2.enforceInterface(str);
            N(parcel2.createStringArray());
            return i2;
        }
    }
    @Override // android.os.IInterface
    public abstract void N(String[] stringArr);
}
