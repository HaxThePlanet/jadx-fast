package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/material3/tokens/ScrimTokens;", "", "()V", "ContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerOpacity", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScrimTokens {

    public static final int $stable = 0;
    private static final androidx.compose.material3.tokens.ColorSchemeKeyTokens ContainerColor = null;
    public static final float ContainerOpacity = 0.32f;
    public static final androidx.compose.material3.tokens.ScrimTokens INSTANCE;
    static {
        ScrimTokens scrimTokens = new ScrimTokens();
        ScrimTokens.INSTANCE = scrimTokens;
        ScrimTokens.ContainerColor = ColorSchemeKeyTokens.Scrim;
    }

    public final androidx.compose.material3.tokens.ColorSchemeKeyTokens getContainerColor() {
        return ScrimTokens.ContainerColor;
    }
}
