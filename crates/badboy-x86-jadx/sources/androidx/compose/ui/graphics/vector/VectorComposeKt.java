package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u00052\u0008\u0008\u0002\u0010\n\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00052\u000e\u0008\u0002\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\u0008\u0011¢\u0006\u0002\u0008\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a¦\u0001\u0010\u0014\u001a\u00020\u00012\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\r2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00052\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020\u00052\u0008\u0008\u0002\u0010#\u001a\u00020\u00052\u0008\u0008\u0002\u0010$\u001a\u00020\u00052\u0008\u0008\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006(", d2 = {"Group", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VectorComposeKt {
    public static final void Group(String name, float rotation, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends androidx.compose.ui.graphics.vector.PathNode> clipPathData, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        float f7;
        float f3;
        float f6;
        Object obj;
        int i;
        boolean traceInProgress;
        int scaleY2;
        int defaultsInvalid;
        int $dirty;
        Object obj3;
        int i2;
        float f5;
        int translationX2;
        Object obj2;
        float name2;
        int i7;
        float translationY3;
        int translationY2;
        float f2;
        float rotation2;
        int i15;
        int clipPathData3;
        Object clipPathData2;
        float f;
        int pivotX2;
        int i8;
        int i5;
        boolean traceInProgress2;
        float i3;
        List pivotY2;
        int i6;
        int str;
        float f4;
        int i9;
        int i11;
        int iNSTANCE;
        int i10;
        int i12;
        int i4;
        int i14;
        int changedInstance;
        int obj21;
        int obj22;
        androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1 obj23;
        int obj24;
        int obj25;
        final Object obj5 = content;
        final int i39 = $changed;
        final int i40 = i13;
        final Composer restartGroup = $composer.startRestartGroup(-213417674);
        ComposerKt.sourceInformation(restartGroup, "C(Group)P(2,5,3,4,6,7,8,9)58@2500L585:VectorCompose.kt#huu6hf");
        $dirty = $changed;
        int i27 = i40 & 1;
        if (i27 != 0) {
            $dirty |= 6;
            obj2 = name;
        } else {
            if (i39 & 6 == 0) {
                i7 = restartGroup.changed(name) ? 4 : 2;
                $dirty |= i7;
            } else {
                obj2 = name;
            }
        }
        int i31 = i40 & 2;
        if (i31 != 0) {
            $dirty |= 48;
            f2 = rotation;
        } else {
            if (i39 & 48 == 0) {
                i15 = restartGroup.changed(rotation) ? 32 : 16;
                $dirty |= i15;
            } else {
                f2 = rotation;
            }
        }
        int i33 = i40 & 4;
        if (i33 != 0) {
            $dirty |= 384;
            f = pivotX;
        } else {
            if (i39 & 384 == 0) {
                i8 = restartGroup.changed(pivotX) ? 256 : 128;
                $dirty |= i8;
            } else {
                f = pivotX;
            }
        }
        int i36 = i40 & 8;
        if (i36 != 0) {
            $dirty |= 3072;
            i3 = pivotY;
        } else {
            if (i39 & 3072 == 0) {
                i6 = restartGroup.changed(pivotY) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                i3 = pivotY;
            }
        }
        str = i40 & 16;
        if (str != null) {
            $dirty |= 24576;
            f4 = scaleX;
        } else {
            if (i39 & 24576 == 0) {
                i9 = restartGroup.changed(scaleX) ? 16384 : 8192;
                $dirty |= i9;
            } else {
                f4 = scaleX;
            }
        }
        int i42 = i40 & 32;
        iNSTANCE = 196608;
        if (i42 != 0) {
            $dirty |= iNSTANCE;
            f7 = scaleY;
        } else {
            if (i39 & iNSTANCE == null) {
                i10 = restartGroup.changed(scaleY) ? 131072 : 65536;
                $dirty |= i10;
            } else {
                f7 = scaleY;
            }
        }
        int i43 = i40 & 64;
        i12 = 1572864;
        if (i43 != 0) {
            $dirty |= i12;
            f3 = translationX;
        } else {
            if (i39 & i12 == 0) {
                i12 = restartGroup.changed(translationX) ? 1048576 : 524288;
                $dirty |= i12;
            } else {
                f3 = translationX;
            }
        }
        int i17 = i40 & 128;
        int i44 = 12582912;
        if (i17 != 0) {
            $dirty |= i44;
            i4 = i17;
            f6 = translationY;
        } else {
            if (i39 & i44 == 0) {
                i4 = i17;
                i14 = restartGroup.changed(translationY) ? 8388608 : 4194304;
                $dirty |= i14;
            } else {
                i4 = i17;
                f6 = translationY;
            }
        }
        if (i39 & i46 == 0) {
            if (i40 & 256 == 0) {
                changedInstance = restartGroup.changedInstance(clipPathData) ? 67108864 : 33554432;
            } else {
                obj = clipPathData;
            }
            $dirty |= changedInstance;
        } else {
            obj = clipPathData;
        }
        int i47 = 805306368;
        if (i40 & 512 != 0) {
            $dirty |= i47;
        } else {
            if (i39 & i47 == 0) {
                i = restartGroup.changedInstance(obj5) ? 536870912 : 268435456;
                $dirty |= i;
            }
        }
        final int obj31 = $dirty;
        if (i18 &= $dirty == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i26 = -234881025;
                if (i39 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i27 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i31 != 0) {
                            f2 = defaultsInvalid;
                        }
                        if (i33 != 0) {
                            f = defaultsInvalid;
                        }
                        if (i36 != 0) {
                            i3 = defaultsInvalid;
                        }
                        if (str != null) {
                            f4 = defaultsInvalid;
                        }
                        scaleY2 = i42 != 0 ? 1065353216 : scaleY;
                        translationX2 = i43 != 0 ? 0 : translationX;
                        translationY2 = i4 != 0 ? 0 : translationY;
                        if (i40 & 256 != 0) {
                            clipPathData2 = VectorKt.getEmptyPath();
                            i2 = obj31 & i26;
                        } else {
                            clipPathData2 = clipPathData;
                            i2 = obj31;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i40 & 256 != 0) {
                            translationX2 = translationX;
                            translationY2 = translationY;
                            clipPathData2 = clipPathData;
                            i2 = i24;
                            scaleY2 = scaleY;
                        } else {
                            scaleY2 = scaleY;
                            translationX2 = translationX;
                            translationY2 = translationY;
                            clipPathData2 = clipPathData;
                            i2 = obj31;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    obj21 = scaleY2;
                    ComposerKt.traceEventStart(-213417674, i2, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                } else {
                    obj21 = scaleY2;
                }
                androidx.compose.ui.graphics.vector.VectorComposeKt.Group.1 scaleY3 = VectorComposeKt.Group.1.INSTANCE;
                str = 0;
                obj22 = translationX2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -548224868, "CC(ComposeNode)P(1,2)336@12596L9:Composables.kt#9igjgp");
                if (!applier instanceof VectorApplier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode((Function0)scaleY3);
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                obj23 = scaleY3;
                Updater.set-impl(constructor-impl, obj2, (Function2)VectorComposeKt.Group.2.1.INSTANCE);
                obj24 = i28;
                Updater.set-impl(constructor-impl, Float.valueOf(f2), (Function2)VectorComposeKt.Group.2.2.INSTANCE);
                Updater.set-impl(constructor-impl, Float.valueOf(f), (Function2)VectorComposeKt.Group.2.3.INSTANCE);
                Updater.set-impl(constructor-impl, Float.valueOf(i3), (Function2)VectorComposeKt.Group.2.4.INSTANCE);
                Updater.set-impl(constructor-impl, Float.valueOf(f4), (Function2)VectorComposeKt.Group.2.5.INSTANCE);
                Updater.set-impl(constructor-impl, Float.valueOf(obj21), (Function2)VectorComposeKt.Group.2.6.INSTANCE);
                Updater.set-impl(constructor-impl, Float.valueOf(obj22), (Function2)VectorComposeKt.Group.2.7.INSTANCE);
                Updater.set-impl(constructor-impl, Float.valueOf(translationY2), (Function2)VectorComposeKt.Group.2.8.INSTANCE);
                Updater.set-impl(constructor-impl, clipPathData2, (Function2)VectorComposeKt.Group.2.9.INSTANCE);
                Composer composer = restartGroup;
                obj24 = i20;
                obj25 = i29;
                ComposerKt.sourceInformationMarkerStart(composer, 541925533, "C72@3070L9:VectorCompose.kt#huu6hf");
                obj5.invoke(composer, Integer.valueOf(i21 &= 14));
                ComposerKt.sourceInformationMarkerEnd(composer);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj2;
                i5 = translationY2;
                name2 = f;
                translationY3 = i3;
                pivotX2 = obj22;
                pivotY2 = clipPathData2;
                clipPathData3 = obj21;
                f5 = f2;
                rotation2 = f4;
            } else {
                restartGroup.skipToGroupEnd();
                clipPathData3 = scaleY;
                i5 = translationY;
                i11 = obj31;
                obj3 = obj2;
                name2 = f;
                translationY3 = i3;
                pivotX2 = translationX;
                pivotY2 = clipPathData;
                f5 = f2;
                rotation2 = f4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new VectorComposeKt.Group.4(obj3, f5, name2, translationY3, rotation2, clipPathData3, pivotX2, i5, pivotY2, obj5, i39, i40);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void Path-9cdaXJ4(List<? extends androidx.compose.ui.graphics.vector.PathNode> pathData, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset, Composer $composer, int $changed, int $changed1, int i18) {
        int skipping;
        int pathFillType2;
        Composer composer;
        Object endRestartGroup;
        int i15;
        float f6;
        int i2;
        Object name3;
        int name2;
        float f3;
        int i27;
        int i3;
        float f;
        float f2;
        float f4;
        int trimPathOffset2;
        Object obj3;
        Object $composer2;
        int $dirty;
        float $dirty2;
        int $dirty12;
        Object $dirty1;
        int i19;
        Object fill3;
        float fill2;
        Object obj4;
        int fillAlpha3;
        int fillAlpha2;
        Object obj;
        Object stroke2;
        int stroke3;
        float f5;
        int strokeLineWidth2;
        int strokeLineWidth3;
        Object obj2;
        int strokeLineCap3;
        int strokeLineCap2;
        int i10;
        int strokeLineJoin2;
        int strokeLineJoin3;
        int i28;
        int strokeLineMiter3;
        int strokeLineMiter2;
        float f7;
        int strokeAlpha2;
        int changed3;
        int trimPathStart2;
        int i12;
        int trimPathEnd2;
        int i25;
        Composer $composer3;
        int iNSTANCE;
        int i21;
        int i14;
        int i24;
        int i7;
        int i16;
        int i17;
        int i11;
        int i22;
        int changed2;
        int i9;
        int i26;
        int i6;
        int i5;
        int i8;
        int i4;
        int i20;
        int i23;
        int i13;
        int i;
        boolean changed;
        ScopeUpdateScope scopeUpdateScope;
        int obj35;
        int obj36;
        int obj37;
        androidx.compose.ui.graphics.vector.VectorComposeKt.Path.1 obj38;
        int obj48;
        Object obj5 = pathData;
        final int i49 = $changed;
        int i29 = $changed1;
        int i30 = i18;
        Composer restartGroup = $composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation(restartGroup, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)115@5068L876:VectorCompose.kt#huu6hf");
        $dirty = $changed;
        $dirty12 = $changed1;
        if (i30 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i49 & 6 == 0) {
                i19 = restartGroup.changedInstance(obj5) ? 4 : 2;
                $dirty |= i19;
            }
        }
        int i43 = i30 & 2;
        if (i43 != 0) {
            $dirty |= 48;
            i10 = pathFillType;
        } else {
            if (i49 & 48 == 0) {
                i28 = restartGroup.changed(pathFillType) ? 32 : 16;
                $dirty |= i28;
            } else {
                i10 = pathFillType;
            }
        }
        int i48 = i30 & 4;
        if (i48 != 0) {
            $dirty |= 384;
            obj4 = name;
        } else {
            if (i49 & 384 == 0) {
                i12 = restartGroup.changed(name) ? 256 : changed3;
                $dirty |= i12;
            } else {
                obj4 = name;
            }
        }
        trimPathEnd2 = i30 & 8;
        iNSTANCE = 1024;
        if (trimPathEnd2 != 0) {
            $dirty |= 3072;
            obj = fill;
        } else {
            if (i49 & 3072 == 0) {
                i16 = restartGroup.changed(fill) ? i25 : iNSTANCE;
                $dirty |= i16;
            } else {
                obj = fill;
            }
        }
        int i51 = i30 & 16;
        if (i51 != 0) {
            $dirty |= 24576;
            f5 = fillAlpha;
        } else {
            if (i49 & 24576 == 0) {
                i22 = restartGroup.changed(fillAlpha) ? 16384 : 8192;
                $dirty |= i22;
            } else {
                f5 = fillAlpha;
            }
        }
        int i52 = i30 & 32;
        changed2 = 196608;
        if (i52 != 0) {
            $dirty |= changed2;
            obj2 = stroke;
        } else {
            if (i49 & changed2 == 0) {
                i9 = restartGroup.changed(stroke) ? 131072 : 65536;
                $dirty |= i9;
            } else {
                obj2 = stroke;
            }
        }
        int i53 = i30 & 64;
        i26 = 1572864;
        if (i53 != 0) {
            $dirty |= i26;
            f7 = strokeAlpha;
        } else {
            if (i49 & i26 == 0) {
                i6 = restartGroup.changed(strokeAlpha) ? 1048576 : 524288;
                $dirty |= i6;
            } else {
                f7 = strokeAlpha;
            }
        }
        int i33 = i30 & 128;
        int i54 = 12582912;
        if (i33 != 0) {
            $dirty |= i54;
            i5 = i33;
            f3 = strokeLineWidth;
        } else {
            if (i49 & i54 == 0) {
                i5 = i33;
                i8 = restartGroup.changed(strokeLineWidth) ? 8388608 : 4194304;
                $dirty |= i8;
            } else {
                i5 = i33;
                f3 = strokeLineWidth;
            }
        }
        int i34 = i30 & 256;
        int i56 = 100663296;
        if (i34 != 0) {
            $dirty |= i56;
            i4 = i34;
            i27 = strokeLineCap;
        } else {
            if (i49 & i56 == 0) {
                i4 = i34;
                i20 = restartGroup.changed(strokeLineCap) ? 67108864 : 33554432;
                $dirty |= i20;
            } else {
                i4 = i34;
                i27 = strokeLineCap;
            }
        }
        int i35 = i30 & 512;
        int i58 = 805306368;
        if (i35 != 0) {
            $dirty |= i58;
            i23 = i35;
            i3 = strokeLineJoin;
        } else {
            if (i49 & i58 == 0) {
                i23 = i35;
                i13 = restartGroup.changed(strokeLineJoin) ? 536870912 : 268435456;
                $dirty |= i13;
            } else {
                i23 = i35;
                i3 = strokeLineJoin;
            }
        }
        int i36 = i30 & 1024;
        if (i36 != 0) {
            $dirty12 |= 6;
            i = i36;
            f = strokeLineMiter;
        } else {
            if (i29 & 6 == 0) {
                i = i36;
                i14 = restartGroup.changed(strokeLineMiter) ? 4 : 2;
                $dirty12 |= i14;
            } else {
                i = i36;
                f = strokeLineMiter;
            }
        }
        int i37 = i30 & 2048;
        if (i37 != 0) {
            $dirty12 |= 48;
            i24 = i37;
            f2 = trimPathStart;
        } else {
            if (i29 & 48 == 0) {
                i24 = i37;
                i17 = restartGroup.changed(trimPathStart) ? 32 : 16;
                $dirty12 |= i17;
            } else {
                i24 = i37;
                f2 = trimPathStart;
            }
        }
        int i38 = i30 & 4096;
        if (i38 != 0) {
            $dirty12 |= 384;
            i11 = i38;
            f4 = trimPathEnd;
        } else {
            i11 = i38;
            if (i29 & 384 == 0) {
                if (restartGroup.changed(trimPathEnd)) {
                    changed3 = 256;
                }
                $dirty12 |= changed3;
            } else {
                f4 = trimPathEnd;
            }
        }
        int i40 = i30 & 8192;
        if (i40 != 0) {
            $dirty12 |= 3072;
            f6 = trimPathOffset;
        } else {
            if (i29 & 3072 == 0) {
                if (restartGroup.changed(trimPathOffset)) {
                } else {
                    i25 = iNSTANCE;
                }
                $dirty12 |= i25;
            } else {
                f6 = trimPathOffset;
            }
        }
        if ($dirty & trimPathStart2 == 306783378 && $dirty12 & 1171 == 1170) {
            if ($dirty12 & 1171 == 1170) {
                if (!restartGroup.getSkipping()) {
                    if (i43 != 0) {
                        pathFillType2 = VectorKt.getDefaultFillType();
                    } else {
                        pathFillType2 = i10;
                    }
                    name3 = i48 != 0 ? "" : obj4;
                    fill3 = trimPathEnd2 != 0 ? 0 : obj;
                    fillAlpha3 = i51 != 0 ? 1065353216 : f5;
                    stroke2 = i52 != 0 ? 0 : obj2;
                    if (i53 != 0) {
                        f7 = f5;
                    }
                    strokeLineWidth2 = i5 != 0 ? 0 : strokeLineWidth;
                    if (i4 != 0) {
                        strokeLineCap3 = VectorKt.getDefaultStrokeLineCap();
                    } else {
                        strokeLineCap3 = strokeLineCap;
                    }
                    if (i23 != 0) {
                        strokeLineJoin2 = VectorKt.getDefaultStrokeLineJoin();
                    } else {
                        strokeLineJoin2 = strokeLineJoin;
                    }
                    strokeLineMiter3 = i != 0 ? 1082130432 : strokeLineMiter;
                    trimPathStart2 = i24 != 0 ? 0 : trimPathStart;
                    trimPathEnd2 = i11 != 0 ? 1065353216 : trimPathEnd;
                    trimPathOffset2 = i40 != 0 ? 0 : trimPathOffset;
                    if (ComposerKt.isTraceInProgress()) {
                        obj35 = pathFillType2;
                        obj36 = trimPathOffset2;
                        ComposerKt.traceEventStart(-1478270750, $dirty, $dirty12, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:114)");
                    } else {
                        obj35 = pathFillType2;
                        obj36 = trimPathOffset2;
                    }
                    androidx.compose.ui.graphics.vector.VectorComposeKt.Path.1 pathFillType3 = VectorComposeKt.Path.1.INSTANCE;
                    i25 = 0;
                    obj37 = i41;
                    obj48 = $dirty;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1886828752, "CC(ComposeNode):Composables.kt#9igjgp");
                    if (!applier instanceof VectorApplier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode((Function0)pathFillType3);
                    } else {
                        restartGroup.useNode();
                    }
                    Composer constructor-impl = Updater.constructor-impl(restartGroup);
                    int i42 = 0;
                    obj38 = pathFillType3;
                    Updater.set-impl(constructor-impl, name3, (Function2)VectorComposeKt.Path.2.1.INSTANCE);
                    Updater.set-impl(constructor-impl, obj5, (Function2)VectorComposeKt.Path.2.2.INSTANCE);
                    Updater.set-impl(constructor-impl, PathFillType.box-impl(obj35), (Function2)VectorComposeKt.Path.2.3.INSTANCE);
                    Updater.set-impl(constructor-impl, fill3, (Function2)VectorComposeKt.Path.2.4.INSTANCE);
                    Updater.set-impl(constructor-impl, Float.valueOf(fillAlpha3), (Function2)VectorComposeKt.Path.2.5.INSTANCE);
                    Updater.set-impl(constructor-impl, stroke2, (Function2)VectorComposeKt.Path.2.6.INSTANCE);
                    Updater.set-impl(constructor-impl, Float.valueOf(f7), (Function2)VectorComposeKt.Path.2.7.INSTANCE);
                    Updater.set-impl(constructor-impl, Float.valueOf(strokeLineWidth2), (Function2)VectorComposeKt.Path.2.8.INSTANCE);
                    Updater.set-impl(constructor-impl, StrokeJoin.box-impl(strokeLineJoin2), (Function2)VectorComposeKt.Path.2.9.INSTANCE);
                    Updater.set-impl(constructor-impl, StrokeCap.box-impl(strokeLineCap3), (Function2)VectorComposeKt.Path.2.10.INSTANCE);
                    Updater.set-impl(constructor-impl, Float.valueOf(strokeLineMiter3), (Function2)VectorComposeKt.Path.2.11.INSTANCE);
                    Updater.set-impl(constructor-impl, Float.valueOf(trimPathStart2), (Function2)VectorComposeKt.Path.2.12.INSTANCE);
                    Updater.set-impl(constructor-impl, Float.valueOf(trimPathEnd2), (Function2)VectorComposeKt.Path.2.13.INSTANCE);
                    Updater.set-impl(constructor-impl, Float.valueOf(obj36), (Function2)VectorComposeKt.Path.2.14.INSTANCE);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj3 = name3;
                    composer = restartGroup;
                    i15 = $dirty12;
                    $composer2 = fill3;
                    $dirty2 = fillAlpha3;
                    $dirty1 = stroke2;
                    fillAlpha2 = strokeLineWidth2;
                    stroke3 = strokeLineCap3;
                    strokeLineWidth3 = strokeLineJoin2;
                    strokeLineCap2 = strokeLineMiter3;
                    fill2 = f7;
                    strokeLineJoin3 = trimPathStart2;
                    strokeLineMiter2 = trimPathEnd2;
                    name2 = obj35;
                    strokeAlpha2 = obj36;
                } else {
                    restartGroup.skipToGroupEnd();
                    strokeLineMiter2 = trimPathEnd;
                    composer = restartGroup;
                    obj48 = $dirty;
                    i15 = $dirty12;
                    obj3 = obj4;
                    $composer2 = obj;
                    $dirty2 = f5;
                    $dirty1 = obj2;
                    name2 = i10;
                    fill2 = f7;
                    fillAlpha2 = strokeLineWidth;
                    stroke3 = strokeLineCap;
                    strokeLineWidth3 = strokeLineJoin;
                    strokeLineCap2 = strokeLineMiter;
                    strokeLineJoin3 = trimPathStart;
                    strokeAlpha2 = trimPathOffset;
                }
            } else {
            }
        } else {
        }
        obj35 = composer;
        endRestartGroup = obj35.endRestartGroup();
        if (endRestartGroup != null) {
            $composer3 = obj35;
            i7 = obj48;
            i21 = i15;
            endRestartGroup = new VectorComposeKt.Path.3(pathData, name2, obj3, $composer2, $dirty2, $dirty1, fill2, fillAlpha2, stroke3, strokeLineWidth3, strokeLineCap2, strokeLineJoin3, strokeLineMiter2, strokeAlpha2, i49, $changed1, i18);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer3 = obj35;
            i7 = obj48;
            i21 = i15;
        }
    }
}
