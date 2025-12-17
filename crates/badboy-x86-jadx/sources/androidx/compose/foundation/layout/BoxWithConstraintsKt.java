package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aN\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072!\u0010\u0008\u001a\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0008\u000c¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f", d2 = {"BoxWithConstraints", "", "modifier", "Landroidx/compose/ui/Modifier;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BoxWithConstraintsKt {
    public static final void BoxWithConstraints(Modifier modifier, Alignment contentAlignment, boolean propagateMinConstraints, Function3<? super androidx.compose.foundation.layout.BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        int $dirty2;
        Object modifier2;
        int $dirty;
        Object contentAlignment2;
        Object obj;
        boolean z2;
        boolean traceInProgress;
        int i2;
        int i6;
        int str;
        Object obj2;
        int i;
        int i8;
        boolean z;
        int i4;
        int i5;
        Object rememberedValue;
        int i3;
        Object empty;
        Object anon;
        final Object obj4 = content;
        final int i15 = $changed;
        maybeCachedBoxMeasurePolicy = 1781813501;
        final Composer restartGroup = $composer.startRestartGroup(maybeCachedBoxMeasurePolicy);
        ComposerKt.sourceInformation(restartGroup, "C(BoxWithConstraints)P(2,1,3)66@3288L218,66@3261L245:BoxWithConstraints.kt#2w3rfo");
        $dirty2 = $changed;
        int i9 = i7 & 1;
        if (i9 != 0) {
            $dirty2 |= 6;
            obj = modifier;
        } else {
            if (i15 & 6 == 0) {
                i6 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i6;
            } else {
                obj = modifier;
            }
        }
        str = i7 & 2;
        if (str != null) {
            $dirty2 |= 48;
            obj2 = contentAlignment;
        } else {
            if (i15 & 48 == 0) {
                i = restartGroup.changed(contentAlignment) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj2 = contentAlignment;
            }
        }
        i8 = i7 & 4;
        if (i8 != 0) {
            $dirty2 |= 384;
            z = propagateMinConstraints;
        } else {
            if (i15 & 384 == 0) {
                i4 = restartGroup.changed(propagateMinConstraints) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                z = propagateMinConstraints;
            }
        }
        rememberedValue = 2048;
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (i15 & 3072 == 0) {
                i5 = restartGroup.changedInstance(obj4) ? rememberedValue : 1024;
                $dirty2 |= i5;
            }
        }
        int i18 = $dirty2;
        if (i18 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (i9 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                if (str != null) {
                    contentAlignment2 = Alignment.Companion.getTopStart();
                } else {
                    contentAlignment2 = obj2;
                }
                if (i8 != 0) {
                    z = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(maybeCachedBoxMeasurePolicy, i18, -1, "androidx.compose.foundation.layout.BoxWithConstraints (BoxWithConstraints.kt:64)");
                }
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment2, z);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2066127113, "CC(remember):BoxWithConstraints.kt#9igjgp");
                str = 0;
                i2 = i18 & 7168 == rememberedValue ? 1 : str;
                obj2 = restartGroup;
                i8 = 0;
                rememberedValue = obj2.rememberedValue();
                i3 = 0;
                if (i2 |= changed2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new BoxWithConstraintsKt.BoxWithConstraints.1.1(maybeCachedBoxMeasurePolicy, obj4);
                        obj2.updateRememberedValue((Function2)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                SubcomposeLayoutKt.SubcomposeLayout(modifier2, (Function2)anon, restartGroup, i18 & 14, str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z2 = z;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = obj;
                contentAlignment2 = obj2;
                z2 = z;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            maybeCachedBoxMeasurePolicy = new BoxWithConstraintsKt.BoxWithConstraints.2(modifier2, contentAlignment2, z2, obj4, i15, i7);
            endRestartGroup.updateScope((Function2)maybeCachedBoxMeasurePolicy);
        }
    }
}
