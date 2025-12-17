package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.exoplayer2.m2.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class r implements a.b {

    public static final Parcelable.Creator<com.google.android.exoplayer2.source.hls.r> CREATOR;
    public final String a;
    public final String b;
    public final List<com.google.android.exoplayer2.source.hls.r.b> c;

    class a implements Parcelable.Creator<com.google.android.exoplayer2.source.hls.r> {
        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.source.hls.r a(Parcel parcel) {
            r rVar = new r(parcel);
            return rVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.google.android.exoplayer2.source.hls.r[] b(int i) {
            return new r[i];
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

        public static final Parcelable.Creator<com.google.android.exoplayer2.source.hls.r.b> CREATOR;
        public final int a;
        public final int b;
        public final String c;
        public final String v;
        public final String w;
        public final String x;
        static {
            r.b.a aVar = new r.b.a();
            r.b.CREATOR = aVar;
        }

        public b(int i, int i2, String string3, String string4, String string5, String string6) {
            super();
            this.a = i;
            this.b = i2;
            this.c = string3;
            this.v = string4;
            this.w = string5;
            this.x = string6;
        }

        b(Parcel parcel) {
            super();
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.v = parcel.readString();
            this.w = parcel.readString();
            this.x = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            int i;
            int equals;
            Class<com.google.android.exoplayer2.source.hls.r.b> obj;
            int i2;
            Class class;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i3 = 0;
            if (object != null) {
                if (r.b.class != object.getClass()) {
                } else {
                    if (this.a == object.a && this.b == object.b && TextUtils.equals(this.c, object.c) && TextUtils.equals(this.v, object.v) && TextUtils.equals(this.w, object.w) && TextUtils.equals(this.x, object.x)) {
                        if (this.b == object.b) {
                            if (TextUtils.equals(this.c, object.c)) {
                                if (TextUtils.equals(this.v, object.v)) {
                                    if (TextUtils.equals(this.w, object.w)) {
                                        if (TextUtils.equals(this.x, object.x)) {
                                        } else {
                                            i = i3;
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
                }
                return i;
            }
            return i3;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i3;
            int i2;
            int i4;
            int i;
            String str = this.c;
            i = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = i;
            }
            String str2 = this.v;
            if (str2 != null) {
                i2 = str2.hashCode();
            } else {
                i2 = i;
            }
            String str3 = this.w;
            if (str3 != null) {
                i4 = str3.hashCode();
            } else {
                i4 = i;
            }
            String str4 = this.x;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return i14 += i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.v);
            parcel.writeString(this.w);
            parcel.writeString(this.x);
        }
    }
    static {
        r.a aVar = new r.a();
        r.CREATOR = aVar;
    }

    r(Parcel parcel) {
        int i;
        Parcelable parcelable;
        super();
        this.a = parcel.readString();
        this.b = parcel.readString();
        int int = parcel.readInt();
        ArrayList arrayList = new ArrayList(int);
        i = 0;
        while (i < int) {
            arrayList.add((r.b)parcel.readParcelable(r.b.class.getClassLoader()));
            i++;
        }
        this.c = Collections.unmodifiableList(arrayList);
    }

    public r(String string, String string2, List<com.google.android.exoplayer2.source.hls.r.b> list3) {
        super();
        this.a = string;
        this.b = string2;
        ArrayList obj1 = new ArrayList(list3);
        this.c = Collections.unmodifiableList(obj1);
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public boolean equals(Object object) {
        int i;
        List equals;
        Class<com.google.android.exoplayer2.source.hls.r> obj;
        String str;
        Class class;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (r.class != object.getClass()) {
            } else {
                if (TextUtils.equals(this.a, object.a) && TextUtils.equals(this.b, object.b) && this.c.equals(object.c)) {
                    if (TextUtils.equals(this.b, object.b)) {
                        if (this.c.equals(object.c)) {
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

    @Override // com.google.android.exoplayer2.m2.a$b
    public int hashCode() {
        int i2;
        int i;
        String str = this.a;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = i;
        }
        final String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i5 += i7;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public String toString() {
        String string;
        String string2;
        String str2;
        String str;
        StringBuilder stringBuilder;
        String str3 = this.a;
        if (str3 != null) {
            str2 = this.b;
            stringBuilder = new StringBuilder(i += length3);
            stringBuilder.append(" [");
            stringBuilder.append(str3);
            stringBuilder.append(", ");
            stringBuilder.append(str2);
            stringBuilder.append("]");
            string = stringBuilder.toString();
        } else {
            string = "";
        }
        String valueOf = String.valueOf(string);
        String str6 = "HlsTrackMetadataEntry";
        if (valueOf.length() != 0) {
            string2 = str6.concat(valueOf);
        } else {
            string2 = new String(str6);
        }
        return string2;
    }

    @Override // com.google.android.exoplayer2.m2.a$b
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        Object obj;
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        int obj5 = this.c.size();
        parcel.writeInt(obj5);
        final int i3 = 0;
        i = i3;
        while (i < obj5) {
            parcel.writeParcelable((Parcelable)this.c.get(i), i3);
            i++;
        }
    }
}
