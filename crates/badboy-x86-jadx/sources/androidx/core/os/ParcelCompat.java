package androidx.core.os;

import android.os.BadParcelableException;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class ParcelCompat {

    static class Api29Impl {
        static <T extends Parcelable> List<T> readParcelableList(Parcel in, List<T> list2, java.lang.ClassLoader cl) {
            return in.readParcelableList(list2, cl);
        }

        static void writeBoolean(Parcel parcel, boolean val) {
            parcel.writeBoolean(val);
        }
    }

    static class Api30Impl {
        static Parcelable.Creator<?> readParcelableCreator(Parcel in, java.lang.ClassLoader loader) {
            return in.readParcelableCreator(loader);
        }
    }

    static class Api33Impl {
        static <T> T[] readArray(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
            return in.readArray(loader, class3);
        }

        static <T> ArrayList<T> readArrayList(Parcel in, java.lang.ClassLoader loader, Class<? extends T> class3) {
            return in.readArrayList(loader, class3);
        }

        static <V, K> HashMap<K, V> readHashMap(Parcel in, java.lang.ClassLoader loader, Class<? extends K> class3, Class<? extends V> class4) {
            return in.readHashMap(loader, class3, class4);
        }

        static <T> void readList(Parcel in, List<? super T> list2, java.lang.ClassLoader loader, Class<T> class4) {
            in.readList(list2, loader, class4);
        }

        static <K, V> void readMap(Parcel in, Map<? super K, ? super V> map2, java.lang.ClassLoader loader, Class<K> class4, Class<V> class5) {
            in.readMap(map2, loader, class4, class5);
        }

        static <T extends Parcelable> T readParcelable(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
            return (Parcelable)in.readParcelable(loader, class3);
        }

        static <T> T[] readParcelableArray(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
            return in.readParcelableArray(loader, class3);
        }

        static <T> Parcelable.Creator<T> readParcelableCreator(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
            return in.readParcelableCreator(loader, class3);
        }

        static <T> List<T> readParcelableList(Parcel in, List<T> list2, java.lang.ClassLoader cl, Class<T> class4) {
            return in.readParcelableList(list2, cl, class4);
        }

        static <T extends java.io.Serializable> T readSerializable(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
            return (Serializable)in.readSerializable(loader, class3);
        }

        static <T> SparseArray<T> readSparseArray(Parcel in, java.lang.ClassLoader loader, Class<? extends T> class3) {
            return in.readSparseArray(loader, class3);
        }
    }
    public static <T> Object[] readArray(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ParcelCompat.Api33Impl.readArray(in, loader, class3);
        }
        return in.readArray(loader);
    }

    public static <T> ArrayList<T> readArrayList(Parcel in, java.lang.ClassLoader loader, Class<? extends T> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ParcelCompat.Api33Impl.readArrayList(in, loader, class3);
        }
        return in.readArrayList(loader);
    }

    public static boolean readBoolean(Parcel in) {
        int i;
        i = in.readInt() != 0 ? 1 : 0;
        return i;
    }

    public static <K, V> HashMap<K, V> readHashMap(Parcel in, java.lang.ClassLoader loader, Class<? extends K> class3, Class<? extends V> class4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ParcelCompat.Api33Impl.readHashMap(in, loader, class3, class4);
        }
        return in.readHashMap(loader);
    }

    public static <T> void readList(Parcel in, List<? super T> list2, java.lang.ClassLoader loader, Class<T> class4) {
        if (Build.VERSION.SDK_INT >= 34) {
            ParcelCompat.Api33Impl.readList(in, list2, loader, class4);
        } else {
            in.readList(list2, loader);
        }
    }

    public static <K, V> void readMap(Parcel in, Map<? super K, ? super V> map2, java.lang.ClassLoader loader, Class<K> class4, Class<V> class5) {
        if (Build.VERSION.SDK_INT >= 34) {
            ParcelCompat.Api33Impl.readMap(in, map2, loader, class4, class5);
        } else {
            in.readMap(map2, loader);
        }
    }

    public static <T extends Parcelable> T readParcelable(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
        int instance;
        if (Build.VERSION.SDK_INT >= 34) {
            return ParcelCompat.Api33Impl.readParcelable(in, loader, class3);
        }
        Parcelable parcelable2 = in.readParcelable(loader);
        if (parcelable2 != null) {
            if (!class3.isInstance(parcelable2)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            BadParcelableException badParcelableException = new BadParcelableException(stringBuilder.append("Parcelable ").append(parcelable2.getClass()).append(" is not a subclass of required class ").append(class3.getName()).append(" provided in the parameter").toString());
            throw badParcelableException;
        }
        return parcelable2;
    }

    @Deprecated
    public static <T> T[] readParcelableArray(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
        int i;
        Object cast;
        if (Build.VERSION.SDK_INT >= 34) {
            return ParcelCompat.Api33Impl.readParcelableArray(in, loader, class3);
        }
        Parcelable[] parcelableArray = in.readParcelableArray(loader);
        if (class3.isAssignableFrom(Parcelable.class)) {
            return (Object[])parcelableArray;
        }
        Object instance = Array.newInstance(class3, parcelableArray.length);
        i = 0;
        for (Object parcelable : obj0) {
            (Object[])instance[i] = class3.cast(parcelable);
        }
        return instance;
    }

    public static <T> Parcelable[] readParcelableArrayTyped(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[])ParcelCompat.Api33Impl.readParcelableArray(in, loader, class3);
        }
        return in.readParcelableArray(loader);
    }

    public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ParcelCompat.Api33Impl.readParcelableCreator(in, loader, class3);
        }
        return ParcelCompat.Api30Impl.readParcelableCreator(in, loader);
    }

    public static <T> List<T> readParcelableList(Parcel in, List<T> list2, java.lang.ClassLoader cl, Class<T> class4) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ParcelCompat.Api33Impl.readParcelableList(in, list2, cl, class4);
        }
        return ParcelCompat.Api29Impl.readParcelableList(in, list2, cl);
    }

    public static <T extends java.io.Serializable> T readSerializable(Parcel in, java.lang.ClassLoader loader, Class<T> class3) {
        if (Build.VERSION.SDK_INT >= 33) {
            return ParcelCompat.Api33Impl.readSerializable(in, loader, class3);
        }
        return in.readSerializable();
    }

    public static <T> SparseArray<T> readSparseArray(Parcel in, java.lang.ClassLoader loader, Class<? extends T> class3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return ParcelCompat.Api33Impl.readSparseArray(in, loader, class3);
        }
        return in.readSparseArray(loader);
    }

    public static void writeBoolean(Parcel out, boolean value) {
        ParcelCompat.Api29Impl.writeBoolean(out, value);
    }
}
