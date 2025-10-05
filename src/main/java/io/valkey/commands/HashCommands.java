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

public interface HashCommands {

  long hset(String key, String field, String value);

  long hset(String key, Map<String, String> hash);

  String hget(String key, String field);

  long hsetnx(String key, String field, String value);

  String hmset(String key, Map<String, String> hash);

  List<String> hmget(String key, String... fields);

  long hincrBy(String key, String field, long value);

  double hincrByFloat(String key, String field, double value);

  boolean hexists(String key, String field);

  long hdel(String key, String... field);

  long hlen(String key);

  Set<String> hkeys(String key);

  List<String> hvals(String key);

  Map<String, String> hgetAll(String key);

  String hrandfield(String key);

  List<String> hrandfield(String key, long count);

  List<Map.Entry<String, String>> hrandfieldWithValues(String key, long count);

  default ScanResult<Entry<String, String>> hscan(String key, String cursor) {
    return hscan(key, cursor, new ScanParams());
  }

  ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params);

  default ScanResult<String> hscanNoValues(String key, String cursor) {
    return hscanNoValues(key, cursor, new ScanParams());
  }

  ScanResult<String> hscanNoValues(String key, String cursor, ScanParams params);

  long hstrlen(String key, String field);

  long hsetex(String key, HSetExParams params, String field, String value);

  long hsetex(String key, HSetExParams params, Map<String, String> hash);

  List<String> hgetex(String key, HGetExParams params, String... fields);

  List<Long> hexpire(String key, long seconds, String... fields);

  List<Long> hexpire(String key, long seconds, ExpiryOption condition, String... fields);

  List<Long> hpexpire(String key, long milliseconds, String... fields);

  List<Long> hpexpire(String key, long milliseconds, ExpiryOption condition, String... fields);

  List<Long> hexpireAt(String key, long unixTimeSeconds, String... fields);

  List<Long> hexpireAt(String key, long unixTimeSeconds, ExpiryOption condition, String... fields);

  List<Long> hpexpireAt(String key, long unixTimeMillis, String... fields);

  List<Long> hpexpireAt(String key, long unixTimeMillis, ExpiryOption condition, String... fields);

  List<Long> hexpireTime(String key, String... fields);

  List<Long> hpexpireTime(String key, String... fields);

  List<Long> httl(String key, String... fields);

  List<Long> hpttl(String key, String... fields);

  List<Long> hpersist(String key, String... fields);
}
