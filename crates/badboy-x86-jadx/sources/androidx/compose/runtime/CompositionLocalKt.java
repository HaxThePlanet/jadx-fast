package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a,\u0010\u0000\u001a\u00020\u00012\n\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\n\u001a<\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u000b\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\t0\u000c\"\u0006\u0012\u0002\u0008\u00030\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0006H\u0007¢\u0006\u0002\u0010\r\u001a0\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\u0008\u0000\u0010\u00102\u000e\u0008\u0002\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0005\u001a+\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\u0008\u0000\u0010\u00102\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002H\u00100\u0016¢\u0006\u0002\u0008\u0018\u001a \u0010\u0019\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\u0008\u0000\u0010\u00102\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0005¨\u0006\u001a", d2 = {"CompositionLocalProvider", "", "context", "Landroidx/compose/runtime/CompositionLocalContext;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionLocalContext;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "value", "Landroidx/compose/runtime/ProvidedValue;", "(Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "values", "", "([Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compositionLocalOf", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "compositionLocalWithComputedDefaultOf", "defaultComputation", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "staticCompositionLocalOf", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompositionLocalKt {
    public static final void CompositionLocalProvider(androidx.compose.runtime.CompositionLocalContext context, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i2;
        int i;
        int skipping;
        boolean traceInProgress2;
        int arrayList;
        androidx.compose.runtime.ProvidedValue[] arr;
        int i3;
        Iterator iterator;
        Object next;
        androidx.compose.runtime.ProvidedValue it;
        int i4;
        Object value;
        Object key;
        traceInProgress = 1853897736;
        final androidx.compose.runtime.Composer obj14 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj14, "C(CompositionLocalProvider)P(1)418@18128L144:CompositionLocal.kt#9igjgp");
        if ($changed & 6 == 0) {
            i2 = obj14.changed(context) ? 4 : 2;
            $dirty |= i2;
        }
        if ($changed & 48 == 0) {
            i = obj14.changedInstance(content) ? 32 : 16;
            $dirty |= i;
        }
        if ($dirty & 19 == 18) {
            if (!obj14.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:417)");
                }
                androidx.compose.runtime.PersistentCompositionLocalMap compositionLocals$runtime_release = context.getCompositionLocals$runtime_release();
                int i6 = 0;
                arrayList = new ArrayList((Map)compositionLocals$runtime_release.size());
                i3 = 0;
                iterator = compositionLocals$runtime_release.entrySet().iterator();
                for (Map.Entry next : iterator) {
                    Object obj = next;
                    i4 = 0;
                    (Collection)arrayList.add((ValueHolder)obj.getValue().toProvided((CompositionLocal)obj.getKey()));
                }
                int i5 = 0;
                Object[] $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new ProvidedValue[0]);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue[])Arrays.copyOf((ProvidedValue[])$i$f$toTypedArray, $i$f$toTypedArray.length), content, obj14, $dirty & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj14.skipToGroupEnd();
            }
        } else {
        }
        androidx.compose.runtime.ScopeUpdateScope endRestartGroup = obj14.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new CompositionLocalKt.CompositionLocalProvider.4(context, content, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void CompositionLocalProvider(androidx.compose.runtime.ProvidedValue<?> value, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1350970552;
        final androidx.compose.runtime.Composer obj6 = $composer.startRestartGroup(i);
        ComposerKt.sourceInformation(obj6, "C(CompositionLocalProvider)P(1)400@17486L9:CompositionLocal.kt#9igjgp");
        int i4 = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, i4, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:398)");
        }
        obj6.startProvider(value);
        content.invoke(obj6, Integer.valueOf(i2 &= 14));
        obj6.endProvider();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        androidx.compose.runtime.ScopeUpdateScope endRestartGroup = obj6.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CompositionLocalKt.CompositionLocalProvider.2(value, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void CompositionLocalProvider(androidx.compose.runtime.ProvidedValue<?>[] values, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1390796515;
        final androidx.compose.runtime.Composer obj6 = $composer.startRestartGroup(i);
        ComposerKt.sourceInformation(obj6, "C(CompositionLocalProvider)P(1)379@16749L9:CompositionLocal.kt#9igjgp");
        int i4 = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, i4, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:377)");
        }
        obj6.startProviders(values);
        content.invoke(obj6, Integer.valueOf(i2 &= 14));
        obj6.endProviders();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        androidx.compose.runtime.ScopeUpdateScope endRestartGroup = obj6.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CompositionLocalKt.CompositionLocalProvider.1(values, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final <T> androidx.compose.runtime.ProvidableCompositionLocal<T> compositionLocalOf(androidx.compose.runtime.SnapshotMutationPolicy<T> policy, Function0<? extends T> defaultFactory) {
        DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = new DynamicProvidableCompositionLocal(policy, defaultFactory);
        return (ProvidableCompositionLocal)dynamicProvidableCompositionLocal;
    }

    public static androidx.compose.runtime.ProvidableCompositionLocal compositionLocalOf$default(androidx.compose.runtime.SnapshotMutationPolicy snapshotMutationPolicy, Function0 function02, int i3, Object object4) {
        androidx.compose.runtime.SnapshotMutationPolicy obj0;
        if (i3 &= 1 != 0) {
            obj0 = SnapshotStateKt.structuralEqualityPolicy();
        }
        return CompositionLocalKt.compositionLocalOf(obj0, function02);
    }

    public static final <T> androidx.compose.runtime.ProvidableCompositionLocal<T> compositionLocalWithComputedDefaultOf(Function1<? super androidx.compose.runtime.CompositionLocalAccessorScope, ? extends T> defaultComputation) {
        ComputedProvidableCompositionLocal computedProvidableCompositionLocal = new ComputedProvidableCompositionLocal(defaultComputation);
        return (ProvidableCompositionLocal)computedProvidableCompositionLocal;
    }

    public static final <T> androidx.compose.runtime.ProvidableCompositionLocal<T> staticCompositionLocalOf(Function0<? extends T> defaultFactory) {
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = new StaticProvidableCompositionLocal(defaultFactory);
        return (ProvidableCompositionLocal)staticProvidableCompositionLocal;
    }
}
