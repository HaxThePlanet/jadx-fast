package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class n extends com.bumptech.glide.load.data.l<InputStream> {

    private static final UriMatcher v;
    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        n.v = uriMatcher;
        String str = "com.android.contacts";
        int i2 = 1;
        uriMatcher.addURI(str, "contacts/lookup/*/#", i2);
        uriMatcher.addURI(str, "contacts/lookup/*", i2);
        uriMatcher.addURI(str, "contacts/#/photo", 2);
        uriMatcher.addURI(str, "contacts/#", 3);
        uriMatcher.addURI(str, "contacts/#/display_photo", 4);
        uriMatcher.addURI(str, "phone_lookup/*", 5);
    }

    public n(ContentResolver contentResolver, Uri uri2) {
        super(contentResolver, uri2);
    }

    private InputStream i(Uri uri, ContentResolver contentResolver2) {
        int i;
        int match = n.v.match(uri);
        if (match != 1 && match != 3 && match != 5) {
            if (match != 3) {
                if (match != 5) {
                    return contentResolver2.openInputStream(uri);
                }
            }
            return j(contentResolver2, uri);
        }
        Uri obj3 = ContactsContract.Contacts.lookupContact(contentResolver2, uri);
        if (obj3 == null) {
        } else {
            return j(contentResolver2, obj3);
        }
        obj3 = new FileNotFoundException("Contact cannot be found");
        throw obj3;
    }

    private InputStream j(ContentResolver contentResolver, Uri uri2) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri2, true);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.l
    protected void c(Object object) {
        g((InputStream)object);
    }

    @Override // com.bumptech.glide.load.data.l
    protected Object f(Uri uri, ContentResolver contentResolver2) {
        return h(uri, contentResolver2);
    }

    @Override // com.bumptech.glide.load.data.l
    protected void g(InputStream inputStream) {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.l
    protected InputStream h(Uri uri, ContentResolver contentResolver2) {
        InputStream obj4 = i(uri, contentResolver2);
        if (obj4 == null) {
        } else {
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InputStream is null for ");
        stringBuilder.append(uri);
        obj4 = new FileNotFoundException(stringBuilder.toString());
        throw obj4;
    }
}
