package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0008\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Landroidx/compose/material3/DateVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "(Landroidx/compose/material3/internal/DateInputFormat;)V", "dateFormatLength", "", "dateOffsetTranslator", "androidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1", "Landroidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1;", "firstDelimiterOffset", "secondDelimiterOffset", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DateVisualTransformation implements VisualTransformation {

    private final int dateFormatLength;
    private final DateInputFormat dateInputFormat;
    private final androidx.compose.material3.DateVisualTransformation.dateOffsetTranslator.1 dateOffsetTranslator;
    private final int firstDelimiterOffset;
    private final int secondDelimiterOffset;
    public DateVisualTransformation(DateInputFormat dateInputFormat) {
        super();
        this.dateInputFormat = dateInputFormat;
        final int i3 = 6;
        final int i4 = 0;
        final int i = 0;
        final int i2 = 0;
        this.firstDelimiterOffset = StringsKt.indexOf$default((CharSequence)this.dateInputFormat.getPatternWithDelimiters(), this.dateInputFormat.getDelimiter(), i, i2, i3, i4);
        this.secondDelimiterOffset = StringsKt.lastIndexOf$default((CharSequence)this.dateInputFormat.getPatternWithDelimiters(), this.dateInputFormat.getDelimiter(), i, i2, i3, i4);
        this.dateFormatLength = this.dateInputFormat.getPatternWithoutDelimiters().length();
        DateVisualTransformation.dateOffsetTranslator.1 anon = new DateVisualTransformation.dateOffsetTranslator.1(this);
        this.dateOffsetTranslator = anon;
    }

    public static final int access$getDateFormatLength$p(androidx.compose.material3.DateVisualTransformation $this) {
        return $this.dateFormatLength;
    }

    public static final int access$getFirstDelimiterOffset$p(androidx.compose.material3.DateVisualTransformation $this) {
        return $this.firstDelimiterOffset;
    }

    public static final int access$getSecondDelimiterOffset$p(androidx.compose.material3.DateVisualTransformation $this) {
        return $this.secondDelimiterOffset;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString text) {
        String substring;
        int dateFormatLength;
        String transformedText;
        int i;
        int i3;
        int i2;
        String transformedText2;
        String str;
        int i4;
        StringBuilder append;
        char firstDelimiterOffset;
        if (text.getText().length() > this.dateFormatLength) {
            substring = StringsKt.substring(text.getText(), RangesKt.until(0, this.dateFormatLength));
        } else {
            substring = text.getText();
        }
        int i5 = 0;
        final String str2 = substring;
        final int i6 = 0;
        i3 = 0;
        transformedText2 = transformedText;
        while (i < (CharSequence)str2.length()) {
            i4 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            if (i3 + 1 != this.firstDelimiterOffset) {
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            transformedText2 = stringBuilder2.append(stringBuilder.append(transformedText2).append(str2.charAt(i)).toString()).append(this.dateInputFormat.getDelimiter()).toString();
            i++;
            i3 = i2;
            if (i3 + 2 == this.secondDelimiterOffset) {
            }
        }
        AnnotatedString annotatedString = new AnnotatedString(transformedText2, 0, 0, 6, 0);
        TransformedText transformedText3 = new TransformedText(annotatedString, (OffsetMapping)this.dateOffsetTranslator);
        return transformedText3;
    }
}
