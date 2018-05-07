package com.songyuankun.mongo;

public class MongodbException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MongodbException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }


}
