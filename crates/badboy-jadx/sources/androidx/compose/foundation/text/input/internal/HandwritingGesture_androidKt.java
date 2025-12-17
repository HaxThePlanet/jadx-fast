package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextGranularity.Companion;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextInclusionStrategy.Companion;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0007\u001a\"\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a&\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a(\u0010\u001b\u001a\u00020\u0001*\u00020 2\u0006\u0010\u001d\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010!\u001a2\u0010\u001b\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00162\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%\u001a<\u0010&\u001a\u00020\t*\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+\u001a.\u0010,\u001a\u00020\t*\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\u00083\u00104\u001a.\u0010,\u001a\u00020\t*\u00020 2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\u00083\u00105\u001a:\u0010,\u001a\u00020\t*\u0004\u0018\u00010\u00142\u0006\u0010-\u001a\u00020.2\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\u00086\u00107\u001a6\u00108\u001a\u00020\t*\u00020\u001c2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<\u001a6\u00108\u001a\u00020\t*\u00020 2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\u0008;\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020'2\u0006\u0010@\u001a\u00020\u0001H\u0002\u001a\u000c\u0010A\u001a\u00020?*\u00020\u0001H\u0002\u001a\u000c\u0010B\u001a\u00020?*\u00020\u0001H\u0002\u001a\u000c\u0010C\u001a\u00020?*\u00020\u0001H\u0002\u001a\u000c\u0010D\u001a\u00020?*\u00020\u0001H\u0002\u001a\u0019\u0010E\u001a\u00020\t*\u00020\u00102\u0006\u0010@\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010F\u001a\u0011\u0010G\u001a\u00020\u0016*\u00020HH\u0002¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006J", d2 = {"LINE_FEED_CODE_POINT", "", "NBSP_CODE_POINT", "compoundEditCommand", "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", "", "([Landroidx/compose/ui/text/input/EditCommand;)Landroidx/compose/ui/text/input/EditCommand;", "enclosure", "Landroidx/compose/ui/text/TextRange;", "a", "b", "enclosure-pWDy79M", "(JJ)J", "adjustHandwritingDeleteGestureRange", "text", "", "adjustHandwritingDeleteGestureRange-72CqOWE", "(JLjava/lang/CharSequence;)J", "getLineForHandwritingGesture", "Landroidx/compose/ui/text/MultiParagraph;", "localPoint", "Landroidx/compose/ui/geometry/Offset;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getLineForHandwritingGesture-d-4ec7I", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "getOffsetForHandwritingGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "pointInScreen", "getOffsetForHandwritingGesture-d-4ec7I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getOffsetForHandwritingGesture-ubNVwUQ", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)I", "getRangeForRemoveSpaceGesture", "Landroidx/compose/ui/text/TextLayoutResult;", "startPointInScreen", "endPointerInScreen", "getRangeForRemoveSpaceGesture-5iVPX68", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)J", "getRangeForScreenRect", "rectInScreen", "Landroidx/compose/ui/geometry/Rect;", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForScreenRect-OH9lIzo", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRect-O048IG0", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/layout/LayoutCoordinates;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRects", "startRectInScreen", "endRectInScreen", "getRangeForScreenRects-O048IG0", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "isBiDiBoundary", "", "offset", "isNewline", "isPunctuation", "isWhitespace", "isWhitespaceExceptNewline", "rangeOfWhitespaces", "(Ljava/lang/CharSequence;I)J", "toOffset", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HandwritingGesture_androidKt {

    private static final int LINE_FEED_CODE_POINT = 10;
    private static final int NBSP_CODE_POINT = 160;
    public static final long access$adjustHandwritingDeleteGestureRange-72CqOWE(long $receiver, java.lang.CharSequence text) {
        return HandwritingGesture_androidKt.adjustHandwritingDeleteGestureRange-72CqOWE($receiver, text);
    }

    public static final EditCommand access$compoundEditCommand(EditCommand... editCommands) {
        return HandwritingGesture_androidKt.compoundEditCommand(editCommands);
    }

    public static final int access$getOffsetForHandwritingGesture-d-4ec7I(LegacyTextFieldState $receiver, long pointInScreen, ViewConfiguration viewConfiguration) {
        return HandwritingGesture_androidKt.getOffsetForHandwritingGesture-d-4ec7I($receiver, pointInScreen, viewConfiguration);
    }

    public static final int access$getOffsetForHandwritingGesture-d-4ec7I(androidx.compose.foundation.text.input.internal.TextLayoutState $receiver, long pointInScreen, ViewConfiguration viewConfiguration) {
        return HandwritingGesture_androidKt.getOffsetForHandwritingGesture-d-4ec7I($receiver, pointInScreen, viewConfiguration);
    }

    public static final long access$getRangeForRemoveSpaceGesture-5iVPX68(TextLayoutResult $receiver, long startPointInScreen, long endPointerInScreen, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        return HandwritingGesture_androidKt.getRangeForRemoveSpaceGesture-5iVPX68($receiver, startPointInScreen, endPointerInScreen, layoutCoordinates, viewConfiguration);
    }

    public static final long access$getRangeForScreenRect-OH9lIzo(LegacyTextFieldState $receiver, Rect rectInScreen, int granularity, TextInclusionStrategy inclusionStrategy) {
        return HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo($receiver, rectInScreen, granularity, inclusionStrategy);
    }

    public static final long access$getRangeForScreenRect-OH9lIzo(androidx.compose.foundation.text.input.internal.TextLayoutState $receiver, Rect rectInScreen, int granularity, TextInclusionStrategy inclusionStrategy) {
        return HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo($receiver, rectInScreen, granularity, inclusionStrategy);
    }

    public static final long access$getRangeForScreenRects-O048IG0(LegacyTextFieldState $receiver, Rect startRectInScreen, Rect endRectInScreen, int granularity, TextInclusionStrategy inclusionStrategy) {
        return HandwritingGesture_androidKt.getRangeForScreenRects-O048IG0($receiver, startRectInScreen, endRectInScreen, granularity, inclusionStrategy);
    }

    public static final long access$getRangeForScreenRects-O048IG0(androidx.compose.foundation.text.input.internal.TextLayoutState $receiver, Rect startRectInScreen, Rect endRectInScreen, int granularity, TextInclusionStrategy inclusionStrategy) {
        return HandwritingGesture_androidKt.getRangeForScreenRects-O048IG0($receiver, startRectInScreen, endRectInScreen, granularity, inclusionStrategy);
    }

    public static final boolean access$isBiDiBoundary(TextLayoutResult $receiver, int offset) {
        return HandwritingGesture_androidKt.isBiDiBoundary($receiver, offset);
    }

    public static final long access$rangeOfWhitespaces(java.lang.CharSequence $receiver, int offset) {
        return HandwritingGesture_androidKt.rangeOfWhitespaces($receiver, offset);
    }

    public static final long access$toOffset(PointF $receiver) {
        return HandwritingGesture_androidKt.toOffset($receiver);
    }

    private static final long adjustHandwritingDeleteGestureRange-72CqOWE(long $this$adjustHandwritingDeleteGestureRange_u2d72CqOWE, java.lang.CharSequence text) {
        int start;
        int end;
        int codePointAtEnd;
        int codePointBeforeStart;
        boolean whitespaceExceptNewline;
        boolean whitespaceExceptNewline2;
        start = TextRange.getStart-impl($this$adjustHandwritingDeleteGestureRange_u2d72CqOWE);
        end = TextRange.getEnd-impl($this$adjustHandwritingDeleteGestureRange_u2d72CqOWE);
        if (start > 0) {
            codePointBeforeStart = Character.codePointBefore(obj8, start);
        } else {
            codePointBeforeStart = codePointAtEnd;
        }
        if (end < obj8.length()) {
            codePointAtEnd = Character.codePointAt(obj8, end);
        } else {
        }
        if (HandwritingGesture_androidKt.isWhitespaceExceptNewline(codePointBeforeStart) && !HandwritingGesture_androidKt.isWhitespace(codePointAtEnd) && HandwritingGesture_androidKt.isPunctuation(codePointAtEnd)) {
            if (!HandwritingGesture_androidKt.isWhitespace(codePointAtEnd)) {
                if (HandwritingGesture_androidKt.isPunctuation(codePointAtEnd)) {
                }
            }
            return TextRangeKt.TextRange(start, end);
        }
        if (HandwritingGesture_androidKt.isWhitespaceExceptNewline(codePointAtEnd) && !HandwritingGesture_androidKt.isWhitespace(codePointBeforeStart) && HandwritingGesture_androidKt.isPunctuation(codePointBeforeStart)) {
            if (!HandwritingGesture_androidKt.isWhitespace(codePointBeforeStart)) {
                if (HandwritingGesture_androidKt.isPunctuation(codePointBeforeStart)) {
                }
            }
            return TextRangeKt.TextRange(start, end);
        }
        return $this$adjustHandwritingDeleteGestureRange_u2d72CqOWE;
    }

    private static final EditCommand compoundEditCommand(EditCommand... editCommands) {
        HandwritingGesture_androidKt.compoundEditCommand.1 anon = new HandwritingGesture_androidKt.compoundEditCommand.1(editCommands);
        return (EditCommand)anon;
    }

    private static final long enclosure-pWDy79M(long a, long b) {
        return TextRangeKt.TextRange(Math.min(TextRange.getStart-impl(a), TextRange.getStart-impl(a)), Math.max(TextRange.getEnd-impl(obj5), TextRange.getEnd-impl(obj5)));
    }

    private static final int getLineForHandwritingGesture-d-4ec7I(MultiParagraph $this$getLineForHandwritingGesture_u2dd_u2d4ec7I, long localPoint, ViewConfiguration viewConfiguration) {
        int handwritingGestureLineMargin;
        int cmp;
        int cmp2;
        int i;
        int i2;
        if (obj8 != null) {
            handwritingGestureLineMargin = obj8.getHandwritingGestureLineMargin();
        } else {
            handwritingGestureLineMargin = 0;
        }
        int lineForVerticalPosition = $this$getLineForHandwritingGesture_u2dd_u2d4ec7I.getLineForVerticalPosition(Offset.getY-impl(localPoint));
        int i4 = -1;
        if (Float.compare(y-impl2, i3) >= 0) {
            if (Float.compare(y-impl3, i) > 0) {
            } else {
                if (Float.compare(x-impl, i2) >= 0 && Float.compare(x-impl2, i2) > 0) {
                    if (Float.compare(x-impl2, i2) > 0) {
                    }
                    return lineForVerticalPosition;
                }
            }
            return i4;
        }
        return i4;
    }

    private static final int getOffsetForHandwritingGesture-d-4ec7I(LegacyTextFieldState $this$getOffsetForHandwritingGesture_u2dd_u2d4ec7I, long pointInScreen, ViewConfiguration viewConfiguration) {
        int offsetForHandwritingGesture-ubNVwUQ;
        Object multiParagraph;
        LayoutCoordinates layoutCoordinates;
        multiParagraph = $this$getOffsetForHandwritingGesture_u2dd_u2d4ec7I.getLayoutResult();
        multiParagraph = multiParagraph.getValue();
        multiParagraph = multiParagraph.getMultiParagraph();
        if (multiParagraph != null && multiParagraph != null && multiParagraph != null) {
            multiParagraph = multiParagraph.getValue();
            if (multiParagraph != null) {
                multiParagraph = multiParagraph.getMultiParagraph();
                if (multiParagraph != null) {
                    offsetForHandwritingGesture-ubNVwUQ = HandwritingGesture_androidKt.getOffsetForHandwritingGesture-ubNVwUQ(multiParagraph, pointInScreen, viewConfiguration, $this$getOffsetForHandwritingGesture_u2dd_u2d4ec7I.getLayoutCoordinates());
                } else {
                    offsetForHandwritingGesture-ubNVwUQ = -1;
                }
            } else {
            }
        } else {
        }
        return offsetForHandwritingGesture-ubNVwUQ;
    }

    private static final int getOffsetForHandwritingGesture-d-4ec7I(androidx.compose.foundation.text.input.internal.TextLayoutState $this$getOffsetForHandwritingGesture_u2dd_u2d4ec7I, long pointInScreen, ViewConfiguration viewConfiguration) {
        Object multiParagraph;
        int offsetForHandwritingGesture-ubNVwUQ;
        LayoutCoordinates textLayoutNodeCoordinates;
        multiParagraph = $this$getOffsetForHandwritingGesture_u2dd_u2d4ec7I.getLayoutResult();
        multiParagraph = multiParagraph.getMultiParagraph();
        if (multiParagraph != null && multiParagraph != null) {
            multiParagraph = multiParagraph.getMultiParagraph();
            if (multiParagraph != null) {
                offsetForHandwritingGesture-ubNVwUQ = HandwritingGesture_androidKt.getOffsetForHandwritingGesture-ubNVwUQ(multiParagraph, pointInScreen, viewConfiguration, $this$getOffsetForHandwritingGesture_u2dd_u2d4ec7I.getTextLayoutNodeCoordinates());
            } else {
                offsetForHandwritingGesture-ubNVwUQ = -1;
            }
        } else {
        }
        return offsetForHandwritingGesture-ubNVwUQ;
    }

    private static final int getOffsetForHandwritingGesture-ubNVwUQ(MultiParagraph $this$getOffsetForHandwritingGesture_u2dubNVwUQ, long pointInScreen, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        int i = -1;
        final long l = screenToLocal-MK-Hz9U;
        int lineForHandwritingGesture-d-4ec7I = HandwritingGesture_androidKt.getLineForHandwritingGesture-d-4ec7I($this$getOffsetForHandwritingGesture_u2dubNVwUQ, l, obj4);
        if (viewConfiguration != null && lineForHandwritingGesture-d-4ec7I == i) {
            l = screenToLocal-MK-Hz9U;
            lineForHandwritingGesture-d-4ec7I = HandwritingGesture_androidKt.getLineForHandwritingGesture-d-4ec7I($this$getOffsetForHandwritingGesture_u2dubNVwUQ, l, obj4);
            if (lineForHandwritingGesture-d-4ec7I == i) {
                return i;
            }
            final int i5 = i2 / i3;
            return $this$getOffsetForHandwritingGesture_u2dubNVwUQ.getOffsetForPosition-k-4lQ0M(Offset.copy-dBAh8RU$default(l, obj4, 0, i5, 1));
        }
        return i;
    }

    private static final long getRangeForRemoveSpaceGesture-5iVPX68(TextLayoutResult $this$getRangeForRemoveSpaceGesture_u2d5iVPX68, long startPointInScreen, long endPointerInScreen, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        long l;
        int line;
        int i;
        Object obj = $this$getRangeForRemoveSpaceGesture_u2d5iVPX68;
        Object obj2 = obj22;
        ViewConfiguration view = obj23;
        if (obj != null) {
            if (obj2 == null) {
                l = layoutCoordinates;
                return TextRange.Companion.getZero-d9O1mEE();
            } else {
                final long screenToLocal-MK-Hz9U = obj2.screenToLocal-MK-Hz9U(startPointInScreen);
                final long screenToLocal-MK-Hz9U2 = obj2.screenToLocal-MK-Hz9U(layoutCoordinates);
                int lineForHandwritingGesture-d-4ec7I = HandwritingGesture_androidKt.getLineForHandwritingGesture-d-4ec7I(obj.getMultiParagraph(), screenToLocal-MK-Hz9U, obj6);
                int lineForHandwritingGesture-d-4ec7I2 = HandwritingGesture_androidKt.getLineForHandwritingGesture-d-4ec7I(obj.getMultiParagraph(), screenToLocal-MK-Hz9U2, obj10);
                int i4 = 0;
                i = -1;
                if (lineForHandwritingGesture-d-4ec7I == i) {
                    if (lineForHandwritingGesture-d-4ec7I2 == i) {
                        return TextRange.Companion.getZero-d9O1mEE();
                    }
                    line = lineForHandwritingGesture-d-4ec7I2;
                } else {
                    if (lineForHandwritingGesture-d-4ec7I2 == i) {
                        i = lineForHandwritingGesture-d-4ec7I;
                    } else {
                        i = Math.min(lineForHandwritingGesture-d-4ec7I, lineForHandwritingGesture-d-4ec7I2);
                    }
                    line = i;
                }
            }
            i5 /= f3;
            final int i8 = 1036831949;
            Rect rect = new Rect(Math.min(Offset.getX-impl(screenToLocal-MK-Hz9U), Offset.getX-impl(screenToLocal-MK-Hz9U2)), i6 - i8, Math.max(Offset.getX-impl(screenToLocal-MK-Hz9U), Offset.getX-impl(screenToLocal-MK-Hz9U2)), i6 + i8);
            return $this$getRangeForRemoveSpaceGesture_u2d5iVPX68.getMultiParagraph().getRangeForRect-8-6BmAI(rect, TextGranularity.Companion.getCharacter-DRrd7Zo(), TextInclusionStrategy.Companion.getAnyOverlap());
        }
        l = layoutCoordinates;
    }

    private static final long getRangeForScreenRect-O048IG0(MultiParagraph $this$getRangeForScreenRect_u2dO048IG0, Rect rectInScreen, LayoutCoordinates layoutCoordinates, int granularity, TextInclusionStrategy inclusionStrategy) {
        if ($this$getRangeForScreenRect_u2dO048IG0 != null && layoutCoordinates == null) {
            if (layoutCoordinates == null) {
            }
            return $this$getRangeForScreenRect_u2dO048IG0.getRangeForRect-8-6BmAI(rectInScreen.translate-k-4lQ0M(layoutCoordinates.screenToLocal-MK-Hz9U(Offset.Companion.getZero-F1C5BW0())), granularity, inclusionStrategy);
        }
        return TextRange.Companion.getZero-d9O1mEE();
    }

    private static final long getRangeForScreenRect-OH9lIzo(LegacyTextFieldState $this$getRangeForScreenRect_u2dOH9lIzo, Rect rectInScreen, int granularity, TextInclusionStrategy inclusionStrategy) {
        Object layoutResult;
        int multiParagraph;
        layoutResult = $this$getRangeForScreenRect_u2dOH9lIzo.getLayoutResult();
        layoutResult = layoutResult.getValue();
        if (layoutResult != null && layoutResult != null) {
            layoutResult = layoutResult.getValue();
            if (layoutResult != null) {
                multiParagraph = layoutResult.getMultiParagraph();
            } else {
                multiParagraph = 0;
            }
        } else {
        }
        return HandwritingGesture_androidKt.getRangeForScreenRect-O048IG0(multiParagraph, rectInScreen, $this$getRangeForScreenRect_u2dOH9lIzo.getLayoutCoordinates(), granularity, inclusionStrategy);
    }

    private static final long getRangeForScreenRect-OH9lIzo(androidx.compose.foundation.text.input.internal.TextLayoutState $this$getRangeForScreenRect_u2dOH9lIzo, Rect rectInScreen, int granularity, TextInclusionStrategy inclusionStrategy) {
        MultiParagraph multiParagraph;
        TextLayoutResult layoutResult = $this$getRangeForScreenRect_u2dOH9lIzo.getLayoutResult();
        if (layoutResult != null) {
            multiParagraph = layoutResult.getMultiParagraph();
        } else {
            multiParagraph = 0;
        }
        return HandwritingGesture_androidKt.getRangeForScreenRect-O048IG0(multiParagraph, rectInScreen, $this$getRangeForScreenRect_u2dOH9lIzo.getTextLayoutNodeCoordinates(), granularity, inclusionStrategy);
    }

    private static final long getRangeForScreenRects-O048IG0(LegacyTextFieldState $this$getRangeForScreenRects_u2dO048IG0, Rect startRectInScreen, Rect endRectInScreen, int granularity, TextInclusionStrategy inclusionStrategy) {
        long rangeForScreenRect-OH9lIzo = HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo($this$getRangeForScreenRects_u2dO048IG0, startRectInScreen, granularity, inclusionStrategy);
        int i = 0;
        final boolean collapsed-impl = TextRange.getCollapsed-impl(rangeForScreenRect-OH9lIzo);
        if (collapsed-impl) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        long rangeForScreenRect-OH9lIzo2 = HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo($this$getRangeForScreenRects_u2dO048IG0, endRectInScreen, granularity, inclusionStrategy);
        final int i2 = 0;
        if (TextRange.getCollapsed-impl(rangeForScreenRect-OH9lIzo2)) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        return HandwritingGesture_androidKt.enclosure-pWDy79M(rangeForScreenRect-OH9lIzo, obj1);
    }

    private static final long getRangeForScreenRects-O048IG0(androidx.compose.foundation.text.input.internal.TextLayoutState $this$getRangeForScreenRects_u2dO048IG0, Rect startRectInScreen, Rect endRectInScreen, int granularity, TextInclusionStrategy inclusionStrategy) {
        long rangeForScreenRect-OH9lIzo = HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo($this$getRangeForScreenRects_u2dO048IG0, startRectInScreen, granularity, inclusionStrategy);
        int i = 0;
        final boolean collapsed-impl = TextRange.getCollapsed-impl(rangeForScreenRect-OH9lIzo);
        if (collapsed-impl) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        long rangeForScreenRect-OH9lIzo2 = HandwritingGesture_androidKt.getRangeForScreenRect-OH9lIzo($this$getRangeForScreenRects_u2dO048IG0, endRectInScreen, granularity, inclusionStrategy);
        final int i2 = 0;
        if (TextRange.getCollapsed-impl(rangeForScreenRect-OH9lIzo2)) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        return HandwritingGesture_androidKt.enclosure-pWDy79M(rangeForScreenRect-OH9lIzo, obj1);
    }

    private static final boolean isBiDiBoundary(TextLayoutResult $this$isBiDiBoundary, int offset) {
        int lineEnd$default;
        int i;
        int i2;
        final int lineForOffset = $this$isBiDiBoundary.getLineForOffset(offset);
        i = 1;
        final int i4 = 0;
        if (offset != $this$isBiDiBoundary.getLineStart(lineForOffset)) {
            if (offset == TextLayoutResult.getLineEnd$default($this$isBiDiBoundary, lineForOffset, i4, 2, 0)) {
            } else {
                if ($this$isBiDiBoundary.getBidiRunDirection(offset) != $this$isBiDiBoundary.getBidiRunDirection(offset + -1)) {
                } else {
                    i = i4;
                }
            }
            return i;
        }
        if ($this$isBiDiBoundary.getParagraphDirection(offset) != $this$isBiDiBoundary.getBidiRunDirection(offset)) {
        } else {
            i = i4;
        }
        return i;
    }

    private static final boolean isNewline(int $this$isNewline) {
        int i;
        int i2;
        final int type = Character.getType($this$isNewline);
        if (type != 14 && type != 13) {
            if (type != 13) {
                if ($this$isNewline == 10) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    private static final boolean isPunctuation(int $this$isPunctuation) {
        int i;
        int i2;
        final int type = Character.getType($this$isPunctuation);
        if (type != 23 && type != 20 && type != 22 && type != 30 && type != 29 && type != 24) {
            if (type != 20) {
                if (type != 22) {
                    if (type != 30) {
                        if (type != 29) {
                            if (type != 24) {
                                if (type == 21) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final boolean isWhitespace(int $this$isWhitespace) {
        int i;
        boolean whitespace;
        if (!Character.isWhitespace($this$isWhitespace)) {
            if ($this$isWhitespace == 160) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final boolean isWhitespaceExceptNewline(int $this$isWhitespaceExceptNewline) {
        boolean whitespace;
        int i;
        if (HandwritingGesture_androidKt.isWhitespace($this$isWhitespaceExceptNewline) && !HandwritingGesture_androidKt.isNewline($this$isWhitespaceExceptNewline)) {
            i = !HandwritingGesture_androidKt.isNewline($this$isWhitespaceExceptNewline) ? 1 : 0;
        } else {
        }
        return i;
    }

    private static final long rangeOfWhitespaces(java.lang.CharSequence $this$rangeOfWhitespaces, int offset) {
        int startOffset;
        int endOffset;
        int codePointBefore;
        int charCount;
        startOffset = offset;
        endOffset = offset;
        while (startOffset > 0) {
            codePointBefore = CodepointHelpers_jvmKt.codePointBefore($this$rangeOfWhitespaces, startOffset);
            if (!HandwritingGesture_androidKt.isWhitespace(codePointBefore)) {
                break;
            } else {
            }
            startOffset -= charCount;
        }
        while (endOffset < $this$rangeOfWhitespaces.length()) {
            codePointBefore = CodepointHelpers_jvmKt.codePointAt($this$rangeOfWhitespaces, endOffset);
            if (!HandwritingGesture_androidKt.isWhitespace(codePointBefore)) {
                break;
            } else {
            }
            endOffset += charCount;
        }
        return TextRangeKt.TextRange(startOffset, endOffset);
    }

    private static final long toOffset(PointF $this$toOffset) {
        return OffsetKt.Offset($this$toOffset.x, $this$toOffset.y);
    }
}
