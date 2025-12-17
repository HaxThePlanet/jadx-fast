package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u000e\u0008\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "charSequence", "", "start", "", "end", "locale", "Ljava/util/Locale;", "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", "iterator", "Ljava/text/BreakIterator;", "checkOffsetIsValid", "", "offset", "getBeginning", "getPrevWordBeginningOnTwoWordsBoundary", "", "getEnd", "getNextWordEndOnTwoWordBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterLetterOrDigit", "isAfterPunctuation", "isOnLetterOrDigit", "isOnPunctuation", "isPunctuationEndBoundary", "isPunctuationStartBoundary", "nextBoundary", "prevBoundary", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WordIterator {

    public static final int $stable = 0;
    public static final androidx.compose.ui.text.android.selection.WordIterator.Companion Companion = null;
    private static final int WINDOW_WIDTH = 50;
    private final java.lang.CharSequence charSequence;
    private final int end;
    private final BreakIterator iterator;
    private final int start;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\u0008R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator$Companion;", "", "()V", "WINDOW_WIDTH", "", "isPunctuation", "", "cp", "isPunctuation$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean isPunctuation$ui_text_release(int cp) {
            int i;
            int i2;
            final int type = Character.getType(cp);
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
    }
    static {
        WordIterator.Companion companion = new WordIterator.Companion(0);
        WordIterator.Companion = companion;
        WordIterator.$stable = 8;
    }

    public WordIterator(java.lang.CharSequence charSequence, int start, int end, Locale locale) {
        int i;
        int length;
        int length2;
        super();
        this.charSequence = charSequence;
        int i7 = 0;
        if (start >= 0 && start <= this.charSequence.length()) {
            length2 = start <= this.charSequence.length() ? i : i7;
        } else {
        }
        if (length2 == 0) {
        } else {
            if (end >= 0 && end <= this.charSequence.length()) {
                if (end <= this.charSequence.length()) {
                } else {
                    i = i7;
                }
            } else {
            }
            if (i == 0) {
            } else {
                this.iterator = BreakIterator.getWordInstance(locale);
                this.start = Math.max(i7, start + -50);
                this.end = Math.min(this.charSequence.length(), end + 50);
                CharSequenceCharacterIterator charSequenceCharacterIterator = new CharSequenceCharacterIterator(this.charSequence, start, end);
                this.iterator.setText((CharacterIterator)charSequenceCharacterIterator);
            }
            int i2 = 0;
            IllegalArgumentException $i$a$RequireWordIterator$2 = new IllegalArgumentException("input end index is outside the CharSequence".toString());
            throw $i$a$RequireWordIterator$2;
        }
        int i6 = 0;
        IllegalArgumentException $i$a$RequireWordIterator$1 = new IllegalArgumentException("input start index is outside the CharSequence".toString());
        throw $i$a$RequireWordIterator$1;
    }

    private final void checkOffsetIsValid(int offset) {
        int i;
        i = 0;
        if (offset <= this.end && this.start <= offset) {
            if (this.start <= offset) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Invalid offset: ").append(offset).append(". Valid range is [").append(this.start).append(" , ").append(this.end).append(']').toString().toString());
        throw illegalArgumentException;
    }

    private final int getBeginning(int offset, boolean getPrevWordBeginningOnTwoWordsBoundary) {
        int preceding;
        boolean afterLetterOrDigit;
        checkOffsetIsValid(offset);
        if (isOnLetterOrDigit(offset)) {
            if (this.iterator.isBoundary(offset)) {
                if (isAfterLetterOrDigit(offset)) {
                    if (!getPrevWordBeginningOnTwoWordsBoundary) {
                        preceding = offset;
                    } else {
                        preceding = this.iterator.preceding(offset);
                    }
                } else {
                }
            } else {
            }
            return preceding;
        }
        if (isAfterLetterOrDigit(offset)) {
            return this.iterator.preceding(offset);
        }
        return -1;
    }

    private final int getEnd(int offset, boolean getNextWordEndOnTwoWordBoundary) {
        int following;
        boolean onLetterOrDigit;
        checkOffsetIsValid(offset);
        if (isAfterLetterOrDigit(offset)) {
            if (this.iterator.isBoundary(offset)) {
                if (isOnLetterOrDigit(offset)) {
                    if (!getNextWordEndOnTwoWordBoundary) {
                        following = offset;
                    } else {
                        following = this.iterator.following(offset);
                    }
                } else {
                }
            } else {
            }
            return following;
        }
        if (isOnLetterOrDigit(offset)) {
            return this.iterator.following(offset);
        }
        return -1;
    }

    private final boolean isAfterLetterOrDigit(int offset) {
        int codePointBefore;
        int letterOrDigit;
        final int i2 = 1;
        final int i3 = 0;
        if (offset <= this.end && start += i2 <= offset) {
            codePointBefore = start += i2 <= offset ? i2 : i3;
        } else {
        }
        if (codePointBefore != 0 && Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, offset))) {
            if (Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, offset))) {
                return i2;
            }
        }
        return i3;
    }

    private final boolean isOnLetterOrDigit(int offset) {
        int codePointAt;
        int letterOrDigit;
        final int i = 1;
        final int i2 = 0;
        if (offset < this.end && this.start <= offset) {
            codePointAt = this.start <= offset ? i : i2;
        } else {
        }
        if (codePointAt != 0 && Character.isLetterOrDigit(Character.codePointAt(this.charSequence, offset))) {
            if (Character.isLetterOrDigit(Character.codePointAt(this.charSequence, offset))) {
                return i;
            }
        }
        return i2;
    }

    private final boolean isPunctuationEndBoundary(int offset) {
        boolean afterPunctuation;
        int i;
        if (!isOnPunctuation(offset) && isAfterPunctuation(offset)) {
            i = isAfterPunctuation(offset) ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean isPunctuationStartBoundary(int offset) {
        boolean afterPunctuation;
        int i;
        if (isOnPunctuation(offset) && !isAfterPunctuation(offset)) {
            i = !isAfterPunctuation(offset) ? 1 : 0;
        } else {
        }
        return i;
    }

    public final int getNextWordEndOnTwoWordBoundary(int offset) {
        return getEnd(offset, true);
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int offset) {
        return getBeginning(offset, true);
    }

    public final int getPunctuationBeginning(int offset) {
        int result;
        boolean punctuationStartBoundary;
        checkOffsetIsValid(offset);
        result = offset;
        while (result != -1) {
            if (!isPunctuationStartBoundary(result)) {
            }
            result = prevBoundary(result);
        }
        return result;
    }

    public final int getPunctuationEnd(int offset) {
        int result;
        boolean punctuationEndBoundary;
        checkOffsetIsValid(offset);
        result = offset;
        while (result != -1) {
            if (!isPunctuationEndBoundary(result)) {
            }
            result = nextBoundary(result);
        }
        return result;
    }

    public final boolean isAfterPunctuation(int offset) {
        int i;
        final int i3 = 0;
        if (offset <= this.end && start += i <= offset) {
            if (start += i <= offset) {
            } else {
                i = i3;
            }
        } else {
        }
        if (i != 0) {
            return WordIterator.Companion.isPunctuation$ui_text_release(Character.codePointBefore(this.charSequence, offset));
        }
        return i3;
    }

    public final boolean isOnPunctuation(int offset) {
        int i;
        final int i2 = 0;
        if (offset < this.end && this.start <= offset) {
            i = this.start <= offset ? 1 : i2;
        } else {
        }
        if (i != 0) {
            return WordIterator.Companion.isPunctuation$ui_text_release(Character.codePointAt(this.charSequence, offset));
        }
        return i2;
    }

    public final int nextBoundary(int offset) {
        checkOffsetIsValid(offset);
        return this.iterator.following(offset);
    }

    public final int prevBoundary(int offset) {
        checkOffsetIsValid(offset);
        return this.iterator.preceding(offset);
    }
}
