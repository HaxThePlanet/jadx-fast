package androidx.compose.material3;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008Q\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001BÝ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003¢\u0006\u0002\u0010/J-\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008c\u0010dJÀ\u0003\u0010e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00032\u0008\u0008\u0002\u0010 \u001a\u00020\u00032\u0008\u0008\u0002\u0010!\u001a\u00020\u00032\u0008\u0008\u0002\u0010\"\u001a\u00020\u00032\u0008\u0008\u0002\u0010#\u001a\u00020\u00032\u0008\u0008\u0002\u0010$\u001a\u00020\u00032\u0008\u0008\u0002\u0010%\u001a\u00020\u00032\u0008\u0008\u0002\u0010&\u001a\u00020\u00032\u0008\u0008\u0002\u0010'\u001a\u00020\u00032\u0008\u0008\u0002\u0010(\u001a\u00020\u00032\u0008\u0008\u0002\u0010)\u001a\u00020\u00032\u0008\u0008\u0002\u0010*\u001a\u00020\u00032\u0008\u0008\u0002\u0010+\u001a\u00020\u00032\u0008\u0008\u0002\u0010,\u001a\u00020\u00032\u0008\u0008\u0002\u0010-\u001a\u00020\u00032\u0008\u0008\u0002\u0010.\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\u0008f\u0010gJ\u001d\u0010\u000b\u001a\u00020\u00032\u0006\u0010a\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008h\u0010iJ\u0013\u0010j\u001a\u00020`2\u0008\u0010k\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010l\u001a\u00020mH\u0016J-\u0010n\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008o\u0010dJ-\u0010p\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008q\u0010dJ-\u0010r\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008s\u0010dJ-\u0010t\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008u\u0010dJ-\u0010v\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008w\u0010dJ-\u0010x\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008y\u0010dJ-\u0010z\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008{\u0010dJ-\u0010|\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008}\u0010dJ-\u0010~\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020`H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u007f\u0010dJ%\u0010\u0080\u0001\u001a\u00020\u000e*\u0004\u0018\u00010\u000e2\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u000e0\u0082\u0001H\u0000¢\u0006\u0003\u0008\u0083\u0001R\u0019\u0010\u000b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u00080\u00101R\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u00083\u00101R\u0019\u0010\u0011\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u00084\u00101R\u0019\u0010\u001d\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u00085\u00101R\u0019\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u00086\u00101R\u0019\u0010!\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u00087\u00101R\u0019\u0010)\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u00088\u00101R\u0019\u0010-\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u00089\u00101R\u0019\u0010%\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008:\u00101R\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008;\u00101R\u0019\u0010\u0019\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008<\u00101R\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008=\u00101R\u0019\u0010\u000c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008>\u00101R\u0019\u0010\u0012\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008?\u00101R\u0019\u0010\u001e\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008@\u00101R\u0019\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008A\u00101R\u0019\u0010\"\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008B\u00101R\u0019\u0010*\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008C\u00101R\u0019\u0010.\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008D\u00101R\u0019\u0010&\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008E\u00101R\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008F\u00101R\u0019\u0010\u001a\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008G\u00101R\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008H\u00101R\u0019\u0010\u000f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008I\u00101R\u0019\u0010\u001b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008J\u00101R\u0019\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008K\u00101R\u0019\u0010\u001f\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008L\u00101R\u0019\u0010'\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008M\u00101R\u0019\u0010+\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008N\u00101R\u0019\u0010#\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008O\u00101R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008P\u00101R\u0019\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008Q\u00101R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008R\u0010SR\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008T\u00101R\u0019\u0010\u0010\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008U\u00101R\u0019\u0010\u001c\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008V\u00101R\u0019\u0010\u0014\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008W\u00101R\u0019\u0010 \u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008X\u00101R\u0019\u0010(\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008Y\u00101R\u0019\u0010,\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008Z\u00101R\u0019\u0010$\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008[\u00101R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008\\\u00101R\u0019\u0010\u0018\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00102\u001a\u0004\u0008]\u00101\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0084\u0001", d2 = {"Landroidx/compose/material3/TextFieldColors;", "", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "textSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCursorColor-0d7_KjU", "()J", "J", "getDisabledContainerColor-0d7_KjU", "getDisabledIndicatorColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getDisabledPlaceholderColor-0d7_KjU", "getDisabledPrefixColor-0d7_KjU", "getDisabledSuffixColor-0d7_KjU", "getDisabledSupportingTextColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getErrorContainerColor-0d7_KjU", "getErrorCursorColor-0d7_KjU", "getErrorIndicatorColor-0d7_KjU", "getErrorLabelColor-0d7_KjU", "getErrorLeadingIconColor-0d7_KjU", "getErrorPlaceholderColor-0d7_KjU", "getErrorPrefixColor-0d7_KjU", "getErrorSuffixColor-0d7_KjU", "getErrorSupportingTextColor-0d7_KjU", "getErrorTextColor-0d7_KjU", "getErrorTrailingIconColor-0d7_KjU", "getFocusedContainerColor-0d7_KjU", "getFocusedIndicatorColor-0d7_KjU", "getFocusedLabelColor-0d7_KjU", "getFocusedLeadingIconColor-0d7_KjU", "getFocusedPlaceholderColor-0d7_KjU", "getFocusedPrefixColor-0d7_KjU", "getFocusedSuffixColor-0d7_KjU", "getFocusedSupportingTextColor-0d7_KjU", "getFocusedTextColor-0d7_KjU", "getFocusedTrailingIconColor-0d7_KjU", "getTextSelectionColors", "()Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getUnfocusedContainerColor-0d7_KjU", "getUnfocusedIndicatorColor-0d7_KjU", "getUnfocusedLabelColor-0d7_KjU", "getUnfocusedLeadingIconColor-0d7_KjU", "getUnfocusedPlaceholderColor-0d7_KjU", "getUnfocusedPrefixColor-0d7_KjU", "getUnfocusedSuffixColor-0d7_KjU", "getUnfocusedSupportingTextColor-0d7_KjU", "getUnfocusedTextColor-0d7_KjU", "getUnfocusedTrailingIconColor-0d7_KjU", "containerColor", "enabled", "", "isError", "focused", "containerColor-XeAY9LY$material3_release", "(ZZZ)J", "copy", "copy-ejIjP34", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/TextFieldColors;", "cursorColor-vNxB06k$material3_release", "(Z)J", "equals", "other", "hashCode", "", "indicatorColor", "indicatorColor-XeAY9LY$material3_release", "labelColor", "labelColor-XeAY9LY$material3_release", "leadingIconColor", "leadingIconColor-XeAY9LY$material3_release", "placeholderColor", "placeholderColor-XeAY9LY$material3_release", "prefixColor", "prefixColor-XeAY9LY$material3_release", "suffixColor", "suffixColor-XeAY9LY$material3_release", "supportingTextColor", "supportingTextColor-XeAY9LY$material3_release", "textColor", "textColor-XeAY9LY$material3_release", "trailingIconColor", "trailingIconColor-XeAY9LY$material3_release", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldColors {

    public static final int $stable;
    private final long cursorColor;
    private final long disabledContainerColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledPrefixColor;
    private final long disabledSuffixColor;
    private final long disabledSupportingTextColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorContainerColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorPlaceholderColor;
    private final long errorPrefixColor;
    private final long errorSuffixColor;
    private final long errorSupportingTextColor;
    private final long errorTextColor;
    private final long errorTrailingIconColor;
    private final long focusedContainerColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedLeadingIconColor;
    private final long focusedPlaceholderColor;
    private final long focusedPrefixColor;
    private final long focusedSuffixColor;
    private final long focusedSupportingTextColor;
    private final long focusedTextColor;
    private final long focusedTrailingIconColor;
    private final TextSelectionColors textSelectionColors;
    private final long unfocusedContainerColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private final long unfocusedLeadingIconColor;
    private final long unfocusedPlaceholderColor;
    private final long unfocusedPrefixColor;
    private final long unfocusedSuffixColor;
    private final long unfocusedSupportingTextColor;
    private final long unfocusedTextColor;
    private final long unfocusedTrailingIconColor;
    static {
    }

    private TextFieldColors(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, TextSelectionColors textSelectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor) {
        final Object obj = this;
        super();
        obj.focusedTextColor = focusedTextColor;
        obj.unfocusedTextColor = disabledTextColor;
        obj.disabledTextColor = focusedContainerColor;
        obj.errorTextColor = disabledContainerColor;
        obj.focusedContainerColor = cursorColor;
        obj.unfocusedContainerColor = textSelectionColors;
        obj.disabledContainerColor = unfocusedIndicatorColor;
        obj.errorContainerColor = errorIndicatorColor;
        obj.cursorColor = unfocusedLeadingIconColor;
        obj.errorCursorColor = errorLeadingIconColor;
        obj.textSelectionColors = unfocusedTrailingIconColor;
        obj.focusedIndicatorColor = disabledTrailingIconColor;
        obj.unfocusedIndicatorColor = focusedLabelColor;
        obj.disabledIndicatorColor = disabledLabelColor;
        obj.errorIndicatorColor = focusedPlaceholderColor;
        obj.focusedLeadingIconColor = disabledPlaceholderColor;
        obj.unfocusedLeadingIconColor = focusedSupportingTextColor;
        obj.disabledLeadingIconColor = disabledSupportingTextColor;
        obj.errorLeadingIconColor = focusedPrefixColor;
        obj.focusedTrailingIconColor = disabledPrefixColor;
        obj.unfocusedTrailingIconColor = focusedSuffixColor;
        obj.disabledTrailingIconColor = disabledSuffixColor;
        obj.errorTrailingIconColor = obj60;
        obj.focusedLabelColor = obj62;
        obj.unfocusedLabelColor = obj64;
        obj.disabledLabelColor = obj66;
        obj.errorLabelColor = obj68;
        obj.focusedPlaceholderColor = obj70;
        obj.unfocusedPlaceholderColor = obj72;
        obj.disabledPlaceholderColor = obj74;
        obj.errorPlaceholderColor = obj76;
        obj.focusedSupportingTextColor = obj78;
        obj.unfocusedSupportingTextColor = obj80;
        obj.disabledSupportingTextColor = obj82;
        obj.errorSupportingTextColor = obj84;
        obj.focusedPrefixColor = obj86;
        obj.unfocusedPrefixColor = obj88;
        obj.disabledPrefixColor = obj90;
        obj.errorPrefixColor = obj92;
        obj.focusedSuffixColor = obj94;
        obj.unfocusedSuffixColor = obj96;
        obj.disabledSuffixColor = obj98;
        obj.errorSuffixColor = obj100;
    }

    public TextFieldColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, TextSelectionColors textSelectionColors11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, long l30, long l31, long l32, long l33, long l34, long l35, long l36, long l37, long l38, long l39, long l40, long l41, long l42, long l43, DefaultConstructorMarker defaultConstructorMarker44) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, textSelectionColors11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27, l28, l29, l30, l31, l32, l33, l34, l35, l36, l37, l38, l39, l40, l41, l42, l43, defaultConstructorMarker44, obj45, obj46, obj47, obj48, obj49, obj50, obj51, obj52, obj53, obj54, obj55, obj56, obj57, obj58, obj59, obj60, obj61, obj62, obj63, obj64, obj65, obj66, obj67, obj68, obj69, obj70, obj71, obj72, obj73, obj74, obj75, obj76, obj77, obj78, obj79, obj80, obj81, obj82, obj83, obj84, obj85);
    }

    public static androidx.compose.material3.TextFieldColors copy-ejIjP34$default(androidx.compose.material3.TextFieldColors textFieldColors, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, TextSelectionColors textSelectionColors12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, long l23, long l24, long l25, long l26, long l27, long l28, long l29, long l30, long l31, long l32, long l33, long l34, long l35, long l36, long l37, long l38, long l39, long l40, long l41, long l42, long l43, long l44, int i45, int i46, Object object47) {
        long errorSuffixColor;
        long focusedTextColor;
        long disabledContainerColor;
        long errorContainerColor;
        long cursorColor;
        long errorCursorColor;
        TextSelectionColors textSelectionColors;
        long focusedIndicatorColor;
        long unfocusedIndicatorColor;
        long disabledIndicatorColor;
        long errorIndicatorColor;
        long focusedLeadingIconColor;
        long unfocusedLeadingIconColor;
        long disabledLeadingIconColor;
        long errorLeadingIconColor;
        long focusedTrailingIconColor;
        long unfocusedTrailingIconColor;
        long disabledTrailingIconColor;
        long errorTrailingIconColor;
        long focusedLabelColor;
        long unfocusedLabelColor;
        long disabledLabelColor;
        long errorLabelColor;
        long focusedPlaceholderColor;
        long unfocusedPlaceholderColor;
        long disabledPlaceholderColor;
        long errorPlaceholderColor;
        long focusedSupportingTextColor;
        long unfocusedSupportingTextColor;
        long disabledSupportingTextColor;
        long errorSupportingTextColor;
        long focusedPrefixColor;
        long unfocusedPrefixColor;
        long disabledPrefixColor;
        long errorPrefixColor;
        long focusedSuffixColor;
        long unfocusedSuffixColor;
        long disabledSuffixColor;
        long unfocusedTextColor;
        long disabledTextColor;
        long errorTextColor;
        long focusedContainerColor;
        long unfocusedContainerColor;
        long l;
        TextSelectionColors obj27;
        long obj34;
        long obj36;
        long obj38;
        long obj40;
        long obj42;
        long obj44;
        long obj46;
        long obj48;
        long obj50;
        long obj52;
        long obj54;
        long obj56;
        long obj58;
        long obj60;
        long obj62;
        long obj64;
        long obj66;
        long obj68;
        long obj70;
        long obj72;
        long obj74;
        long obj76;
        long obj78;
        long obj80;
        long obj82;
        long obj84;
        long obj86;
        Object obj = textFieldColors;
        int i = obj104;
        final int i14 = obj105;
        focusedTextColor = i & 1 != 0 ? obj.focusedTextColor : l2;
        unfocusedTextColor = i & 2 != 0 ? obj.unfocusedTextColor : l4;
        disabledTextColor = i & 4 != 0 ? obj.disabledTextColor : l6;
        errorTextColor = i & 8 != 0 ? obj.errorTextColor : l8;
        focusedContainerColor = i & 16 != 0 ? obj.focusedContainerColor : l10;
        unfocusedContainerColor = i & 32 != 0 ? obj.unfocusedContainerColor : textSelectionColors12;
        disabledContainerColor = i & 64 != 0 ? obj.disabledContainerColor : l14;
        errorContainerColor = i & 128 != 0 ? obj.errorContainerColor : l16;
        final long obj21 = errorContainerColor;
        cursorColor = i & 256 != 0 ? obj.cursorColor : l18;
        final long obj23 = cursorColor;
        errorCursorColor = i & 512 != 0 ? obj.errorCursorColor : l20;
        final long obj25 = errorCursorColor;
        textSelectionColors = i & 1024 != 0 ? obj.textSelectionColors : l22;
        focusedIndicatorColor = i & 2048 != 0 ? obj.focusedIndicatorColor : l23;
        unfocusedIndicatorColor = i & 4096 != 0 ? obj.unfocusedIndicatorColor : l25;
        disabledIndicatorColor = i & 8192 != 0 ? obj.disabledIndicatorColor : l27;
        errorIndicatorColor = i & 16384 != 0 ? obj.errorIndicatorColor : l29;
        focusedLeadingIconColor = i & i30 != 0 ? obj.focusedLeadingIconColor : l31;
        unfocusedLeadingIconColor = i & i32 != 0 ? obj.unfocusedLeadingIconColor : l33;
        disabledLeadingIconColor = i & i34 != 0 ? obj.disabledLeadingIconColor : l35;
        errorLeadingIconColor = i & i36 != 0 ? obj.errorLeadingIconColor : l37;
        focusedTrailingIconColor = i & i38 != 0 ? obj.focusedTrailingIconColor : l39;
        unfocusedTrailingIconColor = i & i40 != 0 ? obj.unfocusedTrailingIconColor : l41;
        disabledTrailingIconColor = i & i42 != 0 ? obj.disabledTrailingIconColor : l43;
        errorTrailingIconColor = i & i44 != 0 ? obj.errorTrailingIconColor : i45;
        focusedLabelColor = i & i48 != 0 ? obj.focusedLabelColor : object47;
        unfocusedLabelColor = i & i50 != 0 ? obj.unfocusedLabelColor : obj66;
        disabledLabelColor = i & i52 != 0 ? obj.disabledLabelColor : obj68;
        errorLabelColor = i & i54 != 0 ? obj.errorLabelColor : obj70;
        focusedPlaceholderColor = i & i56 != 0 ? obj.focusedPlaceholderColor : obj72;
        unfocusedPlaceholderColor = i & i58 != 0 ? obj.unfocusedPlaceholderColor : obj74;
        disabledPlaceholderColor = i & i60 != 0 ? obj.disabledPlaceholderColor : obj76;
        errorPlaceholderColor = i & i62 != 0 ? obj.errorPlaceholderColor : obj78;
        focusedSupportingTextColor = i &= i64 != 0 ? obj.focusedSupportingTextColor : obj80;
        unfocusedSupportingTextColor = i14 & 1 != 0 ? obj.unfocusedSupportingTextColor : obj82;
        disabledSupportingTextColor = i14 & 2 != 0 ? obj.disabledSupportingTextColor : obj84;
        errorSupportingTextColor = i14 & 4 != 0 ? obj.errorSupportingTextColor : obj86;
        focusedPrefixColor = i14 & 8 != 0 ? obj.focusedPrefixColor : obj88;
        unfocusedPrefixColor = i14 & 16 != 0 ? obj.unfocusedPrefixColor : obj90;
        disabledPrefixColor = i14 & 32 != 0 ? obj.disabledPrefixColor : obj92;
        errorPrefixColor = i14 & 64 != 0 ? obj.errorPrefixColor : obj94;
        focusedSuffixColor = i14 & 128 != 0 ? obj.focusedSuffixColor : obj96;
        unfocusedSuffixColor = i14 & 256 != 0 ? obj.unfocusedSuffixColor : obj98;
        disabledSuffixColor = i14 & 512 != 0 ? obj.disabledSuffixColor : obj100;
        errorSuffixColor = i14 & 1024 != 0 ? obj.errorSuffixColor : obj102;
        return obj.copy-ejIjP34(l, obj21, unfocusedTextColor, obj23, disabledTextColor, obj25, errorTextColor, obj27, focusedContainerColor, textSelectionColors12, unfocusedContainerColor, l14, disabledContainerColor, l16, obj21, l18, obj23, l20, obj25, l22, obj27, focusedIndicatorColor, obj42, unfocusedIndicatorColor, obj44, disabledIndicatorColor, obj46, obj34, obj48, obj36, obj50, obj38, obj52, obj40, obj54, obj42, obj56, obj44, obj58, obj46, obj60, obj48, obj62);
    }

    public final long containerColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long unfocusedContainerColor;
        unfocusedContainerColor = !enabled ? this.disabledContainerColor : isError != null ? this.errorContainerColor : focused ? this.focusedContainerColor : this.unfocusedContainerColor;
        return unfocusedContainerColor;
    }

    public final androidx.compose.material3.TextFieldColors copy-ejIjP34(long focusedTextColor, long unfocusedTextColor, long disabledTextColor, long errorTextColor, long focusedContainerColor, long unfocusedContainerColor, long disabledContainerColor, long errorContainerColor, long cursorColor, long errorCursorColor, TextSelectionColors textSelectionColors, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long focusedLeadingIconColor, long unfocusedLeadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long focusedTrailingIconColor, long unfocusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long focusedPlaceholderColor, long unfocusedPlaceholderColor, long disabledPlaceholderColor, long errorPlaceholderColor, long focusedSupportingTextColor, long unfocusedSupportingTextColor, long disabledSupportingTextColor, long errorSupportingTextColor, long focusedPrefixColor, long unfocusedPrefixColor, long disabledPrefixColor, long errorPrefixColor, long focusedSuffixColor, long unfocusedSuffixColor, long disabledSuffixColor, long errorSuffixColor) {
        int $this$isSpecified$iv$iv18;
        int $this$isSpecified$iv$iv39;
        int $this$isSpecified$iv$iv13;
        int $this$isSpecified$iv$iv35;
        int $this$isSpecified$iv$iv10;
        int $this$isSpecified$iv$iv19;
        int $this$isSpecified$iv$iv21;
        int $this$isSpecified$iv$iv23;
        int $this$isSpecified$iv$iv41;
        int $this$isSpecified$iv$iv7;
        int $this$isSpecified$iv$iv31;
        int $this$isSpecified$iv$iv27;
        int $this$isSpecified$iv$iv22;
        int $this$isSpecified$iv$iv;
        int $this$isSpecified$iv$iv40;
        int $this$isSpecified$iv$iv30;
        int $this$isSpecified$iv$iv6;
        int $this$isSpecified$iv$iv38;
        int $this$isSpecified$iv$iv24;
        int $this$isSpecified$iv$iv20;
        int $this$isSpecified$iv$iv4;
        int $this$isSpecified$iv$iv26;
        int $this$isSpecified$iv$iv25;
        int $this$isSpecified$iv$iv32;
        int $this$isSpecified$iv$iv5;
        int $this$isSpecified$iv$iv14;
        int $this$isSpecified$iv$iv8;
        int $this$isSpecified$iv$iv11;
        int $this$isSpecified$iv$iv3;
        int $this$isSpecified$iv$iv17;
        int $this$isSpecified$iv$iv28;
        int $this$isSpecified$iv$iv9;
        int $this$isSpecified$iv$iv15;
        int $this$isSpecified$iv$iv33;
        int $this$isSpecified$iv$iv12;
        int $this$isSpecified$iv$iv36;
        int $this$isSpecified$iv$iv29;
        int $this$isSpecified$iv$iv34;
        int $this$isSpecified$iv$iv37;
        int $this$isSpecified$iv$iv2;
        int $this$isSpecified$iv$iv16;
        long errorSuffixColor2;
        int i2;
        long l17;
        long l39;
        long l4;
        long l36;
        long l18;
        long l32;
        long l7;
        long l15;
        long l16;
        long l33;
        long l29;
        long l14;
        long l8;
        long l25;
        long l19;
        long l40;
        long i;
        long l10;
        long l37;
        long l38;
        long l20;
        long l28;
        long l30;
        long l11;
        long l5;
        long l2;
        long l35;
        long l21;
        long l12;
        long l31;
        long l9;
        long l3;
        long l22;
        long l26;
        long l24;
        long l6;
        long l27;
        long i3;
        long l23;
        long l13;
        long l34;
        long l;
        final Object obj = this;
        int i4 = focusedTextColor;
        int i37 = 0;
        int i131 = 0;
        int i141 = 16;
        i2 = 1;
        final int i174 = 0;
        $this$isSpecified$iv$iv18 = Long.compare(i48, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv18 != 0) {
            l17 = i4;
        } else {
            int i67 = 0;
            l17 = $this$isSpecified$iv$iv18;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv = disabledTextColor;
        int i38 = 0;
        int i132 = 0;
        $this$isSpecified$iv$iv39 = Long.compare(i49, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv39 != 0) {
            l39 = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            int i66 = 0;
            l39 = $this$isSpecified$iv$iv39;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv2 = focusedContainerColor;
        int i39 = 0;
        int i133 = 0;
        $this$isSpecified$iv$iv13 = Long.compare(i50, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv13 != 0) {
            l4 = $this$takeOrElse_u2dDxMtmZc$iv2;
        } else {
            int i65 = 0;
            l4 = $this$isSpecified$iv$iv13;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv3 = disabledContainerColor;
        int i40 = 0;
        int i134 = 0;
        $this$isSpecified$iv$iv35 = Long.compare(i51, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv35 != 0) {
            l36 = $this$takeOrElse_u2dDxMtmZc$iv3;
        } else {
            int i64 = 0;
            l36 = $this$isSpecified$iv$iv35;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv4 = cursorColor;
        int i41 = 0;
        int i135 = 0;
        $this$isSpecified$iv$iv10 = Long.compare(i52, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv10 != 0) {
            l18 = $this$takeOrElse_u2dDxMtmZc$iv4;
        } else {
            int i63 = 0;
            l18 = $this$isSpecified$iv$iv10;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv5 = textSelectionColors;
        int i42 = 0;
        int i136 = 0;
        $this$isSpecified$iv$iv19 = Long.compare(i53, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv19 != 0) {
            l32 = $this$takeOrElse_u2dDxMtmZc$iv5;
        } else {
            int i62 = 0;
            l32 = $this$isSpecified$iv$iv19;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv6 = unfocusedIndicatorColor;
        int i43 = 0;
        int i137 = 0;
        $this$isSpecified$iv$iv21 = Long.compare(i54, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv21 != 0) {
            l7 = $this$takeOrElse_u2dDxMtmZc$iv6;
        } else {
            int i61 = 0;
            l7 = $this$isSpecified$iv$iv21;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv7 = errorIndicatorColor;
        int i44 = 0;
        int i138 = 0;
        $this$isSpecified$iv$iv23 = Long.compare(i55, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv23 != 0) {
            l15 = $this$takeOrElse_u2dDxMtmZc$iv7;
        } else {
            int i60 = 0;
            l15 = $this$isSpecified$iv$iv23;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv8 = unfocusedLeadingIconColor;
        int i45 = 0;
        int i139 = 0;
        $this$isSpecified$iv$iv41 = Long.compare(i56, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv41 != 0) {
            l16 = $this$takeOrElse_u2dDxMtmZc$iv8;
        } else {
            int i59 = 0;
            l16 = $this$isSpecified$iv$iv41;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv9 = errorLeadingIconColor;
        int i46 = 0;
        int i140 = 0;
        $this$isSpecified$iv$iv7 = Long.compare(i57, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv7 != 0) {
            l33 = $this$takeOrElse_u2dDxMtmZc$iv9;
        } else {
            int i58 = 0;
            l33 = $this$isSpecified$iv$iv7;
        }
        TextFieldColors.copy.11 $this$takeOrElse_u2dDxMtmZc$iv10 = new TextFieldColors.copy.11(obj);
        int i47 = disabledTrailingIconColor;
        int i5 = 0;
        int i142 = 0;
        $this$isSpecified$iv$iv31 = Long.compare(i68, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv31 != 0) {
            l29 = i47;
        } else {
            int i130 = 0;
            l29 = $this$isSpecified$iv$iv31;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv11 = focusedLabelColor;
        int i6 = 0;
        int i143 = 0;
        $this$isSpecified$iv$iv27 = Long.compare(i69, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv27 != 0) {
            l14 = $this$takeOrElse_u2dDxMtmZc$iv11;
        } else {
            int i129 = 0;
            l14 = $this$isSpecified$iv$iv27;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv12 = disabledLabelColor;
        int i7 = 0;
        int i144 = 0;
        $this$isSpecified$iv$iv22 = Long.compare(i70, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv22 != 0) {
            l8 = $this$takeOrElse_u2dDxMtmZc$iv12;
        } else {
            int i128 = 0;
            l8 = $this$isSpecified$iv$iv22;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv13 = focusedPlaceholderColor;
        int i8 = 0;
        int i145 = 0;
        $this$isSpecified$iv$iv = Long.compare(i71, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv != 0) {
            l25 = $this$takeOrElse_u2dDxMtmZc$iv13;
        } else {
            int i127 = 0;
            l25 = $this$isSpecified$iv$iv;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv14 = disabledPlaceholderColor;
        int i9 = 0;
        int i146 = 0;
        $this$isSpecified$iv$iv40 = Long.compare(i72, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv40 != 0) {
            l19 = $this$takeOrElse_u2dDxMtmZc$iv14;
        } else {
            int i126 = 0;
            l19 = $this$isSpecified$iv$iv40;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv15 = focusedSupportingTextColor;
        int i10 = 0;
        int i147 = 0;
        $this$isSpecified$iv$iv30 = Long.compare(i73, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv30 != 0) {
            l40 = $this$takeOrElse_u2dDxMtmZc$iv15;
        } else {
            int i125 = 0;
            l40 = $this$isSpecified$iv$iv30;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv16 = disabledSupportingTextColor;
        int i11 = 0;
        int i148 = 0;
        $this$isSpecified$iv$iv6 = Long.compare(i74, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv6 != 0) {
            i = $this$takeOrElse_u2dDxMtmZc$iv16;
        } else {
            int i124 = 0;
            i = $this$isSpecified$iv$iv6;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv17 = focusedPrefixColor;
        int i12 = 0;
        int i149 = 0;
        $this$isSpecified$iv$iv38 = Long.compare(i75, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv38 != 0) {
            l10 = $this$takeOrElse_u2dDxMtmZc$iv17;
        } else {
            int i123 = 0;
            l10 = $this$isSpecified$iv$iv38;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv18 = disabledPrefixColor;
        int i13 = 0;
        int i150 = 0;
        $this$isSpecified$iv$iv24 = Long.compare(i76, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv24 != 0) {
            l37 = $this$takeOrElse_u2dDxMtmZc$iv18;
        } else {
            int i122 = 0;
            l37 = $this$isSpecified$iv$iv24;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv19 = focusedSuffixColor;
        int i14 = 0;
        int i151 = 0;
        $this$isSpecified$iv$iv20 = Long.compare(i77, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv20 != 0) {
            l38 = $this$takeOrElse_u2dDxMtmZc$iv19;
        } else {
            int i121 = 0;
            l38 = $this$isSpecified$iv$iv20;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv20 = disabledSuffixColor;
        int i15 = 0;
        int i152 = 0;
        $this$isSpecified$iv$iv4 = Long.compare(i78, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv4 != 0) {
            l20 = $this$takeOrElse_u2dDxMtmZc$iv20;
        } else {
            int i79 = 0;
            l20 = $this$isSpecified$iv$iv4;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv21 = obj143;
        int i16 = 0;
        int i153 = 0;
        $this$isSpecified$iv$iv26 = Long.compare(i80, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv26 != 0) {
            l28 = $this$takeOrElse_u2dDxMtmZc$iv21;
        } else {
            int i120 = 0;
            l28 = $this$isSpecified$iv$iv26;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv22 = obj145;
        int i17 = 0;
        int i154 = 0;
        $this$isSpecified$iv$iv25 = Long.compare(i81, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv25 != 0) {
            l30 = $this$takeOrElse_u2dDxMtmZc$iv22;
        } else {
            int i119 = 0;
            l30 = $this$isSpecified$iv$iv25;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv23 = obj147;
        int i18 = 0;
        int i155 = 0;
        $this$isSpecified$iv$iv32 = Long.compare(i82, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv32 != 0) {
            l11 = $this$takeOrElse_u2dDxMtmZc$iv23;
        } else {
            int i118 = 0;
            l11 = $this$isSpecified$iv$iv32;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv24 = obj149;
        int i19 = 0;
        int i156 = 0;
        $this$isSpecified$iv$iv5 = Long.compare(i83, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv5 != 0) {
            l5 = $this$takeOrElse_u2dDxMtmZc$iv24;
        } else {
            int i117 = 0;
            l5 = $this$isSpecified$iv$iv5;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv25 = obj151;
        int i20 = 0;
        int i157 = 0;
        $this$isSpecified$iv$iv14 = Long.compare(i84, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv14 != 0) {
            l2 = $this$takeOrElse_u2dDxMtmZc$iv25;
        } else {
            int i116 = 0;
            l2 = $this$isSpecified$iv$iv14;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv26 = obj153;
        int i21 = 0;
        int i158 = 0;
        $this$isSpecified$iv$iv8 = Long.compare(i85, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv8 != 0) {
            l35 = $this$takeOrElse_u2dDxMtmZc$iv26;
        } else {
            int i115 = 0;
            l35 = $this$isSpecified$iv$iv8;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv27 = obj155;
        int i22 = 0;
        int i159 = 0;
        $this$isSpecified$iv$iv11 = Long.compare(i86, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv11 != 0) {
            l21 = $this$takeOrElse_u2dDxMtmZc$iv27;
        } else {
            int i114 = 0;
            l21 = $this$isSpecified$iv$iv11;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv28 = obj157;
        int i23 = 0;
        int i160 = 0;
        $this$isSpecified$iv$iv3 = Long.compare(i87, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv3 != 0) {
            l12 = $this$takeOrElse_u2dDxMtmZc$iv28;
        } else {
            int i113 = 0;
            l12 = $this$isSpecified$iv$iv3;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv29 = obj159;
        int i24 = 0;
        int i161 = 0;
        $this$isSpecified$iv$iv17 = Long.compare(i88, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv17 != 0) {
            l31 = $this$takeOrElse_u2dDxMtmZc$iv29;
        } else {
            int i112 = 0;
            l31 = $this$isSpecified$iv$iv17;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv30 = obj161;
        int i25 = 0;
        int i162 = 0;
        $this$isSpecified$iv$iv28 = Long.compare(i89, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv28 != 0) {
            l9 = $this$takeOrElse_u2dDxMtmZc$iv30;
        } else {
            int i111 = 0;
            l9 = $this$isSpecified$iv$iv28;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv31 = obj163;
        int i26 = 0;
        int i163 = 0;
        $this$isSpecified$iv$iv9 = Long.compare(i90, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv9 != 0) {
            l3 = $this$takeOrElse_u2dDxMtmZc$iv31;
        } else {
            int i110 = 0;
            l3 = $this$isSpecified$iv$iv9;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv32 = obj165;
        int i27 = 0;
        int i164 = 0;
        $this$isSpecified$iv$iv15 = Long.compare(i91, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv15 != 0) {
            l22 = $this$takeOrElse_u2dDxMtmZc$iv32;
        } else {
            int i109 = 0;
            l22 = $this$isSpecified$iv$iv15;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv33 = obj167;
        int i28 = 0;
        int i165 = 0;
        $this$isSpecified$iv$iv33 = Long.compare(i92, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv33 != 0) {
            l26 = $this$takeOrElse_u2dDxMtmZc$iv33;
        } else {
            int i108 = 0;
            l26 = $this$isSpecified$iv$iv33;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv34 = obj169;
        int i29 = 0;
        int i166 = 0;
        $this$isSpecified$iv$iv12 = Long.compare(i93, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv12 != 0) {
            l24 = $this$takeOrElse_u2dDxMtmZc$iv34;
        } else {
            int i107 = 0;
            l24 = $this$isSpecified$iv$iv12;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv35 = obj171;
        int i30 = 0;
        int i167 = 0;
        $this$isSpecified$iv$iv36 = Long.compare(i94, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv36 != 0) {
            l6 = $this$takeOrElse_u2dDxMtmZc$iv35;
        } else {
            int i106 = 0;
            l6 = $this$isSpecified$iv$iv36;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv36 = obj173;
        int i31 = 0;
        int i168 = 0;
        $this$isSpecified$iv$iv29 = Long.compare(i95, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv29 != 0) {
            l27 = $this$takeOrElse_u2dDxMtmZc$iv36;
        } else {
            int i105 = 0;
            l27 = $this$isSpecified$iv$iv29;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv37 = obj175;
        int i32 = 0;
        int i169 = 0;
        $this$isSpecified$iv$iv34 = Long.compare(i96, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv34 != 0) {
            i3 = $this$takeOrElse_u2dDxMtmZc$iv37;
        } else {
            int i104 = 0;
            i3 = $this$isSpecified$iv$iv34;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv38 = obj177;
        int i33 = 0;
        int i170 = 0;
        $this$isSpecified$iv$iv37 = Long.compare(i97, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv37 != 0) {
            l23 = $this$takeOrElse_u2dDxMtmZc$iv38;
        } else {
            int i103 = 0;
            l23 = $this$isSpecified$iv$iv37;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv39 = obj179;
        int i34 = 0;
        int i171 = 0;
        $this$isSpecified$iv$iv2 = Long.compare(i98, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv2 != 0) {
            l13 = $this$takeOrElse_u2dDxMtmZc$iv39;
        } else {
            int i102 = 0;
            l13 = $this$isSpecified$iv$iv2;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv40 = obj181;
        int i35 = 0;
        int i172 = 0;
        $this$isSpecified$iv$iv16 = Long.compare(i99, i141) != 0 ? i2 : i174;
        if ($this$isSpecified$iv$iv16 != 0) {
            l34 = $this$takeOrElse_u2dDxMtmZc$iv40;
        } else {
            int i101 = 0;
            l34 = $this$isSpecified$iv$iv16;
        }
        int $this$takeOrElse_u2dDxMtmZc$iv41 = obj183;
        int i36 = 0;
        int i173 = 0;
        if (Long.compare(errorSuffixColor2, i141) != 0) {
        } else {
            i2 = i174;
        }
        if (i2 != 0) {
            l = $this$takeOrElse_u2dDxMtmZc$iv41;
        } else {
            int i100 = 0;
            l = errorSuffixColor2;
        }
        TextFieldColors textFieldColors = new TextFieldColors(l17, obj14, l39, obj16, l4, obj18, l36, obj20, l18, obj22, l32, obj24, l7, obj26, l15, obj28, l16, obj30, l33, obj32, obj.takeOrElse$material3_release(unfocusedTrailingIconColor, (Function0)$this$takeOrElse_u2dDxMtmZc$iv10), l29, obj35, l14, obj37, l8, obj39, l25, obj41, l19, obj43, l40, obj45, i, obj47, l10, obj49, l37, obj51, l38, obj53, l20, obj55, l28, obj57, l30, obj59, l11, obj61, l5, obj63, l2, obj65, l35, obj67, l21, obj69, l12, obj71, l31, obj73, l9, obj75, l3, obj77, l22, obj79, l26, obj81, l24, obj83, l6, obj85, l27, obj87, i3, obj89, l23, obj91, l13, obj93, l34, obj95, l, obj97, 0);
        return textFieldColors;
    }

    public final long cursorColor-vNxB06k$material3_release(boolean isError) {
        long errorCursorColor;
        errorCursorColor = isError != null ? this.errorCursorColor : this.cursorColor;
        return errorCursorColor;
    }

    public boolean equals(Object other) {
        boolean z;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            if (!other instanceof TextFieldColors) {
            } else {
                if (!Color.equals-impl0(this.focusedTextColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedTextColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledTextColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorTextColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorContainerColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.cursorColor, obj3)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorCursorColor, obj3)) {
                    return i2;
                }
                TextSelectionColors textSelectionColors2 = obj.textSelectionColors;
                if (!Intrinsics.areEqual(this.textSelectionColors, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedIndicatorColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedIndicatorColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledIndicatorColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorIndicatorColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedLeadingIconColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedLeadingIconColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLeadingIconColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorLeadingIconColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedTrailingIconColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedTrailingIconColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledTrailingIconColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorTrailingIconColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedLabelColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedLabelColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLabelColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorLabelColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedPlaceholderColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedPlaceholderColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledPlaceholderColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorPlaceholderColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedSupportingTextColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedSupportingTextColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledSupportingTextColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorSupportingTextColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedPrefixColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedPrefixColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledPrefixColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorPrefixColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedSuffixColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedSuffixColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledSuffixColor, textSelectionColors2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorSuffixColor, textSelectionColors2)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public final long getCursorColor-0d7_KjU() {
        return this.cursorColor;
    }

    public final long getDisabledContainerColor-0d7_KjU() {
        return this.disabledContainerColor;
    }

    public final long getDisabledIndicatorColor-0d7_KjU() {
        return this.disabledIndicatorColor;
    }

    public final long getDisabledLabelColor-0d7_KjU() {
        return this.disabledLabelColor;
    }

    public final long getDisabledLeadingIconColor-0d7_KjU() {
        return this.disabledLeadingIconColor;
    }

    public final long getDisabledPlaceholderColor-0d7_KjU() {
        return this.disabledPlaceholderColor;
    }

    public final long getDisabledPrefixColor-0d7_KjU() {
        return this.disabledPrefixColor;
    }

    public final long getDisabledSuffixColor-0d7_KjU() {
        return this.disabledSuffixColor;
    }

    public final long getDisabledSupportingTextColor-0d7_KjU() {
        return this.disabledSupportingTextColor;
    }

    public final long getDisabledTextColor-0d7_KjU() {
        return this.disabledTextColor;
    }

    public final long getDisabledTrailingIconColor-0d7_KjU() {
        return this.disabledTrailingIconColor;
    }

    public final long getErrorContainerColor-0d7_KjU() {
        return this.errorContainerColor;
    }

    public final long getErrorCursorColor-0d7_KjU() {
        return this.errorCursorColor;
    }

    public final long getErrorIndicatorColor-0d7_KjU() {
        return this.errorIndicatorColor;
    }

    public final long getErrorLabelColor-0d7_KjU() {
        return this.errorLabelColor;
    }

    public final long getErrorLeadingIconColor-0d7_KjU() {
        return this.errorLeadingIconColor;
    }

    public final long getErrorPlaceholderColor-0d7_KjU() {
        return this.errorPlaceholderColor;
    }

    public final long getErrorPrefixColor-0d7_KjU() {
        return this.errorPrefixColor;
    }

    public final long getErrorSuffixColor-0d7_KjU() {
        return this.errorSuffixColor;
    }

    public final long getErrorSupportingTextColor-0d7_KjU() {
        return this.errorSupportingTextColor;
    }

    public final long getErrorTextColor-0d7_KjU() {
        return this.errorTextColor;
    }

    public final long getErrorTrailingIconColor-0d7_KjU() {
        return this.errorTrailingIconColor;
    }

    public final long getFocusedContainerColor-0d7_KjU() {
        return this.focusedContainerColor;
    }

    public final long getFocusedIndicatorColor-0d7_KjU() {
        return this.focusedIndicatorColor;
    }

    public final long getFocusedLabelColor-0d7_KjU() {
        return this.focusedLabelColor;
    }

    public final long getFocusedLeadingIconColor-0d7_KjU() {
        return this.focusedLeadingIconColor;
    }

    public final long getFocusedPlaceholderColor-0d7_KjU() {
        return this.focusedPlaceholderColor;
    }

    public final long getFocusedPrefixColor-0d7_KjU() {
        return this.focusedPrefixColor;
    }

    public final long getFocusedSuffixColor-0d7_KjU() {
        return this.focusedSuffixColor;
    }

    public final long getFocusedSupportingTextColor-0d7_KjU() {
        return this.focusedSupportingTextColor;
    }

    public final long getFocusedTextColor-0d7_KjU() {
        return this.focusedTextColor;
    }

    public final long getFocusedTrailingIconColor-0d7_KjU() {
        return this.focusedTrailingIconColor;
    }

    public final TextSelectionColors getTextSelectionColors() {
        return this.textSelectionColors;
    }

    public final long getUnfocusedContainerColor-0d7_KjU() {
        return this.unfocusedContainerColor;
    }

    public final long getUnfocusedIndicatorColor-0d7_KjU() {
        return this.unfocusedIndicatorColor;
    }

    public final long getUnfocusedLabelColor-0d7_KjU() {
        return this.unfocusedLabelColor;
    }

    public final long getUnfocusedLeadingIconColor-0d7_KjU() {
        return this.unfocusedLeadingIconColor;
    }

    public final long getUnfocusedPlaceholderColor-0d7_KjU() {
        return this.unfocusedPlaceholderColor;
    }

    public final long getUnfocusedPrefixColor-0d7_KjU() {
        return this.unfocusedPrefixColor;
    }

    public final long getUnfocusedSuffixColor-0d7_KjU() {
        return this.unfocusedSuffixColor;
    }

    public final long getUnfocusedSupportingTextColor-0d7_KjU() {
        return this.unfocusedSupportingTextColor;
    }

    public final long getUnfocusedTextColor-0d7_KjU() {
        return this.unfocusedTextColor;
    }

    public final long getUnfocusedTrailingIconColor-0d7_KjU() {
        return this.unfocusedTrailingIconColor;
    }

    public int hashCode() {
        return result21 += i86;
    }

    public final long indicatorColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long unfocusedIndicatorColor;
        unfocusedIndicatorColor = !enabled ? this.disabledIndicatorColor : isError != null ? this.errorIndicatorColor : focused ? this.focusedIndicatorColor : this.unfocusedIndicatorColor;
        return unfocusedIndicatorColor;
    }

    public final long labelColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long unfocusedLabelColor;
        unfocusedLabelColor = !enabled ? this.disabledLabelColor : isError != null ? this.errorLabelColor : focused ? this.focusedLabelColor : this.unfocusedLabelColor;
        return unfocusedLabelColor;
    }

    public final long leadingIconColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long errorLeadingIconColor;
        errorLeadingIconColor = !enabled ? this.disabledLeadingIconColor : isError != null ? this.errorLeadingIconColor : focused ? this.focusedLeadingIconColor : this.unfocusedLeadingIconColor;
        return errorLeadingIconColor;
    }

    public final long placeholderColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long errorPlaceholderColor;
        errorPlaceholderColor = !enabled ? this.disabledPlaceholderColor : isError != null ? this.errorPlaceholderColor : focused ? this.focusedPlaceholderColor : this.unfocusedPlaceholderColor;
        return errorPlaceholderColor;
    }

    public final long prefixColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long unfocusedPrefixColor;
        unfocusedPrefixColor = !enabled ? this.disabledPrefixColor : isError != null ? this.errorPrefixColor : focused ? this.focusedPrefixColor : this.unfocusedPrefixColor;
        return unfocusedPrefixColor;
    }

    public final long suffixColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long unfocusedSuffixColor;
        unfocusedSuffixColor = !enabled ? this.disabledSuffixColor : isError != null ? this.errorSuffixColor : focused ? this.focusedSuffixColor : this.unfocusedSuffixColor;
        return unfocusedSuffixColor;
    }

    public final long supportingTextColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long errorSupportingTextColor;
        errorSupportingTextColor = !enabled ? this.disabledSupportingTextColor : isError != null ? this.errorSupportingTextColor : focused ? this.focusedSupportingTextColor : this.unfocusedSupportingTextColor;
        return errorSupportingTextColor;
    }

    public final TextSelectionColors takeOrElse$material3_release(TextSelectionColors $this$takeOrElse, Function0<TextSelectionColors> block) {
        Object invoke;
        if ($this$takeOrElse == null) {
            invoke = block.invoke();
        } else {
            invoke = $this$takeOrElse;
        }
        return invoke;
    }

    public final long textColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long unfocusedTextColor;
        unfocusedTextColor = !enabled ? this.disabledTextColor : isError != null ? this.errorTextColor : focused ? this.focusedTextColor : this.unfocusedTextColor;
        return unfocusedTextColor;
    }

    public final long trailingIconColor-XeAY9LY$material3_release(boolean enabled, boolean isError, boolean focused) {
        long errorTrailingIconColor;
        errorTrailingIconColor = !enabled ? this.disabledTrailingIconColor : isError != null ? this.errorTrailingIconColor : focused ? this.focusedTrailingIconColor : this.unfocusedTrailingIconColor;
        return errorTrailingIconColor;
    }
}
