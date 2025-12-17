package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0012\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\t0\u0013\"\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0008\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\tR\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Landroidx/compose/runtime/internal/ComposableLambdaNImpl;", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "key", "", "tracked", "", "arity", "(IZI)V", "_block", "", "getArity", "()I", "getKey", "scope", "Landroidx/compose/runtime/RecomposeScope;", "scopes", "", "invoke", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "realParamCount", "params", "trackRead", "", "composer", "Landroidx/compose/runtime/Composer;", "trackWrite", "update", "block", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposableLambdaNImpl implements androidx.compose.runtime.internal.ComposableLambdaN {

    public static final int $stable;
    private Object _block;
    private final int arity;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;
    static {
    }

    public ComposableLambdaNImpl(int key, boolean tracked, int arity) {
        super();
        this.key = key;
        this.tracked = tracked;
        this.arity = arity;
    }

    private final int realParamCount(int params) {
        int realParams;
        int changedParams;
        int i;
        realParams2--;
        changedParams = 1;
        while (changedParams * 10 < realParams) {
            realParams--;
            changedParams++;
        }
        return realParams;
    }

    private final void trackRead(Composer composer) {
        boolean recomposeScope;
        RecomposeScope scope;
        boolean replacableWith;
        int newScopes;
        int size;
        Object obj;
        boolean replacableWith2;
        recomposeScope = composer.getRecomposeScope();
        if (this.tracked && recomposeScope != null) {
            recomposeScope = composer.getRecomposeScope();
            if (recomposeScope != null) {
                composer.recordUsed(recomposeScope);
                if (ComposableLambdaKt.replacableWith(this.scope, recomposeScope)) {
                    this.scope = recomposeScope;
                } else {
                    replacableWith = this.scopes;
                    if (replacableWith == null) {
                        newScopes = new ArrayList();
                        this.scopes = (List)newScopes;
                        newScopes.add(recomposeScope);
                    } else {
                        newScopes = 0;
                        while (newScopes < replacableWith.size()) {
                            newScopes++;
                        }
                        replacableWith.add(recomposeScope);
                    }
                }
            }
        }
    }

    private final void trackWrite() {
        boolean tracked;
        int scopes;
        int index;
        int size;
        Object obj;
        tracked = this.scope;
        if (this.tracked && tracked != null) {
            tracked = this.scope;
            if (tracked != null) {
                tracked.invalidate();
                this.scope = 0;
            }
            scopes = this.scopes;
            if (scopes != null) {
                index = 0;
                while (index < scopes.size()) {
                    (RecomposeScope)scopes.get(index).invalidate();
                    index++;
                }
                scopes.clear();
            }
        }
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN
    public int getArity() {
        return this.arity;
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN
    public final int getKey() {
        return this.key;
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN
    public Object invoke(Object... args) {
        int differentBits;
        Object[] anon;
        int realParamCount = realParamCount(args.length);
        Object obj = args[realParamCount];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        int i2 = 0;
        int i4 = 0;
        Object obj2 = args[length3--];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        Composer c = (Composer)obj.startRestartGroup(this.key);
        trackRead(c);
        if (c.changed(this)) {
            differentBits = ComposableLambdaKt.differentBits(realParamCount);
        } else {
            differentBits = ComposableLambdaKt.sameBits(realParamCount);
        }
        Object _block = this._block;
        Intrinsics.checkNotNull(_block, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.addSpread((Collection)ArraysKt.slice(args, RangesKt.until(i2, length2--)).toArray(new Object[i2]));
        spreadBuilder.add(Integer.valueOf(differentBits |= intValue));
        ScopeUpdateScope endRestartGroup = c.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new ComposableLambdaNImpl.invoke.1(args, realParamCount, this);
            endRestartGroup.updateScope((Function2)anon);
        }
        return (FunctionN)_block.invoke(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN
    public final void update(Object block) {
        int equal;
        Object obj;
        if (!Intrinsics.areEqual(block, this._block)) {
            equal = this._block == null ? 1 : 0;
            Intrinsics.checkNotNull(block, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
            this._block = (FunctionN)block;
            if (equal == 0) {
                trackWrite();
            }
        }
    }
}
