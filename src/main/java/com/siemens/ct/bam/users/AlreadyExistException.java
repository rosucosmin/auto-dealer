package com.siemens.ct.bam.users;

public class AlreadyExistException extends Throwable {
    public AlreadyExistException(String s) {
        super(s);
    }
}
