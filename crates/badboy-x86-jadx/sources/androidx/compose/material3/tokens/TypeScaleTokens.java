package androidx.compose.material3.tokens;

import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0003\u0008\u008f\u0001\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0019\u0010\u000c\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\r\u0010\nR\u0019\u0010\u000e\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u000f\u0010\nR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0017\u0010\nR\u0019\u0010\u0018\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u0019\u0010\nR\u0019\u0010\u001a\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u001b\u0010\nR\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u0013R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0006R\u0019\u0010 \u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008!\u0010\nR\u0019\u0010\"\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008#\u0010\nR\u0019\u0010$\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008%\u0010\nR\u0011\u0010&\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u0013R\u0011\u0010(\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u0006R\u0019\u0010*\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008+\u0010\nR\u0019\u0010,\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008-\u0010\nR\u0019\u0010.\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008/\u0010\nR\u0011\u00100\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u0013R\u0011\u00102\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u0006R\u0019\u00104\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u00085\u0010\nR\u0019\u00106\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u00087\u0010\nR\u0019\u00108\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u00089\u0010\nR\u0011\u0010:\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010\u0013R\u0011\u0010<\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008=\u0010\u0006R\u0019\u0010>\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008?\u0010\nR\u0019\u0010@\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008A\u0010\nR\u0019\u0010B\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008C\u0010\nR\u0011\u0010D\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010\u0013R\u0011\u0010F\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008G\u0010\u0006R\u0019\u0010H\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008I\u0010\nR\u0019\u0010J\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008K\u0010\nR\u0019\u0010L\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008M\u0010\nR\u0011\u0010N\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008O\u0010\u0013R\u0011\u0010P\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008Q\u0010\u0006R\u0019\u0010R\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008S\u0010\nR\u0019\u0010T\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008U\u0010\nR\u0019\u0010V\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008W\u0010\nR\u0011\u0010X\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008Y\u0010\u0013R\u0011\u0010Z\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008[\u0010\u0006R\u0019\u0010\\\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008]\u0010\nR\u0019\u0010^\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008_\u0010\nR\u0019\u0010`\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008a\u0010\nR\u0011\u0010b\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008c\u0010\u0013R\u0011\u0010d\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008e\u0010\u0006R\u0019\u0010f\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008g\u0010\nR\u0019\u0010h\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008i\u0010\nR\u0019\u0010j\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008k\u0010\nR\u0011\u0010l\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008m\u0010\u0013R\u0011\u0010n\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008o\u0010\u0006R\u0019\u0010p\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008q\u0010\nR\u0019\u0010r\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008s\u0010\nR\u0019\u0010t\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008u\u0010\nR\u0011\u0010v\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008w\u0010\u0013R\u0011\u0010x\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008y\u0010\u0006R\u0019\u0010z\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008{\u0010\nR\u0019\u0010|\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008}\u0010\nR\u0019\u0010~\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\u007f\u0010\nR\u0013\u0010\u0080\u0001\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\u0008\u0081\u0001\u0010\u0013R\u0013\u0010\u0082\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\u0008\u0083\u0001\u0010\u0006R\u001b\u0010\u0084\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u0085\u0001\u0010\nR\u001b\u0010\u0086\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u0087\u0001\u0010\nR\u001b\u0010\u0088\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u0089\u0001\u0010\nR\u0013\u0010\u008a\u0001\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\u0008\u008b\u0001\u0010\u0013R\u0013\u0010\u008c\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\u0008\u008d\u0001\u0010\u0006R\u001b\u0010\u008e\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u008f\u0001\u0010\nR\u001b\u0010\u0090\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u0091\u0001\u0010\nR\u001b\u0010\u0092\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u0093\u0001\u0010\nR\u0013\u0010\u0094\u0001\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\u0008\u0095\u0001\u0010\u0013R\u0013\u0010\u0096\u0001\u001a\u00020\u0004¢\u0006\t\n\u0000\u001a\u0005\u0008\u0097\u0001\u0010\u0006R\u001b\u0010\u0098\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u0099\u0001\u0010\nR\u001b\u0010\u009a\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u009b\u0001\u0010\nR\u001b\u0010\u009c\u0001\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\u000b\n\u0002\u0010\u000b\u001a\u0005\u0008\u009d\u0001\u0010\nR\u0013\u0010\u009e\u0001\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\u0008\u009f\u0001\u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 \u0001", d2 = {"Landroidx/compose/material3/tokens/TypeScaleTokens;", "", "()V", "BodyLargeFont", "Landroidx/compose/ui/text/font/GenericFontFamily;", "getBodyLargeFont", "()Landroidx/compose/ui/text/font/GenericFontFamily;", "BodyLargeLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "getBodyLargeLineHeight-XSAIIZE", "()J", "J", "BodyLargeSize", "getBodyLargeSize-XSAIIZE", "BodyLargeTracking", "getBodyLargeTracking-XSAIIZE", "BodyLargeWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getBodyLargeWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "BodyMediumFont", "getBodyMediumFont", "BodyMediumLineHeight", "getBodyMediumLineHeight-XSAIIZE", "BodyMediumSize", "getBodyMediumSize-XSAIIZE", "BodyMediumTracking", "getBodyMediumTracking-XSAIIZE", "BodyMediumWeight", "getBodyMediumWeight", "BodySmallFont", "getBodySmallFont", "BodySmallLineHeight", "getBodySmallLineHeight-XSAIIZE", "BodySmallSize", "getBodySmallSize-XSAIIZE", "BodySmallTracking", "getBodySmallTracking-XSAIIZE", "BodySmallWeight", "getBodySmallWeight", "DisplayLargeFont", "getDisplayLargeFont", "DisplayLargeLineHeight", "getDisplayLargeLineHeight-XSAIIZE", "DisplayLargeSize", "getDisplayLargeSize-XSAIIZE", "DisplayLargeTracking", "getDisplayLargeTracking-XSAIIZE", "DisplayLargeWeight", "getDisplayLargeWeight", "DisplayMediumFont", "getDisplayMediumFont", "DisplayMediumLineHeight", "getDisplayMediumLineHeight-XSAIIZE", "DisplayMediumSize", "getDisplayMediumSize-XSAIIZE", "DisplayMediumTracking", "getDisplayMediumTracking-XSAIIZE", "DisplayMediumWeight", "getDisplayMediumWeight", "DisplaySmallFont", "getDisplaySmallFont", "DisplaySmallLineHeight", "getDisplaySmallLineHeight-XSAIIZE", "DisplaySmallSize", "getDisplaySmallSize-XSAIIZE", "DisplaySmallTracking", "getDisplaySmallTracking-XSAIIZE", "DisplaySmallWeight", "getDisplaySmallWeight", "HeadlineLargeFont", "getHeadlineLargeFont", "HeadlineLargeLineHeight", "getHeadlineLargeLineHeight-XSAIIZE", "HeadlineLargeSize", "getHeadlineLargeSize-XSAIIZE", "HeadlineLargeTracking", "getHeadlineLargeTracking-XSAIIZE", "HeadlineLargeWeight", "getHeadlineLargeWeight", "HeadlineMediumFont", "getHeadlineMediumFont", "HeadlineMediumLineHeight", "getHeadlineMediumLineHeight-XSAIIZE", "HeadlineMediumSize", "getHeadlineMediumSize-XSAIIZE", "HeadlineMediumTracking", "getHeadlineMediumTracking-XSAIIZE", "HeadlineMediumWeight", "getHeadlineMediumWeight", "HeadlineSmallFont", "getHeadlineSmallFont", "HeadlineSmallLineHeight", "getHeadlineSmallLineHeight-XSAIIZE", "HeadlineSmallSize", "getHeadlineSmallSize-XSAIIZE", "HeadlineSmallTracking", "getHeadlineSmallTracking-XSAIIZE", "HeadlineSmallWeight", "getHeadlineSmallWeight", "LabelLargeFont", "getLabelLargeFont", "LabelLargeLineHeight", "getLabelLargeLineHeight-XSAIIZE", "LabelLargeSize", "getLabelLargeSize-XSAIIZE", "LabelLargeTracking", "getLabelLargeTracking-XSAIIZE", "LabelLargeWeight", "getLabelLargeWeight", "LabelMediumFont", "getLabelMediumFont", "LabelMediumLineHeight", "getLabelMediumLineHeight-XSAIIZE", "LabelMediumSize", "getLabelMediumSize-XSAIIZE", "LabelMediumTracking", "getLabelMediumTracking-XSAIIZE", "LabelMediumWeight", "getLabelMediumWeight", "LabelSmallFont", "getLabelSmallFont", "LabelSmallLineHeight", "getLabelSmallLineHeight-XSAIIZE", "LabelSmallSize", "getLabelSmallSize-XSAIIZE", "LabelSmallTracking", "getLabelSmallTracking-XSAIIZE", "LabelSmallWeight", "getLabelSmallWeight", "TitleLargeFont", "getTitleLargeFont", "TitleLargeLineHeight", "getTitleLargeLineHeight-XSAIIZE", "TitleLargeSize", "getTitleLargeSize-XSAIIZE", "TitleLargeTracking", "getTitleLargeTracking-XSAIIZE", "TitleLargeWeight", "getTitleLargeWeight", "TitleMediumFont", "getTitleMediumFont", "TitleMediumLineHeight", "getTitleMediumLineHeight-XSAIIZE", "TitleMediumSize", "getTitleMediumSize-XSAIIZE", "TitleMediumTracking", "getTitleMediumTracking-XSAIIZE", "TitleMediumWeight", "getTitleMediumWeight", "TitleSmallFont", "getTitleSmallFont", "TitleSmallLineHeight", "getTitleSmallLineHeight-XSAIIZE", "TitleSmallSize", "getTitleSmallSize-XSAIIZE", "TitleSmallTracking", "getTitleSmallTracking-XSAIIZE", "TitleSmallWeight", "getTitleSmallWeight", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TypeScaleTokens {

    public static final int $stable;
    private static final GenericFontFamily BodyLargeFont;
    private static final long BodyLargeLineHeight;
    private static final long BodyLargeSize;
    private static final long BodyLargeTracking;
    private static final FontWeight BodyLargeWeight;
    private static final GenericFontFamily BodyMediumFont;
    private static final long BodyMediumLineHeight;
    private static final long BodyMediumSize;
    private static final long BodyMediumTracking;
    private static final FontWeight BodyMediumWeight;
    private static final GenericFontFamily BodySmallFont;
    private static final long BodySmallLineHeight;
    private static final long BodySmallSize;
    private static final long BodySmallTracking;
    private static final FontWeight BodySmallWeight;
    private static final GenericFontFamily DisplayLargeFont;
    private static final long DisplayLargeLineHeight;
    private static final long DisplayLargeSize;
    private static final long DisplayLargeTracking;
    private static final FontWeight DisplayLargeWeight;
    private static final GenericFontFamily DisplayMediumFont;
    private static final long DisplayMediumLineHeight;
    private static final long DisplayMediumSize;
    private static final long DisplayMediumTracking;
    private static final FontWeight DisplayMediumWeight;
    private static final GenericFontFamily DisplaySmallFont;
    private static final long DisplaySmallLineHeight;
    private static final long DisplaySmallSize;
    private static final long DisplaySmallTracking;
    private static final FontWeight DisplaySmallWeight;
    private static final GenericFontFamily HeadlineLargeFont;
    private static final long HeadlineLargeLineHeight;
    private static final long HeadlineLargeSize;
    private static final long HeadlineLargeTracking;
    private static final FontWeight HeadlineLargeWeight;
    private static final GenericFontFamily HeadlineMediumFont;
    private static final long HeadlineMediumLineHeight;
    private static final long HeadlineMediumSize;
    private static final long HeadlineMediumTracking;
    private static final FontWeight HeadlineMediumWeight;
    private static final GenericFontFamily HeadlineSmallFont;
    private static final long HeadlineSmallLineHeight;
    private static final long HeadlineSmallSize;
    private static final long HeadlineSmallTracking;
    private static final FontWeight HeadlineSmallWeight;
    public static final androidx.compose.material3.tokens.TypeScaleTokens INSTANCE;
    private static final GenericFontFamily LabelLargeFont;
    private static final long LabelLargeLineHeight;
    private static final long LabelLargeSize;
    private static final long LabelLargeTracking;
    private static final FontWeight LabelLargeWeight;
    private static final GenericFontFamily LabelMediumFont;
    private static final long LabelMediumLineHeight;
    private static final long LabelMediumSize;
    private static final long LabelMediumTracking;
    private static final FontWeight LabelMediumWeight;
    private static final GenericFontFamily LabelSmallFont;
    private static final long LabelSmallLineHeight;
    private static final long LabelSmallSize;
    private static final long LabelSmallTracking;
    private static final FontWeight LabelSmallWeight;
    private static final GenericFontFamily TitleLargeFont;
    private static final long TitleLargeLineHeight;
    private static final long TitleLargeSize;
    private static final long TitleLargeTracking;
    private static final FontWeight TitleLargeWeight;
    private static final GenericFontFamily TitleMediumFont;
    private static final long TitleMediumLineHeight;
    private static final long TitleMediumSize;
    private static final long TitleMediumTracking;
    private static final FontWeight TitleMediumWeight;
    private static final GenericFontFamily TitleSmallFont;
    private static final long TitleSmallLineHeight;
    private static final long TitleSmallSize;
    private static final long TitleSmallTracking;
    private static final FontWeight TitleSmallWeight;
    static {
        TypeScaleTokens typeScaleTokens = new TypeScaleTokens();
        TypeScaleTokens.INSTANCE = typeScaleTokens;
        TypeScaleTokens.BodyLargeFont = TypefaceTokens.INSTANCE.getPlain();
        long l = 4627448617123184640L;
        TypeScaleTokens.BodyLargeLineHeight = TextUnitKt.getSp(l);
        int i3 = 16;
        TypeScaleTokens.BodyLargeSize = TextUnitKt.getSp(i3);
        long l4 = 4602678819172646912L;
        TypeScaleTokens.BodyLargeTracking = TextUnitKt.getSp(l4);
        TypeScaleTokens.BodyLargeWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.BodyMediumFont = TypefaceTokens.INSTANCE.getPlain();
        long l5 = 4626322717216342016L;
        TypeScaleTokens.BodyMediumLineHeight = TextUnitKt.getSp(l5);
        int i11 = 14;
        TypeScaleTokens.BodyMediumSize = TextUnitKt.getSp(i11);
        long l6 = 4596373779694328218L;
        TypeScaleTokens.BodyMediumTracking = TextUnitKt.getSp(l6);
        TypeScaleTokens.BodyMediumWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.BodySmallFont = TypefaceTokens.INSTANCE.getPlain();
        long l7 = 4625196817309499392L;
        TypeScaleTokens.BodySmallLineHeight = TextUnitKt.getSp(l7);
        int i12 = 12;
        TypeScaleTokens.BodySmallSize = TextUnitKt.getSp(i12);
        TypeScaleTokens.BodySmallTracking = TextUnitKt.getSp(4600877379321698714L);
        TypeScaleTokens.BodySmallWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.DisplayLargeFont = TypefaceTokens.INSTANCE.getBrand();
        TypeScaleTokens.DisplayLargeLineHeight = TextUnitKt.getSp(4634204016564240384L);
        TypeScaleTokens.DisplayLargeSize = TextUnitKt.getSp(57);
        long sp26 = TextUnitKt.getSp(l6);
        final int i14 = 0;
        TextUnitKt.checkArithmetic--R2X_6o(sp26);
        TypeScaleTokens.DisplayLargeTracking = TextUnitKt.pack(TextUnit.getRawType-impl(sp26), obj1);
        TypeScaleTokens.DisplayLargeWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.DisplayMediumFont = TypefaceTokens.INSTANCE.getBrand();
        TypeScaleTokens.DisplayMediumLineHeight = TextUnitKt.getSp(4632515166703976448L);
        TypeScaleTokens.DisplayMediumSize = TextUnitKt.getSp(45);
        int i2 = 0;
        TypeScaleTokens.DisplayMediumTracking = TextUnitKt.getSp(i2);
        TypeScaleTokens.DisplayMediumWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.DisplaySmallFont = TypefaceTokens.INSTANCE.getBrand();
        TypeScaleTokens.DisplaySmallLineHeight = TextUnitKt.getSp(4631389266797133824L);
        TypeScaleTokens.DisplaySmallSize = TextUnitKt.getSp(36);
        TypeScaleTokens.DisplaySmallTracking = TextUnitKt.getSp(i2);
        TypeScaleTokens.DisplaySmallWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.HeadlineLargeFont = TypefaceTokens.INSTANCE.getBrand();
        TypeScaleTokens.HeadlineLargeLineHeight = TextUnitKt.getSp(4630826316843712512L);
        TypeScaleTokens.HeadlineLargeSize = TextUnitKt.getSp(32);
        TypeScaleTokens.HeadlineLargeTracking = TextUnitKt.getSp(i2);
        TypeScaleTokens.HeadlineLargeWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.HeadlineMediumFont = TypefaceTokens.INSTANCE.getBrand();
        TypeScaleTokens.HeadlineMediumLineHeight = TextUnitKt.getSp(4630263366890291200L);
        TypeScaleTokens.HeadlineMediumSize = TextUnitKt.getSp(28);
        TypeScaleTokens.HeadlineMediumTracking = TextUnitKt.getSp(i2);
        TypeScaleTokens.HeadlineMediumWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.HeadlineSmallFont = TypefaceTokens.INSTANCE.getBrand();
        TypeScaleTokens.HeadlineSmallLineHeight = TextUnitKt.getSp(4629700416936869888L);
        TypeScaleTokens.HeadlineSmallSize = TextUnitKt.getSp(24);
        TypeScaleTokens.HeadlineSmallTracking = TextUnitKt.getSp(i2);
        TypeScaleTokens.HeadlineSmallWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.LabelLargeFont = TypefaceTokens.INSTANCE.getPlain();
        TypeScaleTokens.LabelLargeLineHeight = TextUnitKt.getSp(l5);
        TypeScaleTokens.LabelLargeSize = TextUnitKt.getSp(i11);
        long l14 = 4591870180066957722L;
        TypeScaleTokens.LabelLargeTracking = TextUnitKt.getSp(l14);
        TypeScaleTokens.LabelLargeWeight = TypefaceTokens.INSTANCE.getWeightMedium();
        TypeScaleTokens.LabelMediumFont = TypefaceTokens.INSTANCE.getPlain();
        TypeScaleTokens.LabelMediumLineHeight = TextUnitKt.getSp(l7);
        TypeScaleTokens.LabelMediumSize = TextUnitKt.getSp(i12);
        TypeScaleTokens.LabelMediumTracking = TextUnitKt.getSp(l4);
        TypeScaleTokens.LabelMediumWeight = TypefaceTokens.INSTANCE.getWeightMedium();
        TypeScaleTokens.LabelSmallFont = TypefaceTokens.INSTANCE.getPlain();
        TypeScaleTokens.LabelSmallLineHeight = TextUnitKt.getSp(l7);
        TypeScaleTokens.LabelSmallSize = TextUnitKt.getSp(11);
        TypeScaleTokens.LabelSmallTracking = TextUnitKt.getSp(l4);
        TypeScaleTokens.LabelSmallWeight = TypefaceTokens.INSTANCE.getWeightMedium();
        TypeScaleTokens.TitleLargeFont = TypefaceTokens.INSTANCE.getBrand();
        TypeScaleTokens.TitleLargeLineHeight = TextUnitKt.getSp(4628574517030027264L);
        TypeScaleTokens.TitleLargeSize = TextUnitKt.getSp(22);
        TypeScaleTokens.TitleLargeTracking = TextUnitKt.getSp(i2);
        TypeScaleTokens.TitleLargeWeight = TypefaceTokens.INSTANCE.getWeightRegular();
        TypeScaleTokens.TitleMediumFont = TypefaceTokens.INSTANCE.getPlain();
        TypeScaleTokens.TitleMediumLineHeight = TextUnitKt.getSp(l);
        TypeScaleTokens.TitleMediumSize = TextUnitKt.getSp(i3);
        TypeScaleTokens.TitleMediumTracking = TextUnitKt.getSp(l6);
        TypeScaleTokens.TitleMediumWeight = TypefaceTokens.INSTANCE.getWeightMedium();
        TypeScaleTokens.TitleSmallFont = TypefaceTokens.INSTANCE.getPlain();
        TypeScaleTokens.TitleSmallLineHeight = TextUnitKt.getSp(l5);
        TypeScaleTokens.TitleSmallSize = TextUnitKt.getSp(i11);
        TypeScaleTokens.TitleSmallTracking = TextUnitKt.getSp(l14);
        TypeScaleTokens.TitleSmallWeight = TypefaceTokens.INSTANCE.getWeightMedium();
    }

    public final GenericFontFamily getBodyLargeFont() {
        return TypeScaleTokens.BodyLargeFont;
    }

    public final long getBodyLargeLineHeight-XSAIIZE() {
        return TypeScaleTokens.BodyLargeLineHeight;
    }

    public final long getBodyLargeSize-XSAIIZE() {
        return TypeScaleTokens.BodyLargeSize;
    }

    public final long getBodyLargeTracking-XSAIIZE() {
        return TypeScaleTokens.BodyLargeTracking;
    }

    public final FontWeight getBodyLargeWeight() {
        return TypeScaleTokens.BodyLargeWeight;
    }

    public final GenericFontFamily getBodyMediumFont() {
        return TypeScaleTokens.BodyMediumFont;
    }

    public final long getBodyMediumLineHeight-XSAIIZE() {
        return TypeScaleTokens.BodyMediumLineHeight;
    }

    public final long getBodyMediumSize-XSAIIZE() {
        return TypeScaleTokens.BodyMediumSize;
    }

    public final long getBodyMediumTracking-XSAIIZE() {
        return TypeScaleTokens.BodyMediumTracking;
    }

    public final FontWeight getBodyMediumWeight() {
        return TypeScaleTokens.BodyMediumWeight;
    }

    public final GenericFontFamily getBodySmallFont() {
        return TypeScaleTokens.BodySmallFont;
    }

    public final long getBodySmallLineHeight-XSAIIZE() {
        return TypeScaleTokens.BodySmallLineHeight;
    }

    public final long getBodySmallSize-XSAIIZE() {
        return TypeScaleTokens.BodySmallSize;
    }

    public final long getBodySmallTracking-XSAIIZE() {
        return TypeScaleTokens.BodySmallTracking;
    }

    public final FontWeight getBodySmallWeight() {
        return TypeScaleTokens.BodySmallWeight;
    }

    public final GenericFontFamily getDisplayLargeFont() {
        return TypeScaleTokens.DisplayLargeFont;
    }

    public final long getDisplayLargeLineHeight-XSAIIZE() {
        return TypeScaleTokens.DisplayLargeLineHeight;
    }

    public final long getDisplayLargeSize-XSAIIZE() {
        return TypeScaleTokens.DisplayLargeSize;
    }

    public final long getDisplayLargeTracking-XSAIIZE() {
        return TypeScaleTokens.DisplayLargeTracking;
    }

    public final FontWeight getDisplayLargeWeight() {
        return TypeScaleTokens.DisplayLargeWeight;
    }

    public final GenericFontFamily getDisplayMediumFont() {
        return TypeScaleTokens.DisplayMediumFont;
    }

    public final long getDisplayMediumLineHeight-XSAIIZE() {
        return TypeScaleTokens.DisplayMediumLineHeight;
    }

    public final long getDisplayMediumSize-XSAIIZE() {
        return TypeScaleTokens.DisplayMediumSize;
    }

    public final long getDisplayMediumTracking-XSAIIZE() {
        return TypeScaleTokens.DisplayMediumTracking;
    }

    public final FontWeight getDisplayMediumWeight() {
        return TypeScaleTokens.DisplayMediumWeight;
    }

    public final GenericFontFamily getDisplaySmallFont() {
        return TypeScaleTokens.DisplaySmallFont;
    }

    public final long getDisplaySmallLineHeight-XSAIIZE() {
        return TypeScaleTokens.DisplaySmallLineHeight;
    }

    public final long getDisplaySmallSize-XSAIIZE() {
        return TypeScaleTokens.DisplaySmallSize;
    }

    public final long getDisplaySmallTracking-XSAIIZE() {
        return TypeScaleTokens.DisplaySmallTracking;
    }

    public final FontWeight getDisplaySmallWeight() {
        return TypeScaleTokens.DisplaySmallWeight;
    }

    public final GenericFontFamily getHeadlineLargeFont() {
        return TypeScaleTokens.HeadlineLargeFont;
    }

    public final long getHeadlineLargeLineHeight-XSAIIZE() {
        return TypeScaleTokens.HeadlineLargeLineHeight;
    }

    public final long getHeadlineLargeSize-XSAIIZE() {
        return TypeScaleTokens.HeadlineLargeSize;
    }

    public final long getHeadlineLargeTracking-XSAIIZE() {
        return TypeScaleTokens.HeadlineLargeTracking;
    }

    public final FontWeight getHeadlineLargeWeight() {
        return TypeScaleTokens.HeadlineLargeWeight;
    }

    public final GenericFontFamily getHeadlineMediumFont() {
        return TypeScaleTokens.HeadlineMediumFont;
    }

    public final long getHeadlineMediumLineHeight-XSAIIZE() {
        return TypeScaleTokens.HeadlineMediumLineHeight;
    }

    public final long getHeadlineMediumSize-XSAIIZE() {
        return TypeScaleTokens.HeadlineMediumSize;
    }

    public final long getHeadlineMediumTracking-XSAIIZE() {
        return TypeScaleTokens.HeadlineMediumTracking;
    }

    public final FontWeight getHeadlineMediumWeight() {
        return TypeScaleTokens.HeadlineMediumWeight;
    }

    public final GenericFontFamily getHeadlineSmallFont() {
        return TypeScaleTokens.HeadlineSmallFont;
    }

    public final long getHeadlineSmallLineHeight-XSAIIZE() {
        return TypeScaleTokens.HeadlineSmallLineHeight;
    }

    public final long getHeadlineSmallSize-XSAIIZE() {
        return TypeScaleTokens.HeadlineSmallSize;
    }

    public final long getHeadlineSmallTracking-XSAIIZE() {
        return TypeScaleTokens.HeadlineSmallTracking;
    }

    public final FontWeight getHeadlineSmallWeight() {
        return TypeScaleTokens.HeadlineSmallWeight;
    }

    public final GenericFontFamily getLabelLargeFont() {
        return TypeScaleTokens.LabelLargeFont;
    }

    public final long getLabelLargeLineHeight-XSAIIZE() {
        return TypeScaleTokens.LabelLargeLineHeight;
    }

    public final long getLabelLargeSize-XSAIIZE() {
        return TypeScaleTokens.LabelLargeSize;
    }

    public final long getLabelLargeTracking-XSAIIZE() {
        return TypeScaleTokens.LabelLargeTracking;
    }

    public final FontWeight getLabelLargeWeight() {
        return TypeScaleTokens.LabelLargeWeight;
    }

    public final GenericFontFamily getLabelMediumFont() {
        return TypeScaleTokens.LabelMediumFont;
    }

    public final long getLabelMediumLineHeight-XSAIIZE() {
        return TypeScaleTokens.LabelMediumLineHeight;
    }

    public final long getLabelMediumSize-XSAIIZE() {
        return TypeScaleTokens.LabelMediumSize;
    }

    public final long getLabelMediumTracking-XSAIIZE() {
        return TypeScaleTokens.LabelMediumTracking;
    }

    public final FontWeight getLabelMediumWeight() {
        return TypeScaleTokens.LabelMediumWeight;
    }

    public final GenericFontFamily getLabelSmallFont() {
        return TypeScaleTokens.LabelSmallFont;
    }

    public final long getLabelSmallLineHeight-XSAIIZE() {
        return TypeScaleTokens.LabelSmallLineHeight;
    }

    public final long getLabelSmallSize-XSAIIZE() {
        return TypeScaleTokens.LabelSmallSize;
    }

    public final long getLabelSmallTracking-XSAIIZE() {
        return TypeScaleTokens.LabelSmallTracking;
    }

    public final FontWeight getLabelSmallWeight() {
        return TypeScaleTokens.LabelSmallWeight;
    }

    public final GenericFontFamily getTitleLargeFont() {
        return TypeScaleTokens.TitleLargeFont;
    }

    public final long getTitleLargeLineHeight-XSAIIZE() {
        return TypeScaleTokens.TitleLargeLineHeight;
    }

    public final long getTitleLargeSize-XSAIIZE() {
        return TypeScaleTokens.TitleLargeSize;
    }

    public final long getTitleLargeTracking-XSAIIZE() {
        return TypeScaleTokens.TitleLargeTracking;
    }

    public final FontWeight getTitleLargeWeight() {
        return TypeScaleTokens.TitleLargeWeight;
    }

    public final GenericFontFamily getTitleMediumFont() {
        return TypeScaleTokens.TitleMediumFont;
    }

    public final long getTitleMediumLineHeight-XSAIIZE() {
        return TypeScaleTokens.TitleMediumLineHeight;
    }

    public final long getTitleMediumSize-XSAIIZE() {
        return TypeScaleTokens.TitleMediumSize;
    }

    public final long getTitleMediumTracking-XSAIIZE() {
        return TypeScaleTokens.TitleMediumTracking;
    }

    public final FontWeight getTitleMediumWeight() {
        return TypeScaleTokens.TitleMediumWeight;
    }

    public final GenericFontFamily getTitleSmallFont() {
        return TypeScaleTokens.TitleSmallFont;
    }

    public final long getTitleSmallLineHeight-XSAIIZE() {
        return TypeScaleTokens.TitleSmallLineHeight;
    }

    public final long getTitleSmallSize-XSAIIZE() {
        return TypeScaleTokens.TitleSmallSize;
    }

    public final long getTitleSmallTracking-XSAIIZE() {
        return TypeScaleTokens.TitleSmallTracking;
    }

    public final FontWeight getTitleSmallWeight() {
        return TypeScaleTokens.TitleSmallWeight;
    }
}
