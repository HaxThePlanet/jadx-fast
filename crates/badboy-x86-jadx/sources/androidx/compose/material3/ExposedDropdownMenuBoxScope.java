package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOrigin.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002JU\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00080\u0012¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u0015H\u0007¢\u0006\u0002\u0010\u0016J\u0098\u0001\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0017\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00080\u0012¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J¢\u0001\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010#\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00080\u0012¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%J\u0016\u0010&\u001a\u00020\u000e*\u00020\u000e2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\nH&J\u000c\u0010'\u001a\u00020\u000e*\u00020\u000eH\u0007J(\u0010'\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010(\u001a\u00020\u00042\u0008\u0008\u0002\u0010)\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+R\u0018\u0010\u0003\u001a\u00020\u0004X \u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0001,\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006-", d2 = {"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "()V", "anchorType", "Landroidx/compose/material3/MenuAnchorType;", "getAnchorType-Mg6Rgbw$material3_release", "()Ljava/lang/String;", "ExposedDropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "matchTextFieldWidth", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "exposedDropdownSize", "menuAnchor", "type", "enabled", "menuAnchor-fsE2BvY", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ExposedDropdownMenuBoxScope {

    public static final int $stable;
    static {
    }

    public ExposedDropdownMenuBoxScope(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static Modifier exposedDropdownSize$default(androidx.compose.material3.ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            final int obj4 = 1;
            if (i4 &= obj4 != 0) {
                obj2 = obj4;
            }
            return exposedDropdownMenuBoxScope.exposedDropdownSize(modifier2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
        throw obj0;
    }

    public static Modifier menuAnchor-fsE2BvY$default(androidx.compose.material3.ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Modifier modifier2, String string3, boolean z4, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 2 != 0) {
                obj3 = 1;
            }
            return exposedDropdownMenuBoxScope.menuAnchor-fsE2BvY(modifier2, string3, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-fsE2BvY");
        throw obj0;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with customization options parameters.")
    public final void ExposedDropdownMenu(boolean expanded, Function0 onDismissRequest, Modifier modifier, ScrollState scrollState, Function3 content, Composer $composer, int $changed, int i8) {
        int traceInProgress;
        Object restartGroup;
        int $dirty;
        int i9;
        int i10;
        int i11;
        Object modifier2;
        boolean traceInProgress2;
        Object rememberScrollState;
        int i;
        Object obj2;
        int changed;
        Object obj5;
        int i5;
        Object obj3;
        boolean z;
        int i7;
        Object obj;
        int i3;
        boolean skipping;
        int defaultsInvalid;
        int i2;
        int i4;
        Shape shape;
        long containerColor;
        float tonalElevation-D9Ej5fM;
        float shadowElevation-D9Ej5fM;
        int i14;
        Object obj4;
        Composer composer;
        int i12;
        int i6;
        int i13;
        final int i33 = $changed;
        traceInProgress = 1729549851;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ExposedDropdownMenu)P(1,3,2,4)449@20337L21,458@20677L5,459@20726L14,452@20429L498:ExposedDropdownMenu.android.kt#uh7d8r");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
            z = expanded;
        } else {
            if (i33 & 6 == 0) {
                i9 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty |= i9;
            } else {
                z = expanded;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
            obj = onDismissRequest;
        } else {
            if (i33 & 48 == 0) {
                i10 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty |= i10;
            } else {
                obj = onDismissRequest;
            }
        }
        i11 = i8 & 4;
        if (i11 != 0) {
            $dirty |= 384;
            rememberScrollState = modifier;
        } else {
            if (i33 & 384 == 0) {
                i = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i;
            } else {
                rememberScrollState = modifier;
            }
        }
        if (i33 & 3072 == 0) {
            if (i8 & 8 == 0) {
                changed = restartGroup.changed(scrollState) ? 2048 : 1024;
            } else {
                obj2 = scrollState;
            }
            $dirty |= changed;
        } else {
            obj2 = scrollState;
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
            obj5 = content;
        } else {
            if (i33 & 24576 == 0) {
                i5 = restartGroup.changedInstance(content) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                obj5 = content;
            }
        }
        i3 = 196608;
        if (i8 & 32 != 0) {
            $dirty |= i3;
            obj3 = this;
        } else {
            if (i33 & i3 == 0) {
                i3 = restartGroup.changed(this) ? 131072 : 65536;
                $dirty |= i3;
            } else {
                obj3 = this;
            }
        }
        if (i36 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i33 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = rememberScrollState;
                        }
                        if (i8 & 8 != 0) {
                            int i28 = 0;
                            $dirty &= -7169;
                            skipping = modifier2;
                            i2 = rememberScrollState;
                        } else {
                            skipping = modifier2;
                            i2 = obj2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        skipping = rememberScrollState;
                        i2 = obj2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:452)");
                }
                int i21 = 6;
                obj3.ExposedDropdownMenu-vNxi1II(z, obj, skipping, i2, true, MenuDefaults.INSTANCE.getShape(restartGroup, i21), MenuDefaults.INSTANCE.getContainerColor(restartGroup, i21), obj16, MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM(), MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM(), 0, obj5, restartGroup, i18 | i25, i20 | i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                rememberScrollState = skipping;
                obj2 = i2;
                i7 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                i7 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.5(this, expanded, onDismissRequest, rememberScrollState, obj2, content, i33, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper MenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    public final void ExposedDropdownMenu-kbRbctU(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, boolean focusable, boolean matchTextFieldWidth, Shape shape, long containerColor, float tonalElevation, float shadowElevation, BorderStroke border, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i16) {
        int $dirty15;
        int skipping;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        int i26;
        float f3;
        float f2;
        Object obj3;
        Object obj4;
        Object obj5;
        int i13;
        ScopeUpdateScope endRestartGroup;
        int i4;
        float tonalElevation2;
        boolean traceInProgress;
        Object $dirty1;
        int $dirty2;
        Object $dirty;
        int $dirty13;
        Object $dirty12;
        boolean z3;
        int i18;
        Object scrollState2;
        boolean z2;
        Object obj6;
        Object focusable2;
        int focusable3;
        int i25;
        Object obj2;
        long l;
        boolean z;
        Object shape2;
        float f;
        int i14;
        float f4;
        int shadowElevation2;
        int iNSTANCE;
        int iNSTANCE2;
        int i;
        int obj;
        int i5;
        long containerColor2;
        int i8;
        int changedInstance;
        int i7;
        int changed3;
        int i17;
        int i9;
        int i12;
        int i24;
        int i11;
        int $dirty14;
        int changed2;
        int i3;
        int changed4;
        int i15;
        int i2;
        int i19;
        int i10;
        int i6;
        boolean changed;
        float f5;
        int i23;
        Composer composer2;
        Composer composer;
        int i22;
        int i20;
        int i21;
        ScopeUpdateScope scopeUpdateScope;
        int obj48;
        i8 = $changed1;
        int i27 = i16;
        i26 = obj51;
        $dirty1 = $changed.startRestartGroup(366140493);
        ComposerKt.sourceInformation($dirty1, "C(ExposedDropdownMenu)P(3,7,6,8,4,5,10,1:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp)414@19050L21,417@19189L5,418@19241L14,424@19482L463:ExposedDropdownMenu.android.kt#uh7d8r");
        $dirty2 = $changed1;
        $dirty13 = i16;
        if (i26 & 1 != 0) {
            $dirty2 |= 6;
            z3 = expanded;
        } else {
            if (i8 & 6 == 0) {
                i25 = $dirty1.changed(expanded) ? 4 : 2;
                $dirty2 |= i25;
            } else {
                z3 = expanded;
            }
        }
        if (i26 & 2 != 0) {
            $dirty2 |= 48;
            obj2 = onDismissRequest;
        } else {
            if (i8 & 48 == 0) {
                i14 = $dirty1.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty2 |= i14;
            } else {
                obj2 = onDismissRequest;
            }
        }
        shadowElevation2 = i26 & 4;
        if (shadowElevation2 != 0) {
            $dirty2 |= 384;
            scrollState2 = modifier;
        } else {
            if (i8 & 384 == 0) {
                changedInstance = $dirty1.changed(modifier) ? 256 : 128;
                $dirty2 |= changedInstance;
            } else {
                scrollState2 = modifier;
            }
        }
        if (i8 & 3072 == 0) {
            if (i26 & 8 == 0) {
                changed3 = $dirty1.changed(scrollState) ? 2048 : 1024;
            } else {
                obj6 = scrollState;
            }
            $dirty2 |= changed3;
        } else {
            obj6 = scrollState;
        }
        i17 = i26 & 32;
        i9 = 196608;
        if (i17 != 0) {
            $dirty2 |= i9;
            z = matchTextFieldWidth;
        } else {
            if (i8 & i9 == 0) {
                i24 = $dirty1.changed(matchTextFieldWidth) ? 131072 : 65536;
                $dirty2 |= i24;
            } else {
                z = matchTextFieldWidth;
            }
        }
        if (i8 & i85 == 0) {
            if (i26 & 64 == 0) {
                changed2 = $dirty1.changed(shape) ? 1048576 : 524288;
            } else {
                shape2 = shape;
            }
            $dirty2 |= changed2;
        } else {
            shape2 = shape;
        }
        if (i8 & i86 == 0) {
            if (i26 & 128 == 0) {
                changed4 = $dirty1.changed(containerColor) ? 8388608 : 4194304;
            } else {
                containerColor2 = containerColor;
            }
            $dirty2 |= changed4;
        } else {
            containerColor2 = containerColor;
        }
        i5 = i26 & 256;
        i15 = 100663296;
        if (i5 != 0) {
            $dirty2 |= i15;
            f3 = shadowElevation;
        } else {
            if ($changed1 & i15 == 0) {
                i2 = $dirty1.changed(shadowElevation) ? 67108864 : 33554432;
                $dirty2 |= i2;
            } else {
                f3 = shadowElevation;
            }
        }
        int i45 = i26 & 512;
        int i87 = 805306368;
        if (i45 != 0) {
            $dirty2 |= i87;
            i19 = i45;
            f2 = border;
        } else {
            if ($changed1 & i87 == 0) {
                i19 = i45;
                i10 = $dirty1.changed(border) ? 536870912 : 268435456;
                $dirty2 |= i10;
            } else {
                i19 = i45;
                f2 = border;
            }
        }
        int i46 = i26 & 1024;
        if (i46 != 0) {
            $dirty13 |= 6;
            i6 = i46;
            obj3 = content;
        } else {
            if (i27 & 6 == 0) {
                i6 = i46;
                changedInstance = $dirty1.changed(content) ? 4 : 2;
                $dirty13 |= changedInstance;
            } else {
                i6 = i46;
                obj3 = content;
            }
        }
        if (i26 & 2048 != 0) {
            $dirty13 |= 48;
            obj4 = $composer;
        } else {
            if (i27 & 48 == 0) {
                i9 = $dirty1.changedInstance($composer) ? 32 : 16;
                $dirty13 |= i9;
            } else {
                obj4 = $composer;
            }
        }
        if (i26 & 4096 != 0) {
            $dirty13 |= 384;
            obj5 = this;
        } else {
            if (i27 & 384 == 0) {
                i3 = $dirty1.changed(this) ? 256 : 128;
                $dirty13 |= i3;
            } else {
                obj5 = this;
            }
        }
        if ($dirty2 & i7 == 306775186 && $dirty13 & 147 == 146) {
            if ($dirty13 & 147 == 146) {
                if (!$dirty1.getSkipping()) {
                    $dirty1.startDefaults();
                    tonalElevation2 = -3670017;
                    if ($changed1 & 1 != 0) {
                        if ($dirty1.getDefaultsInvalid()) {
                            if (shadowElevation2 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = scrollState2;
                            }
                            if (i26 & 8 != 0) {
                                int i72 = 0;
                                scrollState2 = ScrollKt.rememberScrollState(i72, $dirty1, i72, 1);
                                $dirty2 &= -7169;
                            } else {
                                scrollState2 = obj6;
                            }
                            focusable3 = i26 & 16 != 0 ? 1 : focusable;
                            if (i17 != 0) {
                                z = 1;
                            }
                            i4 = 6;
                            if (i26 & 64 != 0) {
                                shape2 = MenuDefaults.INSTANCE.getShape($dirty1, i4);
                                $dirty2 &= obj48;
                            }
                            if (i26 & 128 != 0) {
                                containerColor2 = MenuDefaults.INSTANCE.getContainerColor($dirty1, i4);
                                $dirty2 &= i4;
                            }
                            if (i5 != 0) {
                                tonalElevation2 = MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = shadowElevation;
                            }
                            if (i19 != 0) {
                                shadowElevation2 = MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = border;
                            }
                            if (i6 != 0) {
                                i11 = modifier3;
                                changed = tonalElevation2;
                                i3 = scrollState2;
                                changed4 = z;
                                i15 = shape2;
                                f5 = shadowElevation2;
                                i23 = i5;
                                i19 = containerColor2;
                                modifier2 = 366140493;
                            } else {
                                i23 = content;
                                i11 = modifier3;
                                changed = tonalElevation2;
                                i3 = scrollState2;
                                changed4 = z;
                                i15 = shape2;
                                f5 = shadowElevation2;
                                i19 = containerColor2;
                                modifier2 = 366140493;
                            }
                        } else {
                            $dirty1.skipToGroupEnd();
                            if (i26 & 8 != 0) {
                                $dirty2 &= -7169;
                            }
                            if (i26 & 64 != 0) {
                                $dirty2 &= tonalElevation2;
                            }
                            if (i26 & 128 != 0) {
                                changed = shadowElevation;
                                f5 = border;
                                i23 = content;
                                $dirty2 = i43;
                                i11 = scrollState2;
                                i3 = obj6;
                                changed4 = z;
                                i15 = shape2;
                                i19 = containerColor2;
                                modifier2 = 366140493;
                                focusable3 = focusable;
                            } else {
                                changed = shadowElevation;
                                f5 = border;
                                i23 = content;
                                i11 = scrollState2;
                                i3 = obj6;
                                changed4 = z;
                                i15 = shape2;
                                i19 = containerColor2;
                                modifier2 = 366140493;
                                focusable3 = focusable;
                            }
                        }
                    } else {
                    }
                    $dirty1.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(modifier2, $dirty2, $dirty13, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:424)");
                    }
                    this.ExposedDropdownMenu-vNxi1II(z3, obj2, i11, i3, changed4, i15, i19, i6, changed, f5, i23, $composer, $dirty1, i36 | i63, i38 | i13);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i12 = $dirty2;
                    $dirty15 = $dirty13;
                    i18 = focusable3;
                    $dirty = i11;
                    $dirty12 = i3;
                    z2 = changed4;
                    focusable2 = i15;
                    l = i19;
                    f = changed;
                    f4 = f5;
                    obj = i23;
                } else {
                    $dirty1.skipToGroupEnd();
                    i18 = focusable;
                    f4 = border;
                    obj = content;
                    composer = $dirty1;
                    i12 = $dirty2;
                    $dirty15 = $dirty13;
                    $dirty = scrollState2;
                    $dirty12 = obj6;
                    z2 = z;
                    focusable2 = shape2;
                    l = containerColor2;
                    f = shadowElevation;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty14 = i68;
            $dirty15 = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.4(this, expanded, onDismissRequest, $dirty, $dirty12, i18, z2, focusable2, l, z, f, f4, obj, $composer, $changed1, i16, i26);
            endRestartGroup.updateScope((Function2)$dirty15);
        } else {
            $dirty14 = $dirty15;
        }
    }

    public final void ExposedDropdownMenu-vNxi1II(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, boolean matchTextFieldWidth, Shape shape, long containerColor, float tonalElevation, float shadowElevation, BorderStroke border, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        int skipping;
        int defaultsInvalid;
        Object modifier2;
        boolean traceInProgress;
        Object $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1;
        Object mutableStateOf$default;
        int i13;
        int $dirty14;
        float i16;
        float f3;
        Object obj8;
        Object obj10;
        Object obj;
        int invalid$iv2;
        Object $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$1;
        int valueOf;
        boolean booleanValue;
        int invalid$iv;
        ScopeUpdateScope endRestartGroup;
        boolean $dirty12;
        Object restartGroup;
        int $dirty;
        Object $dirty2;
        int $dirty1;
        Object $dirty15;
        int i20;
        Object obj7;
        boolean z3;
        boolean z;
        int str3;
        Object obj2;
        float tonalElevation2;
        long l2;
        Object density;
        long containerColor2;
        Object topWindowInsets;
        float f4;
        int i18;
        String str;
        int composer;
        float f5;
        Object shadowElevation2;
        int i19;
        int i12;
        int i5;
        Object $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$keyboardSignalState$1;
        Object consume;
        Object empty;
        int i8;
        int i17;
        int i6;
        Object exposedDropdownMenuPositionProvider;
        String str2;
        int changed2;
        int neverEqualPolicy;
        int rememberedValue;
        int i4;
        int i7;
        int i3;
        Composer.Companion companion2;
        int changed4;
        int companion;
        Composer composer2;
        int i14;
        int i10;
        int changed;
        int $dirty13;
        int i11;
        int i2;
        int i21;
        int i;
        int i9;
        int changed3;
        androidx.compose.material3.ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope;
        Object obj5;
        boolean z2;
        Object obj12;
        Object obj3;
        Object obj6;
        Object obj4;
        long l;
        float f;
        float f2;
        int obj9;
        Object obj11;
        ScopeUpdateScope scopeUpdateScope;
        int obj41;
        int obj42;
        int obj43;
        Object obj44;
        int obj45;
        androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu.popupPositionProvider.1.1 obj46;
        int obj47;
        int obj48;
        Object obj49;
        int obj51;
        $dirty12 = expanded;
        final int i68 = $changed1;
        int i22 = obj54;
        restartGroup = $changed.startRestartGroup(720925481);
        ComposerKt.sourceInformation(restartGroup, "C(ExposedDropdownMenu)P(3,6,5,7,4,9,1:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp)336@15550L21,338@15654L5,339@15706L14,347@16155L53,348@16238L7,349@16281L7,350@16332L10,357@16596L42,361@16795L51,363@16903L486,377@17583L27,378@17626L587,374@17403L810:ExposedDropdownMenu.android.kt#uh7d8r");
        $dirty = $changed1;
        $dirty1 = i15;
        if (i22 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i68 & 6 == 0) {
                i20 = restartGroup.changed($dirty12) ? 4 : 2;
                $dirty |= i20;
            }
        }
        if (i22 & 2 != 0) {
            $dirty |= 48;
            obj7 = onDismissRequest;
        } else {
            if (i68 & 48 == 0) {
                i18 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty |= i18;
            } else {
                obj7 = onDismissRequest;
            }
        }
        int i54 = i22 & 4;
        if (i54 != 0) {
            $dirty |= 384;
            shadowElevation2 = modifier;
        } else {
            if (i68 & 384 == 0) {
                i6 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i6;
            } else {
                shadowElevation2 = modifier;
            }
        }
        if (i68 & 3072 == 0) {
            if (i22 & 8 == 0) {
                changed2 = restartGroup.changed(scrollState) ? 2048 : 1024;
            } else {
                exposedDropdownMenuPositionProvider = scrollState;
            }
            $dirty |= changed2;
        } else {
            exposedDropdownMenuPositionProvider = scrollState;
        }
        neverEqualPolicy = i22 & 16;
        if (neverEqualPolicy != 0) {
            $dirty |= 24576;
            z = matchTextFieldWidth;
        } else {
            if (i68 & 24576 == 0) {
                i4 = restartGroup.changed(matchTextFieldWidth) ? 16384 : 8192;
                $dirty |= i4;
            } else {
                z = matchTextFieldWidth;
            }
        }
        if (i68 & i69 == 0) {
            if (i22 & 32 == 0) {
                changed4 = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                density = shape;
            }
            $dirty |= changed4;
        } else {
            density = shape;
        }
        if (i68 & i70 == 0) {
            if (i22 & 64 == 0) {
                i14 = i54;
                changed = restartGroup.changed(containerColor) ? 1048576 : 524288;
            } else {
                i14 = i54;
                containerColor2 = containerColor;
            }
            $dirty |= changed;
        } else {
            i14 = i54;
            containerColor2 = containerColor;
        }
        tonalElevation2 = i22 & 128;
        i11 = 12582912;
        if (tonalElevation2 != 0) {
            $dirty |= i11;
            i16 = shadowElevation;
        } else {
            if (i68 & i11 == 0) {
                i2 = restartGroup.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty |= i2;
            } else {
                i16 = shadowElevation;
            }
        }
        int i30 = i22 & 256;
        int i71 = 100663296;
        if (i30 != 0) {
            $dirty |= i71;
            i21 = i30;
            f3 = border;
        } else {
            if (i68 & i71 == 0) {
                i21 = i30;
                i = restartGroup.changed(border) ? 67108864 : 33554432;
                $dirty |= i;
            } else {
                i21 = i30;
                f3 = border;
            }
        }
        int i31 = i22 & 512;
        int i73 = 805306368;
        if (i31 != 0) {
            $dirty |= i73;
            i9 = i31;
            obj8 = content;
        } else {
            if (i68 & i73 == 0) {
                i9 = i31;
                changed3 = restartGroup.changed(content) ? 536870912 : 268435456;
                $dirty |= changed3;
            } else {
                i9 = i31;
                obj8 = content;
            }
        }
        if (i22 & 1024 != 0) {
            $dirty1 |= 6;
            obj10 = $composer;
        } else {
            if (i15 & 6 == 0) {
                changed3 = restartGroup.changedInstance($composer) ? 4 : 2;
                $dirty1 |= changed3;
            } else {
                obj10 = $composer;
            }
        }
        if (i22 & 2048 != 0) {
            $dirty1 |= 48;
            obj = this;
        } else {
            if (i15 & 48 == 0) {
                i7 = restartGroup.changed(this) ? 32 : 16;
                $dirty1 |= i7;
            } else {
                obj = this;
            }
        }
        if ($dirty & i3 == 306783378 && $dirty1 & 19 == 18) {
            if ($dirty1 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (i68 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i14 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = shadowElevation2;
                            }
                            if (obj54 & 8 != 0) {
                                i19 = 0;
                                exposedDropdownMenuPositionProvider = ScrollKt.rememberScrollState(i19, restartGroup, i19, 1);
                                $dirty &= -7169;
                            }
                            if (neverEqualPolicy != 0) {
                                z = 1;
                            }
                            if (obj54 & 32 != 0) {
                                density = MenuDefaults.INSTANCE.getShape(restartGroup, 6);
                                $dirty &= i12;
                            }
                            if (obj54 & 64 != 0) {
                                containerColor2 = MenuDefaults.INSTANCE.getContainerColor(restartGroup, 6);
                                $dirty &= i5;
                            }
                            if (tonalElevation2 != 0) {
                                tonalElevation2 = MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = shadowElevation;
                            }
                            if (i21 != 0) {
                                shadowElevation2 = MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = border;
                            }
                            if (i9 != 0) {
                                obj5 = modifier2;
                                z2 = z;
                                f = tonalElevation2;
                                obj4 = density;
                                l = containerColor2;
                                f2 = shadowElevation2;
                                obj6 = exposedDropdownMenuPositionProvider;
                                obj9 = neverEqualPolicy;
                            } else {
                                obj9 = content;
                                obj5 = modifier2;
                                z2 = z;
                                f = tonalElevation2;
                                obj4 = density;
                                l = containerColor2;
                                f2 = shadowElevation2;
                                obj6 = exposedDropdownMenuPositionProvider;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (obj54 & 8 != 0) {
                                $dirty &= -7169;
                            }
                            if (obj54 & 32 != 0) {
                                $dirty &= i13;
                            }
                            if (obj54 & 64 != 0) {
                                f = shadowElevation;
                                f2 = border;
                                obj9 = content;
                                $dirty = modifier2;
                                z2 = z;
                                obj4 = density;
                                l = containerColor2;
                                obj5 = shadowElevation2;
                                obj6 = exposedDropdownMenuPositionProvider;
                            } else {
                                f = shadowElevation;
                                f2 = border;
                                obj9 = content;
                                z2 = z;
                                obj4 = density;
                                l = containerColor2;
                                obj5 = shadowElevation2;
                                obj6 = exposedDropdownMenuPositionProvider;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(720925481, $dirty, $dirty1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:344)");
                    }
                    str3 = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 321492941, str3);
                    int i24 = 0;
                    Composer composer4 = restartGroup;
                    int i50 = 0;
                    Object rememberedValue3 = composer4.rememberedValue();
                    int i55 = 0;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        int i64 = 0;
                        composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy()));
                    } else {
                        $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$keyboardSignalState$1 = rememberedValue3;
                    }
                    Object invalid$iv3 = $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$keyboardSignalState$1;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i51 = 0;
                    int i52 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i53 = 0;
                    int i57 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Object this_$iv2 = consume;
                    topWindowInsets = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, restartGroup, 6).getTop((Density)this_$iv2);
                    restartGroup.startReplaceGroup(321499814);
                    ComposerKt.sourceInformation(restartGroup, "353@16432L36,353@16396L72");
                    if ($dirty12) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 321501788, str3);
                        int i60 = 0;
                        consume = restartGroup;
                        str2 = 0;
                        rememberedValue = consume.rememberedValue();
                        i3 = 0;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            obj41 = i34;
                            $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.1.1((MutableState)invalid$iv3);
                            consume.updateRememberedValue((Function0)$i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$1);
                        } else {
                            $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$1 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ExposedDropdownMenu_androidKt.access$SoftKeyboardListener((View)restartGroup.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView()), this_$iv2, (Function0)$i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$1, restartGroup, 384);
                    }
                    restartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 321507042, str3);
                    valueOf = 0;
                    composer = restartGroup;
                    i8 = 0;
                    exposedDropdownMenuPositionProvider = composer.rememberedValue();
                    neverEqualPolicy = 0;
                    if (exposedDropdownMenuPositionProvider == Composer.Companion.getEmpty()) {
                        obj41 = i26;
                        obj42 = valueOf;
                        $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1 = new MutableTransitionState(false);
                        composer.updateRememberedValue($i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1);
                    } else {
                        obj42 = valueOf;
                        $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1 = exposedDropdownMenuPositionProvider;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    (MutableTransitionState)$i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1.setTargetState(Boolean.valueOf($dirty12));
                    if (!(Boolean)$i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1.getCurrentState().booleanValue()) {
                        if ((Boolean)$i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1.getTargetState().booleanValue()) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 321513419, str3);
                            invalid$iv = 0;
                            Composer composer5 = restartGroup;
                            empty = 0;
                            exposedDropdownMenuPositionProvider = composer5.rememberedValue();
                            neverEqualPolicy = 0;
                            if (exposedDropdownMenuPositionProvider == Composer.Companion.getEmpty()) {
                                obj41 = i25;
                                obj42 = invalid$iv;
                                i3 = $dirty;
                                composer5.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), 0, 2, 0));
                            } else {
                                obj42 = invalid$iv;
                                i3 = $dirty;
                                mutableStateOf$default = exposedDropdownMenuPositionProvider;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 321517310, str3);
                            changed5 |= changed6;
                            Composer composer3 = restartGroup;
                            int i43 = 0;
                            Object rememberedValue2 = composer3.rememberedValue();
                            int i61 = 0;
                            if (i38 == 0) {
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    empty = 0;
                                    obj51 = i38;
                                    ExposedDropdownMenuBoxScope.ExposedDropdownMenu.popupPositionProvider.1.1 invalid$iv4 = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.popupPositionProvider.1.1((MutableState)mutableStateOf$default);
                                    obj42 = this_$iv2;
                                    obj43 = topWindowInsets;
                                    obj41 = exposedDropdownMenuPositionProvider;
                                    super(obj42, obj43, (State)invalid$iv3, 0, (Function2)invalid$iv4, 8, 0);
                                    invalid$iv2 = obj42;
                                    density = obj43;
                                    composer3.updateRememberedValue(obj41);
                                } else {
                                    obj51 = i38;
                                    invalid$iv2 = this_$iv2;
                                    density = topWindowInsets;
                                    topWindowInsets = rememberedValue2;
                                }
                            } else {
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            changed3 = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.2(this, obj5, z2, $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1, mutableStateOf$default, obj6, obj4, l, obj32, f, f2, obj9, $composer);
                            obj45 = restartGroup;
                            AndroidPopup_androidKt.Popup((PopupPositionProvider)(ExposedDropdownMenuPositionProvider)topWindowInsets, obj7, ExposedDropdownMenuDefaults.INSTANCE.popupProperties-pR6Bxps$material3_release(getAnchorType-Mg6Rgbw$material3_release(), restartGroup, 48), (Function2)ComposableLambdaKt.rememberComposableLambda(-1082380263, true, changed3, restartGroup, 54), obj45, i49 |= 3072, 0);
                            composer2 = obj45;
                        } else {
                            obj12 = $i$a$CacheExposedDropdownMenuBoxScope$ExposedDropdownMenu$expandedState$1;
                            composer2 = restartGroup;
                            i3 = $dirty;
                            invalid$iv2 = this_$iv2;
                            density = topWindowInsets;
                        }
                    } else {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty14 = $dirty1;
                    i10 = i3;
                    $dirty2 = obj5;
                    z3 = z2;
                    $dirty15 = obj6;
                    obj2 = obj4;
                    l2 = l;
                    f4 = f;
                    f5 = f2;
                    i17 = obj9;
                } else {
                    restartGroup.skipToGroupEnd();
                    composer2 = restartGroup;
                    i10 = $dirty;
                    $dirty14 = $dirty1;
                    z3 = z;
                    obj2 = density;
                    l2 = containerColor2;
                    $dirty2 = shadowElevation2;
                    $dirty15 = exposedDropdownMenuPositionProvider;
                    f4 = shadowElevation;
                    f5 = border;
                    i17 = content;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty13 = i41;
            $dirty14 = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.3(this, expanded, onDismissRequest, $dirty2, $dirty15, z3, obj2, l2, density, f4, f5, i17, $composer, i68, i15, obj54);
            endRestartGroup.updateScope((Function2)$dirty14);
        } else {
            $dirty13 = $dirty14;
        }
    }

    public abstract Modifier exposedDropdownSize(Modifier modifier, boolean z2);

    public abstract String getAnchorType-Mg6Rgbw$material3_release();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use overload that takes MenuAnchorType and enabled parameters", replaceWith = @ReplaceWith(...))
    public final Modifier menuAnchor(Modifier $this$menuAnchor) {
        return ExposedDropdownMenuBoxScope.menuAnchor-fsE2BvY$default(this, $this$menuAnchor, MenuAnchorType.Companion.getPrimaryNotEditable-Mg6Rgbw(), false, 2, 0);
    }

    public abstract Modifier menuAnchor-fsE2BvY(Modifier modifier, String string2, boolean z3);
}
