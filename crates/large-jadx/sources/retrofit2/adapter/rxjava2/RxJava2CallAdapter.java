package retrofit2.adapter.rxjava2;

import i.b.a;
import i.b.p0.a;
import i.b.r;
import i.b.z;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;

/* loaded from: classes3.dex */
final class RxJava2CallAdapter<R>  implements CallAdapter<R, Object> {

    private final boolean isAsync;
    private final boolean isBody;
    private final boolean isCompletable;
    private final boolean isFlowable;
    private final boolean isMaybe;
    private final boolean isResult;
    private final boolean isSingle;
    private final Type responseType;
    private final z scheduler;
    RxJava2CallAdapter(Type type, z z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        super();
        this.responseType = type;
        this.scheduler = z2;
        this.isAsync = z3;
        this.isResult = z4;
        this.isBody = z5;
        this.isFlowable = z6;
        this.isSingle = z7;
        this.isMaybe = z8;
        this.isCompletable = z9;
    }

    public Object adapt(Call<R> call) {
        r callEnqueueObservable;
        r obj2;
        if (this.isAsync) {
            callEnqueueObservable = new CallEnqueueObservable(call);
        } else {
            callEnqueueObservable = new CallExecuteObservable(call);
        }
        if (this.isResult != null) {
            obj2 = new ResultObservable(callEnqueueObservable);
            callEnqueueObservable = obj2;
        } else {
        }
        obj2 = this.scheduler;
        if (obj2 != null) {
            callEnqueueObservable = callEnqueueObservable.subscribeOn(obj2);
        }
        if (this.isFlowable) {
            return callEnqueueObservable.toFlowable(a.LATEST);
        }
        if (this.isSingle) {
            return callEnqueueObservable.singleOrError();
        }
        if (this.isMaybe) {
            return callEnqueueObservable.singleElement();
        }
        if (this.isCompletable) {
            return callEnqueueObservable.ignoreElements();
        }
        return a.n(callEnqueueObservable);
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.responseType;
    }
}
