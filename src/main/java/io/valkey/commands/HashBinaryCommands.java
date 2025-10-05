package io.valkey.commands;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import io.valkey.args.ExpiryOption;
import io.valkey.params.HGetExParams;
import io.valkey.params.HSetExParams;
import io.valkey.params.ScanParams;
import io.valkey.resps.ScanResult;

public interface HashBinaryCommands {

  long hset(byte[] key, byte[] field, byte[] value);

  long hset(byte[] key, Map<byte[], byte[]> hash);

  byte[] hget(byte[] key, byte[] field);

  long hsetnx(byte[] key, byte[] field, byte[] value);

  String hmset(byte[] key, Map<byte[], byte[]> hash);

  List<byte[]> hmget(byte[] key, byte[]... fields);

  long hincrBy(byte[] key, byte[] field, long value);

  double hincrByFloat(byte[] key, byte[] field, double value);

  boolean hexists(byte[] key, byte[] field);

  long hdel(byte[] key, byte[]... field);

  long hlen(byte[] key);

  Set<byte[]> hkeys(byte[] key);

  List<byte[]> hvals(byte[] key);

  Map<byte[], byte[]> hgetAll(byte[] key);

  byte[] hrandfield(byte[] key);

  List<byte[]> hrandfield(byte[] key, long count);

  List<Map.Entry<byte[], byte[]>> hrandfieldWithValues(byte[] key, long count);

  default ScanResult<Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor) {
    return hscan(key, cursor, new ScanParams());
  }

  ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams params);

  default ScanResult<byte[]> hscanNoValues(byte[] key, byte[] cursor) {
    return hscanNoValues(key, cursor, new ScanParams());
  }

  ScanResult<byte[]> hscanNoValues(byte[] key, byte[] cursor, ScanParams params);

  long hstrlen(byte[] key, byte[] field);

  long hsetex(byte[] key, HSetExParams params, byte[] field, byte[] value);

  long hsetex(byte[] key, HSetExParams params, Map<byte[], byte[]> hash);

  List<byte[]> hgetex(byte[] key, HGetExParams params, byte[]... fields);

  List<Long> hexpire(byte[] key, long seconds, byte[]... fields);

  List<Long> hexpire(byte[] key, long seconds, ExpiryOption condition, byte[]... fields);

  List<Long> hpexpire(byte[] key, long milliseconds, byte[]... fields);

  List<Long> hpexpire(byte[] key, long milliseconds, ExpiryOption condition, byte[]... fields);

  List<Long> hexpireAt(byte[] key, long unixTimeSeconds, byte[]... fields);

  List<Long> hexpireAt(byte[] key, long unixTimeSeconds, ExpiryOption condition, byte[]... fields);

  List<Long> hpexpireAt(byte[] key, long unixTimeMillis, byte[]... fields);

  List<Long> hpexpireAt(byte[] key, long unixTimeMillis, ExpiryOption condition, byte[]... fields);

  List<Long> hexpireTime(byte[] key, byte[]... fields);

  List<Long> hpexpireTime(byte[] key, byte[]... fields);

  List<Long> httl(byte[] key, byte[]... fields);

  List<Long> hpttl(byte[] key, byte[]... fields);

  List<Long> hpersist(byte[] key, byte[]... fields);

}
