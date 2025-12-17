package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u000c\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001c\u0010\u0008\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0000\u001a\u000c\u0010\r\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u000cH\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u000cH\u0000\u001a\u000c\u0010\u0012\u001a\u00020\u0006*\u00020\u0007H\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u000cH\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u0017\u001a\u00020\u000cH\u0000\u001a\u001c\u0010\u0018\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0000¨\u0006\u0019", d2 = {"isSurrogatePair", "", "high", "", "low", "backspace", "", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "commitText", "text", "", "newCursorPosition", "", "deleteAll", "deleteSurroundingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingTextInCodePoints", "finishComposingText", "moveCursor", "amount", "setComposingRegion", "start", "end", "setComposingText", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditCommandKt {
    public static final void backspace(androidx.compose.foundation.text.input.internal.EditingBuffer $this$backspace) {
        int compositionStart;
        int compositionEnd;
        int selectionStart;
        if ($this$backspace.hasComposition()) {
            $this$backspace.delete($this$backspace.getCompositionStart(), $this$backspace.getCompositionEnd());
        } else {
            if ($this$backspace.getCursor() == -1) {
                $this$backspace.setCursor($this$backspace.getSelectionStart());
                $this$backspace.delete($this$backspace.getSelectionStart(), $this$backspace.getSelectionEnd());
            } else {
                if ($this$backspace.getCursor() != 0) {
                    $this$backspace.delete(StringHelpers_androidKt.findPrecedingBreak($this$backspace.toString(), $this$backspace.getCursor()), $this$backspace.getCursor());
                }
            }
        }
    }

    public static final void commitText(androidx.compose.foundation.text.input.internal.EditingBuffer $this$commitText, String text, int newCursorPosition) {
        int compositionStart;
        int compositionEnd;
        int i;
        java.lang.CharSequence length;
        if ($this$commitText.hasComposition()) {
            $this$commitText.replace($this$commitText.getCompositionStart(), $this$commitText.getCompositionEnd(), (CharSequence)text);
        } else {
            $this$commitText.replace($this$commitText.getSelectionStart(), $this$commitText.getSelectionEnd(), (CharSequence)text);
        }
        int cursor = $this$commitText.getCursor();
        if (newCursorPosition > 0) {
            i3--;
        } else {
            i2 -= length;
        }
        $this$commitText.setCursor(RangesKt.coerceIn(i, 0, $this$commitText.getLength()));
    }

    public static final void deleteAll(androidx.compose.foundation.text.input.internal.EditingBuffer $this$deleteAll) {
        $this$deleteAll.replace(0, $this$deleteAll.getLength(), (CharSequence)"");
    }

    public static final void deleteSurroundingText(androidx.compose.foundation.text.input.internal.EditingBuffer $this$deleteSurroundingText, int lengthBeforeCursor, int lengthAfterCursor) {
        int i;
        int result$iv;
        int $i$a$AddExactOrElseEditCommandKt$deleteSurroundingText$end$1;
        int result$iv2;
        int i2;
        int i3 = 0;
        if (lengthBeforeCursor >= 0 && lengthAfterCursor >= 0) {
            i = lengthAfterCursor >= 0 ? 1 : i3;
        } else {
        }
        if (i == 0) {
        } else {
            int selectionEnd = $this$deleteSurroundingText.getSelectionEnd();
            int i6 = 0;
            result$iv = selectionEnd + lengthAfterCursor;
            if (i9 &= i11 < 0) {
                int i10 = 0;
                result$iv = $i$a$AddExactOrElseEditCommandKt$deleteSurroundingText$end$1;
            }
            $this$deleteSurroundingText.delete($this$deleteSurroundingText.getSelectionEnd(), Math.min(result$iv, $this$deleteSurroundingText.getLength()));
            int selectionStart = $this$deleteSurroundingText.getSelectionStart();
            int i8 = 0;
            if (i12 &= i13 < 0) {
                i2 = 0;
                result$iv2 = i3;
            }
            $this$deleteSurroundingText.delete(Math.max(i3, result$iv2), $this$deleteSurroundingText.getSelectionStart());
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ").append(lengthBeforeCursor).append(" and ").append(lengthAfterCursor).append(" respectively.").toString().toString());
        throw illegalArgumentException;
    }

    public static final void deleteSurroundingTextInCodePoints(androidx.compose.foundation.text.input.internal.EditingBuffer $this$deleteSurroundingTextInCodePoints, int lengthBeforeCursor, int lengthAfterCursor) {
        int length;
        int i3;
        int beforeLenInChars;
        int i4;
        int i;
        char selectionStart;
        int i2;
        char selectionEnd;
        boolean surrogatePair2;
        boolean surrogatePair;
        length = 1;
        if (lengthBeforeCursor >= 0 && lengthAfterCursor >= 0) {
            i3 = lengthAfterCursor >= 0 ? length : 0;
        } else {
        }
        if (i3 == 0) {
        } else {
            beforeLenInChars = 0;
            i4 = 0;
            while (i4 < lengthBeforeCursor) {
                beforeLenInChars++;
                if ($this$deleteSurroundingTextInCodePoints.getSelectionStart() <= beforeLenInChars) {
                    break;
                } else {
                }
                if (EditCommandKt.isSurrogatePair($this$deleteSurroundingTextInCodePoints.get(i8 -= length), $this$deleteSurroundingTextInCodePoints.get(selectionStart5 -= beforeLenInChars))) {
                }
                i4++;
                beforeLenInChars++;
            }
            i = 0;
            i2 = 0;
            while (i2 < lengthAfterCursor) {
                i++;
                if (selectionEnd4 += i >= $this$deleteSurroundingTextInCodePoints.getLength()) {
                    break;
                } else {
                }
                if (EditCommandKt.isSurrogatePair($this$deleteSurroundingTextInCodePoints.get(i11 -= length), $this$deleteSurroundingTextInCodePoints.get(selectionEnd6 += i))) {
                }
                i2++;
                i++;
            }
            $this$deleteSurroundingTextInCodePoints.delete($this$deleteSurroundingTextInCodePoints.getSelectionEnd(), selectionEnd3 += i);
            $this$deleteSurroundingTextInCodePoints.delete(selectionStart2 -= beforeLenInChars, $this$deleteSurroundingTextInCodePoints.getSelectionStart());
        }
        int i5 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ").append(lengthBeforeCursor).append(" and ").append(lengthAfterCursor).append(" respectively.").toString().toString());
        throw illegalArgumentException;
    }

    public static final void finishComposingText(androidx.compose.foundation.text.input.internal.EditingBuffer $this$finishComposingText) {
        $this$finishComposingText.commitComposition();
    }

    private static final boolean isSurrogatePair(char high, char low) {
        boolean highSurrogate;
        int i;
        if (Character.isHighSurrogate(high) && Character.isLowSurrogate(low)) {
            i = Character.isLowSurrogate(low) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final void moveCursor(androidx.compose.foundation.text.input.internal.EditingBuffer $this$moveCursor, int amount) {
        int selectionStart;
        int newCursor;
        int i;
        int followingBreak;
        int precedingBreak;
        final int i2 = -1;
        if ($this$moveCursor.getCursor() == i2) {
            $this$moveCursor.setCursor($this$moveCursor.getSelectionStart());
        }
        newCursor = $this$moveCursor.getSelectionStart();
        final String string = $this$moveCursor.toString();
        if (amount > 0) {
            i = 0;
            while (i < amount) {
                followingBreak = StringHelpers_androidKt.findFollowingBreak(string, newCursor);
                if (followingBreak != i2) {
                }
                newCursor = followingBreak;
                i++;
            }
        } else {
            i = 0;
            while (i < -amount) {
                precedingBreak = StringHelpers_androidKt.findPrecedingBreak(string, newCursor);
                if (precedingBreak != i2) {
                }
                newCursor = precedingBreak;
                i++;
            }
        }
        $this$moveCursor.setCursor(newCursor);
    }

    public static final void setComposingRegion(androidx.compose.foundation.text.input.internal.EditingBuffer $this$setComposingRegion, int start, int end) {
        if ($this$setComposingRegion.hasComposition()) {
            $this$setComposingRegion.commitComposition();
        }
        int i = 0;
        int coerceIn = RangesKt.coerceIn(start, i, $this$setComposingRegion.getLength());
        int coerceIn2 = RangesKt.coerceIn(end, i, $this$setComposingRegion.getLength());
        if (coerceIn != coerceIn2) {
            if (coerceIn < coerceIn2) {
                $this$setComposingRegion.setComposition(coerceIn, coerceIn2);
            } else {
                $this$setComposingRegion.setComposition(coerceIn2, coerceIn);
            }
        }
    }

    public static final void setComposingText(androidx.compose.foundation.text.input.internal.EditingBuffer $this$setComposingText, String text, int newCursorPosition) {
        int compositionStart;
        int i;
        int i3;
        int i2;
        java.lang.CharSequence charSequence;
        i = 1;
        final int i4 = 0;
        if ($this$setComposingText.hasComposition()) {
            compositionStart = $this$setComposingText.getCompositionStart();
            $this$setComposingText.replace(compositionStart, $this$setComposingText.getCompositionEnd(), (CharSequence)text);
            i3 = (CharSequence)text.length() > 0 ? i : i4;
            if (i3 != 0) {
                $this$setComposingText.setComposition(compositionStart, length6 += compositionStart);
            }
        } else {
            compositionStart = $this$setComposingText.getSelectionStart();
            $this$setComposingText.replace(compositionStart, $this$setComposingText.getSelectionEnd(), (CharSequence)text);
            i3 = (CharSequence)text.length() > 0 ? i : i4;
            if (i3 != 0) {
                $this$setComposingText.setComposition(compositionStart, length4 += compositionStart);
            }
        }
        int cursor = $this$setComposingText.getCursor();
        if (newCursorPosition > 0) {
            i5 -= i;
        } else {
            i2 = i - length2;
        }
        $this$setComposingText.setCursor(RangesKt.coerceIn(i2, i4, $this$setComposingText.getLength()));
    }
}
