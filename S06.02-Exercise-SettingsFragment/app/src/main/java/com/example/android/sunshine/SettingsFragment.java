package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by suneetsrivastava on 25/02/18.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_sunshine);
        PreferenceManager preferenceManager = getPreferenceManager();
        PreferenceScreen preferenceScreen = preferenceManager.getPreferenceScreen();
        int count = preferenceScreen.getPreferenceCount();
        for(int i =0; i<count; i++){
            Preference preference = preferenceScreen.getPreference(i);
            if(!(preference instanceof CheckBoxPreference)){
                setPreferenceSummary(preference, preference.getSharedPreferences().getString(preference.getKey(),""));
            }
        }
        preferenceScreen.getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    private void setPreferenceSummary(Preference preference, Object value){
            String v = (String) value;
            if(preference instanceof ListPreference){
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(v);
                if(prefIndex >= 0){
                    listPreference.setSummary(listPreference.getEntries()[prefIndex]);
                }
            }
            else
                preference.setSummary(v);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            Preference preference = findPreference(key);
            if(!(preference instanceof CheckBoxPreference)){
                setPreferenceSummary(preference, sharedPreferences.getString(key, "" ));
            }
    }
}
