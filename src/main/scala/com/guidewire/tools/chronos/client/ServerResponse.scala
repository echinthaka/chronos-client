package com.guidewire.tools.chronos.client

/**
 * @author - Eran Withana (ewithana@comprehend.com) 
 */
trait ServerResponse {
  def statusCode: Int
  def statusCodeRangeStart: Int
  def statusCodeRangeEnd: Int
  def success: Boolean
  def validationAllowed: Boolean

  def getStatusCode: Int
  def getStatusCodeRangeStart: Int
  def getStatusCodeRangeEnd: Int
  def isSuccess: Boolean
  def isValidationAllowed: Boolean
}