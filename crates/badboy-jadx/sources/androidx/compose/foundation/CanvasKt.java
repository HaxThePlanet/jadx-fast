package androidx.compose.foundation;

import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0007H\u0007¢\u0006\u0002\u0010\u0008\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0008\u0007H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\u000c", d2 = {"Canvas", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "contentDescription", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CanvasKt {
    public static final void Canvas(Modifier modifier, String contentDescription, Function1<? super DrawScope, Unit> onDraw, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i;
        int i5;
        int i6;
        boolean skipping;
        boolean traceInProgress;
        int i2;
        int i8;
        int str;
        int i4;
        int i3;
        Object rememberedValue;
        int i7;
        Object empty;
        Object anon;
        traceInProgress2 = -1162737955;
        final Composer obj14 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj14, "C(Canvas)P(1)63@3176L48,63@3131L94:Canvas.kt#71ulvw");
        if ($changed & 6 == 0) {
            i = obj14.changed(modifier) ? 4 : 2;
            $dirty |= i;
        }
        i8 = 32;
        if ($changed & 48 == 0) {
            i5 = obj14.changed(contentDescription) ? i8 : 16;
            $dirty |= i5;
        }
        if ($changed & 384 == 0) {
            i6 = obj14.changedInstance(onDraw) ? 256 : 128;
            $dirty |= i6;
        }
        if ($dirty & 147 == 146) {
            if (!obj14.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.foundation.Canvas (Canvas.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(obj14, 1782764706, "CC(remember):Canvas.kt#9igjgp");
                str = 1;
                i4 = 0;
                i2 = $dirty & 112 == i8 ? str : i4;
                i8 = obj14;
                i3 = 0;
                rememberedValue = i8.rememberedValue();
                i7 = 0;
                if (i2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new CanvasKt.Canvas.2.1(contentDescription);
                        i8.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj14);
                SpacerKt.Spacer(SemanticsModifierKt.semantics$default(DrawModifierKt.drawBehind(modifier, onDraw), i4, (Function1)anon, str, 0), obj14, i4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj14.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj14.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new CanvasKt.Canvas.3(modifier, contentDescription, onDraw, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void Canvas(Modifier modifier, Function1<? super DrawScope, Unit> onDraw, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i2;
        int i;
        int skipping;
        boolean traceInProgress;
        int str;
        traceInProgress2 = -932836462;
        final Composer obj6 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj6, "C(Canvas)42@1876L35:Canvas.kt#71ulvw");
        if ($changed & 6 == 0) {
            i2 = obj6.changed(modifier) ? 4 : 2;
            $dirty |= i2;
        }
        if ($changed & 48 == 0) {
            i = obj6.changedInstance(onDraw) ? 32 : 16;
            $dirty |= i;
        }
        if ($dirty & 19 == 18) {
            if (!obj6.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.foundation.Canvas (Canvas.kt:42)");
                }
                SpacerKt.Spacer(DrawModifierKt.drawBehind(modifier, onDraw), obj6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj6.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj6.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new CanvasKt.Canvas.1(modifier, onDraw, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }
}
