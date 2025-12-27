@Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/subscription/DatabaseReferenceKt$readReference$2$listener$1", "Lcom/google/firebase/database/ValueEventListener;", "onCancelled", "", "error", "Lcom/google/firebase/database/DatabaseError;", "onDataChange", "snapshot", "Lcom/google/firebase/database/DataSnapshot;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: 1 */
public static final class DatabaseReferenceKt_readReference_2_listener_1 implements com.google.firebase.database.ValueEventListener {

    final /* synthetic */ kotlinx.coroutines.p<T> $continuation;
    final /* synthetic */ Class<T> $type;
    1(kotlinx.coroutines.p<? super T> pVar, Class<T> cls) {
        this.$continuation = pVar;
        this.$type = cls;
        super();
    }

    public void onCancelled(com.google.firebase.database.DatabaseError error) {
        n.f(error, "error");
        com.google.firebase.database.DatabaseException exception = error.toException();
        n.e(exception, "error.toException()");
        Object obj = q.a(exception);
        Result.a(obj);
        this.$continuation.resumeWith(obj);
    }

    public void onDataChange(com.google.firebase.database.DataSnapshot snapshot) {
        n.f(snapshot, "snapshot");
        try {
            Object value = snapshot.getValue(this.$type);
            n.d(value);
            aVar = Result.a;
            Result.a(value);
            this.$continuation.resumeWith(value);
        } catch (Exception e) {
            e = q.a(e);
            Result.a(e);
            this.$continuation.resumeWith(e);
        }
    }
}
