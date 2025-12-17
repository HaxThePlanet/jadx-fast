package kotlin.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0087\u0008ø\u0001\u0000\u001a\u000c\u0010\u0007\u001a\u00020\u0008*\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\n", d2 = {"HexFormat", "Lkotlin/text/HexFormat;", "builderAction", "Lkotlin/Function1;", "Lkotlin/text/HexFormat$Builder;", "", "Lkotlin/ExtensionFunctionType;", "isCaseSensitive", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class HexFormatKt {
    private static final kotlin.text.HexFormat HexFormat(Function1<? super kotlin.text.HexFormat.Builder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        HexFormat.Builder builder = new HexFormat.Builder();
        builderAction.invoke(builder);
        return builder.build();
    }

    public static final boolean access$isCaseSensitive(String $receiver) {
        return HexFormatKt.isCaseSensitive($receiver);
    }

    private static final boolean isCaseSensitive(String $this$isCaseSensitive) {
        int i;
        int i3;
        char charAt;
        int it;
        int i2;
        boolean compare;
        int i4;
        final java.lang.CharSequence charSequence = $this$isCaseSensitive;
        final int i5 = 0;
        i = 0;
        i3 = i;
        while (i3 < (CharSequence)charSequence.length()) {
            char c = charAt;
            i2 = 0;
            i4 = 1;
            if (Intrinsics.compare(c, 128) < 0) {
            } else {
            }
            it = i4;
            i3++;
            if (Character.isLetter(c)) {
            } else {
            }
            it = i;
        }
        return i;
    }
}
