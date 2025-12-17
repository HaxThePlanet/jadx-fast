package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/text/input/internal/MaskCodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "character", "", "(C)V", "getCharacter", "()C", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "transform", "codepointIndex", "codepoint", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MaskCodepointTransformation implements androidx.compose.foundation.text.input.internal.CodepointTransformation {

    private final char character;
    public MaskCodepointTransformation(char character) {
        super();
        this.character = character;
    }

    public static androidx.compose.foundation.text.input.internal.MaskCodepointTransformation copy$default(androidx.compose.foundation.text.input.internal.MaskCodepointTransformation maskCodepointTransformation, char c2, int i3, Object object4) {
        char obj1;
        if (i3 &= 1 != 0) {
            obj1 = maskCodepointTransformation.character;
        }
        return maskCodepointTransformation.copy(obj1);
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public final char component1() {
        return this.character;
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public final androidx.compose.foundation.text.input.internal.MaskCodepointTransformation copy(char c) {
        MaskCodepointTransformation maskCodepointTransformation = new MaskCodepointTransformation(c);
        return maskCodepointTransformation;
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof MaskCodepointTransformation) {
            return i2;
        }
        if (this.character != obj.character) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public final char getCharacter() {
        return this.character;
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public int hashCode() {
        return Character.hashCode(this.character);
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MaskCodepointTransformation(character=").append(this.character).append(')').toString();
    }

    @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
    public int transform(int codepointIndex, int codepoint) {
        return this.character;
    }
}
