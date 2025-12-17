package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\u0008\tB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\n", d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators;", "", "()V", "AbstractTextSegmentIterator", "CharacterTextSegmentIterator", "LineTextSegmentIterator", "PageTextSegmentIterator", "ParagraphTextSegmentIterator", "TextSegmentIterator", "WordTextSegmentIterator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AccessibilityIterators {

    public static final int $stable;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "", "following", "", "current", "", "preceding", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface TextSegmentIterator {
        public abstract int[] following(int i);

        public abstract int[] preceding(int i);
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\n¨\u0006\u0011", d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "()V", "segment", "", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getRange", "start", "", "end", "initialize", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class AbstractTextSegmentIterator implements androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator {

        public static final int $stable = 8;
        private final int[] segment;
        protected String text;
        static {
            final int i = 8;
        }

        public AbstractTextSegmentIterator() {
            super();
            this.segment = new int[2];
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
        protected final int[] getRange(int start, int end) {
            if (start >= 0 && end >= 0 && start == end) {
                if (end >= 0) {
                    if (start == end) {
                    }
                    this.segment[0] = start;
                    this.segment[1] = end;
                    return this.segment;
                }
            }
            return null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
        protected final String getText() {
            String text = this.text;
            if (text != null) {
                return text;
            }
            Intrinsics.throwUninitializedPropertyAccessException("text");
            return null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
        public void initialize(String text) {
            setText(text);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
        protected final void setText(String <set-?>) {
            this.text = <set-?>;
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0017\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "following", "", "current", "", "initialize", "", "text", "", "onLocaleChanged", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CharacterTextSegmentIterator extends androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator {

        public static final int $stable = 8;
        public static final androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator.Companion Companion;
        private static androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator instance;
        private BreakIterator impl;
        static {
            AccessibilityIterators.CharacterTextSegmentIterator.Companion companion = new AccessibilityIterators.CharacterTextSegmentIterator.Companion(0);
            AccessibilityIterators.CharacterTextSegmentIterator.Companion = companion;
            int i = 8;
        }

        private CharacterTextSegmentIterator(Locale locale) {
            super();
            onLocaleChanged(locale);
        }

        public CharacterTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker2) {
            super(locale);
        }

        public static final androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator access$getInstance$cp() {
            return AccessibilityIterators.CharacterTextSegmentIterator.instance;
        }

        public static final void access$setInstance$cp(androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator <set-?>) {
            AccessibilityIterators.CharacterTextSegmentIterator.instance = <set-?>;
        }

        private final void onLocaleChanged(Locale locale) {
            this.impl = BreakIterator.getCharacterInstance(locale);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] following(int current) {
            int start;
            BreakIterator impl2;
            BreakIterator impl;
            BreakIterator impl3;
            String str;
            int i;
            int length = getText().length();
            int i2 = 0;
            if (length <= 0) {
                return i2;
            }
            if (current >= length) {
                return i2;
            }
            if (current < 0) {
                start = 0;
            }
            str = "impl";
            while (this.impl == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                impl = i2;
                i = -1;
                if (this.impl == null) {
                }
                str = "impl";
                Intrinsics.throwUninitializedPropertyAccessException(str);
                impl2 = i2;
            }
            if (this.impl == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                impl3 = i2;
            }
            int following = impl3.following(start);
            if (following == i) {
                return i2;
            }
            return getRange(start, following);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public void initialize(String text) {
            BreakIterator impl;
            super.initialize(text);
            if (this.impl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                impl = 0;
            }
            impl.setText(text);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] preceding(int current) {
            int end;
            BreakIterator impl3;
            BreakIterator impl;
            BreakIterator impl2;
            String str;
            int i;
            int length = getText().length();
            int i2 = 0;
            if (length <= 0) {
                return i2;
            }
            if (current <= 0) {
                return i2;
            }
            if (current > length) {
                end = length;
            }
            str = "impl";
            while (this.impl == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                impl = i2;
                i = -1;
                if (this.impl == null) {
                }
                str = "impl";
                Intrinsics.throwUninitializedPropertyAccessException(str);
                impl3 = i2;
            }
            if (this.impl == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                impl2 = i2;
            }
            int preceding = impl2.preceding(end);
            if (preceding == i) {
                return i2;
            }
            return getRange(preceding, end);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0018\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "following", "", "current", "", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "initialize", "", "text", "", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LineTextSegmentIterator extends androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator {

        public static final int $stable = 8;
        public static final androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator.Companion Companion;
        private static final ResolvedTextDirection DirectionEnd = 8;
        private static final ResolvedTextDirection DirectionStart = 8;
        private static androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator lineInstance;
        private TextLayoutResult layoutResult;
        static {
            AccessibilityIterators.LineTextSegmentIterator.Companion companion = new AccessibilityIterators.LineTextSegmentIterator.Companion(0);
            AccessibilityIterators.LineTextSegmentIterator.Companion = companion;
            int i = 8;
            ResolvedTextDirection rtl = ResolvedTextDirection.Rtl;
            ResolvedTextDirection ltr = ResolvedTextDirection.Ltr;
        }

        public LineTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator access$getLineInstance$cp() {
            return AccessibilityIterators.LineTextSegmentIterator.lineInstance;
        }

        public static final void access$setLineInstance$cp(androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator <set-?>) {
            AccessibilityIterators.LineTextSegmentIterator.lineInstance = <set-?>;
        }

        private final int getLineEdgeIndex(int lineNumber, ResolvedTextDirection direction) {
            TextLayoutResult layoutResult3;
            int lineStart;
            TextLayoutResult i2;
            TextLayoutResult layoutResult;
            TextLayoutResult layoutResult2;
            int i;
            String str = "layoutResult";
            i2 = 0;
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                layoutResult3 = i2;
            }
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                layoutResult = i2;
            }
            if (direction != layoutResult.getParagraphDirection(layoutResult3.getLineStart(lineNumber))) {
                layoutResult2 = this.layoutResult;
                if (layoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                } else {
                    i2 = layoutResult2;
                }
                lineStart = i2.getLineStart(lineNumber);
            } else {
                if (this.layoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    layoutResult2 = i2;
                }
                lineEnd$default--;
            }
            return lineStart;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] following(int current) {
            int currentLine;
            TextLayoutResult layoutResult;
            TextLayoutResult layoutResult2;
            int lineEdgeIndex;
            TextLayoutResult layoutResult3;
            int i = 0;
            if (getText().length() <= 0) {
                return i;
            }
            if (current >= getText().length()) {
                return i;
            }
            String str = "layoutResult";
            if (current < 0) {
                if (this.layoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    layoutResult = i;
                }
                currentLine = layoutResult.getLineForOffset(0);
            } else {
                if (this.layoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    layoutResult2 = i;
                }
                currentLine = layoutResult2.getLineForOffset(current);
                if (getLineEdgeIndex(currentLine, AccessibilityIterators.LineTextSegmentIterator.DirectionStart) == current) {
                } else {
                    currentLine = lineEdgeIndex;
                }
            }
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                layoutResult3 = i;
            }
            if (currentLine >= layoutResult3.getLineCount()) {
                return i;
            }
            return getRange(getLineEdgeIndex(currentLine, AccessibilityIterators.LineTextSegmentIterator.DirectionStart), lineEdgeIndex3++);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public final void initialize(String text, TextLayoutResult layoutResult) {
            setText(text);
            this.layoutResult = layoutResult;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] preceding(int current) {
            int currentLine;
            TextLayoutResult layoutResult;
            TextLayoutResult layoutResult2;
            int length;
            int i = 0;
            if (getText().length() <= 0) {
                return i;
            }
            if (current <= 0) {
                return i;
            }
            String str = "layoutResult";
            if (current > getText().length()) {
                if (this.layoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    layoutResult = i;
                }
                currentLine = layoutResult.getLineForOffset(getText().length());
            } else {
                if (this.layoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    layoutResult2 = i;
                }
                currentLine = layoutResult2.getLineForOffset(current);
                if (lineEdgeIndex3++ == current) {
                } else {
                    currentLine = length;
                }
            }
            if (currentLine < 0) {
                return i;
            }
            return getRange(getLineEdgeIndex(currentLine, AccessibilityIterators.LineTextSegmentIterator.DirectionStart), lineEdgeIndex2++);
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\u0018\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "tempRect", "Landroid/graphics/Rect;", "following", "", "current", "", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "initialize", "", "text", "", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PageTextSegmentIterator extends androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator {

        public static final int $stable = 8;
        public static final androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator.Companion Companion;
        private static final ResolvedTextDirection DirectionEnd = 8;
        private static final ResolvedTextDirection DirectionStart = 8;
        private static androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator pageInstance;
        private TextLayoutResult layoutResult;
        private SemanticsNode node;
        private Rect tempRect;
        static {
            AccessibilityIterators.PageTextSegmentIterator.Companion companion = new AccessibilityIterators.PageTextSegmentIterator.Companion(0);
            AccessibilityIterators.PageTextSegmentIterator.Companion = companion;
            int i = 8;
            ResolvedTextDirection rtl = ResolvedTextDirection.Rtl;
            ResolvedTextDirection ltr = ResolvedTextDirection.Ltr;
        }

        private PageTextSegmentIterator() {
            super();
            Rect rect = new Rect();
            this.tempRect = rect;
        }

        public PageTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator access$getPageInstance$cp() {
            return AccessibilityIterators.PageTextSegmentIterator.pageInstance;
        }

        public static final void access$setPageInstance$cp(androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator <set-?>) {
            AccessibilityIterators.PageTextSegmentIterator.pageInstance = <set-?>;
        }

        private final int getLineEdgeIndex(int lineNumber, ResolvedTextDirection direction) {
            TextLayoutResult layoutResult3;
            int lineStart;
            TextLayoutResult i2;
            TextLayoutResult layoutResult;
            TextLayoutResult layoutResult2;
            int i;
            String str = "layoutResult";
            i2 = 0;
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                layoutResult3 = i2;
            }
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                layoutResult = i2;
            }
            if (direction != layoutResult.getParagraphDirection(layoutResult3.getLineStart(lineNumber))) {
                layoutResult2 = this.layoutResult;
                if (layoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                } else {
                    i2 = layoutResult2;
                }
                lineStart = i2.getLineStart(lineNumber);
            } else {
                if (this.layoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    layoutResult2 = i2;
                }
                lineEnd$default--;
            }
            return lineStart;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] following(int current) {
            int i;
            TextLayoutResult i2;
            SemanticsNode node;
            TextLayoutResult layoutResult3;
            TextLayoutResult layoutResult5;
            TextLayoutResult layoutResult4;
            TextLayoutResult layoutResult2;
            TextLayoutResult layoutResult;
            i2 = 0;
            if (getText().length() <= 0) {
                return i2;
            }
            if (current >= getText().length()) {
                return i2;
            }
            int i3 = 0;
            if (this.node == null) {
                Intrinsics.throwUninitializedPropertyAccessException("node");
                node = i2;
            }
            int i4 = 0;
            int coerceAtLeast = RangesKt.coerceAtLeast(0, current);
            String str2 = "layoutResult";
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                layoutResult3 = i2;
            }
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                layoutResult5 = i2;
            }
            f += lineTop;
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                layoutResult4 = i2;
            }
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                layoutResult2 = i2;
            }
            if (Float.compare(i6, lineTop2) < 0) {
                layoutResult = this.layoutResult;
                if (layoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                } else {
                    i2 = layoutResult;
                }
                lineForVerticalPosition--;
            } else {
                layoutResult = this.layoutResult;
                if (layoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                } else {
                    i2 = layoutResult;
                }
                lineCount--;
            }
            return getRange(coerceAtLeast, lineEdgeIndex++);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public final void initialize(String text, TextLayoutResult layoutResult, SemanticsNode node) {
            setText(text);
            this.layoutResult = layoutResult;
            this.node = node;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] preceding(int current) {
            int i;
            int currentPageStartLine;
            SemanticsNode node;
            TextLayoutResult layoutResult;
            TextLayoutResult layoutResult2;
            TextLayoutResult layoutResult3;
            i = 0;
            if (getText().length() <= 0) {
                return i;
            }
            if (current <= 0) {
                return i;
            }
            int i2 = 0;
            if (this.node == null) {
                Intrinsics.throwUninitializedPropertyAccessException("node");
                node = i;
            }
            int i3 = 0;
            int coerceAtMost = RangesKt.coerceAtMost(getText().length(), current);
            String str2 = "layoutResult";
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                layoutResult = i;
            }
            int lineForOffset = layoutResult.getLineForOffset(coerceAtMost);
            if (this.layoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                layoutResult2 = i;
            }
            int i4 = lineTop - f;
            if (Float.compare(i4, i5) > 0) {
                layoutResult3 = this.layoutResult;
                if (layoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                } else {
                    i = layoutResult3;
                }
                currentPageStartLine = i.getLineForVerticalPosition(i4);
            } else {
                currentPageStartLine = 0;
            }
            if (coerceAtMost == getText().length() && currentPageStartLine < lineForOffset) {
                try {
                    if (currentPageStartLine < lineForOffset) {
                    }
                    currentPageStartLine++;
                    return getRange(getLineEdgeIndex(currentPageStartLine, AccessibilityIterators.PageTextSegmentIterator.DirectionStart), coerceAtMost);
                    return obj1;
                }
            }
        }
    }

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0007\u0018\u0000 \u000c2\u00020\u0001:\u0001\u000cB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r", d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "following", "", "current", "", "isEndBoundary", "", "index", "isStartBoundary", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ParagraphTextSegmentIterator extends androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator {

        public static final int $stable;
        public static final androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator.Companion Companion;
        private static androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator instance;
        static {
            AccessibilityIterators.ParagraphTextSegmentIterator.Companion companion = new AccessibilityIterators.ParagraphTextSegmentIterator.Companion(0);
            AccessibilityIterators.ParagraphTextSegmentIterator.Companion = companion;
        }

        public ParagraphTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator access$getInstance$cp() {
            return AccessibilityIterators.ParagraphTextSegmentIterator.instance;
        }

        public static final void access$setInstance$cp(androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator <set-?>) {
            AccessibilityIterators.ParagraphTextSegmentIterator.instance = <set-?>;
        }

        private final boolean isEndBoundary(int index) {
            int charAt;
            int i2;
            int i;
            i = 10;
            if (index > 0 && getText().charAt(index + -1) != i) {
                i = 10;
                if (getText().charAt(index + -1) != i) {
                    if (index != getText().length()) {
                        i2 = getText().charAt(index) == i ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i2;
        }

        private final boolean isStartBoundary(int index) {
            char charAt;
            int i2;
            int i;
            final int i3 = 10;
            if (getText().charAt(index) != i3) {
                if (index != 0) {
                    i2 = getText().charAt(index + -1) == i3 ? 1 : 0;
                } else {
                }
            } else {
            }
            return i2;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] following(int current) {
            int end;
            int start;
            boolean startBoundary;
            int i;
            int length = getText().length();
            int i2 = 0;
            if (length <= 0) {
                return i2;
            }
            if (current >= length) {
                return i2;
            }
            if (current < 0) {
                start = 0;
            }
            while (start < length) {
                if (getText().charAt(start) == 10) {
                }
                if (!isStartBoundary(start)) {
                }
                start++;
            }
            if (start >= length) {
                return i2;
            }
            end = start + 1;
            while (end < length) {
                if (isEndBoundary(end) == 0) {
                }
                end++;
            }
            return getRange(start, end);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] preceding(int current) {
            int start;
            int end;
            boolean startBoundary;
            int i;
            int length = getText().length();
            int i2 = 0;
            if (length <= 0) {
                return i2;
            }
            if (current <= 0) {
                return i2;
            }
            if (current > length) {
                end = length;
            }
            while (end > 0) {
                if (getText().charAt(end + -1) == 10) {
                }
                if (!isEndBoundary(end)) {
                }
                end--;
            }
            if (end <= 0) {
                return i2;
            }
            start = end + -1;
            while (start > 0) {
                if (isStartBoundary(start) == 0) {
                }
                start--;
            }
            return getRange(start, end);
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "following", "", "current", "", "initialize", "", "text", "", "isEndBoundary", "", "index", "isLetterOrDigit", "isStartBoundary", "onLocaleChanged", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WordTextSegmentIterator extends androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator {

        public static final int $stable = 8;
        public static final androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator.Companion Companion;
        private static androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator instance;
        private BreakIterator impl;
        static {
            AccessibilityIterators.WordTextSegmentIterator.Companion companion = new AccessibilityIterators.WordTextSegmentIterator.Companion(0);
            AccessibilityIterators.WordTextSegmentIterator.Companion = companion;
            int i = 8;
        }

        private WordTextSegmentIterator(Locale locale) {
            super();
            onLocaleChanged(locale);
        }

        public WordTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker2) {
            super(locale);
        }

        public static final androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator access$getInstance$cp() {
            return AccessibilityIterators.WordTextSegmentIterator.instance;
        }

        public static final void access$setInstance$cp(androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator <set-?>) {
            AccessibilityIterators.WordTextSegmentIterator.instance = <set-?>;
        }

        private final boolean isEndBoundary(int index) {
            int letterOrDigit;
            int i;
            if (index > 0 && isLetterOrDigit(index + -1)) {
                if (isLetterOrDigit(index + -1)) {
                    if (index != getText().length()) {
                        i = !isLetterOrDigit(index) ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        private final boolean isLetterOrDigit(int index) {
            int length;
            if (index >= 0 && index < getText().length()) {
                if (index < getText().length()) {
                    return Character.isLetterOrDigit(getText().codePointAt(index));
                }
            }
            return 0;
        }

        private final boolean isStartBoundary(int index) {
            boolean letterOrDigit;
            int i;
            if (isLetterOrDigit(index)) {
                if (index != 0) {
                    i = !isLetterOrDigit(index + -1) ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }

        private final void onLocaleChanged(Locale locale) {
            this.impl = BreakIterator.getWordInstance(locale);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] following(int current) {
            int start;
            BreakIterator impl;
            boolean letterOrDigit;
            BreakIterator impl2;
            String endBoundary;
            int i;
            int i2 = 0;
            if (getText().length() <= 0) {
                return i2;
            }
            if (current >= getText().length()) {
                return i2;
            }
            if (current < 0) {
                start = 0;
            }
            endBoundary = "impl";
            i = -1;
            while (!isLetterOrDigit(start)) {
                if (this.impl == null) {
                }
                endBoundary = "impl";
                i = -1;
                Intrinsics.throwUninitializedPropertyAccessException(endBoundary);
                impl = i2;
            }
            if (this.impl == null) {
                Intrinsics.throwUninitializedPropertyAccessException(endBoundary);
                impl2 = i2;
            }
            int following = impl2.following(start);
            if (following != i && !isEndBoundary(following)) {
                if (!isEndBoundary(following)) {
                }
                return getRange(start, following);
            }
            return i2;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public void initialize(String text) {
            BreakIterator impl;
            super.initialize(text);
            if (this.impl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                impl = 0;
            }
            impl.setText(text);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
        public int[] preceding(int current) {
            int end;
            String str;
            int startBoundary;
            BreakIterator letterOrDigit;
            BreakIterator impl;
            int length = getText().length();
            int i = 0;
            if (length <= 0) {
                return i;
            }
            if (current <= 0) {
                return i;
            }
            if (current > length) {
                end = length;
            }
            str = "impl";
            startBoundary = -1;
            while (end > 0) {
                if (this.impl == null) {
                }
                str = "impl";
                startBoundary = -1;
                Intrinsics.throwUninitializedPropertyAccessException(str);
                letterOrDigit = i;
            }
            if (this.impl == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                impl = i;
            }
            int preceding = impl.preceding(end);
            if (preceding != startBoundary && !isStartBoundary(preceding)) {
                if (!isStartBoundary(preceding)) {
                }
                return getRange(preceding, end);
            }
            return i;
        }
    }
    static {
    }
}
