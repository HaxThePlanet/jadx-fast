package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a0\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\t\u001a0\u0010\n\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\t\u001a0\u0010\u000c\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "HorizontalDivider", "HorizontalDivider-9IZ8Weo", "VerticalDivider", "VerticalDivider-9IZ8Weo", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DividerKt {
    @Deprecated(message = "Renamed to HorizontalDivider", replaceWith = @ReplaceWith(...))
    public static final void Divider-9IZ8Weo(Modifier modifier, float thickness, long color, Composer $composer, int $changed, int i6) {
        float $i$f$getDp;
        int $dirty;
        Object $dirty2;
        Object modifier3;
        float modifier2;
        Object obj;
        float thickness3;
        long thickness2;
        int i2;
        int traceInProgress2;
        boolean traceInProgress;
        float str;
        int i5;
        long consume;
        int i;
        long l2;
        int changed;
        int defaultsInvalid;
        int str2;
        int i3;
        int i4;
        long l;
        final int i15 = i6;
        $i$f$getDp = 1562471785;
        final Composer restartGroup = $changed.startRestartGroup($i$f$getDp);
        ComposerKt.sourceInformation(restartGroup, "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)100@3659L5,108@3840L78:Divider.kt#uh7d8r");
        $dirty = i6;
        int i9 = obj22 & 1;
        if (i9 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i15 & 6 == 0) {
                i2 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj = modifier;
            }
        }
        traceInProgress2 = obj22 & 2;
        if (traceInProgress2 != 0) {
            $dirty |= 48;
            str = thickness;
        } else {
            if (i15 & 48 == 0) {
                i5 = restartGroup.changed(thickness) ? 32 : 16;
                $dirty |= i5;
            } else {
                str = thickness;
            }
        }
        if (i15 & 384 == 0) {
            if (obj22 & 4 == 0) {
                changed = restartGroup.changed(color) ? 256 : 128;
            } else {
                consume = color;
            }
            $dirty |= changed;
        } else {
            consume = color;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i15 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj;
                        }
                        if (traceInProgress2 != 0) {
                            thickness3 = DividerDefaults.INSTANCE.getThickness-D9Ej5fM();
                        } else {
                            thickness3 = str;
                        }
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                            l2 = consume;
                        } else {
                            l2 = consume;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                            modifier3 = obj;
                            thickness3 = str;
                            l2 = consume;
                        } else {
                            modifier3 = obj;
                            thickness3 = str;
                            l2 = consume;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart($i$f$getDp, $dirty, -1, "androidx.compose.material3.Divider (Divider.kt:101)");
                }
                restartGroup.startReplaceGroup(-433645095);
                ComposerKt.sourceInformation(restartGroup, "*104@3767L7");
                if (Dp.equals-impl0(thickness3, Dp.Companion.getHairline-D9Ej5fM())) {
                    int i12 = 0;
                    str = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i8 = 0;
                    $i$f$getDp = Dp.constructor-impl(i13 /= density);
                } else {
                    $i$f$getDp = thickness3;
                }
                restartGroup.endReplaceGroup();
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0, 1, 0), $i$f$getDp), l2, defaultsInvalid, 0, 2), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = $dirty;
                $dirty2 = modifier3;
                modifier2 = thickness3;
                thickness2 = l2;
            } else {
                restartGroup.skipToGroupEnd();
                i = $dirty;
                $dirty2 = obj;
                thickness2 = l;
                modifier2 = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $i$f$getDp = new DividerKt.Divider.1($dirty2, modifier2, thickness2, traceInProgress2, i15, obj22);
            endRestartGroup.updateScope((Function2)$i$f$getDp);
        }
    }

    public static final void HorizontalDivider-9IZ8Weo(Modifier modifier, float thickness, long color, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty;
        Object $dirty2;
        float modifier2;
        Object modifier3;
        Object obj;
        long thickness2;
        float thickness3;
        int i2;
        int iNSTANCE;
        boolean traceInProgress;
        int i4;
        int i3;
        int changed2;
        float color2;
        int i9;
        int i;
        int i8;
        int i5;
        boolean skipping;
        boolean defaultsInvalid;
        boolean changed;
        int rememberedValue;
        long l;
        int i7;
        int empty;
        Object anon;
        final int i17 = i6;
        traceInProgress2 = 75144485;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(HorizontalDivider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)52@2069L5,54@2134L220,54@2084L270:Divider.kt#uh7d8r");
        $dirty = i6;
        int i11 = obj22 & 1;
        if (i11 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i17 & 6 == 0) {
                i2 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj = modifier;
            }
        }
        iNSTANCE = obj22 & 2;
        i3 = 32;
        if (iNSTANCE != null) {
            $dirty |= 48;
            color2 = thickness;
        } else {
            if (i17 & 48 == 0) {
                i8 = restartGroup.changed(thickness) ? i3 : 16;
                $dirty |= i8;
            } else {
                color2 = thickness;
            }
        }
        rememberedValue = 256;
        if (i17 & 384 == 0) {
            if (obj22 & 4 == 0) {
                i5 = restartGroup.changed(color) ? rememberedValue : 128;
            } else {
                l = color;
            }
            $dirty |= i5;
        } else {
            l = color;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i17 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj;
                        }
                        if (iNSTANCE != null) {
                            thickness3 = DividerDefaults.INSTANCE.getThickness-D9Ej5fM();
                        } else {
                            thickness3 = color2;
                        }
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                            l = color2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                        }
                        modifier3 = obj;
                        thickness3 = color2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.HorizontalDivider (Divider.kt:54)");
                }
                i = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -873178642, "CC(remember):Divider.kt#9igjgp");
                skipping = 0;
                i4 = $dirty & 112 == i3 ? i : skipping;
                if (i18 ^= 384 > rememberedValue) {
                    if (!restartGroup.changed(l)) {
                        if ($dirty & 384 == rememberedValue) {
                        } else {
                            i = skipping;
                        }
                    } else {
                    }
                } else {
                }
                i3 = restartGroup;
                int i20 = 0;
                rememberedValue = i3.rememberedValue();
                i7 = 0;
                if (i4 |= i == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new DividerKt.HorizontalDivider.1.1(thickness3, l, obj12);
                        i3.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0, i, 0), thickness3), (Function1)anon, restartGroup, skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = $dirty;
                $dirty2 = modifier3;
                modifier2 = thickness3;
                thickness2 = l;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = color2;
                i9 = $dirty;
                $dirty2 = obj;
                thickness2 = l;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DividerKt.HorizontalDivider.2($dirty2, modifier2, thickness2, iNSTANCE, i17, obj22);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void VerticalDivider-9IZ8Weo(Modifier modifier, float thickness, long color, Composer $composer, int $changed, int i6) {
        int traceInProgress;
        int $dirty2;
        Object $dirty;
        float modifier3;
        Object modifier2;
        Object obj;
        long thickness3;
        float thickness2;
        int i4;
        int iNSTANCE;
        boolean traceInProgress2;
        int i9;
        int i3;
        int changed;
        float color2;
        int i8;
        int i7;
        int i;
        int i5;
        boolean skipping;
        boolean defaultsInvalid;
        boolean changed2;
        int rememberedValue;
        long l;
        int i2;
        int empty;
        Object anon;
        final int i17 = i6;
        traceInProgress = -1534852205;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(VerticalDivider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)81@3089L5,83@3154L221,83@3104L271:Divider.kt#uh7d8r");
        $dirty2 = i6;
        int i11 = obj22 & 1;
        if (i11 != 0) {
            $dirty2 |= 6;
            obj = modifier;
        } else {
            if (i17 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i4;
            } else {
                obj = modifier;
            }
        }
        iNSTANCE = obj22 & 2;
        i3 = 32;
        if (iNSTANCE != null) {
            $dirty2 |= 48;
            color2 = thickness;
        } else {
            if (i17 & 48 == 0) {
                i = restartGroup.changed(thickness) ? i3 : 16;
                $dirty2 |= i;
            } else {
                color2 = thickness;
            }
        }
        rememberedValue = 256;
        if (i17 & 384 == 0) {
            if (obj22 & 4 == 0) {
                i5 = restartGroup.changed(color) ? rememberedValue : 128;
            } else {
                l = color;
            }
            $dirty2 |= i5;
        } else {
            l = color;
        }
        if ($dirty2 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i17 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (iNSTANCE != null) {
                            thickness2 = DividerDefaults.INSTANCE.getThickness-D9Ej5fM();
                        } else {
                            thickness2 = color2;
                        }
                        if (obj22 & 4 != 0) {
                            $dirty2 &= -897;
                            l = color2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj22 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        modifier2 = obj;
                        thickness2 = color2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material3.VerticalDivider (Divider.kt:83)");
                }
                i7 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -662977123, "CC(remember):Divider.kt#9igjgp");
                skipping = 0;
                i9 = $dirty2 & 112 == i3 ? i7 : skipping;
                if (i18 ^= 384 > rememberedValue) {
                    if (!restartGroup.changed(l)) {
                        if ($dirty2 & 384 == rememberedValue) {
                        } else {
                            i7 = skipping;
                        }
                    } else {
                    }
                } else {
                }
                i3 = restartGroup;
                int i20 = 0;
                rememberedValue = i3.rememberedValue();
                i2 = 0;
                if (i9 |= i7 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new DividerKt.VerticalDivider.1.1(thickness2, l, obj12);
                        i3.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(modifier2, 0, i7, 0), thickness2), (Function1)anon, restartGroup, skipping);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i8 = $dirty2;
                $dirty = modifier2;
                modifier3 = thickness2;
                thickness3 = l;
            } else {
                restartGroup.skipToGroupEnd();
                modifier3 = color2;
                i8 = $dirty2;
                $dirty = obj;
                thickness3 = l;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DividerKt.VerticalDivider.2($dirty, modifier3, thickness3, iNSTANCE, i17, obj22);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
