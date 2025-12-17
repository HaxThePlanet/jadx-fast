package com.google.firebase.database;

import com.google.android.gms.tasks.j;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Map;

/* loaded from: classes2.dex */
public class OnDisconnect {

    private Path path;
    private Repo repo;
    OnDisconnect(Repo repo, Path path2) {
        super();
        this.repo = repo;
        this.path = path2;
    }

    static Path access$000(com.google.firebase.database.OnDisconnect onDisconnect) {
        return onDisconnect.path;
    }

    static Repo access$100(com.google.firebase.database.OnDisconnect onDisconnect) {
        return onDisconnect.repo;
    }

    private j<Void> cancelInternal(com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener) {
        Pair obj3 = Utilities.wrapOnComplete(completionListener);
        OnDisconnect.3 anon = new OnDisconnect.3(this, obj3);
        this.repo.scheduleNow(anon);
        return (j)obj3.getFirst();
    }

    private j<Void> onDisconnectSetInternal(Object object, Node node2, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener3) {
        Validation.validateWritablePath(this.path);
        ValidationPath.validateWithObject(this.path, object);
        Object obj2 = CustomClassMapper.convertToPlainJavaTypes(object);
        Validation.validateWritableObject(obj2);
        final Pair obj3 = Utilities.wrapOnComplete(completionListener3);
        OnDisconnect.1 anon = new OnDisconnect.1(this, NodeUtilities.NodeFromJSON(obj2, node2), obj3);
        this.repo.scheduleNow(anon);
        return (j)obj3.getFirst();
    }

    private j<Void> updateChildrenInternal(Map<String, Object> map, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        final Pair obj5 = Utilities.wrapOnComplete(completionListener2);
        OnDisconnect.2 anon = new OnDisconnect.2(this, Validation.parseAndValidateUpdate(this.path, map), obj5, map);
        this.repo.scheduleNow(anon);
        return (j)obj5.getFirst();
    }

    public j<Void> cancel() {
        return cancelInternal(0);
    }

    public void cancel(com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener) {
        cancelInternal(completionListener);
    }

    public j<Void> removeValue() {
        return setValue(0);
    }

    public void removeValue(com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener) {
        setValue(0, completionListener);
    }

    public j<Void> setValue(Object object) {
        return onDisconnectSetInternal(object, PriorityUtilities.NullPriority(), 0);
    }

    public j<Void> setValue(Object object, double d2) {
        return onDisconnectSetInternal(object, PriorityUtilities.parsePriority(this.path, Double.valueOf(d2)), 0);
    }

    public j<Void> setValue(Object object, String string2) {
        return onDisconnectSetInternal(object, PriorityUtilities.parsePriority(this.path, string2), 0);
    }

    public void setValue(Object object, double d2, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener3) {
        onDisconnectSetInternal(object, PriorityUtilities.parsePriority(this.path, Double.valueOf(d2)), obj5);
    }

    public void setValue(Object object, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        onDisconnectSetInternal(object, PriorityUtilities.NullPriority(), completionListener2);
    }

    public void setValue(Object object, String string2, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener3) {
        onDisconnectSetInternal(object, PriorityUtilities.parsePriority(this.path, string2), completionListener3);
    }

    public void setValue(Object object, Map map2, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener3) {
        onDisconnectSetInternal(object, PriorityUtilities.parsePriority(this.path, map2), completionListener3);
    }

    public j<Void> updateChildren(Map<String, Object> map) {
        return updateChildrenInternal(map, 0);
    }

    public void updateChildren(Map<String, Object> map, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        updateChildrenInternal(map, completionListener2);
    }
}
