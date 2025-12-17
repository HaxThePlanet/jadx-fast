package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class ShortcutInfoCompat {

    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    java.lang.CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled = true;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    java.lang.CharSequence mLabel;
    long mLastChangedTimestamp;
    LocusIdCompat mLocusId;
    java.lang.CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    private static class Api33Impl {
        static void setExcludedFromSurfaces(ShortcutInfo.Builder builder, int surfaces) {
            builder.setExcludedFromSurfaces(surfaces);
        }
    }

    public static class Builder {

        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final androidx.core.content.pm.ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;
        public Builder(Context context, ShortcutInfo shortcutInfo) {
            int sDK_INT;
            int cached;
            super();
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            mInfo.mContext = context;
            mInfo2.mId = shortcutInfo.getId();
            mInfo3.mPackageName = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            mInfo4.mIntents = (Intent[])Arrays.copyOf(intents, intents.length);
            mInfo5.mActivity = shortcutInfo.getActivity();
            mInfo6.mLabel = shortcutInfo.getShortLabel();
            mInfo7.mLongLabel = shortcutInfo.getLongLabel();
            mInfo8.mDisabledMessage = shortcutInfo.getDisabledMessage();
            mInfo9.mDisabledReason = shortcutInfo.getDisabledReason();
            mInfo10.mCategories = shortcutInfo.getCategories();
            mInfo11.mPersons = ShortcutInfoCompat.getPersonsFromExtra(shortcutInfo.getExtras());
            mInfo12.mUser = shortcutInfo.getUserHandle();
            mInfo13.mLastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            if (Build.VERSION.SDK_INT >= 30) {
                sDK_INT.mIsCached = shortcutInfo.isCached();
            }
            mInfo14.mIsDynamic = shortcutInfo.isDynamic();
            mInfo15.mIsPinned = shortcutInfo.isPinned();
            mInfo16.mIsDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            mInfo17.mIsImmutable = shortcutInfo.isImmutable();
            mInfo18.mIsEnabled = shortcutInfo.isEnabled();
            mInfo19.mHasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            mInfo20.mLocusId = ShortcutInfoCompat.getLocusId(shortcutInfo);
            mInfo21.mRank = shortcutInfo.getRank();
            mInfo22.mExtras = shortcutInfo.getExtras();
        }

        public Builder(Context context, String id) {
            super();
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            mInfo.mContext = context;
            mInfo2.mId = id;
        }

        public Builder(androidx.core.content.pm.ShortcutInfoCompat shortcutInfo) {
            Person[] mPersons;
            Object mCategories2;
            Object mExtras;
            int hashSet;
            int mCategories;
            super();
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            mInfo.mContext = shortcutInfo.mContext;
            mInfo2.mId = shortcutInfo.mId;
            mInfo3.mPackageName = shortcutInfo.mPackageName;
            mInfo4.mIntents = (Intent[])Arrays.copyOf(shortcutInfo.mIntents, mIntents2.length);
            mInfo5.mActivity = shortcutInfo.mActivity;
            mInfo6.mLabel = shortcutInfo.mLabel;
            mInfo7.mLongLabel = shortcutInfo.mLongLabel;
            mInfo8.mDisabledMessage = shortcutInfo.mDisabledMessage;
            mInfo9.mDisabledReason = shortcutInfo.mDisabledReason;
            mInfo10.mIcon = shortcutInfo.mIcon;
            mInfo11.mIsAlwaysBadged = shortcutInfo.mIsAlwaysBadged;
            mInfo12.mUser = shortcutInfo.mUser;
            mInfo13.mLastChangedTimestamp = shortcutInfo.mLastChangedTimestamp;
            mInfo14.mIsCached = shortcutInfo.mIsCached;
            mInfo15.mIsDynamic = shortcutInfo.mIsDynamic;
            mInfo16.mIsPinned = shortcutInfo.mIsPinned;
            mInfo17.mIsDeclaredInManifest = shortcutInfo.mIsDeclaredInManifest;
            mInfo18.mIsImmutable = shortcutInfo.mIsImmutable;
            mInfo19.mIsEnabled = shortcutInfo.mIsEnabled;
            mInfo20.mLocusId = shortcutInfo.mLocusId;
            mInfo21.mIsLongLived = shortcutInfo.mIsLongLived;
            mInfo22.mHasKeyFieldsOnly = shortcutInfo.mHasKeyFieldsOnly;
            mInfo23.mRank = shortcutInfo.mRank;
            if (shortcutInfo.mPersons != null) {
                mPersons.mPersons = (Person[])Arrays.copyOf(shortcutInfo.mPersons, mPersons3.length);
            }
            if (shortcutInfo.mCategories != null) {
                hashSet = new HashSet(shortcutInfo.mCategories);
                mCategories2.mCategories = hashSet;
            }
            if (shortcutInfo.mExtras != null) {
                mExtras.mExtras = shortcutInfo.mExtras;
            }
            mInfo24.mExcludedSurfaces = shortcutInfo.mExcludedSurfaces;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder addCapabilityBinding(String capability) {
            Object mCapabilityBindings;
            if (this.mCapabilityBindings == null) {
                mCapabilityBindings = new HashSet();
                this.mCapabilityBindings = mCapabilityBindings;
            }
            this.mCapabilityBindings.add(capability);
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder addCapabilityBinding(String capability, String parameter, List<String> list3) {
            Object mCapabilityBindingParams;
            Object mCapabilityBindingParams2;
            boolean empty;
            HashMap hashMap;
            addCapabilityBinding(capability);
            if (!list3.isEmpty() && this.mCapabilityBindingParams == null) {
                if (this.mCapabilityBindingParams == null) {
                    mCapabilityBindingParams = new HashMap();
                    this.mCapabilityBindingParams = mCapabilityBindingParams;
                }
                if (this.mCapabilityBindingParams.get(capability) == null) {
                    hashMap = new HashMap();
                    this.mCapabilityBindingParams.put(capability, hashMap);
                }
                (Map)this.mCapabilityBindingParams.get(capability).put(parameter, list3);
            }
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat build() {
            Intent[] mIntents;
            Object mLocusId;
            boolean mIsConversation;
            Object mCategories;
            Set mCapabilityBindings2;
            Object mExtras3;
            Object mCapabilityBindingParams;
            Object mExtras2;
            Object mSliceUri;
            LocusIdCompat mCapabilityBindings;
            String mId;
            Set keySet;
            Iterator iterator;
            int i;
            boolean next;
            Object[] array;
            Object obj;
            PersistableBundle mExtras;
            String string;
            Object[] strArr;
            if (TextUtils.isEmpty(mInfo.mLabel)) {
            } else {
                if (mInfo2.mIntents == null) {
                } else {
                    if (mIntents2.length == 0) {
                    } else {
                        if (this.mIsConversation && mInfo4.mLocusId == null) {
                            if (mInfo4.mLocusId == null) {
                                mCapabilityBindings = new LocusIdCompat(mInfo11.mId);
                                mLocusId.mLocusId = mCapabilityBindings;
                            }
                            mIsConversation.mIsLongLived = true;
                        }
                        if (this.mCapabilityBindings != null && mInfo5.mCategories == null) {
                            if (mInfo5.mCategories == null) {
                                mCapabilityBindings = new HashSet();
                                mCategories.mCategories = mCapabilityBindings;
                            }
                            mInfo6.mCategories.addAll(this.mCapabilityBindings);
                        }
                        if (this.mCapabilityBindingParams != null && mInfo7.mExtras == null) {
                            if (mInfo7.mExtras == null) {
                                mCapabilityBindings = new PersistableBundle();
                                mExtras3.mExtras = mCapabilityBindings;
                            }
                            mCapabilityBindingParams = this.mCapabilityBindingParams.keySet().iterator();
                            for (String mCapabilityBindings : mCapabilityBindingParams) {
                                mId = this.mCapabilityBindingParams.get(mCapabilityBindings);
                                i = 0;
                                mInfo12.mExtras.putStringArray(mCapabilityBindings, (String[])(Map)mId.keySet().toArray(new String[i]));
                                iterator = mId.keySet().iterator();
                                while (iterator.hasNext()) {
                                    array = iterator.next();
                                    obj = mId.get((String)array);
                                    StringBuilder stringBuilder = new StringBuilder();
                                    if ((List)obj == null) {
                                    } else {
                                    }
                                    strArr = (List)obj.toArray(new String[i]);
                                    mInfo13.mExtras.putStringArray(stringBuilder.append(mCapabilityBindings).append("/").append(array).toString(), strArr);
                                }
                                array = iterator.next();
                                obj = mId.get((String)array);
                                stringBuilder = new StringBuilder();
                                if ((List)obj == null) {
                                } else {
                                }
                                strArr = (List)obj.toArray(new String[i]);
                                mInfo13.mExtras.putStringArray(stringBuilder.append(mCapabilityBindings).append("/").append(array).toString(), strArr);
                            }
                        }
                        if (this.mSliceUri != null && mInfo8.mExtras == null) {
                            if (mInfo8.mExtras == null) {
                                mCapabilityBindings = new PersistableBundle();
                                mExtras2.mExtras = mCapabilityBindings;
                            }
                            mInfo9.mExtras.putString("extraSliceUri", UriCompat.toSafeString(this.mSliceUri));
                        }
                        return this.mInfo;
                    }
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Shortcut must have an intent");
                throw illegalArgumentException;
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Shortcut must have a non-empty label");
            throw illegalArgumentException2;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setActivity(ComponentName activity) {
            mInfo.mActivity = activity;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setAlwaysBadged() {
            mInfo.mIsAlwaysBadged = true;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setCategories(Set<String> set) {
            ArraySet arraySet = new ArraySet();
            arraySet.addAll(set);
            mInfo.mCategories = arraySet;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setDisabledMessage(java.lang.CharSequence disabledMessage) {
            mInfo.mDisabledMessage = disabledMessage;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setExcludedFromSurfaces(int surfaces) {
            mInfo.mExcludedSurfaces = surfaces;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setExtras(PersistableBundle extras) {
            mInfo.mExtras = extras;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setIcon(IconCompat icon) {
            mInfo.mIcon = icon;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setIntent(Intent intent) {
            Intent[] arr = new Intent[1];
            return setIntents(arr);
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setIntents(Intent[] intents) {
            mInfo.mIntents = intents;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setLocusId(LocusIdCompat locusId) {
            mInfo.mLocusId = locusId;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setLongLabel(java.lang.CharSequence longLabel) {
            mInfo.mLongLabel = longLabel;
            return this;
        }

        @Deprecated
        public androidx.core.content.pm.ShortcutInfoCompat.Builder setLongLived() {
            mInfo.mIsLongLived = true;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setLongLived(boolean longLived) {
            mInfo.mIsLongLived = longLived;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setPerson(Person person) {
            Person[] arr = new Person[1];
            return setPersons(arr);
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setPersons(Person[] persons) {
            mInfo.mPersons = persons;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setRank(int rank) {
            mInfo.mRank = rank;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setShortLabel(java.lang.CharSequence shortLabel) {
            mInfo.mLabel = shortLabel;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setSliceUri(Uri sliceUri) {
            this.mSliceUri = sliceUri;
            return this;
        }

        public androidx.core.content.pm.ShortcutInfoCompat.Builder setTransientExtras(Bundle transientExtras) {
            mInfo.mTransientExtras = (Bundle)Preconditions.checkNotNull(transientExtras);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Surface {
    }
    ShortcutInfoCompat() {
        super();
        final int i = 1;
    }

    private PersistableBundle buildLegacyExtrasBundle() {
        PersistableBundle persistableBundle2;
        Person[] i;
        Object i2;
        int length;
        int mExtras;
        String string;
        PersistableBundle persistableBundle;
        if (this.mExtras == null) {
            persistableBundle2 = new PersistableBundle();
            this.mExtras = persistableBundle2;
        }
        if (this.mPersons != null && mPersons.length > 0) {
            if (mPersons.length > 0) {
                this.mExtras.putInt("extraPersonCount", mPersons2.length);
                i = 0;
                while (i < mPersons3.length) {
                    StringBuilder stringBuilder = new StringBuilder();
                    this.mExtras.putPersistableBundle(stringBuilder.append("extraPerson_").append(i + 1).toString(), this.mPersons[i].toPersistableBundle());
                    i++;
                }
            }
        }
        if (this.mLocusId != null) {
            this.mExtras.putString("extraLocusId", this.mLocusId.getId());
        }
        this.mExtras.putBoolean("extraLongLived", this.mIsLongLived);
        return this.mExtras;
    }

    static List<androidx.core.content.pm.ShortcutInfoCompat> fromShortcuts(Context context, List<ShortcutInfo> list2) {
        Object next;
        androidx.core.content.pm.ShortcutInfoCompat build;
        ArrayList arrayList = new ArrayList(list2.size());
        Iterator iterator = list2.iterator();
        for (ShortcutInfo next : iterator) {
            ShortcutInfoCompat.Builder builder = new ShortcutInfoCompat.Builder(context, next);
            arrayList.add(builder.build());
        }
        return arrayList;
    }

    static LocusIdCompat getLocusId(ShortcutInfo shortcutInfo) {
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle bundle) {
        int locusIdCompat;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("extraLocusId");
        if (string == null) {
        } else {
            locusIdCompat = new LocusIdCompat(string);
        }
        return locusIdCompat;
    }

    static boolean getLongLivedFromExtra(PersistableBundle bundle) {
        String str;
        boolean key;
        str = "extraLongLived";
        if (bundle != null && !bundle.containsKey(str)) {
            str = "extraLongLived";
            if (!bundle.containsKey(str)) {
            }
            return bundle.getBoolean(str);
        }
        return 0;
    }

    static Person[] getPersonsFromExtra(PersistableBundle bundle) {
        String str;
        boolean key;
        int i2;
        Person persistableBundle;
        int i;
        if (bundle != null) {
            str = "extraPersonCount";
            if (!bundle.containsKey(str)) {
            } else {
                int int = bundle.getInt(str);
                Person[] arr = new Person[int];
                i2 = 0;
                while (i2 < int) {
                    StringBuilder stringBuilder = new StringBuilder();
                    arr[i2] = Person.fromPersistableBundle(bundle.getPersistableBundle(stringBuilder.append("extraPerson_").append(i2 + 1).toString()));
                    i2++;
                }
            }
            return arr;
        }
        return null;
    }

    Intent addToIntent(Intent outIntent) {
        int badge;
        boolean mIsAlwaysBadged;
        Object pm;
        Object applicationInfo;
        outIntent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[length--]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        badge = 0;
        mIsAlwaysBadged = this.mContext.getPackageManager();
        if (this.mIcon != null && this.mIsAlwaysBadged && this.mActivity != null) {
            badge = 0;
            if (this.mIsAlwaysBadged) {
                mIsAlwaysBadged = this.mContext.getPackageManager();
                if (this.mActivity != null) {
                    badge = applicationInfo;
                }
                if (badge == 0) {
                    badge = this.mContext.getApplicationInfo().loadIcon(mIsAlwaysBadged);
                }
            }
            this.mIcon.addToShortcutIntent(outIntent, badge, this.mContext);
        }
        return outIntent;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public Set<String> getCategories() {
        return this.mCategories;
    }

    public java.lang.CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntents[length--];
    }

    public Intent[] getIntents() {
        return (Intent[])Arrays.copyOf(this.mIntents, mIntents2.length);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public java.lang.CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    public java.lang.CharSequence getShortLabel() {
        return this.mLabel;
    }

    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isExcludedFromSurfaces(int surface) {
        int i;
        i = mExcludedSurfaces &= surface != 0 ? 1 : 0;
        return i;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public ShortcutInfo toShortcutInfo() {
        Object mIcon;
        boolean mLongLabel;
        boolean mDisabledMessage;
        ComponentName mActivity;
        Set mCategories;
        PersistableBundle mExtras;
        Person[] mPersons;
        Object persons;
        int mExcludedSurfaces;
        Object i;
        int androidPerson;
        ShortcutInfo.Builder builder = new ShortcutInfo.Builder(this.mContext, this.mId);
        ShortcutInfo.Builder intents = builder.setShortLabel(this.mLabel).setIntents(this.mIntents);
        if (this.mIcon != null) {
            intents.setIcon(this.mIcon.toIcon(this.mContext));
        }
        if (!TextUtils.isEmpty(this.mLongLabel)) {
            intents.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty(this.mDisabledMessage)) {
            intents.setDisabledMessage(this.mDisabledMessage);
        }
        if (this.mActivity != null) {
            intents.setActivity(this.mActivity);
        }
        if (this.mCategories != null) {
            intents.setCategories(this.mCategories);
        }
        intents.setRank(this.mRank);
        if (this.mExtras != null) {
            intents.setExtras(this.mExtras);
        }
        if (this.mPersons != null && mPersons2.length > 0) {
            if (mPersons2.length > 0) {
                mPersons = new Person[mPersons3.length];
                i = 0;
                while (i < mPersons.length) {
                    mPersons[i] = this.mPersons[i].toAndroidPerson();
                    i++;
                }
                intents.setPersons(mPersons);
            }
        }
        if (this.mLocusId != null) {
            intents.setLocusId(this.mLocusId.toLocusId());
        }
        intents.setLongLived(this.mIsLongLived);
        if (Build.VERSION.SDK_INT >= 33) {
            ShortcutInfoCompat.Api33Impl.setExcludedFromSurfaces(intents, this.mExcludedSurfaces);
        }
        return intents.build();
    }
}
