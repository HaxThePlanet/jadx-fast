package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.j.c;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class b implements Parcelable {

    public static final Parcelable.Creator<androidx.fragment.app.b> CREATOR;
    final java.lang.CharSequence A;
    final int B;
    final java.lang.CharSequence C;
    final ArrayList<String> D;
    final ArrayList<String> E;
    final boolean F;
    final int[] a;
    final ArrayList<String> b;
    final int[] c;
    final int[] v;
    final int w;
    final String x;
    final int y;
    final int z;

    class a implements Parcelable.Creator<androidx.fragment.app.b> {
        @Override // android.os.Parcelable$Creator
        public androidx.fragment.app.b a(Parcel parcel) {
            b bVar = new b(parcel);
            return bVar;
        }

        @Override // android.os.Parcelable$Creator
        public androidx.fragment.app.b[] b(int i) {
            return new b[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        b.a aVar = new b.a();
        b.CREATOR = aVar;
    }

    public b(Parcel parcel) {
        int obj2;
        super();
        this.a = parcel.createIntArray();
        this.b = parcel.createStringArrayList();
        this.c = parcel.createIntArray();
        this.v = parcel.createIntArray();
        this.w = parcel.readInt();
        this.x = parcel.readString();
        this.y = parcel.readInt();
        this.z = parcel.readInt();
        this.A = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.B = parcel.readInt();
        this.C = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.D = parcel.createStringArrayList();
        this.E = parcel.createStringArrayList();
        obj2 = parcel.readInt() != 0 ? 1 : 0;
        this.F = obj2;
    }

    public b(androidx.fragment.app.a a) {
        int i4;
        int i3;
        int ordinal;
        int ordinal2;
        int mWho;
        int i;
        int i2;
        super();
        int size = a.a.size();
        this.a = new int[size * 5];
        if (!a.g) {
        } else {
            ArrayList arrayList = new ArrayList(size);
            this.b = arrayList;
            this.c = new int[size];
            this.v = new int[size];
            i3 = i4;
            while (i4 < size) {
                Object obj = a.a.get(i4);
                int i12 = i3 + 1;
                this.a[i3] = obj.a;
                androidx.fragment.app.Fragment fragment = obj.b;
                if (fragment != null) {
                } else {
                }
                mWho = 0;
                this.b.add(mWho);
                int[] iArr4 = this.a;
                int i10 = i12 + 1;
                iArr4[i12] = obj.c;
                int i13 = i10 + 1;
                iArr4[i10] = obj.d;
                int i11 = i13 + 1;
                iArr4[i13] = obj.e;
                iArr4[i11] = obj.f;
                this.c[i4] = obj.g.ordinal();
                this.v[i4] = obj.h.ordinal();
                i4++;
                i3 = i;
                mWho = fragment.mWho;
            }
            this.w = a.f;
            this.x = a.i;
            this.y = a.t;
            this.z = a.j;
            this.A = a.k;
            this.B = a.l;
            this.C = a.m;
            this.D = a.n;
            this.E = a.o;
            this.F = a.p;
        }
        IllegalStateException obj8 = new IllegalStateException("Not on back stack");
        throw obj8;
    }

    @Override // android.os.Parcelable
    public androidx.fragment.app.a a(androidx.fragment.app.n n) {
        int i3;
        boolean string;
        int i6;
        int i7;
        int i;
        int[] str;
        androidx.fragment.app.w.a aVar;
        int i4;
        int i8;
        int i5;
        int i2;
        a aVar2 = new a(n);
        i7 = i3;
        str = this.a;
        while (i3 < str.length) {
            aVar = new w.a();
            int i18 = i3 + 1;
            aVar.a = str[i3];
            if (n.I0(2)) {
            }
            Object obj = this.b.get(i7);
            if ((String)obj != null) {
            } else {
            }
            aVar.b = 0;
            aVar.g = j.c.values()[this.c[i7]];
            aVar.h = j.c.values()[this.v[i7]];
            int[] iArr = this.a;
            int i17 = i18 + 1;
            i4 = iArr[i18];
            aVar.c = i4;
            int i19 = i17 + 1;
            i = iArr[i17];
            aVar.d = i;
            i5 = i19 + 1;
            i8 = iArr[i19];
            aVar.e = i8;
            int i11 = iArr[i5];
            aVar.f = i11;
            aVar2.b = i4;
            aVar2.c = i;
            aVar2.d = i8;
            aVar2.e = i11;
            aVar2.e(aVar);
            i7++;
            i3 = i2;
            str = this.a;
            aVar.b = n.i0((String)obj);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Instantiate ");
            stringBuilder.append(aVar2);
            stringBuilder.append(" op #");
            stringBuilder.append(i7);
            stringBuilder.append(" base fragment #");
            stringBuilder.append(this.a[i18]);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        aVar2.f = this.w;
        aVar2.i = this.x;
        aVar2.t = this.y;
        int obj10 = 1;
        aVar2.g = obj10;
        aVar2.j = this.z;
        aVar2.k = this.A;
        aVar2.l = this.B;
        aVar2.m = this.C;
        aVar2.n = this.D;
        aVar2.o = this.E;
        aVar2.p = this.F;
        aVar2.u(obj10);
        return aVar2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.a);
        parcel.writeStringList(this.b);
        parcel.writeIntArray(this.c);
        parcel.writeIntArray(this.v);
        parcel.writeInt(this.w);
        parcel.writeString(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        final int i = 0;
        TextUtils.writeToParcel(this.A, parcel, i);
        parcel.writeInt(this.B);
        TextUtils.writeToParcel(this.C, parcel, i);
        parcel.writeStringList(this.D);
        parcel.writeStringList(this.E);
        parcel.writeInt(this.F);
    }
}
