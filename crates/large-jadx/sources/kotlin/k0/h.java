package kotlin.k0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.y.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008B\u001d\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\u0008\u0001\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\u0008\u0010-\u001a\u00020\u0004H\u0016J\u0008\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u00062", d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class h implements Serializable {

    public static final kotlin.k0.h.a a;
    private Set<? extends kotlin.k0.j> _options;
    private final Pattern nativePattern;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\u0007¨\u0006\u000c", d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final int a(kotlin.k0.h.a h$a, int i2) {
            return a.b(i2);
        }

        private final int b(int i) {
            int obj2;
            if (i & 2 != 0) {
                i |= 64;
            }
            return obj2;
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000f", d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    private static final class b implements Serializable {

        private static final long serialVersionUID;
        private final int flags;
        private final String pattern;
        static {
        }

        public b(String string, int i2) {
            n.f(string, "pattern");
            super();
            this.pattern = string;
            this.flags = i2;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            n.e(compile, "Pattern.compile(pattern, flags)");
            h hVar = new h(compile);
            return hVar;
        }
    }
    static {
        h.a aVar = new h.a(0);
        h.a = aVar;
    }

    public h(String string) {
        n.f(string, "pattern");
        final Pattern obj2 = Pattern.compile(string);
        n.e(obj2, "Pattern.compile(pattern)");
        super(obj2);
    }

    public h(String string, kotlin.k0.j j2) {
        n.f(string, "pattern");
        n.f(j2, "option");
        final Pattern obj2 = Pattern.compile(string, h.a.a(h.a, j2.getValue()));
        n.e(obj2, "Pattern.compile(pattern,…nicodeCase(option.value))");
        super(obj2);
    }

    public h(Pattern pattern) {
        n.f(pattern, "nativePattern");
        super();
        this.nativePattern = pattern;
    }

    public static kotlin.k0.f b(kotlin.k0.h h, java.lang.CharSequence charSequence2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        return h.a(charSequence2, obj2);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        n.e(pattern, "nativePattern.pattern()");
        h.b bVar = new h.b(pattern, this.nativePattern.flags());
        return bVar;
    }

    @Override // java.io.Serializable
    public final kotlin.k0.f a(java.lang.CharSequence charSequence, int i2) {
        n.f(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        n.e(matcher, "nativePattern.matcher(input)");
        return i.a(matcher, i2, charSequence);
    }

    @Override // java.io.Serializable
    public final kotlin.k0.f c(java.lang.CharSequence charSequence) {
        n.f(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        n.e(matcher, "nativePattern.matcher(input)");
        return i.b(matcher, charSequence);
    }

    @Override // java.io.Serializable
    public final boolean d(java.lang.CharSequence charSequence) {
        n.f(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @Override // java.io.Serializable
    public final String e(java.lang.CharSequence charSequence, String string2) {
        n.f(charSequence, "input");
        n.f(string2, "replacement");
        String obj2 = this.nativePattern.matcher(charSequence).replaceAll(string2);
        n.e(obj2, "nativePattern.matcher(in…).replaceAll(replacement)");
        return obj2;
    }

    public final List<String> f(java.lang.CharSequence charSequence, int i2) {
        int string;
        boolean find;
        int i;
        int i3;
        n.f(charSequence, "input");
        v.z0(i2);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        string = 1;
        if (i2 != string) {
            if (!matcher.find()) {
            } else {
                if (i2 > 0) {
                    i = g.e(i2, 10);
                }
                ArrayList arrayList = new ArrayList(i);
                i3 = 0;
                i2 -= string;
                arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
                while (obj6 >= 0) {
                    if (arrayList.size() == obj6) {
                        break;
                    } else {
                    }
                    if (matcher.find() != 0) {
                        break;
                    }
                    arrayList.add(charSequence.subSequence(i3, matcher.start()).toString());
                }
            }
            arrayList.add(charSequence.subSequence(matcher.end(), charSequence.length()).toString());
            return arrayList;
        }
        return p.b(charSequence.toString());
    }

    @Override // java.io.Serializable
    public String toString() {
        String string = this.nativePattern.toString();
        n.e(string, "nativePattern.toString()");
        return string;
    }
}
