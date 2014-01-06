package com.guidewire.tools.chronos.client;

public interface ServerResponse {
  int statusCode();
  int statusCodeRangeStart();
  int statusCodeRangeEnd();
  boolean success();
  boolean validationAllowed();

  int getStatusCode();
  int getStatusCodeRangeStart();
  int getStatusCodeRangeEnd();
  boolean isSuccess();
  boolean isValidationAllowed();
}