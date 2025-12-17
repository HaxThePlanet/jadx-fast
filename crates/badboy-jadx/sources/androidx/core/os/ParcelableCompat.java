package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

/* loaded from: classes5.dex */
@Deprecated
public final class ParcelableCompat {

    static class ParcelableCompatCreatorHoneycombMR2 implements Parcelable.ClassLoaderCreator<T> {

        private final androidx.core.os.ParcelableCompatCreatorCallbacks<T> mCallbacks;
        ParcelableCompatCreatorHoneycombMR2(androidx.core.os.ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
            super();
            this.mCallbacks = parcelableCompatCreatorCallbacks;
        }

        public T createFromParcel(Parcel in) {
            return this.mCallbacks.createFromParcel(in, 0);
        }

        public T createFromParcel(Parcel in, java.lang.ClassLoader loader) {
            return this.mCallbacks.createFromParcel(in, loader);
        }

        public T[] newArray(int size) {
            return this.mCallbacks.newArray(size);
        }
    }
    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(androidx.core.os.ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        ParcelableCompat.ParcelableCompatCreatorHoneycombMR2 parcelableCompatCreatorHoneycombMR2 = new ParcelableCompat.ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
        return parcelableCompatCreatorHoneycombMR2;
    }
}
