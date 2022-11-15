package com.healthcare.healthcareapi.util.service;


public enum SystemOperation {

    READ,
    CREATE,
    MODIFY,
    DELETE;

    private boolean status = false;

    public SystemOperation withError()
    {
        this.status = false;
        return this;
    }

    public SystemOperation withSuccess()
    {
        this.status = true;
        return this;
    }

    public boolean status()
    {
        return this.status;
    }
}
