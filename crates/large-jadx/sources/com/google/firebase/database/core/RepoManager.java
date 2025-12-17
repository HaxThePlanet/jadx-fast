package com.google.firebase.database.core;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class RepoManager {

    private static final com.google.firebase.database.core.RepoManager instance;
    private final Map<com.google.firebase.database.core.Context, Map<String, com.google.firebase.database.core.Repo>> repos;
    static {
        RepoManager repoManager = new RepoManager();
        RepoManager.instance = repoManager;
    }

    public RepoManager() {
        super();
        HashMap hashMap = new HashMap();
        this.repos = hashMap;
    }

    static Map access$000(com.google.firebase.database.core.RepoManager repoManager) {
        return repoManager.repos;
    }

    public static void clear() {
        RepoManager.instance.clearRepos();
    }

    private void clearRepos() {
        final Map repos = this.repos;
        this.repos.clear();
        return;
        synchronized (repos) {
            repos = this.repos;
            this.repos.clear();
        }
    }

    private com.google.firebase.database.core.Repo createLocalRepo(com.google.firebase.database.core.Context context, com.google.firebase.database.core.RepoInfo repoInfo2, FirebaseDatabase firebaseDatabase3) {
        boolean hashMap;
        Map repos;
        context.freeze();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(repoInfo2.host);
        stringBuilder.append("/");
        stringBuilder.append(repoInfo2.namespace);
        String string = stringBuilder.toString();
        Map repos2 = this.repos;
        synchronized (repos2) {
            hashMap = new HashMap();
            this.repos.put(context, hashMap);
            Object obj = this.repos.get(context);
            if ((Map)obj.containsKey(string)) {
            } else {
                Repo repo = new Repo(repoInfo2, context, firebaseDatabase3);
                obj.put(string, repo);
                return repo;
            }
            IllegalStateException obj5 = new IllegalStateException("createLocalRepo() called for existing repo.");
            throw obj5;
        }
    }

    public static com.google.firebase.database.core.Repo createRepo(com.google.firebase.database.core.Context context, com.google.firebase.database.core.RepoInfo repoInfo2, FirebaseDatabase firebaseDatabase3) {
        return RepoManager.instance.createLocalRepo(context, repoInfo2, firebaseDatabase3);
    }

    private com.google.firebase.database.core.Repo getLocalRepo(com.google.firebase.database.core.Context context, com.google.firebase.database.core.RepoInfo repoInfo2) {
        boolean instance;
        Object obj;
        context.freeze();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://");
        stringBuilder.append(repoInfo2.host);
        stringBuilder.append("/");
        stringBuilder.append(repoInfo2.namespace);
        String string = stringBuilder.toString();
        Map repos = this.repos;
        synchronized (repos) {
            if (!(Map)this.repos.get(context).containsKey(string)) {
                InternalHelpers.createDatabaseForTests(FirebaseApp.getInstance(), repoInfo2, (DatabaseConfig)context);
            }
            return (Repo)(Map)this.repos.get(context).get(string);
        }
    }

    public static com.google.firebase.database.core.Repo getRepo(com.google.firebase.database.core.Context context, com.google.firebase.database.core.RepoInfo repoInfo2) {
        return RepoManager.instance.getLocalRepo(context, repoInfo2);
    }

    public static void interrupt(com.google.firebase.database.core.Context context) {
        RepoManager.instance.interruptInternal(context);
    }

    public static void interrupt(com.google.firebase.database.core.Repo repo) {
        RepoManager.1 anon = new RepoManager.1(repo);
        repo.scheduleNow(anon);
    }

    private void interruptInternal(com.google.firebase.database.core.Context context) {
        com.google.firebase.database.core.RepoManager.3 anon;
        final com.google.firebase.database.core.RunLoop runLoop = context.getRunLoop();
        if (runLoop != null) {
            anon = new RepoManager.3(this, context);
            runLoop.scheduleNow(anon);
        }
    }

    public static void resume(com.google.firebase.database.core.Context context) {
        RepoManager.instance.resumeInternal(context);
    }

    public static void resume(com.google.firebase.database.core.Repo repo) {
        RepoManager.2 anon = new RepoManager.2(repo);
        repo.scheduleNow(anon);
    }

    private void resumeInternal(com.google.firebase.database.core.Context context) {
        com.google.firebase.database.core.RepoManager.4 anon;
        final com.google.firebase.database.core.RunLoop runLoop = context.getRunLoop();
        if (runLoop != null) {
            anon = new RepoManager.4(this, context);
            runLoop.scheduleNow(anon);
        }
    }
}
