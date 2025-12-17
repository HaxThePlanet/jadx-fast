package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.PinnableContainerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\u0008\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\u000c", d2 = {"LazyLayoutPinnableItem", "", "key", "", "index", "", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;ILandroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutPinnableItemKt {
    public static final void LazyLayoutPinnableItem(Object key, int index, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList pinnedItemList, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int invalid$iv;
        int $dirty;
        int i3;
        int i5;
        int i;
        int i2;
        int traceInProgress2;
        boolean traceInProgress;
        int str;
        Object key2;
        int i7;
        int i6;
        Object rememberedValue;
        Object obj2;
        int i8;
        Object obj;
        Object empty;
        int i4;
        Object lazyLayoutPinnableItem;
        Object anon;
        invalid$iv = -2079116560;
        final Composer obj13 = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(obj13, "C(LazyLayoutPinnableItem)P(2,1,3)53@2119L77,55@2294L7,56@2337L43,56@2306L74,57@2385L103:LazyLayoutPinnableItem.kt#wow0x6");
        if ($changed & 6 == 0) {
            i3 = obj13.changedInstance(key) ? 4 : 2;
            $dirty |= i3;
        }
        if ($changed & 48 == 0) {
            i5 = obj13.changed(index) ? 32 : 16;
            $dirty |= i5;
        }
        if ($changed & 384 == 0) {
            i = obj13.changedInstance(pinnedItemList) ? 256 : 128;
            $dirty |= i;
        }
        if ($changed & 3072 == 0) {
            i2 = obj13.changedInstance(content) ? 2048 : 1024;
            $dirty |= i2;
        }
        if ($dirty & 1171 == 1170) {
            if (!obj13.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, $dirty, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:52)");
                }
                String str3 = "CC(remember):LazyLayoutPinnableItem.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(obj13, -752868363, str3);
                Composer composer = obj13;
                int i13 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i18 = 0;
                if (changed |= changed4 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        lazyLayoutPinnableItem = new LazyLayoutPinnableItem(key, pinnedItemList);
                        composer.updateRememberedValue(lazyLayoutPinnableItem);
                    } else {
                        lazyLayoutPinnableItem = rememberedValue2;
                    }
                } else {
                }
                invalid$iv = lazyLayoutPinnableItem;
                ComposerKt.sourceInformationMarkerEnd(obj13);
                (LazyLayoutPinnableItem)invalid$iv.setIndex(index);
                int i14 = 0;
                int i17 = 0;
                ComposerKt.sourceInformationMarkerStart(obj13, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj13);
                invalid$iv.setParentPinnableContainer((PinnableContainer)obj13.consume((CompositionLocal)PinnableContainerKt.getLocalPinnableContainer()));
                ComposerKt.sourceInformationMarkerStart(obj13, -752861421, str3);
                Composer composer2 = obj13;
                int i15 = 0;
                rememberedValue = composer2.rememberedValue();
                i8 = 0;
                if (!obj13.changed(invalid$iv)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new LazyLayoutPinnableItemKt.LazyLayoutPinnableItem.1.1(invalid$iv);
                        composer2.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj13);
                EffectsKt.DisposableEffect(invalid$iv, (Function1)anon, obj13, 0);
                CompositionLocalKt.CompositionLocalProvider(PinnableContainerKt.getLocalPinnableContainer().provides(invalid$iv), content, obj13, $stable |= i7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj13.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj13.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LazyLayoutPinnableItemKt.LazyLayoutPinnableItem.2(key, index, pinnedItemList, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            key2 = key;
            i6 = index;
            obj2 = pinnedItemList;
            obj = content;
            i4 = $changed;
        }
    }
}
