package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;

/* loaded from: classes2.dex */
public interface m extends IInterface {

    public static abstract class a extends Binder implements com.google.android.gms.common.internal.m {
        public a() {
            super();
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
            int i2;
            int localInterface;
            boolean z;
            int obj4;
            int obj6;
            if (i > 16777215) {
                return super.onTransact(i, parcel2, parcel3, i4);
            }
            parcel2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder obj7 = parcel2.readStrongBinder();
            if (obj7 == null) {
                localInterface = i2;
            } else {
                if (localInterface instanceof l) {
                } else {
                    localInterface = new b2(obj7);
                }
            }
            int i5 = 1;
            if (i == 46 && parcel2.readInt() != 0) {
                if (parcel2.readInt() != 0) {
                    i2 = obj4;
                }
                getService(localInterface, i2);
                r.j(parcel3);
                parcel3.writeNoException();
                return i5;
            }
            if (i == 47) {
                if (parcel2.readInt() == 0) {
                } else {
                    obj4 = d1.CREATOR.createFromParcel(parcel2);
                }
                obj4 = new UnsupportedOperationException();
                throw obj4;
            }
            parcel2.readInt();
            if (i == 4) {
            } else {
                parcel2.readString();
                if (i != i5) {
                    if (i != 2 && i != 23 && i != 25 && i != 27) {
                        if (i != 23) {
                            if (i != 25) {
                                if (i != 27) {
                                    if (i != 30) {
                                        if (i != 34) {
                                            if (i != 41 && i != 43 && i != 37 && i != 38) {
                                                if (i != 43) {
                                                    if (i != 37) {
                                                        if (i != 38) {
                                                            switch (i) {
                                                                case 5:
                                                                    obj4 = Bundle.CREATOR.createFromParcel(parcel2);
                                                                    break;
                                                                case 6:
                                                                    parcel2.readString();
                                                                    parcel2.createStringArray();
                                                                    parcel2.readString();
                                                                    parcel2.readStrongBinder();
                                                                    parcel2.readString();
                                                                    obj4 = Bundle.CREATOR.createFromParcel(parcel2);
                                                                    break;
                                                                case 7:
                                                                    parcel2.readString();
                                                                    parcel2.createStringArray();
                                                                    break;
                                                                case 8:
                                                                    parcel2.readStrongBinder();
                                                                    obj4 = Bundle.CREATOR.createFromParcel(parcel2);
                                                                    break;
                                                                case 9:
                                                                    parcel2.createStringArray();
                                                                    parcel2.readString();
                                                                    obj4 = Bundle.CREATOR.createFromParcel(parcel2);
                                                                    break;
                                                                default:
                                                            }
                                                        } else {
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                            parcel2.readString();
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    parcel2.readString();
                    parcel2.createStringArray();
                    parcel2.readString();
                    if (parcel2.readInt() == 0) {
                    } else {
                        obj4 = Bundle.CREATOR.createFromParcel(parcel2);
                    }
                }
            }
            obj4 = new UnsupportedOperationException();
            throw obj4;
        }
    }
    @Override // android.os.IInterface
    public abstract void getService(com.google.android.gms.common.internal.l l, com.google.android.gms.common.internal.g g2);
}
