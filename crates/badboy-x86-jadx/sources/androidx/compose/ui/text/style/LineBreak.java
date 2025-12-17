package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0008\u0087@\u0018\u0000 \u001e2\u00020\u0001:\u0004\u001e\u001f !B!\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\u0008\u0008\u0010\tB\u0011\u0008\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\u0008\u0008\u0010\u000cJ.\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\u0008\u0019\u0010\u000cJ\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u0017\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000cR\u0017\u0010\u0006\u001a\u00020\u00078Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000c\u0088\u0001\n\u0092\u0001\u00020\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\"", d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "constructor-impl", "(III)I", "mask", "", "(I)I", "getStrategy-fcGXIks", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", "copy", "copy-gijOMQM", "(IIII)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class LineBreak {

    public static final androidx.compose.ui.text.style.LineBreak.Companion Companion;
    private static final int Heading;
    private static final int Paragraph;
    private static final int Simple;
    private static final int Unspecified;
    private final int mask;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0010\u0010\u0002\u001a\u0004\u0008\u0011\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "()V", "Heading", "Landroidx/compose/ui/text/style/LineBreak;", "getHeading-rAG3T2k$annotations", "getHeading-rAG3T2k", "()I", "I", "Paragraph", "getParagraph-rAG3T2k$annotations", "getParagraph-rAG3T2k", "Simple", "getSimple-rAG3T2k$annotations", "getSimple-rAG3T2k", "Unspecified", "getUnspecified-rAG3T2k$annotations", "getUnspecified-rAG3T2k", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getHeading-rAG3T2k$annotations() {
        }

        public static void getParagraph-rAG3T2k$annotations() {
        }

        public static void getSimple-rAG3T2k$annotations() {
        }

        public static void getUnspecified-rAG3T2k$annotations() {
        }

        public final int getHeading-rAG3T2k() {
            return LineBreak.access$getHeading$cp();
        }

        public final int getParagraph-rAG3T2k() {
            return LineBreak.access$getParagraph$cp();
        }

        public final int getSimple-rAG3T2k() {
            return LineBreak.access$getSimple$cp();
        }

        public final int getUnspecified-rAG3T2k() {
            return LineBreak.access$getUnspecified$cp();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Strategy {

        private static final int Balanced;
        public static final androidx.compose.ui.text.style.LineBreak.Strategy.Companion Companion;
        private static final int HighQuality;
        private static final int Simple;
        private static final int Unspecified;
        private final int value;
        static {
            LineBreak.Strategy.Companion companion = new LineBreak.Strategy.Companion(0);
            LineBreak.Strategy.Companion = companion;
            LineBreak.Strategy.Simple = LineBreak.Strategy.constructor-impl(1);
            LineBreak.Strategy.HighQuality = LineBreak.Strategy.constructor-impl(2);
            LineBreak.Strategy.Balanced = LineBreak.Strategy.constructor-impl(3);
            LineBreak.Strategy.Unspecified = LineBreak.Strategy.constructor-impl(0);
        }

        private Strategy(int value) {
            super();
            this.value = value;
        }

        public static final int access$getBalanced$cp() {
            return LineBreak.Strategy.Balanced;
        }

        public static final int access$getHighQuality$cp() {
            return LineBreak.Strategy.HighQuality;
        }

        public static final int access$getSimple$cp() {
            return LineBreak.Strategy.Simple;
        }

        public static final int access$getUnspecified$cp() {
            return LineBreak.Strategy.Unspecified;
        }

        public static final androidx.compose.ui.text.style.LineBreak.Strategy box-impl(int i) {
            LineBreak.Strategy strategy = new LineBreak.Strategy(i);
            return strategy;
        }

        public static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof LineBreak.Strategy) {
                return i3;
            }
            if (i != (LineBreak.Strategy)object2.unbox-impl()) {
                return i3;
            }
            return 1;
        }

        public static final boolean equals-impl0(int i, int i2) {
            int i3;
            i3 = i == i2 ? 1 : 0;
            return i3;
        }

        public static int hashCode-impl(int i) {
            return Integer.hashCode(i);
        }

        public static String toString-impl(int arg0) {
            String str;
            str = LineBreak.Strategy.equals-impl0(arg0, LineBreak.Strategy.Simple) ? "Strategy.Simple" : equals-impl02 ? "Strategy.HighQuality" : equals-impl03 ? "Strategy.Balanced" : equals-impl04 ? "Strategy.Unspecified" : "Invalid";
            return str;
        }

        public boolean equals(Object object) {
            return LineBreak.Strategy.equals-impl(this.value, object);
        }

        public int hashCode() {
            return LineBreak.Strategy.hashCode-impl(this.value);
        }

        public String toString() {
            return LineBreak.Strategy.toString-impl(this.value);
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class Strictness {

        public static final androidx.compose.ui.text.style.LineBreak.Strictness.Companion Companion;
        private static final int Default;
        private static final int Loose;
        private static final int Normal;
        private static final int Strict;
        private static final int Unspecified;
        private final int value;
        static {
            LineBreak.Strictness.Companion companion = new LineBreak.Strictness.Companion(0);
            LineBreak.Strictness.Companion = companion;
            LineBreak.Strictness.Default = LineBreak.Strictness.constructor-impl(1);
            LineBreak.Strictness.Loose = LineBreak.Strictness.constructor-impl(2);
            LineBreak.Strictness.Normal = LineBreak.Strictness.constructor-impl(3);
            LineBreak.Strictness.Strict = LineBreak.Strictness.constructor-impl(4);
            LineBreak.Strictness.Unspecified = LineBreak.Strictness.constructor-impl(0);
        }

        private Strictness(int value) {
            super();
            this.value = value;
        }

        public static final int access$getDefault$cp() {
            return LineBreak.Strictness.Default;
        }

        public static final int access$getLoose$cp() {
            return LineBreak.Strictness.Loose;
        }

        public static final int access$getNormal$cp() {
            return LineBreak.Strictness.Normal;
        }

        public static final int access$getStrict$cp() {
            return LineBreak.Strictness.Strict;
        }

        public static final int access$getUnspecified$cp() {
            return LineBreak.Strictness.Unspecified;
        }

        public static final androidx.compose.ui.text.style.LineBreak.Strictness box-impl(int i) {
            LineBreak.Strictness strictness = new LineBreak.Strictness(i);
            return strictness;
        }

        public static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof LineBreak.Strictness) {
                return i3;
            }
            if (i != (LineBreak.Strictness)object2.unbox-impl()) {
                return i3;
            }
            return 1;
        }

        public static final boolean equals-impl0(int i, int i2) {
            int i3;
            i3 = i == i2 ? 1 : 0;
            return i3;
        }

        public static int hashCode-impl(int i) {
            return Integer.hashCode(i);
        }

        public static String toString-impl(int arg0) {
            String str;
            str = LineBreak.Strictness.equals-impl0(arg0, LineBreak.Strictness.Default) ? "Strictness.None" : equals-impl02 ? "Strictness.Loose" : equals-impl03 ? "Strictness.Normal" : equals-impl04 ? "Strictness.Strict" : equals-impl05 ? "Strictness.Unspecified" : "Invalid";
            return str;
        }

        public boolean equals(Object object) {
            return LineBreak.Strictness.equals-impl(this.value, object);
        }

        public int hashCode() {
            return LineBreak.Strictness.hashCode-impl(this.value);
        }

        public String toString() {
            return LineBreak.Strictness.toString-impl(this.value);
        }

        public final int unbox-impl() {
            return this.value;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class WordBreak {

        public static final androidx.compose.ui.text.style.LineBreak.WordBreak.Companion Companion;
        private static final int Default;
        private static final int Phrase;
        private static final int Unspecified;
        private final int value;
        static {
            LineBreak.WordBreak.Companion companion = new LineBreak.WordBreak.Companion(0);
            LineBreak.WordBreak.Companion = companion;
            LineBreak.WordBreak.Default = LineBreak.WordBreak.constructor-impl(1);
            LineBreak.WordBreak.Phrase = LineBreak.WordBreak.constructor-impl(2);
            LineBreak.WordBreak.Unspecified = LineBreak.WordBreak.constructor-impl(0);
        }

        private WordBreak(int value) {
            super();
            this.value = value;
        }

        public static final int access$getDefault$cp() {
            return LineBreak.WordBreak.Default;
        }

        public static final int access$getPhrase$cp() {
            return LineBreak.WordBreak.Phrase;
        }

        public static final int access$getUnspecified$cp() {
            return LineBreak.WordBreak.Unspecified;
        }

        public static final androidx.compose.ui.text.style.LineBreak.WordBreak box-impl(int i) {
            LineBreak.WordBreak wordBreak = new LineBreak.WordBreak(i);
            return wordBreak;
        }

        public static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof LineBreak.WordBreak) {
                return i3;
            }
            if (i != (LineBreak.WordBreak)object2.unbox-impl()) {
                return i3;
            }
            return 1;
        }

        public static final boolean equals-impl0(int i, int i2) {
            int i3;
            i3 = i == i2 ? 1 : 0;
            return i3;
        }

        public static int hashCode-impl(int i) {
            return Integer.hashCode(i);
        }

        public static String toString-impl(int arg0) {
            String str;
            str = LineBreak.WordBreak.equals-impl0(arg0, LineBreak.WordBreak.Default) ? "WordBreak.None" : equals-impl02 ? "WordBreak.Phrase" : equals-impl03 ? "WordBreak.Unspecified" : "Invalid";
            return str;
        }

        public boolean equals(Object object) {
            return LineBreak.WordBreak.equals-impl(this.value, object);
        }

        public int hashCode() {
            return LineBreak.WordBreak.hashCode-impl(this.value);
        }

        public String toString() {
            return LineBreak.WordBreak.toString-impl(this.value);
        }

        public final int unbox-impl() {
            return this.value;
        }
    }
    static {
        LineBreak.Companion companion = new LineBreak.Companion(0);
        LineBreak.Companion = companion;
        LineBreak.Simple = LineBreak.constructor-impl(LineBreak_androidKt.access$packBytes(LineBreak.Strategy.Companion.getSimple-fcGXIks(), LineBreak.Strictness.Companion.getNormal-usljTpc(), LineBreak.WordBreak.Companion.getDefault-jp8hJ3c()));
        LineBreak.Heading = LineBreak.constructor-impl(LineBreak_androidKt.access$packBytes(LineBreak.Strategy.Companion.getBalanced-fcGXIks(), LineBreak.Strictness.Companion.getLoose-usljTpc(), LineBreak.WordBreak.Companion.getPhrase-jp8hJ3c()));
        LineBreak.Paragraph = LineBreak.constructor-impl(LineBreak_androidKt.access$packBytes(LineBreak.Strategy.Companion.getHighQuality-fcGXIks(), LineBreak.Strictness.Companion.getStrict-usljTpc(), LineBreak.WordBreak.Companion.getDefault-jp8hJ3c()));
        LineBreak.Unspecified = LineBreak.constructor-impl(0);
    }

    private LineBreak(int mask) {
        super();
        this.mask = mask;
    }

    public static final int access$getHeading$cp() {
        return LineBreak.Heading;
    }

    public static final int access$getParagraph$cp() {
        return LineBreak.Paragraph;
    }

    public static final int access$getSimple$cp() {
        return LineBreak.Simple;
    }

    public static final int access$getUnspecified$cp() {
        return LineBreak.Unspecified;
    }

    public static final androidx.compose.ui.text.style.LineBreak box-impl(int i) {
        LineBreak lineBreak = new LineBreak(i);
        return lineBreak;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static int constructor-impl(int strategy, int strictness, int wordBreak) {
        return LineBreak.constructor-impl(LineBreak_androidKt.access$packBytes(strategy, strictness, wordBreak));
    }

    public static final int copy-gijOMQM(int arg0, int strategy, int strictness, int wordBreak) {
        return LineBreak.constructor-impl(strategy, strictness, wordBreak);
    }

    public static int copy-gijOMQM$default(int i, int i2, int i3, int i4, int i5, Object object6) {
        int obj1;
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = LineBreak.getStrategy-fcGXIks(i);
        }
        if (i5 & 2 != 0) {
            obj2 = LineBreak.getStrictness-usljTpc(i);
        }
        if (i5 &= 4 != 0) {
            obj3 = LineBreak.getWordBreak-jp8hJ3c(i);
        }
        return LineBreak.copy-gijOMQM(i, obj1, obj2, obj3);
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof LineBreak) {
            return i3;
        }
        if (i != (LineBreak)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    public static final int getStrategy-fcGXIks(int arg0) {
        return LineBreak.Strategy.constructor-impl(LineBreak_androidKt.access$unpackByte1(arg0));
    }

    public static final int getStrictness-usljTpc(int arg0) {
        return LineBreak.Strictness.constructor-impl(LineBreak_androidKt.access$unpackByte2(arg0));
    }

    public static final int getWordBreak-jp8hJ3c(int arg0) {
        return LineBreak.WordBreak.constructor-impl(LineBreak_androidKt.access$unpackByte3(arg0));
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    public static String toString-impl(int arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LineBreak(strategy=").append(LineBreak.Strategy.toString-impl(LineBreak.getStrategy-fcGXIks(arg0))).append(", strictness=").append(LineBreak.Strictness.toString-impl(LineBreak.getStrictness-usljTpc(arg0))).append(", wordBreak=").append(LineBreak.WordBreak.toString-impl(LineBreak.getWordBreak-jp8hJ3c(arg0))).append(')').toString();
    }

    public boolean equals(Object object) {
        return LineBreak.equals-impl(this.mask, object);
    }

    public int hashCode() {
        return LineBreak.hashCode-impl(this.mask);
    }

    public String toString() {
        return LineBreak.toString-impl(this.mask);
    }

    public final int unbox-impl() {
        return this.mask;
    }
}
