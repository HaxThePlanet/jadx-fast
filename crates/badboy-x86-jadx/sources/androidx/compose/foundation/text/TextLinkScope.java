package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIcon.Companion;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Builder;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkAnnotation.Url;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SpreadBuilder;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0011\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u001e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001fJ>\u0010 \u001a\u00020\t2\u0016\u0010!\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00010\"\"\u0004\u0018\u00010\u00012\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\nH\u0003¢\u0006\u0002\u0010$J\r\u0010%\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0008&J\u0018\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u001c\u0010,\u001a\u0004\u0018\u00010-2\u0010\u0010.\u001a\u000c\u0012\u0004\u0012\u00020)0/j\u0002`0H\u0002J\u001c\u00101\u001a\u0004\u0018\u0001022\u0010\u0010.\u001a\u000c\u0012\u0004\u0012\u00020)0/j\u0002`0H\u0002J\u001a\u00103\u001a\u0004\u0018\u000104*\u0004\u0018\u0001042\u0008\u00105\u001a\u0004\u0018\u000104H\u0002J\u001c\u00106\u001a\u000207*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0002R%\u0010\u0005\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u000c\"\u0004\u0008\u0014\u0010\u0004R/\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001b¨\u0006;²\u0006\n\u0010<\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010=\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u0010>\u001a\u00020\u000fX\u008a\u0084\u0002", d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "Lkotlin/ExtensionFunctionType;", "getInitialText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "shouldMeasureLinks", "Lkotlin/Function0;", "", "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "text", "getText$foundation_release", "setText$foundation_release", "<set-?>", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "StyleAnnotation", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "applyAnnotators", "applyAnnotators$foundation_release", "handleLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "uriHandler", "Landroidx/compose/ui/platform/UriHandler;", "pathForRangeInRangeCoordinates", "Landroidx/compose/ui/graphics/Path;", "range", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/foundation/text/LinkRange;", "shapeForRange", "Landroidx/compose/ui/graphics/Shape;", "mergeOrUse", "Landroidx/compose/ui/text/SpanStyle;", "other", "textRange", "Landroidx/compose/ui/Modifier;", "start", "", "end", "foundation_release", "isHovered", "isFocused", "isPressed"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextLinkScope {

    public static final int $stable = 8;
    private final SnapshotStateList<Function1<androidx.compose.foundation.text.TextAnnotatorScope, Unit>> annotators;
    private final AnnotatedString initialText;
    private AnnotatedString text;
    private final MutableState textLayoutResult$delegate;
    public static androidx.compose.foundation.text.TextRangeLayoutMeasureResult $r8$lambda$wUliv7MpU312Vdu_yMFwbwK7l9M(androidx.compose.foundation.text.TextLinkScope textLinkScope, int i2, int i3, androidx.compose.foundation.text.TextRangeLayoutMeasureScope textRangeLayoutMeasureScope4) {
        return TextLinkScope.textRange$lambda$3(textLinkScope, i2, i3, textRangeLayoutMeasureScope4);
    }

    static {
        final int i = 8;
    }

    public TextLinkScope(AnnotatedString initialText) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        TextLinkStyles styles;
        int i2;
        int start;
        int end;
        super();
        this.initialText = initialText;
        int i3 = 0;
        this.textLayoutResult$delegate = SnapshotStateKt.mutableStateOf$default(i3, i3, 2, i3);
        AnnotatedString.Builder builder = new AnnotatedString.Builder(this.initialText);
        final int i5 = 0;
        List linkAnnotations = this.initialText.getLinkAnnotations(0, this.initialText.length());
        int i6 = 0;
        index$iv = 0;
        while (index$iv < linkAnnotations.size()) {
            obj2 = obj;
            i = 0;
            styles = (LinkAnnotation)(AnnotatedString.Range)obj2.getItem().getStyles();
            styles = styles.getStyle();
            if (styles != null && styles != null) {
            }
            index$iv++;
            styles = styles.getStyle();
            if (styles != null) {
            }
            i2 = 0;
            builder.addStyle(styles, obj2.getStart(), obj2.getEnd());
        }
        this.text = builder.toAnnotatedString();
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    private static final boolean LinksComposables$lambda$13$lambda$10(State<Boolean> $isFocused$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$isFocused$delegate.getValue().booleanValue();
    }

    private static final boolean LinksComposables$lambda$13$lambda$11(State<Boolean> $isPressed$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$isPressed$delegate.getValue().booleanValue();
    }

    private static final boolean LinksComposables$lambda$13$lambda$9(State<Boolean> $isHovered$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$isHovered$delegate.getValue().booleanValue();
    }

    private final void StyleAnnotation(Object[] keys, Function1<? super androidx.compose.foundation.text.TextAnnotatorScope, Unit> block, Composer $composer, int $changed) {
        boolean traceInProgress2;
        int $dirty;
        int i4;
        int i6;
        int skipping;
        boolean traceInProgress;
        int i3;
        Composer i2;
        int i5;
        int str;
        Object rememberedValue;
        int i;
        Object empty;
        Object anon;
        traceInProgress2 = -2083052099;
        final Composer obj13 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj13, "C(StyleAnnotation)P(1)238@10311L117,238@10280L148:TextLinkScope.kt#423gt5");
        i2 = 32;
        if ($changed & 48 == 0) {
            i4 = obj13.changedInstance(block) ? i2 : 16;
            $dirty |= i4;
        }
        if ($changed & 384 == 0) {
            i6 = obj13.changedInstance(this) ? 256 : 128;
            $dirty |= i6;
        }
        obj13.startMovableGroup(-416717687, Integer.valueOf(keys.length));
        int i11 = 0;
        i5 = i11;
        while (i5 < keys.length) {
            if (obj13.changedInstance(keys[i5])) {
            } else {
            }
            i = i11;
            $dirty |= i;
            i5++;
            i = 4;
        }
        obj13.endMovableGroup();
        if ($dirty & 14 == 0) {
            $dirty |= 2;
        }
        if ($dirty & 147 == 146) {
            if (!obj13.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:237)");
                }
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(block);
                spreadBuilder.addSpread(keys);
                ComposerKt.sourceInformationMarkerStart(obj13, -416714451, "CC(remember):TextLinkScope.kt#9igjgp");
                i3 = $dirty & 112 == i2 ? 1 : i11;
                i2 = obj13;
                str = 0;
                rememberedValue = i2.rememberedValue();
                i = 0;
                if (changedInstance2 |= i3 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new TextLinkScope.StyleAnnotation.1.1(this, block);
                        i2.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj13);
                EffectsKt.DisposableEffect(spreadBuilder.toArray(new Object[spreadBuilder.size()]), (Function1)anon, obj13, i11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj13.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj13.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new TextLinkScope.StyleAnnotation.2(this, keys, block, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final boolean access$LinksComposables$lambda$13$lambda$10(State $isFocused$delegate) {
        return TextLinkScope.LinksComposables$lambda$13$lambda$10($isFocused$delegate);
    }

    public static final boolean access$LinksComposables$lambda$13$lambda$11(State $isPressed$delegate) {
        return TextLinkScope.LinksComposables$lambda$13$lambda$11($isPressed$delegate);
    }

    public static final boolean access$LinksComposables$lambda$13$lambda$9(State $isHovered$delegate) {
        return TextLinkScope.LinksComposables$lambda$13$lambda$9($isHovered$delegate);
    }

    public static final void access$StyleAnnotation(androidx.compose.foundation.text.TextLinkScope $this, Object[] keys, Function1 block, Composer $composer, int $changed) {
        $this.StyleAnnotation(keys, block, $composer, $changed);
    }

    public static final SnapshotStateList access$getAnnotators$p(androidx.compose.foundation.text.TextLinkScope $this) {
        return $this.annotators;
    }

    public static final void access$handleLink(androidx.compose.foundation.text.TextLinkScope $this, LinkAnnotation link, UriHandler uriHandler) {
        $this.handleLink(link, uriHandler);
    }

    public static final SpanStyle access$mergeOrUse(androidx.compose.foundation.text.TextLinkScope $this, SpanStyle $receiver, SpanStyle other) {
        return $this.mergeOrUse($receiver, other);
    }

    private final void handleLink(LinkAnnotation link, UriHandler uriHandler) {
        boolean linkInteractionListener;
        if (link instanceof LinkAnnotation.Url) {
            LinkInteractionListener linkInteractionListener2 = link.getLinkInteractionListener();
            linkInteractionListener = linkInteractionListener2 != null ? Unit.INSTANCE : 0;
            if (linkInteractionListener == null) {
                uriHandler.openUri((LinkAnnotation.Url)link.getUrl());
            }
        } else {
            linkInteractionListener = link.getLinkInteractionListener();
            if (link instanceof LinkAnnotation.Clickable && linkInteractionListener != null) {
                linkInteractionListener = link.getLinkInteractionListener();
                if (linkInteractionListener != null) {
                    linkInteractionListener.onClick(link);
                }
            }
        }
    }

    private final SpanStyle mergeOrUse(SpanStyle $this$mergeOrUse, SpanStyle other) {
        SpanStyle merge;
        if ($this$mergeOrUse != null) {
            if ($this$mergeOrUse.merge(other) == null) {
                merge = other;
            }
        } else {
        }
        return merge;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> range) {
        TextLayoutResult textLayoutResult;
        int i;
        float left;
        if (!(Boolean)getShouldMeasureLinks().invoke().booleanValue()) {
        } else {
            textLayoutResult = getTextLayoutResult();
            if (textLayoutResult != null) {
                final int i3 = 0;
                Path pathForRange = textLayoutResult.getPathForRange(range.getStart(), range.getEnd());
                Rect boundingBox = textLayoutResult.getBoundingBox(range.getStart());
                if (textLayoutResult.getLineForOffset(range.getStart()) == textLayoutResult.getLineForOffset(range.getEnd())) {
                    i = Math.min(textLayoutResult.getBoundingBox(end2--).getLeft(), boundingBox.getLeft());
                } else {
                    i = 0;
                }
                pathForRange.translate-k-4lQ0M(Offset.unaryMinus-F1C5BW0(OffsetKt.Offset(i, boundingBox.getTop())));
                return pathForRange;
            }
        }
        return null;
    }

    private final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> range) {
        int i;
        androidx.compose.foundation.text.TextLinkScope.shapeForRange.1.1 anon;
        final Path pathForRangeInRangeCoordinates = pathForRangeInRangeCoordinates(range);
        if (pathForRangeInRangeCoordinates != null) {
            i = 0;
            anon = new TextLinkScope.shapeForRange.1.1(pathForRangeInRangeCoordinates);
        } else {
            anon = 0;
        }
        return (Shape)anon;
    }

    private final Modifier textRange(Modifier $this$textRange, int start, int end) {
        TextLinkScope$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new TextLinkScope$$ExternalSyntheticLambda0(this, start, end);
        TextRangeLayoutModifier textRangeLayoutModifier = new TextRangeLayoutModifier(externalSyntheticLambda0);
        return $this$textRange.then((Modifier)textRangeLayoutModifier);
    }

    private static final androidx.compose.foundation.text.TextRangeLayoutMeasureResult textRange$lambda$3(androidx.compose.foundation.text.TextLinkScope this$0, int $start, int $end, androidx.compose.foundation.text.TextRangeLayoutMeasureScope $this$$receiver) {
        TextLayoutResult textLayoutResult = this$0.getTextLayoutResult();
        if (textLayoutResult == null) {
            int i = 0;
            return $this$$receiver.layout(i, i, (Function0)TextLinkScope.textRange.1.layoutResult.1.INSTANCE);
        }
        IntRect roundToIntRect = IntRectKt.roundToIntRect(textLayoutResult.getPathForRange($start, $end).getBounds());
        TextLinkScope.textRange.1.1 anon = new TextLinkScope.textRange.1.1(roundToIntRect);
        return $this$$receiver.layout(roundToIntRect.getWidth(), roundToIntRect.getHeight(), (Function0)anon);
    }

    public final void LinksComposables(Composer $composer, int $changed) {
        int i8;
        Composer index$iv2;
        Object invalid$iv;
        Object anon;
        Object collectIsHoveredAsState;
        int traceInProgress2;
        int $dirty2;
        int $dirty3;
        boolean traceInProgress;
        int it;
        Object isPressed$delegate;
        String $this$cache$iv;
        int i2;
        Composer it$iv;
        int i9;
        Object $dirty;
        Object styles;
        Object focusedStyle;
        Object hoveredStyle;
        Object pressedStyle;
        Object obj5;
        int i;
        Object obj;
        List linkAnnotations;
        List list;
        int i11;
        int size;
        Object obj2;
        int i3;
        Shape shapeForRange;
        int i4;
        androidx.compose.ui.Modifier.Companion isFocused$delegate;
        int i10;
        int i7;
        int companion;
        int index$iv;
        Composer.Companion pointerHoverIcon$default;
        Object obj4;
        Object isHovered$delegate;
        State isHovered$delegate2;
        Boolean valueOf2;
        Boolean valueOf;
        SpanStyle spanStyle4;
        SpanStyle spanStyle;
        SpanStyle spanStyle3;
        SpanStyle spanStyle2;
        Object obj3;
        int i5;
        int i6;
        Composer composer;
        int obj37;
        final Object obj7 = this;
        final int i24 = $changed;
        traceInProgress2 = 1154651354;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(LinksComposables)153@6783L7,*159@7046L39,169@7474L38,161@7099L449,173@7597L25,174@7670L25,175@7743L25,185@8083L743,177@7782L1044:TextLinkScope.kt#423gt5");
        i2 = 2;
        if (i24 & 6 == 0) {
            it = restartGroup.changedInstance(obj7) ? 4 : i2;
            $dirty2 |= it;
        }
        i9 = $dirty2;
        if (i9 & 3 == i2) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i9, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:152)");
                }
                int i16 = 0;
                it = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj5 = isPressed$delegate;
                list = linkAnnotations;
                i11 = 0;
                i8 = 0;
                while (i8 < list.size()) {
                    $dirty3 = obj2;
                    i3 = 0;
                    shapeForRange = obj7.shapeForRange((AnnotatedString.Range)$dirty3);
                    if (shapeForRange != null) {
                    } else {
                    }
                    it = Modifier.Companion;
                    String str2 = "CC(remember):TextLinkScope.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -371005797, str2);
                    int i19 = 0;
                    obj37 = restartGroup;
                    int i34 = 0;
                    Object rememberedValue = obj37.rememberedValue();
                    companion = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    } else {
                    }
                    index$iv = i8;
                    index$iv2 = obj37;
                    obj = rememberedValue;
                    Object $this$cache$iv2 = obj;
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i25 = 0;
                    obj37 = i9;
                    $dirty = 2;
                    int i29 = 0;
                    obj4 = $this$cache$iv2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -370992102, str2);
                    i13 |= changedInstance3;
                    Composer composer2 = restartGroup;
                    int i30 = 0;
                    Object rememberedValue2 = composer2.rememberedValue();
                    int i35 = 0;
                    if (i14 == 0) {
                    } else {
                    }
                    $dirty = 0;
                    i7 = i14;
                    invalid$iv = new TextLinkScope.LinksComposables.1.1.1(obj7, $dirty3, obj5);
                    composer2.updateRememberedValue((Function0)invalid$iv);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    BoxKt.Box(ClickableKt.combinedClickable-XVZzFYc$default(PointerIconKt.pointerHoverIcon$default(HoverableKt.hoverable$default(obj7.textRange(it, $dirty3.getStart(), $dirty3.getEnd()), (MutableInteractionSource)$this$cache$iv2, i29, $dirty, i25), PointerIcon.Companion.getHand(), i29, $dirty, i25), obj4, 0, false, 0, 0, 0, 0, 0, (Function0)invalid$iv, 252, 0), restartGroup, 0);
                    int i20 = 6;
                    collectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState((InteractionSource)obj4, restartGroup, i20);
                    State collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState((InteractionSource)obj4, restartGroup, i20);
                    State collectIsPressedAsState = PressInteractionKt.collectIsPressedAsState((InteractionSource)obj4, restartGroup, i20);
                    styles = (LinkAnnotation)$dirty3.getItem().getStyles();
                    if (styles != null) {
                    } else {
                    }
                    spanStyle4 = 0;
                    focusedStyle = (LinkAnnotation)$dirty3.getItem().getStyles();
                    if (focusedStyle != null) {
                    } else {
                    }
                    spanStyle = 0;
                    hoveredStyle = (LinkAnnotation)$dirty3.getItem().getStyles();
                    if (hoveredStyle != null) {
                    } else {
                    }
                    spanStyle3 = 0;
                    pressedStyle = (LinkAnnotation)$dirty3.getItem().getStyles();
                    if (pressedStyle != null) {
                    } else {
                    }
                    spanStyle2 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -370971909, str2);
                    Composer composer3 = restartGroup;
                    i4 = 0;
                    State state2 = collectIsFocusedAsState;
                    Object rememberedValue3 = composer3.rememberedValue();
                    i10 = 0;
                    if (changed5 |= i23 == 0) {
                    } else {
                    }
                    isHovered$delegate2 = collectIsHoveredAsState;
                    pointerHoverIcon$default = 0;
                    isFocused$delegate = it;
                    isHovered$delegate = rememberedValue3;
                    anon = new TextLinkScope.LinksComposables.1.2.1(obj7, $dirty3, state2, isHovered$delegate2, collectIsPressedAsState);
                    composer3.updateRememberedValue((Function1)anon);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj7.StyleAnnotation(/* result */, (Function1)anon, restartGroup, i26 &= 896);
                    i8 = index$iv + 1;
                    i9 = obj37;
                    i2 = 2;
                    i = 0;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    } else {
                    }
                    isFocused$delegate = it;
                    it = state;
                    it$iv = composer3;
                    $this$cache$iv = collectIsPressedAsState;
                    isPressed$delegate = isHovered$delegate2;
                    isHovered$delegate = anon;
                    spanStyle2 = pressedStyle;
                    spanStyle3 = hoveredStyle;
                    spanStyle = focusedStyle;
                    spanStyle4 = styles;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    } else {
                    }
                    i7 = i14;
                    invalid$iv = rememberedValue2;
                    int i28 = 0;
                    index$iv = i8;
                    obj37.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    isPressed$delegate = 0;
                    if (ClipKt.clip((Modifier)Modifier.Companion, shapeForRange) == null) {
                    }
                }
                index$iv = i8;
                obj37 = i9;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj37 = i9;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = new TextLinkScope.LinksComposables.2(obj7, i24);
            endRestartGroup.updateScope((Function2)$dirty3);
        }
    }

    public final AnnotatedString applyAnnotators$foundation_release() {
        AnnotatedString $i$f$buildAnnotatedString;
        AnnotatedString annotatedString;
        AnnotatedString.Builder str;
        int i;
        androidx.compose.foundation.text.TextAnnotatorScope textAnnotatorScope;
        SnapshotStateList annotators;
        int i3;
        int index$iv;
        int size;
        Object obj;
        Object obj2;
        int i2;
        if (this.annotators.isEmpty()) {
            $i$f$buildAnnotatedString = this.text;
        } else {
            int i4 = 0;
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, 0);
            str = builder;
            i = 0;
            str.append(this.initialText);
            textAnnotatorScope = new TextAnnotatorScope(str);
            annotators = this.annotators;
            i3 = 0;
            index$iv = 0;
            while (index$iv < (List)annotators.size()) {
                i2 = 0;
                (Function1)annotators.get(index$iv).invoke(textAnnotatorScope);
                index$iv++;
            }
            $i$f$buildAnnotatedString = annotatedString;
        }
        this.text = $i$f$buildAnnotatedString;
        return $i$f$buildAnnotatedString;
    }

    public final AnnotatedString getInitialText$foundation_release() {
        return this.initialText;
    }

    public final Function0<Boolean> getShouldMeasureLinks() {
        TextLinkScope.shouldMeasureLinks.1 anon = new TextLinkScope.shouldMeasureLinks.1(this);
        return (Function0)anon;
    }

    public final AnnotatedString getText$foundation_release() {
        return this.text;
    }

    public final TextLayoutResult getTextLayoutResult() {
        final int i = 0;
        final int i2 = 0;
        return (TextLayoutResult)(State)this.textLayoutResult$delegate.getValue();
    }

    public final void setText$foundation_release(AnnotatedString <set-?>) {
        this.text = <set-?>;
    }

    public final void setTextLayoutResult(TextLayoutResult <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.textLayoutResult$delegate.setValue(<set-?>);
    }
}
