package org.example.springProject.jsonTest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StoreList {

    StoreList(List<Integer> stores, int department, int storeClass, int subClass) {
        this.stores = stores;
        this.department = department;
        this.storeClass = storeClass;
        this.subClass = subClass;
    }
    @JsonProperty("stores")
    private List<Integer> stores;
    @JsonProperty("department")
    private int department;

    @JsonProperty("class")
    private int storeClass;

    @JsonProperty("subClass")
    private int subClass;

    public List<Integer> getStores() {
        return stores;
    }

    public void setStores(List<Integer> stores) {
        this.stores = stores;
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
}
