package androidx.compose.ui.platform;

import android.os.Bundle;
import android.view.View;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.R.id;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0008\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002\u001a \u0010\u0011\u001a\u00020\u0012*\u0016\u0012\u0004\u0012\u00020\u000c\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00140\u0013H\u0002\u001a\"\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u000c\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0014\u0018\u00010\u0013*\u00020\u0012H\u0002\"\u001e\u0010\u0000\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0016", d2 = {"AcceptableClasses", "", "Ljava/lang/Class;", "", "[Ljava/lang/Class;", "DisposableSaveableStateRegistry", "Landroidx/compose/ui/platform/DisposableSaveableStateRegistry;", "view", "Landroid/view/View;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "id", "", "savedStateRegistryOwner", "canBeSavedToBundle", "", "value", "toBundle", "Landroid/os/Bundle;", "", "", "toMap", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DisposableSaveableStateRegistry_androidKt {

    private static final Class<? extends Object>[] AcceptableClasses;
    public static Bundle $r8$lambda$vXWQ89TxHQ24MnxQcigE5jRzS1E(SaveableStateRegistry saveableStateRegistry) {
        return DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry$lambda$0(saveableStateRegistry);
    }

    static {
        Class[] arr = new Class[7];
        DisposableSaveableStateRegistry_androidKt.AcceptableClasses = arr;
    }

    public static final androidx.compose.ui.platform.DisposableSaveableStateRegistry DisposableSaveableStateRegistry(View view, SavedStateRegistryOwner owner) {
        Object tag;
        Object valueOf;
        final android.view.ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        if (tag instanceof String != null) {
        } else {
            tag = 0;
        }
        if (tag == null) {
            valueOf = String.valueOf(parent.getId());
        } else {
            valueOf = tag;
        }
        return DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry(valueOf, owner);
    }

    public static final androidx.compose.ui.platform.DisposableSaveableStateRegistry DisposableSaveableStateRegistry(String id, SavedStateRegistryOwner savedStateRegistryOwner) {
        Map map;
        int i;
        int i2;
        StringBuilder stringBuilder = new StringBuilder();
        String string = stringBuilder.append(SaveableStateRegistry.class.getSimpleName()).append(':').append(id).toString();
        SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        final Bundle consumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(string);
        if (consumeRestoredStateForKey != null) {
            map = DisposableSaveableStateRegistry_androidKt.toMap(consumeRestoredStateForKey);
        } else {
            map = 0;
        }
        SaveableStateRegistry saveableStateRegistry = SaveableStateRegistryKt.SaveableStateRegistry(map, (Function1)DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry.saveableStateRegistry.1.INSTANCE);
        DisposableSaveableStateRegistry_androidKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new DisposableSaveableStateRegistry_androidKt$$ExternalSyntheticLambda0(saveableStateRegistry);
        savedStateRegistry.registerSavedStateProvider(string, externalSyntheticLambda0);
        i = 1;
        DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry.1 anon = new DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry.1(i, savedStateRegistry, string);
        DisposableSaveableStateRegistry disposableSaveableStateRegistry = new DisposableSaveableStateRegistry(saveableStateRegistry, (Function0)anon);
        return disposableSaveableStateRegistry;
    }

    private static final Bundle DisposableSaveableStateRegistry$lambda$0(SaveableStateRegistry $saveableStateRegistry) {
        return DisposableSaveableStateRegistry_androidKt.toBundle($saveableStateRegistry.performSave());
    }

    public static final boolean access$canBeSavedToBundle(Object value) {
        return DisposableSaveableStateRegistry_androidKt.canBeSavedToBundle(value);
    }

    private static final boolean canBeSavedToBundle(Object value) {
        androidx.compose.runtime.SnapshotMutationPolicy policy;
        boolean stateValue;
        int beSavedToBundle;
        androidx.compose.runtime.SnapshotMutationPolicy structuralEqualityPolicy;
        int i;
        Class cls;
        boolean instance;
        final int i2 = 0;
        if (value instanceof SnapshotMutableState && (SnapshotMutableState)value.getPolicy() != SnapshotStateKt.neverEqualPolicy() && (SnapshotMutableState)value.getPolicy() != SnapshotStateKt.structuralEqualityPolicy() && (SnapshotMutableState)value.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
            if ((SnapshotMutableState)value.getPolicy() != SnapshotStateKt.neverEqualPolicy()) {
                if ((SnapshotMutableState)value.getPolicy() != SnapshotStateKt.structuralEqualityPolicy()) {
                    if ((SnapshotMutableState)value.getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                    }
                    return i2;
                }
            }
            Object value2 = (SnapshotMutableState)value.getValue();
            if (value2 == null) {
            } else {
                beSavedToBundle = DisposableSaveableStateRegistry_androidKt.canBeSavedToBundle(value2);
            }
            return beSavedToBundle;
        }
        if (value instanceof Function && value instanceof Serializable) {
            if (value instanceof Serializable) {
                return i2;
            }
        }
        Class[] acceptableClasses = DisposableSaveableStateRegistry_androidKt.AcceptableClasses;
        i = i2;
        while (i < acceptableClasses.length) {
            i++;
        }
        return i2;
    }

    private static final Bundle toBundle(Map<String, ? extends List<? extends Object>> $this$toBundle) {
        Object next;
        int i;
        Object key;
        Object value;
        Object arrayList;
        Object obj;
        Bundle bundle = new Bundle();
        final int i2 = 0;
        Iterator iterator = $this$toBundle.entrySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            i = 0;
            value = next.getValue();
            if (value instanceof ArrayList != null) {
            } else {
            }
            arrayList = new ArrayList((Collection)(List)value);
            bundle.putParcelableArrayList((String)(Map.Entry)next.getKey(), arrayList);
            arrayList = value;
        }
        return bundle;
    }

    private static final Map<String, List<Object>> toMap(Bundle $this$toMap) {
        Object next;
        Object obj;
        int i;
        ArrayList parcelableArrayList;
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final int i2 = 0;
        final Iterator iterator = (Iterable)$this$toMap.keySet().iterator();
        for (Object next : iterator) {
            obj = next;
            i = 0;
            parcelableArrayList = $this$toMap.getParcelableArrayList((String)obj);
            Intrinsics.checkNotNull(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
            (Map)linkedHashMap.put(obj, parcelableArrayList);
        }
        return linkedHashMap;
    }
}
