package tachyon.client.kv;

import java.nio.ByteBuffer;

import tachyon.client.TachyonFS;

/**
 * The store is identified by its path, e.g., /data/dailyreport/2014-12-05
 * 
 * This is the client a user uses. It should have put, get, and delete functions. In the first step,
 * these methods are only implemented in the KVPartition class.
 * 
 * This class should be abstract. But for the first step, it only has one implementation.
 */
public class KVStore {
  private final String KV_STORE_PATH;
  private TachyonFS TFS;

  public static KVStore get(String kvStorePath) {
    return new KVStore(kvStorePath);
  }

  KVStore(String kvStorePath) {
    KV_STORE_PATH = kvStorePath;
    TFS = TachyonFS.get(KV_STORE_PATH);
  }

  public KVPartition createPartition(int index) {
    return KVPartition.createKVPartition(this, index);
  }

  public ByteBuffer get(ByteBuffer key) {
    return null;
  }

  public String getStorePath() {
    return KV_STORE_PATH;
  }
}