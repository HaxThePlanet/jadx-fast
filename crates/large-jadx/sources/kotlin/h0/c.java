package kotlin.h0;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000c\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 \u00152\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u000bH\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0008¨\u0006\u0016", d2 = {"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(CC)V", "getEndInclusive", "()Ljava/lang/Character;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class c extends kotlin.h0.a {
    static {
        c cVar = new c((char)i, (char)i2);
    }

    public c(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // kotlin.h0.a
    public boolean equals(Object object) {
        boolean empty;
        char c;
        int obj3;
        if (object instanceof c) {
            if (isEmpty()) {
                if (!(c)object.isEmpty()) {
                    if (d() == (c)object.d() && g() == object.g()) {
                        obj3 = g() == object.g() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // kotlin.h0.a
    public int hashCode() {
        int i;
        char c;
        if (isEmpty()) {
            i = -1;
        } else {
            i2 += c;
        }
        return i;
    }

    @Override // kotlin.h0.a
    public boolean isEmpty() {
        int i;
        i = n.h(d(), g()) > 0 ? 1 : 0;
        return i;
    }

    @Override // kotlin.h0.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d());
        stringBuilder.append("..");
        stringBuilder.append(g());
        return stringBuilder.toString();
    }
}
