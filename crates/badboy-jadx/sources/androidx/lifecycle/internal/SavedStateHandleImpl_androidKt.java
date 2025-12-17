package androidx.lifecycle.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\"\u001c\u0010\u0004\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00030\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"isAcceptableType", "", "value", "", "ACCEPTABLE_CLASSES", "", "Ljava/lang/Class;", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandleImpl_androidKt {

    private static final List<Class<? extends Object>> ACCEPTABLE_CLASSES;
    static {
        Class[] arr = new Class[29];
        SavedStateHandleImpl_androidKt.ACCEPTABLE_CLASSES = ArraysKt.filterNotNull(Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class);
    }

    public static final boolean isAcceptableType(Object value) {
        int i3;
        int $this$any$iv;
        int i;
        boolean iterator;
        int i2;
        Object next;
        boolean classRef;
        int i4;
        if (value != null) {
            List aCCEPTABLE_CLASSES = SavedStateHandleImpl_androidKt.ACCEPTABLE_CLASSES;
            i = 0;
            i2 = 0;
            if (aCCEPTABLE_CLASSES instanceof Collection != null && (Collection)(Iterable)aCCEPTABLE_CLASSES.isEmpty()) {
                if ((Collection)aCCEPTABLE_CLASSES.isEmpty()) {
                    $this$any$iv = i2;
                } else {
                    iterator = aCCEPTABLE_CLASSES.iterator();
                    for (Object next : iterator) {
                        i4 = 0;
                    }
                    $this$any$iv = i2;
                }
            } else {
            }
            if ($this$any$iv != 0) {
            } else {
                i3 = i2;
            }
        }
        return i3;
    }
}
