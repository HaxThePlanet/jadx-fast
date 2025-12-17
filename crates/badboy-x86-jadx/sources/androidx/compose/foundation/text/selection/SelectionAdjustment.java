package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008à\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "", "adjust", "Landroidx/compose/foundation/text/selection/Selection;", "layout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SelectionAdjustment {

    public static final androidx.compose.foundation.text.selection.SelectionAdjustment.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0006¨\u0006\u000f", d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment$Companion;", "", "()V", "Character", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getCharacter", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "CharacterWithWordAccelerate", "getCharacterWithWordAccelerate", "None", "getNone", "Paragraph", "getParagraph", "Word", "getWord", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.text.selection.SelectionAdjustment.Companion $$INSTANCE;
        private static final androidx.compose.foundation.text.selection.SelectionAdjustment Character;
        private static final androidx.compose.foundation.text.selection.SelectionAdjustment CharacterWithWordAccelerate;
        private static final androidx.compose.foundation.text.selection.SelectionAdjustment None;
        private static final androidx.compose.foundation.text.selection.SelectionAdjustment Paragraph;
        private static final androidx.compose.foundation.text.selection.SelectionAdjustment Word;
        public static androidx.compose.foundation.text.selection.Selection $r8$lambda$AWpmyDzIev2eUSauuOHmkBKPUBk(androidx.compose.foundation.text.selection.SelectionLayout selectionLayout) {
            return SelectionAdjustment.Companion.Word$lambda$2(selectionLayout);
        }

        public static androidx.compose.foundation.text.selection.Selection $r8$lambda$Ox7P1yEWql18OM6F5c46eijWYEM(androidx.compose.foundation.text.selection.SelectionLayout selectionLayout) {
            return SelectionAdjustment.Companion.Paragraph$lambda$3(selectionLayout);
        }

        public static androidx.compose.foundation.text.selection.Selection $r8$lambda$Ufk7ob1nuileJckTRSHYkxGsAzo(androidx.compose.foundation.text.selection.SelectionLayout selectionLayout) {
            return SelectionAdjustment.Companion.CharacterWithWordAccelerate$lambda$4(selectionLayout);
        }

        public static androidx.compose.foundation.text.selection.Selection $r8$lambda$kXhnWLiofEAGpWtFpHqUcdmpuMo(androidx.compose.foundation.text.selection.SelectionLayout selectionLayout) {
            return SelectionAdjustment.Companion.None$lambda$0(selectionLayout);
        }

        public static androidx.compose.foundation.text.selection.Selection $r8$lambda$p-Wpw4B2bzF0kcpUeT99oOWwRiE(androidx.compose.foundation.text.selection.SelectionLayout selectionLayout) {
            return SelectionAdjustment.Companion.Character$lambda$1(selectionLayout);
        }

        static {
            SelectionAdjustment.Companion companion = new SelectionAdjustment.Companion();
            SelectionAdjustment.Companion.$$INSTANCE = companion;
            SelectionAdjustment.Companion$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SelectionAdjustment.Companion$$ExternalSyntheticLambda0();
            SelectionAdjustment.Companion.None = externalSyntheticLambda0;
            SelectionAdjustment.Companion$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new SelectionAdjustment.Companion$$ExternalSyntheticLambda1();
            SelectionAdjustment.Companion.Character = externalSyntheticLambda1;
            SelectionAdjustment.Companion$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new SelectionAdjustment.Companion$$ExternalSyntheticLambda2();
            SelectionAdjustment.Companion.Word = externalSyntheticLambda2;
            SelectionAdjustment.Companion$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new SelectionAdjustment.Companion$$ExternalSyntheticLambda3();
            SelectionAdjustment.Companion.Paragraph = externalSyntheticLambda3;
            SelectionAdjustment.Companion$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new SelectionAdjustment.Companion$$ExternalSyntheticLambda4();
            SelectionAdjustment.Companion.CharacterWithWordAccelerate = externalSyntheticLambda4;
        }

        private static final androidx.compose.foundation.text.selection.Selection Character$lambda$1(androidx.compose.foundation.text.selection.SelectionLayout layout) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(SelectionAdjustment.Companion.None.adjust(layout), layout);
        }

        private static final androidx.compose.foundation.text.selection.Selection CharacterWithWordAccelerate$lambda$4(androidx.compose.foundation.text.selection.SelectionLayout layout) {
            androidx.compose.foundation.text.selection.Selection.AnchorInfo previousAnchor;
            androidx.compose.foundation.text.selection.Selection.AnchorInfo newAnchor;
            androidx.compose.foundation.text.selection.Selection.AnchorInfo startAnchor;
            androidx.compose.foundation.text.selection.Selection.AnchorInfo endAnchor;
            androidx.compose.foundation.text.selection.SelectableInfo startInfo;
            boolean equal;
            androidx.compose.foundation.text.selection.CrossStatus crossStatus;
            androidx.compose.foundation.text.selection.Selection ensureAtLeastOneChar;
            androidx.compose.foundation.text.selection.CrossStatus cOLLAPSED;
            androidx.compose.foundation.text.selection.Selection previousSelection = layout.getPreviousSelection();
            if (previousSelection == null) {
                return SelectionAdjustment.Companion.Word.adjust(layout);
            }
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            if (layout.isStartHandle()) {
                startAnchor = newAnchor;
                endAnchor = previousSelection.getEnd();
            } else {
                startAnchor = previousSelection.getStart();
                endAnchor = newAnchor;
            }
            if (Intrinsics.areEqual(newAnchor, previousAnchor)) {
                ensureAtLeastOneChar = previousSelection;
            } else {
                if (layout.getCrossStatus() != CrossStatus.CROSSED) {
                    if (layout.getCrossStatus() == CrossStatus.COLLAPSED && startAnchor.getOffset() > endAnchor.getOffset()) {
                        if (startAnchor.getOffset() > endAnchor.getOffset()) {
                            equal = 1;
                        } else {
                            equal = 0;
                        }
                    } else {
                    }
                } else {
                }
                Selection selection = new Selection(startAnchor, endAnchor, equal);
                ensureAtLeastOneChar = SelectionAdjustmentKt.ensureAtLeastOneChar(selection, layout);
            }
            return ensureAtLeastOneChar;
        }

        private static final androidx.compose.foundation.text.selection.Selection None$lambda$0(androidx.compose.foundation.text.selection.SelectionLayout layout) {
            int i;
            i = layout.getCrossStatus() == CrossStatus.CROSSED ? 1 : 0;
            Selection selection = new Selection(layout.getStartInfo().anchorForOffset(layout.getStartInfo().getRawStartHandleOffset()), layout.getEndInfo().anchorForOffset(layout.getEndInfo().getRawEndHandleOffset()), i);
            return selection;
        }

        private static final androidx.compose.foundation.text.selection.Selection Paragraph$lambda$3(androidx.compose.foundation.text.selection.SelectionLayout layout) {
            return SelectionAdjustmentKt.access$adjustToBoundaries(layout, (BoundaryFunction)SelectionAdjustment.Companion.Paragraph.1.1.INSTANCE);
        }

        private static final androidx.compose.foundation.text.selection.Selection Word$lambda$2(androidx.compose.foundation.text.selection.SelectionLayout layout) {
            return SelectionAdjustmentKt.access$adjustToBoundaries(layout, (BoundaryFunction)SelectionAdjustment.Companion.Word.1.1.INSTANCE);
        }

        public final androidx.compose.foundation.text.selection.SelectionAdjustment getCharacter() {
            return SelectionAdjustment.Companion.Character;
        }

        public final androidx.compose.foundation.text.selection.SelectionAdjustment getCharacterWithWordAccelerate() {
            return SelectionAdjustment.Companion.CharacterWithWordAccelerate;
        }

        public final androidx.compose.foundation.text.selection.SelectionAdjustment getNone() {
            return SelectionAdjustment.Companion.None;
        }

        public final androidx.compose.foundation.text.selection.SelectionAdjustment getParagraph() {
            return SelectionAdjustment.Companion.Paragraph;
        }

        public final androidx.compose.foundation.text.selection.SelectionAdjustment getWord() {
            return SelectionAdjustment.Companion.Word;
        }
    }
    static {
        SelectionAdjustment.Companion = SelectionAdjustment.Companion.$$INSTANCE;
    }

    public abstract androidx.compose.foundation.text.selection.Selection adjust(androidx.compose.foundation.text.selection.SelectionLayout selectionLayout);
}
