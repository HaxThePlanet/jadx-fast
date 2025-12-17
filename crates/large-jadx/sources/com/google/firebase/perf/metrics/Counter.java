package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class Counter implements Parcelable {

    public static final Parcelable.Creator<com.google.firebase.perf.metrics.Counter> CREATOR;
    private final AtomicLong count;
    private final String name;
    static {
        Counter.1 anon = new Counter.1();
        Counter.CREATOR = anon;
    }

    private Counter(Parcel parcel) {
        super();
        this.name = parcel.readString();
        AtomicLong atomicLong = new AtomicLong(parcel.readLong(), obj2);
        this.count = atomicLong;
    }

    Counter(Parcel parcel, com.google.firebase.perf.metrics.Counter.1 counter$12) {
        super(parcel);
    }

    public Counter(String string) {
        super();
        this.name = string;
        AtomicLong obj3 = new AtomicLong(0, obj1);
        this.count = obj3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    long getCount() {
        return this.count.get();
    }

    @Override // android.os.Parcelable
    String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void increment(long l) {
        this.count.addAndGet(l);
    }

    @Override // android.os.Parcelable
    void setCount(long l) {
        this.count.set(l);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeLong(this.count.get());
    }
}
