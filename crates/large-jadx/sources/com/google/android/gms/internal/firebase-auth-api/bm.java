package com.google.android.gms.internal.firebase-auth-api;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class bm extends com.google.android.gms.internal.firebase-auth-api.o2 implements com.google.android.gms.internal.firebase-auth-api.dm {
    public bm() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.o2
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        boolean str;
        android.os.Parcelable obj2;
        IBinder obj3;
        com.google.android.gms.internal.firebase-auth-api.xl obj5;
        obj5 = 0;
        str = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks";
        switch (i) {
            case 101:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                O((ae)p3.a(parcel2, ae.CREATOR), obj5);
                break;
            case 102:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                v((ze)p3.a(parcel2, ze.CREATOR), obj5);
                break;
            case 103:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                t1((xe)p3.a(parcel2, xe.CREATOR), obj5);
                break;
            case 104:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                v1((rf)p3.a(parcel2, rf.CREATOR), obj5);
                break;
            case 105:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                R1((jd)p3.a(parcel2, jd.CREATOR), obj5);
                break;
            case 106:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                S((ld)p3.a(parcel2, ld.CREATOR), obj5);
                break;
            case 107:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                B0((rd)p3.a(parcel2, rd.CREATOR), obj5);
                break;
            case 108:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                t0((bf)p3.a(parcel2, bf.CREATOR), obj5);
                break;
            case 109:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                N0((ce)p3.a(parcel2, ce.CREATOR), obj5);
                break;
            case 110:
                return 0;
            case 111:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                V1((ee)p3.a(parcel2, ee.CREATOR), obj5);
                break;
            case 112:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                p0((ge)p3.a(parcel2, ge.CREATOR), obj5);
                break;
            case 113:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                j2((nf)p3.a(parcel2, nf.CREATOR), obj5);
                break;
            case 114:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                r0((pf)p3.a(parcel2, pf.CREATOR), obj5);
                break;
            case 115:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                y((ke)p3.a(parcel2, ke.CREATOR), obj5);
                break;
            case 116:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                o((ue)p3.a(parcel2, ue.CREATOR), obj5);
                break;
            case 117:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                C1((td)p3.a(parcel2, td.CREATOR), obj5);
                break;
            case 118:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                g1((nd)p3.a(parcel2, nd.CREATOR), obj5);
                break;
            case 119:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                H0((hd)p3.a(parcel2, hd.CREATOR), obj5);
                break;
            case 120:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                q((pd)p3.a(parcel2, pd.CREATOR), obj5);
                break;
            case 121:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                h0((qe)p3.a(parcel2, qe.CREATOR), obj5);
                break;
            case 122:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                Z((ff)p3.a(parcel2, ff.CREATOR), obj5);
                break;
            case 123:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                B1((ie)p3.a(parcel2, ie.CREATOR), obj5);
                break;
            case 124:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                F0((me)p3.a(parcel2, me.CREATOR), obj5);
                break;
            case 125:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                n1((se)p3.a(parcel2, se.CREATOR), obj5);
                break;
            case 126:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                b2((oe)p3.a(parcel2, oe.CREATOR), obj5);
                break;
            case 127:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                G1((df)p3.a(parcel2, df.CREATOR), obj5);
                break;
            case 128:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                I1((hf)p3.a(parcel2, hf.CREATOR), obj5);
                break;
            case 129:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                R0((lf)p3.a(parcel2, lf.CREATOR), obj5);
                break;
            case 130:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                m0((wd)p3.a(parcel2, wd.CREATOR), obj5);
                break;
            case 131:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                K((jf)p3.a(parcel2, jf.CREATOR), obj5);
                break;
            case 132:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                H1((yd)p3.a(parcel2, yd.CREATOR), obj5);
                break;
            default:
                obj3 = parcel2.readStrongBinder();
                obj5 = new xl(obj3);
                D((tf)p3.a(parcel2, tf.CREATOR), obj5);
        }
        parcel3.writeNoException();
        return 1;
    }
}
