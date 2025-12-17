package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a:\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\r", d2 = {"DividerAlpha", "", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DividerKt {

    private static final float DividerAlpha = 0.12f;
    public static final void Divider-oMI9zvI(Modifier modifier, long color, float thickness, float startIndent, Composer $composer, int $changed, int i7) {
        boolean traceInProgress2;
        int $dirty;
        Object $dirty2;
        Object modifier2;
        long modifier3;
        Object color2;
        int i5;
        long l;
        float f2;
        float $this$dp$iv;
        boolean traceInProgress;
        int i4;
        int i15;
        float f;
        int changed;
        int $i$f$getDp;
        float i;
        int thickness2;
        int i6;
        int padding-qDBjuR0$default;
        float i2;
        int i8;
        int skipping;
        int onSurface-0d7_KjU;
        boolean equals-impl0;
        int i10;
        int i14;
        int i9;
        int i11;
        int i16;
        int i12;
        int i3;
        int i13;
        Modifier obj21;
        long obj22;
        int obj24;
        int obj25;
        int obj26;
        final int i29 = i7;
        traceInProgress2 = -1249392198;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Divider)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,2:c#ui.unit.Dp)45@1819L6,59@2200L147:Divider.kt#jmzs0o");
        $dirty = i7;
        int i19 = obj28 & 1;
        if (i19 != 0) {
            $dirty |= 6;
            color2 = modifier;
        } else {
            if (i29 & 6 == 0) {
                i5 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i5;
            } else {
                color2 = modifier;
            }
        }
        if (i29 & 48 == 0) {
            if (obj28 & 2 == 0) {
                changed = restartGroup.changed(color) ? 32 : 16;
            } else {
                l = color;
            }
            $dirty |= changed;
        } else {
            l = color;
        }
        $i$f$getDp = obj28 & 4;
        if ($i$f$getDp != 0) {
            $dirty |= 384;
            i = startIndent;
        } else {
            if (i29 & 384 == 0) {
                i6 = restartGroup.changed(startIndent) ? 256 : 128;
                $dirty |= i6;
            } else {
                i = startIndent;
            }
        }
        padding-qDBjuR0$default = obj28 & 8;
        if (padding-qDBjuR0$default != 0) {
            $dirty |= 3072;
            i2 = $composer;
        } else {
            if (i29 & 3072 == 0) {
                i8 = restartGroup.changed($composer) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                i2 = $composer;
            }
        }
        i10 = 1170;
        if ($dirty & 1171 == i10) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i29 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = color2;
                        }
                        if (obj28 & 2 != 0) {
                            color2 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(restartGroup, 6).getOnSurface-0d7_KjU(), i10, 1039516303, 0, 0, 0, 14);
                            $dirty &= -113;
                        } else {
                            color2 = l;
                        }
                        if ($i$f$getDp != 0) {
                            $i$f$getDp = 0;
                            i = $this$dp$iv;
                        }
                        if (padding-qDBjuR0$default != 0) {
                            $i$f$getDp = 0;
                            i2 = $this$dp$iv;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj28 & 2 != 0) {
                            $dirty &= -113;
                        }
                        modifier2 = color2;
                        color2 = l;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.Divider (Divider.kt:48)");
                }
                int i17 = 0;
                int i33 = 1;
                i4 = Float.compare(i2, i17) == 0 ? i33 : 0;
                if (i4 == 0) {
                    i15 = i13;
                    padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, i2, 0, 0, 0, 14, 0);
                } else {
                    i15 = i33;
                    padding-qDBjuR0$default = Modifier.Companion;
                }
                if (Dp.equals-impl0(i, Dp.Companion.getHairline-D9Ej5fM())) {
                    restartGroup.startReplaceGroup(-129374855);
                    ComposerKt.sourceInformation(restartGroup, "*55@2139L7");
                    i10 = 0;
                    i14 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i31 = 0;
                    $i$f$getDp = Dp.constructor-impl(i37 /= density);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-129316234);
                    restartGroup.endReplaceGroup();
                    $i$f$getDp = i;
                }
                i10 = 0;
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier2.then(padding-qDBjuR0$default), i17, i15, i10), $i$f$getDp), color2, thickness, i10, 2), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                thickness2 = $dirty;
                $dirty2 = modifier2;
                modifier3 = color2;
                f2 = f3;
                f = i2;
            } else {
                restartGroup.skipToGroupEnd();
                thickness2 = $dirty;
                $dirty2 = color2;
                modifier3 = l;
                f2 = i13;
                f = i2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DividerKt.Divider.1($dirty2, modifier3, color2, f2, f, i29, obj28);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }
}
