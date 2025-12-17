package androidx.core.os;

import android.os.Parcel;

/* loaded from: classes5.dex */
@Deprecated
public interface ParcelableCompatCreatorCallbacks<T>  {
    public abstract T createFromParcel(Parcel parcel, java.lang.ClassLoader classLoader2);

    public abstract T[] newArray(int i);
}
