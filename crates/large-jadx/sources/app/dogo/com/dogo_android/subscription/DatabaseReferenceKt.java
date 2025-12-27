package app.dogo.com.dogo_android.subscription;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.e3.a;
import kotlinx.coroutines.p;

/* compiled from: DatabaseReference.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\t\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a'\u0010\n\u001a\u00020\u000b\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\u0006\u0010\u000c\u001a\u0002H\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a'\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\t\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a3\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\t\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a!\u0010\u0010\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a-\u0010\u0010\u001a\u0002H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a'\u0010\u0011\u001a\u00020\u000b\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\u0006\u0010\u000c\u001a\u0002H\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0012", d2 = {"readReference", "T", "", "reference", "Lcom/google/firebase/database/DatabaseReference;", "type", "Ljava/lang/Class;", "(Lcom/google/firebase/database/DatabaseReference;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readReferences", "", "pushValue", "", "value", "(Lcom/google/firebase/database/DatabaseReference;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readList", "(Lcom/google/firebase/database/DatabaseReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readValue", "saveValue", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class DatabaseReferenceKt {
    public static final /* synthetic */ Object access$readReference(DatabaseReference databaseReference, Class cls, d dVar) {
        return DatabaseReferenceKt.readReference(databaseReference, cls, dVar);
    }

    public static final /* synthetic */ Object access$readReferences(DatabaseReference databaseReference, Class cls, d dVar) {
        return DatabaseReferenceKt.readReferences(databaseReference, cls, dVar);
    }

    /* suspend */ public static final <T> Object pushValue(DatabaseReference value, T t, d<? super w> dVar) {
        DatabaseReference push = value.push();
        n.e(push, "push()");
        Object value2 = DatabaseReferenceKt.saveValue(push, t, dVar);
        if (value2 == b.d()) {
            return value2;
        }
        return w.a;
    }

    /* suspend inline */ public static final <T> Object readList(DatabaseReference type, Class<T> cls, d<? super List<? extends T>> dVar) {
        return DatabaseReferenceKt.readReferences(type, cls, dVar);
    }

    /* suspend */ private static final <T> Object readReference(DatabaseReference reference, Class<T> type, d<? super T> dVar) {
        final kotlinx.coroutines.q cancellableContinuationImpl = new CancellableContinuationImpl(b.c(dVar), 1);
        cancellableContinuationImpl.B();
        app.dogo.com.dogo_android.subscription.DatabaseReferenceKt.readReference.AnonymousClass2.listener.AnonymousClass1 databaseReferenceKt_readReference_2_listener_1 = new DatabaseReferenceKt_readReference_2_listener_1(cancellableContinuationImpl, type);
        cancellableContinuationImpl.g(new DatabaseReferenceKt.readReference.AnonymousClass2.AnonymousClass1(reference, databaseReferenceKt_readReference_2_listener_1));
        reference.addListenerForSingleValueEvent(databaseReferenceKt_readReference_2_listener_1);
        final Object obj = cancellableContinuationImpl.y();
        if (obj == b.d()) {
            h.c(dVar);
        }
        return obj;
    }

    /* suspend */ private static final <T> Object readReferences(DatabaseReference reference, Class<T> type, d<? super List<? extends T>> dVar) {
        final kotlinx.coroutines.q cancellableContinuationImpl = new CancellableContinuationImpl(b.c(dVar), 1);
        cancellableContinuationImpl.B();
        app.dogo.com.dogo_android.subscription.DatabaseReferenceKt.readReferences.AnonymousClass2.listener.AnonymousClass1 databaseReferenceKt_readReferences_2_listener_1 = new DatabaseReferenceKt_readReferences_2_listener_1(cancellableContinuationImpl, type);
        cancellableContinuationImpl.g(new DatabaseReferenceKt.readReferences.AnonymousClass2.AnonymousClass1(reference, databaseReferenceKt_readReferences_2_listener_1));
        reference.addListenerForSingleValueEvent(databaseReferenceKt_readReferences_2_listener_1);
        final Object obj = cancellableContinuationImpl.y();
        if (obj == b.d()) {
            h.c(dVar);
        }
        return obj;
    }

    /* suspend inline */ public static final <T> Object readValue(DatabaseReference type, Class<T> cls, d<? super T> dVar) {
        return DatabaseReferenceKt.readReference(type, cls, dVar);
    }

    /* suspend */ public static final <T> Object saveValue(DatabaseReference value, T t, d<? super w> dVar) {
        Object dVar32;
        int label2;
        int i = -2147483648;
        int i2;
        z = dVar instanceof DatabaseReferenceKt.saveValue.AnonymousClass1;
        if (dVar instanceof DatabaseReferenceKt.saveValue.AnonymousClass1) {
            dVar32 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.subscription.DatabaseReferenceKt.saveValue.AnonymousClass1 anonymousClass1 = new DatabaseReferenceKt.saveValue.AnonymousClass1(dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar32.label != 0) {
            if (dVar32.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar32.result);
                return w.a;
            }
        }
        q.b(dVar32.result);
        com.google.android.gms.tasks.j value2 = value.setValue(t);
        str = "setValue(value)";
        n.e(value2, str);
        dVar32.label = i3;
        if (a.a(value2, dVar32) == obj) {
            return obj;
        }
    }

    public static final /* synthetic */ <T> Object readList(DatabaseReference databaseReference, d<? super List<? extends T>> dVar) {
        n.l(4, "T");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    public static final /* synthetic */ <T> Object readValue(DatabaseReference databaseReference, d<? super T> dVar) {
        n.l(4, "T");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }
}
