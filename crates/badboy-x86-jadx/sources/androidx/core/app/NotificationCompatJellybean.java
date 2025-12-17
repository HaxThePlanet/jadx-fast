package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
class NotificationCompatJellybean {

    static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_LABEL = "label";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_RESULT_KEY = "resultKey";
    private static final String KEY_SEMANTIC_ACTION = "semanticAction";
    private static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock;
    static {
        Object object = new Object();
        NotificationCompatJellybean.sExtrasLock = object;
        Object object2 = new Object();
        NotificationCompatJellybean.sActionsLock = object2;
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int actionExtrasMap;
        int i;
        Object obj;
        SparseArray sparseArray;
        actionExtrasMap = 0;
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            if ((Bundle)obj != null && actionExtrasMap == null) {
            }
            i++;
            if (actionExtrasMap == null) {
            }
            actionExtrasMap.put(i, (Bundle)obj);
            sparseArray = new SparseArray();
            actionExtrasMap = sparseArray;
        }
        return actionExtrasMap;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        Object sActionsField2;
        Field sActionsField;
        String str;
        String str2 = "Unable to access notification actions";
        final String str3 = "NotificationCompat";
        if (NotificationCompatJellybean.sActionsAccessFailed) {
            return 0;
        }
        int i3 = 1;
        if (NotificationCompatJellybean.sActionsField == null) {
            sActionsField2 = Class.forName("android.app.Notification$Action");
            NotificationCompatJellybean.sActionIconField = sActionsField2.getDeclaredField("icon");
            NotificationCompatJellybean.sActionTitleField = sActionsField2.getDeclaredField("title");
            NotificationCompatJellybean.sActionIntentField = sActionsField2.getDeclaredField("actionIntent");
            NotificationCompatJellybean.sActionsField = Notification.class.getDeclaredField("actions");
            NotificationCompatJellybean.sActionsField.setAccessible(i3);
        }
        return sActionsAccessFailed ^= i3;
    }

    private static androidx.core.app.RemoteInput fromBundle(Bundle data) {
        Object hashSet;
        Object next;
        ArrayList stringArrayList = data.getStringArrayList("allowedDataTypes");
        hashSet = new HashSet();
        final HashSet set = hashSet;
        if (stringArrayList != null) {
            hashSet = stringArrayList.iterator();
            for (String next : hashSet) {
                set.add(next);
            }
        }
        RemoteInput remoteInput = new RemoteInput(data.getString("resultKey"), data.getCharSequence("label"), data.getCharSequenceArray("choices"), data.getBoolean("allowFreeFormInput"), 0, data.getBundle("extras"), set);
        return remoteInput;
    }

    private static androidx.core.app.RemoteInput[] fromBundleArray(Bundle[] bundles) {
        int i;
        androidx.core.app.RemoteInput bundle;
        if (bundles == null) {
            return null;
        }
        androidx.core.app.RemoteInput[] arr = new RemoteInput[bundles.length];
        i = 0;
        for (Object obj : bundles) {
            arr[i] = NotificationCompatJellybean.fromBundle(obj);
        }
        return arr;
    }

    public static androidx.core.app.NotificationCompat.Action getAction(Notification notif, int actionIndex) {
        Object[] actionObjectsLocked;
        String str;
        String str2;
        int actionExtras;
        SparseArray sparseParcelableArray;
        Object obj;
        Object sActionsLock = NotificationCompatJellybean.sActionsLock;
        actionObjectsLocked = NotificationCompatJellybean.getActionObjectsLocked(notif);
        synchronized (sActionsLock) {
            Object obj2 = actionObjectsLocked[actionIndex];
            actionExtras = 0;
            final Bundle extras = NotificationCompatJellybean.getExtras(notif);
            if (extras != null) {
                sparseParcelableArray = extras.getSparseParcelableArray("android.support.actionExtras");
                if (sparseParcelableArray != null) {
                    try {
                        actionExtras = obj;
                        return NotificationCompatJellybean.readAction(NotificationCompatJellybean.sActionIconField.getInt(obj2), (CharSequence)NotificationCompatJellybean.sActionTitleField.get(obj2), (PendingIntent)NotificationCompatJellybean.sActionIntentField.get(obj2), actionExtras);
                        str = "NotificationCompat";
                        Log.e(str, "Unable to access notification actions", th);
                        str = 1;
                        NotificationCompatJellybean.sActionsAccessFailed = str;
                        return null;
                        throw th;
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public static int getActionCount(Notification notif) {
        int length;
        final Object sActionsLock = NotificationCompatJellybean.sActionsLock;
        final Object[] actionObjectsLocked = NotificationCompatJellybean.getActionObjectsLocked(notif);
        synchronized (sActionsLock) {
            length = actionObjectsLocked.length;
            try {
                return length;
                throw actionObjects;
            }
        }
    }

    static androidx.core.app.NotificationCompat.Action getActionFromBundle(Bundle bundle) {
        boolean allowGeneratedReplies;
        String str;
        int i;
        boolean z;
        String str2 = "extras";
        final Bundle bundle2 = bundle.getBundle(str2);
        if (bundle2 != null) {
            z = allowGeneratedReplies;
        } else {
            z = allowGeneratedReplies;
        }
        NotificationCompat.Action action = new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent)bundle.getParcelable("actionIntent"), bundle.getBundle(str2), NotificationCompatJellybean.fromBundleArray(NotificationCompatJellybean.getBundleArrayFromBundle(bundle, "remoteInputs")), NotificationCompatJellybean.fromBundleArray(NotificationCompatJellybean.getBundleArrayFromBundle(bundle, "dataOnlyRemoteInputs")), z, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), 0, 0);
        return action;
    }

    private static Object[] getActionObjectsLocked(Notification notif) {
        final Object sActionsLock = NotificationCompatJellybean.sActionsLock;
        synchronized (sActionsLock) {
            return null;
        }
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle bundle, String key) {
        final android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(key);
        if (!parcelableArray instanceof Bundle[] && parcelableArray == null) {
            if (parcelableArray == null) {
            }
            Object[] copyOf = Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
            bundle.putParcelableArray(key, (Bundle[])copyOf);
            return copyOf;
        }
        return (Bundle[])parcelableArray;
    }

    static Bundle getBundleForAction(androidx.core.app.NotificationCompat.Action action) {
        int resId;
        Bundle actionExtras;
        Object actionIntent;
        Bundle bundle = new Bundle();
        final IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            resId = iconCompat.getResId();
        } else {
            resId = 0;
        }
        bundle.putInt("icon", resId);
        bundle.putCharSequence("title", action.getTitle());
        bundle.putParcelable("actionIntent", action.getActionIntent());
        if (action.getExtras() != null) {
            actionExtras = new Bundle(action.getExtras());
        } else {
            actionExtras = new Bundle();
        }
        actionExtras.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        bundle.putBundle("extras", actionExtras);
        bundle.putParcelableArray("remoteInputs", NotificationCompatJellybean.toBundleArray(action.getRemoteInputs()));
        bundle.putBoolean("showsUserInterface", action.getShowsUserInterface());
        bundle.putInt("semanticAction", action.getSemanticAction());
        return bundle;
    }

    public static Bundle getExtras(Notification notif) {
        Throwable e;
        Field declaredField;
        Object extras;
        String assignableFrom;
        String type;
        final Object sExtrasLock = NotificationCompatJellybean.sExtrasLock;
        final int i2 = 0;
        synchronized (sExtrasLock) {
            return i2;
        }
    }

    public static androidx.core.app.NotificationCompat.Action readAction(int icon, java.lang.CharSequence title, PendingIntent actionIntent, Bundle extras) {
        androidx.core.app.RemoteInput[] remoteInputs;
        androidx.core.app.RemoteInput[] dataOnlyRemoteInputs;
        boolean allowGeneratedReplies;
        String str;
        androidx.core.app.RemoteInput[] objArr;
        androidx.core.app.RemoteInput[] objArr2;
        boolean z;
        if (extras != null) {
            objArr = remoteInputs;
            objArr2 = dataOnlyRemoteInputs;
            z = allowGeneratedReplies;
        } else {
            objArr = remoteInputs;
            objArr2 = dataOnlyRemoteInputs;
            z = allowGeneratedReplies;
        }
        NotificationCompat.Action remoteInputs2 = new NotificationCompat.Action(icon, title, actionIntent, extras, objArr, objArr2, z, 0, 1, 0, 0);
        return remoteInputs2;
    }

    private static Bundle toBundle(androidx.core.app.RemoteInput remoteInput) {
        Bundle arrayList;
        String str;
        Object next;
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInput.getExtras());
        Set allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            if (!allowedDataTypes.isEmpty()) {
                arrayList = new ArrayList(allowedDataTypes.size());
                Iterator iterator = allowedDataTypes.iterator();
                for (String next : iterator) {
                    arrayList.add(next);
                }
                bundle.putStringArrayList("allowedDataTypes", arrayList);
            }
        }
        return bundle;
    }

    private static Bundle[] toBundleArray(androidx.core.app.RemoteInput[] remoteInputs) {
        int i;
        Bundle bundle;
        if (remoteInputs == null) {
            return null;
        }
        Bundle[] arr = new Bundle[remoteInputs.length];
        i = 0;
        for (Object obj : remoteInputs) {
            arr[i] = NotificationCompatJellybean.toBundle(obj);
        }
        return arr;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, androidx.core.app.NotificationCompat.Action action) {
        int resId;
        androidx.core.app.RemoteInput[] remoteInputs;
        androidx.core.app.RemoteInput[] dataOnlyRemoteInputs;
        Object actionIntent;
        final IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            resId = iconCompat.getResId();
        } else {
            resId = 0;
        }
        builder.addAction(resId, action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", NotificationCompatJellybean.toBundleArray(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", NotificationCompatJellybean.toBundleArray(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        return bundle;
    }
}
