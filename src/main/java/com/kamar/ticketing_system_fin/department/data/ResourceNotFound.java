package com.kamar.ticketing_system_fin.department.data;

/**
 * exception to throw*/

public class ResourceNotFound extends Throwable{

    public ResourceNotFound(String msg){
        super(msg);
    }
}
