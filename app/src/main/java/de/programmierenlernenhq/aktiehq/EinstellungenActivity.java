package de.programmierenlernenhq.aktiehq;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;


/**
 * Created by achim on 4/27/16.
 */
public class EinstellungenActivity extends PreferenceActivity
        implements Preference.OnPreferenceChangeListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        Preference aktienlistePref = findPreference(getString(R.string.preference_aktienliste_key));
        aktienlistePref.setOnPreferenceChangeListener(this);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String gespeicherteAktienliste = sharedPreferences.getString(aktienlistePref.getKey(),"");
        onPreferenceChange(aktienlistePref, gespeicherteAktienliste);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        preference.setSummary(newValue.toString());
        return true;
    }
}
