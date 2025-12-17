package kotlin.text;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\u0008\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\u0008¨\u0006\u0007", d2 = {"toRegex", "Lkotlin/text/Regex;", "", "options", "", "Lkotlin/text/RegexOption;", "option", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__RegexExtensionsKt extends kotlin.text.StringsKt__RegexExtensionsJVMKt {
    private static final kotlin.text.Regex toRegex(String $this$toRegex) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        Regex regex = new Regex($this$toRegex);
        return regex;
    }

    private static final kotlin.text.Regex toRegex(String $this$toRegex, Set<? extends kotlin.text.RegexOption> options) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Regex regex = new Regex($this$toRegex, options);
        return regex;
    }

    private static final kotlin.text.Regex toRegex(String $this$toRegex, kotlin.text.RegexOption option) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        Intrinsics.checkNotNullParameter(option, "option");
        Regex regex = new Regex($this$toRegex, option);
        return regex;
    }
}
