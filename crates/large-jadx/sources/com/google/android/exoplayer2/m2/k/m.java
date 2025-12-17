package com.google.android.exoplayer2.m2.k;

import android.accounts.Account;
import android.content.pm.ResolveInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.n1.b;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class m extends com.google.android.exoplayer2.m2.k.i {

    public static final Parcelable.Creator<com.google.android.exoplayer2.m2.k.m> CREATOR;
    public final String b;
    public final String c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.m2.k.m> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.m a(Parcel parcel) {
            m mVar = new m(parcel);
            return mVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.m2.k.m[] b(int i) {
            return new m[i];
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
        m.a aVar = new m.a();
        m.CREATOR = aVar;
    }

    m(Parcel parcel) {
        String string = parcel.readString();
        p0.i(string);
        super((String)string);
        this.b = parcel.readString();
        final String obj2 = parcel.readString();
        p0.i(obj2);
        this.c = (String)obj2;
    }

    public m(String string, String string2, String string3) {
        super(string);
        this.b = string2;
        this.c = string3;
    }

    private static List<Integer> a(String string) {
        int valueOf;
        Integer obj7;
        ArrayList arrayList = new ArrayList();
        final int i = 5;
        final int i2 = 10;
        final int i3 = 7;
        final int i4 = 0;
        final int i5 = 4;
        if (string.length() >= i2) {
            arrayList.add(Integer.valueOf(Integer.parseInt(string.substring(i4, i5))));
            arrayList.add(Integer.valueOf(Integer.parseInt(string.substring(i, i3))));
            arrayList.add(Integer.valueOf(Integer.parseInt(string.substring(8, i2))));
        } else {
            if (string.length() >= i3) {
                arrayList.add(Integer.valueOf(Integer.parseInt(string.substring(i4, i5))));
                arrayList.add(Integer.valueOf(Integer.parseInt(string.substring(i, i3))));
            } else {
                if (string.length() >= i5) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(string.substring(i4, i5))));
                        return arrayList;
                        string = new ArrayList();
                        return string;
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public boolean equals(Object object) {
        int i;
        String z;
        Class<com.google.android.exoplayer2.m2.k.m> obj;
        String str;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (m.class != object.getClass()) {
            } else {
                if (p0.b(this.a, object.a) && p0.b(this.b, object.b) && p0.b(this.c, object.c)) {
                    if (p0.b(this.b, object.b)) {
                        if (p0.b(this.c, object.c)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public int hashCode() {
        int i;
        int i2;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        } else {
            i = i2;
        }
        String str3 = this.c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return i8 += i2;
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public String toString() {
        String str = this.a;
        final String str4 = this.b;
        final String str5 = this.c;
        StringBuilder stringBuilder = new StringBuilder(i2 += length3);
        stringBuilder.append(str);
        stringBuilder.append(": description=");
        stringBuilder.append(str4);
        stringBuilder.append(": value=");
        stringBuilder.append(str5);
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void w(n1.b n1$b) {
        boolean valueOf;
        int i2;
        String valueOf2;
        int length;
        int i;
        valueOf = this.a;
        valueOf.hashCode();
        length = 4;
        final int i4 = 3;
        final int i5 = 0;
        final int i7 = 2;
        final int i8 = 1;
        i = -1;
        switch (valueOf) {
            case "TAL":
                i = i5;
                break;
            case "TCM":
                i = i8;
                break;
            case "TDA":
                i = i7;
                break;
            case "TP1":
                i = i4;
                break;
            case "TP2":
                i = length;
                break;
            case "TP3":
                i = 5;
                break;
            case "TRK":
                i = 6;
                break;
            case "TT2":
                i = 7;
                break;
            case "TXT":
                i = 8;
                break;
            case "TYE":
                i = 9;
                break;
            case "TALB":
                i = 10;
                break;
            case "TCOM":
                i = 11;
                break;
            case "TDAT":
                i = 12;
                break;
            case "TDRC":
                i = 13;
                break;
            case "TDRL":
                i = 14;
                break;
            case "TEXT":
                i = 15;
                break;
            case "TIT2":
                i = 16;
                break;
            case "TPE1":
                i = 17;
                break;
            case "TPE2":
                i = 18;
                break;
            case "TPE3":
                i = 19;
                break;
            case "TRCK":
                i = 20;
                break;
            case "TYER":
                i = 21;
                break;
            default:
        }
        switch (i) {
            case 0:
                b.K(this.c);
                break;
            case 1:
                b.M(this.c);
                break;
            case 2:
                b.P(Integer.valueOf(Integer.parseInt(this.c.substring(i7, length))));
                b.O(Integer.valueOf(Integer.parseInt(this.c.substring(i5, i7))));
                break;
            case 3:
                b.L(this.c);
                break;
            case 4:
                b.J(this.c);
                break;
            case 5:
                b.N(this.c);
                break;
            case 6:
                String[] strArr = p0.C0(this.c, "/");
                valueOf = Integer.valueOf(Integer.parseInt(strArr[i8]));
                valueOf = 0;
                b.W(Integer.valueOf(Integer.parseInt(strArr[i5])));
                b.V(valueOf);
                break;
            case 7:
                b.U(this.c);
                break;
            case 8:
                b.X(this.c);
                break;
            case 9:
                b.Q(Integer.valueOf(Integer.parseInt(this.c)));
                break;
            case 10:
                valueOf = m.a(this.c);
                valueOf2 = valueOf.size();
                b.O((Integer)valueOf.get(i7));
                b.P((Integer)valueOf.get(i8));
                b.Q((Integer)valueOf.get(i5));
                break;
            case 11:
                valueOf = m.a(this.c);
                valueOf2 = valueOf.size();
                b.R((Integer)valueOf.get(i7));
                b.S((Integer)valueOf.get(i8));
                b.T((Integer)valueOf.get(i5));
                break;
            default:
        }
    }

    @Override // com.google.android.exoplayer2.m2.k.i
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
