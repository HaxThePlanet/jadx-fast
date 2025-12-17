package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B7\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0010\nJ\u0010\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000c\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/saveable/SaveableStateRegistryImpl;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restored", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "", "valueProviders", "", "Lkotlin/Function0;", "value", "consumeRestored", "key", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SaveableStateRegistryImpl implements androidx.compose.runtime.saveable.SaveableStateRegistry {

    private final Function1<Object, Boolean> canBeSaved;
    private final Map<String, List<Object>> restored;
    private final Map<String, List<Function0<Object>>> valueProviders;
    public SaveableStateRegistryImpl(Map<String, ? extends List<? extends Object>> restored, Function1<Object, Boolean> canBeSaved) {
        Object linkedHashMap;
        super();
        this.canBeSaved = canBeSaved;
        if (restored != null) {
            if (MapsKt.toMutableMap(restored) == null) {
                linkedHashMap = new LinkedHashMap();
            }
        } else {
        }
        this.restored = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.valueProviders = (Map)linkedHashMap2;
    }

    public static final Map access$getValueProviders$p(androidx.compose.runtime.saveable.SaveableStateRegistryImpl $this) {
        return $this.valueProviders;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object value) {
        return (Boolean)this.canBeSaved.invoke(value).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String key) {
        boolean empty;
        int restored;
        int i;
        int subList;
        int size;
        Object remove = this.restored.remove(key);
        if (remove != null && !(Collection)(List)remove.isEmpty()) {
            if (!(Collection)remove.isEmpty()) {
                subList = 1;
                if (remove.size() > subList) {
                    this.restored.put(key, remove.subList(subList, remove.size()));
                }
                i = remove.get(0);
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public Map<String, List<Object>> performSave() {
        Object next;
        int i2;
        Object key;
        Object value;
        Object invoke2;
        int arrayListOf;
        int arrayList;
        int i3;
        int i;
        Object invoke;
        boolean beSaved;
        Map mutableMap = MapsKt.toMutableMap(this.restored);
        final int i4 = 0;
        Iterator iterator = this.valueProviders.entrySet().iterator();
        for (Map.Entry next : iterator) {
            i2 = 0;
            key = next.getKey();
            value = next.getValue();
            invoke2 = value.size();
            arrayList = new ArrayList(invoke2);
            while (arrayListOf < invoke2) {
                i = 0;
                invoke = (Function0)value.get(arrayListOf).invoke();
                arrayList.add(invoke);
                arrayListOf++;
            }
            mutableMap.put((String)key, (List)arrayList);
            i = 0;
            invoke = (Function0)value.get(arrayListOf).invoke();
            arrayList.add(invoke);
            arrayListOf++;
            invoke2 = (Function0)value.get(0).invoke();
            mutableMap.put(key, CollectionsKt.arrayListOf(/* result */));
        }
        return mutableMap;
    }

    public androidx.compose.runtime.saveable.SaveableStateRegistry.Entry registerProvider(String key, Function0<? extends Object> valueProvider) {
        int i;
        Object arrayList;
        if (SaveableStateRegistryKt.access$fastIsBlank((CharSequence)key)) {
        } else {
            Map valueProviders = this.valueProviders;
            int i3 = 0;
            final Object obj = valueProviders.get(key);
            if (obj == null) {
                i = 0;
                arrayList = new ArrayList();
                valueProviders.put(key, (List)arrayList);
            } else {
                arrayList = obj;
            }
            (List)arrayList.add(valueProvider);
            SaveableStateRegistryImpl.registerProvider.3 anon = new SaveableStateRegistryImpl.registerProvider.3(this, key, valueProvider);
            return (SaveableStateRegistry.Entry)anon;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireSaveableStateRegistryImpl$registerProvider$1 = new IllegalArgumentException("Registered key is empty or blank".toString());
        throw $i$a$RequireSaveableStateRegistryImpl$registerProvider$1;
    }
}
