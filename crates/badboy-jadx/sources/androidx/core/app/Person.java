package androidx.core.app;

import android.app.Person;
import android.app.Person.Builder;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: classes5.dex */
public class Person {

    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";
    IconCompat mIcon;
    boolean mIsBot;
    boolean mIsImportant;
    String mKey;
    java.lang.CharSequence mName;
    String mUri;

    static class Api22Impl {
        static androidx.core.app.Person fromPersistableBundle(PersistableBundle bundle) {
            Person.Builder builder = new Person.Builder();
            return builder.setName(bundle.getString("name")).setUri(bundle.getString("uri")).setKey(bundle.getString("key")).setBot(bundle.getBoolean("isBot")).setImportant(bundle.getBoolean("isImportant")).build();
        }

        static PersistableBundle toPersistableBundle(androidx.core.app.Person person) {
            String string;
            PersistableBundle persistableBundle = new PersistableBundle();
            if (person.mName != null) {
                string = person.mName.toString();
            } else {
                string = 0;
            }
            persistableBundle.putString("name", string);
            persistableBundle.putString("uri", person.mUri);
            persistableBundle.putString("key", person.mKey);
            persistableBundle.putBoolean("isBot", person.mIsBot);
            persistableBundle.putBoolean("isImportant", person.mIsImportant);
            return persistableBundle;
        }
    }

    static class Api28Impl {
        static androidx.core.app.Person fromAndroidPerson(Person person) {
            IconCompat fromIcon;
            Person.Builder builder = new Person.Builder();
            if (person.getIcon() != null) {
                fromIcon = IconCompat.createFromIcon(person.getIcon());
            } else {
                fromIcon = 0;
            }
            return builder.setName(person.getName()).setIcon(fromIcon).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }

        static Person toAndroidPerson(androidx.core.app.Person person) {
            android.graphics.drawable.Icon icon;
            Person.Builder builder = new Person.Builder();
            if (person.getIcon() != null) {
                icon = person.getIcon().toIcon();
            } else {
                icon = 0;
            }
            return builder.setName(person.getName()).setIcon(icon).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
        }
    }

    public static class Builder {

        IconCompat mIcon;
        boolean mIsBot;
        boolean mIsImportant;
        String mKey;
        java.lang.CharSequence mName;
        String mUri;
        Builder(androidx.core.app.Person person) {
            super();
            this.mName = person.mName;
            this.mIcon = person.mIcon;
            this.mUri = person.mUri;
            this.mKey = person.mKey;
            this.mIsBot = person.mIsBot;
            this.mIsImportant = person.mIsImportant;
        }

        public androidx.core.app.Person build() {
            Person person = new Person(this);
            return person;
        }

        public androidx.core.app.Person.Builder setBot(boolean bot) {
            this.mIsBot = bot;
            return this;
        }

        public androidx.core.app.Person.Builder setIcon(IconCompat icon) {
            this.mIcon = icon;
            return this;
        }

        public androidx.core.app.Person.Builder setImportant(boolean important) {
            this.mIsImportant = important;
            return this;
        }

        public androidx.core.app.Person.Builder setKey(String key) {
            this.mKey = key;
            return this;
        }

        public androidx.core.app.Person.Builder setName(java.lang.CharSequence name) {
            this.mName = name;
            return this;
        }

        public androidx.core.app.Person.Builder setUri(String uri) {
            this.mUri = uri;
            return this;
        }
    }
    Person(androidx.core.app.Person.Builder builder) {
        super();
        this.mName = builder.mName;
        this.mIcon = builder.mIcon;
        this.mUri = builder.mUri;
        this.mKey = builder.mKey;
        this.mIsBot = builder.mIsBot;
        this.mIsImportant = builder.mIsImportant;
    }

    public static androidx.core.app.Person fromAndroidPerson(Person person) {
        return Person.Api28Impl.fromAndroidPerson(person);
    }

    public static androidx.core.app.Person fromBundle(Bundle bundle) {
        IconCompat fromBundle;
        Bundle bundle2 = bundle.getBundle("icon");
        Person.Builder builder = new Person.Builder();
        if (bundle2 != null) {
            fromBundle = IconCompat.createFromBundle(bundle2);
        } else {
            fromBundle = 0;
        }
        return builder.setName(bundle.getCharSequence("name")).setIcon(fromBundle).setUri(bundle.getString("uri")).setKey(bundle.getString("key")).setBot(bundle.getBoolean("isBot")).setImportant(bundle.getBoolean("isImportant")).build();
    }

    public static androidx.core.app.Person fromPersistableBundle(PersistableBundle bundle) {
        return Person.Api22Impl.fromPersistableBundle(bundle);
    }

    public boolean equals(Object otherObject) {
        int i;
        boolean equals;
        Object valueOf;
        i = 0;
        if (otherObject == null) {
            return i;
        }
        if (!otherObject instanceof Person) {
            return i;
        }
        Object obj = otherObject;
        final String key = getKey();
        final String key2 = (Person)obj.getKey();
        if (key == null) {
            if (key2 != null) {
            } else {
                if (Objects.equals(Objects.toString(getName()), Objects.toString(obj.getName())) && Objects.equals(getUri(), obj.getUri()) && Objects.equals(Boolean.valueOf(isBot()), Boolean.valueOf(obj.isBot())) && Objects.equals(Boolean.valueOf(isImportant()), Boolean.valueOf(obj.isImportant()))) {
                    if (Objects.equals(getUri(), obj.getUri())) {
                        if (Objects.equals(Boolean.valueOf(isBot()), Boolean.valueOf(obj.isBot()))) {
                            if (Objects.equals(Boolean.valueOf(isImportant()), Boolean.valueOf(obj.isImportant()))) {
                                i = 1;
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return Objects.equals(key, key2);
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getKey() {
        return this.mKey;
    }

    public java.lang.CharSequence getName() {
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }

    public int hashCode() {
        final String key = getKey();
        if (key != null) {
            return key.hashCode();
        }
        return Objects.hash(/* result */);
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    public String resolveToLegacyUri() {
        if (this.mUri != null) {
            return this.mUri;
        }
        if (this.mName != null) {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("name:").append(this.mName).toString();
        }
        return "";
    }

    public Person toAndroidPerson() {
        return Person.Api28Impl.toAndroidPerson(this);
    }

    public androidx.core.app.Person.Builder toBuilder() {
        Person.Builder builder = new Person.Builder(this);
        return builder;
    }

    public Bundle toBundle() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence("name", this.mName);
        if (this.mIcon != null) {
            bundle = this.mIcon.toBundle();
        } else {
            bundle = 0;
        }
        bundle2.putBundle("icon", bundle);
        bundle2.putString("uri", this.mUri);
        bundle2.putString("key", this.mKey);
        bundle2.putBoolean("isBot", this.mIsBot);
        bundle2.putBoolean("isImportant", this.mIsImportant);
        return bundle2;
    }

    public PersistableBundle toPersistableBundle() {
        return Person.Api22Impl.toPersistableBundle(this);
    }
}
