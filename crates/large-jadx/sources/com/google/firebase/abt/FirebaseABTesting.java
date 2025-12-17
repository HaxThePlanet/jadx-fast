package com.google.firebase.abt;

import android.content.Context;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import com.google.firebase.inject.Provider;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class FirebaseABTesting {

    static final String ABT_PREFERENCES = "com.google.firebase.abt";
    static final String ORIGIN_LAST_KNOWN_START_TIME_KEY_FORMAT = "%s_lastKnownExperimentStartTime";
    private final Provider<AnalyticsConnector> analyticsConnector;
    private Integer maxUserProperties = null;
    private final String originService;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OriginService {

        public static final String INAPP_MESSAGING = "fiam";
        public static final String REMOTE_CONFIG = "frc";
    }
    public FirebaseABTesting(Context context, Provider<AnalyticsConnector> provider2, String string3) {
        super();
        this.analyticsConnector = provider2;
        this.originService = string3;
        final int obj1 = 0;
    }

    private void addExperimentToAnalytics(AnalyticsConnector.ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        (AnalyticsConnector)this.analyticsConnector.get().setConditionalUserProperty(conditionalUserProperty);
    }

    private void addExperiments(List<com.google.firebase.abt.AbtExperimentInfo> list) {
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty;
        String originService;
        ArrayDeque arrayDeque = new ArrayDeque(getAllExperimentsInAnalytics());
        final Iterator obj5 = list.iterator();
        for (AbtExperimentInfo next2 : obj5) {
            while (arrayDeque.size() >= getMaxUserPropertiesInAnalytics()) {
                removeExperimentFromAnalytics(pollFirst.name);
            }
            conditionalUserProperty = next2.toConditionalUserProperty(this.originService);
            addExperimentToAnalytics(conditionalUserProperty);
            arrayDeque.offer(conditionalUserProperty);
            removeExperimentFromAnalytics(pollFirst.name);
        }
    }

    private static List<com.google.firebase.abt.AbtExperimentInfo> convertMapsToExperimentInfos(List<Map<String, String>> list) {
        com.google.firebase.abt.AbtExperimentInfo map;
        ArrayList arrayList = new ArrayList();
        final Iterator obj2 = list.iterator();
        for (Map next2 : obj2) {
            arrayList.add(AbtExperimentInfo.fromMap(next2));
        }
        return arrayList;
    }

    private List<AnalyticsConnector.ConditionalUserProperty> getAllExperimentsInAnalytics() {
        return (AnalyticsConnector)this.analyticsConnector.get().getConditionalUserProperties(this.originService, "");
    }

    private ArrayList<com.google.firebase.abt.AbtExperimentInfo> getExperimentsToAdd(List<com.google.firebase.abt.AbtExperimentInfo> list, Set<String> set2) {
        Object next;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        final Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            next = obj4.next();
            if (!set2.contains((AbtExperimentInfo)next.getExperimentId())) {
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private ArrayList<AnalyticsConnector.ConditionalUserProperty> getExperimentsToRemove(List<AnalyticsConnector.ConditionalUserProperty> list, Set<String> set2) {
        Object next;
        boolean contains;
        ArrayList arrayList = new ArrayList();
        final Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            next = obj4.next();
            if (!set2.contains(next.name)) {
            }
            arrayList.add((AnalyticsConnector.ConditionalUserProperty)next);
        }
        return arrayList;
    }

    private int getMaxUserPropertiesInAnalytics() {
        Integer maxUserProperties;
        String originService;
        if (this.maxUserProperties == null) {
            this.maxUserProperties = Integer.valueOf((AnalyticsConnector)this.analyticsConnector.get().getMaxUserProperties(this.originService));
        }
        return this.maxUserProperties.intValue();
    }

    private void removeExperimentFromAnalytics(String string) {
        final int i = 0;
        (AnalyticsConnector)this.analyticsConnector.get().clearConditionalUserProperty(string, i, i);
    }

    private void removeExperiments(Collection<AnalyticsConnector.ConditionalUserProperty> collection) {
        String name;
        final Iterator obj2 = collection.iterator();
        for (AnalyticsConnector.ConditionalUserProperty next2 : obj2) {
            removeExperimentFromAnalytics(next2.name);
        }
    }

    private void replaceAllExperimentsWith(List<com.google.firebase.abt.AbtExperimentInfo> list) {
        String experimentId;
        String name;
        if (list.isEmpty()) {
            removeAllExperiments();
        }
        HashSet hashSet = new HashSet();
        Iterator iterator = list.iterator();
        for (AbtExperimentInfo next2 : iterator) {
            hashSet.add(next2.getExperimentId());
        }
        List allExperimentsInAnalytics = getAllExperimentsInAnalytics();
        HashSet hashSet2 = new HashSet();
        final Iterator iterator2 = allExperimentsInAnalytics.iterator();
        for (AnalyticsConnector.ConditionalUserProperty next4 : iterator2) {
            hashSet2.add(next4.name);
        }
        removeExperiments(getExperimentsToRemove(allExperimentsInAnalytics, hashSet));
        addExperiments(getExperimentsToAdd(list, hashSet2));
    }

    private void throwAbtExceptionIfAnalyticsIsNull() {
        if (this.analyticsConnector.get() == null) {
        } else {
        }
        AbtException abtException = new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        throw abtException;
    }

    public List<com.google.firebase.abt.AbtExperimentInfo> getAllExperiments() {
        com.google.firebase.abt.AbtExperimentInfo conditionalUserProperty;
        throwAbtExceptionIfAnalyticsIsNull();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = getAllExperimentsInAnalytics().iterator();
        for (AnalyticsConnector.ConditionalUserProperty next2 : iterator) {
            arrayList.add(AbtExperimentInfo.fromConditionalUserProperty(next2));
        }
        return arrayList;
    }

    public void removeAllExperiments() {
        throwAbtExceptionIfAnalyticsIsNull();
        removeExperiments(getAllExperimentsInAnalytics());
    }

    public void replaceAllExperiments(List<Map<String, String>> list) {
        throwAbtExceptionIfAnalyticsIsNull();
        if (list == null) {
        } else {
            replaceAllExperimentsWith(FirebaseABTesting.convertMapsToExperimentInfos(list));
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("The replacementExperiments list is null.");
        throw obj2;
    }

    public void reportActiveExperiment(com.google.firebase.abt.AbtExperimentInfo abtExperimentInfo) {
        throwAbtExceptionIfAnalyticsIsNull();
        AbtExperimentInfo.validateAbtExperimentInfo(abtExperimentInfo);
        ArrayList arrayList = new ArrayList();
        Map obj3 = abtExperimentInfo.toStringMap();
        obj3.remove("triggerEvent");
        arrayList.add(AbtExperimentInfo.fromMap(obj3));
        addExperiments(arrayList);
    }

    public void validateRunningExperiments(List<com.google.firebase.abt.AbtExperimentInfo> list) {
        String experimentId;
        throwAbtExceptionIfAnalyticsIsNull();
        HashSet hashSet = new HashSet();
        Iterator obj3 = list.iterator();
        for (AbtExperimentInfo next2 : obj3) {
            hashSet.add(next2.getExperimentId());
        }
        removeExperiments(getExperimentsToRemove(getAllExperimentsInAnalytics(), hashSet));
    }
}
