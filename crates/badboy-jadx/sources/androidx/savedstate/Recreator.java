package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/LifecycleEventObserver;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "reflectiveNew", "className", "", "SavedStateProvider", "Companion", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Recreator implements LifecycleEventObserver {

    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final androidx.savedstate.Recreator.Companion Companion;
    private final androidx.savedstate.SavedStateRegistryOwner owner;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/savedstate/Recreator$Companion;", "", "<init>", "()V", "CLASSES_KEY", "", "COMPONENT_KEY", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000c\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016J\u000e\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0008R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/savedstate/Recreator$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "<init>", "(Landroidx/savedstate/SavedStateRegistry;)V", "classes", "", "", "saveState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "add", "", "className", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavedStateProvider implements androidx.savedstate.SavedStateRegistry.SavedStateProvider {

        private final Set<String> classes;
        public SavedStateProvider(androidx.savedstate.SavedStateRegistry registry) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            super();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.classes = (Set)linkedHashSet;
            registry.registerSavedStateProvider("androidx.savedstate.Restarter", (SavedStateRegistry.SavedStateProvider)this);
        }

        @Override // androidx.savedstate.SavedStateRegistry$SavedStateProvider
        public final void add(String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            this.classes.add(className);
        }

        @Override // androidx.savedstate.SavedStateRegistry$SavedStateProvider
        public Bundle saveState() {
            kotlin.Pair[] $i$f$toTypedArray;
            int arr;
            ArrayList list;
            ArrayList arrayList;
            Map map;
            int i;
            Iterator iterator;
            boolean next;
            kotlin.Pair $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1$iv;
            Object key;
            Object value;
            final Map emptyMap = MapsKt.emptyMap();
            final int i2 = 0;
            arr = 0;
            if (emptyMap.isEmpty()) {
                $i$f$toTypedArray = new Pair[arr];
            } else {
                Map map2 = emptyMap;
                int i4 = 0;
                arrayList = new ArrayList(map2.size());
                i = 0;
                iterator = map2.entrySet().iterator();
                for (Map.Entry next : iterator) {
                    int i8 = 0;
                    (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
                }
                int i3 = 0;
                $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Pair[arr]);
            }
            Bundle bundleOf = BundleKt.bundleOf((Pair[])Arrays.copyOf($i$f$toTypedArray, $i$f$toTypedArray.length));
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            SavedStateWriter.putStringList-impl(SavedStateWriter.constructor-impl(bundleOf), "classes_to_restore", CollectionsKt.toList((Iterable)this.classes));
            return bundleOf;
        }
    }
    static {
        Recreator.Companion companion = new Recreator.Companion(0);
        Recreator.Companion = companion;
    }

    public Recreator(androidx.savedstate.SavedStateRegistryOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super();
        this.owner = owner;
    }

    private final void reflectiveNew(String className) {
        String str = "Class ";
        int i = 0;
        Class subclass = Class.forName(className, i, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
        Intrinsics.checkNotNull(subclass);
        Constructor declaredConstructor = subclass.getDeclaredConstructor(new Class[i]);
        declaredConstructor.setAccessible(true);
        Object instance = declaredConstructor.newInstance(new Object[i]);
        Intrinsics.checkNotNull(instance);
        (SavedStateRegistry.AutoRecreated)instance.onRecreated(this.owner);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        int next;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_CREATE) {
        } else {
            source.getLifecycle().removeObserver((LifecycleObserver)this);
            Bundle consumeRestoredStateForKey = this.owner.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
            if (consumeRestoredStateForKey == null) {
            }
            next = 0;
            final int i = 0;
            List stringListOrNull-impl = SavedStateReader.getStringListOrNull-impl(SavedStateReader.constructor-impl(consumeRestoredStateForKey), "classes_to_restore");
            if (stringListOrNull-impl == null) {
            } else {
                Iterator iterator = stringListOrNull-impl.iterator();
                for (String next : iterator) {
                    reflectiveNew(next);
                }
            }
            IllegalStateException classes = new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"".toString());
            throw classes;
        }
        AssertionError registry = new AssertionError("Next event must be ON_CREATE");
        throw registry;
    }
}
