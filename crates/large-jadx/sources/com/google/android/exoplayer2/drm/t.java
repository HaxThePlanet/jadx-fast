package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.w0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class t implements Comparator<com.google.android.exoplayer2.drm.t.b>, Parcelable {

    public static final Parcelable.Creator<com.google.android.exoplayer2.drm.t> CREATOR;
    private final com.google.android.exoplayer2.drm.t.b[] a;
    private int b;
    public final String c;
    public final int v;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.drm.t> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.drm.t a(Parcel parcel) {
            t tVar = new t(parcel);
            return tVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.drm.t[] b(int i) {
            return new t[i];
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

    public static final class b implements Parcelable {

        public static final Parcelable.Creator<com.google.android.exoplayer2.drm.t.b> CREATOR;
        private int a;
        public final UUID b;
        public final String c;
        public final String v;
        public final byte[] w;
        static {
            t.b.a aVar = new t.b.a();
            t.b.CREATOR = aVar;
        }

        b(Parcel parcel) {
            super();
            UUID uuid = new UUID(parcel.readLong(), obj2, parcel.readLong(), obj4);
            this.b = uuid;
            this.c = parcel.readString();
            String string2 = parcel.readString();
            p0.i(string2);
            this.v = (String)string2;
            this.w = parcel.createByteArray();
        }

        public b(UUID uUID, String string2, String string3, byte[] b4Arr4) {
            super();
            g.e(uUID);
            this.b = (UUID)uUID;
            this.c = string2;
            g.e(string3);
            this.v = (String)string3;
            this.w = b4Arr4;
        }

        public b(UUID uUID, String string2, byte[] b3Arr3) {
            super(uUID, 0, string2, b3Arr3);
        }

        @Override // android.os.Parcelable
        public com.google.android.exoplayer2.drm.t.b a(byte[] bArr) {
            t.b bVar = new t.b(this.b, this.c, this.v, bArr);
            return bVar;
        }

        @Override // android.os.Parcelable
        public boolean b() {
            int i;
            i = this.w != null ? 1 : 0;
            return i;
        }

        @Override // android.os.Parcelable
        public boolean c(UUID uUID) {
            UUID equals;
            int obj3;
            if (!w0.a.equals(this.b)) {
                if (uUID.equals(this.b)) {
                    obj3 = 1;
                } else {
                    obj3 = 0;
                }
            } else {
            }
            return obj3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            int i;
            boolean z;
            Object str;
            Object obj5;
            if (!object instanceof t.b) {
                return 0;
            }
            int i2 = 1;
            if (object == this) {
                return i2;
            }
            if (p0.b(this.c, object.c) && p0.b(this.v, object.v) && p0.b(this.b, object.b) && Arrays.equals(this.w, object.w)) {
                if (p0.b(this.v, object.v)) {
                    if (p0.b(this.b, object.b)) {
                        if (Arrays.equals(this.w, object.w)) {
                            i = i2;
                        }
                    }
                }
            }
            return i;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i2;
            int i3;
            int i;
            if (this.a == 0) {
                String str = this.c;
                if (str == null) {
                    i3 = 0;
                } else {
                    i3 = str.hashCode();
                }
                this.a = i9 += i;
            }
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.b.getMostSignificantBits());
            parcel.writeLong(this.b.getLeastSignificantBits());
            parcel.writeString(this.c);
            parcel.writeString(this.v);
            parcel.writeByteArray(this.w);
        }
    }
    static {
        t.a aVar = new t.a();
        t.CREATOR = aVar;
    }

    t(Parcel parcel) {
        super();
        this.c = parcel.readString();
        Object[] obj2 = parcel.createTypedArray(t.b.CREATOR);
        p0.i((t.b[])obj2);
        this.a = (t.b[])obj2;
        this.v = obj2.length;
    }

    public t(String string, List<com.google.android.exoplayer2.drm.t.b> list2) {
        final int i = 0;
        super(string, i, (t.b[])list2.toArray(new t.b[i]));
    }

    private t(String string, boolean z2, com.google.android.exoplayer2.drm.t.b... t$b3Arr3) {
        Object obj1;
        Object obj3;
        super();
        this.c = string;
        if (z2) {
            obj3 = obj1;
        }
        this.a = obj3;
        this.v = obj3.length;
        Arrays.sort(obj3, this);
    }

    public t(String string, com.google.android.exoplayer2.drm.t.b... t$b2Arr2) {
        super(string, 1, b2Arr2);
    }

    public t(List<com.google.android.exoplayer2.drm.t.b> list) {
        final int i = 0;
        super(0, i, (t.b[])list.toArray(new t.b[i]));
    }

    private static boolean b(ArrayList<com.google.android.exoplayer2.drm.t.b> arrayList, int i2, UUID uUID3) {
        int i;
        boolean equals;
        final int i3 = 0;
        i = i3;
        while (i < i2) {
            i++;
        }
        return i3;
    }

    public static com.google.android.exoplayer2.drm.t d(com.google.android.exoplayer2.drm.t t, com.google.android.exoplayer2.drm.t t2) {
        int i2;
        int tVar;
        int i;
        int length;
        int i3;
        com.google.android.exoplayer2.drm.t.b bVar;
        boolean z;
        Object obj8;
        Object obj9;
        ArrayList arrayList = new ArrayList();
        if (t != null) {
            i = t.c;
            obj8 = t.a;
            i3 = i2;
            while (i3 < obj8.length) {
                bVar = obj8[i3];
                if (bVar.b()) {
                }
                i3++;
                arrayList.add(bVar);
            }
        } else {
            i = tVar;
        }
        if (t2 != null && i == 0) {
            if (i == 0) {
                i = obj8;
            }
            obj9 = t2.a;
            while (i2 < obj9.length) {
                i3 = obj9[i2];
                if (i3.b() && !t.b(arrayList, arrayList.size(), i3.b)) {
                }
                i2++;
                if (!t.b(arrayList, obj8, i3.b)) {
                }
                arrayList.add(i3);
            }
        }
        if (arrayList.isEmpty()) {
        } else {
            tVar = new t(i, arrayList);
        }
        return tVar;
    }

    @Override // java.util.Comparator
    public int a(com.google.android.exoplayer2.drm.t.b t$b, com.google.android.exoplayer2.drm.t.b t$b2) {
        int obj3;
        Object obj4;
        final UUID uuid = w0.a;
        if (uuid.equals(b.b)) {
            obj3 = uuid.equals(b2.b) ? 0 : 1;
        } else {
            obj3 = b.b.compareTo(b2.b);
        }
        return obj3;
    }

    @Override // java.util.Comparator
    public com.google.android.exoplayer2.drm.t c(String string) {
        if (p0.b(this.c, string)) {
            return this;
        }
        t tVar = new t(string, 0, this.a);
        return tVar;
    }

    @Override // java.util.Comparator
    public int compare(Object object, Object object2) {
        return a((t.b)object, (t.b)object2);
    }

    @Override // java.util.Comparator
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public com.google.android.exoplayer2.drm.t.b e(int i) {
        return this.a[i];
    }

    @Override // java.util.Comparator
    public boolean equals(Object object) {
        int i;
        com.google.android.exoplayer2.drm.t.b[] z;
        Class<com.google.android.exoplayer2.drm.t> obj;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (t.class != object.getClass()) {
            } else {
                if (p0.b(this.c, object.c) && Arrays.equals(this.a, object.a)) {
                    if (Arrays.equals(this.a, object.a)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // java.util.Comparator
    public com.google.android.exoplayer2.drm.t f(com.google.android.exoplayer2.drm.t t) {
        int i;
        String str2;
        String equals;
        String str;
        equals = this.c;
        str = t.c;
        if (equals != null && str != null) {
            str = t.c;
            if (str != null) {
                if (TextUtils.equals(equals, str)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        g.f(i);
        if (this.c != null) {
        } else {
            str2 = t.c;
        }
        t tVar = new t(str2, (t.b[])p0.r0(this.a, t.a));
        return tVar;
    }

    @Override // java.util.Comparator
    public int hashCode() {
        int i2;
        int i;
        int i3;
        if (this.b == 0) {
            String str = this.c;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            this.b = i4 += i3;
        }
        return this.b;
    }

    @Override // java.util.Comparator
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.c);
        parcel.writeTypedArray(this.a, 0);
    }
}
