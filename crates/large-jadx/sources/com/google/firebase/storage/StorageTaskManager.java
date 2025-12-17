package com.google.firebase.storage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
class StorageTaskManager {

    private static final com.google.firebase.storage.StorageTaskManager _instance;
    private final Map<String, WeakReference<com.google.firebase.storage.StorageTask<?>>> inProgressTasks;
    private final Object syncObject;
    static {
        StorageTaskManager storageTaskManager = new StorageTaskManager();
        StorageTaskManager._instance = storageTaskManager;
    }

    StorageTaskManager() {
        super();
        HashMap hashMap = new HashMap();
        this.inProgressTasks = hashMap;
        Object object = new Object();
        this.syncObject = object;
    }

    static com.google.firebase.storage.StorageTaskManager getInstance() {
        return StorageTaskManager._instance;
    }

    public void ensureRegistered(com.google.firebase.storage.StorageTask<?> storageTask) {
        final Object syncObject = this.syncObject;
        WeakReference weakReference = new WeakReference(storageTask);
        this.inProgressTasks.put(storageTask.getStorage().toString(), weakReference);
        return;
        synchronized (syncObject) {
            syncObject = this.syncObject;
            weakReference = new WeakReference(storageTask);
            this.inProgressTasks.put(storageTask.getStorage().toString(), weakReference);
        }
    }

    public List<com.google.firebase.storage.FileDownloadTask> getDownloadTasksUnder(com.google.firebase.storage.StorageReference storageReference) {
        Object next;
        boolean startsWith;
        final Object syncObject = this.syncObject;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.inProgressTasks.entrySet().iterator();
        synchronized (syncObject) {
            while (iterator.hasNext()) {
                next = iterator.next();
                next = (WeakReference)next.getValue().get();
                if ((String)(Map.Entry)next.getKey().startsWith(storageReference.toString()) != null && next instanceof FileDownloadTask != null) {
                }
                next = (WeakReference)next.getValue().get();
                if (next instanceof FileDownloadTask != null) {
                }
                arrayList.add((FileDownloadTask)(StorageTask)(StorageTask)next);
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    public List<com.google.firebase.storage.UploadTask> getUploadTasksUnder(com.google.firebase.storage.StorageReference storageReference) {
        Object next;
        boolean startsWith;
        final Object syncObject = this.syncObject;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.inProgressTasks.entrySet().iterator();
        synchronized (syncObject) {
            while (iterator.hasNext()) {
                next = iterator.next();
                next = (WeakReference)next.getValue().get();
                if ((String)(Map.Entry)next.getKey().startsWith(storageReference.toString()) != null && next instanceof UploadTask) {
                }
                next = (WeakReference)next.getValue().get();
                if (next instanceof UploadTask) {
                }
                arrayList.add((UploadTask)(StorageTask)(StorageTask)next);
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    public void unRegister(com.google.firebase.storage.StorageTask<?> storageTask) {
        Object obj;
        Object obj4;
        final Object syncObject = this.syncObject;
        String string = storageTask.getStorage().toString();
        Object obj2 = this.inProgressTasks.get(string);
        synchronized (syncObject) {
            obj = (WeakReference)obj2.get();
            try {
                if (obj != null) {
                } else {
                }
                if (obj == storageTask) {
                }
                this.inProgressTasks.remove(string);
                throw storageTask;
            }
        }
    }
}
