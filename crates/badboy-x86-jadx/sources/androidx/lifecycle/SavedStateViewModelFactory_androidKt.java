package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0004\u001aI\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\t0\u0008\"\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001a6\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0006\"\u0004\u0008\u0000\u0010\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u00042\u0010\u0010\u000f\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00040\u000cH\u0000\"\u0018\u0010\u000b\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00040\u000cX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\r\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00040\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"newInstance", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "constructor", "Ljava/lang/reflect/Constructor;", "params", "", "", "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Landroidx/lifecycle/ViewModel;", "ANDROID_VIEWMODEL_SIGNATURE", "", "VIEWMODEL_SIGNATURE", "findMatchingConstructor", "signature", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateViewModelFactory_androidKt {

    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE;
    private static final List<Class<?>> VIEWMODEL_SIGNATURE;
    static {
        Class[] arr = new Class[2];
        SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE = CollectionsKt.listOf(Application.class, SavedStateHandle.class);
        SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE = CollectionsKt.listOf(SavedStateHandle.class);
    }

    public static final List access$getANDROID_VIEWMODEL_SIGNATURE$p() {
        return SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE;
    }

    public static final List access$getVIEWMODEL_SIGNATURE$p() {
        return SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE;
    }

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> modelClass, List<? extends Class<?>> signature) {
        Object next;
        List list;
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Iterator iterator = ArrayIteratorKt.iterator(modelClass.getConstructors());
        for (Constructor next : iterator) {
            Class[] parameterTypes = next.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
            list = ArraysKt.toList((Object[])parameterTypes);
        }
        return 0;
    }

    public static final <T extends androidx.lifecycle.ViewModel> T newInstance(Class<T> modelClass, Constructor<T> constructor, Object... params) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(params, "params");
        return (ViewModel)constructor.newInstance(Arrays.copyOf(params, params.length));
    }
}
