package eu.thirdspaceauto.akka.hacksprint;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.PhoneLookup;
import android.support.multidex.MultiDex;


import java.util.ArrayList;

import eu.thirdspaceauto.akka.hacksprint.Models.Contact;
import eu.thirdspaceauto.akka.hacksprint.Models.Email;
import eu.thirdspaceauto.akka.hacksprint.Models.Excavators;
import eu.thirdspaceauto.akka.hacksprint.Models.SMS;
import eu.thirdspaceauto.akka.hacksprint.Utils.PreferencesManager;

public class Common extends Application {
    public static Editor editor;
    public static SharedPreferences prefs;

    public static ArrayList<Excavators> excavators = new ArrayList<> ();

    public void onCreate() {
        super.onCreate();
        PreferencesManager.initialize(this);
        MultiDex.install(this);
    }
}
