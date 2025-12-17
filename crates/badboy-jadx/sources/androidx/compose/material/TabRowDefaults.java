package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J0\u0010\u0017\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u000b\u0010\u0008R\u0019\u0010\u000c\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\r\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0006X\u008a\u0084\u0002", d2 = {"Landroidx/compose/material/TabRowDefaults;", "", "()V", "DividerOpacity", "", "DividerThickness", "Landroidx/compose/ui/unit/Dp;", "getDividerThickness-D9Ej5fM", "()F", "F", "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "material_release", "currentTabWidth", "indicatorOffset"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabRowDefaults {

    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;
    private static final float DividerThickness;
    public static final androidx.compose.material.TabRowDefaults INSTANCE;
    private static final float IndicatorHeight;
    private static final float ScrollableTabRowPadding;
    static {
        TabRowDefaults tabRowDefaults = new TabRowDefaults();
        TabRowDefaults.INSTANCE = tabRowDefaults;
        int i4 = 0;
        TabRowDefaults.DividerThickness = Dp.constructor-impl((float)i);
        int i5 = 0;
        TabRowDefaults.IndicatorHeight = Dp.constructor-impl((float)i2);
        int i6 = 0;
        TabRowDefaults.ScrollableTabRowPadding = Dp.constructor-impl((float)i3);
    }

    public final void Divider-9IZ8Weo(Modifier modifier, float thickness, long color, Composer $composer, int $changed, int i6) {
        boolean traceInProgress2;
        int $dirty;
        Object modifier2;
        boolean traceInProgress;
        Object obj2;
        Object thickness2;
        float f;
        int i11;
        float localContentColor;
        long l2;
        int changed2;
        int i;
        Object obj;
        boolean changed;
        long color2;
        long l;
        int color3;
        int i10;
        int defaultsInvalid;
        float i3;
        Object consume;
        long unbox-impl;
        int i9;
        int i8;
        int i7;
        int i4;
        int i12;
        int i2;
        int i5;
        final int i27 = i6;
        traceInProgress2 = 910934799;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)371@16495L7,373@16574L66:TabRow.kt#jmzs0o");
        $dirty = i6;
        int i15 = obj28 & 1;
        if (i15 != 0) {
            $dirty |= 6;
            thickness2 = modifier;
        } else {
            if (i27 & 6 == 0) {
                i11 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i11;
            } else {
                thickness2 = modifier;
            }
        }
        if (i27 & 48 == 0) {
            if (obj28 & 2 == 0) {
                changed2 = restartGroup.changed(thickness) ? 32 : 16;
            } else {
                localContentColor = thickness;
            }
            $dirty |= changed2;
        } else {
            localContentColor = thickness;
        }
        if (i27 & 384 == 0) {
            if (obj28 & 4 == 0) {
                i = restartGroup.changed(color) ? 256 : 128;
            } else {
                color2 = color;
            }
            $dirty |= i;
        } else {
            color2 = color;
        }
        if (obj28 & 8 != 0) {
            $dirty |= 3072;
            obj = this;
        } else {
            if (i27 & 3072 == 0) {
                i10 = restartGroup.changed(this) ? 2048 : 1024;
                $dirty |= i10;
            } else {
                obj = this;
            }
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i27 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i15 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = thickness2;
                        }
                        if (obj28 & 2 != 0) {
                            thickness2 = TabRowDefaults.DividerThickness;
                            $dirty &= -113;
                        } else {
                            thickness2 = localContentColor;
                        }
                        if (obj28 & 4 != 0) {
                            defaultsInvalid = 6;
                            int i28 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty &= -897;
                            i3 = thickness2;
                            l = copy-wmQWz5c$default;
                            color2 = modifier2;
                        } else {
                            i3 = thickness2;
                            l = color2;
                            color2 = modifier2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj28 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj28 & 4 != 0) {
                            $dirty &= -897;
                        }
                        i3 = localContentColor;
                        l = color2;
                        color2 = thickness2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.TabRowDefaults.Divider (TabRow.kt:372)");
                }
                DividerKt.Divider-oMI9zvI(color2, l, defaultsInvalid, i3, 0, restartGroup, i14 | i20);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = color2;
                l2 = l;
                f = i3;
                color3 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = thickness2;
                f = localContentColor;
                l2 = color2;
                color3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowDefaults.Divider.1(this, obj2, f, l2, obj, i27, obj28);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final void Indicator-9IZ8Weo(Modifier modifier, float height, long color, Composer $composer, int $changed, int i6) {
        boolean traceInProgress2;
        int $dirty;
        Object modifier2;
        Object obj;
        float height2;
        int i2;
        float unbox-impl;
        boolean traceInProgress;
        long l3;
        int changed2;
        int i;
        int i3;
        int skipping;
        int defaultsInvalid;
        boolean changed;
        int i4;
        long l;
        int i5;
        long l2;
        Object consume;
        String str;
        int i8;
        int i7;
        final int i19 = i6;
        traceInProgress2 = 1499002201;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Indicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)388@17083L7,390@17107L142:TabRow.kt#jmzs0o");
        $dirty = i6;
        int i10 = obj22 & 1;
        if (i10 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i19 & 6 == 0) {
                i2 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj = modifier;
            }
        }
        if (i19 & 48 == 0) {
            if (obj22 & 2 == 0) {
                changed2 = restartGroup.changed(height) ? 32 : 16;
            } else {
                unbox-impl = height;
            }
            $dirty |= changed2;
        } else {
            unbox-impl = height;
        }
        if (i19 & 384 == 0) {
            if (obj22 & 4 == 0) {
                i = restartGroup.changed(color) ? 256 : 128;
            } else {
                l = color;
            }
            $dirty |= i;
        } else {
            l = color;
        }
        if (obj22 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i19 & 3072 == 0) {
                i3 = restartGroup.changed(this) ? 2048 : 1024;
                $dirty |= i3;
            }
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i19 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (obj22 & 2 != 0) {
                            height2 = TabRowDefaults.IndicatorHeight;
                            $dirty &= -113;
                        } else {
                            height2 = unbox-impl;
                        }
                        if (obj22 & 4 != 0) {
                            defaultsInvalid = 6;
                            i4 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty &= -897;
                            l2 = unbox-impl;
                        } else {
                            l2 = l;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj22 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                        }
                        modifier2 = obj;
                        height2 = unbox-impl;
                        l2 = l;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.TabRowDefaults.Indicator (TabRow.kt:389)");
                }
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0, 1, 0), height2), l2, consume, 0, 2), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l3 = l2;
                i5 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = obj;
                height2 = unbox-impl;
                l3 = l;
                i5 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowDefaults.Indicator.1(this, modifier2, height2, l3, skipping, i19, obj22);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final float getDividerThickness-D9Ej5fM() {
        return TabRowDefaults.DividerThickness;
    }

    public final float getIndicatorHeight-D9Ej5fM() {
        return TabRowDefaults.IndicatorHeight;
    }

    public final float getScrollableTabRowPadding-D9Ej5fM() {
        return TabRowDefaults.ScrollableTabRowPadding;
    }

    public final Modifier tabIndicatorOffset(Modifier $this$tabIndicatorOffset, androidx.compose.material.TabPosition currentTabPosition) {
        kotlin.jvm.functions.Function1 noInspectorInfo;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new TabRowDefaults.tabIndicatorOffset$$inlined.debugInspectorInfo.1(currentTabPosition);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        TabRowDefaults.tabIndicatorOffset.2 $i$f$debugInspectorInfo = new TabRowDefaults.tabIndicatorOffset.2(currentTabPosition);
        return ComposedModifierKt.composed($this$tabIndicatorOffset, noInspectorInfo, (Function3)$i$f$debugInspectorInfo);
    }
}
