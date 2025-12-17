package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.p0;
import com.google.android.gms.internal.measurement.q0;

/* loaded from: classes2.dex */
public abstract class f3 extends p0 implements com.google.android.gms.measurement.internal.g3 {
    public f3() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.p0
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        android.os.Parcelable.Creator cREATOR;
        long cREATOR2;
        String string;
        String string2;
        String string3;
        Object obj7;
        Parcel obj8;
        Object obj10;
        switch (i) {
            case 1:
                M0((u)q0.a(parcel2, u.CREATOR), (na)q0.a(parcel2, na.CREATOR));
                parcel3.writeNoException();
                break;
            case 2:
                J1((ea)q0.a(parcel2, ea.CREATOR), (na)q0.a(parcel2, na.CREATOR));
                parcel3.writeNoException();
                break;
            case 3:
                return 0;
            case 4:
                q0((na)q0.a(parcel2, na.CREATOR));
                parcel3.writeNoException();
                break;
            case 5:
                M1((u)q0.a(parcel2, u.CREATOR), parcel2.readString(), parcel2.readString());
                parcel3.writeNoException();
                break;
            case 6:
                A0((na)q0.a(parcel2, na.CREATOR));
                parcel3.writeNoException();
                break;
            case 7:
                parcel3.writeNoException();
                parcel3.writeTypedList(E1((na)q0.a(parcel2, na.CREATOR), q0.f(parcel2)));
                break;
            case 8:
                parcel3.writeNoException();
                parcel3.writeByteArray(f0((u)q0.a(parcel2, u.CREATOR), parcel2.readString()));
                break;
            case 9:
                this.U0(parcel2.readLong(), obj2, parcel2.readString(), parcel2.readString());
                parcel3.writeNoException();
                break;
            case 10:
                parcel3.writeNoException();
                parcel3.writeString(R((na)q0.a(parcel2, na.CREATOR)));
                break;
            case 11:
                z((c)q0.a(parcel2, c.CREATOR), (na)q0.a(parcel2, na.CREATOR));
                parcel3.writeNoException();
                break;
            case 12:
                a0((c)q0.a(parcel2, c.CREATOR));
                parcel3.writeNoException();
                break;
            case 13:
                parcel3.writeNoException();
                parcel3.writeTypedList(Z0(parcel2.readString(), parcel2.readString(), q0.f(parcel2), (na)q0.a(parcel2, na.CREATOR)));
                break;
            case 14:
                parcel3.writeNoException();
                parcel3.writeTypedList(F(parcel2.readString(), parcel2.readString(), parcel2.readString(), q0.f(parcel2)));
                break;
            case 15:
                parcel3.writeNoException();
                parcel3.writeTypedList(s0(parcel2.readString(), parcel2.readString(), (na)q0.a(parcel2, na.CREATOR)));
                break;
            case 16:
                parcel3.writeNoException();
                parcel3.writeTypedList(b0(parcel2.readString(), parcel2.readString(), parcel2.readString()));
                break;
            case 17:
                J((na)q0.a(parcel2, na.CREATOR));
                parcel3.writeNoException();
                break;
            case 18:
                t((Bundle)q0.a(parcel2, Bundle.CREATOR), (na)q0.a(parcel2, na.CREATOR));
                parcel3.writeNoException();
                break;
            default:
                T0((na)q0.a(parcel2, na.CREATOR));
                parcel3.writeNoException();
        }
        return 1;
    }
}
