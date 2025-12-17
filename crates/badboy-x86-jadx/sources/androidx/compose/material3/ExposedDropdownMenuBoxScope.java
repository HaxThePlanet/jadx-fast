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
        int i4;
        int i10;
        int i11;
        Object modifier2;
        boolean traceInProgress2;
        Object rememberScrollState;
        int i6;
        Object obj3;
        int changed;
        Object obj4;
        int i14;
        Object obj;
        boolean z;
        int i7;
        Object obj5;
        int i;
        boolean skipping;
        int defaultsInvalid;
        int i2;
        int i5;
        Shape shape;
        long containerColor;
        float tonalElevation-D9Ej5fM;
        float shadowElevation-D9Ej5fM;
        int i13;
        Object obj2;
        Composer composer;
        int i9;
        int i3;
        int i12;
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
                i4 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty |= i4;
            } else {
                z = expanded;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
            obj5 = onDismissRequest;
        } else {
            if (i33 & 48 == 0) {
                i10 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty |= i10;
            } else {
                obj5 = onDismissRequest;
            }
        }
        i11 = i8 & 4;
        if (i11 != 0) {
            $dirty |= 384;
            rememberScrollState = modifier;
        } else {
            if (i33 & 384 == 0) {
                i6 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i6;
            } else {
                rememberScrollState = modifier;
            }
        }
        if (i33 & 3072 == 0) {
            if (i8 & 8 == 0) {
                changed = restartGroup.changed(scrollState) ? 2048 : 1024;
            } else {
                obj3 = scrollState;
            }
            $dirty |= changed;
        } else {
            obj3 = scrollState;
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
            obj4 = content;
        } else {
            if (i33 & 24576 == 0) {
                i14 = restartGroup.changedInstance(content) ? 16384 : 8192;
                $dirty |= i14;
            } else {
                obj4 = content;
            }
        }
        i = 196608;
        if (i8 & 32 != 0) {
            $dirty |= i;
            obj = this;
        } else {
            if (i33 & i == 0) {
                i = restartGroup.changed(this) ? 131072 : 65536;
                $dirty |= i;
            } else {
                obj = this;
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
                            i2 = obj3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i8 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        skipping = rememberScrollState;
                        i2 = obj3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:452)");
                }
                int i21 = 6;
                obj.ExposedDropdownMenu-vNxi1II(z, obj5, skipping, i2, true, MenuDefaults.INSTANCE.getShape(restartGroup, i21), MenuDefaults.INSTANCE.getContainerColor(restartGroup, i21), obj16, MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM(), MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM(), 0, obj4, restartGroup, i18 | i25, i20 | i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                rememberScrollState = skipping;
                obj3 = i2;
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
            traceInProgress = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.5(this, expanded, onDismissRequest, rememberScrollState, obj3, content, i33, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "The `focusable` parameter is unused. Pass the proper MenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.")
    public final void ExposedDropdownMenu-kbRbctU(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, boolean focusable, boolean matchTextFieldWidth, Shape shape, long containerColor, float tonalElevation, float shadowElevation, BorderStroke border, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i16) {
        int $dirty14;
        int skipping;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        int i6;
        float f3;
        float f4;
        Object obj;
        Object obj4;
        Object obj3;
        int i15;
        ScopeUpdateScope endRestartGroup;
        int i18;
        float tonalElevation2;
        boolean traceInProgress;
        Object $dirty12;
        int $dirty;
        Object $dirty2;
        int $dirty15;
        Object $dirty1;
        boolean z;
        int i7;
        Object scrollState2;
        boolean z3;
        Object obj6;
        Object focusable3;
        int focusable2;
        int i13;
        Object obj5;
        long l;
        boolean z2;
        Object shape2;
        float f5;
        int i26;
        float f;
        int shadowElevation2;
        int iNSTANCE2;
        int iNSTANCE;
        int i23;
        int obj2;
        int i25;
        long containerColor2;
        int i21;
        int changedInstance;
        int i12;
        int changed;
        int i24;
        int i9;
        int i4;
        int i2;
        int i14;
        int $dirty13;
        int changed4;
        int i11;
        int changed3;
        int i19;
        int i20;
        int i10;
        int i;
        int i5;
        boolean changed2;
        float f2;
        int i22;
        Composer composer2;
        Composer composer;
        int i8;
        int i3;
        int i17;
        ScopeUpdateScope scopeUpdateScope;
        int obj48;
        i21 = $changed1;
        int i27 = i16;
        i6 = obj51;
        $dirty12 = $changed.startRestartGroup(366140493);
        ComposerKt.sourceInformation($dirty12, "C(ExposedDropdownMenu)P(3,7,6,8,4,5,10,1:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp)414@19050L21,417@19189L5,418@19241L14,424@19482L463:ExposedDropdownMenu.android.kt#uh7d8r");
        $dirty = $changed1;
        $dirty15 = i16;
        if (i6 & 1 != 0) {
            $dirty |= 6;
            z = expanded;
        } else {
            if (i21 & 6 == 0) {
                i13 = $dirty12.changed(expanded) ? 4 : 2;
                $dirty |= i13;
            } else {
                z = expanded;
            }
        }
        if (i6 & 2 != 0) {
            $dirty |= 48;
            obj5 = onDismissRequest;
        } else {
            if (i21 & 48 == 0) {
                i26 = $dirty12.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty |= i26;
            } else {
                obj5 = onDismissRequest;
            }
        }
        shadowElevation2 = i6 & 4;
        if (shadowElevation2 != 0) {
            $dirty |= 384;
            scrollState2 = modifier;
        } else {
            if (i21 & 384 == 0) {
                changedInstance = $dirty12.changed(modifier) ? 256 : 128;
                $dirty |= changedInstance;
            } else {
                scrollState2 = modifier;
            }
        }
        if (i21 & 3072 == 0) {
            if (i6 & 8 == 0) {
                changed = $dirty12.changed(scrollState) ? 2048 : 1024;
            } else {
                obj6 = scrollState;
            }
            $dirty |= changed;
        } else {
            obj6 = scrollState;
        }
        i24 = i6 & 32;
        i9 = 196608;
        if (i24 != 0) {
            $dirty |= i9;
            z2 = matchTextFieldWidth;
        } else {
            if (i21 & i9 == 0) {
                i2 = $dirty12.changed(matchTextFieldWidth) ? 131072 : 65536;
                $dirty |= i2;
            } else {
                z2 = matchTextFieldWidth;
            }
        }
        if (i21 & i85 == 0) {
            if (i6 & 64 == 0) {
                changed4 = $dirty12.changed(shape) ? 1048576 : 524288;
            } else {
                shape2 = shape;
            }
            $dirty |= changed4;
        } else {
            shape2 = shape;
        }
        if (i21 & i86 == 0) {
            if (i6 & 128 == 0) {
                changed3 = $dirty12.changed(containerColor) ? 8388608 : 4194304;
            } else {
                containerColor2 = containerColor;
            }
            $dirty |= changed3;
        } else {
            containerColor2 = containerColor;
        }
        i25 = i6 & 256;
        i19 = 100663296;
        if (i25 != 0) {
            $dirty |= i19;
            f3 = shadowElevation;
        } else {
            if ($changed1 & i19 == 0) {
                i20 = $dirty12.changed(shadowElevation) ? 67108864 : 33554432;
                $dirty |= i20;
            } else {
                f3 = shadowElevation;
            }
        }
        int i45 = i6 & 512;
        int i87 = 805306368;
        if (i45 != 0) {
            $dirty |= i87;
            i10 = i45;
            f4 = border;
        } else {
            if ($changed1 & i87 == 0) {
                i10 = i45;
                i = $dirty12.changed(border) ? 536870912 : 268435456;
                $dirty |= i;
            } else {
                i10 = i45;
                f4 = border;
            }
        }
        int i46 = i6 & 1024;
        if (i46 != 0) {
            $dirty15 |= 6;
            i5 = i46;
            obj = content;
        } else {
            if (i27 & 6 == 0) {
                i5 = i46;
                changedInstance = $dirty12.changed(content) ? 4 : 2;
                $dirty15 |= changedInstance;
            } else {
                i5 = i46;
                obj = content;
            }
        }
        if (i6 & 2048 != 0) {
            $dirty15 |= 48;
            obj4 = $composer;
        } else {
            if (i27 & 48 == 0) {
                i9 = $dirty12.changedInstance($composer) ? 32 : 16;
                $dirty15 |= i9;
            } else {
                obj4 = $composer;
            }
        }
        if (i6 & 4096 != 0) {
            $dirty15 |= 384;
            obj3 = this;
        } else {
            if (i27 & 384 == 0) {
                i11 = $dirty12.changed(this) ? 256 : 128;
                $dirty15 |= i11;
            } else {
                obj3 = this;
            }
        }
        if ($dirty & i12 == 306775186 && $dirty15 & 147 == 146) {
            if ($dirty15 & 147 == 146) {
                if (!$dirty12.getSkipping()) {
                    $dirty12.startDefaults();
                    tonalElevation2 = -3670017;
                    if ($changed1 & 1 != 0) {
                        if ($dirty12.getDefaultsInvalid()) {
                            if (shadowElevation2 != 0) {
                                modifier3 = Modifier.Companion;
                            } else {
                                modifier3 = scrollState2;
                            }
                            if (i6 & 8 != 0) {
                                int i72 = 0;
                                scrollState2 = ScrollKt.rememberScrollState(i72, $dirty12, i72, 1);
                                $dirty &= -7169;
                            } else {
                                scrollState2 = obj6;
                            }
                            focusable2 = i6 & 16 != 0 ? 1 : focusable;
                            if (i24 != 0) {
                                z2 = 1;
                            }
                            i18 = 6;
                            if (i6 & 64 != 0) {
                                shape2 = MenuDefaults.INSTANCE.getShape($dirty12, i18);
                                $dirty &= obj48;
                            }
                            if (i6 & 128 != 0) {
                                containerColor2 = MenuDefaults.INSTANCE.getContainerColor($dirty12, i18);
                                $dirty &= i18;
                            }
                            if (i25 != 0) {
                                tonalElevation2 = MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = shadowElevation;
                            }
                            if (i10 != 0) {
                                shadowElevation2 = MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = border;
                            }
                            if (i5 != 0) {
                                i14 = modifier3;
                                changed2 = tonalElevation2;
                                i11 = scrollState2;
                                changed3 = z2;
                                i19 = shape2;
                                f2 = shadowElevation2;
                                i22 = i25;
                                i10 = containerColor2;
                                modifier2 = 366140493;
                            } else {
                                i22 = content;
                                i14 = modifier3;
                                changed2 = tonalElevation2;
                                i11 = scrollState2;
                                changed3 = z2;
                                i19 = shape2;
                                f2 = shadowElevation2;
                                i10 = containerColor2;
                                modifier2 = 366140493;
                            }
                        } else {
                            $dirty12.skipToGroupEnd();
                            if (i6 & 8 != 0) {
                                $dirty &= -7169;
                            }
                            if (i6 & 64 != 0) {
                                $dirty &= tonalElevation2;
                            }
                            if (i6 & 128 != 0) {
                                changed2 = shadowElevation;
                                f2 = border;
                                i22 = content;
                                $dirty = i43;
                                i14 = scrollState2;
                                i11 = obj6;
                                changed3 = z2;
                                i19 = shape2;
                                i10 = containerColor2;
                                modifier2 = 366140493;
                                focusable2 = focusable;
                            } else {
                                changed2 = shadowElevation;
                                f2 = border;
                                i22 = content;
                                i14 = scrollState2;
                                i11 = obj6;
                                changed3 = z2;
                                i19 = shape2;
                                i10 = containerColor2;
                                modifier2 = 366140493;
                                focusable2 = focusable;
                            }
                        }
                    } else {
                    }
                    $dirty12.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(modifier2, $dirty, $dirty15, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:424)");
                    }
                    this.ExposedDropdownMenu-vNxi1II(z, obj5, i14, i11, changed3, i19, i10, i5, changed2, f2, i22, $composer, $dirty12, i36 | i63, i38 | i15);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i4 = $dirty;
                    $dirty14 = $dirty15;
                    i7 = focusable2;
                    $dirty2 = i14;
                    $dirty1 = i11;
                    z3 = changed3;
                    focusable3 = i19;
                    l = i10;
                    f5 = changed2;
                    f = f2;
                    obj2 = i22;
                } else {
                    $dirty12.skipToGroupEnd();
                    i7 = focusable;
                    f = border;
                    obj2 = content;
                    composer = $dirty12;
                    i4 = $dirty;
                    $dirty14 = $dirty15;
                    $dirty2 = scrollState2;
                    $dirty1 = obj6;
                    z3 = z2;
                    focusable3 = shape2;
                    l = containerColor2;
                    f5 = shadowElevation;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty13 = i68;
            $dirty14 = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.4(this, expanded, onDismissRequest, $dirty2, $dirty1, i7, z3, focusable3, l, z2, f5, f, obj2, $composer, $changed1, i16, i6);
            endRestartGroup.updateScope((Function2)$dirty14);
        } else {
            $dirty13 = $dirty14;
        }
    }

    public final void ExposedDropdownMenu-vNxi1II(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, ScrollState scrollState, boolean matchTextFieldWidth, Shape shape, long containerColor, float tonalElevation, float shadowElevation, BorderStroke border, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i15) {
        int skipping;
        int defaultsInvalid;
        Object modifier2;
        boolean traceInProgress;
        Object rememberComposableLambda;
        Object mutableStateOf$default;
        int i16;
        int $dirty13;
        float i8;
        float f3;
        Object obj7;
        Object obj9;
        Object obj2;
        int invalid$iv2;
        Object anon;
        int valueOf;
        boolean booleanValue;
        int invalid$iv;
        ScopeUpdateScope endRestartGroup;
        boolean $dirty12;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        int $dirty14;
        Object $dirty1;
        int i7;
        Object obj12;
        boolean z3;
        boolean z2;
        int str;
        Object obj5;
        float tonalElevation2;
        long l;
        Object density;
        long containerColor2;
        Object topWindowInsets;
        float f2;
        int i2;
        String str2;
        int composer2;
        float f4;
        Object shadowElevation2;
        int i14;
        int i4;
        int i10;
        Object mutableStateOf;
        Object consume;
        Object empty;
        int i11;
        int i6;
        int i5;
        Object exposedDropdownMenuPositionProvider;
        String str3;
        int changed3;
        int neverEqualPolicy;
        int rememberedValue;
        int i21;
        int i9;
        int i3;
        Composer.Companion companion;
        int changed;
        int companion2;
        Composer composer;
        int i19;
        int i20;
        int changed2;
        int $dirty15;
        int i17;
        int i12;
        int i;
        int i18;
        int i13;
        int changed4;
        androidx.compose.material3.ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope;
        Object obj;
        boolean z;
        Object obj10;
        Object obj4;
        Object obj11;
        Object obj8;
        long l2;
        float f;
        float f5;
        int obj6;
        Object obj3;
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
        $dirty2 = $changed1;
        $dirty14 = i15;
        if (i22 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i68 & 6 == 0) {
                i7 = restartGroup.changed($dirty12) ? 4 : 2;
                $dirty2 |= i7;
            }
        }
        if (i22 & 2 != 0) {
            $dirty2 |= 48;
            obj12 = onDismissRequest;
        } else {
            if (i68 & 48 == 0) {
                i2 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty2 |= i2;
            } else {
                obj12 = onDismissRequest;
            }
        }
        int i54 = i22 & 4;
        if (i54 != 0) {
            $dirty2 |= 384;
            shadowElevation2 = modifier;
        } else {
            if (i68 & 384 == 0) {
                i5 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i5;
            } else {
                shadowElevation2 = modifier;
            }
        }
        if (i68 & 3072 == 0) {
            if (i22 & 8 == 0) {
                changed3 = restartGroup.changed(scrollState) ? 2048 : 1024;
            } else {
                exposedDropdownMenuPositionProvider = scrollState;
            }
            $dirty2 |= changed3;
        } else {
            exposedDropdownMenuPositionProvider = scrollState;
        }
        neverEqualPolicy = i22 & 16;
        if (neverEqualPolicy != 0) {
            $dirty2 |= 24576;
            z2 = matchTextFieldWidth;
        } else {
            if (i68 & 24576 == 0) {
                i21 = restartGroup.changed(matchTextFieldWidth) ? 16384 : 8192;
                $dirty2 |= i21;
            } else {
                z2 = matchTextFieldWidth;
            }
        }
        if (i68 & i69 == 0) {
            if (i22 & 32 == 0) {
                changed = restartGroup.changed(shape) ? 131072 : 65536;
            } else {
                density = shape;
            }
            $dirty2 |= changed;
        } else {
            density = shape;
        }
        if (i68 & i70 == 0) {
            if (i22 & 64 == 0) {
                i19 = i54;
                changed2 = restartGroup.changed(containerColor) ? 1048576 : 524288;
            } else {
                i19 = i54;
                containerColor2 = containerColor;
            }
            $dirty2 |= changed2;
        } else {
            i19 = i54;
            containerColor2 = containerColor;
        }
        tonalElevation2 = i22 & 128;
        i17 = 12582912;
        if (tonalElevation2 != 0) {
            $dirty2 |= i17;
            i8 = shadowElevation;
        } else {
            if (i68 & i17 == 0) {
                i12 = restartGroup.changed(shadowElevation) ? 8388608 : 4194304;
                $dirty2 |= i12;
            } else {
                i8 = shadowElevation;
            }
        }
        int i30 = i22 & 256;
        int i71 = 100663296;
        if (i30 != 0) {
            $dirty2 |= i71;
            i = i30;
            f3 = border;
        } else {
            if (i68 & i71 == 0) {
                i = i30;
                i18 = restartGroup.changed(border) ? 67108864 : 33554432;
                $dirty2 |= i18;
            } else {
                i = i30;
                f3 = border;
            }
        }
        int i31 = i22 & 512;
        int i73 = 805306368;
        if (i31 != 0) {
            $dirty2 |= i73;
            i13 = i31;
            obj7 = content;
        } else {
            if (i68 & i73 == 0) {
                i13 = i31;
                changed4 = restartGroup.changed(content) ? 536870912 : 268435456;
                $dirty2 |= changed4;
            } else {
                i13 = i31;
                obj7 = content;
            }
        }
        if (i22 & 1024 != 0) {
            $dirty14 |= 6;
            obj9 = $composer;
        } else {
            if (i15 & 6 == 0) {
                changed4 = restartGroup.changedInstance($composer) ? 4 : 2;
                $dirty14 |= changed4;
            } else {
                obj9 = $composer;
            }
        }
        if (i22 & 2048 != 0) {
            $dirty14 |= 48;
            obj2 = this;
        } else {
            if (i15 & 48 == 0) {
                i9 = restartGroup.changed(this) ? 32 : 16;
                $dirty14 |= i9;
            } else {
                obj2 = this;
            }
        }
        if ($dirty2 & i3 == 306783378 && $dirty14 & 19 == 18) {
            if ($dirty14 & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    if (i68 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (i19 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = shadowElevation2;
                            }
                            if (obj54 & 8 != 0) {
                                i14 = 0;
                                exposedDropdownMenuPositionProvider = ScrollKt.rememberScrollState(i14, restartGroup, i14, 1);
                                $dirty2 &= -7169;
                            }
                            if (neverEqualPolicy != 0) {
                                z2 = 1;
                            }
                            if (obj54 & 32 != 0) {
                                density = MenuDefaults.INSTANCE.getShape(restartGroup, 6);
                                $dirty2 &= i4;
                            }
                            if (obj54 & 64 != 0) {
                                containerColor2 = MenuDefaults.INSTANCE.getContainerColor(restartGroup, 6);
                                $dirty2 &= i10;
                            }
                            if (tonalElevation2 != 0) {
                                tonalElevation2 = MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = shadowElevation;
                            }
                            if (i != 0) {
                                shadowElevation2 = MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = border;
                            }
                            if (i13 != 0) {
                                obj = modifier2;
                                z = z2;
                                f = tonalElevation2;
                                obj8 = density;
                                l2 = containerColor2;
                                f5 = shadowElevation2;
                                obj11 = exposedDropdownMenuPositionProvider;
                                obj6 = neverEqualPolicy;
                            } else {
                                obj6 = content;
                                obj = modifier2;
                                z = z2;
                                f = tonalElevation2;
                                obj8 = density;
                                l2 = containerColor2;
                                f5 = shadowElevation2;
                                obj11 = exposedDropdownMenuPositionProvider;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (obj54 & 8 != 0) {
                                $dirty2 &= -7169;
                            }
                            if (obj54 & 32 != 0) {
                                $dirty2 &= i16;
                            }
                            if (obj54 & 64 != 0) {
                                f = shadowElevation;
                                f5 = border;
                                obj6 = content;
                                $dirty2 = modifier2;
                                z = z2;
                                obj8 = density;
                                l2 = containerColor2;
                                obj = shadowElevation2;
                                obj11 = exposedDropdownMenuPositionProvider;
                            } else {
                                f = shadowElevation;
                                f5 = border;
                                obj6 = content;
                                z = z2;
                                obj8 = density;
                                l2 = containerColor2;
                                obj = shadowElevation2;
                                obj11 = exposedDropdownMenuPositionProvider;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(720925481, $dirty2, $dirty14, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.android.kt:344)");
                    }
                    str = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 321492941, str);
                    int i24 = 0;
                    Composer composer4 = restartGroup;
                    int i50 = 0;
                    Object rememberedValue3 = composer4.rememberedValue();
                    int i55 = 0;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        int i64 = 0;
                        composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy()));
                    } else {
                        mutableStateOf = rememberedValue3;
                    }
                    Object invalid$iv3 = mutableStateOf;
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
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 321501788, str);
                        int i60 = 0;
                        consume = restartGroup;
                        str3 = 0;
                        rememberedValue = consume.rememberedValue();
                        i3 = 0;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            obj41 = i34;
                            anon = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.1.1((MutableState)invalid$iv3);
                            consume.updateRememberedValue((Function0)anon);
                        } else {
                            anon = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        ExposedDropdownMenu_androidKt.access$SoftKeyboardListener((View)restartGroup.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView()), this_$iv2, (Function0)anon, restartGroup, 384);
                    }
                    restartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 321507042, str);
                    valueOf = 0;
                    composer2 = restartGroup;
                    i11 = 0;
                    exposedDropdownMenuPositionProvider = composer2.rememberedValue();
                    neverEqualPolicy = 0;
                    if (exposedDropdownMenuPositionProvider == Composer.Companion.getEmpty()) {
                        obj41 = i26;
                        obj42 = valueOf;
                        rememberComposableLambda = new MutableTransitionState(false);
                        composer2.updateRememberedValue(rememberComposableLambda);
                    } else {
                        obj42 = valueOf;
                        rememberComposableLambda = exposedDropdownMenuPositionProvider;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    (MutableTransitionState)rememberComposableLambda.setTargetState(Boolean.valueOf($dirty12));
                    if (!(Boolean)rememberComposableLambda.getCurrentState().booleanValue()) {
                        if ((Boolean)rememberComposableLambda.getTargetState().booleanValue()) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 321513419, str);
                            invalid$iv = 0;
                            Composer composer5 = restartGroup;
                            empty = 0;
                            exposedDropdownMenuPositionProvider = composer5.rememberedValue();
                            neverEqualPolicy = 0;
                            if (exposedDropdownMenuPositionProvider == Composer.Companion.getEmpty()) {
                                obj41 = i25;
                                obj42 = invalid$iv;
                                i3 = $dirty2;
                                composer5.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), 0, 2, 0));
                            } else {
                                obj42 = invalid$iv;
                                i3 = $dirty2;
                                mutableStateOf$default = exposedDropdownMenuPositionProvider;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 321517310, str);
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
                            changed4 = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.2(this, obj, z, rememberComposableLambda, mutableStateOf$default, obj11, obj8, l2, obj32, f, f5, obj6, $composer);
                            obj45 = restartGroup;
                            AndroidPopup_androidKt.Popup((PopupPositionProvider)(ExposedDropdownMenuPositionProvider)topWindowInsets, obj12, ExposedDropdownMenuDefaults.INSTANCE.popupProperties-pR6Bxps$material3_release(getAnchorType-Mg6Rgbw$material3_release(), restartGroup, 48), (Function2)ComposableLambdaKt.rememberComposableLambda(-1082380263, true, changed4, restartGroup, 54), obj45, i49 |= 3072, 0);
                            composer = obj45;
                        } else {
                            obj10 = rememberComposableLambda;
                            composer = restartGroup;
                            i3 = $dirty2;
                            invalid$iv2 = this_$iv2;
                            density = topWindowInsets;
                        }
                    } else {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty13 = $dirty14;
                    i20 = i3;
                    $dirty = obj;
                    z3 = z;
                    $dirty1 = obj11;
                    obj5 = obj8;
                    l = l2;
                    f2 = f;
                    f4 = f5;
                    i6 = obj6;
                } else {
                    restartGroup.skipToGroupEnd();
                    composer = restartGroup;
                    i20 = $dirty2;
                    $dirty13 = $dirty14;
                    z3 = z2;
                    obj5 = density;
                    l = containerColor2;
                    $dirty = shadowElevation2;
                    $dirty1 = exposedDropdownMenuPositionProvider;
                    f2 = shadowElevation;
                    f4 = border;
                    i6 = content;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty15 = i41;
            $dirty13 = new ExposedDropdownMenuBoxScope.ExposedDropdownMenu.3(this, expanded, onDismissRequest, $dirty, $dirty1, z3, obj5, l, density, f2, f4, i6, $composer, i68, i15, obj54);
            endRestartGroup.updateScope((Function2)$dirty13);
        } else {
            $dirty15 = $dirty13;
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
