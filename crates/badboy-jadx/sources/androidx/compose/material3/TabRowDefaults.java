package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.material3.tokens.SecondaryNavigationTabTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001d\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJD\u0010 \u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010!\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001d\u001a\u00020\t2\u0008\u0008\u0002\u0010\"\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%J0\u0010&\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001d\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010\u001fJ\u0012\u0010(\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010)\u001a\u00020*R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R \u0010\u0008\u001a\u00020\t8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u000cR \u0010\r\u001a\u00020\t8GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0002\u001a\u0004\u0008\u000f\u0010\u000cR\u0017\u0010\u0010\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000cR\u0017\u0010\u0012\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000cR\u0017\u0010\u0014\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000cR\u0017\u0010\u0016\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006+²\u0006\n\u0010,\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020\u0004X\u008a\u0084\u0002", d2 = {"Landroidx/compose/material3/TabRowDefaults;", "", "()V", "ScrollableTabRowEdgeStartPadding", "Landroidx/compose/ui/unit/Dp;", "getScrollableTabRowEdgeStartPadding-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "contentColor", "getContentColor$annotations", "getContentColor", "primaryContainerColor", "getPrimaryContainerColor", "primaryContentColor", "getPrimaryContentColor", "secondaryContainerColor", "getSecondaryContainerColor", "secondaryContentColor", "getSecondaryContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "PrimaryIndicator", "width", "shape", "Landroidx/compose/ui/graphics/Shape;", "PrimaryIndicator-10LGxhE", "(Landroidx/compose/ui/Modifier;FFJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "SecondaryIndicator", "SecondaryIndicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3_release", "currentTabWidth", "indicatorOffset"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabRowDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.TabRowDefaults INSTANCE;
    private static final float ScrollableTabRowEdgeStartPadding;
    static {
        TabRowDefaults tabRowDefaults = new TabRowDefaults();
        TabRowDefaults.INSTANCE = tabRowDefaults;
        final int i2 = 0;
        TabRowDefaults.ScrollableTabRowEdgeStartPadding = Dp.constructor-impl((float)i);
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContainerColor instead", replaceWith = @ReplaceWith(...))
    public static void getContainerColor$annotations() {
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContentColor instead", replaceWith = @ReplaceWith(...))
    public static void getContentColor$annotations() {
    }

    @Deprecated(message = "Use SecondaryIndicator instead.", replaceWith = @ReplaceWith(...))
    public final void Indicator-9IZ8Weo(Modifier modifier, float height, long color, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty;
        Object modifier2;
        Object obj;
        float height2;
        int i8;
        int token;
        boolean traceInProgress;
        long l2;
        float activeIndicatorColor;
        int i2;
        int i5;
        int defaultsInvalid;
        boolean changed;
        long l3;
        int i3;
        long l;
        int i7;
        int i;
        int i4;
        final int i17 = i6;
        traceInProgress2 = 1454716052;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Indicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1202@51501L11,1204@51588L69:TabRow.kt#uh7d8r");
        $dirty = i6;
        int i10 = obj22 & 1;
        if (i10 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i17 & 6 == 0) {
                i8 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i8;
            } else {
                obj = modifier;
            }
        }
        token = obj22 & 2;
        if (token != null) {
            $dirty |= 48;
            activeIndicatorColor = height;
        } else {
            if (i17 & 48 == 0) {
                i2 = restartGroup.changed(height) ? 32 : 16;
                $dirty |= i2;
            } else {
                activeIndicatorColor = height;
            }
        }
        if (i17 & 384 == 0) {
            if (obj22 & 4 == 0) {
                i5 = restartGroup.changed(color) ? 256 : 128;
            } else {
                l3 = color;
            }
            $dirty |= i5;
        } else {
            l3 = color;
        }
        final int i18 = 146;
        if ($dirty & 147 == i18) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i17 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (token != null) {
                            height2 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM();
                        } else {
                            height2 = activeIndicatorColor;
                        }
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                            l = token;
                        } else {
                            l = l3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                        }
                        modifier2 = obj;
                        height2 = activeIndicatorColor;
                        l = l3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1203)");
                }
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0, 1, 0), height2), l, i18, 0, 2), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l2 = l;
                i3 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = obj;
                height2 = activeIndicatorColor;
                l2 = l3;
                i3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowDefaults.Indicator.1(this, modifier2, height2, l2, activeIndicatorColor, i17, obj22);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final void PrimaryIndicator-10LGxhE(Modifier modifier, float width, float height, long color, Shape shape, Composer $composer, int $changed, int i8) {
        boolean traceInProgress2;
        int $dirty;
        Object modifier2;
        Object obj2;
        float width2;
        int i4;
        int activeIndicatorShape;
        boolean traceInProgress;
        float f2;
        float str;
        long l;
        int i;
        float f;
        Object height2;
        int i2;
        int i6;
        int changed;
        int i3;
        long l2;
        int color2;
        Object obj;
        int i5;
        int defaultsInvalid;
        final int i16 = i8;
        traceInProgress2 = -1895596205;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(PrimaryIndicator)P(2,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1222@52283L5,1225@52377L174:TabRow.kt#uh7d8r");
        $dirty = i8;
        int i7 = obj25 & 1;
        if (i7 != 0) {
            $dirty |= 6;
            obj2 = modifier;
        } else {
            if (i16 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i4;
            } else {
                obj2 = modifier;
            }
        }
        activeIndicatorShape = obj25 & 2;
        if (activeIndicatorShape != 0) {
            $dirty |= 48;
            str = width;
        } else {
            if (i16 & 48 == 0) {
                i = restartGroup.changed(width) ? 32 : 16;
                $dirty |= i;
            } else {
                str = width;
            }
        }
        int i14 = obj25 & 4;
        if (i14 != 0) {
            $dirty |= 384;
            f = height;
        } else {
            if (i16 & 384 == 0) {
                i2 = restartGroup.changed(height) ? 256 : 128;
                $dirty |= i2;
            } else {
                f = height;
            }
        }
        if (i16 & 3072 == 0) {
            if (obj25 & 8 == 0) {
                i6 = restartGroup.changed(color) ? 2048 : 1024;
            } else {
                l2 = color;
            }
            $dirty |= i6;
        } else {
            l2 = color;
        }
        i3 = obj25 & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            obj = $composer;
        } else {
            if (i16 & 24576 == 0) {
                i5 = restartGroup.changed($composer) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                obj = $composer;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i16 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj2;
                        }
                        if (activeIndicatorShape != 0) {
                            activeIndicatorShape = 0;
                            width2 = Dp.constructor-impl((float)i11);
                        } else {
                            width2 = str;
                        }
                        if (i14 != 0) {
                            f = activeIndicatorShape;
                        }
                        if (obj25 & 8 != 0) {
                            $dirty &= -7169;
                            l2 = activeIndicatorShape;
                        }
                        if (i3 != 0) {
                            obj = activeIndicatorShape;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj25 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        modifier2 = obj2;
                        width2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1224)");
                }
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.requiredWidth-3ABfNKs(SizeKt.requiredHeight-3ABfNKs(modifier2, f), width2), l2, obj12), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f2 = f;
                l = l2;
                height2 = obj;
                color2 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = obj2;
                width2 = str;
                f2 = f;
                l = l2;
                height2 = obj;
                color2 = $dirty;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TabRowDefaults.PrimaryIndicator.1(this, modifier2, width2, f2, l, i14, height2, i16, obj25);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final void SecondaryIndicator-9IZ8Weo(Modifier modifier, float height, long color, Composer $composer, int $changed, int i6) {
        int traceInProgress;
        int $dirty;
        Object modifier2;
        Object obj;
        float height2;
        int i5;
        int value;
        boolean traceInProgress2;
        long l3;
        float str;
        int i3;
        int i4;
        int defaultsInvalid;
        boolean changed;
        long l;
        int i2;
        long l2;
        int i7;
        int i;
        int i8;
        final int i16 = i6;
        traceInProgress = -1498258020;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SecondaryIndicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)1245@53068L5,1247@53090L69:TabRow.kt#uh7d8r");
        $dirty = i6;
        int i10 = obj22 & 1;
        if (i10 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i16 & 6 == 0) {
                i5 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i5;
            } else {
                obj = modifier;
            }
        }
        value = obj22 & 2;
        if (value != null) {
            $dirty |= 48;
            str = height;
        } else {
            if (i16 & 48 == 0) {
                i3 = restartGroup.changed(height) ? 32 : 16;
                $dirty |= i3;
            } else {
                str = height;
            }
        }
        if (i16 & 384 == 0) {
            if (obj22 & 4 == 0) {
                i4 = restartGroup.changed(color) ? 256 : 128;
            } else {
                l = color;
            }
            $dirty |= i4;
        } else {
            l = color;
        }
        final int i17 = 146;
        if ($dirty & 147 == i17) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i16 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (value != null) {
                            height2 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM();
                        } else {
                            height2 = str;
                        }
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                            l2 = value;
                        } else {
                            l2 = l;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj22 & 4 != 0) {
                            $dirty &= -897;
                        }
                        modifier2 = obj;
                        height2 = str;
                        l2 = l;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1246)");
                }
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0, 1, 0), height2), l2, i17, 0, 2), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l3 = l2;
                i2 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = obj;
                height2 = str;
                l3 = l;
                i2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TabRowDefaults.SecondaryIndicator.1(this, modifier2, height2, l3, str, i16, obj22);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2026555673;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1159@49855L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:1159)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final long getContentColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1163072359;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1175@50509L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:1175)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6);
    }

    public final long getPrimaryContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2069154037;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1163@50026L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:1163)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final long getPrimaryContentColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1410362619;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1179@50682L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1179)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6);
    }

    public final float getScrollableTabRowEdgeStartPadding-D9Ej5fM() {
        return TabRowDefaults.ScrollableTabRowEdgeStartPadding;
    }

    public final long getSecondaryContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1938007129;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1167@50203L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContainerColor> (TabRow.kt:1167)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final long getSecondaryContentColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1166419479;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1183@50861L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContentColor> (TabRow.kt:1183)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), $composer, 6);
    }

    public final Modifier tabIndicatorOffset(Modifier $this$tabIndicatorOffset, androidx.compose.material3.TabPosition currentTabPosition) {
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
