package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000e", d2 = {"Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "Landroidx/compose/ui/text/TtsAnnotation;", "verbatim", "", "(Ljava/lang/String;)V", "getVerbatim", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VerbatimTtsAnnotation extends androidx.compose.ui.text.TtsAnnotation {

    public static final int $stable;
    private final String verbatim;
    static {
    }

    public VerbatimTtsAnnotation(String verbatim) {
        super(0);
        this.verbatim = verbatim;
    }

    @Override // androidx.compose.ui.text.TtsAnnotation
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof VerbatimTtsAnnotation) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.verbatim, obj.verbatim)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.TtsAnnotation
    public final String getVerbatim() {
        return this.verbatim;
    }

    @Override // androidx.compose.ui.text.TtsAnnotation
    public int hashCode() {
        return this.verbatim.hashCode();
    }

    @Override // androidx.compose.ui.text.TtsAnnotation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("VerbatimTtsAnnotation(verbatim=").append(this.verbatim).append(')').toString();
    }
}
