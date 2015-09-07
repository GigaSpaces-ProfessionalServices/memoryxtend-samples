package com.mycompany.app.common;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 * A simple object used to work with the Space. Important properties include the id
 * of the object, a type (used to perform routing when working with partitioned space),
 * the raw data and processed data, and a boolean flag indicating if this Data object
 * was processed or not.
 */
@Entity
@Table(name="data")
@SpaceClass
public class Data {

    @Id
    private String id;

    private String data;

    private Boolean processed;

    /**
     * Constructs a new Data object.
     */
    public Data() {

    }

    /**
     * Constructs a new Data object with the given type
     * and raw data.
     */
    public Data(String data) {
        this.data = data;
        this.processed = false;
    }

    /**
     * The id of this object.
     */
    @SpaceId(autoGenerate=true)
    public String getId() {
        return id;
    }

    /**
     * The id of this object. Its value will be auto generated when it is written
     * to the space.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * The processed data this object holds.
     */
    public String getData() {
        return data;
    }

    /**
     * The processed data this object holds.
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * A boolean flag indicating if the data object was processed or not.
     */
    public Boolean isProcessed() {
        return processed;
    }

    /**
     * A boolean flag indicating if the data object was processed or not.
     */
    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public String toString() {
        return "id[" + id + "]  data[" + data + "] processed[" + processed + "]";
    }
}
