package androidx.compose.foundation.text;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Range;
import androidx.compose.ui.text.Placeholder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a>\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\r2'\u0010\u000e\u001a#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006¢\u0006\u0002\u0008\t0\u0003j\u0002`\n0\u0002H\u0001¢\u0006\u0002\u0010\u000f\u001a\u000c\u0010\u0010\u001a\u00020\u0011*\u00020\rH\u0000\u001a_\u0010\u0012\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\u000c\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006¢\u0006\u0002\u0008\t0\u0003j\u0002`\n0\u00020\u0001*\u00020\r2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0000\"K\u0010\u0000\u001a?\u0012\u0014\u0012\u0012\u0012\u000e\u0012\u000c\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u0002\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006¢\u0006\u0002\u0008\t0\u0003j\u0002`\n0\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*:\u0008\u0000\u0010\u0016\"\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006¢\u0006\u0002\u0008\t0\u00032\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006¢\u0006\u0002\u0008\t0\u0003*\u0018\u0008\u0000\u0010\u0017\"\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0018", d2 = {"EmptyInlineContent", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "Landroidx/compose/foundation/text/PlaceholderRange;", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/foundation/text/InlineContentRange;", "InlineChildren", "text", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContents", "(Landroidx/compose/ui/text/AnnotatedString;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "hasInlineContent", "", "resolveInlineContent", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "InlineContentRange", "PlaceholderRange", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnnotatedStringResolveInlineContentKt {

    private static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> EmptyInlineContent;
    static {
        Pair pair = new Pair(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        AnnotatedStringResolveInlineContentKt.EmptyInlineContent = pair;
    }

    public static final void InlineChildren(AnnotatedString text, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> inlineContents, Composer $composer, int $changed) {
        Object obj2;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        int traceInProgress;
        Composer restartGroup;
        int $dirty;
        Object currentCompositionLocalMap;
        Composer composer3;
        int i11;
        int i14;
        int skipping;
        boolean traceInProgress2;
        int str;
        int size;
        Object obj;
        int component3;
        int i;
        Object component1;
        int component2;
        androidx.compose.foundation.text.AnnotatedStringResolveInlineContentKt.InlineChildren.1.2 iNSTANCE;
        int i3;
        int i15;
        int i7;
        int i2;
        int currentCompositeKeyHash;
        int i10;
        int i4;
        int i13;
        androidx.compose.ui.Modifier.Companion companion;
        int i5;
        int i12;
        int i9;
        int i6;
        kotlin.jvm.functions.Function0 function0;
        Composer composer2;
        int i8;
        Composer $composer2;
        Composer composer;
        androidx.compose.runtime.CompositionLocalMap map;
        Object obj34;
        final Object obj3 = text;
        final Object obj4 = inlineContents;
        final int i16 = $changed;
        traceInProgress = -1794596951;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(InlineChildren)P(1)*75@2735L356:AnnotatedStringResolveInlineContent.kt#423gt5");
        if (i16 & 6 == 0) {
            i11 = restartGroup.changed(obj3) ? 4 : 2;
            $dirty |= i11;
        }
        if (i16 & 48 == 0) {
            i14 = restartGroup.changedInstance(obj4) ? 32 : 16;
            $dirty |= i14;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.foundation.text.InlineChildren (AnnotatedStringResolveInlineContent.kt:73)");
                }
                skipping = 0;
                str = 0;
                while (str < inlineContents.size()) {
                    Object obj6 = obj;
                    i = 0;
                    i15 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    androidx.compose.ui.Modifier.Companion companion2 = Modifier.Companion;
                    int i21 = 0;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i21);
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    companion = companion2;
                    kotlin.jvm.functions.Function0 function02 = constructor;
                    i13 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier instanceof Applier) {
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                    } else {
                    }
                    factory$iv$iv = function02;
                    restartGroup.useNode();
                    Composer constructor-impl = Updater.constructor-impl(restartGroup);
                    int i24 = 0;
                    function0 = factory$iv$iv;
                    Updater.set-impl(constructor-impl, (MeasurePolicy)AnnotatedStringResolveInlineContentKt.InlineChildren.1.2.INSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    i6 = 0;
                    composer2 = constructor-impl;
                    i8 = 0;
                    if (!composer2.getInserting()) {
                    } else {
                    }
                    $composer2 = restartGroup;
                    map = currentCompositionLocalMap;
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)companion2), ComposeUiNode.Companion.getSetModifier());
                    restartGroup = $composer2;
                    int i22 = 0;
                    i5 = i20;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 256183196, "C76@2767L42:AnnotatedStringResolveInlineContent.kt#423gt5");
                    (Function3)(AnnotatedString.Range)obj6.component1().invoke(obj3.subSequence(obj6.component2(), obj6.component3()).getText(), restartGroup, Integer.valueOf(i21));
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    str = i9 + 1;
                    obj2 = obj34;
                    $dirty = i7;
                    skipping = i4;
                    $composer2 = restartGroup;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    } else {
                    }
                    composer3 = composer2;
                    restartGroup.createNode(function02);
                    ComposablesKt.invalidApplier();
                }
                obj34 = obj2;
                composer = restartGroup;
                i2 = $dirty;
                i4 = skipping;
                i9 = str;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                i2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new AnnotatedStringResolveInlineContentKt.InlineChildren.2(obj3, obj4, i16);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    public static final boolean hasInlineContent(AnnotatedString $this$hasInlineContent) {
        return $this$hasInlineContent.hasStringAnnotations("androidx.compose.foundation.text.inlineContent", 0, $this$hasInlineContent.getText().length());
    }

    public static final Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent(AnnotatedString $this$resolveInlineContent, Map<String, androidx.compose.foundation.text.InlineTextContent> inlineContent) {
        AnnotatedString.Range range;
        List stringAnnotations;
        int i;
        boolean empty;
        int index$iv;
        Object obj2;
        Object obj;
        int i3;
        Object obj3;
        int i2;
        int start;
        int end;
        List inlineContentAnnotations;
        range = inlineContent;
        int i4 = 0;
        if (range != null) {
            if (range.isEmpty()) {
                i = 1;
            } else {
                i = i4;
            }
        } else {
        }
        if (i != 0) {
            return AnnotatedStringResolveInlineContentKt.EmptyInlineContent;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final List list = stringAnnotations;
        final int i5 = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            obj = obj2;
            i3 = 0;
            obj3 = range.get((AnnotatedString.Range)obj.getItem());
            if ((InlineTextContent)obj3 != null) {
            } else {
            }
            inlineContentAnnotations = stringAnnotations;
            index$iv++;
            range = inlineContent;
            stringAnnotations = inlineContentAnnotations;
            i2 = 0;
            inlineContentAnnotations = stringAnnotations;
            AnnotatedString.Range range2 = new AnnotatedString.Range((InlineTextContent)obj3.getPlaceholder(), obj.getStart(), obj.getEnd());
            (List)arrayList.add(range2);
            range = new AnnotatedString.Range(obj3.getChildren(), obj.getStart(), obj.getEnd());
            (List)arrayList2.add(range);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }
}
