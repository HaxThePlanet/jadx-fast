package com.google.firebase.database;

import com.google.android.gms.tasks.j;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class DatabaseReference extends com.google.firebase.database.Query {

    private static DatabaseConfig defaultConfig;

    public interface CompletionListener {
        public abstract void onComplete(com.google.firebase.database.DatabaseError databaseError, com.google.firebase.database.DatabaseReference databaseReference2);
    }
    DatabaseReference(Repo repo, Path path2) {
        super(repo, path2);
    }

    private DatabaseReference(ParsedUrl parsedUrl, DatabaseConfig databaseConfig2) {
        super(RepoManager.getRepo(databaseConfig2, parsedUrl.repoInfo), parsedUrl.path);
    }

    DatabaseReference(String string, DatabaseConfig databaseConfig2) {
        super(Utilities.parseUrl(string), databaseConfig2);
    }

    private static DatabaseConfig getDefaultConfig() {
        DatabaseConfig databaseConfig;
        final Class<com.google.firebase.database.DatabaseReference> obj = DatabaseReference.class;
        synchronized (obj) {
            databaseConfig = new DatabaseConfig();
            DatabaseReference.defaultConfig = databaseConfig;
            return DatabaseReference.defaultConfig;
        }
    }

    public static void goOffline() {
        DatabaseReference.goOffline(DatabaseReference.getDefaultConfig());
    }

    static void goOffline(DatabaseConfig databaseConfig) {
        RepoManager.interrupt(databaseConfig);
    }

    public static void goOnline() {
        DatabaseReference.goOnline(DatabaseReference.getDefaultConfig());
    }

    static void goOnline(DatabaseConfig databaseConfig) {
        RepoManager.resume(databaseConfig);
    }

    private j<Void> setPriorityInternal(Node node, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        Validation.validateWritablePath(getPath());
        final Pair obj4 = Utilities.wrapOnComplete(completionListener2);
        DatabaseReference.2 anon = new DatabaseReference.2(this, node, obj4);
        this.repo.scheduleNow(anon);
        return (j)obj4.getFirst();
    }

    private j<Void> setValueInternal(Object object, Node node2, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener3) {
        Validation.validateWritablePath(getPath());
        ValidationPath.validateWithObject(getPath(), object);
        Object obj2 = CustomClassMapper.convertToPlainJavaTypes(object);
        Validation.validateWritableObject(obj2);
        final Pair obj3 = Utilities.wrapOnComplete(completionListener3);
        DatabaseReference.1 anon = new DatabaseReference.1(this, NodeUtilities.NodeFromJSON(obj2, node2), obj3);
        this.repo.scheduleNow(anon);
        return (j)obj3.getFirst();
    }

    private j<Void> updateChildrenInternal(Map<String, Object> map, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        Objects.requireNonNull(map, "Can't pass null for argument 'update' in updateChildren()");
        Map obj4 = CustomClassMapper.convertToPlainJavaTypes(map);
        final Pair obj5 = Utilities.wrapOnComplete(completionListener2);
        DatabaseReference.3 anon = new DatabaseReference.3(this, CompoundWrite.fromPathMerge(Validation.parseAndValidateUpdate(getPath(), obj4)), obj5, obj4);
        this.repo.scheduleNow(anon);
        return (j)obj5.getFirst();
    }

    @Override // com.google.firebase.database.Query
    public com.google.firebase.database.DatabaseReference child(String string) {
        Objects.requireNonNull(string, "Can't pass null for argument 'pathString' in child()");
        if (getPath().isEmpty()) {
            Validation.validateRootPathString(string);
        } else {
            Validation.validatePathString(string);
        }
        Path path3 = new Path(string);
        DatabaseReference databaseReference = new DatabaseReference(this.repo, getPath().child(path3));
        return databaseReference;
    }

    @Override // com.google.firebase.database.Query
    public boolean equals(Object object) {
        boolean string;
        Object obj2;
        if (object instanceof DatabaseReference != null && toString().equals(object.toString())) {
            obj2 = toString().equals(object.toString()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // com.google.firebase.database.Query
    public com.google.firebase.database.FirebaseDatabase getDatabase() {
        return this.repo.getDatabase();
    }

    @Override // com.google.firebase.database.Query
    public String getKey() {
        if (getPath().isEmpty()) {
            return null;
        }
        return getPath().getBack().asString();
    }

    @Override // com.google.firebase.database.Query
    public com.google.firebase.database.DatabaseReference getParent() {
        Path parent = getPath().getParent();
        if (parent != null) {
            DatabaseReference databaseReference = new DatabaseReference(this.repo, parent);
            return databaseReference;
        }
        return null;
    }

    @Override // com.google.firebase.database.Query
    public com.google.firebase.database.DatabaseReference getRoot() {
        Path path = new Path("");
        DatabaseReference databaseReference = new DatabaseReference(this.repo, path);
        return databaseReference;
    }

    @Override // com.google.firebase.database.Query
    public int hashCode() {
        return toString().hashCode();
    }

    @Override // com.google.firebase.database.Query
    public com.google.firebase.database.OnDisconnect onDisconnect() {
        Validation.validateWritablePath(getPath());
        OnDisconnect onDisconnect = new OnDisconnect(this.repo, getPath());
        return onDisconnect;
    }

    @Override // com.google.firebase.database.Query
    public com.google.firebase.database.DatabaseReference push() {
        DatabaseReference databaseReference = new DatabaseReference(this.repo, getPath().child(ChildKey.fromString(PushIdGenerator.generatePushChildName(this.repo.getServerTime()))));
        return databaseReference;
    }

    public j<Void> removeValue() {
        return setValue(0);
    }

    @Override // com.google.firebase.database.Query
    public void removeValue(com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener) {
        setValue(0, completionListener);
    }

    @Override // com.google.firebase.database.Query
    public void runTransaction(com.google.firebase.database.Transaction.Handler transaction$Handler) {
        runTransaction(handler, true);
    }

    @Override // com.google.firebase.database.Query
    public void runTransaction(com.google.firebase.database.Transaction.Handler transaction$Handler, boolean z2) {
        Objects.requireNonNull(handler, "Can't pass null for argument 'handler' in runTransaction()");
        Validation.validateWritablePath(getPath());
        DatabaseReference.4 anon = new DatabaseReference.4(this, handler, z2);
        this.repo.scheduleNow(anon);
    }

    @Override // com.google.firebase.database.Query
    void setHijackHash(boolean z) {
        DatabaseReference.5 anon = new DatabaseReference.5(this, z);
        this.repo.scheduleNow(anon);
    }

    public j<Void> setPriority(Object object) {
        return setPriorityInternal(PriorityUtilities.parsePriority(this.path, object), 0);
    }

    @Override // com.google.firebase.database.Query
    public void setPriority(Object object, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        setPriorityInternal(PriorityUtilities.parsePriority(this.path, object), completionListener2);
    }

    public j<Void> setValue(Object object) {
        final int i = 0;
        return setValueInternal(object, PriorityUtilities.parsePriority(this.path, i), i);
    }

    public j<Void> setValue(Object object, Object object2) {
        return setValueInternal(object, PriorityUtilities.parsePriority(this.path, object2), 0);
    }

    @Override // com.google.firebase.database.Query
    public void setValue(Object object, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        setValueInternal(object, PriorityUtilities.parsePriority(this.path, 0), completionListener2);
    }

    @Override // com.google.firebase.database.Query
    public void setValue(Object object, Object object2, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener3) {
        setValueInternal(object, PriorityUtilities.parsePriority(this.path, object2), completionListener3);
    }

    @Override // com.google.firebase.database.Query
    public String toString() {
        com.google.firebase.database.DatabaseReference parent = getParent();
        if (parent == null) {
            return this.repo.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parent.toString());
        stringBuilder.append("/");
        stringBuilder.append(URLEncoder.encode(getKey(), "UTF-8").replace("+", "%20"));
        return stringBuilder.toString();
    }

    public j<Void> updateChildren(Map<String, Object> map) {
        return updateChildrenInternal(map, 0);
    }

    public void updateChildren(Map<String, Object> map, com.google.firebase.database.DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        updateChildrenInternal(map, completionListener2);
    }
}
