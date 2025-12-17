package androidx.compose.ui.platform;

import android.content.ClipData;
import android.content.ClipDescription;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0016\n\u0002\u0010\u000e\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010(H\u0000\u001a\u000c\u0010)\u001a\u00020(*\u00020'H\u0000\u001a\n\u0010*\u001a\u00020+*\u00020,\u001a\n\u0010-\u001a\u00020.*\u00020/\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u001bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*\n\u00100\"\u0002012\u000201¨\u00062", d2 = {"BACKGROUND_ID", "", "BASELINE_SHIFT_ID", "BASELINE_SHIFT_SIZE", "", "BYTE_SIZE", "COLOR_ID", "COLOR_SIZE", "FLOAT_SIZE", "FONT_FEATURE_SETTINGS_ID", "FONT_SIZE_ID", "FONT_STYLE_ID", "FONT_STYLE_ITALIC", "FONT_STYLE_NORMAL", "FONT_STYLE_SIZE", "FONT_SYNTHESIS_ALL", "FONT_SYNTHESIS_ID", "FONT_SYNTHESIS_NONE", "FONT_SYNTHESIS_SIZE", "FONT_SYNTHESIS_STYLE", "FONT_SYNTHESIS_WEIGHT", "FONT_WEIGHT_ID", "FONT_WEIGHT_SIZE", "INT_SIZE", "LETTER_SPACING_ID", "LONG_SIZE", "PLAIN_TEXT_LABEL", "", "SHADOW_ID", "SHADOW_SIZE", "TEXT_DECORATION_ID", "TEXT_DECORATION_SIZE", "TEXT_GEOMETRIC_TRANSFORM_ID", "TEXT_GEOMETRIC_TRANSFORM_SIZE", "TEXT_UNIT_SIZE", "UNIT_TYPE_EM", "UNIT_TYPE_SP", "UNIT_TYPE_UNSPECIFIED", "convertToAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "", "convertToCharSequence", "toClipEntry", "Landroidx/compose/ui/platform/ClipEntry;", "Landroid/content/ClipData;", "toClipMetadata", "Landroidx/compose/ui/platform/ClipMetadata;", "Landroid/content/ClipDescription;", "NativeClipboard", "Landroid/content/ClipboardManager;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidClipboardManager_androidKt {

    private static final byte BACKGROUND_ID = (byte) 10;
    private static final byte BASELINE_SHIFT_ID = (byte) 8;
    private static final int BASELINE_SHIFT_SIZE = 4;
    private static final int BYTE_SIZE = 1;
    private static final byte COLOR_ID = (byte) 1;
    private static final int COLOR_SIZE = 8;
    private static final int FLOAT_SIZE = 4;
    private static final byte FONT_FEATURE_SETTINGS_ID = (byte) 6;
    private static final byte FONT_SIZE_ID = (byte) 2;
    private static final byte FONT_STYLE_ID = (byte) 4;
    private static final byte FONT_STYLE_ITALIC = (byte) 1;
    private static final byte FONT_STYLE_NORMAL = (byte) 0;
    private static final int FONT_STYLE_SIZE = 1;
    private static final byte FONT_SYNTHESIS_ALL = (byte) 1;
    private static final byte FONT_SYNTHESIS_ID = (byte) 5;
    private static final byte FONT_SYNTHESIS_NONE = (byte) 0;
    private static final int FONT_SYNTHESIS_SIZE = 1;
    private static final byte FONT_SYNTHESIS_STYLE = (byte) 3;
    private static final byte FONT_SYNTHESIS_WEIGHT = (byte) 2;
    private static final byte FONT_WEIGHT_ID = (byte) 3;
    private static final int FONT_WEIGHT_SIZE = 4;
    private static final int INT_SIZE = 4;
    private static final byte LETTER_SPACING_ID = (byte) 7;
    private static final int LONG_SIZE = 8;
    private static final String PLAIN_TEXT_LABEL = "plain text";
    private static final byte SHADOW_ID = (byte) 12;
    private static final int SHADOW_SIZE = 20;
    private static final byte TEXT_DECORATION_ID = (byte) 11;
    private static final int TEXT_DECORATION_SIZE = 4;
    private static final byte TEXT_GEOMETRIC_TRANSFORM_ID = (byte) 9;
    private static final int TEXT_GEOMETRIC_TRANSFORM_SIZE = 8;
    private static final int TEXT_UNIT_SIZE = 5;
    private static final byte UNIT_TYPE_EM = (byte) 2;
    private static final byte UNIT_TYPE_SP = (byte) 1;
    private static final byte UNIT_TYPE_UNSPECIFIED;
    public static final AnnotatedString convertToAnnotatedString(java.lang.CharSequence $this$convertToAnnotatedString) {
        int i;
        int i2;
        int spanStart;
        int spanEnd;
        androidx.compose.ui.platform.DecodeHelper decodeHelper;
        androidx.compose.ui.text.SpanStyle decodeSpanStyle;
        AnnotatedString.Range range;
        if ($this$convertToAnnotatedString == null) {
            return null;
        }
        if (!$this$convertToAnnotatedString instanceof Spanned) {
            AnnotatedString annotatedString = new AnnotatedString($this$convertToAnnotatedString.toString(), 0, 0, 6, 0);
            return annotatedString;
        }
        Object[] spans = (Spanned)$this$convertToAnnotatedString.getSpans(0, $this$convertToAnnotatedString.length(), Annotation.class);
        ArrayList arrayList = new ArrayList();
        ArrayList list = arrayList;
        int lastIndex = ArraysKt.getLastIndex((Annotation[])spans);
        if (0 <= lastIndex) {
        }
        AnnotatedString annotatedString2 = new AnnotatedString($this$convertToAnnotatedString.toString(), (List)list, 0, 4, 0);
        return annotatedString2;
    }

    public static final java.lang.CharSequence convertToCharSequence(AnnotatedString $this$convertToCharSequence) {
        int index$iv;
        Object obj;
        int component3;
        int i;
        Object component1;
        int component2;
        Annotation annotation;
        int i2;
        String encodedString;
        if ($this$convertToCharSequence.getSpanStyles().isEmpty()) {
            return (CharSequence)$this$convertToCharSequence.getText();
        }
        SpannableString spannableString = new SpannableString((CharSequence)$this$convertToCharSequence.getText());
        EncodeHelper encodeHelper = new EncodeHelper();
        List spanStyles2 = $this$convertToCharSequence.getSpanStyles();
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < spanStyles2.size()) {
            Object obj2 = obj;
            i = 0;
            androidx.compose.ui.platform.EncodeHelper encodeHelper2 = encodeHelper;
            int i4 = 0;
            encodeHelper2.reset();
            encodeHelper2.encode((SpanStyle)(AnnotatedString.Range)obj2.component1());
            annotation = new Annotation("androidx.compose.text.SpanStyle", encodeHelper.encodedString());
            spannableString.setSpan(annotation, obj2.component2(), obj2.component3(), 33);
            index$iv++;
        }
        return (CharSequence)spannableString;
    }

    public static final androidx.compose.ui.platform.ClipEntry toClipEntry(ClipData $this$toClipEntry) {
        ClipEntry clipEntry = new ClipEntry($this$toClipEntry);
        return clipEntry;
    }

    public static final androidx.compose.ui.platform.ClipMetadata toClipMetadata(ClipDescription $this$toClipMetadata) {
        ClipMetadata clipMetadata = new ClipMetadata($this$toClipMetadata);
        return clipMetadata;
    }
}
