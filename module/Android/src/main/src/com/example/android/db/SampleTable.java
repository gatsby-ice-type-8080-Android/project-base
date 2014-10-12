package com.example.android.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="SAMPLE_TABLE")
public class SampleTable {
    
    @DatabaseField(generatedId=true, columnName="ID")
    private Long id;
    @DatabaseField(columnName="CODE")
    private String code;
    @DatabaseField(columnName="NAME")
    private String name;

    @Override
    public String toString() {
        return "SampleTable [id=" + id + ", code=" + code + ", name=" + name + "]";
    }
}
