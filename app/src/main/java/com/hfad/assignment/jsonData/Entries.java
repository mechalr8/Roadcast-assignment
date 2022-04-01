package com.hfad.assignment.jsonData;

import android.util.Log;

import java.util.List;

public class Entries {
    public int count;
    public List<Entry> entries;

    public void setCount(int count) {
        this.count = count;
    }

    public void setEntry(List<Entry> entries) {
        Entry entry = new Entry();
        entries.add(entry);
        this.entries = entries;
    }

    public int getCount() {
        return count;
    }

    public List<Entry> getEntry() {
        return entries;
    }
}
