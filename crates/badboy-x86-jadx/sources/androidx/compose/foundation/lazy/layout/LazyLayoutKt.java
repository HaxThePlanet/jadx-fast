package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aP\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000c¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\u000c¢\u0006\u0002\u0008\u0010H\u0007¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"MaxItemsToRetainForReuse", "", "LazyLayout", "", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutKt {

    private static final int MaxItemsToRetainForReuse = 7;
    @Deprecated(message = "Use an overload accepting a lambda prodicing an item provider instead", replaceWith = @ReplaceWith(...))
    public static final void LazyLayout(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider itemProvider, Modifier modifier, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState prefetchState, Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, int $changed, int i7) {
        int anon2;
        int $dirty;
        int $dirty2;
        int i;
        Object obj;
        Object obj3;
        int i4;
        Object empty;
        Object anon;
        int i2;
        int i5;
        Object i8;
        Object obj4;
        Object obj2;
        int i6;
        int i3;
        Object obj15;
        final int i13 = $changed;
        anon2 = 852831187;
        final Composer restartGroup = $composer.startRestartGroup(anon2);
        ComposerKt.sourceInformation(restartGroup, "C(LazyLayout)P(!1,2,3)54@2185L16,54@2174L68:LazyLayout.kt#wow0x6");
        $dirty = $changed;
        int i11 = 4;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i13 & 6 == 0) {
                i = restartGroup.changed(itemProvider) ? i11 : 2;
                $dirty |= i;
            }
        }
        int i10 = i7 & 2;
        if (i10 != 0) {
            $dirty |= 48;
        } else {
            if (i13 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i4;
            }
        }
        empty = i7 & 4;
        if (empty != 0) {
            $dirty |= 384;
            anon = prefetchState;
        } else {
            if (i13 & 384 == 0) {
                i2 = restartGroup.changed(prefetchState) ? 256 : 128;
                $dirty |= i2;
            } else {
                anon = prefetchState;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
            obj2 = measurePolicy;
        } else {
            if (i13 & 3072 == 0) {
                i5 = restartGroup.changedInstance(measurePolicy) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                obj2 = measurePolicy;
            }
        }
        final int i15 = $dirty;
        if (i15 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i10 != 0) {
                    i8 = obj15;
                } else {
                    i8 = modifier;
                }
                obj4 = empty != 0 ? obj15 : anon;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon2, i15, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:53)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1956949074, "CC(remember):LazyLayout.kt#9igjgp");
                obj15 = i15 & 14 == i11 ? 1 : 0;
                Composer composer = restartGroup;
                $dirty2 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i12 = 0;
                if (obj15 == null) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new LazyLayoutKt.LazyLayout.1.1(itemProvider);
                        composer.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LazyLayoutKt.LazyLayout((Function0)anon, i8, obj4, obj2, restartGroup, obj15 | anon2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = i8;
                obj3 = obj4;
            } else {
                restartGroup.skipToGroupEnd();
                obj = modifier;
                obj3 = anon;
            }
        } else {
        }
        obj15 = restartGroup.endRestartGroup();
        if (obj15 != null) {
            anon2 = new LazyLayoutKt.LazyLayout.2(itemProvider, obj, obj3, measurePolicy, i13, i7);
            obj15.updateScope((Function2)anon2);
        }
    }

    public static final void LazyLayout(Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider> itemProvider, Modifier modifier, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState prefetchState, Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> measurePolicy, Composer $composer, int $changed, int i7) {
        int rememberUpdatedState;
        int $dirty2;
        int $dirty;
        boolean traceInProgress;
        int i8;
        int str;
        int i9;
        int i;
        int i2;
        int i5;
        int i3;
        int i6;
        int i4;
        Object obj10;
        Object obj11;
        rememberUpdatedState = 2002163445;
        final Composer restartGroup = $composer.startRestartGroup(rememberUpdatedState);
        ComposerKt.sourceInformation(restartGroup, "C(LazyLayout)P(!1,2,3)79@3266L34,81@3338L1509,81@3306L1541:LazyLayout.kt#wow0x6");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if ($changed & 6 == 0) {
                i8 = restartGroup.changedInstance(itemProvider) ? 4 : 2;
                $dirty2 |= i8;
            }
        }
        str = i7 & 2;
        if (str != null) {
            $dirty2 |= 48;
        } else {
            if ($changed & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            }
        }
        i = i7 & 4;
        if (i != 0) {
            $dirty2 |= 384;
        } else {
            if ($changed & 384 == 0) {
                i2 = restartGroup.changed(prefetchState) ? 256 : 128;
                $dirty2 |= i2;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if ($changed & 3072 == 0) {
                i5 = restartGroup.changedInstance(measurePolicy) ? 2048 : 1024;
                $dirty2 |= i5;
            }
        }
        final int i12 = $dirty2;
        if (i12 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    obj10 = $dirty;
                }
                if (i != 0) {
                    obj11 = 0;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(rememberUpdatedState, i12, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:78)");
                }
                LazyLayoutKt.LazyLayout.3 anon = new LazyLayoutKt.LazyLayout.3(obj11, obj10, measurePolicy, SnapshotStateKt.rememberUpdatedState(itemProvider, restartGroup, i12 & 14));
                LazySaveableStateHolderKt.LazySaveableStateHolderProvider((Function3)ComposableLambdaKt.rememberComposableLambda(-1488997347, true, anon, restartGroup, 54), restartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        obj10 = restartGroup.endRestartGroup();
        if (obj10 != null) {
            rememberUpdatedState = new LazyLayoutKt.LazyLayout.4(itemProvider, obj10, obj11, measurePolicy, $changed, i7);
            obj10.updateScope((Function2)rememberUpdatedState);
        }
    }
}
