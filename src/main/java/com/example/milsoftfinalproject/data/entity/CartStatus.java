package com.example.milsoftfinalproject.data.entity;

public enum CartStatus {
    NEW(0),
    COMPLETED(1);

    private long status;

    CartStatus(long status) {
        this.status = status;
    }

    public long getStatus() {
        return status;
    }

    public static long getStatusValue(CartStatus cartStatus) {
        return cartStatus.getStatus();
    }
}
