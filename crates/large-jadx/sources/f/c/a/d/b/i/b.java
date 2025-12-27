package f.c.a.d.b.i;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes2.dex */
public final class b extends e implements d {
    b(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // f.c.a.d.b.i.e
    public final int C(int i, String str, String str2) {
        Parcel parcel = j();
        parcel.writeInt(3);
        parcel.writeString(str);
        parcel.writeString(str2);
        Parcel parcel2 = m(5, parcel);
        parcel2.recycle();
        return parcel2.readInt();
    }

    @Override // f.c.a.d.b.i.e
    public final int D0(int i, String str, String str2) {
        final Parcel parcel = j();
        parcel.writeInt(i);
        parcel.writeString(str);
        parcel.writeString(str2);
        Parcel parcel2 = m(1, parcel);
        parcel2.recycle();
        return parcel2.readInt();
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle H(int i, String str, String str2, Bundle bundle) {
        Parcel parcel = j();
        parcel.writeInt(9);
        parcel.writeString(str);
        parcel.writeString(str2);
        g.b(parcel, bundle);
        Parcel parcel2 = m(12, parcel);
        parcel2.recycle();
        return (Bundle)g.a(parcel2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final int N1(int i, String str, String str2, Bundle bundle) {
        Parcel parcel = j();
        parcel.writeInt(7);
        parcel.writeString(str);
        parcel.writeString(str2);
        g.b(parcel, bundle);
        Parcel parcel2 = m(10, parcel);
        parcel2.recycle();
        return parcel2.readInt();
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle P(int i, String str, String str2, String str3, Bundle bundle) {
        Parcel parcel = j();
        parcel.writeInt(6);
        parcel.writeString(str);
        parcel.writeString(str2);
        parcel.writeString(str3);
        g.b(parcel, bundle);
        Parcel parcel2 = m(9, parcel);
        parcel2.recycle();
        return (Bundle)g.a(parcel2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle U1(int i, String str, String str2, String str3, Bundle bundle) {
        Parcel parcel = j();
        parcel.writeInt(9);
        parcel.writeString(str);
        parcel.writeString(str2);
        parcel.writeString(str3);
        g.b(parcel, bundle);
        Parcel parcel2 = m(11, parcel);
        parcel2.recycle();
        return (Bundle)g.a(parcel2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle g2(int i, String str, String str2, Bundle bundle) {
        Parcel parcel = j();
        parcel.writeInt(9);
        parcel.writeString(str);
        parcel.writeString(str2);
        g.b(parcel, bundle);
        Parcel parcel2 = m(902, parcel);
        parcel2.recycle();
        return (Bundle)g.a(parcel2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle o0(int i, String str, String str2, String str3) {
        Parcel parcel = j();
        parcel.writeInt(3);
        parcel.writeString(str);
        parcel.writeString(str2);
        parcel.writeString(str3);
        Parcel parcel2 = m(4, parcel);
        parcel2.recycle();
        return (Bundle)g.a(parcel2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle o1(int i, String str, String str2, String str3, String str4, Bundle bundle) {
        final Parcel parcel2 = j();
        parcel2.writeInt(i);
        parcel2.writeString(str);
        parcel2.writeString(str2);
        parcel2.writeString(str3);
        parcel2.writeString(null);
        g.b(parcel2, bundle);
        Parcel parcel = m(8, parcel2);
        parcel.recycle();
        return (Bundle)g.a(parcel, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle q1(int i, String str, String str2, Bundle bundle) {
        Parcel parcel = j();
        parcel.writeInt(3);
        parcel.writeString(str);
        parcel.writeString(str2);
        g.b(parcel, bundle);
        Parcel parcel2 = m(2, parcel);
        parcel2.recycle();
        return (Bundle)g.a(parcel2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle u0(int i, String str, String str2, String str3, String str4) {
        Parcel parcel = j();
        final int i3 = 3;
        parcel.writeInt(i3);
        parcel.writeString(str);
        parcel.writeString(str2);
        parcel.writeString(str3);
        parcel.writeString(null);
        Parcel parcel2 = m(i3, parcel);
        parcel2.recycle();
        return (Bundle)g.a(parcel2, Bundle.CREATOR);
    }

    @Override // f.c.a.d.b.i.e
    public final Bundle w(int i, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcel = j();
        parcel.writeInt(10);
        parcel.writeString(str);
        parcel.writeString(str2);
        g.b(parcel, bundle);
        g.b(parcel, bundle2);
        Parcel parcel2 = m(901, parcel);
        parcel2.recycle();
        return (Bundle)g.a(parcel2, Bundle.CREATOR);
    }
}
