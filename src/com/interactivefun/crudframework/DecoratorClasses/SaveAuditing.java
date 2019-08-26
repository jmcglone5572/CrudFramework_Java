package com.interactivefun.crudframework.DecoratorClasses;

import com.interactivefun.crudframework.contracts.ISave;

import java.util.Date;

public class SaveAuditing<T> implements ISave<T> {

    private final ISave<T> decorated;
    private final ISave<AuditInfo> auditSave;

    public SaveAuditing(ISave<T> decorated, ISave<AuditInfo> auditSave)
    {
        this.decorated = decorated;
        this.auditSave = auditSave;
    }

    @Override
    public void save(T entity) {

        decorated.save(entity);

        AuditInfo auditInfo= new AuditInfo();
        auditInfo.setUserName(System.getProperty("user.name"));
        auditInfo.setTimeStamp(new Date());

        auditSave.save(auditInfo);

    }
}
