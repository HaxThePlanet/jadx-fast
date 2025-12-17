package app.dogo.com.dogo_android.exam;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "Landroid/os/Parcelable;", "dogId", "", "trickId", "programId", "trickDescription", "examTimeLimitSec", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDogId", "()Ljava/lang/String;", "getExamTimeLimitSec", "()J", "getProgramId", "getTrickDescription", "getTrickId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.exam.g> CREATOR;
    private final String a;
    private final String b;
    private final String c;
    private final String v;
    private final long w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.exam.g> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.exam.g a(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), obj7);
            return gVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.exam.g[] b(int i) {
            return new g[i];
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
        g.a aVar = new g.a();
        g.CREATOR = aVar;
    }

    public g(String string, String string2, String string3, String string4, long l5) {
        n.f(string, "dogId");
        n.f(string2, "trickId");
        n.f(string3, "programId");
        n.f(string4, "trickDescription");
        super();
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.v = string4;
        this.w = l5;
    }

    @Override // android.os.Parcelable
    public final String a() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public final long b() {
        return this.w;
    }

    @Override // android.os.Parcelable
    public final String c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final String d() {
        return this.v;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final String e() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof g) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        if (!n.b(this.v, object.v)) {
            return i2;
        }
        if (Long.compare(l, l2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i8 += i13;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExamUploadData(dogId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", trickId=");
        stringBuilder.append(this.b);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.c);
        stringBuilder.append(", trickDescription=");
        stringBuilder.append(this.v);
        stringBuilder.append(", examTimeLimitSec=");
        stringBuilder.append(this.w);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.v);
        parcel.writeLong(this.w);
    }
}
