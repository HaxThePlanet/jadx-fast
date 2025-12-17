package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.DpSize.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\n2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0014\u001a\u000c\u0010\u0015\u001a\u00020\u000e*\u00020\u000eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0006\u0010\u0003\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"CursorHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getCursorHandleHeight", "()F", "F", "CursorHandleWidth", "getCursorHandleWidth", "Sqrt2", "", "CursorHandle", "", "offsetProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "CursorHandle-USBMPiE", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DefaultCursorHandle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawCursorHandle", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidCursorHandle_androidKt {

    private static final float CursorHandleHeight = 0f;
    private static final float CursorHandleWidth = 0f;
    private static final float Sqrt2 = 1.4142135f;
    static {
        int i2 = 0;
        AndroidCursorHandle_androidKt.CursorHandleHeight = Dp.constructor-impl((float)i);
        int i4 = 0;
        int i5 = 0;
        AndroidCursorHandle_androidKt.CursorHandleWidth = Dp.constructor-impl(arg0$iv / other$iv);
    }

    public static final void CursorHandle-USBMPiE(OffsetProvider offsetProvider, Modifier modifier, long minTouchTargetSize, Composer $composer, int $changed, int i6) {
        int semantics$default;
        int i7;
        int changedInstance2;
        int $dirty;
        long $dirty2;
        boolean changedInstance;
        int i2;
        int i;
        int i4;
        boolean traceInProgress;
        int defaultsInvalid;
        int companion;
        boolean traceInProgress2;
        int changed;
        int rememberComposableLambda;
        long unspecified-MYxV2XQ;
        int minTouchTargetSize2;
        int str;
        int i3;
        int i5;
        int i8;
        Object empty;
        Object anon;
        long l;
        final Object obj = offsetProvider;
        final Object obj2 = modifier;
        final int i13 = i6;
        semantics$default = 1776202187;
        final Composer restartGroup = $changed.startRestartGroup(semantics$default);
        ComposerKt.sourceInformation(restartGroup, "C(CursorHandle)P(2,1,0:c#ui.unit.DpSize)52@2192L241,63@2551L458,60@2438L571:AndroidCursorHandle.android.kt#423gt5");
        $dirty = i6;
        rememberComposableLambda = 4;
        if (obj24 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i13 & 6 == 0) {
                if (i13 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj);
                } else {
                    changedInstance = restartGroup.changedInstance(obj);
                }
                i2 = changedInstance != null ? rememberComposableLambda : 2;
                $dirty |= i2;
            }
        }
        if (obj24 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i13 & 48 == 0) {
                i = restartGroup.changed(obj2) ? 32 : 16;
                $dirty |= i;
            }
        }
        if (i13 & 384 == 0) {
            if (obj24 & 4 == 0) {
                i4 = restartGroup.changed(minTouchTargetSize) ? 256 : 128;
            } else {
                unspecified-MYxV2XQ = minTouchTargetSize;
            }
            $dirty |= i4;
        } else {
            unspecified-MYxV2XQ = minTouchTargetSize;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i13 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj24 & 4 != 0) {
                            unspecified-MYxV2XQ = DpSize.Companion.getUnspecified-MYxV2XQ();
                            $dirty &= -897;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj24 & 4 != 0) {
                            $dirty &= -897;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(semantics$default, $dirty, -1, "androidx.compose.foundation.text.CursorHandle (AndroidCursorHandle.android.kt:51)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -533359786, "CC(remember):AndroidCursorHandle.android.kt#9igjgp");
                int i12 = 0;
                int i14 = 1;
                if ($dirty & 14 != rememberComposableLambda) {
                    if ($dirty & 8 != 0 && restartGroup.changedInstance(obj)) {
                        if (restartGroup.changedInstance(obj)) {
                            i7 = i14;
                        } else {
                            i7 = i12;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer = restartGroup;
                int i16 = 0;
                Object rememberedValue = composer.rememberedValue();
                i8 = 0;
                if (i7 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new AndroidCursorHandle_androidKt.CursorHandle.finalModifier.1.1(obj);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AndroidCursorHandle_androidKt.CursorHandle.1 anon2 = new AndroidCursorHandle_androidKt.CursorHandle.1(unspecified-MYxV2XQ, obj9, SemanticsModifierKt.semantics$default(obj2, i12, (Function1)anon, i14, 0));
                AndroidSelectionHandles_androidKt.HandlePopup(obj, Alignment.Companion.getTopCenter(), (Function2)ComposableLambdaKt.rememberComposableLambda(-1653527038, i14, anon2, restartGroup, 54), restartGroup, i15 |= 432);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                minTouchTargetSize2 = $dirty;
                $dirty2 = l;
            } else {
                restartGroup.skipToGroupEnd();
                minTouchTargetSize2 = $dirty;
                $dirty2 = l;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            semantics$default = new AndroidCursorHandle_androidKt.CursorHandle.2(obj, obj2, $dirty2, traceInProgress, i13, obj24);
            endRestartGroup.updateScope((Function2)semantics$default);
        }
    }

    private static final void DefaultCursorHandle(Modifier modifier, Composer $composer, int $changed, int i4) {
        boolean traceInProgress2;
        int $dirty;
        int companion;
        boolean traceInProgress;
        int skipping;
        int i;
        Object obj5;
        traceInProgress2 = 694251107;
        final Composer obj6 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj6, "C(DefaultCursorHandle)83@3117L79:AndroidCursorHandle.android.kt#423gt5");
        $dirty = $changed;
        companion = i4 & 1;
        skipping = 2;
        if (companion != 0) {
            $dirty |= 6;
        } else {
            if ($changed & 6 == 0) {
                i = obj6.changed(modifier) ? 4 : skipping;
                $dirty |= i;
            }
        }
        if ($dirty & 3 == skipping) {
            if (!obj6.getSkipping()) {
                if (companion != 0) {
                    obj5 = companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:82)");
                }
                SpacerKt.Spacer(AndroidCursorHandle_androidKt.drawCursorHandle(SizeKt.size-VpY3zN4(obj5, AndroidCursorHandle_androidKt.CursorHandleWidth, AndroidCursorHandle_androidKt.CursorHandleHeight)), obj6, 0);
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
            companion = new AndroidCursorHandle_androidKt.DefaultCursorHandle.1(obj5, $changed, i4);
            endRestartGroup.updateScope((Function2)companion);
        }
    }

    public static final void access$DefaultCursorHandle(Modifier modifier, Composer $composer, int $changed, int $default) {
        AndroidCursorHandle_androidKt.DefaultCursorHandle(modifier, $composer, $changed, $default);
    }

    private static final Modifier drawCursorHandle(Modifier $this$drawCursorHandle) {
        final int i2 = 0;
        return ComposedModifierKt.composed$default($this$drawCursorHandle, i2, (Function3)AndroidCursorHandle_androidKt.drawCursorHandle.1.INSTANCE, 1, i2);
    }

    public static final float getCursorHandleHeight() {
        return AndroidCursorHandle_androidKt.CursorHandleHeight;
    }

    public static final float getCursorHandleWidth() {
        return AndroidCursorHandle_androidKt.CursorHandleWidth;
    }
}
