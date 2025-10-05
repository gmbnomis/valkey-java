package io.valkey.params;

import io.valkey.CommandArguments;
import io.valkey.Protocol.Keyword;

/**
 * Parameters for HSETEX command.
 * Supports FNX/FXX conditions and various expiration options.
 */
public class HSetExParams implements IParams {

  private boolean fnx = false;
  private boolean fxx = false;
  private Long ex = null;
  private Long px = null;
  private Long exAt = null;
  private Long pxAt = null;
  private boolean keepTtl = false;

  public HSetExParams() {
  }

  /**
   * Only set the fields if none of them already exist.
   * @return this
   */
  public HSetExParams fnx() {
    this.fnx = true;
    this.fxx = false;
    return this;
  }

  /**
   * Only set the fields if all of them already exist.
   * @return this
   */
  public HSetExParams fxx() {
    this.fxx = true;
    this.fnx = false;
    return this;
  }

  /**
   * Set the specified expiration time in seconds.
   * @param seconds expiration time in seconds
   * @return this
   */
  public HSetExParams ex(long seconds) {
    this.ex = seconds;
    this.px = null;
    this.exAt = null;
    this.pxAt = null;
    this.keepTtl = false;
    return this;
  }

  /**
   * Set the specified expiration time in milliseconds.
   * @param milliseconds expiration time in milliseconds
   * @return this
   */
  public HSetExParams px(long milliseconds) {
    this.px = milliseconds;
    this.ex = null;
    this.exAt = null;
    this.pxAt = null;
    this.keepTtl = false;
    return this;
  }

  /**
   * Set the specified Unix time in seconds at which the fields will expire.
   * @param unixTimeSeconds Unix time in seconds
   * @return this
   */
  public HSetExParams exAt(long unixTimeSeconds) {
    this.exAt = unixTimeSeconds;
    this.ex = null;
    this.px = null;
    this.pxAt = null;
    this.keepTtl = false;
    return this;
  }

  /**
   * Set the specified Unix time in milliseconds at which the fields will expire.
   * @param unixTimeMillis Unix time in milliseconds
   * @return this
   */
  public HSetExParams pxAt(long unixTimeMillis) {
    this.pxAt = unixTimeMillis;
    this.ex = null;
    this.px = null;
    this.exAt = null;
    this.keepTtl = false;
    return this;
  }

  /**
   * Retain the TTL associated with the fields.
   * @return this
   */
  public HSetExParams keepTtl() {
    this.keepTtl = true;
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
    if (fnx) {
      args.add(Keyword.FNX);
    }
    if (fxx) {
      args.add(Keyword.FXX);
    }
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
    if (keepTtl) {
      args.add(Keyword.KEEPTTL);
    }
  }

  /**
   * Create a new HSetExParams instance.
   * @return new HSetExParams instance
   */
  public static HSetExParams hSetExParams() {
    return new HSetExParams();
  }

  // Getters for testing purposes
  public boolean isFnx() {
    return fnx;
  }

  public boolean isFxx() {
    return fxx;
  }

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

  public boolean isKeepTtl() {
    return keepTtl;
  }
}
