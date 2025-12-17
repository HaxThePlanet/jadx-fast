package com.google.firebase.database.core;

import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes2.dex */
public class ZombieEventManager implements com.google.firebase.database.core.EventRegistrationZombieListener {

    private static com.google.firebase.database.core.ZombieEventManager defaultInstance;
    final HashMap<com.google.firebase.database.core.EventRegistration, List<com.google.firebase.database.core.EventRegistration>> globalEventRegistrations;
    static {
        ZombieEventManager zombieEventManager = new ZombieEventManager();
        ZombieEventManager.defaultInstance = zombieEventManager;
    }

    private ZombieEventManager() {
        super();
        HashMap hashMap = new HashMap();
        this.globalEventRegistrations = hashMap;
    }

    public static com.google.firebase.database.core.ZombieEventManager getInstance() {
        return ZombieEventManager.defaultInstance;
    }

    private void unRecordEventRegistration(com.google.firebase.database.core.EventRegistration eventRegistration) {
        Object globalEventRegistrations;
        boolean default;
        int i;
        int i2;
        int size2;
        Object size;
        Object obj7;
        final HashMap globalEventRegistrations2 = this.globalEventRegistrations;
        globalEventRegistrations = this.globalEventRegistrations.get(eventRegistration);
        i2 = 0;
        size2 = i2;
        synchronized (globalEventRegistrations2) {
            while (size2 < (List)globalEventRegistrations.size()) {
                size2++;
            }
            size2 = i2;
            if (globalEventRegistrations.isEmpty()) {
                this.globalEventRegistrations.remove(eventRegistration);
            }
            if (size2 == 0) {
                if (!eventRegistration.isUserInitiated()) {
                } else {
                    i = i2;
                }
            }
            Utilities.hardAssert(i);
            default = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()));
            i = this.globalEventRegistrations.get(default);
            if (!eventRegistration.getQuerySpec().isDefault() && (List)i != null) {
                default = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()));
                i = this.globalEventRegistrations.get(default);
                if ((List)(List)i != null) {
                }
            }
        }
    }

    @Override // com.google.firebase.database.core.EventRegistrationZombieListener
    public void onZombied(com.google.firebase.database.core.EventRegistration eventRegistration) {
        unRecordEventRegistration(eventRegistration);
    }

    @Override // com.google.firebase.database.core.EventRegistrationZombieListener
    public void recordEventRegistration(com.google.firebase.database.core.EventRegistration eventRegistration) {
        Object arrayList;
        boolean default;
        HashMap globalEventRegistrations2;
        HashMap globalEventRegistrations;
        final HashMap globalEventRegistrations3 = this.globalEventRegistrations;
        synchronized (globalEventRegistrations3) {
            arrayList = new ArrayList();
            this.globalEventRegistrations.put(eventRegistration, arrayList);
            arrayList.add(eventRegistration);
            default = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()));
            if (!eventRegistration.getQuerySpec().isDefault() && (List)this.globalEventRegistrations.get(default) == null) {
                try {
                    default = eventRegistration.clone(QuerySpec.defaultQueryAtPath(eventRegistration.getQuerySpec().getPath()));
                    if ((List)this.globalEventRegistrations.get(default) == null) {
                    }
                    globalEventRegistrations2 = new ArrayList();
                    this.globalEventRegistrations.put(default, globalEventRegistrations2);
                    globalEventRegistrations2.add(eventRegistration);
                    eventRegistration.setIsUserInitiated(true);
                    eventRegistration.setOnZombied(this);
                    throw eventRegistration;
                }
            }
        }
    }

    @Override // com.google.firebase.database.core.EventRegistrationZombieListener
    public void zombifyForRemove(com.google.firebase.database.core.EventRegistration eventRegistration) {
        boolean empty;
        Object obj;
        boolean querySpec;
        Object obj6;
        final HashMap globalEventRegistrations = this.globalEventRegistrations;
        Object obj2 = this.globalEventRegistrations.get(eventRegistration);
        synchronized (globalEventRegistrations) {
            if (!(List)obj2.isEmpty()) {
                if (eventRegistration.getQuerySpec().isDefault()) {
                    try {
                        obj6 = new HashSet();
                        size--;
                        while (empty >= 0) {
                            obj = obj2.get(empty);
                            if (!obj6.contains((EventRegistration)obj.getQuerySpec())) {
                            }
                            empty--;
                            obj6.add(obj.getQuerySpec());
                            obj.zombify();
                        }
                        obj = obj2.get(empty);
                        if (!obj6.contains((EventRegistration)obj.getQuerySpec())) {
                        }
                        obj6.add(obj.getQuerySpec());
                        obj.zombify();
                        empty--;
                        (EventRegistration)obj2.get(0).zombify();
                        throw eventRegistration;
                    }
                } else {
                }
            }
        }
    }
}
