package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Timer implements Parcelable {

    public static final Parcelable.Creator<com.google.firebase.perf.util.Timer> CREATOR;
    private long highResTime;
    private long timeInMicros;
    static {
        Timer.1 anon = new Timer.1();
        Timer.CREATOR = anon;
    }

    public Timer() {
        super();
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    public Timer(long l) {
        super();
        this.timeInMicros = l;
        this.highResTime = TimeUnit.MICROSECONDS.toNanos(l);
    }

    public Timer(long l, long l2) {
        super();
        this.timeInMicros = l;
        this.highResTime = obj3;
    }

    private Timer(Parcel parcel) {
        super();
        this.timeInMicros = parcel.readLong();
        this.highResTime = parcel.readLong();
    }

    Timer(Parcel parcel, com.google.firebase.perf.util.Timer.1 timer$12) {
        super(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public long getCurrentTimestampMicros() {
        return timeInMicros += durationMicros;
    }

    @Override // android.os.Parcelable
    public long getDurationMicros() {
        return TimeUnit.NANOSECONDS.toMicros(nanoTime -= highResTime);
    }

    @Override // android.os.Parcelable
    public long getDurationMicros(com.google.firebase.perf.util.Timer timer) {
        return TimeUnit.NANOSECONDS.toMicros(highResTime -= highResTime2);
    }

    @Override // android.os.Parcelable
    public long getHighResTime() {
        return TimeUnit.NANOSECONDS.toMicros(this.highResTime);
    }

    @Override // android.os.Parcelable
    public long getMicros() {
        return this.timeInMicros;
    }

    @Override // android.os.Parcelable
    public void reset() {
        this.timeInMicros = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.highResTime = System.nanoTime();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timeInMicros);
        parcel.writeLong(this.highResTime);
    }
}
