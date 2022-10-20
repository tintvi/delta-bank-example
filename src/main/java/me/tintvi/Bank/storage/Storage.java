package me.tintvi.Bank.storage;

public interface Storage {
    void save(String data, String path);
    String load(String path);
}
