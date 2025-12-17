package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

/* loaded from: classes2.dex */
public class f extends SparseArray<Parcelable> implements Parcelable {

    public static final Parcelable.Creator<com.google.android.material.internal.f> CREATOR;

    static class a implements Parcelable.ClassLoaderCreator<com.google.android.material.internal.f> {
        @Override // android.os.Parcelable$ClassLoaderCreator
        public com.google.android.material.internal.f a(Parcel parcel) {
            f fVar = new f(parcel, 0);
            return fVar;
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public com.google.android.material.internal.f b(Parcel parcel, java.lang.ClassLoader classLoader2) {
            f fVar = new f(parcel, classLoader2);
            return fVar;
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public com.google.android.material.internal.f[] c(int i) {
            return new f[i];
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public Object createFromParcel(Parcel parcel, java.lang.ClassLoader classLoader2) {
            return b(parcel, classLoader2);
        }

        @Override // android.os.Parcelable$ClassLoaderCreator
        public Object[] newArray(int i) {
            return c(i);
        }
    }
    static {
        f.a aVar = new f.a();
        f.CREATOR = aVar;
    }

    public f(Parcel parcel, java.lang.ClassLoader classLoader2) {
        int i;
        Parcelable parcelable;
        int obj6;
        super();
        final int int = parcel.readInt();
        final int[] iArr = new int[int];
        parcel.readIntArray(iArr);
        obj6 = 0;
        while (obj6 < int) {
            put(iArr[obj6], parcel.readParcelableArray(classLoader2)[obj6]);
            obj6++;
        }
    }

    @Override // android.util.SparseArray
    public int describeContents() {
        return 0;
    }

    @Override // android.util.SparseArray
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        Object valueAt;
        final int size = size();
        final int[] iArr = new int[size];
        final Parcelable[] arr = new Parcelable[size];
        i = 0;
        while (i < size) {
            iArr[i] = keyAt(i);
            arr[i] = (Parcelable)valueAt(i);
            i++;
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(arr, i2);
    }
}
