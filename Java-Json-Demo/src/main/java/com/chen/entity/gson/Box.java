package com.chen.entity.gson;

import com.google.gson.annotations.SerializedName;

public class Box {

  @SerializedName("w")
  private int width;

  @SerializedName("h")
  private int height;

  @SerializedName("d")
  private int depth;

  // Methods removed for brevity
}