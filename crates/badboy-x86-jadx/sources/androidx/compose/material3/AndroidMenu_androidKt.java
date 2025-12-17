package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001an\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\u001a¢\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001d2\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\u001ad\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\u0002\u0008\u0014¢\u0006\u0002\u0008\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\u001a\u0090\u0001\u0010%\u001a\u00020\u00052\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\u0008\u00142\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020\u00050\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0015\u0008\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\u0008\u00142\u0015\u0008\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\u0008\u00142\u0008\u0008\u0002\u0010*\u001a\u00020\u00072\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010-\u001a\u00020.2\n\u0008\u0002\u0010/\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0002\u00101\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00062", d2 = {"DefaultMenuProperties", "Landroidx/compose/ui/window/PopupProperties;", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "DropdownMenu-IlH_yew", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidMenu_androidKt {

    private static final PopupProperties DefaultMenuProperties;
    static {
        PopupProperties popupProperties = new PopupProperties(1, 0, 0, 0, 14, 0);
        AndroidMenu_androidKt.DefaultMenuProperties = popupProperties;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with parameters for shape, color, elevation, and border.", replaceWith = @ReplaceWith(...))
    public static final void DropdownMenu-4kj-_NE(boolean expanded, Function0 onDismissRequest, Modifier modifier, long offset, ScrollState scrollState, PopupProperties properties, Function3 content, Composer $composer, int $changed, int i10) {
        int traceInProgress;
        int defaultsInvalid;
        Object modifier3;
        int modifier2;
        Composer restartGroup;
        int $dirty;
        int i7;
        int i6;
        int rememberScrollState;
        boolean traceInProgress2;
        Object obj7;
        Object $this$dp$iv;
        long l;
        int i8;
        int i16;
        long l2;
        Object obj;
        Object obj5;
        int i17;
        Object obj4;
        boolean z;
        Object obj3;
        int i11;
        int changed;
        Object i15;
        Object obj8;
        int i;
        Object obj2;
        int i12;
        int i18;
        Object i13;
        Object obj6;
        PopupProperties popupProperties;
        int containerColor;
        int i3;
        int tonalElevation-D9Ej5fM;
        int shadowElevation-D9Ej5fM;
        int i4;
        int i14;
        Composer composer;
        int i5;
        int i2;
        int i9;
        int obj36;
        final int i46 = i10;
        restartGroup = $changed.startRestartGroup(-1137929566);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,6,5)119@4573L21,130@4960L5,131@5005L14,123@4721L465:AndroidMenu.android.kt#uh7d8r");
        $dirty = i10;
        if (obj38 & 1 != 0) {
            $dirty |= 6;
            z = expanded;
        } else {
            if (i46 & 6 == 0) {
                i7 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty |= i7;
            } else {
                z = expanded;
            }
        }
        if (obj38 & 2 != 0) {
            $dirty |= 48;
            obj3 = onDismissRequest;
        } else {
            if (i46 & 48 == 0) {
                i6 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty |= i6;
            } else {
                obj3 = onDismissRequest;
            }
        }
        rememberScrollState = obj38 & 4;
        if (rememberScrollState != 0) {
            $dirty |= 384;
            $this$dp$iv = modifier;
        } else {
            if (i46 & 384 == 0) {
                i8 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i8;
            } else {
                $this$dp$iv = modifier;
            }
        }
        i16 = obj38 & 8;
        if (i16 != 0) {
            $dirty |= 3072;
            l2 = offset;
        } else {
            if (i46 & 3072 == 0) {
                i17 = restartGroup.changed(offset) ? 2048 : 1024;
                $dirty |= i17;
            } else {
                l2 = offset;
            }
        }
        if (i46 & 24576 == 0) {
            if (obj38 & 16 == 0) {
                changed = restartGroup.changed(properties) ? 16384 : 8192;
            } else {
                obj4 = properties;
            }
            $dirty |= changed;
        } else {
            obj4 = properties;
        }
        i15 = obj38 & 32;
        int i47 = 196608;
        if (i15 != 0) {
            $dirty |= i47;
            obj8 = content;
        } else {
            if (i47 &= i46 == 0) {
                i = restartGroup.changed(content) ? 131072 : 65536;
                $dirty |= i;
            } else {
                obj8 = content;
            }
        }
        i12 = 1572864;
        if (obj38 & 64 != 0) {
            $dirty |= i12;
            obj2 = $composer;
        } else {
            if (i46 & i12 == 0) {
                i12 = restartGroup.changedInstance($composer) ? 1048576 : 524288;
                $dirty |= i12;
            } else {
                obj2 = $composer;
            }
        }
        if (i51 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i18 = -57345;
                if (i46 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (rememberScrollState != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = $this$dp$iv;
                        }
                        if (i16 != 0) {
                            int i34 = 0;
                            i16 = 0;
                            obj36 = i18;
                            l2 = rememberScrollState;
                        } else {
                            obj36 = i18;
                        }
                        if (obj38 & 16 != 0) {
                            int i30 = 0;
                            $dirty &= obj36;
                            obj4 = rememberScrollState;
                        }
                        if (i15 != 0) {
                            popupProperties = new PopupProperties(1, 0, 0, 0, 14, 0);
                            i15 = modifier3;
                            obj8 = l2;
                            i13 = obj4;
                            obj6 = popupProperties;
                            modifier2 = -1137929566;
                        } else {
                            i15 = modifier3;
                            i13 = obj4;
                            obj6 = obj8;
                            modifier2 = -1137929566;
                            obj8 = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj38 & 16 != 0) {
                            $dirty &= i18;
                        }
                        i15 = $this$dp$iv;
                        i13 = obj4;
                        obj6 = obj8;
                        modifier2 = -1137929566;
                        obj8 = l2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, $dirty, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:123)");
                }
                int i32 = 6;
                AndroidMenu_androidKt.DropdownMenu-IlH_yew(z, obj3, i15, obj8, obj2, i13, obj6, MenuDefaults.INSTANCE.getShape(restartGroup, i32), MenuDefaults.INSTANCE.getContainerColor(restartGroup, i32), i3, MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM(), MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM(), 0, $composer, restartGroup, i26 | i42);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj7 = i15;
                l = obj8;
                obj = i13;
                obj5 = obj6;
                i11 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                obj7 = $this$dp$iv;
                l = l2;
                obj = obj4;
                obj5 = obj8;
                i11 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AndroidMenu_androidKt.DropdownMenu.3(expanded, onDismissRequest, obj7, l, i16, obj, obj5, $composer, i46, obj38);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(...))
    public static final void DropdownMenu-ILWXrKs(boolean expanded, Function0 onDismissRequest, Modifier modifier, long offset, PopupProperties properties, Function3 content, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        Composer restartGroup;
        int $dirty2;
        int i6;
        int i17;
        Object obj2;
        Object modifier2;
        Object obj5;
        long l;
        boolean traceInProgress;
        int i19;
        int $this$dp$iv;
        long l2;
        Object obj7;
        int i5;
        boolean z;
        Object obj6;
        int i7;
        int i;
        int $dirty;
        Object obj;
        int i18;
        Object obj3;
        int i14;
        boolean rememberScrollState;
        int i8;
        int i13;
        int i3;
        int i10;
        int i2;
        int i4;
        int i15;
        Object obj4;
        Composer composer;
        int i11;
        int i12;
        int i16;
        final int i37 = i9;
        traceInProgress2 = 354826666;
        restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)163@6060L21,158@5896L251:AndroidMenu.android.kt#uh7d8r");
        $dirty2 = i9;
        if (obj36 & 1 != 0) {
            $dirty2 |= 6;
            z = expanded;
        } else {
            if (i37 & 6 == 0) {
                i6 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty2 |= i6;
            } else {
                z = expanded;
            }
        }
        if (obj36 & 2 != 0) {
            $dirty2 |= 48;
            obj6 = onDismissRequest;
        } else {
            if (i37 & 48 == 0) {
                i17 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty2 |= i17;
            } else {
                obj6 = onDismissRequest;
            }
        }
        int i26 = obj36 & 4;
        if (i26 != 0) {
            $dirty2 |= 384;
            obj5 = modifier;
        } else {
            if (i37 & 384 == 0) {
                i19 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i19;
            } else {
                obj5 = modifier;
            }
        }
        $this$dp$iv = obj36 & 8;
        if ($this$dp$iv != 0) {
            $dirty2 |= 3072;
            l2 = offset;
        } else {
            if (i37 & 3072 == 0) {
                i7 = restartGroup.changed(offset) ? 2048 : 1024;
                $dirty2 |= i7;
            } else {
                l2 = offset;
            }
        }
        i = obj36 & 16;
        if (i != 0) {
            $dirty2 |= 24576;
            obj = content;
        } else {
            if (i37 & 24576 == 0) {
                i18 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i18;
            } else {
                obj = content;
            }
        }
        i14 = 196608;
        if (obj36 & 32 != 0) {
            $dirty2 |= i14;
            obj3 = $composer;
        } else {
            if (i37 & i14 == 0) {
                i14 = restartGroup.changedInstance($composer) ? 131072 : 65536;
                $dirty2 |= i14;
            } else {
                obj3 = $composer;
            }
        }
        if (i41 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i26 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj5;
                }
                if ($this$dp$iv != 0) {
                    int i35 = 0;
                    rememberScrollState = 0;
                    l2 = obj5;
                }
                if (i != 0) {
                    rememberScrollState = new PopupProperties(1, 0, 0, 0, 14, 0);
                    i8 = rememberScrollState;
                } else {
                    i8 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:158)");
                }
                int i20 = 0;
                i = modifier2;
                obj = l2;
                AndroidMenu_androidKt.DropdownMenu-IlH_yew(z, obj6, i, obj, obj3, ScrollKt.rememberScrollState(i20, restartGroup, i20, 1), i8, 0, 0, i10, 0, 0, 0, obj3, restartGroup, i24 | i34);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = i;
                l = obj;
                obj7 = i8;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                obj2 = obj5;
                l = l2;
                obj7 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = $dirty2;
            traceInProgress2 = new AndroidMenu_androidKt.DropdownMenu.4(expanded, onDismissRequest, obj2, l, $this$dp$iv, obj7, $composer, i37, obj36);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        } else {
            $dirty = $dirty2;
        }
    }

    public static final void DropdownMenu-IlH_yew(boolean expanded, Function0<Unit> onDismissRequest, Modifier modifier, long offset, ScrollState scrollState, PopupProperties properties, Shape shape, long containerColor, float tonalElevation, float shadowElevation, BorderStroke border, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i16) {
        int traceInProgress;
        Object endRestartGroup;
        Object $i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1;
        Object expandedState2;
        int i23;
        float f5;
        float f4;
        Object obj6;
        Object i2;
        int this_$iv;
        int invalid$iv;
        Object restartGroup;
        int $dirty3;
        long $dirty5;
        Object $dirty;
        int skipping;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        long l;
        int shape2;
        int defaultMenuProperties;
        boolean traceInProgress2;
        int i18;
        Object i15;
        boolean z;
        int i21;
        Object rememberScrollState;
        int str;
        Object tonalElevation2;
        Object obj4;
        int i12;
        int $i$f$cache;
        Object rememberedValue;
        int i9;
        Object obj7;
        Object obj2;
        long offset2;
        long i7;
        int i;
        float f;
        int containerColor2;
        int i11;
        Object $i$f$getDp;
        float offset3;
        long $i$a$CacheAndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1;
        int empty;
        int i20;
        int obj8;
        int shadowElevation2;
        Object dropdownMenuPositionProvider;
        Object obj10;
        int i8;
        int companion;
        int i22;
        int i6;
        boolean changed;
        Composer composer;
        int i13;
        int i3;
        int i17;
        int i24;
        int changed2;
        int center-SzJe1aQ;
        int $dirty2;
        int $dirty4;
        int changed3;
        int $dirty1;
        int $dirty12;
        int i5;
        int i14;
        int i10;
        int i25;
        int i19;
        int changedInstance;
        Object obj3;
        MutableTransitionState expandedState;
        Object obj9;
        Object obj;
        Object obj11;
        long l2;
        float f2;
        float f3;
        int i4;
        Object obj5;
        ScopeUpdateScope scopeUpdateScope;
        int obj42;
        Object obj43;
        Object obj44;
        androidx.compose.runtime.internal.ComposableLambda obj45;
        Composer obj46;
        int obj47;
        int obj48;
        int obj49;
        int obj54;
        final int i66 = i16;
        traceInProgress = obj57;
        restartGroup = $changed1.startRestartGroup(1431928300);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenu)P(3,6,4,5:c#ui.unit.DpOffset,8,7,10,1:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp)182@6555L21,185@6667L5,187@6715L14,55@2073L42,59@2260L51,60@2347L7,62@2403L251,72@2825L494,68@2664L655:AndroidMenu.android.kt#uh7d8r");
        $dirty3 = i16;
        int i37 = obj56;
        if (traceInProgress & 1 != 0) {
            $dirty3 |= 6;
            z = expanded;
        } else {
            if (i66 & 6 == 0) {
                i9 = restartGroup.changed(expanded) ? 4 : 2;
                $dirty3 |= i9;
            } else {
                z = expanded;
            }
        }
        if (traceInProgress & 2 != 0) {
            $dirty3 |= 48;
            obj7 = onDismissRequest;
        } else {
            if (i66 & 48 == 0) {
                i = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty3 |= i;
            } else {
                obj7 = onDismissRequest;
            }
        }
        containerColor2 = traceInProgress & 4;
        if (containerColor2 != 0) {
            $dirty3 |= 384;
            $i$f$getDp = modifier;
        } else {
            if (i66 & 384 == 0) {
                i20 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i20;
            } else {
                $i$f$getDp = modifier;
            }
        }
        shadowElevation2 = traceInProgress & 8;
        if (shadowElevation2 != 0) {
            $dirty3 |= 3072;
            offset2 = offset;
        } else {
            if (i66 & 3072 == 0) {
                i6 = restartGroup.changed(offset) ? 2048 : 1024;
                $dirty3 |= i6;
            } else {
                offset2 = offset;
            }
        }
        if (i66 & 24576 == 0) {
            if (traceInProgress & 16 == 0) {
                changed = restartGroup.changed(properties) ? 16384 : 8192;
            } else {
                rememberScrollState = properties;
            }
            $dirty3 |= changed;
        } else {
            rememberScrollState = properties;
        }
        i13 = traceInProgress & 32;
        i3 = 196608;
        if (i13 != 0) {
            $dirty3 |= i3;
            obj10 = shape;
        } else {
            if (i66 & i3 == 0) {
                i17 = restartGroup.changed(shape) ? 131072 : 65536;
                $dirty3 |= i17;
            } else {
                obj10 = shape;
            }
        }
        if (i66 & i67 == 0) {
            if (traceInProgress & 64 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 1048576 : 524288;
            } else {
                tonalElevation2 = containerColor;
            }
            $dirty3 |= changed2;
        } else {
            tonalElevation2 = containerColor;
        }
        if (i66 & i68 == 0) {
            if (traceInProgress & 128 == 0) {
                $dirty2 = $dirty3;
                i23 = i37;
                changed3 = restartGroup.changed(tonalElevation) ? 8388608 : 4194304;
            } else {
                $dirty2 = $dirty3;
                i23 = i37;
                $dirty5 = tonalElevation;
            }
            $dirty2 |= changed3;
        } else {
            $dirty4 = $dirty3;
            i23 = i37;
            $dirty5 = tonalElevation;
        }
        $dirty1 = i23;
        int $dirty13 = traceInProgress & 256;
        int i69 = 100663296;
        if ($dirty13 != 0) {
            $dirty4 |= i69;
            i5 = $dirty13;
            f5 = border;
        } else {
            if (i66 & i69 == 0) {
                i5 = $dirty13;
                i14 = restartGroup.changed(border) ? 67108864 : 33554432;
                $dirty4 |= i14;
            } else {
                i5 = $dirty13;
                f5 = border;
            }
        }
        int i29 = traceInProgress & 512;
        int i71 = 805306368;
        if (i29 != 0) {
            $dirty4 |= i71;
            i10 = i29;
            f4 = content;
        } else {
            if (i66 & i71 == 0) {
                i10 = i29;
                i25 = restartGroup.changed(content) ? 536870912 : 268435456;
                $dirty4 |= i25;
            } else {
                i10 = i29;
                f4 = content;
            }
        }
        int i30 = traceInProgress & 1024;
        if (i30 != 0) {
            $dirty1 |= 6;
            i19 = i30;
            obj6 = $composer;
        } else {
            if (obj56 & 6 == 0) {
                i19 = i30;
                changedInstance = restartGroup.changed($composer) ? 4 : 2;
                $dirty1 |= changedInstance;
            } else {
                i19 = i30;
                obj6 = $composer;
            }
        }
        if (traceInProgress & 2048 != 0) {
            $dirty1 |= 48;
        } else {
            if (obj56 & 48 == 0) {
                i8 = restartGroup.changedInstance($changed) ? 32 : 16;
                $dirty1 |= i8;
            } else {
                i2 = $changed;
            }
        }
        this_$iv = $dirty1;
        if ($dirty4 & companion == 306783378 && this_$iv & 19 == 18) {
            if (this_$iv & 19 == 18) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    i22 = -57345;
                    obj54 = -3670017;
                    if (i66 & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (containerColor2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = $i$f$getDp;
                            }
                            if (shadowElevation2 != 0) {
                                int i63 = 0;
                                shadowElevation2 = 0;
                                offset2 = DpKt.DpOffset-YgX7TsA(Dp.constructor-impl((float)i61), Dp.constructor-impl((float)$i$f$getDp));
                            }
                            if (traceInProgress & 16 != 0) {
                                defaultMenuProperties = 0;
                                rememberScrollState = ScrollKt.rememberScrollState(defaultMenuProperties, restartGroup, defaultMenuProperties, 1);
                                $dirty4 &= i22;
                            }
                            if (i13 != 0) {
                                obj10 = defaultMenuProperties;
                            }
                            int i60 = 6;
                            if (traceInProgress & 64 != 0) {
                                shape2 = MenuDefaults.INSTANCE.getShape(restartGroup, i60);
                                $dirty4 &= obj54;
                            } else {
                                shape2 = tonalElevation2;
                            }
                            if (traceInProgress & 128 != 0) {
                                containerColor2 = MenuDefaults.INSTANCE.getContainerColor(restartGroup, i60);
                                $dirty4 &= i12;
                            } else {
                                containerColor2 = tonalElevation;
                            }
                            if (i5 != 0) {
                                tonalElevation2 = MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM();
                            } else {
                                tonalElevation2 = border;
                            }
                            if (i10 != 0) {
                                shadowElevation2 = MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM();
                            } else {
                                shadowElevation2 = content;
                            }
                            if (i19 != 0) {
                                obj3 = modifier2;
                                obj11 = shape2;
                                obj = rememberScrollState;
                                f2 = tonalElevation2;
                                l2 = containerColor2;
                                f3 = shadowElevation2;
                                i4 = i22;
                                modifier3 = $dirty4;
                            } else {
                                i4 = $composer;
                                obj3 = modifier2;
                                obj11 = shape2;
                                obj = rememberScrollState;
                                f2 = tonalElevation2;
                                l2 = containerColor2;
                                f3 = shadowElevation2;
                                modifier3 = $dirty4;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (traceInProgress & 16 != 0) {
                                $dirty4 &= i22;
                            }
                            if (traceInProgress & 64 != 0) {
                                $dirty4 &= obj54;
                            }
                            if (traceInProgress & 128 != 0) {
                                modifier3 = $dirty4 & i36;
                                l2 = tonalElevation;
                                f2 = border;
                                f3 = content;
                                i4 = $composer;
                                obj = rememberScrollState;
                                obj11 = tonalElevation2;
                                obj3 = $i$f$getDp;
                            } else {
                                l2 = tonalElevation;
                                f2 = border;
                                f3 = content;
                                i4 = $composer;
                                obj = rememberScrollState;
                                obj11 = tonalElevation2;
                                obj3 = $i$f$getDp;
                                modifier3 = $dirty4;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1431928300, modifier3, this_$iv, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:54)");
                    }
                    str = "CC(remember):AndroidMenu.android.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1468213501, str);
                    i15 = 0;
                    rememberedValue = restartGroup;
                    i11 = 0;
                    Object rememberedValue3 = rememberedValue.rememberedValue();
                    dropdownMenuPositionProvider = 0;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        obj42 = i26;
                        obj54 = this_$iv;
                        $i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1 = new MutableTransitionState(false);
                        rememberedValue.updateRememberedValue($i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1);
                    } else {
                        obj54 = this_$iv;
                        i6 = 0;
                        $i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1 = rememberedValue3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    (MutableTransitionState)$i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1.setTargetState(Boolean.valueOf(z));
                    if (!(Boolean)$i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1.getCurrentState().booleanValue()) {
                        if ((Boolean)$i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1.getTargetState().booleanValue()) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 1468219494, str);
                            invalid$iv = 0;
                            Composer composer2 = restartGroup;
                            $i$f$cache = 0;
                            Object rememberedValue2 = composer2.rememberedValue();
                            empty = 0;
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                dropdownMenuPositionProvider = 0;
                                expandedState = $i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1;
                                obj42 = invalid$iv;
                                obj43 = $i$f$cache;
                                composer2.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), 0, 2, 0));
                            } else {
                                expandedState = $i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1;
                                obj42 = invalid$iv;
                                obj43 = $i$f$cache;
                                expandedState2 = rememberedValue2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            int i40 = 0;
                            int i45 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            this_$iv = consume;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 1468224270, str);
                            i18 = modifier3 & 7168 == 2048 ? 1 : i6;
                            Composer composer3 = restartGroup;
                            int i53 = 0;
                            rememberedValue = composer3.rememberedValue();
                            int i62 = 0;
                            if (i18 |= changed4 == 0) {
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i64 = 0;
                                    obj45 = this_$iv;
                                    AndroidMenu_androidKt.DropdownMenu.popupPositionProvider.1.1 density = new AndroidMenu_androidKt.DropdownMenu.popupPositionProvider.1.1((MutableState)expandedState2);
                                    obj43 = offset2;
                                    obj42 = dropdownMenuPositionProvider;
                                    super(obj43, scrollState, obj45, 0, (Function2)density, 4, 0);
                                    $i$a$CacheAndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1 = obj43;
                                    this_$iv = obj45;
                                    composer3.updateRememberedValue(obj42);
                                } else {
                                    $i$a$CacheAndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1 = offset2;
                                    offset2 = rememberedValue;
                                }
                            } else {
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            changedInstance = new AndroidMenu_androidKt.DropdownMenu.1(obj3, expandedState, expandedState2, obj, obj11, l2, obj34, f2, f3, i4, $changed);
                            obj46 = restartGroup;
                            AndroidPopup_androidKt.Popup((PopupPositionProvider)(DropdownMenuPositionProvider)offset2, obj7, obj10, (Function2)ComposableLambdaKt.rememberComposableLambda(2126968933, true, changedInstance, restartGroup, 54), obj46, i49 |= i56, 0);
                            composer = obj46;
                        } else {
                            expandedState = $i$a$CacheAndroidMenu_androidKt$DropdownMenu$expandedState$1;
                            composer = restartGroup;
                            $i$a$CacheAndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1 = offset2;
                        }
                    } else {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty4 = modifier3;
                    l = $i$a$CacheAndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1;
                    $dirty = obj3;
                    rememberScrollState = obj;
                    obj2 = obj11;
                    i7 = l2;
                    f = f2;
                    offset3 = f3;
                    obj8 = i4;
                    obj4 = obj10;
                } else {
                    restartGroup.skipToGroupEnd();
                    f = border;
                    obj8 = $composer;
                    obj54 = this_$iv;
                    composer = restartGroup;
                    obj2 = tonalElevation2;
                    l = offset2;
                    $dirty = $i$f$getDp;
                    i7 = tonalElevation;
                    offset3 = content;
                    obj4 = obj10;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty12 = obj54;
            endRestartGroup = new AndroidMenu_androidKt.DropdownMenu.2(expanded, onDismissRequest, $dirty, l, z, rememberScrollState, obj4, obj2, i7, obj10, f, offset3, obj8, $changed, i66, obj56, obj57);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $dirty12 = obj54;
        }
    }

    public static final void DropdownMenuItem(Function2<? super Composer, ? super Integer, Unit> text, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean enabled, androidx.compose.material3.MenuItemColors colors, PaddingValues contentPadding, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i12) {
        Object obj4;
        Object obj5;
        boolean traceInProgress;
        int contentPadding2;
        int defaultsInvalid;
        int itemColors;
        PaddingValues contentPadding3;
        Object restartGroup;
        int $dirty;
        int $dirty2;
        int i3;
        int i6;
        Object obj12;
        int i10;
        boolean traceInProgress2;
        Object str;
        Object obj;
        int i11;
        Object obj3;
        Object obj8;
        boolean z;
        int i;
        Object obj9;
        Object obj11;
        Object obj7;
        int i14;
        int obj10;
        Object obj2;
        int i7;
        Object obj6;
        boolean enabled2;
        int i8;
        Object colors2;
        int changed;
        int i9;
        int i13;
        int i16;
        int i5;
        int i4;
        int i2;
        Composer composer;
        int i15;
        final int i50 = $changed;
        final int i51 = i12;
        restartGroup = $composer.startRestartGroup(1826340448);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenuItem)P(7,6,5,4,8,2)194@8925L12,180@6505L319:AndroidMenu.android.kt#uh7d8r");
        $dirty = $changed;
        if (i51 & 1 != 0) {
            $dirty |= 6;
            obj2 = text;
        } else {
            if (i50 & 6 == 0) {
                i3 = restartGroup.changedInstance(text) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj2 = text;
            }
        }
        if (i51 & 2 != 0) {
            $dirty |= 48;
            obj6 = onClick;
        } else {
            if (i50 & 48 == 0) {
                i6 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i6;
            } else {
                obj6 = onClick;
            }
        }
        i10 = i51 & 4;
        if (i10 != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i50 & 384 == 0) {
                i11 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i11;
            } else {
                str = modifier;
            }
        }
        int i45 = i51 & 8;
        if (i45 != 0) {
            $dirty |= 3072;
            obj8 = leadingIcon;
        } else {
            if (i50 & 3072 == 0) {
                i = restartGroup.changedInstance(leadingIcon) ? 2048 : 1024;
                $dirty |= i;
            } else {
                obj8 = leadingIcon;
            }
        }
        int i47 = i51 & 16;
        if (i47 != 0) {
            $dirty |= 24576;
            obj11 = trailingIcon;
        } else {
            if (i50 & 24576 == 0) {
                i14 = restartGroup.changedInstance(trailingIcon) ? 16384 : 8192;
                $dirty |= i14;
            } else {
                obj11 = trailingIcon;
            }
        }
        int i49 = i51 & 32;
        int i52 = 196608;
        if (i49 != 0) {
            $dirty |= i52;
            enabled2 = enabled;
        } else {
            if (i52 &= i50 == 0) {
                i8 = restartGroup.changed(enabled) ? 131072 : 65536;
                $dirty |= i8;
            } else {
                enabled2 = enabled;
            }
        }
        if (i54 &= i50 == 0) {
            if (i51 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                colors2 = colors;
            }
            $dirty |= changed;
        } else {
            colors2 = colors;
        }
        int i18 = i51 & 128;
        int i57 = 12582912;
        if (i18 != 0) {
            $dirty |= i57;
            i9 = i18;
            obj4 = contentPadding;
        } else {
            if (i50 & i57 == 0) {
                i9 = i18;
                i13 = restartGroup.changed(contentPadding) ? 8388608 : 4194304;
                $dirty |= i13;
            } else {
                i9 = i18;
                obj4 = contentPadding;
            }
        }
        int i19 = i51 & 256;
        int i59 = 100663296;
        if (i19 != 0) {
            $dirty |= i59;
            i16 = i19;
            obj5 = interactionSource;
        } else {
            if (i50 & i59 == 0) {
                i16 = i19;
                i5 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i5;
            } else {
                i16 = i19;
                obj5 = interactionSource;
            }
        }
        final int obj32 = $dirty;
        if ($dirty & i4 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i30 = -3670017;
                if (i50 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i45 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        if (i47 != 0) {
                            obj11 = defaultsInvalid;
                        }
                        if (i49 != 0) {
                            enabled2 = defaultsInvalid;
                        }
                        if (i51 & 64 != 0) {
                            $dirty2 = obj32 & i30;
                            colors2 = itemColors;
                        } else {
                            $dirty2 = obj32;
                        }
                        if (i9 != 0) {
                            contentPadding3 = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            contentPadding3 = contentPadding;
                        }
                        if (i16 != 0) {
                            i4 = contentPadding3;
                            i2 = i10;
                            changed = obj11;
                            i9 = enabled2;
                            i16 = colors2;
                            contentPadding2 = 1826340448;
                            enabled2 = str;
                            colors2 = obj8;
                        } else {
                            i2 = interactionSource;
                            i4 = contentPadding3;
                            changed = obj11;
                            i9 = enabled2;
                            i16 = colors2;
                            contentPadding2 = 1826340448;
                            enabled2 = str;
                            colors2 = obj8;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i51 & 64 != 0) {
                            i4 = contentPadding;
                            i2 = interactionSource;
                            $dirty2 = i29;
                            changed = obj11;
                            i9 = enabled2;
                            i16 = colors2;
                            contentPadding2 = 1826340448;
                            enabled2 = str;
                            colors2 = obj8;
                        } else {
                            i4 = contentPadding;
                            i2 = interactionSource;
                            $dirty2 = obj32;
                            changed = obj11;
                            i9 = enabled2;
                            i16 = colors2;
                            contentPadding2 = 1826340448;
                            enabled2 = str;
                            colors2 = obj8;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(contentPadding2, $dirty2, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:179)");
                }
                MenuKt.DropdownMenuItemContent(obj2, obj6, enabled2, colors2, changed, i9, i16, i4, i2, restartGroup, i27 | i43);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i7 = $dirty2;
                obj12 = enabled2;
                obj = colors2;
                obj3 = changed;
                z = i9;
                obj9 = i16;
                obj7 = i4;
                obj10 = i2;
            } else {
                restartGroup.skipToGroupEnd();
                obj10 = interactionSource;
                i7 = obj32;
                composer = restartGroup;
                obj12 = str;
                obj = obj8;
                obj3 = obj11;
                z = enabled2;
                obj9 = colors2;
                obj7 = contentPadding;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AndroidMenu_androidKt.DropdownMenuItem.1(text, onClick, obj12, obj, obj3, z, obj9, obj7, obj10, i50, i51);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return AndroidMenu_androidKt.DefaultMenuProperties;
    }
}
