package com.interactivefun.crudframework.contracts;

// Use this interface in conjunction with the DeleteConfirmation or similar decrators
// when user interaction is required to perform an action...
public interface IUserInteraction {

    boolean confirm(String message);
}
