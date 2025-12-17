package kotlin.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0007\u0018\u0000 \u00132\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u001f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0015", d2 = {"Lkotlin/text/HexFormat;", "", "upperCase", "", "bytes", "Lkotlin/text/HexFormat$BytesHexFormat;", "number", "Lkotlin/text/HexFormat$NumberHexFormat;", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat;", "getUpperCase", "()Z", "toString", "", "Builder", "BytesHexFormat", "Companion", "NumberHexFormat", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HexFormat {

    public static final kotlin.text.HexFormat.Companion Companion;
    private static final kotlin.text.HexFormat Default;
    private static final kotlin.text.HexFormat UpperCase;
    private final kotlin.text.HexFormat.BytesHexFormat bytes;
    private final kotlin.text.HexFormat.NumberHexFormat number;
    private final boolean upperCase;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u0008\u0001¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0001J%\u0010\u0007\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\u0008\u0018H\u0087\u0008ø\u0001\u0000J%\u0010\n\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\u0008\u0018H\u0087\u0008ø\u0001\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0019", d2 = {"Lkotlin/text/HexFormat$Builder;", "", "()V", "_bytes", "Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "_number", "Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "bytes", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "number", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "upperCase", "", "getUpperCase", "()Z", "setUpperCase", "(Z)V", "build", "Lkotlin/text/HexFormat;", "", "builderAction", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {

        private kotlin.text.HexFormat.BytesHexFormat.Builder _bytes;
        private kotlin.text.HexFormat.NumberHexFormat.Builder _number;
        private boolean upperCase;
        public Builder() {
            super();
            this.upperCase = HexFormat.Companion.getDefault().getUpperCase();
        }

        private final void bytes(Function1<? super kotlin.text.HexFormat.BytesHexFormat.Builder, Unit> builderAction) {
            Intrinsics.checkNotNullParameter(builderAction, "builderAction");
            builderAction.invoke(getBytes());
        }

        private final void number(Function1<? super kotlin.text.HexFormat.NumberHexFormat.Builder, Unit> builderAction) {
            Intrinsics.checkNotNullParameter(builderAction, "builderAction");
            builderAction.invoke(getNumber());
        }

        public final kotlin.text.HexFormat build() {
            kotlin.text.HexFormat.BytesHexFormat default$kotlin_stdlib;
            Object default$kotlin_stdlib2;
            default$kotlin_stdlib = this._bytes;
            if (default$kotlin_stdlib != null) {
                if (default$kotlin_stdlib.build$kotlin_stdlib() == null) {
                    default$kotlin_stdlib = HexFormat.BytesHexFormat.Companion.getDefault$kotlin_stdlib();
                }
            } else {
            }
            default$kotlin_stdlib2 = this._number;
            if (default$kotlin_stdlib2 != null) {
                if (default$kotlin_stdlib2.build$kotlin_stdlib() == null) {
                    default$kotlin_stdlib2 = HexFormat.NumberHexFormat.Companion.getDefault$kotlin_stdlib();
                }
            } else {
            }
            HexFormat hexFormat = new HexFormat(this.upperCase, default$kotlin_stdlib, default$kotlin_stdlib2);
            return hexFormat;
        }

        public final kotlin.text.HexFormat.BytesHexFormat.Builder getBytes() {
            kotlin.text.HexFormat.BytesHexFormat.Builder builder;
            if (this._bytes == null) {
                builder = new HexFormat.BytesHexFormat.Builder();
                this._bytes = builder;
            }
            kotlin.text.HexFormat.BytesHexFormat.Builder _bytes = this._bytes;
            Intrinsics.checkNotNull(_bytes);
            return _bytes;
        }

        public final kotlin.text.HexFormat.NumberHexFormat.Builder getNumber() {
            kotlin.text.HexFormat.NumberHexFormat.Builder _number;
            if (this._number == null) {
                _number = new HexFormat.NumberHexFormat.Builder();
                this._number = _number;
            }
            kotlin.text.HexFormat.NumberHexFormat.Builder _number2 = this._number;
            Intrinsics.checkNotNull(_number2);
            return _number2;
        }

        public final boolean getUpperCase() {
            return this.upperCase;
        }

        public final void setUpperCase(boolean <set-?>) {
            this.upperCase = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B7\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0008\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ%\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001f\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008 J\u0008\u0010!\u001a\u00020\u0006H\u0016R\u0011\u0010\u0008\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000cR\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0014X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u0014X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0016¨\u0006$", d2 = {"Lkotlin/text/HexFormat$BytesHexFormat;", "", "bytesPerLine", "", "bytesPerGroup", "groupSeparator", "", "byteSeparator", "bytePrefix", "byteSuffix", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBytePrefix", "()Ljava/lang/String;", "getByteSeparator", "getByteSuffix", "getBytesPerGroup", "()I", "getBytesPerLine", "getGroupSeparator", "ignoreCase", "", "getIgnoreCase$kotlin_stdlib", "()Z", "noLineAndGroupSeparator", "getNoLineAndGroupSeparator$kotlin_stdlib", "shortByteSeparatorNoPrefixAndSuffix", "getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "toString", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BytesHexFormat {

        public static final kotlin.text.HexFormat.BytesHexFormat.Companion Companion;
        private static final kotlin.text.HexFormat.BytesHexFormat Default;
        private final String bytePrefix;
        private final String byteSeparator;
        private final String byteSuffix;
        private final int bytesPerGroup;
        private final int bytesPerLine;
        private final String groupSeparator;
        private final boolean ignoreCase = true;
        private final boolean noLineAndGroupSeparator = false;
        private final boolean shortByteSeparatorNoPrefixAndSuffix = false;
        static {
            HexFormat.BytesHexFormat.Companion companion = new HexFormat.BytesHexFormat.Companion(0);
            HexFormat.BytesHexFormat.Companion = companion;
            HexFormat.BytesHexFormat bytesHexFormat = new HexFormat.BytesHexFormat(Integer.MAX_VALUE, Integer.MAX_VALUE, "  ", "", "", "");
            HexFormat.BytesHexFormat.Default = bytesHexFormat;
        }

        public BytesHexFormat(int bytesPerLine, int bytesPerGroup, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            int bytesPerGroup2;
            int length;
            boolean z;
            Intrinsics.checkNotNullParameter(groupSeparator, "groupSeparator");
            Intrinsics.checkNotNullParameter(byteSeparator, "byteSeparator");
            Intrinsics.checkNotNullParameter(bytePrefix, "bytePrefix");
            Intrinsics.checkNotNullParameter(byteSuffix, "byteSuffix");
            super();
            this.bytesPerLine = bytesPerLine;
            this.bytesPerGroup = bytesPerGroup;
            this.groupSeparator = groupSeparator;
            this.byteSeparator = byteSeparator;
            this.bytePrefix = bytePrefix;
            this.byteSuffix = byteSuffix;
            int i5 = 0;
            final int i7 = 1;
            final int i8 = Integer.MAX_VALUE;
            if (this.bytesPerLine == i8 && this.bytesPerGroup == i8) {
                int i4 = this.bytesPerGroup == i8 ? i7 : i4;
            }
            int i = i5;
            length = (CharSequence)this.bytePrefix.length() == 0 ? i7 : i5;
            if (length != 0) {
                length = (CharSequence)this.byteSuffix.length() == 0 ? i7 : i5;
                if (length != 0 && this.byteSeparator.length() <= i7) {
                    int i2 = this.byteSeparator.length() <= i7 ? i7 : i2;
                }
            }
            int i3 = i5;
            if (!HexFormatKt.access$isCaseSensitive(this.groupSeparator) && !HexFormatKt.access$isCaseSensitive(this.byteSeparator) && !HexFormatKt.access$isCaseSensitive(this.bytePrefix)) {
                if (!HexFormatKt.access$isCaseSensitive(this.byteSeparator)) {
                    if (!HexFormatKt.access$isCaseSensitive(this.bytePrefix)) {
                    }
                }
            }
            int i6 = i7;
        }

        public static final kotlin.text.HexFormat.BytesHexFormat access$getDefault$cp() {
            return HexFormat.BytesHexFormat.Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            StringBuilder append3 = sb.append(indent).append("bytesPerLine = ").append(this.bytesPerLine);
            String str4 = "append(...)";
            Intrinsics.checkNotNullExpressionValue(append3, str4);
            String str7 = ",";
            StringBuilder append4 = append3.append(str7);
            Intrinsics.checkNotNullExpressionValue(append4, str4);
            final int i = 10;
            Intrinsics.checkNotNullExpressionValue(append4.append(i), str4);
            StringBuilder append8 = sb.append(indent).append("bytesPerGroup = ").append(this.bytesPerGroup);
            Intrinsics.checkNotNullExpressionValue(append8, str4);
            StringBuilder append9 = append8.append(str7);
            Intrinsics.checkNotNullExpressionValue(append9, str4);
            Intrinsics.checkNotNullExpressionValue(append9.append(i), str4);
            StringBuilder append13 = sb.append(indent).append("groupSeparator = \"").append(this.groupSeparator);
            Intrinsics.checkNotNullExpressionValue(append13, str4);
            String str9 = "\",";
            StringBuilder append14 = append13.append(str9);
            Intrinsics.checkNotNullExpressionValue(append14, str4);
            Intrinsics.checkNotNullExpressionValue(append14.append(i), str4);
            StringBuilder append18 = sb.append(indent).append("byteSeparator = \"").append(this.byteSeparator);
            Intrinsics.checkNotNullExpressionValue(append18, str4);
            StringBuilder append19 = append18.append(str9);
            Intrinsics.checkNotNullExpressionValue(append19, str4);
            Intrinsics.checkNotNullExpressionValue(append19.append(i), str4);
            StringBuilder append23 = sb.append(indent).append("bytePrefix = \"").append(this.bytePrefix);
            Intrinsics.checkNotNullExpressionValue(append23, str4);
            StringBuilder append24 = append23.append(str9);
            Intrinsics.checkNotNullExpressionValue(append24, str4);
            Intrinsics.checkNotNullExpressionValue(append24.append(i), str4);
            sb.append(indent).append("byteSuffix = \"").append(this.byteSuffix).append("\"");
            return sb;
        }

        public final String getBytePrefix() {
            return this.bytePrefix;
        }

        public final String getByteSeparator() {
            return this.byteSeparator;
        }

        public final String getByteSuffix() {
            return this.byteSuffix;
        }

        public final int getBytesPerGroup() {
            return this.bytesPerGroup;
        }

        public final int getBytesPerLine() {
            return this.bytesPerLine;
        }

        public final String getGroupSeparator() {
            return this.groupSeparator;
        }

        public final boolean getIgnoreCase$kotlin_stdlib() {
            return this.ignoreCase;
        }

        public final boolean getNoLineAndGroupSeparator$kotlin_stdlib() {
            return this.noLineAndGroupSeparator;
        }

        public final boolean getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() {
            return this.shortByteSeparatorNoPrefixAndSuffix;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder sb = stringBuilder;
            final int i = 0;
            StringBuilder append = sb.append("BytesHexFormat(");
            final String str5 = "append(...)";
            Intrinsics.checkNotNullExpressionValue(append, str5);
            final int i2 = 10;
            Intrinsics.checkNotNullExpressionValue(append.append(i2), str5);
            Intrinsics.checkNotNullExpressionValue(appendOptionsTo$kotlin_stdlib(sb, "    ").append(i2), str5);
            sb.append(")");
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\t", d2 = {"Lkotlin/text/HexFormat$Companion;", "", "()V", "Default", "Lkotlin/text/HexFormat;", "getDefault", "()Lkotlin/text/HexFormat;", "UpperCase", "getUpperCase", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.text.HexFormat getDefault() {
            return HexFormat.access$getDefault$cp();
        }

        public final kotlin.text.HexFormat getUpperCase() {
            return HexFormat.access$getUpperCase$cp();
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !B'\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ%\u0010\u0019\u001a\u00060\u001aj\u0002`\u001b2\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001d\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0008\u001eJ\u0008\u0010\u001f\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0014\u0010\u000f\u001a\u00020\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u001c\u0010\u0007\u001a\u00020\u00088\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0016¨\u0006\"", d2 = {"Lkotlin/text/HexFormat$NumberHexFormat;", "", "prefix", "", "suffix", "removeLeadingZeros", "", "minLength", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "ignoreCase", "getIgnoreCase$kotlin_stdlib", "()Z", "isDigitsOnly", "isDigitsOnly$kotlin_stdlib", "isDigitsOnlyAndNoPadding", "isDigitsOnlyAndNoPadding$kotlin_stdlib", "getMinLength$annotations", "()V", "getMinLength", "()I", "getPrefix", "()Ljava/lang/String;", "getRemoveLeadingZeros", "getSuffix", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "toString", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NumberHexFormat {

        public static final kotlin.text.HexFormat.NumberHexFormat.Companion Companion;
        private static final kotlin.text.HexFormat.NumberHexFormat Default;
        private final boolean ignoreCase = true;
        private final boolean isDigitsOnly = false;
        private final boolean isDigitsOnlyAndNoPadding = false;
        private final int minLength;
        private final String prefix;
        private final boolean removeLeadingZeros;
        private final String suffix;
        static {
            HexFormat.NumberHexFormat.Companion companion = new HexFormat.NumberHexFormat.Companion(0);
            HexFormat.NumberHexFormat.Companion = companion;
            String str = "";
            HexFormat.NumberHexFormat numberHexFormat = new HexFormat.NumberHexFormat(str, str, 0, 1);
            HexFormat.NumberHexFormat.Default = numberHexFormat;
        }

        public NumberHexFormat(String prefix, String suffix, boolean removeLeadingZeros, int minLength) {
            int i;
            boolean isDigitsOnly;
            boolean z;
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(suffix, "suffix");
            super();
            this.prefix = prefix;
            this.suffix = suffix;
            this.removeLeadingZeros = removeLeadingZeros;
            this.minLength = minLength;
            int i6 = 0;
            final int i8 = 1;
            i = (CharSequence)this.prefix.length() == 0 ? i8 : i6;
            if (i != 0) {
                i = (CharSequence)this.suffix.length() == 0 ? i8 : i6;
                int i5 = i != 0 ? i8 : i5;
            }
            int i2 = i6;
            if (this.isDigitsOnly && this.minLength == i8) {
                int i4 = this.minLength == i8 ? i8 : i4;
            }
            int i3 = i6;
            if (!HexFormatKt.access$isCaseSensitive(this.prefix)) {
            }
            int i7 = i8;
        }

        public static final kotlin.text.HexFormat.NumberHexFormat access$getDefault$cp() {
            return HexFormat.NumberHexFormat.Default;
        }

        public static void getMinLength$annotations() {
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            StringBuilder append3 = sb.append(indent).append("prefix = \"").append(this.prefix);
            String str4 = "append(...)";
            Intrinsics.checkNotNullExpressionValue(append3, str4);
            String str6 = "\",";
            StringBuilder append4 = append3.append(str6);
            Intrinsics.checkNotNullExpressionValue(append4, str4);
            final int i2 = 10;
            Intrinsics.checkNotNullExpressionValue(append4.append(i2), str4);
            StringBuilder append8 = sb.append(indent).append("suffix = \"").append(this.suffix);
            Intrinsics.checkNotNullExpressionValue(append8, str4);
            StringBuilder append9 = append8.append(str6);
            Intrinsics.checkNotNullExpressionValue(append9, str4);
            Intrinsics.checkNotNullExpressionValue(append9.append(i2), str4);
            StringBuilder append13 = sb.append(indent).append("removeLeadingZeros = ").append(this.removeLeadingZeros);
            Intrinsics.checkNotNullExpressionValue(append13, str4);
            StringBuilder append14 = append13.append(',');
            Intrinsics.checkNotNullExpressionValue(append14, str4);
            Intrinsics.checkNotNullExpressionValue(append14.append(i2), str4);
            sb.append(indent).append("minLength = ").append(this.minLength);
            return sb;
        }

        public final boolean getIgnoreCase$kotlin_stdlib() {
            return this.ignoreCase;
        }

        public final int getMinLength() {
            return this.minLength;
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final boolean getRemoveLeadingZeros() {
            return this.removeLeadingZeros;
        }

        public final String getSuffix() {
            return this.suffix;
        }

        public final boolean isDigitsOnly$kotlin_stdlib() {
            return this.isDigitsOnly;
        }

        public final boolean isDigitsOnlyAndNoPadding$kotlin_stdlib() {
            return this.isDigitsOnlyAndNoPadding;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder sb = stringBuilder;
            final int i = 0;
            StringBuilder append = sb.append("NumberHexFormat(");
            final String str5 = "append(...)";
            Intrinsics.checkNotNullExpressionValue(append, str5);
            final int i2 = 10;
            Intrinsics.checkNotNullExpressionValue(append.append(i2), str5);
            Intrinsics.checkNotNullExpressionValue(appendOptionsTo$kotlin_stdlib(sb, "    ").append(i2), str5);
            sb.append(")");
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }
    static {
        HexFormat.Companion companion = new HexFormat.Companion(0);
        HexFormat.Companion = companion;
        HexFormat hexFormat = new HexFormat(0, HexFormat.BytesHexFormat.Companion.getDefault$kotlin_stdlib(), HexFormat.NumberHexFormat.Companion.getDefault$kotlin_stdlib());
        HexFormat.Default = hexFormat;
        HexFormat hexFormat2 = new HexFormat(1, HexFormat.BytesHexFormat.Companion.getDefault$kotlin_stdlib(), HexFormat.NumberHexFormat.Companion.getDefault$kotlin_stdlib());
        HexFormat.UpperCase = hexFormat2;
    }

    public HexFormat(boolean upperCase, kotlin.text.HexFormat.BytesHexFormat bytes, kotlin.text.HexFormat.NumberHexFormat number) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(number, "number");
        super();
        this.upperCase = upperCase;
        this.bytes = bytes;
        this.number = number;
    }

    public static final kotlin.text.HexFormat access$getDefault$cp() {
        return HexFormat.Default;
    }

    public static final kotlin.text.HexFormat access$getUpperCase$cp() {
        return HexFormat.UpperCase;
    }

    public final kotlin.text.HexFormat.BytesHexFormat getBytes() {
        return this.bytes;
    }

    public final kotlin.text.HexFormat.NumberHexFormat getNumber() {
        return this.number;
    }

    public final boolean getUpperCase() {
        return this.upperCase;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i = 0;
        StringBuilder append = sb.append("HexFormat(");
        final String str9 = "append(...)";
        Intrinsics.checkNotNullExpressionValue(append, str9);
        final int i2 = 10;
        Intrinsics.checkNotNullExpressionValue(append.append(i2), str9);
        StringBuilder append4 = sb.append("    upperCase = ").append(this.upperCase);
        Intrinsics.checkNotNullExpressionValue(append4, str9);
        StringBuilder append5 = append4.append(",");
        Intrinsics.checkNotNullExpressionValue(append5, str9);
        Intrinsics.checkNotNullExpressionValue(append5.append(i2), str9);
        StringBuilder append7 = sb.append("    bytes = BytesHexFormat(");
        Intrinsics.checkNotNullExpressionValue(append7, str9);
        Intrinsics.checkNotNullExpressionValue(append7.append(i2), str9);
        String str11 = "        ";
        Intrinsics.checkNotNullExpressionValue(this.bytes.appendOptionsTo$kotlin_stdlib(sb, str11).append(i2), str9);
        StringBuilder append10 = sb.append("    ),");
        Intrinsics.checkNotNullExpressionValue(append10, str9);
        Intrinsics.checkNotNullExpressionValue(append10.append(i2), str9);
        StringBuilder append12 = sb.append("    number = NumberHexFormat(");
        Intrinsics.checkNotNullExpressionValue(append12, str9);
        Intrinsics.checkNotNullExpressionValue(append12.append(i2), str9);
        Intrinsics.checkNotNullExpressionValue(this.number.appendOptionsTo$kotlin_stdlib(sb, str11).append(i2), str9);
        StringBuilder append15 = sb.append("    )");
        Intrinsics.checkNotNullExpressionValue(append15, str9);
        Intrinsics.checkNotNullExpressionValue(append15.append(i2), str9);
        sb.append(")");
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
