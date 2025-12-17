package f.c.a.d.b.i;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class b extends f.c.a.d.b.i.e implements f.c.a.d.b.i.d {
    b(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // f.c.a.d.b.i.e
    public final int C(int i, String string2, String string3) {
        Parcel obj2 = j();
        obj2.writeInt(3);
        obj2.writeString(string2);
        obj2.writeString(string3);
        obj2 = m(5, obj2);
        obj2.recycle();
        return obj2.readInt();
    }

    @Override // f.c.a.d.b.i.e
    public final int D0(int i, String string2, String string3) {
        final Parcel parcel = j();
        parcel.writeInt(i);
        parcel.writeString(string2);
        parcel.writeString(string3);
        Parcel obj2 = m(1, parcel);
        obj2.recycle();
        return obj2.readInt();
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle H(int i, String string2, String string3, Bundle bundle4) {
        Parcel obj2 = j();
        obj2.writeInt(9);
        obj2.writeString(string2);
        obj2.writeString(string3);
        g.b(obj2, bundle4);
        obj2 = m(12, obj2);
        obj2.recycle();
        return (Bundle)g.a(obj2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final int N1(int i, String string2, String string3, Bundle bundle4) {
        Parcel obj2 = j();
        obj2.writeInt(7);
        obj2.writeString(string2);
        obj2.writeString(string3);
        g.b(obj2, bundle4);
        obj2 = m(10, obj2);
        obj2.recycle();
        return obj2.readInt();
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle P(int i, String string2, String string3, String string4, Bundle bundle5) {
        Parcel obj2 = j();
        obj2.writeInt(6);
        obj2.writeString(string2);
        obj2.writeString(string3);
        obj2.writeString(string4);
        g.b(obj2, bundle5);
        obj2 = m(9, obj2);
        obj2.recycle();
        return (Bundle)g.a(obj2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle U1(int i, String string2, String string3, String string4, Bundle bundle5) {
        Parcel obj2 = j();
        obj2.writeInt(9);
        obj2.writeString(string2);
        obj2.writeString(string3);
        obj2.writeString(string4);
        g.b(obj2, bundle5);
        obj2 = m(11, obj2);
        obj2.recycle();
        return (Bundle)g.a(obj2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle g2(int i, String string2, String string3, Bundle bundle4) {
        Parcel obj2 = j();
        obj2.writeInt(9);
        obj2.writeString(string2);
        obj2.writeString(string3);
        g.b(obj2, bundle4);
        obj2 = m(902, obj2);
        obj2.recycle();
        return (Bundle)g.a(obj2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle o0(int i, String string2, String string3, String string4) {
        Parcel obj2 = j();
        obj2.writeInt(3);
        obj2.writeString(string2);
        obj2.writeString(string3);
        obj2.writeString(string4);
        obj2 = m(4, obj2);
        obj2.recycle();
        return (Bundle)g.a(obj2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle o1(int i, String string2, String string3, String string4, String string5, Bundle bundle6) {
        final Parcel obj5 = j();
        obj5.writeInt(i);
        obj5.writeString(string2);
        obj5.writeString(string3);
        obj5.writeString(string4);
        obj5.writeString(0);
        g.b(obj5, bundle6);
        Parcel obj1 = m(8, obj5);
        obj1.recycle();
        return (Bundle)g.a(obj1, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle q1(int i, String string2, String string3, Bundle bundle4) {
        Parcel obj2 = j();
        obj2.writeInt(3);
        obj2.writeString(string2);
        obj2.writeString(string3);
        g.b(obj2, bundle4);
        obj2 = m(2, obj2);
        obj2.recycle();
        return (Bundle)g.a(obj2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle u0(int i, String string2, String string3, String string4, String string5) {
        Parcel obj1 = j();
        final int obj5 = 3;
        obj1.writeInt(obj5);
        obj1.writeString(string2);
        obj1.writeString(string3);
        obj1.writeString(string4);
        obj1.writeString(0);
        obj1 = m(obj5, obj1);
        obj1.recycle();
        return (Bundle)g.a(obj1, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle w(int i, String string2, String string3, Bundle bundle4, Bundle bundle5) {
        Parcel obj2 = j();
        obj2.writeInt(10);
        obj2.writeString(string2);
        obj2.writeString(string3);
        g.b(obj2, bundle4);
        g.b(obj2, bundle5);
        obj2 = m(901, obj2);
        obj2.recycle();
        return (Bundle)g.a(obj2, Bundle.CREATOR);
    }
}
