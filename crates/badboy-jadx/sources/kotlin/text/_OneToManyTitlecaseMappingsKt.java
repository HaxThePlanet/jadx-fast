package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000c\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003", d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char $this$titlecaseImpl) {
        String string;
        StringBuilder append;
        StringBuilder stringBuilder;
        String str;
        String valueOf = String.valueOf($this$titlecaseImpl);
        String str2 = "null cannot be cast to non-null type java.lang.String";
        Intrinsics.checkNotNull(valueOf, str2);
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        stringBuilder = 1;
        if (upperCase.length() > stringBuilder) {
            if ($this$titlecaseImpl == 329) {
                string = upperCase;
            } else {
                Intrinsics.checkNotNull(upperCase, str2);
                String substring = upperCase.substring(stringBuilder);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Intrinsics.checkNotNull(substring, str2);
                String lowerCase = substring.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                stringBuilder = new StringBuilder();
                string = stringBuilder.append(upperCase.charAt(0)).append(lowerCase).toString();
            }
            return string;
        }
        return String.valueOf(Character.toTitleCase($this$titlecaseImpl));
    }
}
