package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0007\u0018\u0000 :2\u00020\u0001:\u00039:;B;\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\u0002\u0010\nBY\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0008\u0002\u0010\u000b\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005\u0012\u0016\u0008\u0002\u0010\u000c\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0005\u0012\u0018\u0008\u0002\u0010\r\u001a\u0012\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u000e0\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\u0011\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013H\u0096\u0002J\"\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020#0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\"\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J*\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\"\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J$\u0010*\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020+0\u00060\u00052\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013H\u0007J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0000J\u0016\u0010-\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\u001e\u0010.\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013J\u0008\u0010/\u001a\u00020\u0013H\u0016J\u0011\u00100\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002J\u0018\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u000203ø\u0001\u0000¢\u0006\u0004\u00084\u00105J\u0018\u00101\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u0013H\u0016J\u0008\u00108\u001a\u00020\u0003H\u0016R$\u0010\r\u001a\u0012\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u000e0\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u001d\u0010\u0008\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00060\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0011R\"\u0010\u000c\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0011R\"\u0010\u000b\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006<", d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "", "text", "", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "spanStylesOrNull", "paragraphStylesOrNull", "annotations", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnnotations$ui_text_release", "()Ljava/util/List;", "length", "", "getLength", "()I", "getParagraphStyles", "getParagraphStylesOrNull$ui_text_release", "getSpanStyles", "getSpanStylesOrNull$ui_text_release", "getText", "()Ljava/lang/String;", "equals", "", "other", "get", "", "index", "getLinkAnnotations", "Landroidx/compose/ui/text/LinkAnnotation;", "start", "end", "getStringAnnotations", "tag", "getTtsAnnotations", "Landroidx/compose/ui/text/TtsAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/UrlAnnotation;", "hasEqualAnnotations", "hasLinkAnnotations", "hasStringAnnotations", "hashCode", "plus", "subSequence", "range", "Landroidx/compose/ui/text/TextRange;", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "startIndex", "endIndex", "toString", "Builder", "Companion", "Range", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnnotatedString implements java.lang.CharSequence {

    public static final int $stable;
    public static final androidx.compose.ui.text.AnnotatedString.Companion Companion;
    private static final Saver<androidx.compose.ui.text.AnnotatedString, ?> Saver;
    private final List<androidx.compose.ui.text.AnnotatedString.Range<? extends Object>> annotations;
    private final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>> paragraphStylesOrNull;
    private final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStylesOrNull;
    private final String text;

    @Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000c\n\u0002\u0010\r\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001;B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ&\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u001e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ \u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0007J \u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0007J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0006J\u001e\u0010,\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tJ\u0010\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010,\u001a\u00020\u00002\u0008\u0010\u0003\u001a\u0004\u0018\u00010/H\u0016J\"\u0010,\u001a\u00020\u00002\u0008\u0010\u0003\u001a\u0004\u0018\u00010/2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0016J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u0004J\u0015\u00100\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u0008,J\u0006\u00101\u001a\u00020\u001aJ\u000e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\tJ\u000e\u00103\u001a\u00020\t2\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0013J\u000e\u00107\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0015J\u000e\u00108\u001a\u00020\t2\u0006\u0010'\u001a\u00020(J\u0010\u00109\u001a\u00020\t2\u0006\u0010*\u001a\u00020+H\u0007J\u0006\u0010:\u001a\u00020\u0006R\u001c\u0010\u000b\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u000e0\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u000e0\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00060\u0017j\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<", d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "text", "", "(Ljava/lang/String;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "capacity", "", "(I)V", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "", "length", "getLength", "()I", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyles", "Landroidx/compose/ui/text/SpanStyle;", "styleStack", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "addLink", "", "clickable", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "start", "end", "url", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "addStringAnnotation", "tag", "annotation", "addStyle", "style", "addTtsAnnotation", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "addUrlAnnotation", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "append", "char", "", "", "deprecated_append_returning_void", "pop", "index", "pushLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "pushStringAnnotation", "pushStyle", "pushTtsAnnotation", "pushUrlAnnotation", "toAnnotatedString", "MutableRange", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder implements java.lang.Appendable {

        public static final int $stable = 8;
        private final List<androidx.compose.ui.text.AnnotatedString.Builder.MutableRange<? extends Object>> annotations;
        private final List<androidx.compose.ui.text.AnnotatedString.Builder.MutableRange<androidx.compose.ui.text.ParagraphStyle>> paragraphStyles;
        private final List<androidx.compose.ui.text.AnnotatedString.Builder.MutableRange<androidx.compose.ui.text.SpanStyle>> spanStyles;
        private final List<androidx.compose.ui.text.AnnotatedString.Builder.MutableRange<? extends Object>> styleStack;
        private final StringBuilder text;
        static {
            final int i = 8;
        }

        public Builder() {
            super(0, 1, 0);
        }

        public Builder(int capacity) {
            super();
            StringBuilder stringBuilder = new StringBuilder(capacity);
            this.text = stringBuilder;
            ArrayList arrayList = new ArrayList();
            this.spanStyles = (List)arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.paragraphStyles = (List)arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.annotations = (List)arrayList3;
            ArrayList arrayList4 = new ArrayList();
            this.styleStack = (List)arrayList4;
        }

        public Builder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
            int obj1;
            obj1 = i2 &= 1 != 0 ? 16 : obj1;
            super(obj1);
        }

        public Builder(androidx.compose.ui.text.AnnotatedString text) {
            super(0, 1, 0);
            append(text);
        }

        public Builder(String text) {
            super(0, 1, 0);
            append(text);
        }

        @Override // java.lang.Appendable
        public final void addLink(androidx.compose.ui.text.LinkAnnotation.Clickable clickable, int start, int end) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(clickable, start, end, 0, 8, 0);
            this.annotations.add(mutableRange);
        }

        @Override // java.lang.Appendable
        public final void addLink(androidx.compose.ui.text.LinkAnnotation.Url url, int start, int end) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(url, start, end, 0, 8, 0);
            this.annotations.add(mutableRange);
        }

        @Override // java.lang.Appendable
        public final void addStringAnnotation(String tag, String annotation, int start, int end) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(annotation, start, end, tag);
            this.annotations.add(mutableRange);
        }

        @Override // java.lang.Appendable
        public final void addStyle(androidx.compose.ui.text.ParagraphStyle style, int start, int end) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(style, start, end, 0, 8, 0);
            this.paragraphStyles.add(mutableRange);
        }

        @Override // java.lang.Appendable
        public final void addStyle(androidx.compose.ui.text.SpanStyle style, int start, int end) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(style, start, end, 0, 8, 0);
            this.spanStyles.add(mutableRange);
        }

        @Override // java.lang.Appendable
        public final void addTtsAnnotation(androidx.compose.ui.text.TtsAnnotation ttsAnnotation, int start, int end) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(ttsAnnotation, start, end, 0, 8, 0);
            this.annotations.add(mutableRange);
        }

        @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(...))
        public final void addUrlAnnotation(androidx.compose.ui.text.UrlAnnotation urlAnnotation, int start, int end) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(urlAnnotation, start, end, 0, 8, 0);
            this.annotations.add(mutableRange);
        }

        @Override // java.lang.Appendable
        public androidx.compose.ui.text.AnnotatedString.Builder append(char char) {
            this.text.append(char);
            return this;
        }

        @Override // java.lang.Appendable
        public androidx.compose.ui.text.AnnotatedString.Builder append(java.lang.CharSequence text) {
            Object text2;
            if (text instanceof AnnotatedString != null) {
                append((AnnotatedString)text);
            } else {
                this.text.append(text);
            }
            return this;
        }

        @Override // java.lang.Appendable
        public androidx.compose.ui.text.AnnotatedString.Builder append(java.lang.CharSequence text, int start, int end) {
            Object text2;
            if (text instanceof AnnotatedString != null) {
                append((AnnotatedString)text, start, end);
            } else {
                this.text.append(text, start, end);
            }
            return this;
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(char p0) {
            return (Appendable)append(p0);
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(java.lang.CharSequence p0) {
            return (Appendable)append(p0);
        }

        @Override // java.lang.Appendable
        public java.lang.Appendable append(java.lang.CharSequence p0, int p1, int p2) {
            return (Appendable)append(p0, p1, p2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by the append(Char) method that returns an Appendable. This method must be kept around for binary compatibility.")
        public final void append(char char) {
            append(char);
        }

        @Override // java.lang.Appendable
        public final void append(androidx.compose.ui.text.AnnotatedString text) {
            String text2;
            int index$iv;
            int size;
            Object obj2;
            Object obj;
            int i;
            Object annotations;
            int mutableRange;
            int item;
            int i2;
            int i3;
            String tag;
            int length = this.text.length();
            this.text.append(text.getText());
            List spanStylesOrNull$ui_text_release = text.getSpanStylesOrNull$ui_text_release();
            if (spanStylesOrNull$ui_text_release != null) {
                text2 = 0;
                index$iv = 0;
                while (index$iv < spanStylesOrNull$ui_text_release.size()) {
                    obj = obj2;
                    i = 0;
                    addStyle((SpanStyle)(AnnotatedString.Range)obj.getItem(), start += length, end += length);
                    index$iv++;
                }
            }
            List paragraphStylesOrNull$ui_text_release = text.getParagraphStylesOrNull$ui_text_release();
            if (paragraphStylesOrNull$ui_text_release != null) {
                text2 = 0;
                index$iv = 0;
                while (index$iv < paragraphStylesOrNull$ui_text_release.size()) {
                    obj = obj2;
                    i = 0;
                    addStyle((ParagraphStyle)(AnnotatedString.Range)obj.getItem(), start2 += length, end2 += length);
                    index$iv++;
                }
            }
            List annotations$ui_text_release = text.getAnnotations$ui_text_release();
            if (annotations$ui_text_release != null) {
                text2 = 0;
                index$iv = 0;
                while (index$iv < annotations$ui_text_release.size()) {
                    obj = obj2;
                    i = 0;
                    mutableRange = new AnnotatedString.Builder.MutableRange((AnnotatedString.Range)obj.getItem(), start3 += length, end3 += length, obj.getTag());
                    this.annotations.add(mutableRange);
                    index$iv++;
                }
            }
        }

        @Override // java.lang.Appendable
        public final void append(androidx.compose.ui.text.AnnotatedString text, int start, int end) {
            Object obj2;
            String text2;
            int index$iv;
            int size;
            Object obj;
            Object obj3;
            int i3;
            Object annotations;
            int mutableRange;
            int item;
            int i;
            int i2;
            obj2 = this;
            int length = obj2.text.length();
            obj2.text.append((CharSequence)text.getText(), start, end);
            List list = AnnotatedStringKt.access$getLocalSpanStyles(text, start, end);
            if (list != null) {
                text2 = 0;
                index$iv = 0;
                while (index$iv < list.size()) {
                    obj3 = obj;
                    i3 = 0;
                    obj2.addStyle((SpanStyle)(AnnotatedString.Range)obj3.getItem(), start2 += length, end2 += length);
                    index$iv++;
                }
            }
            List list2 = AnnotatedStringKt.access$getLocalParagraphStyles(text, start, end);
            if (list2 != null) {
                text2 = 0;
                index$iv = 0;
                while (index$iv < list2.size()) {
                    obj3 = obj;
                    i3 = 0;
                    obj2.addStyle((ParagraphStyle)(AnnotatedString.Range)obj3.getItem(), start3 += length, end3 += length);
                    index$iv++;
                }
            }
            List list3 = AnnotatedStringKt.access$getLocalAnnotations(text, start, end);
            if (list3 != null) {
                text2 = 0;
                index$iv = 0;
                while (index$iv < list3.size()) {
                    obj3 = obj;
                    i3 = 0;
                    mutableRange = new AnnotatedString.Builder.MutableRange((AnnotatedString.Range)obj3.getItem(), start4 += length, end4 += length, obj3.getTag());
                    obj2.annotations.add(mutableRange);
                    index$iv++;
                    obj2 = this;
                }
            }
        }

        @Override // java.lang.Appendable
        public final void append(String text) {
            this.text.append(text);
        }

        @Override // java.lang.Appendable
        public final int getLength() {
            return this.text.length();
        }

        @Override // java.lang.Appendable
        public final void pop() {
            if ((Collection)this.styleStack.isEmpty()) {
            } else {
                (AnnotatedString.Builder.MutableRange)this.styleStack.remove(size--).setEnd(this.text.length());
            }
            int item = 0;
            IllegalStateException $i$a$CheckAnnotatedString$Builder$pop$1 = new IllegalStateException("Nothing to pop.".toString());
            throw $i$a$CheckAnnotatedString$Builder$pop$1;
        }

        @Override // java.lang.Appendable
        public final void pop(int index) {
            int i;
            int i3 = 1;
            i = index < this.styleStack.size() ? i3 : 0;
            if (i == 0) {
            }
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append(index).append(" should be less than ").append(this.styleStack.size()).toString().toString());
            throw illegalStateException;
        }

        @Override // java.lang.Appendable
        public final int pushLink(androidx.compose.ui.text.LinkAnnotation link) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(link, this.text.length(), 0, 0, 12, 0);
            int obj8 = 0;
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return obj8--;
        }

        @Override // java.lang.Appendable
        public final int pushStringAnnotation(String tag, String annotation) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(annotation, this.text.length(), 0, tag, 4, 0);
            int obj8 = 0;
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return obj8--;
        }

        @Override // java.lang.Appendable
        public final int pushStyle(androidx.compose.ui.text.ParagraphStyle style) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(style, this.text.length(), 0, 0, 12, 0);
            int obj8 = 0;
            this.styleStack.add(mutableRange);
            this.paragraphStyles.add(mutableRange);
            return obj8--;
        }

        @Override // java.lang.Appendable
        public final int pushStyle(androidx.compose.ui.text.SpanStyle style) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(style, this.text.length(), 0, 0, 12, 0);
            int obj8 = 0;
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return obj8--;
        }

        @Override // java.lang.Appendable
        public final int pushTtsAnnotation(androidx.compose.ui.text.TtsAnnotation ttsAnnotation) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(ttsAnnotation, this.text.length(), 0, 0, 12, 0);
            int obj8 = 0;
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return obj8--;
        }

        @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(...))
        public final int pushUrlAnnotation(androidx.compose.ui.text.UrlAnnotation urlAnnotation) {
            AnnotatedString.Builder.MutableRange mutableRange = new AnnotatedString.Builder.MutableRange(urlAnnotation, this.text.length(), 0, 0, 12, 0);
            int obj8 = 0;
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return obj8--;
        }

        @Override // java.lang.Appendable
        public final androidx.compose.ui.text.AnnotatedString toAnnotatedString() {
            ArrayList $this$fastMap$iv2;
            ArrayList $this$fastMap$iv;
            ArrayList arrayList;
            List annotations;
            ArrayList $i$a$IfEmptyAnnotatedString$Builder$toAnnotatedString$6;
            int index$iv$iv2;
            Object obj2;
            int index$iv$iv3;
            int index$iv$iv;
            Object obj;
            int i3;
            ArrayList list2;
            androidx.compose.ui.text.AnnotatedString.Range it;
            int i2;
            int length;
            int i;
            List list;
            final Object obj3 = this;
            List spanStyles = obj3.spanStyles;
            int i5 = 0;
            arrayList = new ArrayList(spanStyles.size());
            List list3 = spanStyles;
            int i10 = 0;
            index$iv$iv2 = 0;
            while (index$iv$iv2 < list3.size()) {
                i3 = 0;
                i2 = 0;
                (Collection)arrayList.add((AnnotatedString.Builder.MutableRange)list3.get(index$iv$iv2).toRange(obj3.text.length()));
                index$iv$iv2++;
            }
            if ((Collection)(List)arrayList.isEmpty()) {
                int i4 = 0;
                $this$fastMap$iv2 = 0;
            }
            List paragraphStyles = obj3.paragraphStyles;
            int i8 = 0;
            ArrayList arrayList2 = new ArrayList(paragraphStyles.size());
            List list4 = paragraphStyles;
            int i11 = 0;
            index$iv$iv3 = 0;
            while (index$iv$iv3 < list4.size()) {
                it = 0;
                i = 0;
                (Collection)arrayList2.add((AnnotatedString.Builder.MutableRange)list4.get(index$iv$iv3).toRange(obj3.text.length()));
                index$iv$iv3++;
            }
            if ((Collection)(List)arrayList2.isEmpty()) {
                int i6 = 0;
                $this$fastMap$iv = 0;
            }
            annotations = obj3.annotations;
            int i9 = 0;
            ArrayList arrayList3 = new ArrayList(annotations.size());
            List list5 = annotations;
            int i12 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list5.size()) {
                it = 0;
                i = 0;
                (Collection)arrayList3.add((AnnotatedString.Builder.MutableRange)list5.get(index$iv$iv).toRange(obj3.text.length()));
                index$iv$iv++;
                annotations = list;
            }
            List $this$fastMap$iv4 = annotations;
            if ((Collection)(List)arrayList3.isEmpty()) {
                int i7 = 0;
                $i$a$IfEmptyAnnotatedString$Builder$toAnnotatedString$6 = 0;
            }
            AnnotatedString annotatedString = new AnnotatedString(obj3.text.toString(), (List)$this$fastMap$iv2, (List)$this$fastMap$iv, (List)$i$a$IfEmptyAnnotatedString$Builder$toAnnotatedString$6);
            return annotatedString;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/text/AnnotatedString$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.ui.text.AnnotatedString, ?> getSaver() {
            return AnnotatedString.access$getSaver$cp();
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u001f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B%\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J<\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00028\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001e", d2 = {"Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "", "item", "start", "", "end", "(Ljava/lang/Object;II)V", "tag", "", "(Ljava/lang/Object;IILjava/lang/String;)V", "getEnd", "()I", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "equals", "", "other", "hashCode", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Range {

        public static final int $stable;
        private final int end;
        private final T item;
        private final int start;
        private final String tag;
        static {
        }

        public Range(T item, int start, int end) {
            super(item, start, end, "");
        }

        public Range(T item, int start, int end, String tag) {
            int i;
            super();
            this.item = item;
            this.start = start;
            this.end = end;
            this.tag = tag;
            i = this.start <= this.end ? 1 : 0;
            if (i == 0) {
            } else {
            }
            int i2 = 0;
            IllegalArgumentException $i$a$RequireAnnotatedString$Range$1 = new IllegalArgumentException("Reversed range is not supported".toString());
            throw $i$a$RequireAnnotatedString$Range$1;
        }

        public static androidx.compose.ui.text.AnnotatedString.Range copy$default(androidx.compose.ui.text.AnnotatedString.Range annotatedString$Range, Object object2, int i3, int i4, String string5, int i6, Object object7) {
            Object obj1;
            int obj2;
            int obj3;
            String obj4;
            if (i6 & 1 != 0) {
                obj1 = range.item;
            }
            if (i6 & 2 != 0) {
                obj2 = range.start;
            }
            if (i6 & 4 != 0) {
                obj3 = range.end;
            }
            if (i6 &= 8 != 0) {
                obj4 = range.tag;
            }
            return range.copy(obj1, obj2, obj3, obj4);
        }

        public final T component1() {
            return this.item;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        public final String component4() {
            return this.tag;
        }

        public final androidx.compose.ui.text.AnnotatedString.Range<T> copy(T t, int i2, int i3, String string4) {
            AnnotatedString.Range range = new AnnotatedString.Range(t, i2, i3, string4);
            return range;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof AnnotatedString.Range) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.item, obj.item)) {
                return i2;
            }
            if (this.start != obj.start) {
                return i2;
            }
            if (this.end != obj.end) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.tag, obj.tag)) {
                return i2;
            }
            return i;
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            int i;
            if (this.item == null) {
                i = 0;
            } else {
                i = this.item.hashCode();
            }
            return i6 += i10;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Range(item=").append(this.item).append(", start=").append(this.start).append(", end=").append(this.end).append(", tag=").append(this.tag).append(')').toString();
        }
    }
    static {
        AnnotatedString.Companion companion = new AnnotatedString.Companion(0);
        AnnotatedString.Companion = companion;
        AnnotatedString.Saver = SaversKt.getAnnotatedStringSaver();
    }

    public AnnotatedString(String text, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStyles, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>> paragraphStyles) {
        int $i$a$IfEmptyAnnotatedString$1;
        int $i$a$IfEmptyAnnotatedString$2;
        final int i3 = 0;
        if ((Collection)spanStyles.isEmpty()) {
            int i = 0;
            $i$a$IfEmptyAnnotatedString$1 = i3;
        }
        if ((Collection)paragraphStyles.isEmpty()) {
            int i2 = 0;
            $i$a$IfEmptyAnnotatedString$2 = i3;
        }
        super(text, (List)$i$a$IfEmptyAnnotatedString$1, (List)$i$a$IfEmptyAnnotatedString$2, i3);
    }

    public AnnotatedString(String string, List list2, List list3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        List obj2;
        List obj3;
        if (i4 & 2 != 0) {
            obj2 = CollectionsKt.emptyList();
        }
        if (i4 &= 4 != 0) {
            obj3 = CollectionsKt.emptyList();
        }
        super(string, obj2, obj3);
    }

    public AnnotatedString(String text, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> spanStylesOrNull, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>> paragraphStylesOrNull, List<? extends androidx.compose.ui.text.AnnotatedString.Range<? extends Object>> annotations) {
        int lastStyleEnd;
        List $this$sortedBy$iv;
        int i;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i2;
        int end;
        int i5;
        int i3;
        int i4;
        final Object obj3 = this;
        super();
        obj3.text = text;
        obj3.spanStylesOrNull = spanStylesOrNull;
        obj3.paragraphStylesOrNull = paragraphStylesOrNull;
        obj3.annotations = annotations;
        int i6 = 0;
        lastStyleEnd = -1;
        $this$sortedBy$iv = obj3.paragraphStylesOrNull;
        i = 0;
        index$iv = new AnnotatedString.special$$inlined.sortedBy.1();
        $this$sortedBy$iv = CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)index$iv);
        if ($this$sortedBy$iv != null && $this$sortedBy$iv != null) {
            i = 0;
            index$iv = new AnnotatedString.special$$inlined.sortedBy.1();
            $this$sortedBy$iv = CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)index$iv);
            if ($this$sortedBy$iv != null) {
                i = 0;
                index$iv = 0;
                while (index$iv < $this$sortedBy$iv.size()) {
                    obj2 = obj;
                    i2 = 0;
                    i4 = 1;
                    if ((AnnotatedString.Range)obj2.getStart() >= lastStyleEnd) {
                    } else {
                    }
                    i5 = 0;
                    if (obj2.getEnd() <= obj3.text.length()) {
                    } else {
                    }
                    i3 = 0;
                    lastStyleEnd = obj2.getEnd();
                    index$iv++;
                    i3 = i4;
                    i5 = i4;
                }
            }
        }
    }

    public AnnotatedString(String string, List list2, List list3, List list4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(string, obj3, obj4, obj5);
    }

    public static final Saver access$getSaver$cp() {
        return AnnotatedString.Saver;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int index) {
        return get(index);
    }

    @Override // java.lang.CharSequence
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other instanceof AnnotatedString == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.text, obj.text)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.spanStylesOrNull, obj2.spanStylesOrNull)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.paragraphStylesOrNull, obj3.paragraphStylesOrNull)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.annotations, obj4.annotations)) {
            return i2;
        }
        return i;
    }

    @Override // java.lang.CharSequence
    public char get(int index) {
        return this.text.charAt(index);
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<? extends Object>> getAnnotations$ui_text_release() {
        return this.annotations;
    }

    @Override // java.lang.CharSequence
    public int getLength() {
        return this.text.length();
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>> getLinkAnnotations(int start, int end) {
        int i3;
        Object obj2;
        int i9;
        Object $this$fastFilter$iv;
        int i5;
        ArrayList arrayList;
        List list;
        int i;
        int index$iv$iv;
        int size;
        Object obj3;
        Object obj4;
        int i2;
        Object obj;
        int i4;
        int i7;
        boolean intersect;
        int end2;
        int i6;
        int i8;
        List annotations = obj2.annotations;
        if (annotations != null) {
            i5 = 0;
            arrayList = new ArrayList(annotations.size());
            list = annotations;
            i = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                obj4 = obj3;
                i2 = 0;
                obj = obj4;
                i4 = 0;
                if (item instanceof LinkAnnotation) {
                } else {
                }
                i8 = start;
                i9 = end;
                i7 = 0;
                if (i7 != 0) {
                }
                index$iv$iv++;
                obj2 = this;
                (Collection)arrayList.add(obj4);
                if (AnnotatedStringKt.intersect(start, end, obj.getStart(), obj.getEnd())) {
                } else {
                }
                i7 = 1;
            }
            i6 = start;
            i3 = end;
            $this$fastFilter$iv = arrayList;
        } else {
            i6 = start;
            i3 = end;
            $this$fastFilter$iv = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull($this$fastFilter$iv, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return $this$fastFilter$iv;
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>> getParagraphStyles() {
        List paragraphStylesOrNull;
        if (this.paragraphStylesOrNull == null) {
            paragraphStylesOrNull = CollectionsKt.emptyList();
        }
        return paragraphStylesOrNull;
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>> getParagraphStylesOrNull$ui_text_release() {
        return this.paragraphStylesOrNull;
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> getSpanStyles() {
        List spanStylesOrNull;
        if (this.spanStylesOrNull == null) {
            spanStylesOrNull = CollectionsKt.emptyList();
        }
        return spanStylesOrNull;
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>> getSpanStylesOrNull$ui_text_release() {
        return this.spanStylesOrNull;
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<String>> getStringAnnotations(int start, int end) {
        int i9;
        Object obj4;
        int i2;
        Object $this$fastFilter$iv;
        int i3;
        ArrayList arrayList;
        List list;
        int i8;
        int index$iv$iv;
        int size;
        Object obj3;
        Object obj;
        int i5;
        Object obj2;
        int i4;
        int i;
        boolean intersect;
        int end2;
        int i6;
        int i7;
        List annotations = obj4.annotations;
        if (annotations != null) {
            i3 = 0;
            arrayList = new ArrayList(annotations.size());
            list = annotations;
            i8 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                obj = obj3;
                i5 = 0;
                obj2 = obj;
                i4 = 0;
                if (item instanceof String != null) {
                } else {
                }
                i7 = start;
                i2 = end;
                i = 0;
                if (i != 0) {
                }
                index$iv$iv++;
                obj4 = this;
                (Collection)arrayList.add(obj);
                if (AnnotatedStringKt.intersect(start, end, obj2.getStart(), obj2.getEnd())) {
                } else {
                }
                i = 1;
            }
            i6 = start;
            i9 = end;
            $this$fastFilter$iv = arrayList;
        } else {
            i6 = start;
            i9 = end;
            $this$fastFilter$iv = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull($this$fastFilter$iv, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>");
        return $this$fastFilter$iv;
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<String>> getStringAnnotations(String tag, int start, int end) {
        Object obj2;
        int i3;
        int i6;
        List annotations;
        int $this$fastFilter$iv2;
        int $this$fastFilter$iv;
        Object $i$f$fastFilter;
        ArrayList arrayList;
        List list2;
        int i4;
        int index$iv$iv;
        int size;
        Object obj;
        Object obj6;
        int i2;
        Object obj3;
        int i5;
        int i;
        boolean intersect;
        Object obj4;
        Object obj5;
        int end2;
        List list;
        annotations = obj2.annotations;
        if (annotations != null) {
            int i7 = 0;
            arrayList = new ArrayList(annotations.size());
            list2 = annotations;
            i4 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list2.size()) {
                obj6 = obj;
                i2 = 0;
                obj3 = obj6;
                i5 = 0;
                if (item instanceof String != null) {
                } else {
                }
                obj4 = tag;
                i3 = start;
                list = annotations;
                $this$fastFilter$iv2 = end;
                i = 0;
                if (i != 0) {
                }
                index$iv$iv++;
                obj2 = this;
                annotations = list;
                (Collection)arrayList.add(obj6);
                if (Intrinsics.areEqual(tag, obj3.getTag())) {
                } else {
                }
                list = annotations;
                if (AnnotatedStringKt.intersect(start, end, obj3.getStart(), obj3.getEnd())) {
                } else {
                }
                i = 1;
            }
            obj5 = tag;
            i6 = start;
            list = annotations;
            $this$fastFilter$iv = end;
            $i$f$fastFilter = arrayList;
        } else {
            obj5 = tag;
            i6 = start;
            $this$fastFilter$iv = end;
            $i$f$fastFilter = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull($i$f$fastFilter, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<kotlin.String>>");
        return $i$f$fastFilter;
    }

    @Override // java.lang.CharSequence
    public final String getText() {
        return this.text;
    }

    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>> getTtsAnnotations(int start, int end) {
        int i5;
        Object obj2;
        int i9;
        Object $this$fastFilter$iv;
        int i2;
        ArrayList arrayList;
        List list;
        int i4;
        int index$iv$iv;
        int size;
        Object obj;
        Object obj3;
        int i;
        Object obj4;
        int i3;
        int i6;
        boolean intersect;
        int end2;
        int i7;
        int i8;
        List annotations = obj2.annotations;
        if (annotations != null) {
            i2 = 0;
            arrayList = new ArrayList(annotations.size());
            list = annotations;
            i4 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                obj3 = obj;
                i = 0;
                obj4 = obj3;
                i3 = 0;
                if (item instanceof TtsAnnotation) {
                } else {
                }
                i8 = start;
                i9 = end;
                i6 = 0;
                if (i6 != 0) {
                }
                index$iv$iv++;
                obj2 = this;
                (Collection)arrayList.add(obj3);
                if (AnnotatedStringKt.intersect(start, end, obj4.getStart(), obj4.getEnd())) {
                } else {
                }
                i6 = 1;
            }
            i7 = start;
            i5 = end;
            $this$fastFilter$iv = arrayList;
        } else {
            i7 = start;
            i5 = end;
            $this$fastFilter$iv = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull($this$fastFilter$iv, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return $this$fastFilter$iv;
    }

    @Deprecated(message = "Use LinkAnnotation API instead", replaceWith = @ReplaceWith(...))
    public final List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>> getUrlAnnotations(int start, int end) {
        int i2;
        Object obj2;
        int i;
        Object $this$fastFilter$iv;
        int i5;
        ArrayList arrayList;
        List list;
        int i7;
        int index$iv$iv;
        int size;
        Object obj;
        Object obj3;
        int i3;
        Object obj4;
        int i8;
        int i4;
        boolean intersect;
        int end2;
        int i9;
        int i6;
        List annotations = obj2.annotations;
        if (annotations != null) {
            i5 = 0;
            arrayList = new ArrayList(annotations.size());
            list = annotations;
            i7 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                obj3 = obj;
                i3 = 0;
                obj4 = obj3;
                i8 = 0;
                if (item instanceof UrlAnnotation) {
                } else {
                }
                i6 = start;
                i = end;
                i4 = 0;
                if (i4 != 0) {
                }
                index$iv$iv++;
                obj2 = this;
                (Collection)arrayList.add(obj3);
                if (AnnotatedStringKt.intersect(start, end, obj4.getStart(), obj4.getEnd())) {
                } else {
                }
                i4 = 1;
            }
            i9 = start;
            i2 = end;
            $this$fastFilter$iv = arrayList;
        } else {
            i9 = start;
            i2 = end;
            $this$fastFilter$iv = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull($this$fastFilter$iv, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return $this$fastFilter$iv;
    }

    @Override // java.lang.CharSequence
    public final boolean hasEqualAnnotations(androidx.compose.ui.text.AnnotatedString other) {
        return Intrinsics.areEqual(this.annotations, other.annotations);
    }

    @Override // java.lang.CharSequence
    public final boolean hasLinkAnnotations(int start, int end) {
        int i4;
        int i;
        List list;
        int i6;
        int index$iv$iv;
        int size;
        Object obj;
        Object obj2;
        int i3;
        int it;
        int i7;
        boolean intersect;
        int i2;
        int end2;
        int i5;
        final List annotations = obj3.annotations;
        if (annotations != null) {
            i = 0;
            list = annotations;
            i6 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                i3 = 0;
                Object obj4 = obj2;
                i7 = 0;
                if (item instanceof LinkAnnotation) {
                } else {
                }
                i4 = start;
                i2 = end;
                it = 0;
                index$iv$iv++;
                if (AnnotatedStringKt.intersect(start, end, obj4.getStart(), obj4.getEnd())) {
                } else {
                }
                it = 1;
            }
            i4 = start;
            i2 = end;
            i5 = 0;
        } else {
            i4 = start;
            i2 = end;
            i5 = 0;
        }
        return i5;
    }

    @Override // java.lang.CharSequence
    public final boolean hasStringAnnotations(String tag, int start, int end) {
        Object obj3;
        int i6;
        boolean intersect;
        int i2;
        int i7;
        List list;
        int i4;
        int index$iv$iv;
        int size;
        Object obj;
        Object obj2;
        int i3;
        Object obj4;
        int i;
        int equal;
        int i5;
        Object obj5;
        final List annotations = obj3.annotations;
        if (annotations != null) {
            i7 = 0;
            list = annotations;
            i4 = 0;
            index$iv$iv = 0;
            while (index$iv$iv < list.size()) {
                i3 = 0;
                obj4 = obj2;
                i = 0;
                if (item instanceof String != null) {
                } else {
                }
                obj5 = tag;
                i5 = start;
                i6 = end;
                intersect = 0;
                index$iv$iv++;
                obj3 = this;
                if (Intrinsics.areEqual(tag, obj4.getTag())) {
                } else {
                }
                if (AnnotatedStringKt.intersect(start, end, obj4.getStart(), obj4.getEnd())) {
                } else {
                }
                intersect = 1;
            }
            obj5 = tag;
            i5 = start;
            i6 = end;
            i2 = 0;
        } else {
            obj5 = tag;
            i5 = start;
            i6 = end;
            i2 = 0;
        }
        return i2;
    }

    @Override // java.lang.CharSequence
    public int hashCode() {
        int i;
        int i2;
        int i3;
        List spanStylesOrNull = this.spanStylesOrNull;
        i3 = 0;
        if (spanStylesOrNull != null) {
            i = spanStylesOrNull.hashCode();
        } else {
            i = i3;
        }
        List paragraphStylesOrNull = this.paragraphStylesOrNull;
        if (paragraphStylesOrNull != null) {
            i2 = paragraphStylesOrNull.hashCode();
        } else {
            i2 = i3;
        }
        List annotations = this.annotations;
        if (annotations != null) {
            i3 = annotations.hashCode();
        }
        return result2 += i3;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return getLength();
    }

    @Override // java.lang.CharSequence
    public final androidx.compose.ui.text.AnnotatedString plus(androidx.compose.ui.text.AnnotatedString other) {
        AnnotatedString.Builder builder = new AnnotatedString.Builder(this);
        final int i = 0;
        builder.append(other);
        return builder.toAnnotatedString();
    }

    @Override // java.lang.CharSequence
    public androidx.compose.ui.text.AnnotatedString subSequence(int startIndex, int endIndex) {
        int length;
        length = startIndex <= endIndex ? 1 : 0;
        if (length == 0) {
        } else {
            if (startIndex == 0 && endIndex == this.text.length()) {
                if (endIndex == this.text.length()) {
                    return this;
                }
            }
            String substring = this.text.substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            AnnotatedString annotatedString = new AnnotatedString(substring, AnnotatedStringKt.access$filterRanges(this.spanStylesOrNull, startIndex, endIndex), AnnotatedStringKt.access$filterRanges(this.paragraphStylesOrNull, startIndex, endIndex), AnnotatedStringKt.access$filterRanges(this.annotations, startIndex, endIndex));
            return annotatedString;
        }
        int text = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("start (").append(startIndex).append(") should be less or equal to end (").append(endIndex).append(')').toString().toString());
        throw illegalArgumentException;
    }

    @Override // java.lang.CharSequence
    public java.lang.CharSequence subSequence(int startIndex, int endIndex) {
        return (CharSequence)subSequence(startIndex, endIndex);
    }

    @Override // java.lang.CharSequence
    public final androidx.compose.ui.text.AnnotatedString subSequence-5zc-tL8(long range) {
        return subSequence(TextRange.getMin-impl(range), TextRange.getMax-impl(range));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text;
    }
}
