package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\r\n\u0002\u0008\r\n\u0002\u0010\u000c\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001TB1\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0014\u0010/\u001a\u00060\u0001j\u0002`\u00022\u0006\u00100\u001a\u000201H\u0016J\u0016\u0010/\u001a\u00060\u0001j\u0002`\u00022\u0008\u00102\u001a\u0004\u0018\u00010#H\u0016J&\u0010/\u001a\u00060\u0001j\u0002`\u00022\u0008\u00102\u001a\u0004\u0018\u00010#2\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bH\u0016J\u0006\u00105\u001a\u00020#J\u000e\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u001bJ\u0008\u00108\u001a\u000209H\u0002J \u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0002J\u000e\u0010>\u001a\u0002092\u0006\u00107\u001a\u00020\u001bJ\u000e\u0010?\u001a\u0002092\u0006\u00107\u001a\u00020\u001bJ\u001e\u0010@\u001a\u0002092\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001b2\u0006\u00102\u001a\u00020#J9\u0010@\u001a\u0002092\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001b2\u0006\u00102\u001a\u00020#2\u0008\u0008\u0002\u0010A\u001a\u00020\u001b2\u0008\u0008\u0002\u0010B\u001a\u00020\u001bH\u0000¢\u0006\u0002\u0008CJ \u0010D\u001a\u0002092\u0006\u00107\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0018H\u0002J\u001a\u0010G\u001a\u0002092\u0006\u0010H\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\u0008I\u0010,J\u0006\u0010J\u001a\u000209J\u0015\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020#H\u0000¢\u0006\u0002\u0008MJ\u0008\u0010N\u001a\u00020OH\u0016J(\u0010P\u001a\u00020\u00042\u0008\u0008\u0002\u0010)\u001a\u00020\u001f2\n\u0008\u0002\u0010Q\u001a\u0004\u0018\u00010\u001fH\u0000ø\u0001\u0000¢\u0006\u0004\u0008R\u0010SR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\u00020\u001f8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R*\u0010)\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001f8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008*\u0010!\"\u0004\u0008+\u0010,R\u0016\u0010-\u001a\u00020\u001fX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010.\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006U", d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialChanges", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "originalValue", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/ChangeTracker;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "backingChangeTracker", "buffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "changeTracker", "getChangeTracker", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "getChanges$annotations", "()V", "getChanges", "()Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "hasSelection", "", "()Z", "length", "", "getLength", "()I", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "getOriginalSelection-d9O1mEE", "()J", "originalText", "", "getOriginalText", "()Ljava/lang/CharSequence;", "getOriginalValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "selectionInChars", "J", "append", "char", "", "text", "start", "end", "asCharSequence", "charAt", "index", "clearChangeList", "", "onTextWillChange", "replaceStart", "replaceEnd", "newLength", "placeCursorAfterCharAt", "placeCursorBeforeCharAt", "replace", "textStart", "textEnd", "replace$foundation_release", "requireValidIndex", "startExclusive", "endExclusive", "requireValidRange", "range", "requireValidRange-5zc-tL8", "revertAllChanges", "setTextIfChanged", "newText", "setTextIfChanged$foundation_release", "toString", "", "toTextFieldCharSequence", "composition", "toTextFieldCharSequence-udt6zUU$foundation_release", "(JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "ChangeList", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldBuffer implements java.lang.Appendable {

    public static final int $stable = 8;
    private ChangeTracker backingChangeTracker;
    private final PartialGapBuffer buffer;
    private final OffsetMappingCalculator offsetMappingCalculator;
    private final androidx.compose.foundation.text.input.TextFieldCharSequence originalValue;
    private long selectionInChars;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008g\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000c\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\rÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getOriginalRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getOriginalRange--jx7JFs", "(I)J", "getRange", "getRange--jx7JFs", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ChangeList {
        public abstract int getChangeCount();

        public abstract long getOriginalRange--jx7JFs(int i);

        public abstract long getRange--jx7JFs(int i);
    }
    static {
        final int i = 8;
    }

    public TextFieldBuffer(androidx.compose.foundation.text.input.TextFieldCharSequence initialValue, ChangeTracker initialChanges, androidx.compose.foundation.text.input.TextFieldCharSequence originalValue, OffsetMappingCalculator offsetMappingCalculator) {
        Object partialGapBuffer;
        int charSequence;
        ChangeTracker changeTracker;
        super();
        this.originalValue = originalValue;
        this.offsetMappingCalculator = offsetMappingCalculator;
        partialGapBuffer = new PartialGapBuffer((CharSequence)initialValue);
        this.buffer = partialGapBuffer;
        if (initialChanges != null) {
            partialGapBuffer = initialChanges;
            charSequence = 0;
            changeTracker = new ChangeTracker(initialChanges);
        } else {
            changeTracker = 0;
        }
        this.backingChangeTracker = changeTracker;
        this.selectionInChars = initialValue.getSelection-d9O1mEE();
    }

    public TextFieldBuffer(androidx.compose.foundation.text.input.TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker2, androidx.compose.foundation.text.input.TextFieldCharSequence textFieldCharSequence3, OffsetMappingCalculator offsetMappingCalculator4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj3;
        androidx.compose.foundation.text.input.TextFieldCharSequence obj4;
        int obj5;
        final int i = 0;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? textFieldCharSequence : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(textFieldCharSequence, obj3, obj4, obj5);
    }

    private final void clearChangeList() {
        getChangeTracker().clearChanges();
    }

    private final ChangeTracker getChangeTracker() {
        ChangeTracker backingChangeTracker;
        ChangeTracker changeTracker;
        int i;
        if (this.backingChangeTracker == null) {
            int i3 = 0;
            backingChangeTracker = new ChangeTracker(i3, 1, i3);
            i = 0;
            this.backingChangeTracker = backingChangeTracker;
        }
        return backingChangeTracker;
    }

    public static void getChanges$annotations() {
    }

    private final void onTextWillChange(int replaceStart, int replaceEnd, int newLength) {
        int selStart;
        int selEnd;
        int i;
        getChangeTracker().trackChange(replaceStart, replaceEnd, newLength);
        OffsetMappingCalculator offsetMappingCalculator = this.offsetMappingCalculator;
        if (offsetMappingCalculator != null) {
            offsetMappingCalculator.recordEditOperation(replaceStart, replaceEnd, newLength);
        }
        int i2 = Math.min(replaceStart, replaceEnd);
        final int i3 = Math.max(replaceStart, replaceEnd);
        selStart = TextRange.getMin-impl(getSelection-d9O1mEE());
        int max-impl = TextRange.getMax-impl(getSelection-d9O1mEE());
        if (max-impl < i2) {
        }
        if (selStart <= i2 && i3 <= max-impl) {
            if (i3 <= max-impl) {
                i = newLength - i6;
                if (selStart == max-impl) {
                    selStart += i;
                }
                max-impl += i;
            } else {
                if (selStart > i2 && max-impl < i3) {
                    if (max-impl < i3) {
                        selStart = i2 + newLength;
                        selEnd = i2 + newLength;
                    } else {
                        if (selStart >= i3) {
                            i = newLength - i5;
                            selStart += i;
                            max-impl += i;
                        } else {
                            if (i2 < selStart) {
                                selStart = i2 + newLength;
                                max-impl += i;
                            } else {
                                selEnd = i2;
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
        this.selectionInChars = TextRangeKt.TextRange(selStart, selEnd);
    }

    public static void replace$foundation_release$default(androidx.compose.foundation.text.input.TextFieldBuffer textFieldBuffer, int i2, int i3, java.lang.CharSequence charSequence4, int i5, int i6, int i7, Object object8) {
        int i4;
        int i;
        int obj10;
        int obj11;
        i4 = i7 & 8 != 0 ? obj10 : i5;
        if (i7 & 16 != 0) {
            i = obj11;
        } else {
            i = i6;
        }
        textFieldBuffer.replace$foundation_release(i2, i3, charSequence4, i4, i);
    }

    private final void requireValidIndex(int index, boolean startExclusive, boolean endExclusive) {
        int i2;
        int i;
        int length;
        i = startExclusive ? i2 : -1;
        int i4 = 1;
        if (endExclusive) {
        } else {
            length += i4;
        }
        if (i <= index && index < length) {
            if (index < length) {
                i2 = i4;
            }
        }
        if (i2 == 0) {
        } else {
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected ").append(index).append(" to be in [").append(i).append(", ").append(length).append(')').toString().toString());
        throw illegalArgumentException;
    }

    private final void requireValidRange-5zc-tL8(long range) {
        final int length = getLength();
        long l = TextRangeKt.TextRange(0, length);
        if (!TextRange.contains-5zc-tL8(l, length)) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected ").append(TextRange.toString-impl(range)).append(" to be in ").append(TextRange.toString-impl(l)).toString().toString());
        throw illegalArgumentException;
    }

    public static androidx.compose.foundation.text.input.TextFieldCharSequence toTextFieldCharSequence-udt6zUU$foundation_release$default(androidx.compose.foundation.text.input.TextFieldBuffer textFieldBuffer, long l2, TextRange textRange3, int i4, Object object5) {
        long obj1;
        int obj3;
        if (object5 & 1 != 0) {
            obj1 = textFieldBuffer.getSelection-d9O1mEE();
        }
        if (object5 &= 2 != 0) {
            obj3 = 0;
        }
        return textFieldBuffer.toTextFieldCharSequence-udt6zUU$foundation_release(obj1, textRange3);
    }

    @Override // java.lang.Appendable
    public java.lang.Appendable append(char char) {
        Object obj = this;
        final int i = 0;
        obj.onTextWillChange((TextFieldBuffer)obj.getLength(), obj.getLength(), 1);
        PartialGapBuffer.replace$default(obj.buffer, obj.buffer.length(), obj.buffer.length(), (CharSequence)String.valueOf(char), 0, 0, 24, 0);
        return (Appendable)this;
    }

    @Override // java.lang.Appendable
    public java.lang.Appendable append(java.lang.CharSequence text) {
        PartialGapBuffer buffer2;
        int length;
        int length2;
        PartialGapBuffer buffer;
        int length4;
        int length3;
        java.lang.CharSequence text2;
        int i2;
        int i3;
        int i4;
        int i;
        final Object obj = this;
        final int i5 = 0;
        if (text != null) {
            obj.onTextWillChange((TextFieldBuffer)obj.getLength(), obj.getLength(), text.length());
            PartialGapBuffer.replace$default(obj.buffer, obj.buffer.length(), obj.buffer.length(), text, 0, 0, 24, 0);
        } else {
            text2 = text;
        }
        return (Appendable)this;
    }

    @Override // java.lang.Appendable
    public java.lang.Appendable append(java.lang.CharSequence text, int start, int end) {
        PartialGapBuffer buffer;
        int length3;
        int i;
        PartialGapBuffer buffer2;
        int length2;
        int length;
        java.lang.CharSequence subSequence;
        int i4;
        int i3;
        int i2;
        int i5;
        Object obj = this;
        final int i6 = 0;
        if (text != null) {
            obj.onTextWillChange((TextFieldBuffer)obj.getLength(), obj.getLength(), end - start);
            PartialGapBuffer.replace$default(obj.buffer, obj.buffer.length(), obj.buffer.length(), text.subSequence(start, end), 0, 0, 24, 0);
        }
        return (Appendable)this;
    }

    @Override // java.lang.Appendable
    public final java.lang.CharSequence asCharSequence() {
        return (CharSequence)this.buffer;
    }

    @Override // java.lang.Appendable
    public final char charAt(int index) {
        return this.buffer.charAt(index);
    }

    @Override // java.lang.Appendable
    public final androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList getChanges() {
        return (TextFieldBuffer.ChangeList)getChangeTracker();
    }

    @Override // java.lang.Appendable
    public final int getLength() {
        return this.buffer.length();
    }

    @Override // java.lang.Appendable
    public final long getOriginalSelection-d9O1mEE() {
        return this.originalValue.getSelection-d9O1mEE();
    }

    @Override // java.lang.Appendable
    public final java.lang.CharSequence getOriginalText() {
        return this.originalValue.getText();
    }

    @Override // java.lang.Appendable
    public final androidx.compose.foundation.text.input.TextFieldCharSequence getOriginalValue$foundation_release() {
        return this.originalValue;
    }

    @Override // java.lang.Appendable
    public final long getSelection-d9O1mEE() {
        return this.selectionInChars;
    }

    @Override // java.lang.Appendable
    public final boolean hasSelection() {
        return collapsed-impl ^= 1;
    }

    @Override // java.lang.Appendable
    public final void placeCursorAfterCharAt(int index) {
        requireValidIndex(index, false, true);
        this.selectionInChars = TextRangeKt.TextRange(RangesKt.coerceAtMost(index + 1, getLength()));
    }

    @Override // java.lang.Appendable
    public final void placeCursorBeforeCharAt(int index) {
        requireValidIndex(index, true, false);
        this.selectionInChars = TextRangeKt.TextRange(index);
    }

    @Override // java.lang.Appendable
    public final void replace(int start, int end, java.lang.CharSequence text) {
        this.replace$foundation_release(start, end, text, 0, text.length());
    }

    @Override // java.lang.Appendable
    public final void replace$foundation_release(int start, int end, java.lang.CharSequence text, int textStart, int textEnd) {
        int i2;
        int i;
        int i4 = 0;
        i = start <= end ? i2 : i4;
        if (i == 0) {
        } else {
            if (textStart <= textEnd) {
            } else {
                i2 = i4;
            }
            if (i2 == 0) {
            } else {
                onTextWillChange(start, end, textEnd - textStart);
                this.buffer.replace(start, end, text, textStart, textEnd);
            }
            int start3 = start;
            int i7 = end;
            java.lang.CharSequence charSequence2 = text;
            int obj8 = 0;
            StringBuilder obj9 = new StringBuilder();
            obj9 = new IllegalArgumentException(obj9.append("Expected textStart=").append(textStart).append(" <= textEnd=").append(textEnd).toString().toString());
            throw obj9;
        }
        java.lang.CharSequence charSequence = text;
        obj8 = 0;
        obj9 = new StringBuilder();
        obj9 = new IllegalArgumentException(obj9.append("Expected start=").append(start).append(" <= end=").append(end).toString().toString());
        throw obj9;
    }

    @Override // java.lang.Appendable
    public final void revertAllChanges() {
        String string = this.originalValue.toString();
        replace(0, getLength(), (CharSequence)string);
        setSelection-5zc-tL8(this.originalValue.getSelection-d9O1mEE());
        clearChangeList();
    }

    @Override // java.lang.Appendable
    public final void setSelection-5zc-tL8(long value) {
        requireValidRange-5zc-tL8(value);
        this.selectionInChars = value;
    }

    @Override // java.lang.Appendable
    public final void setTextIfChanged$foundation_release(java.lang.CharSequence newText) {
        int aStart$iv;
        int aEnd$iv;
        int bStart$iv;
        int bEnd$iv;
        int prefixFound$iv;
        int suffixFound$iv;
        int charAt2;
        char charAt;
        java.lang.CharSequence charSequence;
        int i;
        int i2;
        final PartialGapBuffer buffer = this.buffer;
        final int i3 = 0;
        aStart$iv = 0;
        aEnd$iv = (CharSequence)buffer.length();
        bStart$iv = 0;
        bEnd$iv = newText.length();
        charAt2 = 1;
        prefixFound$iv = buffer.length() > 0 ? charAt2 : suffixFound$iv;
        if (prefixFound$iv != 0 && newText.length() > 0) {
            if (newText.length() > 0) {
                suffixFound$iv = charAt2;
            }
            if (suffixFound$iv != 0) {
                prefixFound$iv = 0;
                suffixFound$iv = 0;
                while (prefixFound$iv == 0) {
                    if (buffer.charAt(aStart$iv) == newText.charAt(bStart$iv)) {
                    } else {
                    }
                    prefixFound$iv = 1;
                    if (suffixFound$iv == 0) {
                    }
                    if (aStart$iv < aEnd$iv) {
                    }
                    if (bStart$iv < bEnd$iv) {
                    }
                    if (prefixFound$iv != 0) {
                    } else {
                    }
                    if (suffixFound$iv == 0) {
                    }
                    if (buffer.charAt(aEnd$iv + -1) == newText.charAt(bEnd$iv + -1)) {
                    } else {
                    }
                    suffixFound$iv = 1;
                    aEnd$iv--;
                    bEnd$iv--;
                    aStart$iv++;
                    bStart$iv++;
                }
            }
        }
        if (aStart$iv >= aEnd$iv && bStart$iv >= bEnd$iv) {
            if (bStart$iv >= bEnd$iv) {
                charSequence = newText;
            } else {
                prefixFound$iv = 0;
                this.replace$foundation_release(aStart$iv, aEnd$iv, newText, bStart$iv, bEnd$iv);
            }
        } else {
        }
    }

    @Override // java.lang.Appendable
    public String toString() {
        return this.buffer.toString();
    }

    @Override // java.lang.Appendable
    public final androidx.compose.foundation.text.input.TextFieldCharSequence toTextFieldCharSequence-udt6zUU$foundation_release(long selection, TextRange composition) {
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence((CharSequence)this.buffer.toString(), selection, obj3, obj11, 0, 8, 0);
        return textFieldCharSequence;
    }
}
