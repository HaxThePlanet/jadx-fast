package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.firestore.util.Preconditions;
import java.util.Date;

/* loaded from: classes2.dex */
public final class Timestamp implements Comparable<com.google.firebase.Timestamp>, Parcelable {

    public static final Parcelable.Creator<com.google.firebase.Timestamp> CREATOR;
    private final int nanoseconds;
    private final long seconds;
    static {
        Timestamp.1 anon = new Timestamp.1();
        Timestamp.CREATOR = anon;
    }

    public Timestamp(long l, int i2) {
        super();
        Timestamp.validateRange(l, i2);
        this.seconds = l;
        this.nanoseconds = obj3;
    }

    protected Timestamp(Parcel parcel) {
        super();
        this.seconds = parcel.readLong();
        this.nanoseconds = parcel.readInt();
    }

    public Timestamp(Date date) {
        int i;
        int i2;
        int obj7;
        super();
        long time = date.getTime();
        final int i5 = 1000;
        obj7 *= i;
        if (obj7 < 0) {
            i2 -= i4;
            obj7 += i;
        }
        Timestamp.validateRange(i2, obj5);
        this.seconds = i2;
        this.nanoseconds = obj7;
    }

    public static com.google.firebase.Timestamp now() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date);
        return timestamp;
    }

    private static void validateRange(long l, int i2) {
        int i;
        int i3;
        int obj9;
        int i4 = 1;
        final int i5 = 0;
        i = obj9 >= 0 ? i4 : i5;
        Object[] arr3 = new Object[i4];
        arr3[i5] = Integer.valueOf(obj9);
        String str2 = "Timestamp nanoseconds out of range: %s";
        Preconditions.checkArgument(i, str2, arr3);
        i3 = Double.compare(d, l4) < 0 ? i4 : i5;
        Object[] arr4 = new Object[i4];
        arr4[i5] = Integer.valueOf(obj9);
        Preconditions.checkArgument(i3, str2, arr4);
        obj9 = Long.compare(l, l2) >= 0 ? i4 : i5;
        Object[] arr2 = new Object[i4];
        arr2[i5] = Long.valueOf(l);
        String str = "Timestamp seconds out of range: %s";
        Preconditions.checkArgument(obj9, str, arr2);
        obj9 = Long.compare(l, l3) < 0 ? i4 : i5;
        Object[] arr = new Object[i4];
        arr[i5] = Long.valueOf(l);
        Preconditions.checkArgument(obj9, str, arr);
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.Timestamp timestamp) {
        long seconds = this.seconds;
        final long seconds2 = timestamp.seconds;
        if (Long.compare(seconds, seconds2) == 0) {
            return Integer.signum(nanoseconds -= obj6);
        }
        return Long.signum(seconds -= seconds2);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((Timestamp)object);
    }

    @Override // java.lang.Comparable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof Timestamp) {
            return i2;
        }
        if (compareTo((Timestamp)object) == 0) {
        } else {
            i = i2;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int getNanoseconds() {
        return this.nanoseconds;
    }

    @Override // java.lang.Comparable
    public long getSeconds() {
        return this.seconds;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        long seconds = this.seconds;
        return i7 += nanoseconds;
    }

    @Override // java.lang.Comparable
    public Date toDate() {
        Date date = new Date(i += l, obj2);
        return date;
    }

    @Override // java.lang.Comparable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timestamp(seconds=");
        stringBuilder.append(this.seconds);
        stringBuilder.append(", nanoseconds=");
        stringBuilder.append(this.nanoseconds);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // java.lang.Comparable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.seconds);
        parcel.writeInt(this.nanoseconds);
    }
}
