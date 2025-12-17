package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0005H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"SkippableItem", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "saveableStateHolder", "Landroidx/compose/foundation/lazy/layout/StableValue;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "index", "", "key", "", "SkippableItem-JVlU9Rs", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Ljava/lang/Object;ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutItemContentFactoryKt {
    private static final void SkippableItem-JVlU9Rs(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider itemProvider, Object saveableStateHolder, int index, Object key, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i2;
        int i6;
        int i5;
        int i;
        boolean rememberComposableLambda;
        boolean traceInProgress2;
        int str;
        Object itemProvider2;
        int i7;
        Object obj2;
        int i4;
        int i8;
        Object obj;
        int i3;
        traceInProgress = 1439843069;
        final Composer obj12 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj12, "C(SkippableItem)P(1,3:c#foundation.lazy.layout.StableValue!,2:c#foundation.lazy.layout.StableValue)133@4741L51,133@4708L84:LazyLayoutItemContentFactory.kt#wow0x6");
        if ($changed & 6 == 0) {
            i2 = obj12.changed(itemProvider) ? 4 : 2;
            $dirty |= i2;
        }
        if ($changed & 48 == 0) {
            i6 = obj12.changed(saveableStateHolder) ? 32 : 16;
            $dirty |= i6;
        }
        if ($changed & 384 == 0) {
            i5 = obj12.changed(index) ? 256 : 128;
            $dirty |= i5;
        }
        if ($changed & 3072 == 0) {
            i = obj12.changed(key) ? 2048 : 1024;
            $dirty |= i;
        }
        if ($dirty & 1171 == 1170) {
            if (!obj12.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.lazy.layout.SkippableItem (LazyLayoutItemContentFactory.kt:132)");
                }
                LazyLayoutItemContentFactoryKt.SkippableItem.1 anon = new LazyLayoutItemContentFactoryKt.SkippableItem.1(itemProvider, index, key);
                (SaveableStateHolder)saveableStateHolder.SaveableStateProvider(key, (Function2)ComposableLambdaKt.rememberComposableLambda(980966366, true, anon, obj12, 54), obj12, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj12.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj12.endRestartGroup();
        if (endRestartGroup != null) {
            rememberComposableLambda = new LazyLayoutItemContentFactoryKt.SkippableItem.2(itemProvider, saveableStateHolder, index, key, $changed);
            endRestartGroup.updateScope((Function2)rememberComposableLambda);
        } else {
            itemProvider2 = itemProvider;
            obj2 = saveableStateHolder;
            i8 = index;
            obj = key;
            i3 = $changed;
        }
    }

    public static final void access$SkippableItem-JVlU9Rs(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider itemProvider, Object saveableStateHolder, int index, Object key, Composer $composer, int $changed) {
        LazyLayoutItemContentFactoryKt.SkippableItem-JVlU9Rs(itemProvider, saveableStateHolder, index, key, $composer, $changed);
    }
}
