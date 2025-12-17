package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0019\u0008\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001d\u0010\u001e\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00152\u0006\u0010\u001f\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0010H\u0007J\u0010\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001f\u001a\u00020\u000fJ\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000fH\u0007J\u0008\u0010%\u001a\u00020\u0006H\u0007J\u001f\u0010&\u001a\u00020\u00062\u000e\u0010'\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0001¢\u0006\u0004\u0008(\u0010)J\u001b\u0010*\u001a\u00020\u00062\n\u0010+\u001a\u00060\u0014j\u0002`\u0015H\u0001¢\u0006\u0004\u0008,\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00128G@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001b\u0010\u0019\"\u0004\u0008\u001c\u0010\u001d¨\u0006.", d2 = {"Landroidx/savedstate/internal/SavedStateRegistryImpl;", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "onAttach", "Lkotlin/Function0;", "", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;Lkotlin/jvm/functions/Function0;)V", "getOnAttach$savedstate_release", "()Lkotlin/jvm/functions/Function0;", "lock", "Landroidx/savedstate/internal/SynchronizedObject;", "keyToProviders", "", "", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "attached", "", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "Landroid/os/Bundle;", "value", "isRestored", "()Z", "isAllowingSavingState", "isAllowingSavingState$savedstate_release", "setAllowingSavingState$savedstate_release", "(Z)V", "consumeRestoredStateForKey", "key", "(Ljava/lang/String;)Landroid/os/Bundle;", "registerSavedStateProvider", "provider", "getSavedStateProvider", "unregisterSavedStateProvider", "performAttach", "performRestore", "savedState", "performRestore$savedstate_release", "(Landroid/os/Bundle;)V", "performSave", "outBundle", "performSave$savedstate_release", "Companion", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateRegistryImpl {

    private static final androidx.savedstate.internal.SavedStateRegistryImpl.Companion Companion = null;
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private boolean isAllowingSavingState;
    private boolean isRestored;
    private final Map<String, SavedStateRegistry.SavedStateProvider> keyToProviders;
    private final androidx.savedstate.internal.SynchronizedObject lock;
    private final Function0<Unit> onAttach;
    private final SavedStateRegistryOwner owner;
    private Bundle restoredState;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Landroidx/savedstate/internal/SavedStateRegistryImpl$Companion;", "", "<init>", "()V", "SAVED_COMPONENTS_KEY", "", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    public static void $r8$lambda$6xnOyEL_uTccN7fW0CY8JkIx-HI(androidx.savedstate.internal.SavedStateRegistryImpl savedStateRegistryImpl, LifecycleOwner lifecycleOwner2, Lifecycle.Event lifecycle$Event3) {
        SavedStateRegistryImpl.performAttach$lambda$12(savedStateRegistryImpl, lifecycleOwner2, event3);
    }

    public static Unit $r8$lambda$R9vp5vCFnEV0LfvGgWHkMgcxL5s() {
        return SavedStateRegistryImpl._init_$lambda$0();
    }

    static {
        SavedStateRegistryImpl.Companion companion = new SavedStateRegistryImpl.Companion(0);
        SavedStateRegistryImpl.Companion = companion;
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner owner, Function0<Unit> onAttach) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(onAttach, "onAttach");
        super();
        this.owner = owner;
        this.onAttach = onAttach;
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        this.lock = synchronizedObject;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.keyToProviders = (Map)linkedHashMap;
        this.isAllowingSavingState = true;
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.savedstate.internal.SavedStateRegistryImpl$$ExternalSyntheticLambda1 obj2;
        if (i3 &= 2 != 0) {
            obj2 = new SavedStateRegistryImpl$$ExternalSyntheticLambda1();
        }
        super(savedStateRegistryOwner, obj2);
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final Map access$getKeyToProviders$p(androidx.savedstate.internal.SavedStateRegistryImpl $this) {
        return $this.keyToProviders;
    }

    private static final void performAttach$lambda$12(androidx.savedstate.internal.SavedStateRegistryImpl this$0, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        int obj2;
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.isAllowingSavingState = true;
        } else {
            if (event == Lifecycle.Event.ON_STOP) {
                this$0.isAllowingSavingState = false;
            }
        }
    }

    public final Bundle consumeRestoredStateForKey(String key) {
        int savedState-impl;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.isRestored) {
        } else {
            Bundle restoredState = this.restoredState;
            int i = 0;
            if (restoredState == null) {
                return i;
            }
            int i2 = 0;
            Bundle constructor-impl = SavedStateReader.constructor-impl(restoredState);
            int i5 = 0;
            if (SavedStateReader.contains-impl(constructor-impl, key)) {
                savedState-impl = SavedStateReader.getSavedState-impl(constructor-impl, key);
            } else {
                savedState-impl = i;
            }
            Bundle bundle2 = restoredState;
            int i3 = 0;
            int i6 = 0;
            SavedStateWriter.remove-impl(SavedStateWriter.constructor-impl(bundle2), key);
            int i4 = 0;
            int i7 = 0;
            if (SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(bundle2))) {
                this.restoredState = i;
            }
            return savedState-impl;
        }
        int state = 0;
        IllegalStateException $i$a$CheckSavedStateRegistryImpl$consumeRestoredStateForKey$1 = new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state".toString());
        throw $i$a$CheckSavedStateRegistryImpl$consumeRestoredStateForKey$1;
    }

    public final Function0<Unit> getOnAttach$savedstate_release() {
        return this.onAttach;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider(String key) {
        Object value;
        int i2;
        int i;
        Object key2;
        boolean equal;
        Intrinsics.checkNotNullParameter(key, "key");
        androidx.savedstate.internal.SynchronizedObject lock = this.lock;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        Iterator iterator = SavedStateRegistryImpl.access$getKeyToProviders$p(this).entrySet().iterator();
        synchronized (lock) {
            i2 = 0;
            while (iterator.hasNext()) {
                Object next = iterator.next();
                i = 0;
                if (Intrinsics.areEqual((String)(Map.Entry)next.getKey(), key)) {
                }
                if (i2 == 0) {
                }
                i2 = 0;
                i2 = value;
            }
            return i2;
        }
    }

    public final boolean isAllowingSavingState$savedstate_release() {
        return this.isAllowingSavingState;
    }

    public final boolean isRestored() {
        return this.isRestored;
    }

    public final void performAttach() {
        int i;
        final int i4 = 1;
        i = this.owner.getLifecycle().getCurrentState() == Lifecycle.State.INITIALIZED ? i4 : 0;
        if (i == 0) {
        } else {
            if (this.attached) {
            } else {
                this.onAttach.invoke();
                SavedStateRegistryImpl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SavedStateRegistryImpl$$ExternalSyntheticLambda0(this);
                this.owner.getLifecycle().addObserver((LifecycleObserver)externalSyntheticLambda0);
                this.attached = i4;
            }
            int i3 = 0;
            IllegalStateException $i$a$CheckSavedStateRegistryImpl$performAttach$2 = new IllegalStateException("SavedStateRegistry was already attached.".toString());
            throw $i$a$CheckSavedStateRegistryImpl$performAttach$2;
        }
        int i2 = 0;
        IllegalStateException $i$a$CheckSavedStateRegistryImpl$performAttach$1 = new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        throw $i$a$CheckSavedStateRegistryImpl$performAttach$1;
    }

    public final void performRestore$savedstate_release(Bundle savedState) {
        int savedState-impl;
        Object sTARTED;
        int i2;
        Bundle constructor-impl;
        int i;
        String str;
        boolean contains-impl;
        if (!this.attached) {
            performAttach();
        }
        if (this.owner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
        } else {
            if (this.isRestored) {
            } else {
                savedState-impl = 0;
                i2 = 0;
                constructor-impl = SavedStateReader.constructor-impl(savedState);
                i = 0;
                str = "androidx.lifecycle.BundlableSavedStateRegistry.key";
                if (savedState != null && SavedStateReader.contains-impl(constructor-impl, str)) {
                    i2 = 0;
                    constructor-impl = SavedStateReader.constructor-impl(savedState);
                    i = 0;
                    str = "androidx.lifecycle.BundlableSavedStateRegistry.key";
                    if (SavedStateReader.contains-impl(constructor-impl, str)) {
                        savedState-impl = SavedStateReader.getSavedState-impl(constructor-impl, str);
                    }
                }
                this.restoredState = savedState-impl;
                this.isRestored = true;
            }
            int i3 = 0;
            IllegalStateException $i$a$CheckSavedStateRegistryImpl$performRestore$2 = new IllegalStateException("SavedStateRegistry was already restored.".toString());
            throw $i$a$CheckSavedStateRegistryImpl$performRestore$2;
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("performRestore cannot be called when owner is ").append(this.owner.getLifecycle().getCurrentState()).toString().toString());
        throw illegalStateException;
    }

    public final void performSave$savedstate_release(Bundle outBundle) {
        Object[] $i$f$toTypedArray;
        Bundle bundleOf;
        Object key;
        Bundle bundle2;
        int i3;
        Bundle constructor-impl;
        kotlin.Pair[] arr;
        int i2;
        ArrayList list;
        boolean empty-impl;
        ArrayList arrayList;
        Map map;
        int i;
        Iterator iterator;
        boolean next;
        kotlin.Pair $i$a$MapSavedStateKt__SavedState_androidKt$savedState$pairs$1$iv;
        Object key2;
        Object value;
        Object value2;
        Bundle bundle;
        Object obj;
        key = this;
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        Map emptyMap = MapsKt.emptyMap();
        int i5 = 0;
        arr = 0;
        if (emptyMap.isEmpty()) {
            $i$f$toTypedArray = new Pair[arr];
        } else {
            Map map2 = emptyMap;
            int i6 = 0;
            arrayList = new ArrayList(map2.size());
            i = 0;
            iterator = map2.entrySet().iterator();
            for (Map.Entry next : iterator) {
                int i10 = 0;
                (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
            }
            int i4 = 0;
            $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Pair[arr]);
        }
        Object[] objArr = $i$f$toTypedArray;
        int i7 = 0;
        int i8 = 0;
        Bundle constructor-impl2 = SavedStateWriter.constructor-impl(BundleKt.bundleOf((Pair[])Arrays.copyOf(objArr, objArr.length)));
        int i9 = 0;
        Bundle restoredState = key.restoredState;
        if (restoredState != null) {
            key2 = 0;
            SavedStateWriter.putAll-impl(constructor-impl2, restoredState);
        }
        androidx.savedstate.internal.SynchronizedObject it = key.lock;
        int i11 = 0;
        int i12 = 0;
        final int i13 = 0;
        Iterator iterator2 = SavedStateRegistryImpl.access$getKeyToProviders$p(key).entrySet().iterator();
        synchronized (it) {
            for (Map.Entry next3 : iterator2) {
                SavedStateWriter.putSavedState-impl(constructor-impl2, (String)next3.getKey(), (SavedStateRegistry.SavedStateProvider)next3.getValue().saveState());
                key = this;
                bundleOf = bundle;
            }
            Unit iNSTANCE = Unit.INSTANCE;
            Bundle bundle3 = bundle6;
            i3 = 0;
            i2 = 0;
            if (!SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(bundle3))) {
            }
        }
        i3 = 0;
        i2 = 0;
        SavedStateWriter.putSavedState-impl(SavedStateWriter.constructor-impl(outBundle), "androidx.lifecycle.BundlableSavedStateRegistry.key", bundle3);
    }

    public final void registerSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        androidx.savedstate.internal.SynchronizedObject lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        int i3 = 0;
        synchronized (lock) {
            SavedStateRegistryImpl.access$getKeyToProviders$p(this).put(key, provider);
            Unit $i$a$SynchronizedSavedStateRegistryImpl$registerSavedStateProvider$12 = Unit.INSTANCE;
        }
    }

    public final void setAllowingSavingState$savedstate_release(boolean <set-?>) {
        this.isAllowingSavingState = <set-?>;
    }

    public final void unregisterSavedStateProvider(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        androidx.savedstate.internal.SynchronizedObject lock = this.lock;
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        Object remove = SavedStateRegistryImpl.access$getKeyToProviders$p(this).remove(key);
        return;
        synchronized (lock) {
            Intrinsics.checkNotNullParameter(key, "key");
            lock = this.lock;
            i = 0;
            i2 = 0;
            i3 = 0;
            remove = SavedStateRegistryImpl.access$getKeyToProviders$p(this).remove(key);
        }
    }
}
