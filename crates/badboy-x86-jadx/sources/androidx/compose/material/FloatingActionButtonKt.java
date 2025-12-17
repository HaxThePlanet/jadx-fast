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
        long l3;
        long l4;
        int traceInProgress;
        int defaultsInvalid;
        int copy;
        int $dirty2;
        int $dirty3;
        boolean traceInProgress2;
        int obj9;
        Object elevation-xZ9-QkE;
        Function2 $composer2;
        int $dirty4;
        long $dirty;
        Object $dirty5;
        int i13;
        int i9;
        int i10;
        Object obj3;
        Object obj;
        Object modifier2;
        int i18;
        int i4;
        int i17;
        Composer $composer3;
        Object obj2;
        Object i2;
        long icon2;
        int i7;
        int i8;
        Object obj6;
        long l2;
        int i11;
        Object obj8;
        int changed2;
        int i19;
        int changed3;
        Object obj7;
        Object obj4;
        int i6;
        int changed;
        int i14;
        Modifier sizeIn-qDBjuR0$default;
        int changed4;
        Object i5;
        Object i15;
        int secondary-0d7_KjU;
        long contentColor2;
        long contentColor3;
        long l;
        int i3;
        Object obj5;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i16;
        int i;
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
        $dirty4 = obj39;
        if (i65 & 1 != 0) {
            $dirty4 |= 6;
        } else {
            if (i64 & 6 == 0) {
                i13 = elevation-xZ9-QkE.changedInstance(obj9) ? 4 : 2;
                $dirty4 |= i13;
            }
        }
        if (i65 & 2 != 0) {
            $dirty4 |= 48;
            obj4 = onClick;
        } else {
            if (i64 & 48 == 0) {
                i9 = elevation-xZ9-QkE.changedInstance(onClick) ? 32 : 16;
                $dirty4 |= i9;
            } else {
                obj4 = onClick;
            }
        }
        i10 = i65 & 4;
        if (i10 != 0) {
            $dirty4 |= 384;
            obj = modifier;
        } else {
            if (i64 & 384 == 0) {
                i18 = elevation-xZ9-QkE.changed(modifier) ? 256 : 128;
                $dirty4 |= i18;
            } else {
                obj = modifier;
            }
        }
        i4 = i65 & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
            i2 = icon;
        } else {
            if (i64 & 3072 == 0) {
                i7 = elevation-xZ9-QkE.changedInstance(icon) ? 2048 : 1024;
                $dirty4 |= i7;
            } else {
                i2 = icon;
            }
        }
        i8 = i65 & 16;
        if (i8 != 0) {
            $dirty4 |= 24576;
            obj6 = interactionSource;
        } else {
            if (i64 & 24576 == 0) {
                i11 = elevation-xZ9-QkE.changed(interactionSource) ? 16384 : 8192;
                $dirty4 |= i11;
            } else {
                obj6 = interactionSource;
            }
        }
        if (i57 &= i64 == 0) {
            if (i65 & 32 == 0) {
                changed2 = elevation-xZ9-QkE.changed(shape) ? 131072 : 65536;
            } else {
                obj8 = shape;
            }
            $dirty4 |= changed2;
        } else {
            obj8 = shape;
        }
        if (i60 &= i64 == 0) {
            if (i65 & 64 == 0) {
                changed = elevation-xZ9-QkE.changed(backgroundColor) ? 1048576 : 524288;
            } else {
                l3 = backgroundColor;
            }
            $dirty4 |= changed;
        } else {
            l3 = backgroundColor;
        }
        int i66 = 12582912;
        if (i64 & i66 == 0) {
            if (i65 & 128 == 0) {
                i19 = elevation-xZ9-QkE.changed(elevation) ? 8388608 : 4194304;
            } else {
                l4 = elevation;
            }
            $dirty4 |= i19;
        } else {
            l4 = elevation;
        }
        if (i61 &= i64 == 0) {
            if (i65 & 256 == 0) {
                changed4 = elevation-xZ9-QkE.changed($changed) ? 67108864 : 33554432;
            } else {
                obj7 = $changed;
            }
            $dirty4 |= changed4;
        } else {
            obj7 = $changed;
        }
        i15 = i66;
        if ($dirty4 & i5 == 38347922) {
            if (!elevation-xZ9-QkE.getSkipping()) {
                elevation-xZ9-QkE.startDefaults();
                int i31 = -234881025;
                i14 = -29360129;
                int i67 = -3670017;
                secondary-0d7_KjU = -458753;
                if (i64 & 1 != 0) {
                    if (elevation-xZ9-QkE.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (i4 != 0) {
                            i2 = defaultsInvalid;
                        }
                        if (i8 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        i10 = 6;
                        if (i65 & 32 != 0) {
                            $dirty4 &= secondary-0d7_KjU;
                            obj8 = copy;
                        }
                        if (i65 & 64 != 0) {
                            $dirty2 = $dirty7;
                            $dirty = secondary-0d7_KjU;
                        } else {
                            $dirty2 = $dirty4;
                            $dirty = backgroundColor;
                        }
                        if (i65 & 128 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U($dirty, i10, elevation-xZ9-QkE);
                            $dirty2 &= i14;
                        } else {
                            contentColor2 = elevation;
                        }
                        if (i65 & 256 != 0) {
                            obj34 = elevation-xZ9-QkE;
                            $composer3 = obj34;
                            obj5 = elevation-xZ9-QkE;
                            i5 = obj6;
                            l = contentColor2;
                            contentColor3 = $dirty;
                            $dirty4 = $dirty6;
                            $dirty3 = i15;
                            i15 = obj8;
                        } else {
                            $composer3 = elevation-xZ9-QkE;
                            i5 = obj6;
                            obj5 = obj7;
                            l = contentColor2;
                            contentColor3 = $dirty;
                            $dirty4 = $dirty2;
                            $dirty3 = i15;
                            i15 = obj8;
                        }
                    } else {
                        elevation-xZ9-QkE.skipToGroupEnd();
                        if (i65 & 32 != 0) {
                            $dirty4 &= secondary-0d7_KjU;
                        }
                        if (i65 & 64 != 0) {
                            $dirty4 &= i67;
                        }
                        if (i65 & 128 != 0) {
                            $dirty4 &= i14;
                        }
                        if (i65 & 256 != 0) {
                            contentColor3 = backgroundColor;
                            l = elevation;
                            $dirty4 = i30;
                            $composer3 = elevation-xZ9-QkE;
                            i5 = obj6;
                            obj5 = obj7;
                            $dirty3 = i15;
                            i15 = obj8;
                        } else {
                            contentColor3 = backgroundColor;
                            l = elevation;
                            $composer3 = elevation-xZ9-QkE;
                            i5 = obj6;
                            obj5 = obj7;
                            $dirty3 = i15;
                            i15 = obj8;
                        }
                    }
                } else {
                }
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1555720195, $dirty4, -1, "androidx.compose.material.ExtendedFloatingActionButton (FloatingActionButton.kt:156)");
                }
                FloatingActionButtonKt.ExtendedFloatingActionButton.1 anon = new FloatingActionButtonKt.ExtendedFloatingActionButton.1(i2, text);
                FloatingActionButtonKt.FloatingActionButton-bogVsAg(obj4, SizeKt.sizeIn-qDBjuR0$default(obj, FloatingActionButtonKt.ExtendedFabSize, FloatingActionButtonKt.ExtendedFabSize, 0, 0, 12, 0), i5, i15, contentColor3, obj19, l, i3, obj5, (Function2)ComposableLambdaKt.rememberComposableLambda(1418981691, true, anon, $composer3, 54), $composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i6 = $dirty4;
                $dirty5 = obj;
                obj3 = i2;
                modifier2 = i5;
                obj2 = i15;
                icon2 = contentColor3;
                l2 = l;
                obj7 = obj5;
            } else {
                elevation-xZ9-QkE.skipToGroupEnd();
                composer = elevation-xZ9-QkE;
                i6 = $dirty4;
                $dirty5 = obj;
                obj3 = i2;
                modifier2 = obj6;
                obj2 = obj8;
                $composer2 = text;
                icon2 = backgroundColor;
                l2 = elevation;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new FloatingActionButtonKt.ExtendedFloatingActionButton.2($composer2, onClick, $dirty5, obj3, modifier2, obj2, icon2, i8, l2, obj8, obj7, i64, i65);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FloatingActionButton-bogVsAg(Function0<Unit> onClick, Modifier modifier, MutableInteractionSource interactionSource, Shape shape, long backgroundColor, long contentColor, androidx.compose.material.FloatingActionButtonElevation elevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object obj7;
        int i9;
        int traceInProgress2;
        int defaultsInvalid;
        Object modifier4;
        int modifier3;
        Object $i$a$CacheFloatingActionButtonKt$FloatingActionButton$interactionSource$1;
        int $dirty2;
        int i13;
        int i8;
        boolean traceInProgress;
        Object obj4;
        Object obj2;
        int copy;
        long backgroundColor3;
        Object modifier2;
        int i10;
        int backgroundColor4;
        Object obj;
        Object obj8;
        int i;
        long interactionSource2;
        int i4;
        Object contentColorFor-ek8zF_U;
        long l3;
        int changed;
        long l2;
        int $dirty3;
        androidx.compose.material.FloatingActionButtonElevation $dirty;
        Object obj3;
        int i7;
        int changed2;
        long l;
        int i14;
        int changed3;
        int i2;
        int changed4;
        long i3;
        int i5;
        Object companion;
        Object obj6;
        long backgroundColor2;
        float unbox-impl;
        Object obj5;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i6;
        int i12;
        int obj29;
        final Object obj11 = $changed;
        final int i55 = obj39;
        final int i56 = obj40;
        final Composer restartGroup = i11.startRestartGroup(1028985328);
        ComposerKt.sourceInformation(restartGroup, "C(FloatingActionButton)P(6,5,4,7,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)83@3890L6,84@3978L6,85@4022L32,86@4132L11,97@4531L28,99@4619L408,91@4310L717:FloatingActionButton.kt#jmzs0o");
        $dirty2 = obj39;
        if (i56 & 1 != 0) {
            $dirty2 |= 6;
            obj3 = onClick;
        } else {
            if (i55 & 6 == 0) {
                i13 = restartGroup.changedInstance(onClick) ? 4 : 2;
                $dirty2 |= i13;
            } else {
                obj3 = onClick;
            }
        }
        int i26 = i56 & 2;
        if (i26 != 0) {
            $dirty2 |= 48;
            obj2 = modifier;
        } else {
            if (i55 & 48 == 0) {
                i10 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i10;
            } else {
                obj2 = modifier;
            }
        }
        backgroundColor4 = i56 & 4;
        if (backgroundColor4 != 0) {
            $dirty2 |= 384;
            obj8 = interactionSource;
        } else {
            if (i55 & 384 == 0) {
                i4 = restartGroup.changed(interactionSource) ? 256 : 128;
                $dirty2 |= i4;
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
                changed2 = restartGroup.changed(backgroundColor) ? 16384 : 8192;
            } else {
                l2 = backgroundColor;
            }
            $dirty2 |= changed2;
        } else {
            l2 = backgroundColor;
        }
        if (i57 &= i55 == 0) {
            if (i56 & 32 == 0) {
                changed3 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                l = elevation;
            }
            $dirty2 |= changed3;
        } else {
            l = elevation;
        }
        if (i55 & i60 == 0) {
            if (i56 & 64 == 0) {
                changed4 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj7 = $composer;
            }
            $dirty2 |= changed4;
        } else {
            obj7 = $composer;
        }
        i3 = 12582912;
        if (i56 & 128 != 0) {
            $dirty2 |= i3;
        } else {
            if (i55 & i3 == 0) {
                i9 = restartGroup.changedInstance(obj11) ? 8388608 : 4194304;
                $dirty2 |= i9;
            }
        }
        if (i16 &= $dirty2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i61 = -3670017;
                i8 = -458753;
                i5 = -57345;
                if (i55 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i26 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = obj2;
                        }
                        companion = backgroundColor4 != 0 ? obj2 : obj8;
                        backgroundColor4 = 6;
                        if (i56 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj6 = copy;
                        } else {
                            obj6 = contentColorFor-ek8zF_U;
                        }
                        if (i56 & 16 != 0) {
                            backgroundColor3 = MaterialTheme.INSTANCE.getColors(restartGroup, backgroundColor4).getSecondary-0d7_KjU();
                            $dirty2 &= i5;
                        } else {
                            backgroundColor3 = l2;
                        }
                        if (i56 & 32 != 0) {
                            l = contentColorFor-ek8zF_U;
                            $dirty3 = $dirty2;
                        } else {
                            $dirty3 = $dirty2;
                        }
                        if (i56 & 64 != 0) {
                            $dirty2 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0, 0, 0, 0, restartGroup, 24576, 15);
                            obj2 = modifier4;
                            $dirty3 = i8;
                            obj8 = companion;
                            i2 = obj6;
                            i3 = backgroundColor2;
                            modifier3 = 1028985328;
                        } else {
                            $dirty2 = $composer;
                            obj2 = modifier4;
                            obj8 = companion;
                            i2 = obj6;
                            i3 = backgroundColor2;
                            modifier3 = 1028985328;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i56 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i56 & 16 != 0) {
                            $dirty2 &= i5;
                        }
                        if (i56 & 32 != 0) {
                            $dirty2 &= i8;
                        }
                        if (i56 & 64 != 0) {
                            $dirty2 = $composer;
                            i2 = contentColorFor-ek8zF_U;
                            i3 = l2;
                            $dirty3 = i21;
                            modifier3 = 1028985328;
                        } else {
                            i2 = contentColorFor-ek8zF_U;
                            i3 = l2;
                            modifier3 = 1028985328;
                            $dirty3 = $dirty2;
                            $dirty2 = $composer;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier3, $dirty3, -1, "androidx.compose.material.FloatingActionButton (FloatingActionButton.kt:88)");
                }
                if (obj8 == null) {
                    restartGroup.startReplaceGroup(-1991754265);
                    ComposerKt.sourceInformation(restartGroup, "90@4266L39");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 628486523, "CC(remember):FloatingActionButton.kt#9igjgp");
                    traceInProgress = restartGroup;
                    backgroundColor4 = 0;
                    contentColorFor-ek8zF_U = traceInProgress.rememberedValue();
                    l2 = 0;
                    obj29 = i24;
                    if (contentColorFor-ek8zF_U == Composer.Companion.getEmpty()) {
                        int i25 = 0;
                        traceInProgress.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheFloatingActionButtonKt$FloatingActionButton$interactionSource$1 = contentColorFor-ek8zF_U;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                    obj5 = $i$a$CacheFloatingActionButtonKt$FloatingActionButton$interactionSource$1;
                } else {
                    restartGroup.startReplaceGroup(628485872);
                    restartGroup.endReplaceGroup();
                    obj5 = obj8;
                }
                int i52 = 1;
                FloatingActionButtonKt.FloatingActionButton.2 anon = new FloatingActionButtonKt.FloatingActionButton.2(l, obj15, obj11);
                companion = l;
                SurfaceKt.Surface-LPr_se0(obj3, SemanticsModifierKt.semantics$default(obj2, false, (Function1)FloatingActionButtonKt.FloatingActionButton.1.INSTANCE, i52, 0), false, i2, i3, i5, companion, obj6, 0, (Dp)$dirty2.elevation((InteractionSource)obj5, restartGroup, i37 &= 112).getValue().unbox-impl(), obj5, (Function2)ComposableLambdaKt.rememberComposableLambda(1972871863, i52, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj2;
                modifier2 = obj8;
                i7 = $dirty3;
                obj = i2;
                interactionSource2 = i3;
                l3 = companion;
                $dirty = $dirty2;
            } else {
                restartGroup.skipToGroupEnd();
                i7 = $dirty2;
                obj4 = obj2;
                modifier2 = obj8;
                composer = restartGroup;
                obj = contentColorFor-ek8zF_U;
                interactionSource2 = l2;
                l3 = l;
                $dirty = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new FloatingActionButtonKt.FloatingActionButton.3(onClick, obj4, modifier2, obj, interactionSource2, restartGroup, l3, l2, $dirty, obj11, i55, i56);
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
