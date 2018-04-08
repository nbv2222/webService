package ru.tinkoff.dao.interfaces;

public abstract class AbstractDAO<E> implements DAO<E> {
    //constants
    //for logging
    protected static final String START_METHOD = "Start %s method";
    protected static final String END_METHOD = "End %s method";
    protected static final String GET_OBJECT = "Get %s from DB %s";
    protected static final String DB_GET_ERROR = "Error while getting from db";
    protected static final String DELETE_OBJECT = "Delete from DB %s = %s";
}
