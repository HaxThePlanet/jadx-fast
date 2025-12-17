package zendesk.belvedere;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.File;

/* loaded from: classes3.dex */
public class s implements Parcelable, Comparable<zendesk.belvedere.s> {

    public static final Parcelable.Creator<zendesk.belvedere.s> CREATOR;
    private final File a;
    private final Uri b;
    private final Uri c;
    private final String v;
    private final String w;
    private final long x;
    private final long y;
    private final long z;

    static class a implements Parcelable.Creator<zendesk.belvedere.s> {
        @Override // android.os.Parcelable$Creator
        public zendesk.belvedere.s a(Parcel parcel) {
            s sVar = new s(parcel, 0);
            return sVar;
        }

        @Override // android.os.Parcelable$Creator
        public zendesk.belvedere.s[] b(int i) {
            return new s[i];
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
        s.a aVar = new s.a();
        s.CREATOR = aVar;
    }

    private s(Parcel parcel) {
        super();
        this.a = (File)parcel.readSerializable();
        this.b = (Uri)parcel.readParcelable(s.class.getClassLoader());
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.c = (Uri)parcel.readParcelable(s.class.getClassLoader());
        this.x = parcel.readLong();
        this.y = parcel.readLong();
        this.z = parcel.readLong();
    }

    s(Parcel parcel, zendesk.belvedere.s.a s$a2) {
        super(parcel);
    }

    public s(File file, Uri uri2, Uri uri3, String string4, String string5, long l6, long l7, long l8) {
        super();
        this.a = file;
        this.b = uri2;
        this.c = uri3;
        this.w = string5;
        this.v = string4;
        this.x = l6;
        this.y = l8;
        this.z = obj10;
    }

    static zendesk.belvedere.s c() {
        super(0, 0, 0, 0, 0, -1, obj7, -1, obj9, -1, obj11);
        return sVar2;
    }

    @Override // android.os.Parcelable
    public int a(zendesk.belvedere.s s) {
        return this.c.compareTo(s.k());
    }

    @Override // android.os.Parcelable
    public int compareTo(Object object) {
        return a((s)object);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public File e() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        boolean equals4;
        boolean equals;
        Uri equals2;
        boolean equals3;
        String equals5;
        int cmp;
        Object class;
        long l;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (s.class != object.getClass()) {
            } else {
                if (Long.compare(l2, l5) != 0) {
                    return i;
                }
                if (Long.compare(l3, l) == 0) {
                    if (Long.compare(l4, l) != 0) {
                    } else {
                        File file = this.a;
                        if (file != null) {
                            if (file.equals(object.a) == null) {
                                return i;
                            }
                        } else {
                            if (object.a != null) {
                            }
                        }
                        Uri uri = this.b;
                        if (uri != null) {
                            if (!uri.equals(object.b)) {
                                return i;
                            }
                        } else {
                            if (object.b != null) {
                            }
                        }
                        Uri uri2 = this.c;
                        if (uri2 != null) {
                            if (!uri2.equals(object.c)) {
                                return i;
                            }
                        } else {
                            if (object.c != null) {
                            }
                        }
                        String str = this.v;
                        if (str != null) {
                            if (!str.equals(object.v)) {
                                return i;
                            }
                        } else {
                            if (object.v != null) {
                            }
                        }
                        String str2 = this.w;
                        final String obj7 = object.w;
                        if (str2 != null) {
                            equals4 = str2.equals(obj7);
                        } else {
                            if (obj7 == null) {
                            } else {
                                equals4 = i;
                            }
                        }
                    }
                    return equals4;
                }
            }
        }
        return i;
    }

    @Override // android.os.Parcelable
    public long f() {
        return this.z;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i3;
        int i;
        int i5;
        int i2;
        int i4;
        File file = this.a;
        i = 0;
        if (file != null) {
            i3 = file.hashCode();
        } else {
            i3 = i;
        }
        Uri uri = this.b;
        if (uri != null) {
            i5 = uri.hashCode();
        } else {
            i5 = i;
        }
        Uri uri2 = this.c;
        if (uri2 != null) {
            i2 = uri2.hashCode();
        } else {
            i2 = i;
        }
        String str = this.v;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = i;
        }
        String str2 = this.w;
        if (str2 != null) {
            i = str2.hashCode();
        }
        long l = this.x;
        int i26 = 32;
        long l2 = this.y;
        long l3 = this.z;
        return i18 += i25;
    }

    @Override // android.os.Parcelable
    public String i() {
        return this.w;
    }

    @Override // android.os.Parcelable
    public String j() {
        return this.v;
    }

    @Override // android.os.Parcelable
    public Uri k() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public long m() {
        return this.x;
    }

    @Override // android.os.Parcelable
    public Uri n() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public long o() {
        return this.y;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSerializable(this.a);
        parcel.writeParcelable(this.b, i2);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeParcelable(this.c, i2);
        parcel.writeLong(this.x);
        parcel.writeLong(this.y);
        parcel.writeLong(this.z);
    }
}
