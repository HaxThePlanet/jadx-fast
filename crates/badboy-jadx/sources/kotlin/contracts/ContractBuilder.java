package kotlin.contracts;

import kotlin.Function;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008g\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H'J\u0008\u0010\t\u001a\u00020\nH'J\u0012\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001H'J\u0008\u0010\u000c\u001a\u00020\rH'¨\u0006\u000e", d2 = {"Lkotlin/contracts/ContractBuilder;", "", "callsInPlace", "Lkotlin/contracts/CallsInPlace;", "R", "lambda", "Lkotlin/Function;", "kind", "Lkotlin/contracts/InvocationKind;", "returns", "Lkotlin/contracts/Returns;", "value", "returnsNotNull", "Lkotlin/contracts/ReturnsNotNull;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ContractBuilder {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static kotlin.contracts.CallsInPlace callsInPlace$default(kotlin.contracts.ContractBuilder contractBuilder, Function function2, kotlin.contracts.InvocationKind invocationKind3, int i4, Object object5) {
            kotlin.contracts.InvocationKind obj2;
            if (object5 != null) {
            } else {
                if (i4 &= 2 != 0) {
                    obj2 = InvocationKind.UNKNOWN;
                }
                return contractBuilder.callsInPlace(function2, obj2);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            throw obj0;
        }
    }
    public abstract <R> kotlin.contracts.CallsInPlace callsInPlace(Function<? extends R> function, kotlin.contracts.InvocationKind invocationKind2);

    public abstract kotlin.contracts.Returns returns();

    public abstract kotlin.contracts.Returns returns(Object object);

    public abstract kotlin.contracts.ReturnsNotNull returnsNotNull();
}
