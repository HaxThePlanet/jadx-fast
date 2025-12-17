package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000c\u0010\u0013\u001a\u00060\u000bj\u0002`\u000cH\u0016J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\u000c2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0019", d2 = {"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V", "restored", "", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "viewModel", "Landroidx/lifecycle/SavedStateHandlesVM;", "getViewModel", "()Landroidx/lifecycle/SavedStateHandlesVM;", "viewModel$delegate", "Lkotlin/Lazy;", "saveState", "performRestore", "", "consumeRestoredStateForKey", "key", "", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {

    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final Lazy viewModel$delegate;
    public static androidx.lifecycle.SavedStateHandlesVM $r8$lambda$BWYiFNbmaxFqlGaoxfo2jDYwXi4(androidx.lifecycle.ViewModelStoreOwner viewModelStoreOwner) {
        return SavedStateHandlesProvider.viewModel_delegate$lambda$0(viewModelStoreOwner);
    }

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, androidx.lifecycle.ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        super();
        this.savedStateRegistry = savedStateRegistry;
        SavedStateHandlesProvider$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SavedStateHandlesProvider$$ExternalSyntheticLambda0(viewModelStoreOwner);
        this.viewModel$delegate = LazyKt.lazy(externalSyntheticLambda0);
    }

    private final androidx.lifecycle.SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM)this.viewModel$delegate.getValue();
    }

    private static final androidx.lifecycle.SavedStateHandlesVM viewModel_delegate$lambda$0(androidx.lifecycle.ViewModelStoreOwner $viewModelStoreOwner) {
        return SavedStateHandleSupport.getSavedStateHandlesVM($viewModelStoreOwner);
    }

    @Override // androidx.savedstate.SavedStateRegistry$SavedStateProvider
    public final Bundle consumeRestoredStateForKey(String key) {
        int $this$toTypedArray$iv$iv;
        Bundle bundle;
        Bundle initialState$iv;
        int i3;
        kotlin.Pair[] $i$f$toTypedArray;
        Bundle bundle2;
        int i2;
        int arr;
        Object arrayList;
        int i4;
        Bundle constructor-impl;
        int iterator;
        boolean next;
        int i;
        Object key2;
        final Object obj = this;
        final Object obj2 = key;
        Intrinsics.checkNotNullParameter(obj2, "key");
        obj.performRestore();
        Bundle restoredState = obj.restoredState;
        $this$toTypedArray$iv$iv = 0;
        if (restoredState == null) {
            return $this$toTypedArray$iv$iv;
        }
        int i7 = 0;
        int i11 = 0;
        if (!SavedStateReader.contains-impl(SavedStateReader.constructor-impl(restoredState), obj2)) {
            return $this$toTypedArray$iv$iv;
        }
        int i8 = 0;
        int i12 = 0;
        if (SavedStateReader.getSavedStateOrNull-impl(SavedStateReader.constructor-impl(restoredState), obj2) == null) {
            Map emptyMap = MapsKt.emptyMap();
            i3 = 0;
            if (emptyMap.isEmpty()) {
                $i$f$toTypedArray = new Pair[0];
            } else {
                Map map = emptyMap;
                int i14 = 0;
                arrayList = new ArrayList(map.size());
                constructor-impl = 0;
                iterator = map.entrySet().iterator();
                for (Map.Entry next : iterator) {
                    i = 0;
                    (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
                    $this$toTypedArray$iv$iv = 0;
                    i2 = 0;
                }
                int i13 = 0;
                $i$f$toTypedArray = $this$toTypedArray$iv$iv;
            }
            $this$toTypedArray$iv$iv = BundleKt.bundleOf((Pair[])Arrays.copyOf($i$f$toTypedArray, $i$f$toTypedArray.length));
            arr = 0;
            i4 = 0;
            constructor-impl = SavedStateWriter.constructor-impl($this$toTypedArray$iv$iv);
            iterator = 0;
            initialState$iv = $this$toTypedArray$iv$iv;
        }
        bundle = restoredState;
        int i5 = 0;
        int i9 = 0;
        SavedStateWriter.remove-impl(SavedStateWriter.constructor-impl(bundle), obj2);
        int i6 = 0;
        int i10 = 0;
        if (SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(bundle))) {
            obj.restoredState = 0;
        }
        return initialState$iv;
    }

    @Override // androidx.savedstate.SavedStateRegistry$SavedStateProvider
    public final void performRestore() {
        boolean consumeRestoredStateForKey;
        int i;
        int i3;
        Object[] $i$f$toTypedArray;
        kotlin.Pair[] arr;
        Bundle bundleOf;
        ArrayList list;
        ArrayList arrayList;
        Map map;
        int i2;
        Iterator constructor-impl;
        boolean next;
        kotlin.Pair $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1$iv;
        Object key;
        Object value;
        if (!this.restored) {
            consumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Map emptyMap = MapsKt.emptyMap();
            i3 = 0;
            arr = 0;
            if (emptyMap.isEmpty()) {
                $i$f$toTypedArray = new Pair[arr];
            } else {
                Map map2 = emptyMap;
                int i5 = 0;
                arrayList = new ArrayList(map2.size());
                i2 = 0;
                constructor-impl = map2.entrySet().iterator();
                for (Map.Entry next : constructor-impl) {
                    int i6 = 0;
                    (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
                }
                int i4 = 0;
                $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Pair[arr]);
            }
            bundleOf = BundleKt.bundleOf((Pair[])Arrays.copyOf($i$f$toTypedArray, $i$f$toTypedArray.length));
            arrayList = 0;
            i2 = 0;
            constructor-impl = SavedStateWriter.constructor-impl(bundleOf);
            next = 0;
            $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1$iv = this.restoredState;
            if ($i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1$iv != null) {
                key = 0;
                SavedStateWriter.putAll-impl(constructor-impl, $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1$iv);
            }
            if (consumeRestoredStateForKey != null) {
                key = 0;
                SavedStateWriter.putAll-impl(constructor-impl, consumeRestoredStateForKey);
            }
            this.restoredState = bundleOf;
            this.restored = true;
            getViewModel();
        }
    }

    @Override // androidx.savedstate.SavedStateRegistry$SavedStateProvider
    public Bundle saveState() {
        Map emptyMap;
        Object[] $i$f$toTypedArray;
        int i5;
        ArrayList list;
        ArrayList arrayList;
        kotlin.Pair[] arr;
        int i4;
        Iterator iterator;
        boolean next;
        kotlin.Pair $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1$iv;
        Object key;
        Object value;
        Object next2;
        int i3;
        Object value2;
        Bundle bundle;
        Map map;
        int i2;
        Bundle constructor-impl;
        int i;
        boolean empty-impl;
        final Object obj = this;
        emptyMap = MapsKt.emptyMap();
        final int i6 = 0;
        i5 = 0;
        if (emptyMap.isEmpty()) {
            $i$f$toTypedArray = new Pair[i5];
        } else {
            Map map2 = emptyMap;
            int i8 = 0;
            arrayList = new ArrayList(map2.size());
            i4 = 0;
            iterator = map2.entrySet().iterator();
            for (Map.Entry next : iterator) {
                int i12 = 0;
                (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
            }
            int i7 = 0;
            $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Pair[i5]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[])Arrays.copyOf($i$f$toTypedArray, $i$f$toTypedArray.length));
        int i9 = 0;
        int i10 = 0;
        Bundle constructor-impl2 = SavedStateWriter.constructor-impl(bundleOf);
        int i11 = 0;
        Bundle restoredState = obj.restoredState;
        if (restoredState != null) {
            value = 0;
            SavedStateWriter.putAll-impl(constructor-impl2, restoredState);
        }
        int i13 = 0;
        Iterator iterator2 = obj.getViewModel().getHandles().entrySet().iterator();
        while (iterator2.hasNext()) {
            next2 = iterator2.next();
            i3 = 0;
            Bundle state = (SavedStateHandle)next2.getValue().savedStateProvider().saveState();
            i2 = 0;
            i = 0;
            if (!SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(state))) {
            }
            emptyMap = map;
            i5 = 0;
            SavedStateWriter.putSavedState-impl(constructor-impl2, (String)(Map.Entry)next2.getKey(), state);
        }
        Map initialState$iv2 = emptyMap;
        obj.restored = false;
        return bundleOf;
    }
}
