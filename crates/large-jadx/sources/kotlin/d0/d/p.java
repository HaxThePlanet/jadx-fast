package kotlin.d0.d;

import java.io.Serializable;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008&\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u000b", d2 = {"Lkotlin/jvm/internal/Lambda;", "R", "Lkotlin/jvm/internal/FunctionBase;", "Ljava/io/Serializable;", "arity", "", "(I)V", "getArity", "()I", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class p<R>  implements kotlin.d0.d.i<R>, Serializable {

    private final int arity;
    public p(int i) {
        super();
        this.arity = i;
    }

    @Override // kotlin.d0.d.i
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.d0.d.i
    public String toString() {
        final String str = c0.i(this);
        n.e(str, "Reflection.renderLambdaToString(this)");
        return str;
    }
}
