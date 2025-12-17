package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shadow.Companion;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.FontWeight.Companion;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.Locale.Companion;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.LocaleList.Companion;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BaselineShift.Companion;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextGeometricTransform.Companion;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndent.Companion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnit.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0086\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001ay\u0010Q\u001a\u000e\u0012\u0004\u0012\u0002HR\u0012\u0004\u0012\u0002HS0\u0011\"\u0004\u0008\u0000\u0010R\"\u0008\u0008\u0001\u0010S*\u00020\u00032.\u0010T\u001a*\u0012\u0004\u0012\u00020V\u0012\u0013\u0012\u0011HR¢\u0006\u000c\u0008W\u0012\u0008\u0008X\u0012\u0004\u0008\u0008(Y\u0012\u0006\u0012\u0004\u0018\u0001HS0U¢\u0006\u0002\u0008Z2#\u0010[\u001a\u001f\u0012\u0013\u0012\u0011HS¢\u0006\u000c\u0008W\u0012\u0008\u0008X\u0012\u0004\u0008\u0008(Y\u0012\u0006\u0012\u0004\u0018\u0001HR0\\H\u0002\u001aL\u0010[\u001a\u0004\u0018\u0001H]\"\u0014\u0008\u0000\u0010^*\u000e\u0012\u0004\u0012\u0002HR\u0012\u0004\u0012\u0002HS0\u0001\"\u0004\u0008\u0001\u0010R\"\u0004\u0008\u0002\u0010S\"\u0006\u0008\u0003\u0010]\u0018\u00012\u0008\u0010Y\u001a\u0004\u0018\u0001HS2\u0006\u0010_\u001a\u0002H^H\u0080\u0008¢\u0006\u0002\u0010`\u001a\"\u0010[\u001a\u0004\u0018\u0001H]\"\u0006\u0008\u0000\u0010]\u0018\u00012\u0008\u0010Y\u001a\u0004\u0018\u00010\u0003H\u0080\u0008¢\u0006\u0002\u0010a\u001aI\u0010T\u001a\u00020\u0003\"\u0014\u0008\u0000\u0010^*\u000e\u0012\u0004\u0012\u0002HR\u0012\u0004\u0012\u0002HS0\u0001\"\u0004\u0008\u0001\u0010R\"\u0004\u0008\u0002\u0010S2\u0008\u0010Y\u001a\u0004\u0018\u0001HR2\u0006\u0010_\u001a\u0002H^2\u0006\u0010b\u001a\u00020VH\u0000¢\u0006\u0002\u0010c\u001a\u001f\u0010T\u001a\u0004\u0018\u0001H^\"\u0004\u0008\u0000\u0010^2\u0008\u0010Y\u001a\u0004\u0018\u0001H^H\u0000¢\u0006\u0002\u0010a\" \u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005\"(\u0010\u0006\u001a\u001c\u0012\u0012\u0012\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00030\u00080\u0007\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\t\u001a\u0016\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00030\u0008\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\n\u0010\u000b\"\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0005\"\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0005\"\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00030\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u0005\"\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00030\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\" \u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u00084\u0010\u000b\"\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00030\u0001*\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010:\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00030\u0001*\u00020;8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010<\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00030\u0001*\u00020=8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010>\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00030\u0001*\u00020?8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010@\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u0001*\u00020A8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010B\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u0001*\u00020C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010D\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00030\u0001*\u00020E8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010F\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001*\u00020G8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010H\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030\u0001*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010J\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00030\u0001*\u00020K8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010L\"$\u00107\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00030\u0001*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010N\"$\u00107\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u00030\u0001*\u00020O8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010P¨\u0006d", d2 = {"AnnotatedStringSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/AnnotatedString;", "", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "AnnotationRangeListSaver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "BaselineShiftSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "ClickableSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ColorSaver", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "Landroidx/compose/ui/graphics/Color;", "FontWeightSaver", "Landroidx/compose/ui/text/font/FontWeight;", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "LocaleSaver", "Landroidx/compose/ui/text/intl/Locale;", "OffsetSaver", "Landroidx/compose/ui/geometry/Offset;", "ParagraphStyleSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyleSaver", "ShadowSaver", "Landroidx/compose/ui/graphics/Shadow;", "SpanStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyleSaver", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextDecoration;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "TextIndentSaver", "Landroidx/compose/ui/text/style/TextIndent;", "TextLinkStylesSaver", "Landroidx/compose/ui/text/TextLinkStyles;", "getTextLinkStylesSaver", "TextRangeSaver", "Landroidx/compose/ui/text/TextRange;", "TextUnitSaver", "Landroidx/compose/ui/unit/TextUnit;", "UrlAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotationSaver$annotations", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "Saver", "Landroidx/compose/ui/geometry/Offset$Companion;", "getSaver", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "NonNullValueClassSaver", "Original", "Saveable", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "Result", "T", "saver", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "scope", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SaversKt {

    private static final Saver<androidx.compose.ui.text.AnnotatedString, Object> AnnotatedStringSaver;
    private static final Saver<List<androidx.compose.ui.text.AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver;
    private static final Saver<androidx.compose.ui.text.AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver;
    private static final Saver<BaselineShift, Object> BaselineShiftSaver;
    private static final Saver<androidx.compose.ui.text.LinkAnnotation.Clickable, Object> ClickableSaver;
    private static final androidx.compose.ui.text.NonNullValueClassSaver<Color, Object> ColorSaver;
    private static final Saver<FontWeight, Object> FontWeightSaver;
    private static final Saver<androidx.compose.ui.text.LinkAnnotation.Url, Object> LinkSaver;
    private static final Saver<LocaleList, Object> LocaleListSaver;
    private static final Saver<Locale, Object> LocaleSaver;
    private static final androidx.compose.ui.text.NonNullValueClassSaver<Offset, Object> OffsetSaver;
    private static final Saver<androidx.compose.ui.text.ParagraphStyle, Object> ParagraphStyleSaver;
    private static final Saver<Shadow, Object> ShadowSaver;
    private static final Saver<androidx.compose.ui.text.SpanStyle, Object> SpanStyleSaver;
    private static final Saver<TextDecoration, Object> TextDecorationSaver;
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver;
    private static final Saver<TextIndent, Object> TextIndentSaver;
    private static final Saver<androidx.compose.ui.text.TextLinkStyles, Object> TextLinkStylesSaver;
    private static final Saver<androidx.compose.ui.text.TextRange, Object> TextRangeSaver;
    private static final androidx.compose.ui.text.NonNullValueClassSaver<TextUnit, Object> TextUnitSaver;
    private static final Saver<androidx.compose.ui.text.UrlAnnotation, Object> UrlAnnotationSaver;
    private static final Saver<androidx.compose.ui.text.VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver;
    static {
        SaversKt.AnnotatedStringSaver = SaverKt.Saver((Function2)SaversKt.AnnotatedStringSaver.1.INSTANCE, (Function1)SaversKt.AnnotatedStringSaver.2.INSTANCE);
        SaversKt.AnnotationRangeListSaver = SaverKt.Saver((Function2)SaversKt.AnnotationRangeListSaver.1.INSTANCE, (Function1)SaversKt.AnnotationRangeListSaver.2.INSTANCE);
        SaversKt.AnnotationRangeSaver = SaverKt.Saver((Function2)SaversKt.AnnotationRangeSaver.1.INSTANCE, (Function1)SaversKt.AnnotationRangeSaver.2.INSTANCE);
        SaversKt.VerbatimTtsAnnotationSaver = SaverKt.Saver((Function2)SaversKt.VerbatimTtsAnnotationSaver.1.INSTANCE, (Function1)SaversKt.VerbatimTtsAnnotationSaver.2.INSTANCE);
        SaversKt.UrlAnnotationSaver = SaverKt.Saver((Function2)SaversKt.UrlAnnotationSaver.1.INSTANCE, (Function1)SaversKt.UrlAnnotationSaver.2.INSTANCE);
        SaversKt.LinkSaver = SaverKt.Saver((Function2)SaversKt.LinkSaver.1.INSTANCE, (Function1)SaversKt.LinkSaver.2.INSTANCE);
        SaversKt.ClickableSaver = SaverKt.Saver((Function2)SaversKt.ClickableSaver.1.INSTANCE, (Function1)SaversKt.ClickableSaver.2.INSTANCE);
        SaversKt.ParagraphStyleSaver = SaverKt.Saver((Function2)SaversKt.ParagraphStyleSaver.1.INSTANCE, (Function1)SaversKt.ParagraphStyleSaver.2.INSTANCE);
        SaversKt.SpanStyleSaver = SaverKt.Saver((Function2)SaversKt.SpanStyleSaver.1.INSTANCE, (Function1)SaversKt.SpanStyleSaver.2.INSTANCE);
        SaversKt.TextLinkStylesSaver = SaverKt.Saver((Function2)SaversKt.TextLinkStylesSaver.1.INSTANCE, (Function1)SaversKt.TextLinkStylesSaver.2.INSTANCE);
        SaversKt.TextDecorationSaver = SaverKt.Saver((Function2)SaversKt.TextDecorationSaver.1.INSTANCE, (Function1)SaversKt.TextDecorationSaver.2.INSTANCE);
        SaversKt.TextGeometricTransformSaver = SaverKt.Saver((Function2)SaversKt.TextGeometricTransformSaver.1.INSTANCE, (Function1)SaversKt.TextGeometricTransformSaver.2.INSTANCE);
        SaversKt.TextIndentSaver = SaverKt.Saver((Function2)SaversKt.TextIndentSaver.1.INSTANCE, (Function1)SaversKt.TextIndentSaver.2.INSTANCE);
        SaversKt.FontWeightSaver = SaverKt.Saver((Function2)SaversKt.FontWeightSaver.1.INSTANCE, (Function1)SaversKt.FontWeightSaver.2.INSTANCE);
        SaversKt.BaselineShiftSaver = SaverKt.Saver((Function2)SaversKt.BaselineShiftSaver.1.INSTANCE, (Function1)SaversKt.BaselineShiftSaver.2.INSTANCE);
        SaversKt.TextRangeSaver = SaverKt.Saver((Function2)SaversKt.TextRangeSaver.1.INSTANCE, (Function1)SaversKt.TextRangeSaver.2.INSTANCE);
        SaversKt.ShadowSaver = SaverKt.Saver((Function2)SaversKt.ShadowSaver.1.INSTANCE, (Function1)SaversKt.ShadowSaver.2.INSTANCE);
        SaversKt.ColorSaver = SaversKt.NonNullValueClassSaver((Function2)SaversKt.ColorSaver.1.INSTANCE, (Function1)SaversKt.ColorSaver.2.INSTANCE);
        SaversKt.TextUnitSaver = SaversKt.NonNullValueClassSaver((Function2)SaversKt.TextUnitSaver.1.INSTANCE, (Function1)SaversKt.TextUnitSaver.2.INSTANCE);
        SaversKt.OffsetSaver = SaversKt.NonNullValueClassSaver((Function2)SaversKt.OffsetSaver.1.INSTANCE, (Function1)SaversKt.OffsetSaver.2.INSTANCE);
        SaversKt.LocaleListSaver = SaverKt.Saver((Function2)SaversKt.LocaleListSaver.1.INSTANCE, (Function1)SaversKt.LocaleListSaver.2.INSTANCE);
        SaversKt.LocaleSaver = SaverKt.Saver((Function2)SaversKt.LocaleSaver.1.INSTANCE, (Function1)SaversKt.LocaleSaver.2.INSTANCE);
    }

    private static final <Original, Saveable> androidx.compose.ui.text.NonNullValueClassSaver<Original, Saveable> NonNullValueClassSaver(Function2<? super SaverScope, ? super Original, ? extends Saveable> save, Function1<? super Saveable, ? extends Original> restore) {
        SaversKt.NonNullValueClassSaver.1 anon = new SaversKt.NonNullValueClassSaver.1(save, restore);
        return (NonNullValueClassSaver)anon;
    }

    public static final Saver access$getAnnotationRangeListSaver$p() {
        return SaversKt.AnnotationRangeListSaver;
    }

    public static final Saver access$getAnnotationRangeSaver$p() {
        return SaversKt.AnnotationRangeSaver;
    }

    public static final Saver access$getClickableSaver$p() {
        return SaversKt.ClickableSaver;
    }

    public static final Saver access$getLinkSaver$p() {
        return SaversKt.LinkSaver;
    }

    public static final Saver access$getUrlAnnotationSaver$p() {
        return SaversKt.UrlAnnotationSaver;
    }

    public static final Saver access$getVerbatimTtsAnnotationSaver$p() {
        return SaversKt.VerbatimTtsAnnotationSaver;
    }

    public static final Saver<androidx.compose.ui.text.AnnotatedString, Object> getAnnotatedStringSaver() {
        return SaversKt.AnnotatedStringSaver;
    }

    private static void getAnnotationRangeSaver$annotations() {
    }

    public static final Saver<androidx.compose.ui.text.ParagraphStyle, Object> getParagraphStyleSaver() {
        return SaversKt.ParagraphStyleSaver;
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion $this$Saver) {
        return (Saver)SaversKt.OffsetSaver;
    }

    public static final Saver<Color, Object> getSaver(Color.Companion $this$Saver) {
        return (Saver)SaversKt.ColorSaver;
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion $this$Saver) {
        return SaversKt.ShadowSaver;
    }

    public static final Saver<androidx.compose.ui.text.TextRange, Object> getSaver(androidx.compose.ui.text.TextRange.Companion $this$Saver) {
        return SaversKt.TextRangeSaver;
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion $this$Saver) {
        return SaversKt.FontWeightSaver;
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion $this$Saver) {
        return SaversKt.LocaleSaver;
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion $this$Saver) {
        return SaversKt.LocaleListSaver;
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion $this$Saver) {
        return SaversKt.BaselineShiftSaver;
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion $this$Saver) {
        return SaversKt.TextDecorationSaver;
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion $this$Saver) {
        return SaversKt.TextGeometricTransformSaver;
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion $this$Saver) {
        return SaversKt.TextIndentSaver;
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion $this$Saver) {
        return (Saver)SaversKt.TextUnitSaver;
    }

    public static final Saver<androidx.compose.ui.text.SpanStyle, Object> getSpanStyleSaver() {
        return SaversKt.SpanStyleSaver;
    }

    public static final Saver<androidx.compose.ui.text.TextLinkStyles, Object> getTextLinkStylesSaver() {
        return SaversKt.TextLinkStylesSaver;
    }

    private static void getUrlAnnotationSaver$annotations() {
    }

    public static final <Result> Result restore(Object value) {
        int i2;
        int i3;
        int i;
        String str;
        final int i4 = 0;
        if (value != null) {
            i2 = value;
            i3 = 0;
            Intrinsics.reifiedOperationMarker(1, "Result");
        } else {
            i2 = 0;
        }
        return i2;
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable value, T saver) {
        boolean equal;
        int i;
        Object $this$restore_u24lambda_u243_u24lambda_u242;
        Object obj;
        String str;
        final int i2 = 0;
        if (Intrinsics.areEqual(value, false) && !saver instanceof NonNullValueClassSaver) {
            if (!saver instanceof NonNullValueClassSaver) {
                return 0;
            }
        }
        if (value != null) {
            equal = value;
            int i4 = 0;
            int i5 = 0;
            $this$restore_u24lambda_u243_u24lambda_u242 = (Saver)saver.restore(value);
            Intrinsics.reifiedOperationMarker(1, "Result");
            obj = $this$restore_u24lambda_u243_u24lambda_u242;
            i = $this$restore_u24lambda_u243_u24lambda_u242;
        }
        return i;
    }

    public static final <T> T save(T value) {
        return value;
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original value, T saver, SaverScope scope) {
        int i;
        int i2;
        Object $this$save_u24lambda_u241_u24lambda_u240;
        int i3;
        if (value != null) {
            i = value;
            i2 = 0;
            i3 = 0;
            if (saver.save(scope, value) == null) {
                $this$save_u24lambda_u241_u24lambda_u240 = false;
            }
        } else {
        }
        return $this$save_u24lambda_u241_u24lambda_u240;
    }
}
