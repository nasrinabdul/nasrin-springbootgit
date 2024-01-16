package org.example.springProject.jsonTest.data;

import com.fasterxml.jackson.annotation.JsonProperty;



public class StoreDetail {

    @JsonProperty("store")
    private int store;

    @JsonProperty("department")
    private int department;

    @JsonProperty("class")
    private int storeClass;

    @JsonProperty("subClass")
    private int subClass;

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getStoreClass() {
        return storeClass;
    }

    public void setStoreClass(int storeClass) {
        this.storeClass = storeClass;
    }

    public int getSubClass() {
        return subClass;
    }

    public void setSubClass(int subClass) {
        this.subClass = subClass;
    }

    public boolean test(StoreDetail detail) {
        if(detail != null) {
            if(detail.getDepartment() == this.getDepartment()
             && detail.getStoreClass() == this.getStoreClass()
             && detail.getSubClass() == this.getSubClass()) {
                return true;
            }
        }
        return false;
    }
}
