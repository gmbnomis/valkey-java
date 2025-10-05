package io.valkey.params;

import io.valkey.CommandArguments;
import io.valkey.Protocol.Keyword;

/**
 * Parameters for HGETEX command.
 * Supports various expiration options and PERSIST.
 */
public class HGetExParams implements IParams {

  private Long ex = null;
  private Long px = null;
  private Long exAt = null;
  private Long pxAt = null;
  private boolean persist = false;

  public HGetExParams() {
  }

  /**
   * Set the specified expiration time in seconds.
   * @param seconds expiration time in seconds
   * @return this
   */
  public HGetExParams ex(long seconds) {
    this.ex = seconds;
    this.px = null;
    this.exAt = null;
    this.pxAt = null;
    this.persist = false;
    return this;
  }

  /**
   * Set the specified expiration time in milliseconds.
   * @param milliseconds expiration time in milliseconds
   * @return this
   */
  public HGetExParams px(long milliseconds) {
    this.px = milliseconds;
    this.ex = null;
    this.exAt = null;
    this.pxAt = null;
    this.persist = false;
    return this;
  }

  /**
   * Set the specified Unix time in seconds at which the fields will expire.
   * @param unixTimeSeconds Unix time in seconds
   * @return this
   */
  public HGetExParams exAt(long unixTimeSeconds) {
    this.exAt = unixTimeSeconds;
    this.ex = null;
    this.px = null;
    this.pxAt = null;
    this.persist = false;
    return this;
  }

  /**
   * Set the specified Unix time in milliseconds at which the fields will expire.
   * @param unixTimeMillis Unix time in milliseconds
   * @return this
   */
  public HGetExParams pxAt(long unixTimeMillis) {
    this.pxAt = unixTimeMillis;
    this.ex = null;
    this.px = null;
    this.exAt = null;
    this.persist = false;
    return this;
  }

  /**
   * Remove the TTL associated with the fields.
   * @return this
   */
  public HGetExParams persist() {
    this.persist = true;
    this.ex = null;
    this.px = null;
    this.exAt = null;
    this.pxAt = null;
    return this;
  }

  /**
   * Add parameters to the command arguments.
   * @param args the command arguments builder
   */
  public void addParams(CommandArguments args) {
    if (ex != null) {
      args.add(Keyword.EX).add(ex);
    }
    if (px != null) {
      args.add(Keyword.PX).add(px);
    }
    if (exAt != null) {
      args.add(Keyword.EXAT).add(exAt);
    }
    if (pxAt != null) {
      args.add(Keyword.PXAT).add(pxAt);
    }
    if (persist) {
      args.add(Keyword.PERSIST);
    }
  }

  /**
   * Create a new HGetExParams instance.
   * @return new HGetExParams instance
   */
  public static HGetExParams hGetExParams() {
    return new HGetExParams();
  }

  // Getters for testing purposes
  public Long getEx() {
    return ex;
  }

  public Long getPx() {
    return px;
  }

  public Long getExAt() {
    return exAt;
  }

  public Long getPxAt() {
    return pxAt;
  }

  public boolean isPersist() {
    return persist;
  }
}
