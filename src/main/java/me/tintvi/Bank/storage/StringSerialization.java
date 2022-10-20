package me.tintvi.Bank.storage;

public interface StringSerialization {
    String serialize(Object objectToSerialize);

    <T> T deserialize(String stringToDeserialize, Class<T> classOf);
}
