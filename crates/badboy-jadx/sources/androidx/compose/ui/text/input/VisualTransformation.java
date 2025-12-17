package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008ç\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/ui/text/input/VisualTransformation;", "", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VisualTransformation {

    public static final androidx.compose.ui.text.input.VisualTransformation.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/text/input/VisualTransformation$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/input/VisualTransformation;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/input/VisualTransformation;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.text.input.VisualTransformation.Companion $$INSTANCE;
        private static final androidx.compose.ui.text.input.VisualTransformation None;
        public static androidx.compose.ui.text.input.TransformedText $r8$lambda$lVQGM-qHtfjm-EwPaE6dqnfDBlU(AnnotatedString annotatedString) {
            return VisualTransformation.Companion.None$lambda$0(annotatedString);
        }

        static {
            VisualTransformation.Companion companion = new VisualTransformation.Companion();
            VisualTransformation.Companion.$$INSTANCE = companion;
            VisualTransformation.Companion$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new VisualTransformation.Companion$$ExternalSyntheticLambda0();
            VisualTransformation.Companion.None = externalSyntheticLambda0;
        }

        private static final androidx.compose.ui.text.input.TransformedText None$lambda$0(AnnotatedString text) {
            TransformedText transformedText = new TransformedText(text, OffsetMapping.Companion.getIdentity());
            return transformedText;
        }

        public static void getNone$annotations() {
        }

        public final androidx.compose.ui.text.input.VisualTransformation getNone() {
            return VisualTransformation.Companion.None;
        }
    }
    static {
        VisualTransformation.Companion = VisualTransformation.Companion.$$INSTANCE;
    }

    public abstract androidx.compose.ui.text.input.TransformedText filter(AnnotatedString annotatedString);
}
