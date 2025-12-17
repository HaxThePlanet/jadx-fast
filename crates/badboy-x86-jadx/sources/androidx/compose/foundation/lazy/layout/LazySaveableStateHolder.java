package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistry.Entry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010#\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B/\u0008\u0016\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\r\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000bJ(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00082\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00170\u001a¢\u0006\u0002\u0008\u001bH\u0017¢\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0008H\u0096\u0001J\u0013\u0010 \u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0018\u001a\u00020\u0006H\u0096\u0001J\u001c\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00070\u0005H\u0016J!\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00062\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u001aH\u0096\u0001J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0008H\u0016R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00080\rX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "parentRegistry", "restoredValues", "", "", "", "", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/util/Map;)V", "wrappedRegistry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "previouslyComposedKeys", "", "<set-?>", "wrappedHolder", "getWrappedHolder", "()Landroidx/compose/runtime/saveable/SaveableStateHolder;", "setWrappedHolder", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "wrappedHolder$delegate", "Landroidx/compose/runtime/MutableState;", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "canBeSaved", "", "value", "consumeRestored", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "removeState", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazySaveableStateHolder implements SaveableStateRegistry, SaveableStateHolder {

    public static final androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.Companion Companion;
    private final Set<Object> previouslyComposedKeys;
    private final MutableState wrappedHolder$delegate;
    private final SaveableStateRegistry wrappedRegistry;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00080\u00060\u00042\u0008\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder$Companion;", "", "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "", "", "", "parentRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.foundation.lazy.layout.LazySaveableStateHolder, Map<String, List<Object>>> saver(SaveableStateRegistry parentRegistry) {
            LazySaveableStateHolder.Companion.saver.2 anon = new LazySaveableStateHolder.Companion.saver.2(parentRegistry);
            return SaverKt.Saver((Function2)LazySaveableStateHolder.Companion.saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        LazySaveableStateHolder.Companion companion = new LazySaveableStateHolder.Companion(0);
        LazySaveableStateHolder.Companion = companion;
    }

    public LazySaveableStateHolder(SaveableStateRegistry wrappedRegistry) {
        super();
        this.wrappedRegistry = wrappedRegistry;
        int i = 0;
        this.wrappedHolder$delegate = SnapshotStateKt.mutableStateOf$default(i, i, 2, i);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.previouslyComposedKeys = (Set)linkedHashSet;
    }

    public LazySaveableStateHolder(SaveableStateRegistry parentRegistry, Map<String, ? extends List<? extends Object>> restoredValues) {
        LazySaveableStateHolder.1 anon = new LazySaveableStateHolder.1(parentRegistry);
        super(SaveableStateRegistryKt.SaveableStateRegistry(restoredValues, (Function1)anon));
    }

    public static final Set access$getPreviouslyComposedKeys$p(androidx.compose.foundation.lazy.layout.LazySaveableStateHolder $this) {
        return $this.previouslyComposedKeys;
    }

    public void SaveableStateProvider(Object key, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i;
        int i2;
        int i4;
        boolean skipping;
        boolean traceInProgress2;
        int str;
        Object rememberedValue;
        int i3;
        Object empty;
        Object anon;
        traceInProgress = -697180401;
        final Composer obj11 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj11, "C(SaveableStateProvider)P(1)84@3453L35,85@3519L137,85@3497L159:LazySaveableStateHolder.kt#wow0x6");
        if ($changed & 6 == 0) {
            i = obj11.changedInstance(key) ? 4 : 2;
            $dirty |= i;
        }
        if ($changed & 48 == 0) {
            i2 = obj11.changedInstance(content) ? 32 : 16;
            $dirty |= i2;
        }
        if ($changed & 384 == 0) {
            i4 = obj11.changedInstance(this) ? 256 : 128;
            $dirty |= i4;
        }
        if ($dirty & 147 == 146) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:82)");
                }
                SaveableStateHolder wrappedHolder = getWrappedHolder();
                if (wrappedHolder == null) {
                } else {
                    wrappedHolder.SaveableStateProvider(key, content, obj11, i9 |= i11);
                    ComposerKt.sourceInformationMarkerStart(obj11, 622446964, "CC(remember):LazySaveableStateHolder.kt#9igjgp");
                    skipping = obj11;
                    str = 0;
                    rememberedValue = skipping.rememberedValue();
                    i3 = 0;
                    if (changedInstance |= changedInstance3 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon = new LazySaveableStateHolder.SaveableStateProvider.2.1(this, key);
                            skipping.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj11);
                    EffectsKt.DisposableEffect(key, (Function1)anon, obj11, $dirty & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
                    if (endRestartGroup != null) {
                        skipping = new LazySaveableStateHolder.SaveableStateProvider.3(this, key, content, $changed);
                        endRestartGroup.updateScope((Function2)skipping);
                    }
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        int i8 = 0;
        IllegalArgumentException $i$a$RequireNotNullLazySaveableStateHolder$SaveableStateProvider$1 = new IllegalArgumentException("null wrappedHolder".toString());
        throw $i$a$RequireNotNullLazySaveableStateHolder$SaveableStateProvider$1;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object object) {
        return this.wrappedRegistry.canBeSaved(object);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String string) {
        return this.wrappedRegistry.consumeRestored(string);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final SaveableStateHolder getWrappedHolder() {
        final int i = 0;
        final int i2 = 0;
        return (SaveableStateHolder)(State)this.wrappedHolder$delegate.getValue();
    }

    public Map<String, List<Object>> performSave() {
        Set previouslyComposedKeys;
        int i;
        Iterator iterator;
        boolean next;
        Object obj;
        int i2;
        final SaveableStateHolder wrappedHolder = getWrappedHolder();
        if (wrappedHolder != null) {
            i = 0;
            iterator = (Iterable)this.previouslyComposedKeys.iterator();
            for (Object next : iterator) {
                i2 = 0;
                wrappedHolder.removeState(next);
            }
        }
        return this.wrappedRegistry.performSave();
    }

    public SaveableStateRegistry.Entry registerProvider(String string, Function0<? extends Object> function02) {
        return this.wrappedRegistry.registerProvider(string, function02);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public void removeState(Object key) {
        SaveableStateHolder wrappedHolder = getWrappedHolder();
        if (wrappedHolder == null) {
        } else {
            wrappedHolder.removeState(key);
        }
        int i = 0;
        IllegalArgumentException $i$a$RequireNotNullLazySaveableStateHolder$removeState$1 = new IllegalArgumentException("null wrappedHolder".toString());
        throw $i$a$RequireNotNullLazySaveableStateHolder$removeState$1;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final void setWrappedHolder(SaveableStateHolder <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.wrappedHolder$delegate.setValue(<set-?>);
    }
}
