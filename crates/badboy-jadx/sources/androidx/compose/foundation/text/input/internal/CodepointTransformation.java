package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008á\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "", "transform", "", "codepointIndex", "codepoint", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CodepointTransformation {

    public static final androidx.compose.foundation.text.input.internal.CodepointTransformation.Companion Companion;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/foundation/text/input/internal/CodepointTransformation$Companion;", "", "()V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.text.input.internal.CodepointTransformation.Companion $$INSTANCE;
        static {
            CodepointTransformation.Companion companion = new CodepointTransformation.Companion();
            CodepointTransformation.Companion.$$INSTANCE = companion;
        }
    }
    static {
        CodepointTransformation.Companion = CodepointTransformation.Companion.$$INSTANCE;
    }

    public abstract int transform(int i, int i2);
}
