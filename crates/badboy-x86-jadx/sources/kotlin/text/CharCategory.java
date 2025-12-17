package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008 \u0008\u0086\u0081\u0002\u0018\u0000 -2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001-B\u0017\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nj\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016j\u0002\u0008\u0017j\u0002\u0008\u0018j\u0002\u0008\u0019j\u0002\u0008\u001aj\u0002\u0008\u001bj\u0002\u0008\u001cj\u0002\u0008\u001dj\u0002\u0008\u001ej\u0002\u0008\u001fj\u0002\u0008 j\u0002\u0008!j\u0002\u0008\"j\u0002\u0008#j\u0002\u0008$j\u0002\u0008%j\u0002\u0008&j\u0002\u0008'j\u0002\u0008(j\u0002\u0008)j\u0002\u0008*j\u0002\u0008+j\u0002\u0008,¨\u0006.", d2 = {"Lkotlin/text/CharCategory;", "", "value", "", "code", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getValue", "()I", "contains", "", "char", "", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public enum CharCategory {

    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn"),
    UNASSIGNED(false, "Cn");

    private final String code;
    private final int value;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lkotlin/text/CharCategory$Companion;", "", "()V", "valueOf", "Lkotlin/text/CharCategory;", "category", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.text.CharCategory valueOf(int category) {
            int i2;
            Object obj;
            int i;
            int i3;
            int i4;
            i = 0;
            if (category >= 0 && category < 17) {
                i4 = category < 17 ? i2 : i;
            } else {
            }
            if (i4 != 0) {
                obj = CharCategory.getEntries().get(category);
                return obj;
            } else {
                if (18 <= category && category < 31) {
                    if (category < 31) {
                    } else {
                        i2 = i;
                    }
                } else {
                }
                if (i2 == 0) {
                } else {
                    obj = CharCategory.getEntries().get(category + -1);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Category #").append(category).append(" is not defined.").toString());
            throw illegalArgumentException;
        }
    }
    private static final kotlin.text.CharCategory[] $values() {
        return /* result */;
    }

    public static EnumEntries<kotlin.text.CharCategory> getEntries() {
        return CharCategory.$ENTRIES;
    }

    @Override // java.lang.Enum
    public final boolean contains(char char) {
        int i;
        i = Character.getType(char) == this.value ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public final String getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final int getValue() {
        return this.value;
    }
}
