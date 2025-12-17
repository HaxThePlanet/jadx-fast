package androidx.compose.ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\n\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\nH\u0000¨\u0006\u000b", d2 = {"areObjectsOfSameType", "", "a", "", "b", "classKeyForObject", "tryPopulateReflectively", "", "Landroidx/compose/ui/platform/InspectorInfo;", "element", "Landroidx/compose/ui/node/ModifierNodeElement;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Actual_jvmKt {
    public static final boolean areObjectsOfSameType(Object a, Object b) {
        int i;
        i = a.getClass() == b.getClass() ? 1 : 0;
        return i;
    }

    public static final Object classKeyForObject(Object a) {
        return a.getClass();
    }

    public static final void tryPopulateReflectively(InspectorInfo $this$tryPopulateReflectively, ModifierNodeElement<?> element) {
        int index$iv;
        Object obj;
        Object obj3;
        int i;
        Throwable assignableFrom;
        Class<ModifierNodeElement> name;
        Object obj2;
        int i2 = 0;
        Actual_jvmKt.tryPopulateReflectively$$inlined.sortedBy.1 anon = new Actual_jvmKt.tryPopulateReflectively$$inlined.sortedBy.1();
        List $this$sortedBy$iv = ArraysKt.sortedWith(element.getClass().getDeclaredFields(), (Comparator)anon);
        int i3 = 0;
        index$iv = 0;
        while (index$iv < $this$sortedBy$iv.size()) {
            obj3 = obj;
            i = 0;
            if (!(Field)obj3.getDeclaringClass().isAssignableFrom(ModifierNodeElement.class)) {
            }
            index$iv++;
            obj3.setAccessible(true);
            $this$tryPopulateReflectively.getProperties().set(obj3.getName(), obj3.get(element));
        }
    }
}
