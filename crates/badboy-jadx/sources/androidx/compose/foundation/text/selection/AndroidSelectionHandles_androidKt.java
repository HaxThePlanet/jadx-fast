package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapConfig.Companion;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.DpSize.Companion;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0008\u0008H\u0001¢\u0006\u0002\u0010\t\u001aD\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001a+\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0019\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001a\"\u0010 \u001a\u00020\u0014*\u00020\u00142\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0019\u001a\u00020\rH\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006!", d2 = {"HandlePopup", "", "positionProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "offsetProvider", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "modifier", "Landroidx/compose/ui/Modifier;", "SelectionHandle-pzduO1o", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandleIcon", "iconVisible", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidSelectionHandles_androidKt {
    public static final void HandlePopup(androidx.compose.foundation.text.selection.OffsetProvider positionProvider, Alignment handleReferencePoint, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int i9;
        boolean traceInProgress;
        int $dirty2;
        int $dirty;
        boolean traceInProgress2;
        int i12;
        int i;
        int i4;
        int i14;
        int str;
        boolean changedInstance;
        int changed;
        int i13;
        Object empty;
        Object handlePositionProvider;
        PopupProperties popupProperties;
        int i11;
        int i8;
        int i10;
        int i2;
        int i6;
        int i7;
        int i3;
        int i5;
        final Object obj = positionProvider;
        final Object obj2 = handleReferencePoint;
        final Object obj5 = content;
        final int i25 = $changed;
        traceInProgress = 476043083;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(HandlePopup)P(2,1)248@8967L127,251@9099L190:AndroidSelectionHandles.android.kt#eksfi3");
        changed = 4;
        if (i25 & 6 == 0) {
            if (i25 & 8 == 0) {
                changedInstance = restartGroup.changed(obj);
            } else {
                changedInstance = restartGroup.changedInstance(obj);
            }
            i = changedInstance != null ? changed : 2;
            $dirty2 |= i;
        }
        i13 = 32;
        if (i25 & 48 == 0) {
            i4 = restartGroup.changed(obj2) ? i13 : 16;
            $dirty2 |= i4;
        }
        if (i25 & 384 == 0) {
            i14 = restartGroup.changedInstance(obj5) ? 256 : 128;
            $dirty2 |= i14;
        }
        final int i26 = $dirty2;
        if (i26 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i26, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:247)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1288574970, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                int i20 = 0;
                i9 = i26 & 112 == i13 ? i12 : i20;
                if (i26 & 14 != changed) {
                    if (i26 & 8 != 0 && restartGroup.changed(obj)) {
                        if (restartGroup.changed(obj)) {
                        } else {
                            i12 = i20;
                        }
                    } else {
                    }
                }
                Composer composer = restartGroup;
                int i21 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i24 = 0;
                if (i9 |= i12 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        handlePositionProvider = new HandlePositionProvider(obj2, obj);
                        composer.updateRememberedValue(handlePositionProvider);
                    } else {
                        handlePositionProvider = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                popupProperties = new PopupProperties(0, 0, 0, 0, 1, 0, 15, 0);
                AndroidPopup_androidKt.Popup((PopupPositionProvider)(HandlePositionProvider)handlePositionProvider, 0, popupProperties, obj5, restartGroup, i19 | 384, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new AndroidSelectionHandles_androidKt.HandlePopup.1(obj, obj2, obj5, i25);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final void SelectionHandle-pzduO1o(androidx.compose.foundation.text.selection.OffsetProvider offsetProvider, boolean isStartHandle, ResolvedTextDirection direction, boolean handlesCrossed, long minTouchTargetSize, Modifier modifier, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        Object endRestartGroup;
        int $dirty;
        boolean traceInProgress2;
        Alignment topRight;
        Object $i$a$CacheAndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1;
        int i10;
        int i7;
        int i12;
        int i11;
        int i14;
        int i4;
        int minTouchTargetSize2;
        int companion;
        int changedInstance;
        int i5;
        int defaultsInvalid;
        int changed;
        boolean changedInstance2;
        int i13;
        int i8;
        int i3;
        int semantics$default;
        long minTouchTargetSize3;
        boolean z2;
        Object obj2;
        int i2;
        Object obj;
        boolean z;
        long handleReferencePoint;
        int i6;
        int i;
        long l;
        Composer.Companion companion2;
        Object obj22;
        Alignment obj25;
        final Object obj3 = offsetProvider;
        z2 = isStartHandle;
        obj2 = $composer;
        i2 = i9;
        traceInProgress = -843755800;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SelectionHandle)P(5,2!2,3:c#ui.unit.DpSize)69@3042L326,80@3475L7,81@3579L1272,81@3487L1364:AndroidSelectionHandles.android.kt#eksfi3");
        $dirty = i9;
        i8 = 4;
        if (obj27 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i2 & 6 == 0) {
                if (i2 & 8 == 0) {
                    changedInstance2 = restartGroup.changed(obj3);
                } else {
                    changedInstance2 = restartGroup.changedInstance(obj3);
                }
                i10 = changedInstance2 ? i8 : 2;
                $dirty |= i10;
            }
        }
        i3 = 32;
        if (obj27 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i2 & 48 == 0) {
                i7 = restartGroup.changed(z2) ? i3 : 16;
                $dirty |= i7;
            }
        }
        if (obj27 & 4 != 0) {
            $dirty |= 384;
            obj = direction;
        } else {
            if (i2 & 384 == 0) {
                i12 = restartGroup.changed(direction) ? 256 : 128;
                $dirty |= i12;
            } else {
                obj = direction;
            }
        }
        if (obj27 & 8 != 0) {
            $dirty |= 3072;
            z = handlesCrossed;
        } else {
            if (i2 & 3072 == 0) {
                i11 = restartGroup.changed(handlesCrossed) ? 2048 : 1024;
                $dirty |= i11;
            } else {
                z = handlesCrossed;
            }
        }
        if (i2 & 24576 == 0) {
            if (obj27 & 16 == 0) {
                i14 = restartGroup.changed(minTouchTargetSize) ? 16384 : 8192;
            } else {
                handleReferencePoint = minTouchTargetSize;
            }
            $dirty |= i14;
        } else {
            handleReferencePoint = minTouchTargetSize;
        }
        int i28 = 196608;
        if (obj27 & 32 != 0) {
            $dirty |= i28;
        } else {
            if (i2 & i28 == 0) {
                i4 = restartGroup.changed(obj2) ? 131072 : 65536;
                $dirty |= i4;
            }
        }
        if (i16 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i29 = -57345;
                if (i2 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj27 & 16 != 0) {
                            handleReferencePoint = DpSize.Companion.getUnspecified-MYxV2XQ();
                            i = $dirty;
                        } else {
                            i = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj27 & 16 != 0) {
                            i = $dirty;
                        } else {
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:64)");
                }
                boolean leftSelectionHandle = SelectionHandlesKt.isLeftSelectionHandle(isStartHandle, direction, handlesCrossed);
                AbsoluteAlignment iNSTANCE = AbsoluteAlignment.INSTANCE;
                if (leftSelectionHandle) {
                    topRight = iNSTANCE.getTopRight();
                } else {
                    topRight = iNSTANCE.getTopLeft();
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -785126383, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                if (i & 14 != i8) {
                    if (i & 8 != 0 && restartGroup.changedInstance(obj3)) {
                        if (restartGroup.changedInstance(obj3)) {
                            i5 = 1;
                        } else {
                            i5 = 0;
                        }
                    } else {
                    }
                } else {
                }
                i13 = i & 112 == i3 ? 1 : 0;
                Composer composer = restartGroup;
                int i25 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i30 = 0;
                if (i18 |= changed6 == 0) {
                    obj25 = topRight;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        companion2 = handleReferencePoint2;
                        $i$a$CacheAndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1 = new AndroidSelectionHandles_androidKt.SelectionHandle.semanticsModifier.1.1(obj3, z2, leftSelectionHandle);
                        composer.updateRememberedValue((Function1)$i$a$CacheAndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1);
                    } else {
                        $i$a$CacheAndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1 = rememberedValue;
                    }
                } else {
                    obj25 = topRight;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i21 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume;
                long l2 = handleReferencePoint;
                AndroidSelectionHandles_androidKt.SelectionHandle.1 anon = new AndroidSelectionHandles_androidKt.SelectionHandle.1((ViewConfiguration)this_$iv, l2, 0, leftSelectionHandle, SemanticsModifierKt.semantics$default(obj2, false, (Function1)$i$a$CacheAndroidSelectionHandles_androidKt$SelectionHandle$semanticsModifier$1, 1, 0), obj3);
                obj22 = this_$iv;
                AndroidSelectionHandles_androidKt.HandlePopup(obj3, obj25, (Function2)ComposableLambdaKt.rememberComposableLambda(280174801, true, anon, restartGroup, 54), restartGroup, i15 |= 384);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                handleReferencePoint = l;
            } else {
                restartGroup.skipToGroupEnd();
                i = $dirty;
            }
        } else {
        }
        endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new AndroidSelectionHandles_androidKt.SelectionHandle.2(obj3, z2, obj, z, handleReferencePoint, obj3, obj2, i2, obj27);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            minTouchTargetSize3 = handleReferencePoint;
        }
    }

    public static final void SelectionHandleIcon(Modifier modifier, Function0<Boolean> iconVisible, boolean isLeft, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i2;
        int i3;
        int i;
        boolean skipping;
        boolean traceInProgress2;
        int str;
        traceInProgress = 2111672474;
        final Composer obj7 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj7, "C(SelectionHandleIcon)P(2)123@5009L129:AndroidSelectionHandles.android.kt#eksfi3");
        if ($changed & 6 == 0) {
            i2 = obj7.changed(modifier) ? 4 : 2;
            $dirty |= i2;
        }
        if ($changed & 48 == 0) {
            i3 = obj7.changedInstance(iconVisible) ? 32 : 16;
            $dirty |= i3;
        }
        if ($changed & 384 == 0) {
            i = obj7.changed(isLeft) ? 256 : 128;
            $dirty |= i;
        }
        if ($dirty & 147 == 146) {
            if (!obj7.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:122)");
                }
                SpacerKt.Spacer(AndroidSelectionHandles_androidKt.drawSelectionHandle(SizeKt.size-VpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), iconVisible, isLeft), obj7, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj7.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj7.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new AndroidSelectionHandles_androidKt.SelectionHandleIcon.1(modifier, iconVisible, isLeft, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope $this$createHandleImage, float radius) {
        ImageBitmap imageBitmap;
        Canvas canvas;
        CanvasDrawScope drawScope;
        androidx.compose.foundation.text.selection.HandleImageCache iNSTANCE;
        int height;
        int alpha8-_sVssgQ;
        int i;
        int i5;
        int i2;
        int i3;
        int i4;
        ImageBitmap imageBitmap2;
        Canvas canvas2;
        CanvasDrawScope canvasDrawScope;
        final float f4 = radius;
        iNSTANCE = i6 * 2;
        imageBitmap = HandleImageCache.INSTANCE.getImageBitmap();
        canvas = HandleImageCache.INSTANCE.getCanvas();
        drawScope = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap != null && canvas != null && iNSTANCE <= imageBitmap.getWidth()) {
            if (canvas != null) {
                if (iNSTANCE <= imageBitmap.getWidth()) {
                    if (iNSTANCE > imageBitmap.getHeight()) {
                        imageBitmap = ImageBitmapKt.ImageBitmap-x__-hDU$default(iNSTANCE, iNSTANCE, ImageBitmapConfig.Companion.getAlpha8-_sVssgQ(), false, 0, 24, 0);
                        i4 = iNSTANCE;
                        HandleImageCache.INSTANCE.setImageBitmap(imageBitmap);
                        canvas = CanvasKt.Canvas(imageBitmap);
                        HandleImageCache.INSTANCE.setCanvas(canvas);
                        imageBitmap2 = imageBitmap;
                        canvas2 = canvas;
                    } else {
                        i4 = iNSTANCE;
                        imageBitmap2 = imageBitmap;
                        canvas2 = canvas;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (drawScope == null) {
            CanvasDrawScope canvasDrawScope2 = new CanvasDrawScope();
            drawScope = canvasDrawScope2;
            HandleImageCache.INSTANCE.setCanvasDrawScope(drawScope);
            canvasDrawScope = drawScope;
        } else {
            canvasDrawScope = drawScope;
        }
        androidx.compose.ui.unit.LayoutDirection layoutDirection = $this$createHandleImage.getLayoutDirection();
        float f3 = (float)height2;
        long l = SizeKt.Size((float)width, f3);
        final CanvasDrawScope canvasDrawScope3 = canvasDrawScope;
        final int i12 = 0;
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope3.getDrawParams();
        androidx.compose.ui.unit.Density component1 = drawParams2.component1();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope3.getDrawParams();
        int i9 = 0;
        androidx.compose.ui.unit.Density density = $this$createHandleImage;
        drawParams3.setDensity((Density)density);
        drawParams3.setLayoutDirection(layoutDirection);
        drawParams3.setCanvas(canvas2);
        drawParams3.setSize-uvyYCjk(l);
        canvas2.save();
        CanvasDrawScope canvasDrawScope4 = canvasDrawScope3;
        final int i21 = 0;
        final int i20 = 0;
        final int i14 = 0;
        final int i15 = 0;
        final int i16 = 0;
        DrawScope.drawRect-n-J9OG0$default(canvasDrawScope4, Color.Companion.getBlack-0d7_KjU(), obj20, 0, obj22, (DrawScope)canvasDrawScope4.getSize-NH-jbRc(), obj24, i14, i15, i16);
        long l4 = 4278190080L;
        DrawScope.drawRect-n-J9OG0$default(canvasDrawScope4, ColorKt.Color(l4), obj20, Offset.Companion.getZero-F1C5BW0(), obj22, SizeKt.Size(f4, f4), obj24, i14, i15, i16);
        final long l7 = l;
        androidx.compose.ui.unit.LayoutDirection $this$createHandleImage_u24lambda_u241 = layoutDirection;
        int prevDensity$iv = i4;
        DrawScope.drawCircle-VaOC9Bg$default(canvasDrawScope4, ColorKt.Color(l4), f3, f4, OffsetKt.Offset(f4, f4), component1, 0, 0, 0, 0);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope3.getDrawParams();
        int i7 = 0;
        drawParams.setDensity(component1);
        drawParams.setLayoutDirection(drawParams2.component2());
        drawParams.setCanvas(drawParams2.component3());
        drawParams.setSize-uvyYCjk(drawParams2.component4-NH-jbRc());
        return imageBitmap2;
    }

    public static final Modifier drawSelectionHandle(Modifier $this$drawSelectionHandle, Function0<Boolean> iconVisible, boolean isLeft) {
        AndroidSelectionHandles_androidKt.drawSelectionHandle.1 anon = new AndroidSelectionHandles_androidKt.drawSelectionHandle.1(iconVisible, isLeft);
        final int i2 = 0;
        return ComposedModifierKt.composed$default($this$drawSelectionHandle, i2, (Function3)anon, 1, i2);
    }
}
