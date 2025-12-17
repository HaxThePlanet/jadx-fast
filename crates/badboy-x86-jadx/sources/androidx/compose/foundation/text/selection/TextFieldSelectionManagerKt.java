package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0008\u001a\"\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u000cH\u0000ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0010", d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "isSelectionHandleInVisibleBound", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldSelectionManagerKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[Handle.Cursor.ordinal()] = 1;
            iArr[Handle.SelectionStart.ordinal()] = 2;
            iArr[Handle.SelectionEnd.ordinal()] = 3;
            TextFieldSelectionManagerKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final void TextFieldSelectionHandle(boolean isStartHandle, ResolvedTextDirection direction, androidx.compose.foundation.text.selection.TextFieldSelectionManager manager, Composer $composer, int $changed) {
        int traceInProgress2;
        int i7;
        Object anon2;
        boolean z;
        int $dirty2;
        boolean $dirty;
        boolean traceInProgress;
        int i2;
        int i3;
        int i8;
        int str;
        int i;
        int companion;
        Modifier pointerInput;
        int i4;
        int i6;
        Object empty;
        Object obj;
        int i5;
        Object anon;
        Object $i$a$CacheTextFieldSelectionManagerKt$TextFieldSelectionHandle$observer$1;
        Object obj19;
        z = isStartHandle;
        final Object obj3 = direction;
        final Object obj5 = manager;
        final int i24 = $changed;
        traceInProgress2 = -1344558920;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(TextFieldSelectionHandle)P(1)1001@38955L90,1006@39093L44,1010@39319L71,1005@39051L346:TextFieldSelectionManager.kt#eksfi3");
        companion = 4;
        if (i24 & 6 == 0) {
            i2 = restartGroup.changed(z) ? companion : 2;
            $dirty2 |= i2;
        }
        if (i24 & 48 == 0) {
            i3 = restartGroup.changed(obj3) ? 32 : 16;
            $dirty2 |= i3;
        }
        if (i24 & 384 == 0) {
            i8 = restartGroup.changedInstance(obj5) ? 256 : 128;
            $dirty2 |= i8;
        }
        final int i25 = $dirty2;
        if (i25 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i25, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:1000)");
                }
                String str3 = "CC(remember):TextFieldSelectionManager.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 990782570, str3);
                int i19 = 0;
                i7 = i25 & 14 == companion ? i : i19;
                Composer composer3 = restartGroup;
                empty = 0;
                Object rememberedValue3 = composer3.rememberedValue();
                int i26 = 0;
                if (i7 |= changed3 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        int i27 = 0;
                        composer3.updateRememberedValue(obj5.handleDragObserver$foundation_release(z));
                    } else {
                        $i$a$CacheTextFieldSelectionManagerKt$TextFieldSelectionHandle$observer$1 = rememberedValue3;
                    }
                } else {
                }
                obj = $i$a$CacheTextFieldSelectionManagerKt$TextFieldSelectionHandle$observer$1;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 990786940, str3);
                if (i25 & 14 == companion) {
                } else {
                    i = i19;
                }
                Composer composer = restartGroup;
                Object rememberedValue = composer.rememberedValue();
                int i22 = 0;
                if (changedInstance |= i == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new TextFieldSelectionManagerKt.TextFieldSelectionHandle.1.1(obj5, z);
                        composer.updateRememberedValue((OffsetProvider)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                Object invalid$iv = anon;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                companion = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 990794199, str3);
                Composer composer2 = restartGroup;
                int i23 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                i5 = 0;
                if (!restartGroup.changedInstance((TextDragObserver)obj)) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        $i$a$CacheTextFieldSelectionManagerKt$TextFieldSelectionHandle$observer$1 = 0;
                        obj19 = invalid$iv;
                        anon2 = new TextFieldSelectionManagerKt.TextFieldSelectionHandle.2.1(obj, 0);
                        composer2.updateRememberedValue((Function2)anon2);
                    } else {
                        obj19 = invalid$iv;
                        anon2 = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AndroidSelectionHandles_androidKt.SelectionHandle-pzduO1o(obj19, isStartHandle, obj3, TextRange.getReversed-impl(obj5.getValue$foundation_release().getSelection-d9O1mEE()), 0, companion, SuspendingPointerInputFilterKt.pointerInput((Modifier)companion, obj, (Function2)anon2), restartGroup, i15 | i17);
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
            $dirty = new TextFieldSelectionManagerKt.TextFieldSelectionHandle.3(z, obj3, obj5, i24);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final long calculateSelectionMagnifierCenterAndroid-O0kMr_c(androidx.compose.foundation.text.selection.TextFieldSelectionManager manager, long magnifierSize) {
        int transformedText$foundation_release;
        int i;
        int start-impl;
        int $EnumSwitchMapping$0;
        long selection-d9O1mEE;
        Object state$foundation_release2;
        Object state$foundation_release;
        int cmp;
        float f;
        long localDragPosition2;
        long localDragPosition;
        int width-impl;
        int i2;
        Offset currentDragPosition-_m7T9-E = manager.getCurrentDragPosition-_m7T9-E();
        if (currentDragPosition-_m7T9-E != null) {
            long unbox-impl = currentDragPosition-_m7T9-E.unbox-impl();
            transformedText$foundation_release = manager.getTransformedText$foundation_release();
            int i5 = 0;
            if (transformedText$foundation_release != null) {
                transformedText$foundation_release = (CharSequence)transformedText$foundation_release.length() == 0 ? $EnumSwitchMapping$0 : i5;
                if (transformedText$foundation_release == 0) {
                } else {
                    $EnumSwitchMapping$0 = i5;
                }
            } else {
            }
            if ($EnumSwitchMapping$0 == 0) {
                return Offset.Companion.getUnspecified-F1C5BW0();
            }
            Handle draggingHandle = manager.getDraggingHandle();
            if (draggingHandle == null) {
                i = -1;
            } else {
                i = TextFieldSelectionManagerKt.WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
            }
            switch (i) {
                case -1:
                    long localDragPosition8 = unbox-impl;
                    return Offset.Companion.getUnspecified-F1C5BW0();
                case 0:
                    long l = unbox-impl;
                    NoWhenBranchMatchedException localDragPosition4 = new NoWhenBranchMatchedException();
                    throw localDragPosition4;
                case 1:
                    start-impl = TextRange.getStart-impl(manager.getValue$foundation_release().getSelection-d9O1mEE());
                    break;
                default:
                    start-impl = TextRange.getEnd-impl(manager.getValue$foundation_release().getSelection-d9O1mEE());
            }
            state$foundation_release2 = manager.getState$foundation_release();
            if (state$foundation_release2 != null) {
                state$foundation_release2 = state$foundation_release2.getLayoutResult();
                if (state$foundation_release2 == null) {
                    localDragPosition = unbox-impl;
                    return Offset.Companion.getUnspecified-F1C5BW0();
                } else {
                    state$foundation_release = manager.getState$foundation_release();
                    state$foundation_release = state$foundation_release.getTextDelegate();
                    if (state$foundation_release != null && state$foundation_release != null) {
                        state$foundation_release = state$foundation_release.getTextDelegate();
                        if (state$foundation_release != null) {
                            state$foundation_release = state$foundation_release.getText();
                            if (state$foundation_release == null) {
                                localDragPosition2 = unbox-impl;
                            } else {
                                int length2 = state$foundation_release.length();
                                float x-impl = Offset.getX-impl(state$foundation_release2.translateDecorationToInnerCoordinates-MK-Hz9U$foundation_release(unbox-impl));
                                TextLayoutResult value = state$foundation_release2.getValue();
                                final int lineForOffset = value.getLineForOffset(RangesKt.coerceIn(manager.getOffsetMapping$foundation_release().originalToTransformed(start-impl), i5, length2));
                                final float lineLeft = value.getLineLeft(lineForOffset);
                                final float lineRight = value.getLineRight(lineForOffset);
                                final float coerceIn2 = RangesKt.coerceIn(x-impl, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
                                long l2 = unbox-impl;
                                Object localDragPosition5 = magnifierSize;
                                if (!IntSize.equals-impl0(localDragPosition5, obj1)) {
                                    i2 = 2;
                                    if (Float.compare(f5, f) > 0) {
                                        return Offset.Companion.getUnspecified-F1C5BW0();
                                    }
                                } else {
                                    i2 = 2;
                                }
                            }
                            float lineTop = value.getLineTop(lineForOffset);
                            return OffsetKt.Offset(coerceIn2, i9 + lineTop);
                        }
                    }
                    localDragPosition2 = unbox-impl;
                }
                return Offset.Companion.getUnspecified-F1C5BW0();
            }
            localDragPosition = unbox-impl;
        }
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public static final boolean isSelectionHandleInVisibleBound(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this$isSelectionHandleInVisibleBound, boolean isStartHandle) {
        boolean inclusive-Uv8p0NA;
        Object layoutCoordinates;
        long handlePosition-tuRUvjQ$foundation_release;
        layoutCoordinates = $this$isSelectionHandleInVisibleBound.getState$foundation_release();
        layoutCoordinates = layoutCoordinates.getLayoutCoordinates();
        layoutCoordinates = SelectionManagerKt.visibleBounds(layoutCoordinates);
        if (layoutCoordinates != null && layoutCoordinates != null && layoutCoordinates != null) {
            layoutCoordinates = layoutCoordinates.getLayoutCoordinates();
            if (layoutCoordinates != null) {
                layoutCoordinates = SelectionManagerKt.visibleBounds(layoutCoordinates);
                if (layoutCoordinates != null) {
                    inclusive-Uv8p0NA = SelectionManagerKt.containsInclusive-Uv8p0NA(layoutCoordinates, $this$isSelectionHandleInVisibleBound.getHandlePosition-tuRUvjQ$foundation_release(isStartHandle));
                } else {
                    inclusive-Uv8p0NA = 0;
                }
            } else {
            }
        } else {
        }
        return inclusive-Uv8p0NA;
    }
}
