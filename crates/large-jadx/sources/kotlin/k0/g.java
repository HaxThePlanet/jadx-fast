package kotlin.k0;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.a;
import kotlin.y.b;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u001b¨\u0006\u001d", d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class g implements kotlin.k0.f {

    private List<String> a;
    private final Matcher b;

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u0004H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a extends b<String> {

        final kotlin.k0.g b;
        a(kotlin.k0.g g) {
            this.b = g;
            super();
        }

        @Override // kotlin.y.b
        public final boolean contains(Object object) {
            if (object instanceof String != null) {
                return g((String)object);
            }
            return 0;
        }

        @Override // kotlin.y.b
        public int d() {
            return groupCount++;
        }

        @Override // kotlin.y.b
        public boolean g(String string) {
            return super.contains(string);
        }

        @Override // kotlin.y.b
        public Object get(int i) {
            return h(i);
        }

        @Override // kotlin.y.b
        public String h(int i) {
            String obj2;
            if (g.c(this.b).group(i) != null) {
            } else {
                obj2 = "";
            }
            return obj2;
        }

        @Override // kotlin.y.b
        public int i(String string) {
            return super.indexOf(string);
        }

        @Override // kotlin.y.b
        public final int indexOf(Object object) {
            if (object instanceof String != null) {
                return i((String)object);
            }
            return -1;
        }

        @Override // kotlin.y.b
        public int l(String string) {
            return super.lastIndexOf(string);
        }

        @Override // kotlin.y.b
        public final int lastIndexOf(Object object) {
            if (object instanceof String != null) {
                return l((String)object);
            }
            return -1;
        }
    }
    public g(Matcher matcher, java.lang.CharSequence charSequence2) {
        n.f(matcher, "matcher");
        n.f(charSequence2, "input");
        super();
        this.b = matcher;
    }

    public static final MatchResult c(kotlin.k0.g g) {
        return g.d();
    }

    private final MatchResult d() {
        return this.b;
    }

    @Override // kotlin.k0.f
    public kotlin.k0.f.b a() {
        return f.a.a(this);
    }

    public List<String> b() {
        List aVar;
        if (this.a == null) {
            aVar = new g.a(this);
            this.a = aVar;
        }
        List list = this.a;
        n.d(list);
        return list;
    }

    @Override // kotlin.k0.f
    public String getValue() {
        String group = d().group();
        n.e(group, "matchResult.group()");
        return group;
    }
}
