package com.google.android.gms.internal.firebase-auth-api;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthCredential;

/* loaded from: classes2.dex */
public abstract class yl extends com.google.android.gms.internal.firebase-auth-api.o2 implements com.google.android.gms.internal.firebase-auth-api.zl {
    public yl() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.o2
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        Object obj1;
        Object obj2;
        android.os.Parcelable.Creator obj3;
        switch (i) {
            case 1:
                m2((to)p3.a(parcel2, to.CREATOR));
                break;
            case 2:
                Y0((to)p3.a(parcel2, to.CREATOR), (mo)p3.a(parcel2, mo.CREATOR));
                break;
            case 3:
                M((yn)p3.a(parcel2, yn.CREATOR));
                break;
            case 4:
                v0((fp)p3.a(parcel2, fp.CREATOR));
                break;
            case 5:
                S1((Status)p3.a(parcel2, Status.CREATOR));
                break;
            case 6:
                d();
                break;
            case 7:
                f();
                break;
            case 8:
                m1(parcel2.readString());
                break;
            case 9:
                g0(parcel2.readString());
                break;
            case 10:
                V0((PhoneAuthCredential)p3.a(parcel2, PhoneAuthCredential.CREATOR));
                break;
            case 11:
                x0(parcel2.readString());
                break;
            case 12:
                A((Status)p3.a(parcel2, Status.CREATOR), (PhoneAuthCredential)p3.a(parcel2, PhoneAuthCredential.CREATOR));
                break;
            case 13:
                e();
                break;
            case 14:
                r1((vf)p3.a(parcel2, vf.CREATOR));
                break;
            case 15:
                O1((yf)p3.a(parcel2, yf.CREATOR));
                break;
            default:
                return 0;
        }
        return 1;
    }
}
