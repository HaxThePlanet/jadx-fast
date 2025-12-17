package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.MediaType;
import androidx.compose.foundation.content.MediaType.Companion;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0005\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0004¨\u0006\u0007", d2 = {"MediaTypesAll", "", "Landroidx/compose/foundation/content/MediaType;", "getMediaTypesAll$annotations", "()V", "MediaTypesText", "getMediaTypesText$annotations", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDecoratorModifierKt {

    private static final Set<MediaType> MediaTypesAll;
    private static final Set<MediaType> MediaTypesText;
    static {
        TextFieldDecoratorModifierKt.MediaTypesText = SetsKt.setOf(MediaType.Companion.getText());
        TextFieldDecoratorModifierKt.MediaTypesAll = SetsKt.setOf(MediaType.Companion.getAll());
    }

    public static final Set access$getMediaTypesAll$p() {
        return TextFieldDecoratorModifierKt.MediaTypesAll;
    }

    public static final Set access$getMediaTypesText$p() {
        return TextFieldDecoratorModifierKt.MediaTypesText;
    }

    private static void getMediaTypesAll$annotations() {
    }

    private static void getMediaTypesText$annotations() {
    }
}
