package com.healthcare.healthcareapi.util.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Common Error Wrapper
 *
 **/

@Data
public class Error {

    private String code;
    private String message;
    private List<String> errorList;

    public void addMessage( String message )
    {
        if( this.errorList == null )
        {
            this.errorList = new ArrayList<>();
        }

        this.errorList.add( message );
    }


}
