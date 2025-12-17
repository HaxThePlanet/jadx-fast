package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.ReplaceWith;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class BundleCompat {

    static class Api33Impl {
        static <T> T getParcelable(Bundle in, String key, Class<T> class3) {
            return in.getParcelable(key, class3);
        }

        static <T> T[] getParcelableArray(Bundle in, String key, Class<T> class3) {
            return in.getParcelableArray(key, class3);
        }

        static <T> ArrayList<T> getParcelableArrayList(Bundle in, String key, Class<? extends T> class3) {
            return in.getParcelableArrayList(key, class3);
        }

        static <T extends java.io.Serializable> T getSerializable(Bundle in, String key, Class<T> class3) {
            return in.getSerializable(key, class3);
        }

        static <T> SparseArray<T> getSparseParcelableArray(Bundle in, String key, Class<? extends T> class3) {
            return in.getSparseParcelableArray(key, class3);
        }
    }
    @ReplaceWith(expression = "bundle.getBinder(key)")
    @Deprecated
    public static IBinder getBinder(Bundle bundle, String key) {
        return bundle.getBinder(key);
    }

    public static <T> T getParcelable(Bundle in, String key, Class<T> class3) {
        Parcelable parcelable;
        if (Build.VERSION.SDK_INT >= 34) {
            return BundleCompat.Api33Impl.getParcelable(in, key, class3);
        }
        Parcelable parcelable3 = in.getParcelable(key);
        parcelable = class3.isInstance(parcelable3) ? parcelable3 : 0;
        return parcelable;
    }

    public static Parcelable[] getParcelableArray(Bundle in, String key, Class<? extends Parcelable> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[])BundleCompat.Api33Impl.getParcelableArray(in, key, class3);
        }
        return in.getParcelableArray(key);
    }

    public static <T> ArrayList<T> getParcelableArrayList(Bundle in, String key, Class<? extends T> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return BundleCompat.Api33Impl.getParcelableArrayList(in, key, class3);
        }
        return in.getParcelableArrayList(key);
    }

    public static <T extends java.io.Serializable> T getSerializable(Bundle in, String key, Class<T> class3) {
        java.io.Serializable serializable;
        if (Build.VERSION.SDK_INT >= 34) {
            return BundleCompat.Api33Impl.getSerializable(in, key, class3);
        }
        java.io.Serializable serializable3 = in.getSerializable(key);
        serializable = class3.isInstance(serializable3) ? serializable3 : 0;
        return serializable;
    }

    public static <T> SparseArray<T> getSparseParcelableArray(Bundle in, String key, Class<? extends T> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return BundleCompat.Api33Impl.getSparseParcelableArray(in, key, class3);
        }
        return in.getSparseParcelableArray(key);
    }

    @ReplaceWith(expression = "bundle.putBinder(key, binder)")
    @Deprecated
    public static void putBinder(Bundle bundle, String key, IBinder binder) {
        bundle.putBinder(key, binder);
    }
}
