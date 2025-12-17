package app.dogo.com.dogo_android.subscription;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.e3.a;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\t\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a'\u0010\n\u001a\u00020\u000b\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\u0006\u0010\u000c\u001a\u0002H\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a'\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\t\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a3\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\t\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a!\u0010\u0010\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a-\u0010\u0010\u001a\u0002H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a'\u0010\u0011\u001a\u00020\u000b\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u00020\u00042\u0006\u0010\u000c\u001a\u0002H\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0012", d2 = {"readReference", "T", "", "reference", "Lcom/google/firebase/database/DatabaseReference;", "type", "Ljava/lang/Class;", "(Lcom/google/firebase/database/DatabaseReference;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readReferences", "", "pushValue", "", "value", "(Lcom/google/firebase/database/DatabaseReference;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readList", "(Lcom/google/firebase/database/DatabaseReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readValue", "saveValue", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DatabaseReferenceKt {
    public static final Object access$readReference(DatabaseReference databaseReference, Class class2, d d3) {
        return DatabaseReferenceKt.readReference(databaseReference, class2, d3);
    }

    public static final Object access$readReferences(DatabaseReference databaseReference, Class class2, d d3) {
        return DatabaseReferenceKt.readReferences(databaseReference, class2, d3);
    }

    public static final <T> Object pushValue(DatabaseReference databaseReference, T t2, d<? super w> d3) {
        DatabaseReference obj1 = databaseReference.push();
        n.e(obj1, "push()");
        obj1 = DatabaseReferenceKt.saveValue(obj1, t2, d3);
        if (obj1 == b.d()) {
            return obj1;
        }
        return w.a;
    }

    public static final <T> Object readList(DatabaseReference databaseReference, Class<T> class2, d<? super List<? extends T>> d3) {
        return DatabaseReferenceKt.readReferences(databaseReference, class2, d3);
    }

    public static final <T> Object readList(DatabaseReference databaseReference, d<? super List<? extends T>> d2) {
        n.l(4, "T");
        throw 0;
    }

    private static final <T> Object readReference(DatabaseReference databaseReference, Class<T> class2, d<? super T> d3) {
        q qVar = new q(b.c(d3), 1);
        qVar.B();
        DatabaseReferenceKt.readReference.2.listener.1 anon = new DatabaseReferenceKt.readReference.2.listener.1(qVar, class2);
        DatabaseReferenceKt.readReference.2.1 obj4 = new DatabaseReferenceKt.readReference.2.1(databaseReference, anon);
        qVar.g(obj4);
        databaseReference.addListenerForSingleValueEvent(anon);
        final Object obj3 = qVar.y();
        if (obj3 == b.d()) {
            h.c(d3);
        }
        return obj3;
    }

    private static final <T> Object readReferences(DatabaseReference databaseReference, Class<T> class2, d<? super List<? extends T>> d3) {
        q qVar = new q(b.c(d3), 1);
        qVar.B();
        DatabaseReferenceKt.readReferences.2.listener.1 anon = new DatabaseReferenceKt.readReferences.2.listener.1(qVar, class2);
        DatabaseReferenceKt.readReferences.2.1 obj4 = new DatabaseReferenceKt.readReferences.2.1(databaseReference, anon);
        qVar.g(obj4);
        databaseReference.addListenerForSingleValueEvent(anon);
        final Object obj3 = qVar.y();
        if (obj3 == b.d()) {
            h.c(d3);
        }
        return obj3;
    }

    public static final <T> Object readValue(DatabaseReference databaseReference, Class<T> class2, d<? super T> d3) {
        return DatabaseReferenceKt.readReference(databaseReference, class2, d3);
    }

    public static final <T> Object readValue(DatabaseReference databaseReference, d<? super T> d2) {
        n.l(4, "T");
        throw 0;
    }

    public static final <T> Object saveValue(DatabaseReference databaseReference, T t2, d<? super w> d3) {
        boolean anon;
        int label;
        int i;
        int i2;
        com.google.android.gms.tasks.j obj4;
        Object obj5;
        Object obj6;
        anon = d3;
        label = anon.label;
        i = Integer.MIN_VALUE;
        if (d3 instanceof DatabaseReferenceKt.saveValue.1 && label & i != 0) {
            anon = d3;
            label = anon.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                anon.label = label -= i;
            } else {
                anon = new DatabaseReferenceKt.saveValue.1(d3);
            }
        } else {
        }
        obj6 = anon.result;
        Object obj = b.d();
        int label2 = anon.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                q.b(obj6);
                return w.a;
            }
            obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
        q.b(obj6);
        obj4 = databaseReference.setValue(t2);
        n.e(obj4, "setValue(value)");
        anon.label = i3;
        if (a.a(obj4, anon) == obj) {
            return obj;
        }
    }
}
