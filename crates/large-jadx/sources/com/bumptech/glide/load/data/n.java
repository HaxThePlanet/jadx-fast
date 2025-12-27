package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class n extends l<InputStream> {

    private static final UriMatcher v = new UriMatcher(-1);
    static {
        String str = "com.android.contacts";
        int i2 = 1;
        obj.addURI(str, "contacts/lookup/*/#", i2);
        obj.addURI(str, "contacts/lookup/*", i2);
        obj.addURI(str, "contacts/#/photo", 2);
        obj.addURI(str, "contacts/#", 3);
        obj.addURI(str, "contacts/#/display_photo", 4);
        obj.addURI(str, "phone_lookup/*", 5);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream i(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = n.v.match(uri);
        int i = 1;
        if (match != 1) {
            if (match != 3 && match != 5) {
                return contentResolver.openInputStream(uri);
            }
            return j(contentResolver, uri);
        }
        Uri contact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (contact == null) {
            throw new FileNotFoundException("Contact cannot be found");
        } else {
            return j(contentResolver, contact);
        }
    }

    private InputStream j(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // com.bumptech.glide.load.data.l
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.l
    protected void g(InputStream inputStream) throws java.io.IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.l
    protected InputStream h(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStream = i(uri, contentResolver);
        if (inputStream == null) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "InputStream is null for ";
            uri = str + uri;
            throw new FileNotFoundException(uri);
        } else {
            return inputStream;
        }
    }
}
