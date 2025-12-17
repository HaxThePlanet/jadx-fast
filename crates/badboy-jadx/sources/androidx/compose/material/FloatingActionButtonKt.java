package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0088\u0001\u0010\u0006\u001a\u00020\u00072\u0011\u0010\u0008\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0008\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00070\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0015\u0008\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\u0008\n2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001aq\u0010\u001a\u001a\u00020\u00072\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00070\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0008\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"ExtendedFabIconPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExtendedFabSize", "ExtendedFabTextPadding", "FabSize", "ExtendedFloatingActionButton", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "onClick", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "ExtendedFloatingActionButton-wqdebIU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButton", "content", "FloatingActionButton-bogVsAg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material/FloatingActionButtonElevation;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FloatingActionButtonKt {

    private static final float ExtendedFabIconPadding;
    private static final float ExtendedFabSize;
    private static final float ExtendedFabTextPadding;
    private static final float FabSize;
    static {
        int i5 = 0;
        FloatingActionButtonKt.FabSize = Dp.constructor-impl((float)i);
        int i6 = 0;
        FloatingActionButtonKt.ExtendedFabSize = Dp.constructor-impl((float)i2);
        int i7 = 0;
        FloatingActionButtonKt.ExtendedFabIconPadding = Dp.constructor-impl((float)i3);
        int i8 = 0;
        FloatingActionButtonKt.ExtendedFabTextPadding = Dp.constructor-impl((float)i4);
    }

    public static final void ExtendedFloatingActionButton-wqdebIU(Function2<? super Composer, ? super Integer, Unit> text, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, androidx.compose.material.FloatingActionButtonElevation elevation, Composer $composer, int $changed, int i12) {
        long l4;
        long l3;
        int traceInProgress;
        int defaultsInvalid;
        int copy;
        int $dirty5;
        int $dirty;
        boolean traceInProgress2;
        int obj9;
        Object elevation-xZ9-QkE;
        Function2 $composer2;
        int $dirty3;
        long $dirty4;
        Object $dirty2;
        int i4;
        int i15;
        int i10;
        Object obj;
        Object obj7;
        Object modifier2;
        int i9;
        int i3;
        int i18;
        Composer $composer3;
        Object obj8;
        Object i6;
        long icon2;
        int i13;
        int i5;
        Object obj6;
        long l;
        int i7;
        Object obj5;
        int changed;
        int i8;
        int changed3;
        Object obj2;
        Object obj3;
        int i14;
        int changed4;
        int i16;
        Modifier sizeIn-qDBjuR0$default;
        int changed2;
        Object i11;
        Object i17;
        int secondary-0d7_KjU;
        long contentColor2;
        long contentColor3;
        long l2;
        int i19;
        Object obj4;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i;
        int i2;
        androidx.compose.material.FloatingActionButtonDefaults obj29;
        int obj30;
        int obj31;
        int obj32;
        int obj33;
        Composer obj34;
        int obj35;
        int obj36;
        obj9 = text;
        final int i64 = obj39;
        final int i65 = obj40;
        elevation-xZ9-QkE = i12.startRestartGroup(-1555720195);
        ComposerKt.sourceInformation(elevation-xZ9-QkE, "C(ExtendedFloatingActionButton)P(8,6,5,3,4,7,0:c#ui.graphics.Color,1:c#ui.graphics.Color)152@7254L6,153@7342L6,154@7386L32,155@7496L11,168@7878L487,157@7516L849:FloatingActionButton.kt#jmzs0o");
        $dirty3 = obj39;
        if (i65 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i64 & 6 == 0) {
                i4 = elevation-xZ9-QkE.changedInstance(obj9) ? 4 : 2;
                $dirty3 |= i4;
            }
        }
        if (i65 & 2 != 0) {
            $dirty3 |= 48;
            obj3 = onClick;
        } else {
            if (i64 & 48 == 0) {
                i15 = elevation-xZ9-QkE.changedInstance(onClick) ? 32 : 16;
                $dirty3 |= i15;
            } else {
                obj3 = onClick;
            }
        }
        i10 = i65 & 4;
        if (i10 != 0) {
            $dirty3 |= 384;
            obj7 = modifier;
        } else {
            if (i64 & 384 == 0) {
                i9 = elevation-xZ9-QkE.changed(modifier) ? 256 : 128;
                $dirty3 |= i9;
            } else {
                obj7 = modifier;
            }
        }
        i3 = i65 & 8;
        if (i3 != 0) {
            $dirty3 |= 3072;
            i6 = icon;
        } else {
            if (i64 & 3072 == 0) {
                i13 = elevation-xZ9-QkE.changedInstance(icon) ? 2048 : 1024;
                $dirty3 |= i13;
            } else {
                i6 = icon;
            }
        }
        i5 = i65 & 16;
        if (i5 != 0) {
            $dirty3 |= 24576;
            obj6 = interactionSource;
        } else {
            if (i64 & 24576 == 0) {
                i7 = elevation-xZ9-QkE.changed(interactionSource) ? 16384 : 8192;
                $dirty3 |= i7;
            } else {
                obj6 = interactionSource;
            }
        }
        if (i57 &= i64 == 0) {
            if (i65 & 32 == 0) {
                changed = elevation-xZ9-QkE.changed(shape) ? 131072 : 65536;
            } else {
                obj5 = shape;
            }
            $dirty3 |= changed;
        } else {
            obj5 = shape;
        }
        if (i60 &= i64 == 0) {
            if (i65 & 64 == 0) {
                changed4 = elevation-xZ9-QkE.changed(backgroundColor) ? 1048576 : 524288;
            } else {
                l4 = backgroundColor;
            }
            $dirty3 |= changed4;
        } else {
            l4 = backgroundColor;
        }
        int i66 = 12582912;
        if (i64 & i66 == 0) {
            if (i65 & 128 == 0) {
                i8 = elevation-xZ9-QkE.changed(elevation) ? 8388608 : 4194304;
            } else {
                l3 = elevation;
            }
            $dirty3 |= i8;
        } else {
            l3 = elevation;
        }
        if (i61 &= i64 == 0) {
            if (i65 & 256 == 0) {
                changed2 = elevation-xZ9-QkE.changed($changed) ? 67108864 : 33554432;
            } else {
                obj2 = $changed;
            }
            $dirty3 |= changed2;
        } else {
            obj2 = $changed;
        }
        i17 = i66;
        if ($dirty3 & i11 == 38347922) {
            if (!elevation-xZ9-QkE.getSkipping()) {
                elevation-xZ9-QkE.startDefaults();
                int i31 = -234881025;
                i16 = -29360129;
                int i67 = -3670017;
                secondary-0d7_KjU = -458753;
                if (i64 & 1 != 0) {
                    if (elevation-xZ9-QkE.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            obj7 = defaultsInvalid;
                        }
                        if (i3 != 0) {
                            i6 = defaultsInvalid;
                        }
                        if (i5 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        i10 = 6;
                        if (i65 & 32 != 0) {
                            $dirty3 &= secondary-0d7_KjU;
                            obj5 = copy;
                        }
                        if (i65 & 64 != 0) {
                            $dirty5 = $dirty7;
                            $dirty4 = secondary-0d7_KjU;
                        } else {
                            $dirty5 = $dirty3;
                            $dirty4 = backgroundColor;
                        }
                        if (i65 & 128 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U($dirty4, i10, elevation-xZ9-QkE);
                            $dirty5 &= i16;
                        } else {
                            contentColor2 = elevation;
                        }
                        if (i65 & 256 != 0) {
                            obj34 = elevation-xZ9-QkE;
                            $composer3 = obj34;
                            obj4 = elevation-xZ9-QkE;
                            i11 = obj6;
                            l2 = contentColor2;
                            contentColor3 = $dirty4;
                            $dirty3 = $dirty6;
                            $dirty = i17;
                            i17 = obj5;
                        } else {
                            $composer3 = elevation-xZ9-QkE;
                            i11 = obj6;
                            obj4 = obj2;
                            l2 = contentColor2;
                            contentColor3 = $dirty4;
                            $dirty3 = $dirty5;
                            $dirty = i17;
                            i17 = obj5;
                        }
                    } else {
                        elevation-xZ9-QkE.skipToGroupEnd();
                        if (i65 & 32 != 0) {
                            $dirty3 &= secondary-0d7_KjU;
                        }
                        if (i65 & 64 != 0) {
                            $dirty3 &= i67;
                        }
                        if (i65 & 128 != 0) {
                            $dirty3 &= i16;
                        }
                        if (i65 & 256 != 0) {
                            contentColor3 = backgroundColor;
                            l2 = elevation;
                            $dirty3 = i30;
                            $composer3 = elevation-xZ9-QkE;
                            i11 = obj6;
                            obj4 = obj2;
                            $dirty = i17;
                            i17 = obj5;
                        } else {
                            contentColor3 = backgroundColor;
                            l2 = elevation;
                            $composer3 = elevation-xZ9-QkE;
                            i11 = obj6;
                            obj4 = obj2;
                            $dirty = i17;
                            i17 = obj5;
                        }
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555720195, $dirty3, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:156)");
                }
                FloatingActionButtonKt.ExtendedFloatingActionButton.1 anon = new FloatingActionButtonKt.ExtendedFloatingActionButton.1(i6, text);
                FloatingActionButtonKt.FloatingActionButton-bogVsAg(obj3, SizeKt.sizeIn-qDBjuR0$default(obj7, FloatingActionButtonKt.ExtendedFabSize, FloatingActionButtonKt.ExtendedFabSize, 0, 0, 12, 0), i11, i17, contentColor3, obj19, l2, i19, obj4, (Function2)ComposableLambdaKt.rememberComposableLambda(1418981691, true, anon, $composer3, 54), $composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i14 = $dirty3;
                $dirty2 = obj7;
                obj = i6;
                modifier2 = i11;
                obj8 = i17;
                icon2 = contentColor3;
                l = l2;
                obj2 = obj4;
            } else {
                elevation-xZ9-QkE.skipToGroupEnd();
                composer = elevation-xZ9-QkE;
                i14 = $dirty3;
                $dirty2 = obj7;
                obj = i6;
                modifier2 = obj6;
                obj8 = obj5;
                $composer2 = text;
                icon2 = backgroundColor;
                l = elevation;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new FloatingActionButtonKt.ExtendedFloatingActionButton.2($composer2, onClick, $dirty2, obj, modifier2, obj8, icon2, i5, l, obj5, obj2, i64, i65);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FloatingActionButton-bogVsAg(Function0<Unit> onClick, Modifier modifier, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, androidx.compose.material.FloatingActionButtonElevation elevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj4;
        int i10;
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier2;
        int modifier4;
        Object $i$a$CacheFloatingActionButtonKt$FloatingActionButton$interactionSource$1;
        int $dirty2;
        int i13;
        int i5;
        boolean traceInProgress;
        Object obj7;
        Object obj6;
        int copy;
        long backgroundColor4;
        Object modifier3;
        int i12;
        int backgroundColor2;
        Object obj3;
        Object obj8;
        int i9;
        long interactionSource2;
        int i;
        Object contentColorFor-ek8zF_U;
        long l3;
        int changed;
        long l;
        int $dirty;
        androidx.compose.material.FloatingActionButtonElevation $dirty3;
        Object obj2;
        int i7;
        int changed3;
        long l2;
        int i14;
        int changed4;
        int i2;
        int changed2;
        long i8;
        int i4;
        Object companion;
        Object obj5;
        long backgroundColor3;
        float unbox-impl;
        Object obj;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i3;
        int i6;
        int obj29;
        final Object obj11 = $changed;
        final int i55 = obj39;
        final int i56 = obj40;
        final Composer restartGroup = i11.startRestartGroup(1028985328);
        ComposerKt.sourceInformation(restartGroup, "C(FloatingActionButton)P(6,5,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)83@3890L6,84@3978L6,85@4022L32,86@4132L11,97@4531L28,99@4619L408,91@4310L717:FloatingActionButton.kt#jmzs0o");
        $dirty2 = obj39;
        if (i56 & 1 != 0) {
            $dirty2 |= 6;
            obj2 = onClick;
        } else {
            if (i55 & 6 == 0) {
                i13 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i13;
            } else {
                obj2 = onClick;
            }
        }
        int i26 = i56 & 2;
        if (i26 != 0) {
            $dirty2 |= 48;
            obj6 = modifier;
        } else {
            if (i55 & 48 == 0) {
                i12 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i12;
            } else {
                obj6 = modifier;
            }
        }
        backgroundColor2 = i56 & 4;
        if (backgroundColor2 != 0) {
            $dirty2 |= 384;
            obj8 = interactionSource;
        } else {
            if (i55 & 384 == 0) {
                i = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty2 |= i;
            } else {
                obj8 = interactionSource;
            }
        }
        if (i55 & 3072 == 0) {
            if (i56 & 8 == 0) {
                changed = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                contentColorFor-ek8zF_U = shape;
            }
            $dirty2 |= changed;
        } else {
            contentColorFor-ek8zF_U = shape;
        }
        if (i55 & 24576 == 0) {
            if (i56 & 16 == 0) {
                changed3 = restartGroup.changed(backgroundColor) ? 16384 : 8192;
            } else {
                l = backgroundColor;
            }
            $dirty2 |= changed3;
        } else {
            l = backgroundColor;
        }
        if (i57 &= i55 == 0) {
            if (i56 & 32 == 0) {
                changed4 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                l2 = elevation;
            }
            $dirty2 |= changed4;
        } else {
            l2 = elevation;
        }
        if (i55 & i60 == 0) {
            if (i56 & 64 == 0) {
                changed2 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj4 = $composer;
            }
            $dirty2 |= changed2;
        } else {
            obj4 = $composer;
        }
        i8 = 12582912;
        if (i56 & 128 != 0) {
            $dirty2 |= i8;
        } else {
            if (i55 & i8 == 0) {
                i10 = restartGroup.changedInstance(obj11) ? 8388608 : 4194304;
                $dirty2 |= i10;
            }
        }
        if (i16 &= $dirty2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i61 = -3670017;
                i5 = -458753;
                i4 = -57345;
                if (i55 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i26 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj6;
                        }
                        companion = backgroundColor2 != 0 ? obj6 : obj8;
                        backgroundColor2 = 6;
                        if (i56 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj5 = copy;
                        } else {
                            obj5 = contentColorFor-ek8zF_U;
                        }
                        if (i56 & 16 != 0) {
                            backgroundColor4 = MaterialTheme.INSTANCE.getColors(restartGroup, backgroundColor2).getSecondary-0d7_KjU();
                            $dirty2 &= i4;
                        } else {
                            backgroundColor4 = l;
                        }
                        if (i56 & 32 != 0) {
                            l2 = contentColorFor-ek8zF_U;
                            $dirty = $dirty2;
                        } else {
                            $dirty = $dirty2;
                        }
                        if (i56 & 64 != 0) {
                            $dirty2 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0, 0, 0, 0, restartGroup, 24576, 15);
                            obj6 = modifier2;
                            $dirty = i5;
                            obj8 = companion;
                            i2 = obj5;
                            i8 = backgroundColor3;
                            modifier4 = 1028985328;
                        } else {
                            $dirty2 = $composer;
                            obj6 = modifier2;
                            obj8 = companion;
                            i2 = obj5;
                            i8 = backgroundColor3;
                            modifier4 = 1028985328;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i56 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i56 & 16 != 0) {
                            $dirty2 &= i4;
                        }
                        if (i56 & 32 != 0) {
                            $dirty2 &= i5;
                        }
                        if (i56 & 64 != 0) {
                            $dirty2 = $composer;
                            i2 = contentColorFor-ek8zF_U;
                            i8 = l;
                            $dirty = i21;
                            modifier4 = 1028985328;
                        } else {
                            i2 = contentColorFor-ek8zF_U;
                            i8 = l;
                            modifier4 = 1028985328;
                            $dirty = $dirty2;
                            $dirty2 = $composer;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier4, $dirty, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:88)");
                }
                if (obj8 == null) {
                    restartGroup.startReplaceGroup(-1991754265);
                    ComposerKt.sourceInformation(restartGroup, "90@4266L39");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 628486523, "CC(remember):FloatingActionButton.kt#9igjgp");
                    traceInProgress = restartGroup;
                    backgroundColor2 = 0;
                    contentColorFor-ek8zF_U = traceInProgress.rememberedValue();
                    l = 0;
                    obj29 = i24;
                    if (contentColorFor-ek8zF_U == Composer.Companion.getEmpty()) {
                        int i25 = 0;
                        traceInProgress.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheFloatingActionButtonKt$FloatingActionButton$interactionSource$1 = contentColorFor-ek8zF_U;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                    obj = $i$a$CacheFloatingActionButtonKt$FloatingActionButton$interactionSource$1;
                } else {
                    restartGroup.startReplaceGroup(628485872);
                    restartGroup.endReplaceGroup();
                    obj = obj8;
                }
                int i52 = 1;
                FloatingActionButtonKt.FloatingActionButton.2 anon = new FloatingActionButtonKt.FloatingActionButton.2(l2, obj15, obj11);
                companion = l2;
                SurfaceKt.Surface-LPr_se0(obj2, SemanticsModifierKt.semantics$default(obj6, false, (Function1)FloatingActionButtonKt.FloatingActionButton.1.INSTANCE, i52, 0), false, i2, i8, i4, companion, obj5, 0, (Dp)$dirty2.elevation((InteractionSource)obj, restartGroup, i37 &= 112).getValue().unbox-impl(), obj, (Function2)ComposableLambdaKt.rememberComposableLambda(1972871863, i52, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj7 = obj6;
                modifier3 = obj8;
                i7 = $dirty;
                obj3 = i2;
                interactionSource2 = i8;
                l3 = companion;
                $dirty3 = $dirty2;
            } else {
                restartGroup.skipToGroupEnd();
                i7 = $dirty2;
                obj7 = obj6;
                modifier3 = obj8;
                composer = restartGroup;
                obj3 = contentColorFor-ek8zF_U;
                interactionSource2 = l;
                l3 = l2;
                $dirty3 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new FloatingActionButtonKt.FloatingActionButton.3(onClick, obj7, modifier3, obj3, interactionSource2, restartGroup, l3, l, $dirty3, obj11, i55, i56);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final float access$getExtendedFabIconPadding$p() {
        return FloatingActionButtonKt.ExtendedFabIconPadding;
    }

    public static final float access$getExtendedFabTextPadding$p() {
        return FloatingActionButtonKt.ExtendedFabTextPadding;
    }

    public static final float access$getFabSize$p() {
        return FloatingActionButtonKt.FabSize;
    }
}
