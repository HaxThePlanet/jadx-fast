package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\u0008\u0086\u0081\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008j\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010¨\u0006\u0011", d2 = {"Lkotlin/text/RegexOption;", "", "Lkotlin/text/FlagEnum;", "value", "", "mask", "(Ljava/lang/String;III)V", "getMask", "()I", "getValue", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum RegexOption implements kotlin.text.FlagEnum {

    CANON_EQ(false, false, false, false),
    COMMENTS(false, false, false, false),
    DOT_MATCHES_ALL(false, false, false, false),
    IGNORE_CASE(2, false, 2, false),
    IGNORE_CASE(2, false, 2, false),
    IGNORE_CASE(2, false, 2, false),
    LITERAL(2, false, false, false),
    MULTILINE(false, 2, false, false),
    UNIX_LINES(false, false, false, false);

    private final int mask;
    private final int value;
    private static final kotlin.text.RegexOption[] $values() {
        return /* result */;
    }

    public static EnumEntries<kotlin.text.RegexOption> getEntries() {
        return RegexOption.$ENTRIES;
    }

    @Override // java.lang.Enum
    public int getMask() {
        return this.mask;
    }

    @Override // java.lang.Enum
    public int getValue() {
        return this.value;
    }
}
